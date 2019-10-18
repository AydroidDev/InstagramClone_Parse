package com.mehmetberkayatasoy.instagramcloneparse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class MainActivity extends AppCompatActivity {
    EditText usernameText,passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameText=findViewById(R.id.mainActivity_nameTxt);
        passwordText=findViewById(R.id.mainActivity_passwordTxt);
        ParseUser parseUser=ParseUser.getCurrentUser();
        if(parseUser!=null){
            Intent intent=new Intent(MainActivity.this,FeedActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }

    }
    public void signin(View view){
        ParseUser.logInInBackground(usernameText.getText().toString(), passwordText.getText().toString(), new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
            if(e!=null){
                Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(MainActivity.this, "Welcome "+user.getUsername(), Toast.LENGTH_LONG).show();
                Intent intent=new Intent(MainActivity.this,FeedActivity.class);
                startActivity(intent);
                //intent
            }
            }
        });


    }
    public void signup(View view){
        ParseUser user = new ParseUser();
        user.setUsername(usernameText.getText().toString());
        user.setPassword(passwordText.getText().toString());
        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if(e!=null){
                    Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this,"User Created", Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(MainActivity.this,FeedActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
