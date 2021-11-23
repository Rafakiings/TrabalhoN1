package com.example.n1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Calculadora extends AppCompatActivity implements View.OnClickListener {

    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6,
            btn7, btn8, btn9, btnLimpar, btnPonto, btnDiv,
            btnMulti, btnSoma, btnSub, btnIgual;
    private TextView txtExpressao, txtResult;
    private ImageView backspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        IniciarCommponentes();

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnSoma.setOnClickListener(this);
        btnMulti.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnPonto.setOnClickListener(this);

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtExpressao.setText("");
                txtResult.setText("");
            }
        });

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView op = findViewById(R.id.txtexp);
                String string = op.getText().toString();

                if(!string.isEmpty()){
                    byte var0 = 0;
                    int var1 = string.length()-1;
                    String txtOp = string.substring(var0,var1);
                    op.setText(txtOp);
                }
                txtResult.setText("");
            }
        });

        btnIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Expression expressao = new ExpressionBuilder(txtExpressao.getText().toString()).build();
                    double resultado = expressao.evaluate();
                    long longResult = (long) resultado;

                    if (resultado == (double) longResult) {
                        txtResult.setText((CharSequence) String.valueOf(longResult));
                    } else {
                        txtResult.setText((CharSequence) String.valueOf(resultado));
                    }
                }catch (Exception e){

                }
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn0:
                AddOp("0", true);
                break;

            case R.id.btn1:
                AddOp("1", true);
                break;

            case R.id.btn2:
                AddOp("2", true);
                break;

            case R.id.btn3:
                AddOp("3", true);
                break;

            case R.id.btn4:
                AddOp("4", true);
                break;

            case R.id.btn5:
                AddOp("5", true);
                break;

            case R.id.btn6:
                AddOp("6", true);
                break;

            case R.id.btn7:
                AddOp("7", true);
                break;

            case R.id.btn8:
                AddOp("8", true);
                break;

            case R.id.btn9:
                AddOp("9", true);
                break;

            case R.id.btnPonto:
                AddOp(".", true);
                break;

            case R.id.btnSoma:
                AddOp("+", false);
                break;

            case R.id.btnSub:
                AddOp("-", false);
                break;

            case R.id.btnDiv:
                AddOp("/", false);
                break;

            case R.id.btnMulti:
                AddOp("*", false);
                break;
        }
    }

    private void IniciarCommponentes(){

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnDiv = findViewById(R.id.btnDiv);
        btnSoma = findViewById(R.id.btnSoma);
        btnMulti = findViewById(R.id.btnMulti);
        btnSub = findViewById(R.id.btnSub);
        btnPonto = findViewById(R.id.btnPonto);
        btnLimpar = findViewById(R.id.btnLimpar);
        backspace = findViewById(R.id.btnApaga);
        txtExpressao = findViewById(R.id.txtexp);
        txtResult = findViewById(R.id.txtresult);
        btnIgual = findViewById(R.id.btnIgual);

    }

    public void AddOp (String string, boolean limpar){

        if(txtResult.getText().equals("")){
            txtExpressao.setText(" ");
        }
        if(limpar){
            txtResult.setText(" ");
            txtExpressao.append(string);
        }
        else{
            txtExpressao.append(txtResult.getText());
            txtExpressao.append(string);
            txtResult.setText(" ");
        }

    }
}
