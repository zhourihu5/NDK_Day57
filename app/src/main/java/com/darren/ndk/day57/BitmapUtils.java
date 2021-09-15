package com.darren.ndk.day57;

import android.graphics.Bitmap;

/**
 * Created by hcDarren on 2018/12/9.
 */

class BitmapUtils {
    public static native int gary(Bitmap src);
    /*public static Bitmap gary(Bitmap src) {
        // 怎么变成灰度的？ 矩阵去操作
        Bitmap dst = Bitmap.createBitmap(src.getWidth(), src.getHeight(), src.getConfig());
        Canvas canvas = new Canvas(dst);

        Paint paint = new Paint();
        paint.setDither(true);
        paint.setAntiAlias(true);

        // gary  f = 0.11f*R + 0.59f*B + 0.30f*G
        *//*ColorMatrix colorMatrix = new ColorMatrix(new float[]{
                0.213f,0.715f,0.072f,0,0,
                0.213f,0.715f,0.072f,0,0,
                0.213f,0.715f,0.072f,0,0,
                0,0,0,1,0,
        });*//*
        // 原图？
        *//*ColorMatrix colorMatrix = new ColorMatrix(new float[]{
                1,0,0,0,0,
                0,1,0,0,0,
                0,0,1,0,0,
                0,0,0,1,0,
        });*//*
        // 底片效果
        *//*ColorMatrix colorMatrix = new ColorMatrix(new float[]{
                -1,0,0,0,255,
                0,-1,0,0,255,
                0,0,-1,0,255,
                0,0,0,1,0,
        });*//*
        *//*ColorMatrix colorMatrix = new ColorMatrix(new float[]{
                1.2f,0,0,0,0,
                0,1.2f,0,0,0,
                0,0,1.2f,0,0,
                0,0,0,1,0,
        });*//*

        // 没办法做到高斯模式
        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
                1.2f, 0, 0, 0, 0,
                0, 1.2f, 0, 0, 0,
                0, 0, 1.2f, 0, 0,
                0, 0, 0, 1, 0,
        });

        // colorMatrix.setSaturation(0);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));

        canvas.drawBitmap(src, 0, 0, paint);
        return dst;
    }*/

   /* public static Bitmap gary2(Bitmap src) {
        // 怎么变成灰度的？ 矩阵去操作
        // Bitmap dst = Bitmap.createBitmap(src.getWidth(), src.getHeight(), src.getConfig());
        // java 层像素来操作
        int[] pixels = new int[src.getWidth() * src.getHeight()];
        src.getPixels(pixels, 0, src.getWidth(), 0, 0, src.getWidth(), src.getHeight());

        // 只处理上半部分
        for (int i = 0; i < pixels.length; i++) {
            int pixel = pixels[i];

            int a = (pixel >> 24) & 0xff;
            int r = (pixel >> 16) & 0xff;
            int g = (pixel >> 8) & 0xff;
            int b = pixel & 0xff;
            // f = 0.213f * r + 0.715f * g + 0.072f * b
            int gery = (int) (0.213f * r + 0.715f * g + 0.072f * b);

            // 黑白
            // int black_white = (a + r + b) / 3 > 125 ? 255 : 0;

            pixels[i] = (a << 24) | (gery << 16) | (gery << 8) | gery;
        }

        src.setPixels(pixels, 0, src.getWidth(), 0, 0, src.getWidth(), src.getHeight());
        return src;
    }*/
}
