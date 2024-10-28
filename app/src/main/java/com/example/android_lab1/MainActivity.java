package com.example.android_lab1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Button bOk = findViewById(R.id.bOk);
        Intent intent = new Intent(this, NameActivity.class);
        bOk.setOnClickListener(v -> {
            EditText helloInput = findViewById(R.id.helloInput);
            intent.putExtra("hello", helloInput.getText().toString());
            startActivityForResult(intent, 1);
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String finalText = data.getStringExtra("finalText");
                TextView textView = findViewById(R.id.finalText);
                textView.setText(finalText);
            }
        }
    }
}