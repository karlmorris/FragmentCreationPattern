package edu.temple.myfragmentapplication;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class ColorFragment extends Fragment {


    private static final String ID_KEY = "id";

    View layout;

    int id = -1;

    ButtonClickedInterface parentActivity;

    public ColorFragment() {}


    public static ColorFragment newInstance (int id) {
        ColorFragment fragment = new ColorFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ID_KEY, id);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();

        if (bundle != null) {
            id = bundle.getInt("id");
        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof ButtonClickedInterface) {
            parentActivity = (ButtonClickedInterface) context;
        } else {
            throw new RuntimeException("Please Implement the ButtonClickedListener Interface!!!!!!!");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_color, container, false);

        Button changeColorButton = layout.findViewById(R.id.changeColorButton);

        changeColorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (id >= 0)
                    parentActivity.buttonClicked(id);
            }
        });

        changeColor();

        return layout;
    }

    public void changeColor() {
        int colors[] = {Color.RED, Color.BLUE, Color.GREEN, Color.GRAY, Color.MAGENTA, Color.CYAN};

        int colorIndex = (new Random()).nextInt(colors.length);
        if (layout != null)
            layout.setBackgroundColor(colors[colorIndex]);
    }

    interface ButtonClickedInterface {
        public void buttonClicked(int id);
    }

    public int getFragmentId() {
        return id;
    }

}
