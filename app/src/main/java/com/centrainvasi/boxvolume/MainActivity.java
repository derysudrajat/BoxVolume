/*
 * Copyright (c) 2020.  this code was written by Dery Sudrajat
 */

package com.centrainvasi.boxvolume;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.et_width)
    EditText etWidth;
    @BindView(R.id.et_height)
    EditText etHeight;
    @BindView(R.id.et_length)
    EditText etLenght;
    @BindView(R.id.til_width)
    TextInputLayout tilWidht;
    @BindView(R.id.til_height)
    TextInputLayout tilHeight;
    @BindView(R.id.til_lenght)
    TextInputLayout tilLenght;
    @BindView(R.id.tv_result)
    TextView tvResult;
    @BindView(R.id.tv_formula)
    TextView tvFormula;
    @BindView(R.id.cv_result)
    CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        cardView.setVisibility(View.GONE);
    }

    @SuppressLint("SetTextI18n")
    @OnClick(R.id.button)
    void calculateVolume() {
        if (isValid()) {
            unableError();
            if (!etWidth.getText().toString().isEmpty()) {
                float w = Float.parseFloat(etWidth.getText().toString());
                float h = Float.parseFloat(etHeight.getText().toString());
                float l = Float.parseFloat(etLenght.getText().toString());
                float result = h * w * l;
                tvResult.setText(String.valueOf(result));
                tvFormula.setText(getString(R.string.v_w_h_l) + " " + w + "*" + h + "*" + l + " = " + result);
                cardView.setVisibility(View.VISIBLE);
            } else {
                cardView.setVisibility(View.GONE);
                tilWidht.setError(getString(R.string.width) + " " + getString(R.string.must_not_empty));
            }
        } else {
            cardView.setVisibility(View.GONE);
            if (etLenght.getText().toString().isEmpty()) {
                tilLenght.setError(getString(R.string.lenght) + " " + getString(R.string.must_not_empty));
            } else {
                tilLenght.setErrorEnabled(false);
            }
            if (etHeight.getText().toString().isEmpty()) {
                tilHeight.setError(getString(R.string.height) + " " + getString(R.string.must_not_empty));
            } else {
                tilHeight.setErrorEnabled(false);
            }
            if (etWidth.getText().toString().isEmpty()) {
                tilWidht.setError(getString(R.string.width) + " " + getString(R.string.must_not_empty));
            } else {
                tilWidht.setErrorEnabled(false);
            }
        }
    }

    private boolean isValid() {
        return !TextUtils.isEmpty(etHeight.getText())
                && !TextUtils.isEmpty(etHeight.getText())
                && !TextUtils.isEmpty(etLenght.getText());
    }

    private void unableError() {
        tilLenght.setErrorEnabled(false);
        tilHeight.setErrorEnabled(false);
        tilWidht.setErrorEnabled(false);
    }
}
