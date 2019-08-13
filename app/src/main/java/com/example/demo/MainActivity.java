package com.example.demo;


import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.annotation.Annotation;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private TextView textView6;
    private TextView textView7;
    private TextView textView8;
    private TextView textView9;
    private TextView textView10;
    private TextView textView11;
    private TextView textView12;
    private DrawCircle roateCircle;



    private ImageView img;

    private TranslateAnimation translateAnimation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();//ActionBar
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


        //实例化控件
        textView1 = findViewById(R.id.text1);
        textView2 = findViewById(R.id.text2);
        textView3 = findViewById(R.id.text3);
        textView4 = findViewById(R.id.text4);
        textView5 = findViewById(R.id.text5);
        textView6 = findViewById(R.id.text6);
        textView7 = findViewById(R.id.text7);
        textView8 = findViewById(R.id.text8);
        textView9 = findViewById(R.id.text9);
        textView10 = findViewById(R.id.text10);
        textView11 = findViewById(R.id.text11);
        textView12 = findViewById(R.id.text12);

        roateCircle = findViewById(R.id.circle);


        img = findViewById(R.id.up_image);



    }


    //刷新转盘
    private void initCirlcle(){
        int times = (int) (Math.random()*360*10 + 1);

        Log.d("this is tag : ",String.valueOf(times +"  " ));

        //旋转角度小，持续的时间越长，旋转速度越慢，角度大旋转时间相对小则速度快
        final RotateAnimation roate = new RotateAnimation(0f,720 ,
                Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,
                0.5f);
        final RotateAnimation roate2 = new RotateAnimation(0f,720f,
                Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,
                0.5f);

        LinearInterpolator lin = new LinearInterpolator();//匀速转动
        DecelerateInterpolator lin2 = new DecelerateInterpolator();//减速


        roate.setInterpolator(lin);
        roate.setFillAfter(true);//执行完是否在当前的状态
        roate.setDuration(1000);//持续时间
        roate.setStartOffset(100);//执行前的等待时间


        roate2.setInterpolator(lin2);
        roate2.setFillAfter(true);
        roate2.setDuration(4000);//持续时间


        roateCircle.startAnimation(roate);
        roate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {


            }

            @Override
            public void onAnimationEnd(Animation animation) {
                roateCircle.startAnimation(roate2);
                roate2.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        translateAnimation.setFillAfter(false);

                        AlertDialog.Builder  dialog = new AlertDialog.Builder(MainActivity.this);
                        dialog.setTitle("开始");

                        dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                initCirlcle();
                            }
                        });
                        dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        dialog.show();

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });





    }



/*
设置图例
 */

    private void legnedColor(){
        Intent intent = getIntent();
        textView1.setText(intent.getStringExtra("value1"));
        textView2.setText(intent.getStringExtra("value2"));
        textView3.setText(intent.getStringExtra("value3"));
        textView4.setText(intent.getStringExtra("value4"));
        textView5.setText(intent.getStringExtra("value5"));
        textView6.setText(intent.getStringExtra("value6"));
        textView7.setText(intent.getStringExtra("value7"));
        textView8.setText(intent.getStringExtra("value8"));
        textView9.setText(intent.getStringExtra("value9"));
        textView10.setText(intent.getStringExtra("value10"));

        textView1.setBackgroundColor(DrawCircle.color[0]);
        textView2.setBackgroundColor(DrawCircle.color[1]);
        textView3.setBackgroundColor(DrawCircle.color[2]);
        textView4.setBackgroundColor(DrawCircle.color[3]);
        textView5.setBackgroundColor(DrawCircle.color[4]);
        textView6.setBackgroundColor(DrawCircle.color[5]);
        textView7.setBackgroundColor(DrawCircle.color[6]);
        textView8.setBackgroundColor(DrawCircle.color[7]);
        textView9.setBackgroundColor(DrawCircle.color[8]);
        textView10.setBackgroundColor(DrawCircle.color[9]);




    }

    /*
    动画效果
     */

    private void onAnimation(){
        translateAnimation = new TranslateAnimation(0,0,350,0);
        translateAnimation.setDuration(200);

        translateAnimation.setDetachWallpaper(true);
        translateAnimation.setFillAfter(true);



        img.setAnimation(translateAnimation);
        translateAnimation.start();
    }

    private void cancleAnimator(){
        translateAnimation.cancel();

    }



    //绑定右边menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbarmenu,menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){//左边
            case android.R.id.home:
                finish();
                break;
            case R.id.menu1:

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            default:

        }
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        legnedColor();
        AlertDialog.Builder  dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("开始");

        dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                initCirlcle();
            }
        });
        dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.show();


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action){
            case MotionEvent.ACTION_DOWN:




                break;
            case MotionEvent.ACTION_MOVE:

                break;
            case MotionEvent.ACTION_UP:
                onAnimation();


                break;
             default:
                 break;

        }

        return super.onTouchEvent(event);

    }
}
