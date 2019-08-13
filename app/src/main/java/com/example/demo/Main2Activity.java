package com.example.demo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    EditText text1;
    EditText text2;
    EditText text3;
    EditText text4;
    EditText text5;
    EditText text6;
    EditText text7;
    EditText text8;
    EditText text9;
    EditText text10;
    Button sure;
    Button back;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        text1 = findViewById(R.id.edtext_1);
        text2 = findViewById(R.id.edtext_2);
        text3 = findViewById(R.id.edtext_3);
        text4 = findViewById(R.id.edtext_4);
        text5 = findViewById(R.id.edtext_5);
        text6 = findViewById(R.id.edtext_6);
        text7 = findViewById(R.id.edtext_7);
        text8 = findViewById(R.id.edtext_8);
        text9 = findViewById(R.id.edtext_9);
        text10 = findViewById(R.id.edtext_10);

        sure = findViewById(R.id.sure_btn);
        back = findViewById(R.id.retrun_btn);

        /*
        确认
         */
        sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(text1.getText().toString().equals("")
                       && text2.getText().toString().equals("")
                       && text3.getText().toString().equals("")
                       && text4.getText().toString().equals("")
                       && text5.getText().toString().equals("")
                       && text6.getText().toString().equals("")
                       && text7.getText().toString().equals("")
                       && text8.getText().toString().equals("")
                       && text9.getText().toString().equals("")
                       && text10.getText().toString().equals("")){
                   Toast.makeText(Main2Activity.this,"选项未填写完毕",Toast.LENGTH_SHORT).show();
               }else{
                   Toast.makeText(Main2Activity.this,"选项填写完毕",Toast.LENGTH_SHORT).show();
               }
            }
        });

        /*
        返回
         */
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(getApplicationContext(),text1.getText().toString(),
                        text2.getText().toString(),
                        text3.getText().toString(),
                        text4.getText().toString(),
                        text5.getText().toString(),
                        text6.getText().toString(),
                        text7.getText().toString(),
                        text8.getText().toString(),
                        text9.getText().toString(),
                        text10.getText().toString());

            }
        });



    }
    private void startActivity(Context context,String st1,String st2,String st3,
            String st4,String st5,String st6,String st7,String st8,String st9,String st10){
            Intent intent = new Intent(Main2Activity.this,MainActivity.class);
            intent.putExtra("value1",st1);
            intent.putExtra("value2",st2);
            intent.putExtra("value3",st3);
            intent.putExtra("value4",st4);
            intent.putExtra("value5",st5);
            intent.putExtra("value6",st6);
            intent.putExtra("value7",st7);
            intent.putExtra("value8",st8);
            intent.putExtra("value9",st9);
            intent.putExtra("value10",st10);
            context.startActivity(intent);
    }


}
