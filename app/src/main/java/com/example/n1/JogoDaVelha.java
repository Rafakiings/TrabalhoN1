package com.example.n1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class JogoDaVelha extends AppCompatActivity{

    private final String QUADRADO = "quadrado";
    private final String bola = "O";
    private final String xis = "X";

    private String LastPlay = "O";
    private View view;

    int [][] estadoFinal= new int[][]{
            {1, 2, 3}, {4, 5, 6}, {7, 8, 9},
            {1, 4, 7}, {2, 5, 8}, {3, 6, 9},
            {1, 5, 9}, {3, 5, 7}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setView(getLayoutInflater().inflate(R.layout.activity_jogodavelha,null));
        setContentView( getView() );
    }

    public void clickQuadrado(View view){

        if(((Button)view).getText().equals("")) {
            if (LastPlay.equals(bola)) {
                ((Button) view).setText(xis);
                setLastPlay(xis);
            } else {
                ((Button) view).setText(bola);
                setLastPlay(bola);
            }
        }else {
            Toast.makeText(getView().getContext(), "Quadrado já preenchido!", Toast.LENGTH_LONG).show();
        }

        for(int x=0; x<=7 ; ++x){
            String s1 = getQUADRADO( estadoFinal[x][0] ).getText().toString();
            String s2 = getQUADRADO( estadoFinal[x][1] ).getText().toString();
            String s3 = getQUADRADO( estadoFinal[x][2] ).getText().toString();

            if (!s1.equals("")&&
                !s2.equals("")&&
                !s3.equals("")){

                if (s1.equals(s2) && (s2.equals(s3))) {
                    Toast.makeText(getView().getContext(), "Fim de Jogo", Toast.LENGTH_LONG).show();
                    setEnableQuadrado(false);
                }
            }
        }
    }

    public Button getQUADRADO(int tagNum) {
        return (Button) getView().findViewWithTag(QUADRADO+tagNum);
    }

    public void newGame(View view){

        setEnableQuadrado(true);

        for(int i=1; i<=9; i++){
            if(getQUADRADO(i)!=null){
                getQUADRADO(i).setText("");
            }
        }
    }

    public void setEnableQuadrado(boolean b){
        for(int i=1; i<=9 ; ++i){
            if(getQUADRADO(i)!=null){
                getQUADRADO(i).setEnabled(b);
            }
        }
    }

    public View getView(){
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public void setLastPlay(String lastPlay) {
        LastPlay = lastPlay;
    }
}
