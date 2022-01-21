package com.dinhnt.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        Button btnSend = findViewById(R.id.btnSend);
        EditText edtInput1 = findViewById(R.id.edtInput1);
        EditText edtInput2 = findViewById(R.id.edtInput2);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("input1", edtInput1.getText().toString());
                bundle.putString("input2", edtInput2.getText().toString());
                intent.putExtras(bundle);
                setResult(2, intent);
                finish();
            }
        });
    }
}