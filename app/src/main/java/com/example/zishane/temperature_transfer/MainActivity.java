package com.example.zishane.temperature_transfer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements RadioGroup.OnCheckedChangeListener, TextWatcher {

    private RadioGroup rgType;
    private EditText edvalue;
    private TextView tvdegF;
    private TextView tvdegC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgType = (RadioGroup) findViewById(R.id.rg_Type);
        edvalue = (EditText) findViewById(R.id.et_Value);
        tvdegF = (TextView) findViewById(R.id.tv_degF);
        tvdegC = (TextView) findViewById(R.id.tv_degC);

        rgType.setOnCheckedChangeListener(this);
        edvalue.addTextChangedListener(this);
    }

    protected void calc() {
//        double f, c;
//        if (rgType.getCheckedRadioButtonId() == R.id.rb_unitF){
//            f = Double.parseDouble(edvalue.getText().toString());
//            c = (f - 32) * 5 / 9;
//        }else {
//            c = Double.parseDouble(edvalue.getText().toString());
//            f = c * 9 / 5 + 32;
//        }
//        tvdegF.setText(String.format("%.1f"), f) + getResources().getString(R.string.charF);
//        tvdegC.setText(String.format("%.1f"), c) + getResources().getString(R.string.charC);
        double value = Float.parseFloat(edvalue.getText().toString());

        switch (rgType.getCheckedRadioButtonId()){
            case R.id.rb_unitC:
                tvdegC.setText(String.format("%.1f", value) + getResources().getString(R.string.charC));

                double degF = value * 9 / 5 + 32;
                tvdegF.setText(String.format("%.1f", degF)+ getResources().getString(R.string.charF));
                break;

            case R.id.rb_unitF:
                double degC = (value - 32) * 5 / 9;
                tvdegC.setText(String.format("%.1f", degC) + getResources().getString(R.string.charC));

                tvdegF.setText(String.format("%.1f", value) + getResources().getString(R.string.charF));
                break;
            }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        //RadioButton CheckedChanged
        try {
            calc();
        }
        catch (Exception e) {}
    }



    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        //EditText TextChanged
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        //EditText TextChanged
    }

    @Override
    public void afterTextChanged(Editable s) {
        //EditText TextChanged
        try {
            calc();
        }
        catch (Exception e) {}
    }
}
