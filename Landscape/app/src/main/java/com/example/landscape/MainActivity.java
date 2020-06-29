package com.example.landscape;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    private TextView Screen;
    private Button seven, eight, nine, four, five, six, three, two, one, zero, C, div, multiply, add, minus, equal;
    private String input, answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("lifecycle", "onCreate invoked");
        Screen = findViewById(R.id.screen);
        C = findViewById(R.id.C);
        div = findViewById(R.id.div);
        multiply = findViewById(R.id.multiply);
        minus = findViewById(R.id.minus);
        add = findViewById(R.id.add);
        nine = findViewById(R.id.nine);
        eight = findViewById(R.id.eight);
        seven = findViewById(R.id.seven);
        six = findViewById(R.id.six);
        five = findViewById(R.id.five);
        four = findViewById(R.id.four);
        three = findViewById(R.id.three);
        two = findViewById(R.id.two);
        one = findViewById(R.id.one);
        zero = findViewById(R.id.zero);
        equal = findViewById(R.id.equal);
    }
    public void ButtonClick(View view) {
        Button button = (Button) view;
        String data = button.getText().toString();
        switch (data) {
            case "C":
                input = "";
                break;
            case "x":
                Solve();
                input += "x";
                break;
            case "/":
                Solve();
                input += "/";
                break;
            case "=":
                Solve();
                answer = input;
                break;
            case "<--":
                String newText = input.substring(0, input.length() - 1);
                input = newText;
                break;
            default:
                if (input == null) {
                    input = "";
                }
                if (data.equals("+") || data.equals("-") || data.equals("/")) {
                    Solve();
                }
                input += data;
        }
        Screen.setText(input);
    }
    private  void Solve(){
        if (input.split("\\*").length == 2) {
            String number[] = input.split("\\*");
            try {
                double multiply = Double.parseDouble(number[0]) * Double.parseDouble(number[1]);
                input = multiply+"";
            }
            catch (Exception e) {
            }
        } else if (input.split("\\/").length == 2) {
            String number[] = input.split("\\/");
            try {
                double div = Double.parseDouble(number[0]) / Double.parseDouble(number[1]);
                input = div+"";
            } catch (Exception e) {

            }
        } else if (input.split("\\+").length == 2) {
            String number[] = input.split("\\+");
            try {
                double add = (Double.parseDouble(number[0]) + Double.parseDouble(number[1]));
                input = add+"";
            } catch (Exception e) {
            }
        } else if (input.split("\\-").length>1) {
            String number[] = input.split("\\-");
            if (number[0]=="" && number.length==2) {
                number[0] = 0+"";
            }
            try {
                double minus =0;
                if(number.length==2){
                    minus = Double.parseDouble(number[0]) - Double.parseDouble(number[1]);
                }
                else if(number.length==3){
                    minus= -Double.parseDouble(number[1]) - Double.parseDouble(number[2]);
                }
                input =minus+"";
            }
            catch (Exception e) {
            }
        }
        String n[]=input.split("\\.");
        if(n.length>1){
            if(n[1].equals("0")){
                input=n[0];
            }
        }
        Screen.setText(input);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifecycle", "onStart invoked");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifecycle", "onResume invoked");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("lifecycle", "onPause invoked");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifecycle", "onStop invoked");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lifecycle", "onRestart invoked");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecycle", "onDestroy invoked");
    }

}