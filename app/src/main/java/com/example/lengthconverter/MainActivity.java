package com.example.lengthconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.text.InputType;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
//initializing array postion for spinner and default values
            int pos = 0;
            int lastValue = 0;

    void showToast(CharSequence msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Calling into methods
        Spinner spin = (Spinner)findViewById(R.id.units_spinner);
        Button btnConvert = (Button)findViewById(R.id.btnConvert);
        final EditText txtEntry = (EditText)findViewById(R.id.distancenum);
        txtEntry.setInputType(InputType.TYPE_CLASS_NUMBER);
        final TextView textView =(TextView)findViewById(R.id.Output);

        //Getting values of spinner elements from Array list in String.xml
        ArrayAdapter<CharSequence> adapter =ArrayAdapter.createFromResource(
                this, R.array.units_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(
                    AdapterView<?> parent, View view, int position, long id) {
                //showToast("Spinner2: position=" + position + " id=" + id);
                pos = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
              

            }
        });

        btnConvert.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (txtEntry.getText().toString().trim().length() > 0){
                    String textValue = txtEntry.getText().toString();
                    lastValue = Integer.parseInt(textValue);
                    double km, m, cm, feet, inches, yard;

                    if(pos==0){
                        km = lastValue * 1.60934;
                        showToast(lastValue + " miles = " +  km + " km(s)");
                        textView.setText( lastValue +" mile(s) = " + km + "  km(s)" );
                    }else if(pos==1){
                        m = lastValue * 1609.34;
                        showToast(lastValue + " miles = " +  m + " m(s)");
                        textView.setText( lastValue +" mile(s) = " + m + " m(s)" );
                    }else if(pos==2){
                        cm = lastValue * 160934;
                        showToast(lastValue + " miles = " +  cm + " cm(s)");
                        textView.setText( lastValue +" mile(s) = " + cm + " cm(s)" );
                    }else if(pos==3){
                        feet = lastValue * 5280;
                        showToast(lastValue + " miles = " +  feet + " feet");
                        textView.setText( lastValue +" mile(s) = " + feet + " feet" );
                    }else if(pos==4){
                        inches = lastValue * 63360;
                        showToast(lastValue + " miles = " + inches + "inch(s)");
                        textView.setText( lastValue +" mile(s) = " + inches + " inch(s)" );
                    }else if(pos==5){
                        yard = lastValue * 1760;
                        showToast(lastValue + "miles = " +yard + "yard");
                        textView.setText ( lastValue +" mile(s) = " + yard + " yard" );
                    }

                }
                else{
                    showToast("Please Enter The Value");

                }

            }
        });
    }
}