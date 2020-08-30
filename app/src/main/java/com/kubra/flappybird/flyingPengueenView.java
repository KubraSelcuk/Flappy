package com.kubra.flappybird;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

import com.kubra.flappybird.R;

public class flyingPengueenView extends View {
    private Bitmap pengueen;
    public flyingPengueenView(Context context){
        super(context);

        pengueen= BitmapFactory.decodeResource(getResources(), R.drawable.pengueen);


    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawBitmap(pengueen,0,0,null);

    }
}
