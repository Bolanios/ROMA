package com.watermelon.omarb.roma.View;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.watermelon.omarb.roma.ListDialog;
import com.watermelon.omarb.roma.R;
import com.watermelon.omarb.roma.Sounds;

public class ObesidadActivity extends AppCompatActivity {
    EditText editTextFamiliares,editTextUsted,editTextAlimentacion,editTextNivel,
            editTextCuando,editTextTratamiento,editTextTipoDiag,editTextNotas;
    ImageView imageViewFamiliares,imageViewUsted,imageViewAlimentacion,imageViewNivel,imageViewCuando,imageViewTratamiento,imageViewTipoDiag;
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
        setContentView(R.layout.activity_obesidad);
        prefsEstados= getSharedPreferences("EstadosROMA", MODE_PRIVATE);
        prefsDatos= getSharedPreferences("ObesidadForm", MODE_PRIVATE);

        final Intent intent = new Intent(this, ListDialog.class);
        sounds=new Sounds();

        editTextFamiliares =findViewById(R.id.input_obesidad_familiares);
        editTextUsted =findViewById(R.id.input_obesidad_usted);
        editTextAlimentacion =findViewById(R.id.input_obesidad_alimentos);
        editTextNivel = findViewById(R.id.input_obesidad_nivel);
        editTextCuando = findViewById(R.id.input_obesidad_desde);
        editTextTratamiento = findViewById(R.id.input_obesidad_tratamiento);
        editTextTipoDiag = findViewById(R.id.input_obesidad_tipo_diagnostico);
        editTextNotas = findViewById(R.id.notas);
        imageViewFamiliares =findViewById(R.id.sound_obesidad_familiares);
        imageViewUsted =findViewById(R.id.sound_obesidad_usted);
        imageViewAlimentacion =findViewById(R.id.sound_obesidad_alimentos);
        imageViewNivel = findViewById(R.id.sound_obesidad_nivel);
        imageViewCuando = findViewById(R.id.sound_obesidad_desde);
        imageViewTratamiento = findViewById(R.id.sound_obesidad_tratamiento);
        imageViewTipoDiag = findViewById(R.id.sound_obesidad_tipo_diagnostico);
        imageViewFamiliares.setTag(getResources().getResourceEntryName(R.string.obesidad_preg_fam));
        imageViewUsted.setTag(getResources().getResourceEntryName(R.string.obesidad_preg_diag));
        imageViewAlimentacion.setTag(getResources().getResourceEntryName(R.string.obesidad_preg_alimentacion));
        imageViewNivel.setTag(getResources().getResourceEntryName(R.string.obesidad_preg_nivel_obesidad));
        imageViewCuando.setTag(getResources().getResourceEntryName(R.string.preg_g1_desde));
        imageViewTratamiento.setTag(getResources().getResourceEntryName(R.string.obesidad_preg_tratamiento));
        imageViewTipoDiag.setTag(getResources().getResourceEntryName(R.string.obesidad_preg_diagnostico_2));


