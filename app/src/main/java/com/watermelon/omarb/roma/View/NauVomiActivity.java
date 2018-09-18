package com.watermelon.omarb.roma.View;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.watermelon.omarb.roma.ListDialog;
import com.watermelon.omarb.roma.R;
import com.watermelon.omarb.roma.Sounds;

public class NauVomiActivity extends AppCompatActivity {
    EditText editTextDesde,editTextHorario,editTextSintomas,editTextHabitos,editTextNotas;
    ImageView imageViewDesde,imageViewHorario,imageViewSintomas,imageViewHabitos;
    Sounds sounds;
    TextView title;
    SharedPreferences prefsEstados,prefsDatos;

    AudioAttributes audioAttributes = new AudioAttributes.Builder()
            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
            .setUsage(AudioAttributes.USAGE_MEDIA)
            .build();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nau_vomi);
        prefsEstados= getSharedPreferences("EstadosROMA", MODE_PRIVATE);
        prefsDatos= getSharedPreferences("NauVomiForm", MODE_PRIVATE);

        final Intent intent = new Intent(this, ListDialog.class);
        sounds=new Sounds();

        editTextDesde =findViewById(R.id.input_nauvomi_desde);
        editTextHorario =findViewById(R.id.input_nauvomi_horario);
        editTextSintomas =findViewById(R.id.input_nauvomi_sintomas);
        editTextHabitos = findViewById(R.id.input_nauvomi_habitos);
        editTextNotas   = findViewById(R.id.notas);
        imageViewDesde =findViewById(R.id.sound_nauvomi_desde);
        imageViewHorario =findViewById(R.id.sound_nauvomi_horario);
        imageViewSintomas =findViewById(R.id.sound_nauvomi_sintomas);
        imageViewHabitos =findViewById(R.id.sound_nauvomi_habitos);
        imageViewDesde.setTag(getResources().getResourceEntryName(R.string.preg_g1_desde));
        imageViewHorario.setTag(getResources().getResourceEntryName(R.string.preg_g2_horario));
        imageViewSintomas.setTag(getResources().getResourceEntryName(R.string.preg_g3_sintomas));
        imageViewHabitos.setTag(getResources().getResourceEntryName(R.string.preg_habitos_nau));

        checarEstado();
        editTextDesde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.e("arrayNames", getResources().getResourceEntryName(R.array.resp_preg_g1_desde));
                Log.e("arrayFlags", getResources().getResourceEntryName(R.array.icon3));
                Log.e("title", getResources().getString(R.string.preg_g1_desde));
                Log.e("refer",  getResources().getResourceEntryName(R.array.resp_preg_g1_desde));


                intent.putExtra("arrayNames",   getResources().getResourceEntryName(R.array.resp_preg_g1_desde));
                intent.putExtra("arrayFlags",   getResources().getResourceEntryName(R.array.icon3));
                intent.putExtra("title",        getResources().getString(R.string.preg_g1_desde));
                intent.putExtra("refer",        getResources().getResourceEntryName(R.array.resp_preg_g1_desde));

                startActivityForResult(intent,1);
            }
        });

        editTextHorario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.e("arrayNames", getResources().getResourceEntryName(R.array.resp_preg_g2_horario));
                Log.e("arrayFlags", getResources().getResourceEntryName(R.array.icon3));
                Log.e("title", getResources().getString(R.string.preg_g2_horario));
                Log.e("refer",  getResources().getResourceEntryName(R.array.resp_preg_g2_horario));


                intent.putExtra("arrayNames",   getResources().getResourceEntryName(R.array.resp_preg_g2_horario));
                intent.putExtra("arrayFlags",   getResources().getResourceEntryName(R.array.icon3));
                intent.putExtra("title",        getResources().getString(R.string.preg_g2_horario));
                intent.putExtra("refer",        getResources().getResourceEntryName(R.array.resp_preg_g2_horario));

                startActivityForResult(intent,2);
            }
        });


        editTextSintomas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.e("arrayNames", getResources().getResourceEntryName(R.array.nauseas_resp_sintomas));
                Log.e("arrayFlags", getResources().getResourceEntryName(R.array.icon4));
                Log.e("title", getResources().getString(R.string.preg_g3_sintomas));
                Log.e("refer",  getResources().getResourceEntryName(R.array.nauseas_resp_sintomas));


                intent.putExtra("arrayNames",   getResources().getResourceEntryName(R.array.nauseas_resp_sintomas));
                intent.putExtra("arrayFlags",   getResources().getResourceEntryName(R.array.icon4));
                intent.putExtra("title",        getResources().getString(R.string.preg_g3_sintomas));
                intent.putExtra("refer",        getResources().getResourceEntryName(R.array.nauseas_resp_sintomas));

                startActivityForResult(intent,3);
            }
        });


        editTextHabitos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.e("arrayNames", getResources().getResourceEntryName(R.array.nauseas_resp_habitos));
                Log.e("arrayFlags", getResources().getResourceEntryName(R.array.icon2));
                Log.e("title", getResources().getString(R.string.preg_habitos_nau));
                Log.e("refer",  getResources().getResourceEntryName(R.array.nauseas_resp_habitos));


                intent.putExtra("arrayNames",   getResources().getResourceEntryName(R.array.nauseas_resp_habitos));
                intent.putExtra("arrayFlags",   getResources().getResourceEntryName(R.array.icon2));
                intent.putExtra("title",        getResources().getString(R.string.preg_habitos_nau));
                intent.putExtra("refer",        getResources().getResourceEntryName(R.array.nauseas_resp_habitos));

                startActivityForResult(intent,4);
            }
        });

        // Crear toolbar
        showToolbar(getResources().getString(R.string.nau_vom),true);        //Getting the instance of Spinner and applying OnItemSelectedListener on it
    }


    public void onGuardar(View view) {
        final SharedPreferences.Editor editorLocal = prefsDatos.edit();
        final SharedPreferences.Editor editorEstados = prefsEstados.edit();
        editorLocal.putString("desde", editTextDesde.getText().toString());
        editorLocal.putString("horario",editTextHorario.getText().toString());
        editorLocal.putString("sintomas", editTextSintomas.getText().toString());
        editorLocal.putString("habitos", editTextHabitos.getText().toString());
        editorLocal.putString("notas", editTextNotas.getText().toString());
        editorLocal.apply();

        editorEstados.putBoolean("NauVomiForm",true);
        editorEstados.putBoolean("Consulta",true);
        editorEstados.apply();

        Intent intent = new Intent(this, ConsultaActivity.class);
        startActivity(intent);
    }

    private void checarEstado() {
        if(prefsEstados.getBoolean("NauVomiForm",false)){
            editTextDesde.setText(prefsDatos.getString("desde",""));
            editTextHorario.setText(prefsDatos.getString("horario",""));
            editTextSintomas.setText(prefsDatos.getString("sintomas",""));
            editTextHabitos.setText(prefsDatos.getString("habitos",""));
            editTextNotas.setText(prefsDatos.getString("notas",""));
        }

    }
    public void showToolbar(String tittle, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                String result=data.getStringExtra("result");
                Log.e("resultOK","RESPUESTA");
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                Log.e("resultCANCELED",String.valueOf(ListDialog.getArraySelectList()) );
                editTextDesde.setText(String.valueOf(ListDialog.getStringSelectList()));
            }
        }

        if (requestCode == 2) {
            if(resultCode == Activity.RESULT_OK){
                String result=data.getStringExtra("result");
                Log.e("resultOK","RESPUESTA");
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                Log.e("resultCANCELED",String.valueOf(ListDialog.getArraySelectList()) );
                editTextHorario.setText(String.valueOf(ListDialog.getStringSelectList()));
            }
        }
        if (requestCode == 3) {
            if(resultCode == Activity.RESULT_OK){
                String result=data.getStringExtra("result");
                Log.e("resultOK","RESPUESTA");
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                Log.e("resultCANCELED",String.valueOf(ListDialog.getArraySelectList()) );
                editTextSintomas.setText(String.valueOf(ListDialog.getStringSelectList()));
            }
        }

        if (requestCode == 4) {
            if(resultCode == Activity.RESULT_OK){
                String result=data.getStringExtra("result");
                Log.e("resultOK","RESPUESTA");
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                Log.e("resultCANCELED",String.valueOf(ListDialog.getArraySelectList()) );
                editTextHabitos.setText(String.valueOf(ListDialog.getStringSelectList()));
            }
        }

    }//onActivityResult


    public void sound(View view) {
        final SoundPool ourSounds;

        ourSounds = new SoundPool.Builder()
                .setMaxStreams(5)
                .setAudioAttributes(audioAttributes)
                .build();
        //Then wait for the onLoadComplete event
        ourSounds.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener()
        {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status)
            {
                // May be you want to add log here to see the IDs of the items loaded
                soundPool.play(sampleId,1,1,1,0,1);
                Log.e("sound","reproduciendo soundpool");
            }
        });

        Integer sound=null;

        String text =sounds.getStringByLocal(this,(String) view.getTag(),"aa");

        sound= sounds.getSound((String) view.getTag());
        if(sound!=null){
            ourSounds.load(this, sound, 1);
        }else{
            Toast.makeText(getApplicationContext(), text+"- NO AUDIO" , Toast.LENGTH_SHORT).show();
        }
//

        //
        //MediaPlayer media=null;
        //Integer sound=null;
        //Toast.makeText(getApplicationContext(), (String) view.getTag() , Toast.LENGTH_SHORT).show();
        //if(sound!=null){
        //media = MediaPlayer.create(getApplicationContext(),sound);
        //}else{
        //Toast.makeText(getApplicationContext(), "Lo sentimos aun no se tiene este audio" , Toast.LENGTH_SHORT).show();
        //}
        //if (media != null) {
        //media.start();
        //}
        //

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_base, menu);
        return true;
    }

}
