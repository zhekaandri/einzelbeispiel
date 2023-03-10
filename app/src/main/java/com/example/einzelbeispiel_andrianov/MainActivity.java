package com.example.einzelbeispiel_andrianov;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private TextView resultText;
    private EditText editText;
    private Button sendBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        TCPClient client = new TCPClient();

        resultText = findViewById(R.id.textViewResult);
        editText = findViewById(R.id.editTextNumber);
        sendBtn = findViewById(R.id.button5);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = editText.getText().toString();

                try {
                    String response = client.runServer(String.valueOf(Integer.parseInt(result)));
                    resultText.setText(response);
                } catch (Exception e){
                    throw new RuntimeException(e);
                }
            }
        });
    }
}