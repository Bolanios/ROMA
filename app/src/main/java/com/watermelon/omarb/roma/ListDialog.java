package com.watermelon.omarb.roma;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListDialog extends ListActivity {

    public String[] names;
    private TypedArray imgs;
    private List<DialogHelper> list;
    private static Map<Integer, String> mapSelects =new HashMap<Integer, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent=getIntent();
        setTitle(intent.getStringExtra("title"));

        //populateList();
        populateList(intent.getStringExtra("arrayNames"),intent.getStringExtra("arrayFlags"));


        //ArrayAdapter<DialogHelper> adapter = new ListDialogAdapter(this, list);
        ArrayAdapter<DialogHelper> adapter = new ListDialogAdapter(this, list, intent.getStringExtra("refer"));
        setListAdapter(adapter);

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("TAG_PAUSA_ARRAY", String.valueOf(mapSelects));
        Intent returnIntent = getIntent();
        returnIntent.putExtra("result",String.valueOf(mapSelects));
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }
/*
    private void populateList() {
        list = new ArrayList<>();
        names = getResources().getStringArray(R.array.names);
        imgs = getResources().obtainTypedArray(R.array.flags);
        for(int i = 0; i < names.length; i++){
            list.add(new DialogHelper(names[i], imgs.getDrawable(i)));
        }
    }*/
    private void populateList(String name, String flags) {
        int holderint = getResources().getIdentifier(name, "array",
                this.getPackageName()); // You had used "name" example
        int holderintFlags = getResources().getIdentifier(flags, "array",
                this.getPackageName()); // You had used "flags" example


        list = new ArrayList<>();
        names = getResources().getStringArray(holderint);
        imgs = getResources().obtainTypedArray(holderintFlags);

        for(int i = 0; i < names.length; i++) {
            list.add(new DialogHelper(names[i], imgs.getDrawable(i)));
        }


        //
        //list = new ArrayList<>();
        //names = getResources().getStringArray(R.array.names);
        //imgs = getResources().obtainTypedArray(R.array.flags);
        //for(int i = 0; i < names.length; i++){
        //list.add(new DialogHelper(names[i], imgs.getDrawable(i)));
        //}
        //

    }


    public static void setRemoveArraySelect(){
        mapSelects.clear();
    }
    public static void setRemoveArraySelect(int i){
        mapSelects.remove(i);
    }
    public static void setPutArraySelect(int i,String s){
        mapSelects.put(i,s);
    }
    public static Map<Integer, String> getArraySelectList(){
        return mapSelects;
    }


    public static String getStringSelectList(){
        boolean flag= false;
        String values="";
        for (Map.Entry<Integer,String> entry : mapSelects.entrySet()) {
            if(flag)
                values=values+", "+entry.getValue();
            else{
                values=entry.getValue();
                flag=true;
            }
        }
        return values;
    }

}