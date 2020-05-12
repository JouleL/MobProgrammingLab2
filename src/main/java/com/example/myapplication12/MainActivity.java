package com.example.myapplication12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Vector;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button1;
    Button button2;
    Button a;
    TextView scroll;
    TextView popout;
    ViewGroup list_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a = (Button)findViewById(R.id.animation);

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotate);
                animation.setDuration(60);
                animation.setFillAfter(true);
                a.startAnimation(animation);
            }
        });



        list_ = (ViewGroup)findViewById(R.id.LinearLayout);

        LayoutInflater l = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        Vector<String> strings = new Vector<String>();
        for(int i=0;i<10;++i)
        {
            strings.add("Item # " + i);
        }

        for(String s : strings)
        {
            View item = l.inflate( R.layout.list_item, null);
            ((TextView)item.findViewById(R.id.textForList)).setText(s);
            list_.addView(item);
        }

        String [] text = {"Yatsynych", "Taras", "KN-305"};
        scroll = findViewById(R.id.textForList);

        scroll.setText("");
        for (String name : text){
            scroll.append(name + "\n");
        }

        editText = (EditText) findViewById(R.id.editText);
        button1 = (Button) findViewById(R.id.send);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),editText.getText(),Toast.LENGTH_SHORT).show();
            }
        });

        popout = (TextView) findViewById(R.id.popOut);
        button2 = (Button) findViewById(R.id.change);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popout.setText("Hello World!");
                button2.setBackgroundColor(Color.parseColor("#00ff00"));
            }
        });
    }
}
