package com.example.arithmetic;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView tvOutput1,tvOutput2,tvOutput;
    private EditText et1,et2;
    private Button btn1,btn2;
    AlertDialog.Builder builder;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvOutput=findViewById(R.id.tvOutput);
        tvOutput1=findViewById(R.id.tvOutput1);
        tvOutput2=findViewById(R.id.tvOutput2);
        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);

        builder = new AlertDialog.Builder(this);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                builder.setMessage("do you want to close this application?")
                        .setCancelable(false)
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                               finish();
                                Toast.makeText(getApplicationContext(),"you clicked yes", Toast.LENGTH_SHORT).show();

                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                Toast.makeText(getApplicationContext(),"you clicked no", Toast.LENGTH_SHORT).show();

                            }
                        });
                AlertDialog alert = builder.create();
                alert.setTitle("My Title");
                alert.show();

            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double result;
                double first=Double.parseDouble(et1.getText().toString());
                double second=Double.parseDouble(et2.getText().toString());
                result=first+second;
                tvOutput.setText(Double.toString(result));
            }
        });


    }
}
