package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.String;

public class MainActivity extends AppCompatActivity {

    String[] arrayResult;
    Double resultado=0.0;
    String ope="";
    boolean flag=false;
    TextView textField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textField = (TextView) findViewById(R.id.textField);
    }


    public void pulsarCero(View view) {
        textField.setText(textField.getText()+ "0");
    }
    public void pulsarUno(View view) {
        textField.setText(textField.getText()+ "1");
    }
    public void pulsarDos(View view) {
        textField.setText(textField.getText()+ "2");
    }
    public void pulsarTres(View view) {
        textField.setText(textField.getText()+ "3");
    }
    public void pulsarCuatro(View view) {
        textField.setText(textField.getText()+ "4");
    }
    public void pulsarCinco(View view) {
        textField.setText(textField.getText()+ "5");
    }
    public void pulsarSeis(View view) {
        textField.setText(textField.getText()+ "6");
    }
    public void pulsarSiete(View view) {
        textField.setText(textField.getText()+ "7");
    }
    public void pulsarOcho(View view) {
        textField.setText(textField.getText()+ "8");
    }
    public void pulsarNueve(View view) {
        textField.setText(textField.getText()+ "9");
    }

    public void pulsarSuma(View view) {
        if(textField.getText().equals("")){}
        else{
            if(((textField.getText()).charAt(0)=='-')&& ope.equals("-")){
                textField.setText(textField.getText()+ "+");
                ope="\\+";
            }else if(ope.equals("")){
                textField.setText(textField.getText()+ "+");
                ope="\\+";
            }
        }

    }



    public void pulsarRestar(View view) {
        if(ope.equals("")){
            textField.setText(textField.getText()+ "-");
            ope="-";
        }else if(((textField.getText()).charAt(0)== '-')&& ope.equals("-") && flag==false){
            textField.setText(textField.getText()+ "-");
            ope="-";
            flag=true; // PARA EVITAR PODER AÑADIR MAS ' - '
        }
    }


    public void pulsarMultiplicacion(View view) {
        if(textField.getText().equals("")){}
        else{
            if(((textField.getText()).charAt(0)== '-')&& ope.equals("-")){
                textField.setText(textField.getText()+ "x");
                ope="x";
            }else if(ope.equals("")){
                textField.setText(textField.getText()+ "x");
                ope="x";
            }
        }
    }


    public void pulsarDivision(View view) {
        if(textField.getText().equals("")){}
        else{
            if(((textField.getText()).charAt(0)== '-')&& ope.equals("-")){
                textField.setText(textField.getText()+ "÷");
                ope="÷";
            }else if(ope.equals("")){
                textField.setText(textField.getText()+ "÷");
                ope="÷";
            }
        }
    }


    public void pulsarResultado(View view) {
        arrayResult = textField.getText().toString().split(ope);
        if(flag==true){ // SI ESTA TRUE ES PORQUE VAMOS A REALIZAR UNA RESTA CON UN NEGATIVO
            resultado = (Double.parseDouble(arrayResult[1])*-1)-Double.parseDouble(arrayResult[2]);
        }else{
            switch(ope){
                case "\\+": resultado = Double.parseDouble(arrayResult[0])+Double.parseDouble(arrayResult[1]);break;
                case "-": resultado = Double.parseDouble(arrayResult[0])-Double.parseDouble(arrayResult[1]);break;
                case "x": resultado = Double.parseDouble(arrayResult[0])*Double.parseDouble(arrayResult[1]);break;
                case "÷": resultado = Double.parseDouble(arrayResult[0])/Double.parseDouble(arrayResult[1]);break;
            }
        }

        String numAux="";
        int resultadoAux=0;
        String[] arrayAux;
        numAux = resultado+"";
        arrayAux=numAux.split("\\.");

        if(arrayAux[1].equals("0")){
            resultadoAux = Integer.parseInt(arrayAux[0]);
            textField.setText(resultadoAux+"");
        }else{
            textField.setText(resultado+"");
        }

        if(textField.getText().charAt(0)=='-'){ // EL RESULTADO SE VA A QUEDAR EN NEGATIVO ASI QUE DEJAMOS EL OPERADOR EN NEGATIVO
            ope="-";
        }else{
            ope="";
        }
        flag=false;
    }


    public void pulsarComa(View view) {
        textField.setText(textField.getText()+ ".");
    }

    // EL BOTON BORRAR CAPTURA LO ESCRITO EN PANTALLA SI ESTA VACIO NO HACE NADA
    // SI NO, CREA UN NUEVO VALOR DESDE LA POSICION 0 HASTA LA PENULTIMA Y LO
    // ESCRIBE EN PANTALLA.


    public void pulsarBorrar(View view) {
        if(textField.getText().equals("")){}
        else{
            textField.setText(textField.getText().toString().substring(0,textField.getText().length()-1));
        }

    }

    // RESTAURA LA PANTALLA, LA VARIABLE DEL OPERADOR Y EL RESULTADO.

    public void pulsarVaciar(View view) {
        textField.setText("");
        ope="";
        resultado=0.0;
        flag=false;
    }



}
