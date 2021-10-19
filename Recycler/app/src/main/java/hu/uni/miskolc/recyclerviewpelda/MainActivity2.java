package hu.uni.miskolc.recyclerviewpelda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import hu.uni.miskolc.recyclerviewpelda.ui.dolgozo.DolgozoFragment;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, DolgozoFragment.newInstance())
                    .commitNow();
        }
    }
}