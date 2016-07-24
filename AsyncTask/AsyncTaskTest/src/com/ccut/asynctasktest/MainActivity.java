package com.ccut.asynctasktest;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loadImage(View view) {
        Intent intent = new Intent(MainActivity.this, ImageTest.class);
        startActivity(intent);
    }  
    public void loadProgress(View view){
    	startActivity(new Intent(MainActivity.this,ProgressBarTest.class));
    }
}
