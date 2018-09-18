package com.watermelon.omarb.roma;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.watermelon.omarb.roma.View.MenuPrincipalActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goConsulta(View view) {
/*
        SharedPreferences prefs =
                getSharedPreferences("EstadosROMA", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("datosGenerales",false);
        editor.putBoolean("consulta", false);
        editor.commit();*/

        Intent intent = new Intent(this, MenuPrincipalActivity.class);
        startActivity(intent);
    }
}
