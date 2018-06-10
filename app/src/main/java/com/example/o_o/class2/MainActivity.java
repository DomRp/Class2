package com.example.o_o.class2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private AppCompatButton btnLogin;
    EditText etCorreo;
    EditText etClave;
    HashMap<String, person> data;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "OnCreate", Toast.LENGTH_SHORT).show();
        // La actividad está siendo creado

        etCorreo    =   findViewById(R.id.etCorreo);
        etClave     =   findViewById(R.id.etPass);
        btnLogin    =   findViewById(R.id.btnEnter);

        createDummyListOfPeople();

        btnLogin.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String correo = "";
                if (etCorreo != null) {
                    correo = etCorreo.getText().toString().toLowerCase();
                }
                person currentPerson = data.get(correo);

                if (currentPerson != null) {
                    Intent i = new Intent(MainActivity.this, ProfileActivity.class);
                    i.putExtra("PROFILE_DATA", currentPerson);
                    startActivity(i);
                } else {
                    showErrorDialog();
                    etCorreo.setText("");
                    etClave.setText("");
                }
            }
        });
    }
        private void showErrorDialog () {
        AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
            dlgAlert.setMessage(R.string.dialog_body_message);
            dlgAlert.setTitle(R.string.dialog_title_message);
            dlgAlert.setPositiveButton("OK", null);
            dlgAlert.setCancelable(true);
            dlgAlert.create().show();
        }

        private void createDummyListOfPeople () {
        person person = new person();
            person.setName("Leandro Leonardo");
            person.setEmail("leandroleonardo909@gmail.com");
            person.setAbout("I'm a Software Developer specialized on Android Development.");
            person.setProjects(100);
            person.setStars(300);
            person.setRepos(150);

            data = new HashMap<>();
            data.put("leandroleonardo909@gmail.com", person);
        }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "OnStart", Toast.LENGTH_SHORT).show();
        // La actividad está a punto de hacerse visible.
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "OnResume", Toast.LENGTH_SHORT).show();
        // La actividad se ha vuelto visible (ahora se "reanuda").
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "OnPause", Toast.LENGTH_SHORT).show();
        // Enfocarse en otra actividad  (esta actividad está a punto de ser "detenida").
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "OnStop", Toast.LENGTH_SHORT).show();
        // La actividad ya no es visible (ahora está "detenida")
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "OnDestroy", Toast.LENGTH_SHORT).show();
        // La actividad está a punto de ser destruida.
    }
}
