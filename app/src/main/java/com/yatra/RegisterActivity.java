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

public class RegisterActivity extends AppCompatActivity {
    private TextView textView;
    EditText inputEmail,inputPassword,inputConfirmPassword;
    boolean password_visible;
    Button btnRegister;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();
        textView=findViewById(R.id.already);
        inputEmail=findViewById(R.id.etemail2);
        inputPassword=findViewById(R.id.etpassword2);
        inputConfirmPassword=findViewById(R.id.etrepassword);
        btnRegister=findViewById(R.id.btnRegister);
        DB = new DBHelper(this);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user= inputEmail.getText().toString();
                String pass= inputPassword.getText().toString();
                String repass= inputConfirmPassword.getText().toString();
                if (user.equals("")||pass.equals("")|| repass.equals(""))
                    Toast.makeText(RegisterActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                else {
                    if (pass.equals(repass)){
                        Boolean checkuser= DB.checkusername(user);
                        if(checkuser==false){
                            Boolean insert = DB.insertDta(user,pass);
                            if (insert==true){
                                Toast.makeText(RegisterActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(RegisterActivity.this, "Registration Failed.", Toast.LENGTH_SHORT).show();
                            }

                        }else {
                            Toast.makeText(RegisterActivity.this, "User already exist please sign in", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(RegisterActivity.this, "Password not matching", Toast.LENGTH_SHORT).show();
                    }
                }

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
        inputConfirmPassword.setOnTouchListener(new View.OnTouchListener() { //for visibility
            @Override
            public boolean onTouch(View view, MotionEvent Event) {
                final int Right=2;
                if(Event.getAction()==MotionEvent.ACTION_UP) {
                    if (Event.getRawX() >= inputConfirmPassword.getRight() - inputConfirmPassword.getCompoundDrawables()[Right].getBounds().width()){
                        int selection=inputConfirmPassword.getSelectionEnd();
                        if(password_visible){
                            //set drawable image here
                            inputConfirmPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_visibilityoff,0);
                            //for hide password
                            inputConfirmPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            password_visible=false;
                        }else {

                            //set drawable image here
                            inputConfirmPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_visibilityon,0);
                            //for show password
                            inputConfirmPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            password_visible=true;
                        }
                        inputConfirmPassword.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });
    }
}