package com.example.assignmentpaint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;

import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class DrawView extends View implements View.OnTouchListener {


    PointF point = new PointF();
    ArrayList<PointF> points = new ArrayList<PointF>();
    MainActivity main = new MainActivity();
    private boolean clear;


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

                paint.setColor(Color.RED);
for(int i=0;i<points.size();i++){

    canvas.drawCircle(points.get(i).x,points.get(i).y,50,paint);
}

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        points.add(new PointF(event.getX(),event.getY()));
        invalidate();
        return true;
    }
}
