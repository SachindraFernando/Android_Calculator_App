package com.androidsachi.cal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText idEditText;
    Button btnEk, btnAdu, btnBedima, btnGuna;
    Double x = 0.0;
    Button getBtnValue;
    int clicked_btn = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getBtnValue = (Button) findViewById(R.id.btnGetResults);
        getBtnValue.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(clicked_btn==1) {
                    if(TextUtils.isEmpty(idEditText.getText().toString())) {
                        Double value = Double.parseDouble(idEditText.getText().toString());
                        x+= value;
                        idEditText.setText(String.valueOf(x));
                        x = 0.0;
                    }
                    else {
                        idEditText.setText(String.valueOf(x));
                        x = 0.0;
                    }
                }
            }
        });
        idEditText = (EditText) findViewById(R.id.editTxtnumber);
        btnEk = (Button) findViewById(R.id.btnEkathukirima);
        btnAdu = (Button) findViewById(R.id.btnAdukirima);
        btnBedima = (Button) findViewById(R.id.btnBedima);
        btnGuna = (Button) findViewById(R.id.btnGunakirima);
        btnEk.setOnCLickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(!TextUtils.isEmpty(idEditText.getText().toString()))
                {
                //code
                    cal(type:"+", idEditText.getText().toString());
                }
                else
                {
                    Toast.makeText(context: MainActivity.this, text:"No empty number allowed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    void cal(String type, String number)
    {
    if(type.equals("+"))
    {
        clicked_btn = 1;
        Double numberDouble = Double.parseDouble(number);
        x = x + numberDouble;
        Toast.makeText( context:MainActivity.this, String.valueOf(x), Toast.LENGTH_SHORT).show();
        idEditText.setText("");
    }
    }

}
