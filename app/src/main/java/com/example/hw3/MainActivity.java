package com.example.hw3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String Name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button submit=(Button)findViewById(R.id.submit);
        submit.setOnClickListener(Sayhello);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    private static final int ACTIVITY_SET_NAME = 1;
    private OnClickListener Sayhello=new OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent();
            intent.setClass(MainActivity.this,
                    Main2Activity.class);
            startActivityForResult(intent, ACTIVITY_SET_NAME);
        }
    };

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode, Intent intent){
        if(intent==null)
        {
            return;
        }
        super.onActivityResult(requestCode, resultCode, intent);
        switch(requestCode) {
            case ACTIVITY_SET_NAME:
                Name = intent.getStringExtra("Key_Name");
                Toast.makeText(MainActivity.this,
                        oput(Name),
                        Toast.LENGTH_LONG).show();
                break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if(id==R.id.action_web)
        {
            Uri uri=Uri.parse("http://www.google.com.tw");
            Intent intent=new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(uri);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private String oput(String input_str){
        String result=new String();
        if(input_str==null)
        {
            return input_str;
        }
        result="Hello "+input_str;
        return  result;
    }
}
