package com.example.android_lab1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class NameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_name);
        Intent data = getIntent();
        String hello = data.getStringExtra("hello");
        TextView helloText = findViewById(R.id.helloText);
        helloText.setText(hello);
        Button button = findViewById(R.id.bOk);
        Intent intent = new Intent();
        button.setOnClickListener(v -> {
            EditText nameInput = findViewById(R.id.nameInput);
            String finalText = hello + ", " + nameInput.getText().toString() + "!";
            intent.putExtra("finalText", finalText);
            setResult(RESULT_OK, intent);
            finish();
        });
    }
}