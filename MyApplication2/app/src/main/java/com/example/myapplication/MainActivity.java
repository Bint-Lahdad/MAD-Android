package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String TAG=MainActivity.class.getSimpleName();

    private EditText editTextSampleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"method onCreate");
        editTextSampleText=(EditText) findViewById(R.id.editTextSampleText);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"method onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"method onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"method onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"method onPause");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG,"method onSaveInstanceState");
        outState.putString("samplekey",editTextSampleText.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG,"method onRestoreInstanceState");
        editTextSampleText.setText(savedInstanceState.getString("samplekey"));
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"method onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"method onDestroy");
    }
}