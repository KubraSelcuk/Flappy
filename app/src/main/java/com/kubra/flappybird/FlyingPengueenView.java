package com.kubra.flappybird;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.View;

public class FlyingPengueenView extends View {

    private int canvasWidth;
    private int canvasHeight;

    //private Bitmap pengueen;
    private Bitmap pengueen[] = new Bitmap[2];
    private int pengueenX=10;
    private int pengueenY;
    private int pengueenSpeed;

    private Bitmap backgroundImage;

    private Paint scorePaint = new Paint();

    //private Paint levelPaint= new Paint();

    private Bitmap life[]=new Bitmap[2];

    private boolean touch= false;


    public FlyingPengueenView(Context context){
        super(context);

        pengueen[0]= BitmapFactory.decodeResource(getResources(), R.drawable.pengueen1);
       pengueen[1]= BitmapFactory.decodeResource(getResources(), R.drawable.pengueen2);

        backgroundImage=BitmapFactory.decodeResource(getResources(), R.drawable.background);

        scorePaint.setColor(Color.BLACK);
        scorePaint.setTextSize(70); //70
        scorePaint.setTypeface(Typeface.DEFAULT_BOLD);
        scorePaint.setAntiAlias(true);

        //levelPaint.setColor(Color.DKGRAY);
        //levelPaint.setTextSize(32);
//  scorePaint.setTypeface(Typeface.DEFAULT_BOLD);
//  levelPaint.setTextAlign(Paint.Align.CENTER);
//        scorePaint.setAntiAlias(true);


        life[0]= BitmapFactory.decodeResource(getResources(),R.drawable.hearts);
        life[1]= BitmapFactory.decodeResource(getResources(),R.drawable.heart_grey);


        pengueenY=500;
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        canvasWidth = canvas.getWidth();
        canvasHeight = canvas.getHeight();


        int minPengueenY = pengueen[0].getHeight();
        int maxPengueenY =canvasHeight - pengueen[0].getHeight() * 3;

        pengueenY = pengueenY + pengueenSpeed;
        if(pengueenY<minPengueenY)
        {
            pengueenY = minPengueenY;
        }
        if(pengueenY>maxPengueenY)
        {
            pengueenY = maxPengueenY;
        }
        pengueenSpeed = pengueenSpeed +2;

        if(touch)
        {

            canvas.drawBitmap(pengueen[1],pengueenX,pengueenY,null);
            touch=false;
        }
        else{
            canvas.drawBitmap(pengueen[1],pengueenX,pengueenY,null);
        }



        canvas.drawBitmap(backgroundImage,0,0,null);

        canvas.drawText("Score:",20,60,scorePaint);

        //canvas.drawText("Level 1", canvasWidth()/2,60,levelPaint);

        canvas.drawBitmap(pengueen[0],0,0,null);



        canvas.drawBitmap(life[0],580,10,null);

        canvas.drawBitmap(life[0],680,10,null);

        canvas.drawBitmap(life[0],780,10,null);


    }

    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction()==MotionEvent.ACTION_DOWN)
        {
            touch=true;
            pengueenSpeed=-20;


        }
        return true;

    }
}
