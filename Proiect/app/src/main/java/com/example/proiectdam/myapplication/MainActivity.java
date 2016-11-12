package com.example.proiectdam.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    private boolean exit = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        Thread toRun = new Thread()
        {
            public void run()
            {
                try{
                    sleep(2000);
                    Intent it = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(it);
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        };
        toRun.start();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        exit = true;
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        if(exit) {
            this.finish();
            System.exit(0);
        }
    }

}
