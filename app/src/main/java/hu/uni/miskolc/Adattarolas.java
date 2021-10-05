package hu.uni.miskolc;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;

public class Adattarolas extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adattarolas);
        String hatterkepPath = "hatterkep.jpg";
        int permissionCheck = ContextCompat.checkSelfPermission(
                Adattarolas.this, Manifest.permission.READ_EXTERNAL_STORAGE);
        if (permissionCheck == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(Adattarolas.this, new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE}, 101);
        }
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        if (prefs.contains("nev")){

            Toast toast = Toast.makeText(Adattarolas.this, "Üdvözöllek "+prefs.getString("nev", ""), Toast.LENGTH_LONG);
            View view= toast.getView();
            view.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));
            toast.show();
        }
        Button kameragomb = findViewById(R.id.kameragomb);
        ActivityResultLauncher<Intent> launchKamera = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        if (result.getData().getType() != null) {
                            Intent data = result.getData();
                            Bitmap img = (Bitmap) data.getExtras().get("data");
                            findViewById(R.id.dblayout).setBackground(new BitmapDrawable(getResources(), img));
                        } else {
                            File file = new File(Environment.getExternalStorageDirectory(), hatterkepPath);
                            Bitmap img = BitmapFactory.decodeFile(file.getPath());
                            findViewById(R.id.dblayout).setBackground(new BitmapDrawable(getResources(), img));
                            File naplofajt = new File(getFilesDir(), "hatterkepnaplo.txt");

                            try {
                                FileWriter fw  = new FileWriter(naplofajt, true);
                                BufferedWriter bw = new BufferedWriter(fw);
                                Timestamp now = new Timestamp(System.currentTimeMillis());
                                bw.append("Uj hatterkep keszult: "+now +"\n");
                                bw.flush();
                                bw.close();

                                FileReader fr = new FileReader(naplofajt);
                                BufferedReader br = new BufferedReader(fr);
                                int db = 0;
                                while ((br.readLine()) != null){
                                    db++;
                                }
                                System.out.println("Eddig "+db+" alkalommal lett " +
                                        "megváltoztatva a háttérkép");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                }
        );



        kameragomb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File file = new File(Environment.getExternalStorageDirectory(), hatterkepPath);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                launchKamera.launch(intent);
            }
        });

        EditText firstname = findViewById(R.id.firstname);
        firstname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().trim().isEmpty()){
                    Toast.makeText(Adattarolas.this, "Kérlek add meg a neved", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Adattarolas.this, "Mostantól így szólítalak majd", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("nev", editable.toString());
                    editor.apply();
                }
            }
        });
    }
}