package com.example.galery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public Button boards;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boards = findViewById(R.id.boards);
        boards.setOnClickListener(this::boardsView);

    }



    public void boardsView(View view) {
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
    }



}