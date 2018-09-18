package com.watermelon.omarb.roma;


import android.graphics.drawable.Drawable;

public class DialogHelper {
    private String name;
    private Drawable flag;
    private boolean isSelected;

    public DialogHelper(String name, Drawable flag){
        this.name = name;
        this.flag = flag;

    }
    public String getName() {
        return name;
    }

    public Drawable getFlag() {
        return flag;
    }


    public boolean getSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}