package ImageProcessing;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ImageCutting {

    public Bitmap getProcessedImage(byte[] bitmapData) {
        Bitmap bitmap = BitmapFactory.decodeByteArray(bitmapData, 0, bitmapData.length);
        return getProcessedImage(bitmap);
    }

    public Bitmap getProcessedImage(Bitmap image){
        Bitmap tempImage = Bitmap.createBitmap(image.getWidth(),image.getHeight(), Bitmap.Config.ARGB_8888);

        Paint p = new Paint();
        p.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Canvas c = new Canvas(tempImage);
        c.drawBitmap(image, 0, 0, null);

        int x = 0,
            y = 0;

        for (int i = 0; i < image.getHeight(); i++)
        {
            for (int j = 0; j < image.getWidth(); j++)
            {
                int color = image.getPixel(j, i);

                if(color == Color.RED)
                {
                    x = j;
                    y = i;
                }
            }
        }

        c.drawRect(x, y, x + 20, y + 20, p);
        //c.drawRect(30, 30, 100, 100, p);

        saveToFile(tempImage);

        return tempImage;
    }

    private void saveToFile(Bitmap bmp) {
        FileOutputStream out = null;
        try {
            takeScreenSchot();
            out = new FileOutputStream(String.format("/sdcard/Test%d.jpg", System.currentTimeMillis()));
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, out); // bmp is your Bitmap instance
            // PNG is a lossless format, the compression factor (100) is ignored
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void takeScreenSchot() throws IOException, InterruptedException {
        Process sh = Runtime.getRuntime().exec("su", null,null);

        OutputStream os = sh.getOutputStream();
        os.write(("/system/bin/screencap -p " + "/sdcard/123img.jpg").getBytes("ASCII"));
        os.flush();

        os.close();
        sh.waitFor();
    }
}
