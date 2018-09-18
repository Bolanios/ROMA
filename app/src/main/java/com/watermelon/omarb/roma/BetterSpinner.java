package com.watermelon.omarb.roma;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

/**
 * Created by omarb on 02/04/2018.
 */

public class BetterSpinner {

    Context context;

    public BetterSpinner(Context context){
        this.context=context;
        return;
    }

    public void CrearList(String[] array,View viewById){

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(context,
                android.R.layout.simple_dropdown_item_1line,  array);

        MaterialBetterSpinner materialDesignSpinner = (MaterialBetterSpinner)viewById;
        materialDesignSpinner.setAdapter(arrayAdapter);
    }

}
