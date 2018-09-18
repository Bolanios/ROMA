package com.watermelon.omarb.roma;

import android.app.Activity;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ListDialogAdapter extends ArrayAdapter<DialogHelper> {

    private final List<DialogHelper> list;
    private final Activity context;
    private final String referencia;

    static class ViewHolder {
        protected CheckBox checkBox;
        protected TextView name;
        protected ImageView flag;
    }

    public ListDialogAdapter(Activity context, List<DialogHelper> list) {
        super(context, R.layout.dialog_layout, list);
        this.context = context;
        this.list = list;
        this.referencia = null;
    }


    public ListDialogAdapter(Activity context, List<DialogHelper> list, String referecia) {
        super(context, R.layout.dialog_layout, list);
        this.context = context;
        this.list = list;
        this.referencia = referecia;
    }


    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
        View view = null;
        ListDialog.setRemoveArraySelect();

        if (convertView == null) {
            LayoutInflater inflator = context.getLayoutInflater();
            view = inflator.inflate(R.layout.dialog_layout, null);
            final ViewHolder viewHolder = new ViewHolder();
            viewHolder.name = (TextView) view.findViewById(R.id.name);
            viewHolder.flag = (ImageView) view.findViewById(R.id.flag);
             viewHolder.checkBox = (CheckBox) view.findViewById(R.id.checkBox);
            view.setTag(viewHolder);
        } else {
            view = convertView;
        }

        final ViewHolder holder = (ViewHolder) view.getTag();
        holder.name.setText(list.get(position).getName());
        holder.flag.setImageDrawable(list.get(position).getFlag());
        holder.flag.setContentDescription(holder.name.getText());
        holder.flag.setTag(R.integer.btnplusview, convertView);
        holder.flag.setTag( position);
        holder.checkBox.setChecked(list.get(position).getSelected());
        holder.checkBox.setTag(R.integer.btnplusview, convertView);
        holder.checkBox.setTag( position);

        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View tempview = (View) holder.checkBox.getTag(R.integer.btnplusview);
                Integer pos = (Integer)  holder.checkBox.getTag();
                //Toast.makeText(context, "Checkbox "+pos+" clicked!", Toast.LENGTH_SHORT).show();
                if(list.get(pos).getSelected()){
                    ListDialog.setRemoveArraySelect(pos);
                    list.get(pos).setSelected(false);
                    //Toast.makeText(context, "CalcelCheckbox "+pos+" ! "+ ListDialog.getArraySelectList(), Toast.LENGTH_SHORT).show();
                }else {
                    ListDialog.setPutArraySelect(pos,list.get(pos).getName());
                    //Toast.makeText(context, "Checkbox "+pos+" ! "+ ListDialog.getArraySelectList(), Toast.LENGTH_SHORT).show();
                    list.get(pos).setSelected(true);
                }

            }
        });

        holder.flag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sounds arraySounds= new Sounds();


                View tempview = (View) holder.checkBox.getTag(R.integer.btnplusview);
                Integer pos = (Integer)  holder.checkBox.getTag();

                Log.e("TAG_REFERENCIARESPUESTA",referencia);
                //Toast.makeText(context, "image " + pos + " ! "+ arraySounds.getArraySound(referencia) , Toast.LENGTH_SHORT).show();

                //Toast.makeText(context, v.getContentDescription().toString(), Toast.LENGTH_SHORT).show();
                //Toast.makeText(context, (CharSequence) context.getParent().getApplication(), Toast.LENGTH_SHORT).show();

                MediaPlayer media=null;
                Integer sound=null;
                String soundString=arraySounds.getStringByLocal(context,referencia,"aa",pos);

                if (arraySounds.getArraySound(referencia)!=null)
                    sound = arraySounds.getArraySound(referencia)[pos];

                Toast.makeText(context,  arraySounds.getStringByLocal(context,referencia,"aa",pos), Toast.LENGTH_SHORT).show();

                if(sound!=null){
                    media = MediaPlayer.create(context,sound);
                }else{
                    Toast.makeText(context,  arraySounds.getStringByLocal(context,referencia,"aa",pos)+" -NO AUDIO", Toast.LENGTH_SHORT).show();
                    //Toast.makeText(context, "Lo sentimos aun no se tiene este audio" , Toast.LENGTH_SHORT).show();
                }

                if (media != null) {
                    media.start();
                    media.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
                }


            }
        });

        ///---------------------
        return view;
    }

    public List<DialogHelper> getList() {
        return list;
    }
}