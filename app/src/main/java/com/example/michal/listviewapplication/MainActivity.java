package com.example.michal.listviewapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et1,et2;
    Button btn;
    double mh,f;
    Switch sw;
    boolean tf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=(EditText) findViewById(R.id.et1);
        et2=(EditText) findViewById(R.id.et2);
        btn=(Button) findViewById(R.id.btn);
        sw=(Switch)findViewById(R.id.sw);
    }

    public void Next(View view) {
        String str1=et1.getText().toString();
        String str2=et2.getText().toString();
        if ((str1!="")||(str1!=".")||(str1!="-")||(str1!="-.")||(str1!=".-")||(str2!="")||(str2!=".")||(str2!="-")||(str2!="-.")||(str2!=".-")){
            f=Double.parseDouble(str1);
            mh=Double.parseDouble(str2);
            Intent t=new Intent (this,SecondActivity.class);
            t.putExtra("True/False",tf);
            t.putExtra("f",f);
            t.putExtra("mh",mh);
            startActivity(t);
        }
        else{
            Toast.makeText(this,"Wrong Input",Toast.LENGTH_SHORT).show();
        }
    }

    public void choice(View view) {
        if (sw.isChecked()) {
            tf = true;
        }
        else {
            tf = false;
        }
    }

    public void credit(View view) {
        Intent t=new Intent (this,ThirdActivity.class);
        startActivity(t);
    }
}
