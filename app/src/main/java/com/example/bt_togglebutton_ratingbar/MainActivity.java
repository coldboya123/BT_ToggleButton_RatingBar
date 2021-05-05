package com.example.bt_togglebutton_ratingbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener, CompoundButton.OnCheckedChangeListener {

    SeekBar mSeekbarAlpha, mSeekbarRed, mSeekbarGreen, mSeekbarBlue;
    TextView txtHex, txtRBG;
    LinearLayout block;
    int a = 0, r = 0, b = 0, g = 0;
    ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

//        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        mSeekbarAlpha.setOnSeekBarChangeListener(this);
        mSeekbarRed.setOnSeekBarChangeListener(this);
        mSeekbarGreen.setOnSeekBarChangeListener(this);
        mSeekbarBlue.setOnSeekBarChangeListener(this);

        toggleButton.setOnCheckedChangeListener(this);

    }

    private void init() {
        mSeekbarAlpha = findViewById(R.id.seekbarAlpha);
        mSeekbarRed = findViewById(R.id.seekbarRed);
        mSeekbarGreen = findViewById(R.id.seekbarGreen);
        mSeekbarBlue = findViewById(R.id.seekbarBlue);
        txtHex = findViewById(R.id.txtHex);
        txtRBG = findViewById(R.id.txtRBG);
        block = findViewById(R.id.block);
        toggleButton = findViewById(R.id.togglebutton);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()) {
            case R.id.seekbarAlpha:
                a = progress;
                break;
            case R.id.seekbarRed:
                r = progress;
                break;
            case R.id.seekbarGreen:
                g = progress;
                break;
            case R.id.seekbarBlue:
                b = progress;
                break;
        }
        block.setBackgroundColor(Color.argb(a, r, g, b));
        txtHex.setText(String.format("HEX # %s %s %s %s",
                Integer.toHexString(a),
                Integer.toHexString(r),
                Integer.toHexString(g),
                Integer.toHexString(b))
        );
        txtRBG.setText(String.format("RGB %s %s %s %s", a, r, g, b));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        } else AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

    }
}