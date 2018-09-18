package com.watermelon.omarb.roma.View;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.watermelon.omarb.roma.BetterSpinner;
import com.watermelon.omarb.roma.R;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Locale;


public class DatosGeneralesActivity extends AppCompatActivity {

    EditText editTextName, editTextOcupacion,editTextEdad,
            editTextSexo,editTextPeso,editTextTalla,editTextAlergias;

    SharedPreferences prefsEstados,prefsDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_generales);

        prefsEstados= getSharedPreferences("EstadosROMA", MODE_PRIVATE);
        prefsDatos= getSharedPreferences("DatosGeneralesForm", MODE_PRIVATE);

        editTextName= findViewById(R.id.input_name);
        editTextOcupacion= findViewById(R.id.input_ocupacion);
        editTextEdad= findViewById(R.id.age);
        editTextSexo= findViewById(R.id.sex);
        editTextPeso= findViewById(R.id.peso);
        editTextTalla= findViewById(R.id.talla);
        editTextAlergias= findViewById(R.id.alergias);

        checarEstado();
        BetterSpinner betterSpinner= new BetterSpinner(this);
        betterSpinner.CrearList(getResources().getStringArray(R.array.sexo), findViewById(R.id.sex));


        // Crear toolbar
        showToolbar(getResources().getString(R.string.toolbar_tittle_datos),true);
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

        Calendar calander = Calendar.getInstance();
        int cDay = calander.get(Calendar.DAY_OF_MONTH);
        int cMonth = calander.get(Calendar.MONTH) + 1;
        int cYear = calander.get(Calendar.YEAR);
        String selectedMonth = "" + cMonth;
        String selectedYear = "" + cYear;
        int  cHour = calander.get(Calendar.HOUR);
        int cMinute = calander.get(Calendar.MINUTE);
        int cSecond = calander.get(Calendar.SECOND);
        
        
        
        
        final SharedPreferences.Editor editor = prefsDatos.edit();
        final SharedPreferences.Editor editor2 = prefsEstados.edit();

        editor.putString("_id", editTextName.getText().toString()+""+
                cDay+""+cMonth+""+cYear+""+cHour+""+cMinute+""+cSecond);
        editor.putString("fecha", cDay+"/"+cMonth+"/"+cYear);
        editor.putString("hora_ini", cHour+":"+cMinute+":"+cSecond);
        editor.putString("nombre", editTextName.getText().toString());
        editor.putString("ocupacion", editTextOcupacion.getText().toString());
        editor.putString("edad", editTextEdad.getText().toString());
        editor.putString("sexo", editTextSexo.getText().toString());
        editor.putString("peso", editTextPeso.getText().toString());
        editor.putString("talla", editTextTalla.getText().toString());
        editor.putString("alergias", editTextAlergias.getText().toString());
        editor.apply();

        editor2.putBoolean("DatosGeneralesForm",true);
        editor2.apply();

        Intent intent = new Intent(this, MenuPrincipalActivity.class);
        startActivity(intent);

    }


    private void checarEstado() {
        if(prefsEstados.getBoolean("DatosGeneralesForm",false)){

           editTextName.setText(prefsDatos.getString("nombre",""));
           editTextOcupacion.setText(prefsDatos.getString("ocupacion",""));
           editTextEdad.setText(prefsDatos.getString("edad",""));
           editTextSexo.setText(prefsDatos.getString("sexo",""));
           editTextPeso.setText(prefsDatos.getString("peso",""));
           editTextTalla.setText(prefsDatos.getString("talla",""));
           editTextAlergias.setText(prefsDatos.getString("alergias",""));
        }

    }



    public void sound(View view) {
        String audio_id= (String) view.getContentDescription();
        MediaPlayer media = null;

        if (audio_id.equals(getResources().getString(R.string.hint_name))){
            Toast.makeText(this, getStringByLocal(this,R.string.hint_name,"aa")
                    , Toast.LENGTH_LONG).show();
            media= MediaPlayer.create(this,R.raw.datos_nombre);
        }else if (audio_id.equals(getResources().getString(R.string.hint_ocupacion))){
            Toast.makeText(this, getStringByLocal(this,R.string.hint_ocupacion,"aa")
                    , Toast.LENGTH_LONG).show();
            media= MediaPlayer.create(this,R.raw.datos_ocupacion);
        }else if (audio_id.equals(getResources().getString(R.string.hint_age))){
            Toast.makeText(this, getStringByLocal(this,R.string.hint_age,"aa")
                    , Toast.LENGTH_LONG).show();
            media= MediaPlayer.create(this,R.raw.datos_edad);
        }else if (audio_id.equals(getResources().getString(R.string.hint_alergias))){
            Toast.makeText(this, getStringByLocal(this,R.string.hint_alergias,"aa")
                    , Toast.LENGTH_LONG).show();
            media= MediaPlayer.create(this,R.raw.datos_alergia);
        }

        if (media != null) {
            media.start();
        }
        media.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            };
        });
    }

    public static String getStringByLocal(Context context, int id, String locale) {
        Configuration configuration = new Configuration(context.getResources().getConfiguration());
        configuration.setLocale(new Locale(locale));
        return context.createConfigurationContext(configuration).getResources().getString(id);
    }
}