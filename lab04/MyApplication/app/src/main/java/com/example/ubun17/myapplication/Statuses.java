package com.example.ubun17.myapplication;

/**
 * Created by ubun17 on 8/18/16.
 */
public class Statuses {
    private String text;

    public String getText() {return  text;}

    public void setText(String str) {
         this.text = str;
    }

    @Override
    public String toString() {
        return text;
    }
}
