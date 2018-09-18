package com.watermelon.omarb.roma.View;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.watermelon.omarb.roma.R;

import java.util.Locale;

public class ConsultaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        checarEstado();
        // Crear toolbar
        showToolbar(getResources().getString(R.string.toolbar_tittle_consulta),true);
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

    private void checarEstado() {

        SharedPreferences prefsEstados= getSharedPreferences("EstadosROMA", MODE_PRIVATE);
        ImageView imageView;
        if(prefsEstados.getBoolean("Dolor",false)){
            imageView=findViewById(R.id.imageViewConsulta1);
            imageView.setImageResource(R.drawable.iconodolor2);
        }
        if(prefsEstados.getBoolean("FiebreForm",false)){
            imageView=findViewById(R.id.imageViewConsulta2);
            imageView.setImageResource(R.drawable.iconofiebre2);
        }
        if(prefsEstados.getBoolean("NauVomiForm",false)){
            imageView=findViewById(R.id.imageViewConsulta3);
            imageView.setImageResource(R.drawable.iconovomito2png);
        }
        if(prefsEstados.getBoolean("DiarreaForm",false)){
            imageView=findViewById(R.id.imageViewConsulta4);
            imageView.setImageResource(R.drawable.iconodiarrea2);
        }
        if(prefsEstados.getBoolean("HipertensionForm",false)){
            imageView=findViewById(R.id.imageViewConsulta5);
            imageView.setImageResource(R.drawable.iconohiperetension2);
        }
        if(prefsEstados.getBoolean("DiabetesForm",false)){
            imageView=findViewById(R.id.imageViewConsulta6);
            imageView.setImageResource(R.drawable.iconodiabetes2);
        }
        if(prefsEstados.getBoolean("ObesidadForm",false)){
            imageView=findViewById(R.id.imageViewConsulta7);
            imageView.setImageResource(R.drawable.iconoobesidad2);
        }
        if(prefsEstados.getBoolean("EmbarazoForm",false)){
            imageView=findViewById(R.id.imageViewConsulta8);
            imageView.setImageResource(R.drawable.iconoembarazo2);
        }

    }

    public void showToolbar(String tittle, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

    public void sound(View view){

            String audio_id= (String) view.getContentDescription();
            MediaPlayer media = null;

            if (audio_id.equals(getResources().getString(R.string.dolor))){
                getStringByLocal(this,R.string.dolor,"aa");
                media= MediaPlayer.create(this,R.raw.motivo_dolor);
            }else if (audio_id.equals(getResources().getString(R.string.fiebre))){
                getStringByLocal(this,R.string.fiebre,"aa");
                media= MediaPlayer.create(this,R.raw.motivo_fiebre);
            }else if (audio_id.equals(getResources().getString(R.string.nau_vom))){
                getStringByLocal(this,R.string.nau_vom,"aa");
                media= MediaPlayer.create(this,R.raw.motivo_nauseasyvomito);
            }else if (audio_id.equals(getResources().getString(R.string.diarrea))){
                getStringByLocal(this,R.string.diarrea,"aa");
                media= MediaPlayer.create(this,R.raw.motivo_diarrea);
            }else if (audio_id.equals(getResources().getString(R.string.hipertension))){
                getStringByLocal(this,R.string.hipertension,"aa");
                media= MediaPlayer.create(this,R.raw.motivo_hipertension);
            }else if (audio_id.equals(getResources().getString(R.string.diabetes))){
                getStringByLocal(this,R.string.diabetes,"aa");
                media= MediaPlayer.create(this,R.raw.motivo_diabetes);
            }else if (audio_id.equals(getResources().getString(R.string.obesidad))){
                getStringByLocal(this,R.string.obesidad,"aa");
                media= MediaPlayer.create(this,R.raw.motivo_obesidad);
            }else if (audio_id.equals(getResources().getString(R.string.embarazo))){
                getStringByLocal(this,R.string.embarazo,"aa");
                media= MediaPlayer.create(this,R.raw.motivo_controldeembarazo);
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


    public void goDolor(View view){
        Intent intent = new Intent(this, PartesCuerpoActivity.class);
        startActivity(intent);
    }

    public void goFiebre(View view){
        Intent intent = new Intent(this, FiebreActivity.class);
        startActivity(intent);
    }

    public void goNauseas(View view){
        Intent intent = new Intent(this, NauVomiActivity.class);
        startActivity(intent);
    }

    public void goDiarrrea(View view){
        Intent intent = new Intent(this, DiarreaActivity.class);
        startActivity(intent);
    }

    public void goHipertension(View view){
        Intent intent = new Intent(this, HipertensionActivity.class);
        startActivity(intent);
    }

    public void goDiabetes(View view){
        Intent intent = new Intent(this, DiabetesActivity.class);
        startActivity(intent);
    }

    public void goObesidad(View view){
        Intent intent = new Intent(this, ObesidadActivity.class);
        startActivity(intent);
    }

    public void goEmbarazo(View view){
        Intent intent = new Intent(this, EmbarazoActivity.class);
        startActivity(intent);
    }

}

