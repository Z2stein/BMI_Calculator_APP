package com.example.bmi_rechner;

import androidx.appcompat.app.AppCompatActivity;

import android.net.sip.SipSession;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.EventListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Realatiove Layout
        RelativeLayout rel = new RelativeLayout(this);

    //Field 1
        //TextView Körpergröße
        TextView inp1V = new TextView(this);
        inp1V.setId(1);
        inp1V.setText("Körpergrößer in cm");
            // Layout Params
                RelativeLayout.LayoutParams inp1VDetail = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

            // Rules
                inp1VDetail.addRule(RelativeLayout.CENTER_HORIZONTAL);

        // Text Input Körpergröße
        final TextInputEditText inp1 = new TextInputEditText(this);
        inp1.setId(2);

            //  Layout Parameter
            RelativeLayout.LayoutParams inp1Detail = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

            // Text Input Rules
            inp1Detail.addRule(RelativeLayout.BELOW,1);
            inp1Detail.addRule(RelativeLayout.CENTER_HORIZONTAL);

    // Field 2

        //TextView Körpergröße
        TextView inp2V = new TextView(this);
        inp2V.setId(3);
        inp2V.setText("Körpergewicht in Kg");
            // Layout Params
            RelativeLayout.LayoutParams inp2VDetail = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

            // Rules
            inp2VDetail.addRule(RelativeLayout.BELOW,2);
            inp2VDetail.addRule(RelativeLayout.CENTER_HORIZONTAL);


        // Text Input Körpergröße
        final TextInputEditText inp2 = new TextInputEditText(this);
        inp2.setId(4);

            //  Layout Parameter
            RelativeLayout.LayoutParams inp2Detail = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

            // Text Input Rules
            inp2Detail.addRule(RelativeLayout.BELOW,3);
            inp2Detail.addRule(RelativeLayout.CENTER_HORIZONTAL);

    // Button
        Button but1 = new Button(this);
        but1.setId(5);
        but1.setText("Berechne");

        // Layout Param
        RelativeLayout.LayoutParams but1Detail = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        // RUles
        but1Detail.addRule(RelativeLayout.CENTER_HORIZONTAL);
        but1Detail.addRule(RelativeLayout.BELOW,4);

    // Text Ausgabe
        final TextView txtv = new TextView(this);
        txtv.setText("-");

        // Layout Param
        RelativeLayout.LayoutParams txtvDetail = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        // RUles
        txtvDetail.addRule(RelativeLayout.CENTER_HORIZONTAL);
        txtvDetail.addRule(RelativeLayout.BELOW,5);


    // Button Berechne Listener
        but1.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean c = true;
                        double hight =0;
                        double weight = 0;
                        try {
                            hight = Double.parseDouble(String.valueOf(inp1.getText()));
                        } catch (Exception e) {
                            inp1.setText("Wrong Format");
                            c= false;
                        }
                        try {
                            weight = Double.parseDouble(String.valueOf(inp2.getText()));
                        } catch (Exception e) {
                            c= false;

                        }




                        double res = weight/(hight*hight)*10000;
                        txtv.setText(Double.toString(res));

                        if(c){
                            inp1.setText("0");
                            inp2.setText("0");
                        }



                    }
                }
        );

        //Funktionen zu Layout Hinzufügen
        rel.addView(inp1V,inp1VDetail);
        rel.addView(inp1,inp1Detail);

        rel.addView(inp2V,inp2VDetail);
        rel.addView(inp2,inp2Detail);

        rel.addView(but1,but1Detail);

        rel.addView(txtv,txtvDetail);
        //Content Setzen
        setContentView(rel);
    }
}