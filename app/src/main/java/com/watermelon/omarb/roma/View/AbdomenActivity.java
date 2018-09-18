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

public class AbdomenActivity extends AppCompatActivity {
    EditText editTextDesde,editTextHorario,editTextTantoDuele,
            editTextDura,editTextAumenta,editTextDisminuye,editTextNota;
    ImageView imageViewDesde,imageViewHorario,imageViewTantoDuele,
            imageViewDura,imageViewAumenta,imageViewDisminuye;
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
        setContentView(R.layout.activity_abdomen);

        final Intent intent = new Intent(this, ListDialog.class);
        sounds=new Sounds();

        prefsEstados= getSharedPreferences("EstadosROMA", MODE_PRIVATE);
        prefsDatos= getSharedPreferences("AbdomenForm", MODE_PRIVATE);


        editTextDesde =findViewById(R.id.input_abdomen_desde);
        editTextHorario =findViewById(R.id.input_abdomen_horario);
        editTextTantoDuele =findViewById(R.id.input_abdomen_tanto);
        editTextDura = findViewById(R.id.input_abdomen_dura);
        editTextAumenta = findViewById(R.id.input_abdomen_aumenta);
        editTextDisminuye = findViewById(R.id.input_abdomen_disminuye);
        editTextNota = findViewById(R.id.notas);

        imageViewDesde =findViewById(R.id.sound_abdomen_desde);
        imageViewHorario =findViewById(R.id.sound_abdomen_horario);
        imageViewTantoDuele =findViewById(R.id.sound_abdomen_tanto);
        imageViewDura = findViewById(R.id.sound_abdomen_dura);
        imageViewAumenta = findViewById(R.id.sound_abdomen_aumenta);
        imageViewDisminuye = findViewById(R.id.sound_abdomen_disminuye);

        imageViewDesde.setTag(getResources().getResourceEntryName(R.string.preg_g1_desde));
        imageViewHorario.setTag(getResources().getResourceEntryName(R.string.preg_g2_horario));
        imageViewTantoDuele.setTag(getResources().getResourceEntryName(R.string.preg_tanto_duele));
        imageViewDura.setTag(getResources().getResourceEntryName(R.string.preg_duracion_dolor));
        imageViewAumenta.setTag(getResources().getResourceEntryName(R.string.preg_aumenta_dolor));
        imageViewDisminuye.setTag(getResources().getResourceEntryName(R.string.preg_disminuye_dolor));
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

        editTextTantoDuele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("arrayNames", getResources().getResourceEntryName(R.array.resp_tanto_duele));
                Log.e("arrayFlags", getResources().getResourceEntryName(R.array.icon3));
                Log.e("title", getResources().getString(R.string.preg_tanto_duele));
                Log.e("refer",  getResources().getResourceEntryName(R.array.resp_tanto_duele));
                intent.putExtra("arrayNames",   getResources().getResourceEntryName(R.array.resp_tanto_duele));
                intent.putExtra("arrayFlags",   getResources().getResourceEntryName(R.array.icon3));
                intent.putExtra("title",        getResources().getString(R.string.preg_tanto_duele));
                intent.putExtra("refer",        getResources().getResourceEntryName(R.array.resp_tanto_duele));

