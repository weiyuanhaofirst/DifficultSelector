package com.example.demo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


public class DrawCircle extends View {

     int dWidth;
     int dHeight;


        //自定义大小
     static int types =10;//种类
     int angle = 360 /types;

     public static int[] color  = new int[types];

    public  String[] colortypes = {"#FFEC8B","#FFE4C4","#FFC0CB","#FFBBFF","#FFC1C1","#FFE4E1","#FFF68F","#FFFF00","#FF8C00","#FF82AB"};




     private Paint sectorPaint;//扇形

     private Paint point;




    public DrawCircle(Context context) {
        super(context);

    }

    public DrawCircle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    /*
    确认View大小
     */

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //重写onMeasure归根到地就是把参数传输给setMeasuredDimension();方法
        dWidth = measureSize(widthMeasureSpec);
        dHeight = measureSize(heightMeasureSpec);
        setMeasuredDimension(dWidth,dHeight);

    }

    private int measureSize(int measureSpec){
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        if (specMode == MeasureSpec.EXACTLY){//指出默认大小
            result =900;
        }else {
            result = specSize;
            if (specMode == MeasureSpec.AT_MOST){
                result = Math.min(result, specSize);//取出我们给定的值和specSize中最小的值作为计算
            }
        }
        return  result;
        }


     private void initPaint(){

         sectorPaint = new Paint();
         sectorPaint.setStyle(Paint.Style.FILL);
         sectorPaint.setAntiAlias(true);
         sectorPaint.setStrokeWidth(10);


         point = new Paint();
         point.setStyle(Paint.Style.STROKE);
         point.setAntiAlias(true);
         point.setStrokeWidth(20);
         point.setColor(Color.parseColor(RandomColor.getColor()));






     }


    @Override
    protected void onDraw(Canvas canvas) {
        initPaint();
        //扇形
        float r = (float) (Math.min(dWidth,dHeight)/2 * 0.9);
        RectF rectF =  new RectF(-r,-r,r,r);
        canvas.translate(dWidth/2,dHeight/2);
        for (int i = 0; i < types; i++ ){
            color[i] = Color.parseColor(colortypes[i]);
            sectorPaint.setColor(color[i]);
            sectorPaint.setShadowLayer(4,2,4,Color.GRAY);//阴影
            canvas.drawArc(rectF,i*angle,angle,true,sectorPaint);

        }

        //圆心
        canvas.drawCircle(0,0,1,point);






    }


}
