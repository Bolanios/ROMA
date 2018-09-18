package com.watermelon.omarb.roma.View;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Calendar;
import java.util.Map;

import com.watermelon.omarb.roma.MainActivity;
import com.watermelon.omarb.roma.R;

public class MenuPrincipalActivity extends AppCompatActivity {

    SharedPreferences prefsEstado,prefsDatosGenerales;

    ImageView imageView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

         prefsEstado = getSharedPreferences("EstadosROMA", MODE_PRIVATE);
        prefsDatosGenerales = getSharedPreferences("DatosGeneralesForm", MODE_PRIVATE);
        //Log.e("MENU", toString().valueOf(prefsEstado.getBoolean("DatosGeneralesForm",false)));
        checarEstado();


        // Crear toolbar
        showToolbar(getResources().getString(R.string.toolbar_tittle_menuprincipal),false);
    }

    private void checarEstado() {
        if(prefsEstado.getBoolean("DatosGeneralesForm",false)){
            imageView= findViewById(R.id.imageView);
            imageView.setImageResource(R.drawable.iconodatos2);
            button =findViewById(R.id.button);
            button.setVisibility(View.VISIBLE);
        }
        if(prefsEstado.getBoolean("Consulta",false)){
            imageView= findViewById(R.id.imageView2);
            imageView.setImageResource(R.drawable.iconoconsulta2);
        }
        if(prefsEstado.getBoolean("ExploracionForm",false)){
            imageView= findViewById(R.id.imageView3);
            imageView.setImageResource(R.drawable.iconoexploracion2);
        }
        if(prefsEstado.getBoolean("DiagTraFrom",false)){
            imageView= findViewById(R.id.imageView4);
            imageView.setImageResource(R.drawable.iconotratamiento2);
        }

    }


    public void showToolbar(String tittle, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_base, menu);
        return false;
    }

    public void goDatosGenerales(View view) {
        Intent intent = new Intent(this, DatosGeneralesActivity.class);
        startActivity(intent);
    }

    public void goConsulta(View view) {
        Intent intent = new Intent(this, ConsultaActivity.class);
        startActivity(intent);
    }
    public void goExploracion(View view) {
        Intent intent = new Intent(this, ExploracionActivity.class);
        startActivity(intent);
    }
    public void goDiagTra(View view) {
        Intent intent = new Intent(this, DiagTraActivity.class);
        startActivity(intent);
    }

    public void onGuardar(View view) {


        Calendar calander = Calendar.getInstance();
        int  cHour = calander.get(Calendar.HOUR);
        int cMinute = calander.get(Calendar.MINUTE);
        int cSecond = calander.get(Calendar.SECOND);
        final SharedPreferences.Editor editor = prefsDatosGenerales.edit();
        editor.putString("hora_fin", cHour+":"+cMinute+":"+cSecond);
        editor.apply();
        try{
            json();
        } catch (Exception e) {
            e.printStackTrace();
        }
        prefsEstado.edit().clear().apply();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void json() throws JSONException {
        SharedPreferences prefer;
        JSONObject object = new JSONObject(); //Creamos un objeto JSON a partir de la cadena
        JSONObject object1;
        Map<String, ?> nameFormularios = prefsEstado.getAll();
        for (Map.Entry<String, ?> formulario : nameFormularios.entrySet()) {
            if (formulario.getKey().equals("Dolor")){
                continue;
            }
            if (formulario.getKey().equals("Consulta")){
                continue;
            }
            object1 = new JSONObject();
            prefer= getSharedPreferences(formulario.getKey(), MODE_PRIVATE);
            Map<String, ?> allForm = prefer.getAll();

            if(formulario.getKey().equals("DatosGeneralesForm")){
                for (Map.Entry<String, ?> inputs : allForm.entrySet()) {
                        object.put(inputs.getKey(),inputs.getValue());
                }
                continue;
            }else{
                for (Map.Entry<String, ?> inputs : allForm.entrySet()) {
                    object1.put(inputs.getKey(),inputs.getValue());
                }
            }
            object.put(formulario.getKey(),object1);
        }
        crearJsonFile(object);
    }

    public void crearJsonFile(org.json.JSONObject jsonO){
        String filename = "JSONFileMOBA";
        JSONArray addJSON=new JSONArray();
        FileOutputStream outputStream;
        File file = new File(MenuPrincipalActivity.this.getFilesDir(), filename);
        String texto="";

        try {
            if(!file.exists()){
                file.createNewFile();
                addJSON.put(jsonO);
                texto= addJSON.toString();
                Log.e("CREADO",texto);
            }else {
                //Read text from file
                StringBuilder text = new StringBuilder();
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;

                while ((line = br.readLine()) != null) {
                    text.append(line);
                    text.append('\n');
                }
                br.close();
                Log.e("LEIO", text.toString());
                addJSON = new JSONArray(text.toString());
                addJSON.put(jsonO);
                texto=addJSON.toString();
            }
            outputStream = openFileOutput(filename, android.content.Context.MODE_PRIVATE);
            outputStream.write(texto.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //editText.setText(texto);
    }

}