                startActivityForResult(intent,3);
            }
        });

        editTextDura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("arrayNames", getResources().getResourceEntryName(R.array.resp_duracion_dolor));
                Log.e("arrayFlags", getResources().getResourceEntryName(R.array.icon3));
                Log.e("title", getResources().getString(R.string.preg_duracion_dolor));
                Log.e("refer",  getResources().getResourceEntryName(R.array.resp_duracion_dolor));
                intent.putExtra("arrayNames",   getResources().getResourceEntryName(R.array.resp_duracion_dolor));
                intent.putExtra("arrayFlags",   getResources().getResourceEntryName(R.array.icon3));
                intent.putExtra("title",        getResources().getString(R.string.preg_duracion_dolor));
                intent.putExtra("refer",        getResources().getResourceEntryName(R.array.resp_duracion_dolor));

                startActivityForResult(intent,4);
            }
        });
        editTextAumenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("arrayNames", getResources().getResourceEntryName(R.array.abdomen_resp_aumenta));
                Log.e("arrayFlags", getResources().getResourceEntryName(R.array.icon2));
                Log.e("title", getResources().getString(R.string.preg_aumenta_dolor));
                Log.e("refer",  getResources().getResourceEntryName(R.array.abdomen_resp_aumenta));
                intent.putExtra("arrayNames",   getResources().getResourceEntryName(R.array.abdomen_resp_aumenta));
                intent.putExtra("arrayFlags",   getResources().getResourceEntryName(R.array.icon3));
                intent.putExtra("title",        getResources().getString(R.string.preg_aumenta_dolor));
                intent.putExtra("refer",        getResources().getResourceEntryName(R.array.abdomen_resp_aumenta));

                startActivityForResult(intent,5);
            }
        });
        editTextDisminuye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("arrayNames", getResources().getResourceEntryName(R.array.abdomen_resp_disminuye));
                Log.e("arrayFlags", getResources().getResourceEntryName(R.array.icon2));
                Log.e("title", getResources().getString(R.string.preg_disminuye_dolor));
                Log.e("refer",  getResources().getResourceEntryName(R.array.abdomen_resp_disminuye));
                intent.putExtra("arrayNames",   getResources().getResourceEntryName(R.array.abdomen_resp_disminuye));
                intent.putExtra("arrayFlags",   getResources().getResourceEntryName(R.array.icon3));
                intent.putExtra("title",        getResources().getString(R.string.preg_disminuye_dolor));
                intent.putExtra("refer",        getResources().getResourceEntryName(R.array.abdomen_resp_disminuye));

                startActivityForResult(intent,6);
            }
        });

        // Crear toolbar
        showToolbar(getResources().getString(R.string.abdomen),true);        //Getting the instance of Spinner and applying OnItemSelectedListener on it
    }



    public void onGuardar(View view) {
        final SharedPreferences.Editor editorLocal = prefsDatos.edit();
        final SharedPreferences.Editor editorEstados = prefsEstados.edit();
        editorLocal.putString("desde", editTextDesde.getText().toString());
        editorLocal.putString("horario",editTextHorario.getText().toString());
        editorLocal.putString("tantoduele", editTextTantoDuele.getText().toString());
        editorLocal.putString("dura", editTextDura.getText().toString());
        editorLocal.putString("aumenta", editTextAumenta.getText().toString());
        editorLocal.putString("disminuye", editTextDisminuye.getText().toString());
        editorLocal.putString("notas", editTextNota.getText().toString());
        editorLocal.apply();

        editorEstados.putBoolean("AbdomenForm",true);
        editorEstados.putBoolean("Dolor",true);
        editorEstados.putBoolean("Consulta",true);
        editorEstados.apply();

        Intent intent = new Intent(this, PartesCuerpoActivity.class);
        startActivity(intent);
    }

    private void checarEstado() {
        if(prefsEstados.getBoolean("AbdomenForm",false)){
            editTextDesde.setText(prefsDatos.getString("desde",""));
            editTextHorario.setText(prefsDatos.getString("horario",""));
            editTextTantoDuele.setText(prefsDatos.getString("tantoduele",""));
            editTextDura.setText(prefsDatos.getString("dura",""));
            editTextAumenta.setText(prefsDatos.getString("aumenta",""));
            editTextDisminuye.setText(prefsDatos.getString("disminuye",""));
            editTextNota.setText(prefsDatos.getString("notas",""));
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
                editTextTantoDuele.setText(String.valueOf(ListDialog.getStringSelectList()));
            }
        }

        if (requestCode == 4) {
            if(resultCode == Activity.RESULT_OK){
                String result=data.getStringExtra("result");
                Log.e("resultOK","RESPUESTA");
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                Log.e("resultCANCELED",String.valueOf(ListDialog.getArraySelectList()) );
                editTextDura.setText(String.valueOf(ListDialog.getStringSelectList()));
            }
        }

        if (requestCode == 5) {
            if(resultCode == Activity.RESULT_OK){
                String result=data.getStringExtra("result");
                Log.e("resultOK","RESPUESTA");
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                Log.e("resultCANCELED",String.valueOf(ListDialog.getArraySelectList()) );
                editTextAumenta.setText(String.valueOf(ListDialog.getStringSelectList()));
            }
        }

        if (requestCode == 6) {
            if(resultCode == Activity.RESULT_OK){
                String result=data.getStringExtra("result");
                Log.e("resultOK","RESPUESTA");
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                Log.e("resultCANCELED",String.valueOf(ListDialog.getArraySelectList()) );
                editTextDisminuye.setText(String.valueOf(ListDialog.getStringSelectList()));
            }
        }

    }//onActivityResult


    public void sound(final View view) {
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
                Log.e("sound","Reproduciendo soundpool: "+ view.getTag());
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
