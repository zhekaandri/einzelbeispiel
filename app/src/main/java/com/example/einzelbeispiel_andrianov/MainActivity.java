package com.example.einzelbeispiel_andrianov;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView resultText;
    private EditText editText;
    private Button sendBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        resultText = findViewById(R.id.textViewResult);
        editText = findViewById(R.id.editTextNumber);
        sendBtn = findViewById(R.id.button5);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                int num1 = Integer.parseInt(hint_1.getText().toString());
//                resultText.setText(String.valueOf(num1));
//                System.out.println("Clicked Button");
                TCPClient client = new TCPClient();
                try {
                    client
                }
            }
        });

    }
}