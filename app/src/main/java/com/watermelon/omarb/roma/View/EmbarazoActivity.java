package com.watermelon.omarb.roma.View;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DialogFragment;
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
import android.widget.Toast;

import com.watermelon.omarb.roma.DatePickerFragment;
import com.watermelon.omarb.roma.ListDialog;
import com.watermelon.omarb.roma.R;
import com.watermelon.omarb.roma.Sounds;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class EmbarazoActivity extends AppCompatActivity {

    EditText editTextInicio,editTextUltima,editTextOtros,editTextCuantos,
            editTextComplicacion,editTextAcido,editTextSintomas,editTextNotas;
    ImageView imageViewInicio,imageViewUltima,imageViewOtros,imageViewCuantos,imageViewComplicacion,imageViewAcido,imageViewSintomas;
    Sounds sounds;
    SharedPreferences prefsEstados,prefsDatos;


    AudioAttributes audioAttributes = new AudioAttributes.Builder()
            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
            .setUsage(AudioAttributes.USAGE_MEDIA)
            .build();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_embarazo);

        prefsEstados= getSharedPreferences("EstadosROMA", MODE_PRIVATE);
        prefsDatos= getSharedPreferences("EmbarazoForm", MODE_PRIVATE);
        final Intent intent = new Intent(this, ListDialog.class);
        sounds = new Sounds();

        editTextInicio = findViewById(R.id.input_inicio_vida);
        editTextUltima = findViewById(R.id.input_ultima_regla);
        editTextOtros = findViewById(R.id.input_otros_embarazos);
        editTextCuantos = findViewById(R.id.input_embarazo_cuantos);
        editTextComplicacion = findViewById(R.id.input_complicaciones);
        editTextAcido = findViewById(R.id.input_acido_folico);
        editTextSintomas = findViewById(R.id.input_embarazo_sintomas);
        editTextNotas=findViewById(R.id.notas);
        imageViewInicio = findViewById(R.id.sound_embarazo_inicio_vida);
        imageViewUltima = findViewById(R.id.sound_embarazo_ultima_regla);
        imageViewOtros = findViewById(R.id.sound_embarazo_otros_embarazos);
        imageViewCuantos = findViewById(R.id.sound_embarazo_cuantos);
        imageViewComplicacion = findViewById(R.id.sound_embarazo_complicaciones);
        imageViewAcido = findViewById(R.id.sound_embarazo_acido_folico);
        imageViewSintomas = findViewById(R.id.sound_embarazo_sintomas);
        imageViewInicio.setTag(getResources().getResourceEntryName(R.string.preg_embarazo_inicio_vida));
        imageViewUltima.setTag(getResources().getResourceEntryName(R.string.preg_embarazo_ultima_regla));
        imageViewOtros.setTag(getResources().getResourceEntryName(R.string.preg_embarazo_otros_embarazos));
        imageViewCuantos.setTag(getResources().getResourceEntryName(R.string.preg_embarazo_cuantos));
        imageViewComplicacion.setTag(getResources().getResourceEntryName(R.string.preg_embarazo_complicaciones));
        imageViewAcido.setTag(getResources().getResourceEntryName(R.string.preg_embarazo_acido_folico));
        imageViewSintomas.setTag(getResources().getResourceEntryName(R.string.preg_g3_sintomas));

        checarEstado();

        editTextInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog  mdiDialog =new DatePickerDialog(EmbarazoActivity.this,new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        editTextInicio.setText(dayOfMonth+"/"+monthOfYear+"/"+year);
                    }
                }, 2000, 0, 1);
                mdiDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {
                        editTextInicio.setText("");
                    }
                });
                mdiDialog.show();
            }
        });

        editTextUltima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog  mdiDialog =new DatePickerDialog(EmbarazoActivity.this,new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        editTextUltima.setText(dayOfMonth+"/"+monthOfYear+"/"+year);
                    }
                }, 2000, 0, 1);
                mdiDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {
                        editTextUltima.setText("");
                    }
                });
                mdiDialog.show();
            }
        });

        editTextOtros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.e("arrayNames", getResources().getResourceEntryName(R.array.resp_si_no));
                Log.e("arrayFlags", getResources().getResourceEntryName(R.array.icon2));
                Log.e("title", getResources().getString(R.string.preg_embarazo_otros_embarazos));
                Log.e("refer",  getResources().getResourceEntryName(R.array.resp_si_no));

                intent.putExtra("arrayNames",   getResources().getResourceEntryName(R.array.resp_si_no));
                intent.putExtra("arrayFlags",   getResources().getResourceEntryName(R.array.icon2));
                intent.putExtra("title",        getResources().getString(R.string.preg_embarazo_otros_embarazos));
                intent.putExtra("refer",        getResources().getResourceEntryName(R.array.resp_si_no));

                startActivityForResult(intent,1);
            }
        });
        editTextComplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.e("arrayNames", getResources().getResourceEntryName(R.array.embarazo_resp_complicaciones));
                Log.e("arrayFlags", getResources().getResourceEntryName(R.array.icon4));
                Log.e("title", getResources().getString(R.string.preg_embarazo_complicaciones));
                Log.e("refer",  getResources().getResourceEntryName(R.array.embarazo_resp_complicaciones));

                intent.putExtra("arrayNames",   getResources().getResourceEntryName(R.array.embarazo_resp_complicaciones));
                intent.putExtra("arrayFlags",   getResources().getResourceEntryName(R.array.icon4));
                intent.putExtra("title",        getResources().getString(R.string.preg_embarazo_complicaciones));
                intent.putExtra("refer",        getResources().getResourceEntryName(R.array.embarazo_resp_complicaciones));

                startActivityForResult(intent,2);
            }
        });
        editTextAcido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.e("arrayNames", getResources().getResourceEntryName(R.array.resp_si_no));
                Log.e("arrayFlags", getResources().getResourceEntryName(R.array.icon2));
                Log.e("title", getResources().getString(R.string.preg_embarazo_acido_folico));
                Log.e("refer",  getResources().getResourceEntryName(R.array.resp_si_no));

                intent.putExtra("arrayNames",   getResources().getResourceEntryName(R.array.resp_si_no));
                intent.putExtra("arrayFlags",   getResources().getResourceEntryName(R.array.icon2));
                intent.putExtra("title",        getResources().getString(R.string.preg_embarazo_acido_folico));
                intent.putExtra("refer",        getResources().getResourceEntryName(R.array.resp_si_no));

                startActivityForResult(intent,3);
            }
        });
        editTextSintomas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.e("arrayNames", getResources().getResourceEntryName(R.array.embarazo_resp_sintomas));
                Log.e("arrayFlags", getResources().getResourceEntryName(R.array.icon3));
                Log.e("title", getResources().getString(R.string.preg_embarazo_otros_embarazos));
                Log.e("refer",  getResources().getResourceEntryName(R.array.embarazo_resp_sintomas));

                intent.putExtra("arrayNames",   getResources().getResourceEntryName(R.array.embarazo_resp_sintomas));
                intent.putExtra("arrayFlags",   getResources().getResourceEntryName(R.array.icon3));
                intent.putExtra("title",        getResources().getString(R.string.preg_g3_sintomas));
                intent.putExtra("refer",        getResources().getResourceEntryName(R.array.embarazo_resp_sintomas));
                startActivityForResult(intent,4);
            }
        });



        // Crear toolbar
        showToolbar(getResources().getString(R.string.embarazo),true);        //Getting the instance of Spinner and applying OnItemSelectedListener on it
    }


    public void onGuardar(View view) {
        final SharedPreferences.Editor editorLocal = prefsDatos.edit();
        final SharedPreferences.Editor editorEstados = prefsEstados.edit();
        editorLocal.putString("inicio", editTextInicio.getText().toString());
        editorLocal.putString("lastmenstru",editTextUltima.getText().toString());
        editorLocal.putString("otrosemba", editTextOtros.getText().toString());
        editorLocal.putString("cuantos", editTextCuantos.getText().toString());
        editorLocal.putString("complicacion", editTextComplicacion.getText().toString());
        editorLocal.putString("acido", editTextAcido.getText().toString());
        editorLocal.putString("sintomas", editTextSintomas.getText().toString());
        editorLocal.putString("notas", editTextNotas.getText().toString());
        editorLocal.apply();

        editorEstados.putBoolean("EmbarazoForm",true);
        editorEstados.apply();

        Intent intent = new Intent(this, ConsultaActivity.class);
        startActivity(intent);
    }

    private void checarEstado() {
        if(prefsEstados.getBoolean("EmbarazoForm",false)){
            editTextInicio.setText(prefsDatos.getString("inicio",""));
            editTextUltima.setText(prefsDatos.getString("lastmenstru",""));
            editTextOtros.setText(prefsDatos.getString("otrosemba",""));
            editTextCuantos.setText(prefsDatos.getString("cuantos",""));
            editTextComplicacion.setText(prefsDatos.getString("complicacion",""));
            editTextAcido.setText(prefsDatos.getString("acido",""));
            editTextSintomas.setText(prefsDatos.getString("sintomas",""));
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
                editTextOtros.setText(String.valueOf(ListDialog.getStringSelectList()));
            }
        }

        if (requestCode == 2) {
            if(resultCode == Activity.RESULT_OK){
                String result=data.getStringExtra("result");
                Log.e("resultOK","RESPUESTA");
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                Log.e("resultCANCELED",String.valueOf(ListDialog.getArraySelectList()) );
                editTextComplicacion.setText(String.valueOf(ListDialog.getStringSelectList()));
            }
        }
        if (requestCode == 3) {
            if(resultCode == Activity.RESULT_OK){
                String result=data.getStringExtra("result");
                Log.e("resultOK","RESPUESTA");
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                Log.e("resultCANCELED",String.valueOf(ListDialog.getArraySelectList()) );
                editTextAcido.setText(String.valueOf(ListDialog.getStringSelectList()));
            }
        }
        if (requestCode == 4) {
            if(resultCode == Activity.RESULT_OK){
                String result=data.getStringExtra("result");
                Log.e("resultOK","RESPUESTA");
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                Log.e("resultCANCELED",String.valueOf(ListDialog.getArraySelectList()) );
                editTextSintomas.setText(String.valueOf(ListDialog.getStringSelectList()));
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
