package com.yatra;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class HospitalsActivity extends AppCompatActivity {
     LinearLayout metrocity,manipal,ciewic,fishtail,western,charak;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospitals);
        getSupportActionBar().hide();
        metrocity=findViewById(R.id.metrocity);
        manipal=findViewById(R.id.manipal);
        ciewic=findViewById(R.id.ciewic);
        fishtail=findViewById(R.id.fishtail);
        western=findViewById(R.id.western);
        charak=findViewById(R.id.charak);
        metrocity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("geo:0,0?q=Metrocity+Hospital+(P)+Ltd.");
                Intent i = new Intent(Intent.ACTION_VIEW, uri);
                i.setPackage("com.google.android.apps.maps");
                startActivity(i);

            }
        });
        manipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("geo:0,0?q=Manipal+Teaching+Hospital");
                Intent i = new Intent(Intent.ACTION_VIEW, uri);
                i.setPackage("com.google.android.apps.maps");
                startActivity(i);

            }
        });
        ciewic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("geo:0,0?q=CIWEC+Hospital+Pokhara");
                Intent i = new Intent(Intent.ACTION_VIEW, uri);
                i.setPackage("com.google.android.apps.maps");
                startActivity(i);

            }
        });
        fishtail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("geo:0,0?q=fishtail+hospital+pokhara");
                Intent i = new Intent(Intent.ACTION_VIEW, uri);
                i.setPackage("com.google.android.apps.maps");
                startActivity(i);

            }
        });
        western.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("geo:0,0?q=Western+Regional+Hospital+%5B+Gandaki+Hospital+%5D");
                Intent i = new Intent(Intent.ACTION_VIEW, uri);
                i.setPackage("com.google.android.apps.maps");
                startActivity(i);

            }
        });
        charak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("geo:0,0?q=Charak+Memorial+Hospital+Pvt.+Ltd.");
                Intent i = new Intent(Intent.ACTION_VIEW, uri);
                i.setPackage("com.google.android.apps.maps");
                startActivity(i);

            }
        });

    }
}