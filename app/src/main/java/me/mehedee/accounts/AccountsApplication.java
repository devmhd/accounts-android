package me.mehedee.accounts;

import android.app.Application;

import me.mehedee.accounts.persistence.MainDatabase;

public class AccountsApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        MainDatabase.create(getApplicationContext());
    }
}
