package com.example.flavioalison_alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText precoALcool, precoGasolina;
    TextView Resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        precoALcool = findViewById(R.id.pa);
        precoGasolina = findViewById(R.id.pg);
        Resultado = findViewById(R.id.R);


    }

    public void calcular(View view) {

        validarCampos();

        if (validarCampos()) {

            Double valorGasolina = Double.parseDouble(precoGasolina.getText().toString());
            Double valorAlcool = Double.parseDouble(precoALcool.getText().toString());
            if (valorAlcool > 0.7 * valorGasolina) {
                Resultado.setText("É melhor utilizar gasolina");
            } else {
                Resultado.setText(("É melhor utilizar Álcool"));
            }

        } else {
            Resultado.setText("Dados os campos corretamente");

        }

    }

    public boolean validarCampos() {
        boolean r1, r2 = false;

        if (!TextUtils.isEmpty(precoALcool.getText().toString())) {
            Double vAlcool = Double.parseDouble(precoALcool.getText().toString());
            if (vAlcool == 0) {
                r1 = false;
                precoALcool.setError("Preencher Gasolina corretamente");
                precoALcool.requestFocus();
            } else {
                r1 = true;
            }
        } else {
            r1 = false;
            precoALcool.setError("Preencher Gasolina corretamente");
            precoALcool.requestFocus();
        }

        if (!TextUtils.isEmpty(precoGasolina.getText().toString())) {
            Double vGasolina = Double.parseDouble(precoGasolina.getText().toString());
            if (vGasolina == 0) {
                r2 = false;
                precoGasolina.setError("Preencher Gasolina corretamente");
                precoGasolina.requestFocus();
            } else {
                r2 = true;
            }
        } else {
            r2 = false;
            precoGasolina.setError("Preencher Gasolina corretamente");
            precoGasolina.requestFocus();
        }

        return r1 && r2;
    }
}

//Flavio Alison Simas Lopes