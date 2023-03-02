package com.yatra;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ImageView imageView;
    ImageView imageView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();
        recyclerView=findViewById((R.id.recyclerview));
        imageView=findViewById(R.id.menu);
        ImageView imageView3 =findViewById(R.id.hospital);
       imageView1=findViewById(R.id.travel);
       ImageView imageView4=findViewById(R.id.cafe);
       ImageView imageView5=findViewById(R.id.adventure);
        ImageView imageView2=findViewById(R.id.hotels);
        ArrayList<Places> list = new ArrayList<>();
        list.add(new Places(R.drawable.mahendracave, "Mahendra Cafe","Rupakot Resort is nearly one hour drive from airport." +
                "It offers splendid view of rupa and begnas lake. It offers features like swimming pool, " +
                "air conditioning and balcony.The room available are deluxe and standard view room. The cost for staying starts from $200."));
//        list.add(new Places(R.drawable.akeside, "Lakeside","It is located at the centre of Pokhara. It offers splendid view of Phewa Lake"
//        +"along with Barahi Temple in between."+"Adventures like boating and swimming is carried out."));
       list.add(new Places(R.drawable.bindabasani, "Bindabasini","It is a religious place that is visited by Hindu people residing here." +
                "It is located 20 mins drive through the airport"+"They offer facility of lift for elderly and disable people."));
       list.add(new Places(R.drawable.sarangkot,"Sarangkot","Sarangkot is known for its panoramic Himalaya view. This offers" +
              "the incredible view with a taste of local village life.This tiny village just north of Pokhara " +
               "is mostly known for the stunning sunrise over Annapurna Mountains"));
       list.add(new Places(R.drawable.stupa,"Stupa","It is a Buddhist monument located at Pumdhikot." +
               "it is a popular tourist attraction and strinking landmark for a hikers as well. The way of transportation can be through boating" +
               "cycling or hiking."));
        list.add(new Places(R.drawable.oldbazar,"OldBazar","This bazaar lets you witness some mysterious alleys and courtyard which might not " +
                "have witnessed before."));
        PlacesAdapter adapter=new PlacesAdapter(list,getApplicationContext());
        recyclerView.setAdapter(adapter);

       // CaptionImageAdapter imageAdapter=new CaptionImageAdapter()

        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivity.this,MapsActivity.class);
                startActivity(intent);

            }
        });
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivity.this,PlacesActivity.class);
                startActivity(intent);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivity.this,HotelsActivity.class);
                startActivity(intent);
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivity.this,HospitalsActivity.class);
                startActivity(intent);
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivity.this,CafeActivity.class);
                startActivity(intent);
            }
        });
        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivity.this,AdventureActivity.class);
                startActivity(intent);
            }
        });


    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu,menu);
//        return super.onCreateOptionsMenu(menu);
//    }


   /* @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if (id==R.id.map);

            Intent intent = new Intent(HomeActivity.this, HotelActivity.class);
            startActivity(intent);
            finish();

        return super.onOptionsItemSelected(item);*/

}