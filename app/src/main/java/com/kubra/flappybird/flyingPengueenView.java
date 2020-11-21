package com.kubra.flappybird;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.View;

public class flyingPengueenView extends View {

    private Bitmap pengueen;

    private Bitmap backgroundImage;
    private Paint scorePaint = new Paint();
    private Bitmap life[]=new Bitmap[2];

    private pengueen = new Bitmap[2];
    private int pengueenX=10;
    private int pengueenY;
    private int pengueenSpeed;

    private boolean touch = false;

    private int canvasWidth, canvasHeight;

    public flyingPengueenView(Context context){
        super(context);

        pengueen= BitmapFactory.decodeResource(getResources(), R.drawable.pengueen1);

        backgroundImage=BitmapFactory.decodeResource(getResources(), R.drawable.background);

        scorePaint.setColor(Color.BLACK);
        scorePaint.setTextSize(70);
        scorePaint.setTypeface(Typeface.DEFAULT_BOLD);
        scorePaint.setAntiAlias(true);

        life[0]= BitmapFactory.decodeResource(getResources(),R.drawable.hearts);
        life[1]= BitmapFactory.decodeResource(getResources(),R.drawable.heart_grey);

    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvasWidth = canvas.getWidth();
        canvasHeight = canvas.getHeight();

        canvas.drawBitmap(backgroundImage,0,0,null);
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




        canvas.drawText("Score:",20,60,scorePaint);
        canvas.drawBitmap(pengueen,0,0,null);
        canvas.drawBitmap(life[0],580,10,null);
        canvas.drawBitmap(life[0],680,10,null);
        canvas.drawBitmap(life[0],780,10,null);


    }
}
