package hu.uni.miskolc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MentettCim extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentett_cim);
        Intent intent = getIntent();
        String nev = intent.getStringExtra("nev");
        Cim cim= (Cim) intent.getSerializableExtra("cim");
        TextView nevMezo = findViewById(R.id.nevkiir);
        TextView cimMezo = findViewById(R.id.cimkiir);
        nevMezo.setText(nev);
        cimMezo.setText(cim.toString());

    }
}