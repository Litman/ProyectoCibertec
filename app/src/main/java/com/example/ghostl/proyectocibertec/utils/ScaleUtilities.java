package com.example.ghostl.proyectocibertec.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class ScaleUtilities {

    public static Bitmap decodeFile(String path, int dstWidth, int dstHeight, ScalingLogic scalingLogic){
        Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);
        options.inJustDecodeBounds = false;
        options.inSampleSize = calculateSampleSize(options.outWidth, options.outHeight, dstWidth,
                dstHeight, scalingLogic);
        return BitmapFactory.decodeFile(path, options);
    }

    private static int calculateSampleSize(int srcWidth, int srcHeight, int dstWidth, int dstHeight, ScalingLogic scalingLogic) {
        if(scalingLogic == ScalingLogic.FIT){
            float srcAspect = (float)srcWidth / (float)srcHeight;
            float dstAspect = (float)dstWidth / (float)dstHeight;

            if(srcAspect > dstAspect){
                return  srcWidth / dstWidth;
            }else{
                return srcHeight / dstHeight;
            }

        }else{
            float srcAspect = (float)srcWidth / (float)srcHeight;
            float dstAspect = (float)dstWidth / (float)dstHeight;

            if(srcAspect > dstAspect){
                return srcHeight / dstHeight;
            }else{
                return srcWidth / dstWidth;
            }
        }
    }

    public enum ScalingLogic{
        CROP,FIT
    }

    public static Bitmap createScaleBitmap(Bitmap unscaleBitmap,int dstWidth, int dstHeight, ScalingLogic scalingLogic){
       Rect srcRect = calculateSrcRect(unscaleBitmap.getWidth(), unscaleBitmap.getHeight(), dstWidth, dstHeight, scalingLogic);

       Rect dstRect = calculateDstRect(unscaleBitmap.getWidth(), unscaleBitmap.getHeight(), dstWidth, dstHeight, scalingLogic);

        Bitmap scaleBitmap = Bitmap.createBitmap(dstRect.width(), dstRect.height(), Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(scaleBitmap);
        canvas.drawBitmap(unscaleBitmap, srcRect, dstRect, new Paint(Paint.FILTER_BITMAP_FLAG));

        return scaleBitmap;

    }

    private static Rect calculateSrcRect(int srcWidth, int srcHeight, int dstWidth, int dstHeight, ScalingLogic scalingLogic) {
        if(scalingLogic == ScalingLogic.CROP){
            float srcAspect = (float) srcWidth / (float) srcHeight;
            float dstAspect = (float) dstWidth / (float) dstHeight;

            if(srcAspect > dstAspect){
                int srcRectWidth = (int)(srcHeight * dstAspect);
                int srcRectLeft = (srcWidth - srcRectWidth) / 2;
                return new Rect(srcRectLeft, 0 , srcRectLeft + srcRectWidth, srcHeight);
            }else{
                int srcRectHeight = (int)(srcWidth / dstAspect);
                int scrRectTop =(int) (srcHeight - srcRectHeight)/2;
                return new Rect(0, scrRectTop, srcWidth, scrRectTop + srcRectHeight);
            }
         }else{
            return new Rect(0, 0, srcWidth, srcHeight);
        }
    }

    private static Rect calculateDstRect(int srcWidth, int srcHeight, int dstWidth, int dstHeight, ScalingLogic scalingLogic){
        if (scalingLogic == ScalingLogic.FIT) {
            float srcAspect = (float) srcWidth / (float) srcHeight;
            float dstAspect = (float) dstWidth / (float) dstHeight;

            if(srcAspect > dstAspect){
                return new Rect(0, 0, dstWidth, (int)(dstWidth/ srcAspect));
            }else{
                return new Rect(0, 0,(int)(dstHeight * srcAspect), dstHeight);
            }

        }else{
            return new Rect(0, 0, dstWidth, dstHeight);
        }
    }

}
