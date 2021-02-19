package com.example.covid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int r1, r2, r3, r4, edad, resultado;
    String r, e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioButton rbM = (RadioButton) findViewById(R.id.RadiobutomSexoM);
        RadioButton rbH = (RadioButton) findViewById(R.id.RadiobutomSexoH);

        EditText editTextEdad = (EditText) findViewById(R.id.edad);

        RadioButton rbPB = (RadioButton) findViewById(R.id.RbBajoP);
        RadioButton rbPN = (RadioButton) findViewById(R.id.RbPesoN);
        RadioButton rbSP = (RadioButton) findViewById(R.id.RbSobrepeso);
        RadioButton rbOb = (RadioButton) findViewById(R.id.RbObesidad);

        CheckBox checkHiper = (CheckBox) findViewById(R.id.checkPadecimiento1);
        CheckBox checkDiab = (CheckBox) findViewById(R.id.checkPadecimiento2);
        CheckBox checkPulm = (CheckBox) findViewById(R.id.checkPadecimiento3);
        CheckBox checkRenal = (CheckBox) findViewById(R.id.checkPadecimiento4);
        CheckBox checkInmuno = (CheckBox) findViewById(R.id.checkPadecimiento5);


        Button bResul = (Button) findViewById(R.id.btnCalcular);
        TextView textViewResul = (TextView) findViewById(R.id.textViewResul);

        RadioGroup rg1 = (RadioGroup) findViewById(R.id.groupRadio);
        RadioGroup rg2 = (RadioGroup) findViewById(R.id.groupRadioPeso);

        rbH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        bResul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e = editTextEdad.getText().toString();
                edad = Integer.parseInt(e);

                if(rbH.isChecked() == true){
                    r1 = 10;
                }
                if(rbM.isChecked() == true){
                    r1 = 20;
                }

                if((edad >= 0) && (edad <= 20) ){
                    r2 = 20;
                }
                if((edad >= 21) && (edad <= 40) ){
                    r2 = 30;
                }
                if((edad >= 41) && (edad <= 60) ){
                    r2 = 40;
                }
                if((edad >= 61) && (edad <= 80) ){
                    r2 = 50;
                }
                if(edad >= 81){
                    r2 = 60;
                }


                if(rbPB.isChecked() == true){
                    r3 = 10;
                }
                if(rbPN.isChecked() == true){
                    r3 = 5;
                }
                if(rbSP.isChecked() == true){
                    r3 = 25;
                }
                if(rbOb.isChecked() == true){
                    r3 = 30;
                }

                if(checkHiper.isChecked() == true){
                    r4 += 40;
                }
                if(checkDiab.isChecked() == true){
                    r4 += 20;
                }
                if(checkPulm.isChecked() == true){
                    r4 += 40;
                }
                if(checkRenal.isChecked() == true){
                    r4 += 30;
                }
                if(checkInmuno.isChecked() == true){
                    r4 += 40;
                }


                resultado = r1 +  r2 + r3 + r4;
                //r = String.valueOf(resultado);
                //textViewResul.setText(r);

                if((resultado >= 0) && (resultado <= 60)){
                    //Se crea objeto
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    //Titulo
                    builder.setTitle("El riesgo es:");
                    //Mensaje
                    builder.setMessage("BAJO \nPero debes de tomar las preucaciones adecuedas");
                    //Texto del botón
                    builder.setPositiveButton("Aceptar", null);
                    //Se crea
                    AlertDialog dialog = builder.create();
                    //Se muestra
                    dialog.show();
                }
                if((resultado >= 61) && (resultado <= 120)){

                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("El riesgo es:");
                    builder.setMessage("MEDIO \nDebes de evitar salir");
                    builder.setPositiveButton("Aceptar", null);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
                if((resultado >= 121) && (resultado <= 180)){

                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("El riesgo es:");
                    builder.setMessage("ALTO \nQuedate en casa y toma las medidas de sanidad");
                    builder.setPositiveButton("Aceptar", null);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
                if(resultado >= 181){

                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("El riesgo es:");
                    builder.setMessage("¡MUY ALTO! \nNo debes de salir, eres un grupo vulnerable");
                    builder.setPositiveButton("Aceptar", null);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
                rg1.clearCheck();
                rg2.clearCheck();
                editTextEdad.setText("");
                checkHiper.setChecked(false);
                checkDiab.setChecked(false);
                checkPulm.setChecked(false);
                checkInmuno.setChecked(false);
                checkRenal.setChecked(false);

                r1 = 0;
                r2 = 0;
                r3 = 0;
                r4 = 0;
                resultado = 0;
            }
        });

    }
}