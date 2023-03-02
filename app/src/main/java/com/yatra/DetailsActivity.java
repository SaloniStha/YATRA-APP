package com.yatra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class DetailsActivity extends AppCompatActivity {
    ImageView imageView;
    TextView textView,textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        imageView=findViewById(R.id.image_details);
        textView=findViewById(R.id.text_details);
        textView1=findViewById(R.id.text_desc);
        imageView.setImageResource(getIntent().getIntExtra("ImageName",0));
        textView.setText(getIntent().getStringExtra("header"));
        textView1.setText(getIntent().getStringExtra("desc"));
    }
}