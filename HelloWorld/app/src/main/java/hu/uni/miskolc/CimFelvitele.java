package hu.uni.miskolc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.io.Serializable;

public class CimFelvitele extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cim_felvitele);
        ImageButton kuldes = findViewById(R.id.kuldes);
        EditText nev = findViewById(R.id.name);
        EditText iranyitoszam = findViewById(R.id.iranyitoszam);
        EditText varos = findViewById(R.id.varos);
        EditText utca = findViewById(R.id.utca);
        EditText hazszam = findViewById(R.id.hazszam);
        nev.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (nev.getText().toString().trim().isEmpty()) {
                    kuldes.setEnabled(false);
                } else {
                    kuldes.setEnabled(true);
                }
            }
        });

        kuldes.setOnClickListener(view -> {
            LinearLayout viewGroup = findViewById(R.id.adatok);
            if (checkFields(viewGroup)) {
                Intent intent = new Intent(this, MentettCim.class);
                String nevErtek = nev.getText().toString();
                Cim cim = new Cim();
                cim.iranyitoszam = iranyitoszam.getText().toString();
                cim.varos = varos.getText().toString();
                cim.utca = utca.getText().toString();
                cim.hazszam = hazszam.getText().toString();
                intent.putExtra("nev", nevErtek);
                intent.putExtra("cim", cim);
                startActivity(intent);
            }
        });
    }


    public boolean checkFields(ViewGroup viewGroup) {
        boolean result = true;
        int count = viewGroup.getChildCount();
        for (int i = 0; i < count; i++) {
            View view = viewGroup.getChildAt(i);
            if (view instanceof ViewGroup) {
                checkFields((ViewGroup) view);
            } else if (view instanceof EditText) {
                EditText edittext = (EditText) view;
                if (edittext.getText().toString().trim().isEmpty()) {
                    result = false;
                    edittext.setError("Kötelező megadni");
                }
            }
        }
        return result;
    }
}