        checarEstado();
        editTextFamiliares.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("arrayNames", getResources().getResourceEntryName(R.array.resp_si_no));
                Log.e("arrayFlags", getResources().getResourceEntryName(R.array.icon2));
                Log.e("title", getResources().getString(R.string.obesidad_preg_fam));
                Log.e("refer",  getResources().getResourceEntryName(R.array.resp_si_no));
                intent.putExtra("arrayNames",   getResources().getResourceEntryName(R.array.resp_si_no));
                intent.putExtra("arrayFlags",   getResources().getResourceEntryName(R.array.icon2));
                intent.putExtra("title",        getResources().getString(R.string.obesidad_preg_fam));
                intent.putExtra("refer",        getResources().getResourceEntryName(R.array.resp_si_no));
                startActivityForResult(intent,1);
            }
        });

        editTextUsted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.e("arrayNames", getResources().getResourceEntryName(R.array.resp_si_no));
                Log.e("arrayFlags", getResources().getResourceEntryName(R.array.icon2));
                Log.e("title", getResources().getString(R.string.obesidad_preg_diag));
                Log.e("refer",  getResources().getResourceEntryName(R.array.resp_si_no));
                intent.putExtra("arrayNames",   getResources().getResourceEntryName(R.array.resp_si_no));
                intent.putExtra("arrayFlags",   getResources().getResourceEntryName(R.array.icon2));
                intent.putExtra("title",        getResources().getString(R.string.obesidad_preg_diag));
                intent.putExtra("refer",        getResources().getResourceEntryName(R.array.resp_si_no));

                startActivityForResult(intent,2);
            }
        });


        editTextAlimentacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.e("arrayNames", getResources().getResourceEntryName(R.array.hipertension_resp_alimentacion));
                Log.e("arrayFlags", getResources().getResourceEntryName(R.array.icon3));
                Log.e("title", getResources().getString(R.string.obesidad_preg_alimentacion));
                Log.e("refer",  getResources().getResourceEntryName(R.array.hipertension_resp_alimentacion));

                intent.putExtra("arrayNames",   getResources().getResourceEntryName(R.array.hipertension_resp_alimentacion));
                intent.putExtra("arrayFlags",   getResources().getResourceEntryName(R.array.icon3));
                intent.putExtra("title",        getResources().getString(R.string.obesidad_preg_alimentacion));
                intent.putExtra("refer",        getResources().getResourceEntryName(R.array.hipertension_resp_alimentacion));

                startActivityForResult(intent,3);
            }
        });
        editTextNivel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.e("arrayNames", getResources().getResourceEntryName(R.array.obesidad_resp_nivel));
                Log.e("arrayFlags", getResources().getResourceEntryName(R.array.icon3));
                Log.e("title", getResources().getString(R.string.obesidad_preg_nivel_obesidad));
                Log.e("refer",  getResources().getResourceEntryName(R.array.obesidad_resp_nivel));

                intent.putExtra("arrayNames",   getResources().getResourceEntryName(R.array.obesidad_resp_nivel));
                intent.putExtra("arrayFlags",   getResources().getResourceEntryName(R.array.icon3));
                intent.putExtra("title",        getResources().getString(R.string.obesidad_preg_nivel_obesidad));
                intent.putExtra("refer",        getResources().getResourceEntryName(R.array.obesidad_resp_nivel));

                startActivityForResult(intent,4);
            }
        });
        editTextTipoDiag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.e("arrayNames", getResources().getResourceEntryName(R.array.obesidad_resp_diagnostico_2));
                Log.e("arrayFlags", getResources().getResourceEntryName(R.array.icon4));
                Log.e("title", getResources().getString(R.string.obesidad_preg_diagnostico_2));
                Log.e("refer",  getResources().getResourceEntryName(R.array.obesidad_resp_diagnostico_2));

                intent.putExtra("arrayNames",   getResources().getResourceEntryName(R.array.obesidad_resp_diagnostico_2));
                intent.putExtra("arrayFlags",   getResources().getResourceEntryName(R.array.icon4));
                intent.putExtra("title",        getResources().getString(R.string.obesidad_preg_diagnostico_2));
                intent.putExtra("refer",        getResources().getResourceEntryName(R.array.obesidad_resp_diagnostico_2));

                startActivityForResult(intent,5);
            }
        });
        editTextCuando.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog  mdiDialog =new DatePickerDialog(ObesidadActivity.this,new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        editTextCuando.setText(dayOfMonth+"/"+monthOfYear+"/"+year);
                    }
                }, 2000, 0, 1);
                mdiDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {
                        editTextCuando.setText("");
                    }
                });
                mdiDialog.show();
            }
        });


        editTextTratamiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // Crear toolbar
        showToolbar(getResources().getString(R.string.obesidad),true);        //Getting the instance of Spinner and applying OnItemSelectedListener on it
    }


    public void onGuardar(View view) {
        final SharedPreferences.Editor editorLocal = prefsDatos.edit();
        final SharedPreferences.Editor editorEstados = prefsEstados.edit();
        editorLocal.putString("familiares", editTextFamiliares.getText().toString());
        editorLocal.putString("usted",editTextUsted.getText().toString());
        editorLocal.putString("cuando", editTextCuando.getText().toString());
        editorLocal.putString("diagnostico", editTextTipoDiag.getText().toString());
        editorLocal.putString("tratamiento", editTextTratamiento.getText().toString());
        editorLocal.putString("alimentacion", editTextAlimentacion.getText().toString());
        editorLocal.putString("nivel", editTextNivel.getText().toString());
        editorLocal.putString("notas", editTextNotas.getText().toString());
        editorLocal.apply();

        editorEstados.putBoolean("ObesidadForm",true);
        editorEstados.putBoolean("Consulta",true);
        editorEstados.apply();

        Intent intent = new Intent(this, ConsultaActivity.class);
        startActivity(intent);
    }

    private void checarEstado() {
        if(prefsEstados.getBoolean("ObesidadForm",false)){
            editTextFamiliares.setText(prefsDatos.getString("familiares",""));
            editTextUsted.setText(prefsDatos.getString("usted",""));
            editTextCuando.setText(prefsDatos.getString("cuando",""));
            editTextTipoDiag.setText(prefsDatos.getString("diagnostico",""));
            editTextTratamiento.setText(prefsDatos.getString("tratamiento",""));
            editTextAlimentacion.setText(prefsDatos.getString("alimentacion",""));
            editTextNivel.setText(prefsDatos.getString("nivel",""));
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
                editTextFamiliares.setText(String.valueOf(ListDialog.getStringSelectList()));
            }
        }

        if (requestCode == 2) {
            if(resultCode == Activity.RESULT_OK){
                String result=data.getStringExtra("result");
                Log.e("resultOK","RESPUESTA");
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                Log.e("resultCANCELED",String.valueOf(ListDialog.getArraySelectList()) );
                editTextUsted.setText(String.valueOf(ListDialog.getStringSelectList()));
            }
        }
        if (requestCode == 3) {
            if(resultCode == Activity.RESULT_OK){
                String result=data.getStringExtra("result");
                Log.e("resultOK","RESPUESTA");
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                Log.e("resultCANCELED",String.valueOf(ListDialog.getArraySelectList()) );
                editTextAlimentacion.setText(String.valueOf(ListDialog.getStringSelectList()));
            }
        }
        if (requestCode == 4) {
            if(resultCode == Activity.RESULT_OK){
                String result=data.getStringExtra("result");
                Log.e("resultOK","RESPUESTA");
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                Log.e("resultCANCELED",String.valueOf(ListDialog.getArraySelectList()) );
                editTextNivel.setText(String.valueOf(ListDialog.getStringSelectList()));
            }
        }
        if (requestCode == 5) {
            if(resultCode == Activity.RESULT_OK){
                String result=data.getStringExtra("result");
                Log.e("resultOK","RESPUESTA");
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                Log.e("resultCANCELED",String.valueOf(ListDialog.getArraySelectList()) );
                editTextTipoDiag.setText(String.valueOf(ListDialog.getStringSelectList()));
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
