package com.mehmetberkayatasoy.instagramcloneparse;

import android.app.Application;

import com.parse.Parse;

public class ParseStarterClass extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.setLogLevel(Parse.LOG_LEVEL_DEBUG);
        Parse.initialize(new Parse.Configuration.Builder(this)
        .applicationId("0ISJDUZ4jejEQ4qL0Q0NEm7IVxKyKDctFXqnCjuG")
        .clientKey("Spa8niyeM3HUebPDn5tK0O3WTgTITYGMxIQsu2C1")
        .server("https://parseapi.back4app.com/")
        .build());
    }
}
