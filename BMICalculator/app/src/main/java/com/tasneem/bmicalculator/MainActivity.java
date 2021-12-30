package com.tasneem.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    ImageButton feetPlus, feetMinus, kg_plus, kg_minus, inchi_plus, inchi_minus;
    LinearLayout btnMale, btnFemale;
    String gender = "";
    TextView inchi_value, feet_value, weight_value;
    int user_feet,user_inchi, user_age;
    float  user_weight;
    Button calcBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMale = findViewById(R.id.btnMale);
        btnFemale = findViewById(R.id.btnFemale);
        feetPlus = findViewById(R.id.feet_plus);
        feetMinus = findViewById(R.id.feet_minus);
        kg_plus = findViewById(R.id.kg_plus);
        kg_minus = findViewById(R.id.kg_minus);
        inchi_plus = findViewById(R.id.inchi_plus);
        inchi_minus = findViewById(R.id.inchi_minus);
        feet_value = findViewById(R.id.feet_value);
        inchi_value = findViewById(R.id.inchi_value);
        weight_value = findViewById(R.id.weight_value);
        calcBtn = findViewById(R.id.calcBtn);
        user_feet = 0;
        user_weight = Integer.parseInt(weight_value.getText().toString());
        user_inchi = 0;
        user_age = 0;


        btnMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gender != "male"){
                    btnMale.setBackgroundResource(R.drawable.selected_g_button);
                    btnFemale.setBackgroundResource(R.drawable.g_c_btn);
                    gender = "male";
                }
                else {
                    btnMale.setBackgroundResource(R.drawable.g_c_btn);
                    gender = "";
                }
            }
        });

        btnFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gender != "female"){
                    btnFemale.setBackgroundResource(R.drawable.selected_g_button);
                    btnMale.setBackgroundResource(R.drawable.g_c_btn);
                    gender = "female";
                }
                else {
                    btnFemale.setBackgroundResource(R.drawable.g_c_btn);
                    gender = "";
                }
            }
        });



        feetPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user_feet < 9){
                    user_feet++;
                }
                else if(user_feet == 11){
                    user_feet = 0;
                }
                feet_value.setText(""+user_feet);
            }
        });

        feetMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user_feet > 0){
                    user_feet--;
                    feet_value.setText(""+user_feet);
                }
            }
        });




        inchi_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user_inchi < 11){
                    user_inchi++;
                }
                else if(user_inchi == 11){
                    user_inchi = 0;
                }
                inchi_value.setText(""+user_inchi);
            }
        });

        inchi_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user_inchi > 0){
                    user_inchi--;
                    inchi_value.setText(""+user_inchi);
                }
            }
        });


        kg_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (0 < 500){
                    user_weight+= 0.5;
                    weight_value.setText(""+user_weight);
                }
            }
        });

        kg_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user_weight > 0){
                    user_weight--;
                    weight_value.setText(""+user_weight);
                }
            }
        });



        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }
}