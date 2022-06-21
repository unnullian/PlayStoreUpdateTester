package com.minwoo.playstoreupdatetester;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    PackageInfo pi = getApplicationContext().getPackageManager().getPackageInfo(getApplicationContext().getPackageName(), 0);
                    Toast.makeText(MainActivity.this, "versionName : " + pi.versionName + "\n" + "versionCode:" + pi.versionCode, Toast.LENGTH_SHORT).show();
                    ((TextView)findViewById(R.id.versionText)).setText("versionName : " + pi.versionName + "\n" + "versionCode:" + pi.versionCode);
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}