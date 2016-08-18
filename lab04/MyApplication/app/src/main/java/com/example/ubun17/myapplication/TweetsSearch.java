package com.example.ubun17.myapplication;

import java.util.ArrayList;

/**
 * Created by ubun17 on 8/18/16.
 */
public class TweetsSearch {
    private ArrayList<Statuses> statuses;

    public ArrayList<Statuses> getStatuses() {
        return statuses;
    }

    public void setStatuses(ArrayList<Statuses> statuses) {
        this.statuses = statuses;
    }

    @Override
    public String toString() {
        return statuses.toString();
    }

   // public Statuses[]

}
