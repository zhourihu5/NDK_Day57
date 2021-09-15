package com.darren.ndk.day57;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BitmapFactory.Options options = new BitmapFactory.Options();
        // 版本 复用
        options.inMutable = true;
        // 有啥区别？  ARGB_8888  32 位最好
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        // RGB_565 747  ARGB_8888 1494  1 倍
        // ARGB_8888 -> RGB 565 RGB 5位R 6位G 5位B   16位
        Bitmap src = BitmapFactory.decodeResource(getResources(), R.mipmap.copy, options);

        Log.e("TAG", src.getByteCount() / 1024 + "");
        BitmapUtils.gary(src);

        ImageView image2 = findViewById(R.id.image_2);
        image2.setImageBitmap(src);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
