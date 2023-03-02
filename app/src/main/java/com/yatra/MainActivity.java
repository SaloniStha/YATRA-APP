package com.yatra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    EditText inputEmail,inputPassword;
    Button btnLogin;
    boolean password_visible;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        textView=findViewById(R.id.newaccount);
        TextView textView1 = findViewById(R.id.etforget);
        inputEmail=findViewById(R.id.etemail);
        inputPassword=findViewById(R.id.etpassword);
        btnLogin=findViewById(R.id.btnLogin);
        DB=new DBHelper(this);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user= inputEmail.getText().toString();
                String pass= inputPassword.getText().toString();
                if(user.equals("")||pass.equals(""))
                    Toast.makeText(MainActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpass =DB.checkusernamepassword(user,pass);
                    if(checkuserpass==true){
                        Toast.makeText(MainActivity.this, "Sign in successful", Toast.LENGTH_SHORT).show();
                         Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
                         startActivity(intent);
                    }else {
                        Toast.makeText(MainActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);

            }
        });
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);

            }
        });
        inputPassword.setOnTouchListener(new View.OnTouchListener() { //for visibility
            @Override
            public boolean onTouch(View view, MotionEvent Event) {
                final int Right=2;
                if(Event.getAction()==MotionEvent.ACTION_UP) {
                    if (Event.getRawX() >= inputPassword.getRight() - inputPassword.getCompoundDrawables()[Right].getBounds().width()){
                        int selection=inputPassword.getSelectionEnd();
                        if(password_visible){
                            //set drawable image here
                            inputPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_visibilityoff,0);
                            //for hide password
                            inputPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            password_visible=false;
                        }else {

                            //set drawable image here
                            inputPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_visibilityon,0);
                            //for show password
                            inputPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            password_visible=true;
                        }
                        inputPassword.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });
    }
}