package com.watermelon.omarb.roma.View;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import com.watermelon.omarb.roma.R;


public class DiagTraActivity extends AppCompatActivity {
    EditText editTextNotas;
    SharedPreferences prefsEstados,prefsDatos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diag_tra);

        editTextNotas= findViewById(R.id.diag_notas);
        prefsEstados= getSharedPreferences("EstadosROMA", MODE_PRIVATE);
        prefsDatos= getSharedPreferences("DiagTraFrom", MODE_PRIVATE);
        checarEstado();


        // Crear toolbar
        showToolbar(getResources().getString(R.string.menu_diag),true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_base, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void showToolbar(String tittle, boolean upButton){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);

    }

    public void onGuardar(View view) {
        final SharedPreferences.Editor editor = prefsDatos.edit();
        final SharedPreferences.Editor editor2 = prefsEstados.edit();
        editor.putString("notas", editTextNotas.getText().toString());
        editor.apply();

        editor2.putBoolean("DiagTraFrom",true);
        editor2.apply();

        Intent intent = new Intent(this, MenuPrincipalActivity.class);
        startActivity(intent);

    }


    private void checarEstado() {
        if(prefsEstados.getBoolean("DiagTraFrom",false)){
            editTextNotas.setText(prefsDatos.getString("notas",""));
        }

    }

}
