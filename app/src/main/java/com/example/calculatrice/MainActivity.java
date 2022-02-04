package com.example.calculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button BT_0;
    private Button BT_1;
    private Button BT_2;
    private Button BT_3;
    private Button BT_4;
    private Button BT_5;
    private Button BT_6;
    private Button BT_7;
    private Button BT_8;
    private Button BT_9;

    private Button BT_div;
    private Button BT_mul;
    private Button BT_add;
    private Button BT_sou;
    private Button BT_ega;

    private Button BT_C;
    private TextView TX_result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BT_0 = findViewById(R.id.BT_0);
        BT_1 = findViewById(R.id.BT_1);
        BT_2 = findViewById(R.id.BT_2);
        BT_3 = findViewById(R.id.BT_3);
        BT_4 = findViewById(R.id.BT_4);
        BT_5 = findViewById(R.id.BT_5);
        BT_6 = findViewById(R.id.BT_6);
        BT_7 = findViewById(R.id.BT_7);
        BT_8 = findViewById(R.id.BT_8);
        BT_9 = findViewById(R.id.BT_9);

        BT_div = findViewById(R.id.BT_div);
        BT_mul = findViewById(R.id.BT_mul);
        BT_add = findViewById(R.id.BT_add);
        BT_sou = findViewById(R.id.BT_sou);
        BT_ega = findViewById(R.id.BT_ega);

        BT_C = findViewById(R.id.BT_C);

        TX_result = findViewById(R.id.Resultat);
    }

    String nombreCacul = "";
    String premierNombre = "";
    String Opération = "";

    public void ajoutChiffre(String chiffre) {
        nombreCacul += chiffre;
        TX_result.setText(nombreCacul);

    }

    public String premierNombre() {
        premierNombre = nombreCacul;
        nombreCacul = "";
        TX_result.setText(nombreCacul);
        return premierNombre;
    }


    public void supprimerChiffre(){
        if (nombreCacul.length() > 0) {
            int charNbr = nombreCacul.length();
            nombreCacul = nombreCacul.substring(0, charNbr - 1);
            TX_result.setText(nombreCacul);
        }

    }

    public void Egal() {
        String deuxiemeNombre = premierNombre;
        int nbre2 = Integer.parseInt(deuxiemeNombre);
        String premierNombre = premierNombre();
        int nbre1 = Integer.parseInt(premierNombre);
        int resultint = 0;
        if(Opération == "+"){
            resultint = nbre1 + nbre2;
        }
        else if(Opération == "-"){
            resultint =  nbre2 - nbre1;
        }
        else if(Opération == "/"){
            if(nbre1 == 0){
                TX_result.setText("ERROR sal hmar");
            }
            else {
                resultint = nbre1 / nbre2;
            }
        }
        if(Opération == "*"){
            resultint = nbre1 * nbre2;
        }
        String result = Integer.toString(resultint);
        TX_result.setText(result);
    }

    @Override
    protected void onStart() {
        super.onStart();
        BT_ega.setEnabled(false);

        BT_0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ajoutChiffre("0");

            }
        });

        BT_1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ajoutChiffre("1");

            }
        });

        BT_2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ajoutChiffre("2");
            }
        });

        BT_3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ajoutChiffre("3");
            }
        });

        BT_4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ajoutChiffre("4");
            }
        });


        BT_5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ajoutChiffre("5");
            }
        });

        BT_6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ajoutChiffre("6");
            }
        });

        BT_7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ajoutChiffre("7");
            }
        });

        BT_8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ajoutChiffre("8");
            }
        });

        BT_9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ajoutChiffre("9");
            }
        });

        BT_sou.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                premierNombre();
                BT_ega.setEnabled(true);
                Opération = "-";
            }
        });

        BT_add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                premierNombre();
                BT_ega.setEnabled(true);
                Opération = "+";
            }
        });

        BT_div.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                premierNombre();
                BT_ega.setEnabled(true);
                Opération = "/";
            }
        });

        BT_mul.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                premierNombre();
                BT_ega.setEnabled(true);
                Opération = "*";
            }
        });

        BT_ega.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Egal();
                BT_ega.setEnabled(false);
            }
        });

        BT_C.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                supprimerChiffre();
            }
        });


    }

}