package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
//import androidx.constraintlayout.widget.ConstraintLayout;
//import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
//import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

//import java.math.BigInteger;
import java.math.BigDecimal;
import java.math.MathContext;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private TextView textView2;
    private EditText editText;
//    private Snackbar snackbar;
//     private LinearLayout mainLayout;
    // private ConstraintLayout mainLayout;
   private ScrollView scrollview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        textView2 = findViewById(R.id.textView2);
        editText = findViewById(R.id.editText);
        scrollview = findViewById(R.id.scrollview);
        // mainLayout = findViewById(R.id.mainLayout);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "It frickin' works!", Toast.LENGTH_SHORT).show();
//                String s = editText.getText().toString();
                String s = editText.getText().toString();
                if (s.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Enter some number", Toast.LENGTH_SHORT).show();
                } else {
                    BigDecimal KG = new BigDecimal(s);
                    BigDecimal multiplyingFactor = new BigDecimal("2.2046226218488");
                    BigDecimal POUNDS = KG.multiply(multiplyingFactor);
//                int kg = Integer.parseInt(s);
//                double pound = (int)(2.205 * kg);
                    int precision = POUNDS.toString().indexOf('.') + 2;
                    if (precision > 14) precision = 14;
                    MathContext mc = new MathContext(precision);
                    textView2.setText("The corresponding value in pounds is " + POUNDS.round(mc));
                    showSnackbar();
                }
            }
        });
    }
    public void showSnackbar() {
      Snackbar snackbar = Snackbar.make(scrollview, "Who's laughing now?", Snackbar.LENGTH_INDEFINITE)
      .setAction("ME", new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Snackbar snb1 = Snackbar.make(scrollview, "YOU'RE GODDAMN RIGHT!", Snackbar.LENGTH_SHORT);
            snb1.show();
        }
      });
      snackbar.show();
    }
}
