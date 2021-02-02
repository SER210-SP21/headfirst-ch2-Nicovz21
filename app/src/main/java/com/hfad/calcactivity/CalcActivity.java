package com.hfad.calcactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class CalcActivity extends AppCompatActivity {
    EditText input1, input2;
    TextView res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button add = (Button) findViewById(R.id.addition);
        Button sub = (Button) findViewById(R.id.subtraction);
        input1 = (EditText) findViewById(R.id.input1);
        input2 = (EditText) findViewById(R.id.input2);
        res =  (TextView) findViewById(R.id.result);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setSelection(0,false);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String op = (String) adapterView.getItemAtPosition(i);
                if(op.equals("*"))
                    performOp('*');
                else
                    performOp('/');
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOp('+');
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOp('-');
            }
        });
    }
    private void performOp(char op){
        Log.v("Debug","method performOp called");
        if((input1.getText() != null) && (input2.getText() != null) ){

            //read from inout1 and input2
            double num1 = Double.valueOf(input1.getText().toString());
            double num2 = Double.valueOf(input2.getText().toString());

            Log.v("Debug", "num 1 " + num1 + "num 2" + num2);
            double result = 0;

                    //perform operation the two values

            switch(op){
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;

            }
            //update the volume of text in the result textview
            res.setText(Double.toHexString(result));
        }
    }

}