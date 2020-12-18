package com.driwach.multify;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int num;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button txtColor = findViewById(R.id.button);
        Button fontColor = findViewById(R.id.button2);
        Button sumar = findViewById(R.id.button3);
        Button restar = findViewById(R.id.button4);
        Button augmentar = findViewById(R.id.button5);
        Button disiminuir = findViewById(R.id.button6);
        Button amagar = findViewById(R.id.button7);
        Button mostrar = findViewById(R.id.button8);
        TextView txt = findViewById(R.id.textView);
        num = Integer.parseInt(txt.getText().toString());
        sumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num++;
                update_textview(num);
            }
        });
        restar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num--;
                update_textview(num);
            }
        });
        augmentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float px = txt.getTextSize();
                float sp = px / getResources().getDisplayMetrics().scaledDensity;
                if (sp > 50) {
                    Toast.makeText(MainActivity.this, R.string.augmentar_limit, Toast.LENGTH_SHORT).show();
                } else {
                    sp++;
                    txt.setTextSize(TypedValue.COMPLEX_UNIT_SP, sp);
                }
            }
        });
        disiminuir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float px = txt.getTextSize();
                float sp = px / getResources().getDisplayMetrics().scaledDensity;
                if (sp <= 1) {
                    Toast.makeText(MainActivity.this, R.string.disminuir_limit, Toast.LENGTH_SHORT).show();
                } else {
                    sp--;
                    txt.setTextSize(TypedValue.COMPLEX_UNIT_SP, sp);
                }

            }
        });
        amagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setVisibility(View.INVISIBLE);
            }
        });
        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setVisibility(View.VISIBLE);
            }
        });
        fontColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setBackgroundColor(colors());
            }
        });
        txtColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setTextColor(colors());
            }
        });


    }

    public Random rand = new Random();

    public int colors() {
        return Color.rgb(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
    }


    public void update_textview(int num) {
        String str = String.valueOf(num);
        TextView txt = findViewById(R.id.textView);
        txt.setText(str);
    }
}