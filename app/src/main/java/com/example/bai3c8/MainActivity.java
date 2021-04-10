package com.example.bai3c8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtPhone;
    Button btnSave;
    ListView lvBand;
    ArrayAdapter<String> adapterBand;
    public static final ArrayList<String> listBand = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listBand.add(edtPhone.getText().toString());
                adapterBand.add(edtPhone.getText().toString());
                edtPhone.setText("");
                edtPhone.requestFocus();

            }
        });
    }

    private void addControls() {
        edtPhone = findViewById(R.id.edtPhone);
        btnSave = findViewById(R.id.btnSave);
        lvBand = findViewById(R.id.lvBand);
        adapterBand = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1);
        lvBand.setAdapter(adapterBand);
    }

    @Override
    protected void onPause() {
        super.onPause();
        XuLyLuuSoBiChan();
    }

    @Override
    protected void onResume() {
        super.onResume();
        XuLyThemSoBiChan();
    }

    void XuLyLuuSoBiChan()
    {
        SharedPreferences preferences = getSharedPreferences("b3c8",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        for(int i=0;i<listBand.size();i++)
        {
            editor.putInt("sizeList",listBand.size());
            editor.putString("f"+i,listBand.get(i));
        }
        editor.commit();
    }
    void XuLyThemSoBiChan()
    {
        SharedPreferences preferences = getSharedPreferences("b3c8",MODE_PRIVATE);

        for(int i=0;i<preferences.getInt("sizeList",0);i++)
        {
            listBand.add(preferences.getString("f"+i,""));
        }

        adapterBand.clear();
        for(int i=0;i<listBand.size();i++)
        {
            adapterBand.add(preferences.getString("f"+i,""));
        }
    }



}