package com.yasinakca.runablehandler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button starButton;
    int count;
    Runnable runnable;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        starButton = findViewById(R.id.startButton);
        count = 0;
    }

    public void startClicked(View view) {
        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {
                textView.setText("Time: " + count);
                count++;
                textView.setText("Time: " + count);
                handler.postDelayed(runnable,1000);
            }
        };

        handler.post(runnable);

        starButton.setEnabled(false);
    }

    public void stopClicked(View view) {
        starButton.setEnabled(true);
        handler.removeCallbacks(runnable);
        count = 0;
        textView.setText("Time: 0");
    }
}
