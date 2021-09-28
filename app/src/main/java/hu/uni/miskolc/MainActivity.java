package hu.uni.miskolc;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.time.LocalDateTime;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.wtf(TAG, "Kiscica");
        Log.d("Cica","Nagycica");
   /*     Button ujcimGomb = findViewById(R.id.floatingActionButton);
        ujcimGomb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/
    }


    public void cimfelviteleActivityMegnyitas(View view){
        Intent intent = new Intent(MainActivity.this, CimFelvitele.class);
        startActivity(intent);
    }


}