package com.example.studentdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    Button button_one;
    Button button_two;
    Button button_three;

    private RadioButton radioButton1, radioButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_one = findViewById(R.id.button_one);

        button_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button_one:
                        Intent intent = new Intent (MainActivity.this, studtoken.class);
                        startActivity(intent);
                        break;
                    default:
                        break;

                }
            }
        });

        button_two = findViewById(R.id.button_two);

        button_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button_two:
                        Intent intent = new Intent (MainActivity.this, timetable.class);
                        startActivity(intent);
                        break;
                    default:
                        break;

                }
            }
        });
        button_three = findViewById(R.id.button_three);

        button_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button_three:
                        Intent intent = new Intent (MainActivity.this, qrcodeact.class);
                        startActivity(intent);
                        break;
                    default:
                        break;

                }
            }
        });

        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);

        radioButton1.setChecked(Update("Shayth_one"));
        radioButton2.setChecked(Update("Shayth_two"));

        radioButton1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean one_isChecked) {
                SaveIntoSharedPrefs("Shayth_one", one_isChecked);
            }
        });

        radioButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean two_isChecked) {
                SaveIntoSharedPrefs("Shayth_two", two_isChecked);
            }
        });
    }
    private void SaveIntoSharedPrefs( String key, boolean value){
        SharedPreferences sp = getSharedPreferences( "Shayth",MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }
    private boolean Update(String key){

        SharedPreferences sp = getSharedPreferences("Shayth", MODE_PRIVATE);
        return sp.getBoolean(key, false);
    }

}