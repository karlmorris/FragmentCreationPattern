package edu.temple.myfragmentapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ColorFragment.ButtonClickedInterface {

    ColorFragment fragments[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragments = new ColorFragment[4];

        fragments[0] = ColorFragment.newInstance(0);
        fragments[1] = ColorFragment.newInstance(1);
        fragments[2] = ColorFragment.newInstance(2);
        fragments[3] = ColorFragment.newInstance(3);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container1, fragments[0])
                .add(R.id.container2, fragments[1])
                .add(R.id.container3, fragments[2])
                .add(R.id.container4, fragments[3])
                .commit();

    }

    public void buttonClicked(int id) {

        for (ColorFragment fragment : fragments) {
            if (fragment.getFragmentId() != id)
                fragment.changeColor();
        }
    }

}
