package com.ngdroidapp;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;

import istanbul.gamelab.ngdroid.base.BaseCanvas;
import istanbul.gamelab.ngdroid.util.Log;
import istanbul.gamelab.ngdroid.util.Utils;


/**
 * Created by noyan on 24.06.2016.
 * Nitra Games Ltd.
 */


public class GameCanvas extends BaseCanvas {

    private Bitmap tileSet;
    private Bitmap spriteSheet;
    private Rect kareSrc, kareDst;
    private Rect tileSrc, tileDst;
    private int kareNo;

    public GameCanvas(NgApp ngApp) {
        super(ngApp);
    }

    public void setup()
    {
        //Log.i(TAG, "setup");";
        spriteSheet = Utils.loadImage(root,"cowboy.png");
        tileSet = Utils.loadImage(root, "tilea2.png");
        kareSrc = new Rect();
        kareDst = new Rect();
        tileSrc = new Rect();
        tileDst = new Rect();
        kareNo = 1;

    }



    public void update() {
        //Log.i(TAG, "update");

        kareSrc.set(kareNo * 128, 0, (kareNo + 1) * 128, 128);
        kareDst.set(0, 0, 128, 128);
        tileSrc.set(0, 0, 64, 64);


        kareNo++;
        if(kareNo > 8)
            kareNo = 1;
    }

    public void draw(Canvas canvas) {
        //Log.i(TAG, "draw");

        for (int i = 0; i < getWidth(); i+=64) {
            for (int j = 0; j < getHeight(); j+=64)
            {
                tileDst.set(i, j, i+64, j+64);
                canvas.drawBitmap(tileSet, tileSrc, tileDst, null);
            }
        }



        canvas.drawBitmap(spriteSheet, kareSrc, kareDst, null);
    }

    public void keyPressed(int key) {

    }

    public void keyReleased(int key) {

    }

    public boolean backPressed() {
        return true;
    }

    public void surfaceChanged(int width, int height) {

    }

    public void surfaceCreated() {

    }

    public void surfaceDestroyed() {

    }

    public void touchDown(int x, int y) {
    }

    public void touchMove(int x, int y) {
    }

    public void touchUp(int x, int y) {
    }


    public void pause() {

    }


    public void resume() {

    }


    public void reloadTextures() {

    }


    public void showNotify() {
    }

    public void hideNotify() {
    }

}
