package com.watermelon.omarb.roma.View;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.watermelon.omarb.roma.R;

import java.util.Locale;

public class PartesCuerpoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partes_cuerpo);


        checarEstado();

        ImageButton ibcabeza = this.<ImageButton>findViewById(R.id.imageCabeza);
        ImageButton ibcuello = this.<ImageButton>findViewById(R.id.imageCuello);
        ImageButton ibtorax = this.<ImageButton>findViewById(R.id.imageTorax);
        ImageButton ibabdomen = this.<ImageButton>findViewById(R.id.imageAbdomen);
        ImageButton ibgenito = this.<ImageButton>findViewById(R.id.imageGenito);
        ImageButton ibextremidades = this.<ImageButton>findViewById(R.id.imageExtremidades);
/*
        cabeza.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v) {
                // TODO Auto-generated method stub
                sound(v);
                return false;
            }
        });*/
        ibcabeza.setOnLongClickListener(mLongListener);
        ibcuello.setOnLongClickListener(mLongListener);
        ibtorax.setOnLongClickListener(mLongListener);
        ibabdomen.setOnLongClickListener(mLongListener);
        ibgenito.setOnLongClickListener(mLongListener);
        ibextremidades.setOnLongClickListener(mLongListener);

        // Crear toolbar
        showToolbar(getResources().getString(R.string.toolbar_tittle_partes),true);
    }

    private void checarEstado() {

        SharedPreferences prefsEstados= getSharedPreferences("EstadosROMA", MODE_PRIVATE);
        ImageView imageView;
        if(prefsEstados.getBoolean("CabezaForm",false)){
             imageView=findViewById(R.id.imageCabeza);
             imageView.setImageResource(R.drawable.iconocabeza2);
        }
        if(prefsEstados.getBoolean("CuelloForm",false)){
            imageView=findViewById(R.id.imageCuello);
            imageView.setImageResource(R.drawable.iconocuello2);
        }
        if(prefsEstados.getBoolean("ToraxForm",false)){
            imageView=findViewById(R.id.imageTorax);
            imageView.setImageResource(R.drawable.iconotorax2);
        }
        if(prefsEstados.getBoolean("AbdomenForm",false)){
            imageView=findViewById(R.id.imageAbdomen);
            imageView.setImageResource(R.drawable.iconoabdomen2);
        }
        if(prefsEstados.getBoolean("GenitoForm",false)){
            imageView=findViewById(R.id.imageGenito);
            imageView.setImageResource(R.drawable.iconogeniturinario2);
        }
        if(prefsEstados.getBoolean("ExtremidadesForm",false)){
            imageView=findViewById(R.id.imageExtremidades);
            imageView.setImageResource(R.drawable.iconoextremidades2);
        }

    }

    public void showToolbar(String tittle, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

        // Create an anonymous implementation of OnClickListener
        private View.OnLongClickListener mLongListener = new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                sound( v);
                return false;
            }

        };

    public void sound(View view){

        String audio_id= (String) view.getContentDescription();
        MediaPlayer media = null;

        if (audio_id.equals(getResources().getString(R.string.cabeza))){
            getStringByLocal(this,R.string.cabeza,"aa");
            media= MediaPlayer.create(this,R.raw.partes_cabeza);
        }else if (audio_id.equals(getResources().getString(R.string.cuello))){
            getStringByLocal(this,R.string.cuello,"aa");
            media= MediaPlayer.create(this,R.raw.partes_cuello);
        }else if (audio_id.equals(getResources().getString(R.string.torax))){
            getStringByLocal(this,R.string.torax,"aa");
            media= MediaPlayer.create(this,R.raw.partes_torax);
        }else if (audio_id.equals(getResources().getString(R.string.abdomen))){
            getStringByLocal(this,R.string.abdomen,"aa");
            media= MediaPlayer.create(this,R.raw.partes_abdomen);
        }else if (audio_id.equals(getResources().getString(R.string.genitourinario))){
            getStringByLocal(this,R.string.genitourinario,"aa");
            media= MediaPlayer.create(this,R.raw.partes_genitourinario);
        }else if (audio_id.equals(getResources().getString(R.string.extremidades))){
            getStringByLocal(this,R.string.extremidades,"aa");
            media= MediaPlayer.create(this,R.raw.partes_extremidades);
        }

        if (media != null)
            media.start();

        media.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            };
        });

    }
    public static String getStringByLocal(Context context, int id, String locale) {
        String text;
        Configuration configuration = new Configuration(context.getResources().getConfiguration());
        configuration.setLocale(new Locale(locale));
        text = context.createConfigurationContext(configuration).getResources().getString(id);
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
        return text;
    }

    public void goCabeza(View view){
        Intent intent = new Intent(this, CabezaActivity.class);
        startActivity(intent);
    }
    public void goCuello(View view){
        Intent intent = new Intent(this,CuelloActivity.class);
        startActivity(intent);
    }
    public void goTorax(View view){
        Intent intent = new Intent(this, ToraxActivity.class);
        startActivity(intent);
    }
    public void goAbdomen(View view){
        Intent intent = new Intent(this, AbdomenActivity.class);
         startActivity(intent);
    }
    public void goGenito(View view){
         Intent intent = new Intent(this, GenitourinarioActivity.class);
         startActivity(intent);
    }
    public void goExtremidades(View view){
        Intent intent = new Intent(this, ExtremidadesActivity.class);
         startActivity(intent);
    }
}
