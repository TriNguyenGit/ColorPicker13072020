package com.example.colorpicker13072020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button mBtn;
    TextView mTv;
    ProgressBar mProgress;
    CountDownTimer mCountDownTimer;
    boolean mIsloading = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtn = findViewById(R.id.buttonprogress);
        mTv = findViewById(R.id.textview);
        mProgress = findViewById(R.id.progressbar);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!mIsloading){
                    showView(mTv);
                    showView(mProgress);
                    mIsloading = true;
                    mCountDownTimer = new CountDownTimer(4200,1000) {
                        @Override
                        public void onTick(long l) {
                            mTv.setText(String.format("Time Loading : %ds",l / 1000));
                        }

                        @Override
                        public void onFinish() {
                                hideView(mProgress);
                                hideView(mTv);
                                mIsloading =false;
                            Toast.makeText(MainActivity.this,"Loading finish",Toast.LENGTH_SHORT).show();
                        }
                    };
                    mCountDownTimer.start();
                }
            }
        });
    }

    public void showView(View v) {
        v.setVisibility(View.VISIBLE);
    }
    public void hideView(View v) {
        v.setVisibility(View.INVISIBLE);
    }
}