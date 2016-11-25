package com.example.a403.reportb2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

        CheckBox c1;
    Button btn1;
    RadioButton rb,rb1;
    ImageView IV1;
    LinearLayout L1;
    EditText e1,e2,e3;
    TextView t1,t2,t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c1 = (CheckBox)findViewById(R.id.cb);
        btn1 = (Button)findViewById(R.id.btn);
        rb = (RadioButton)findViewById(R.id.rb);
        rb1 = (RadioButton)findViewById(R.id.rb2);
        IV1 = (ImageView)findViewById(R.id.IV);
        e1 = (EditText)findViewById(R.id.et);
        e2 = (EditText)findViewById(R.id.et1);
        e3 = (EditText)findViewById(R.id.et2);
        t1 = (TextView)findViewById(R.id.tv);
        t2 = (TextView)findViewById(R.id.tv1);
        t3 = (TextView)findViewById(R.id.tv2);

        int num1,num2,num3;

        rb.setChecked(true);

        rb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    IV1.setImageResource(R.drawable.pk);
            }
        });
        rb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    IV1.setImageResource(R.drawable.sc);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1 = e1.getText().toString();
                String num2 = e2.getText().toString();
                String num3 = e3.getText().toString();

                int result1 = Integer.parseInt(num1) + Integer.parseInt(num2) + Integer.parseInt(num3);
                Double result2 = (Double.parseDouble(num1) * 16000) + ((Double.parseDouble(num2)) * 11000) + ((Double.parseDouble(num3)) * 4000);

                if(c1.isChecked()) {
                    result2 = (Double)result2 - ((Double)result2 *0.07);
                }

                t1.setText("주문 개수 : "+ result1);
                t2.setText("주문 금액 : "+ result2);

                if(rb.isChecked()) {
                    t3.setText("피클을 선택하셨습니다.");
                } else {
                    t3.setText("소스를 선택하셨습니다.");
                }


            }
        });
    }
}
