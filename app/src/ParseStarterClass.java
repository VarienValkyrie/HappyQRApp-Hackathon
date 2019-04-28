package com.example.hack;

import android.app.Application;

import com.parse.Parse;

public class ParseStarterClass extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.setLogLevel(Parse.LOG_LEVEL_DEBUG);

        Parse.initialize(new Parse.Configuration.Builder(this)
            .applicationId("EwMy7W5YTgjnvCS1ZNyarran6fB3XPqPlccVgmYD")
                .clientKey("GMjsasoJcaz0hgr00ckxuaYuS88dJjyCxaC1rdlr")
                .server("https://parseapi.back4app.com/")
                .build()


        );
    }
}
