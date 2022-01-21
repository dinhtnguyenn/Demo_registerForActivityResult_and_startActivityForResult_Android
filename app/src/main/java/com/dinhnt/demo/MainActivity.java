package com.dinhnt.demo;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnInput = findViewById(R.id.btnInput);
        txtResult = findViewById(R.id.txtResult);

        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InputActivity.class);

                //sử dụng startActivityForResult
                // startActivityForResult(intent, 1);

                //sử dụng registerForActivityResult
                getData.launch(intent);
            }
        });
    }

    //sử dụng startActivityForResult
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == 2) {
            Bundle bundle = data.getExtras();
            String input1 = bundle.getString("input1");
            String input2 = bundle.getString("input2");
            txtResult.setText(input1 + " - " + input2);
        }
    }

    //sử dụng registerForActivityResult
    ActivityResultLauncher<Intent> getData = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == 2) {
                        Intent intent = result.getData();
                        Bundle bundle = intent.getExtras();
                        String input1 = bundle.getString("input1");
                        String input2 = bundle.getString("input2");
                        txtResult.setText(input1 + " - " + input2);
                    }
                }
            });

}