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


public class ExploracionActivity extends AppCompatActivity {
    EditText editTextNotas;
    SharedPreferences prefsEstados,prefsDatos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exploracion);

        editTextNotas= findViewById(R.id.notas_exploracion);
        prefsEstados= getSharedPreferences("EstadosROMA", MODE_PRIVATE);
        prefsDatos= getSharedPreferences("ExploracionForm", MODE_PRIVATE);
        checarEstado();


        // Crear toolbar
        showToolbar(getResources().getString(R.string.menu_exploracion),true);
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

        editor2.putBoolean("ExploracionForm",true);
        editor2.apply();

        Intent intent = new Intent(this, MenuPrincipalActivity.class);
        startActivity(intent);

    }


    private void checarEstado() {
        if(prefsEstados.getBoolean("ExploracionForm",false)){
            editTextNotas.setText(prefsDatos.getString("notas",""));
        }

    }

}
