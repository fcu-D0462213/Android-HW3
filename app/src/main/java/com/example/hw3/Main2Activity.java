package com.example.hw3;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    private TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        result=(TextView)findViewById(R.id.iName);
        Button back=(Button)findViewById(R.id.submit2);
        back.setOnClickListener(SayH);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }
    private OnClickListener SayH=new OnClickListener() {
        @Override
        public void onClick(View v) {
            String input=result.getText().toString();

            Intent intent=new Intent();
            intent.putExtra("Key_Name",input);
            setResult(RESULT_OK,intent);
            finish();
        }
    };
    private String oput(String input_str){
        String result=new String();
        if(input_str==null)
        {
            return input_str;
        }
        result="Hello "+input_str;
        Toast.makeText(Main2Activity.this,
                oput(result),
                Toast.LENGTH_SHORT).show();
        return  result;
    }

}
