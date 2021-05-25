package com.example.cricscore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int runs = 0, wkts = 0, overs = 0, balls = 0, x = 0;

    public void plus(View view) {
        x = 1;
    }

    public void overs() {
        if (x == 0) {
            balls = balls + 1;
            if (balls == 6) {
                overs = overs + 1;
                balls = 0;
            }
        }
        x = 0;
        dispovers(overs, balls);
    }

    public void innings(View view) {
        disptarget(runs + 1);
        runs = 0;
        wkts = 0;
        overs = 0;
        balls = 0;
        dispruns(runs);
        dispwkts(wkts);
        dispovers(overs, balls);
        display("SECOND INNINGS");
    }

    public void out(View view) {
        wkts = wkts + 1;
        if (wkts < 10) {
            dispwkts(wkts);
            overs();

        } else if (wkts == 10) {
            innings(null);
        }
    }

    public void reset(View view) {
        runs = 0;
        wkts = 0;
        overs = 0;
        balls = 0;
        display("FIRST INNINGS");
        dispruns(runs);
        dispwkts(wkts);
        dispovers(overs, balls);
        dispclr("");
    }

    public void zero(View view) {
        runs = runs + 0;
        overs();
        dispruns(runs);
    }

    public void one(View view) {
        runs = runs + 1;
        overs();
        dispruns(runs);
    }

    public void two(View view) {
        runs = runs + 2;
        overs();
        dispruns(runs);
    }

    public void three(View view) {
        runs = runs + 3;
        overs();
        dispruns(runs);
    }

    public void four(View view) {
        runs = runs + 4;
        overs();
        dispruns(runs);
    }

    public void five(View view) {
        runs = runs + 5;
        overs();
        dispruns(runs);
    }

    public void six(View view) {
        runs = runs + 6;
        overs();
        dispruns(runs);
    }

    public void wide(View view) {
        runs = runs + 1;
        dispruns(runs);
    }

    public void noBall(View view) {
        runs = runs + 1;
        dispruns(runs);
    }

    private void dispruns(int number) {

        TextView quantityTextView = findViewById(R.id.runs);

        quantityTextView.setText("" + number);
    }

    private void dispwkts(int number) {

        TextView quantityTextView = findViewById(R.id.wickets);

        quantityTextView.setText("" + number);
    }

    private void display(String name) {

        TextView quantityTextView = findViewById(R.id.teamName);

        quantityTextView.setText("" + name);

    }

    private void disptarget(int number) {

        TextView quantityTextView = findViewById(R.id.target);

        quantityTextView.setText("TARGET is " + number);
    }

    private void dispclr(String number) {

        TextView quantityTextView = findViewById(R.id.target);

        quantityTextView.setText(" " + number);
    }

    private void dispovers(int over, int balls) {

        TextView quantityTextView = findViewById(R.id.overs);

        quantityTextView.setText(over + "." + balls);
    }
}
