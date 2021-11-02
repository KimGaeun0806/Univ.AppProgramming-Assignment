package org.techtown.firstassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText et_text = findViewById(R.id.et_text);
        et_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                TextView tv_preview = findViewById(R.id.tv_preview);
                tv_preview.setText(editable);
            }
        });

        SeekBar sb_size = findViewById(R.id.sb_size);
        sb_size.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                TextView tv_preview = findViewById(R.id.tv_preview);
                tv_preview.setTextSize(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        SeekBar sb_red = findViewById(R.id.sb_red);
        SeekBar sb_green = findViewById(R.id.sb_green);
        SeekBar sb_blue = findViewById(R.id.sb_blue);

        sb_red.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int red, boolean b) {
                int color = 0xFF000000 + red * 0x10000 + sb_green.getProgress() * 0x100 + sb_blue.getProgress();
                TextView tv_preview = findViewById(R.id.tv_preview);
                tv_preview.setTextColor(color);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sb_green.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int green, boolean b) {
                int color = 0xFF000000 + sb_red.getProgress() * 0x10000 + green * 0x100 + sb_blue.getProgress();
                TextView tv_preview = findViewById(R.id.tv_preview);
                tv_preview.setTextColor(color);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sb_blue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int blue, boolean b) {
                int color = 0xFF000000 + sb_red.getProgress() * 0x10000 + sb_green.getProgress()*0x100 + blue;
                TextView tv_preview = findViewById(R.id.tv_preview);
                tv_preview.setTextColor(color);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}