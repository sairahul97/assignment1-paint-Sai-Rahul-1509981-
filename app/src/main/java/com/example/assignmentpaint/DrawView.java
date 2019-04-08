package com.example.assignmentpaint;


import android.content.Context;
import android.graphics.Canvas;

import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;

import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;


public class DrawView extends View implements View.OnTouchListener {


    PointF point = new PointF();
    ArrayList<Point> points = new ArrayList<Point>();
    MainActivity main = new MainActivity();
    private boolean clear;

    class PaintCoordinate
    {
        Point pt;
        float radius;
    }
    ArrayList <PaintCoordinate> pointss = new ArrayList<PaintCoordinate>();

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;


    }

    float radius = 5;



    public DrawView(Context context) {
        super(context);
        setOnTouchListener(this);
        point.x = 300;
        point.y = 300;
    }

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnTouchListener(this);
        point.x = 300;
        point.y=300;
    }

    public DrawView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOnTouchListener(this);
        point.x = 300;
        point.y=300;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();

              //  paint.setColor(Color.RED);
//for(int i=0;i<points.size();i++){
   // canvas.drawCircle(points.get(i).x,points.get(i).y,50,paint);
//}


//        for (Point pt : points)
//        {
//            paint.setColor(pt.colour);
//            canvas.drawCircle(pt.x,pt.y,30,paint);
//        }

        for(PaintCoordinate pc : points) {
            canvas.drawCircle(pc.pt.x, pc.pt.y, pc.radius, paint);
        }


    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {


       // points.add(new PointF(event.getX(),event.getY()));
        for(int i=0;i<event.getPointerCount();i++)
        {
            points.add(new Point(event.getX(i),event.getY(i),new Random().nextInt()));
        }

        invalidate();
        return true;
    }

//    @Override
//    public boolean onTouch(View view, MotionEvent event) {
//        PaintCoordinate pc = new PaintCoordinate();
//
//
//        for(int i=0;i<event.getPointerCount();i++)
//        {
//            points.add(new Point(event.getX(i),event.getY(i),new Random().nextInt()));
//        }
//
//
//
//
//
//
//        pc.radius = radius;
//
//
//
//        invalidate();
//
//        return true;
//    }
}
