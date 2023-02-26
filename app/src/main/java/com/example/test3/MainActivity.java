package com.example.test3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayoutStates;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText userInput; //create private variables so it can't be access outside class
    private Button button;

    private TextView textView;
    private String TEXT_CONTENTS;

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString(TEXT_CONTENTS,textView.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("MAIN","onRestoreInstanceState()");
        String savedState = savedInstanceState.getString(TEXT_CONTENTS);
        textView.setText(savedState);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Link the Java file to the XML
        userInput = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
        textView = (TextView)findViewById(R.id.textView);


        //set Text
       // userInput.setText("Hello to Android programming");

        //Button onClickListener
        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {


                //wrap_context
                //match_parent it will take entire horizontal width
                //Get the text from the editText

                //convert the data to a string format
               String message = "\n" + userInput.getText().toString();
                //append or replace the text with the data

                textView.append(message);
                userInput.setText(" ");
                Log.d("Main Activity","onCreate Button is clicked.");
                  }
        });
    }


}