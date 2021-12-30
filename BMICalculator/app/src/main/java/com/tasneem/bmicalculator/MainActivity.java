package com.tasneem.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
    TextView tvDes, tvResult;

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
        user_age = 0;
        tvDes = findViewById(R.id.tvDes);
        tvResult = findViewById(R.id.tvResult);


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

        kg_plus.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (0 < 500){
                    user_weight+= 10;
                    weight_value.setText(""+user_weight);
                }
                return true;
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
                    user_feet = Integer.parseInt(feet_value.getText().toString());
                    user_weight = Float.parseFloat(weight_value.getText().toString());
                    user_inchi = Integer.parseInt(inchi_value.getText().toString());
                    float height = (float) ((user_feet * 0.3048) + (user_inchi * 0.0254));
                    float bmiIndex = 0;

                    if(height != 0 && user_weight !=0){

                        bmiIndex = user_weight /(height*height);
                        tvResult.setText("YOUR BMI INDEX IS: " + String.format("%.2f", bmiIndex));
                        tvResult.setVisibility(View.VISIBLE);
                        tvDes.setVisibility(View.VISIBLE);
                    }
                    else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setMessage("Please Enter Values First..");
                        builder.setNeutralButton("Ok",new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        builder.setCancelable(true);

                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                    }

                    if (bmiIndex < 18.5){
                        tvDes.setText("You're underweight. Please eat healthy and nutritious food to increase your BMI Index.");
                    }
                    else if(bmiIndex >= 18.5 && bmiIndex <= 24.9){
                        tvDes.setText("Your BMI Index is perfect. Keep it up. \n 😎 😎");
                    }
                    else if (bmiIndex >= 25 && bmiIndex <= 29.9){
                        tvDes.setText("Your BMI Index is overweight. You should control your diet and exercise regularly.");
                    }
                    else{
                        tvDes.setText("You're too overweight. You should control your diet and exercise regularly. Please control your weight... ");
                    }

            }
        });


    }
}