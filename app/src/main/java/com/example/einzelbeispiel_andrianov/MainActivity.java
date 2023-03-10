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
    private TextView resultTextQuer;
    private EditText editText;
    private Button sendBtn;
    private Button calculateBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        TCPClient client = new TCPClient();

        editText = findViewById(R.id.editTextNumber);
        resultText = findViewById(R.id.textViewResult);
        sendBtn = findViewById(R.id.sendBtn);
        calculateBtn = findViewById(R.id.calculateBtn);
        resultTextQuer = findViewById(R.id.resultQuerText);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = editText.getText().toString();

                try {
                    String response = client.run(String.valueOf(Integer.parseInt(result)));
                    resultText.setText(response);
                    System.out.println("Response: " + response);
                } catch (Exception e){
                    throw new RuntimeException(e);
                }
            }
        });

        calculateBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String resultQuer = editText.getText().toString();

                try {
                    String querResponse = client.calculateQuerSum(String.valueOf(Integer.parseInt(resultQuer)));
                    resultTextQuer.setText(querResponse);
                } catch (Exception e){
                    throw new RuntimeException(e);
                }
            }
        });
    }
}