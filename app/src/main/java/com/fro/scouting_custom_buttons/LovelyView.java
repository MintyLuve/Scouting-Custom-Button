package com.fro.scouting_custom_buttons;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class LovelyView extends View {
    //circle and text colors
    private int rectCol, labelCol;
    //label text
    private String rectText;
    //paint for drawing custom view
    private Paint rectPaint;
    public LovelyView(Context context, AttributeSet attrs){
        super(context, attrs);
        //paint object for drawing in onDraw
        rectPaint = new Paint();
        //get the attributes specified in attrs.xml using the name we included
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.LovelyView, 0, 0);

        try {
            //get the text and colors specified using the names in attrs.xml
            rectText = a.getString(R.styleable.LovelyView_rectLabel);
            rectCol = a.getInteger(R.styleable.LovelyView_rectColor, 0);//0 is default
            labelCol = a.getInteger(R.styleable.LovelyView_labelColor, 0);
        } finally {
            a.recycle();
        }
    }
    @Override
    protected void onDraw(Canvas canvas) {
        //draw the View
        rectPaint.setStyle(Style.FILL);
        rectPaint.setAntiAlias(true);
        rectPaint.setStrokeWidth(20);
        //set the paint color using the rect color specified
        rectPaint.setColor(rectCol);
        RectF rect = new RectF(0,0,250,250);
        canvas.drawRoundRect(rect, 40, 40, rectPaint);

        //set the text color using the color specified
        rectPaint.setColor(labelCol);
        //set text properties
        rectPaint.setTextSize(50);
        //draw the text using the string attribute and chosen properties
        canvas.drawText(rectText, 200, 200, rectPaint);

    }

    public int getRectColor(){
        return rectCol;
    }
    public int getLabelColor(){return labelCol;}
    public String getLabelText(){return rectText;}

    public void setRectColor(int newColor){
        //update the instance variable
        rectCol=newColor;
        //redraw the view
        invalidate();
        requestLayout();
    }
    public void setLabelColor(int newColor){
        //update the instance variable
        labelCol=newColor;
        //redraw the view
        invalidate();
        requestLayout();
    }
    public void setLabelText(String newLabel){
        //update the instance variable
        rectText=newLabel;
        //redraw the view
        invalidate();
        requestLayout();
    }
}
