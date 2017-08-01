package com.example.mg;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Erik Justian on 01/08/2017.
 */

public class Memory extends Application {
    @Override
    public void onCreate(){
        super.onCreate();

        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().name("memory.realm").build();
        Realm.setDefaultConfiguration(config);
    }
}
