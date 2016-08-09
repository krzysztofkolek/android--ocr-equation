package ImageProcessing;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;

public class ImageLoader extends ApplicationImageContent {

    public ImageLoader() {
        super();
    }

    public Bitmap loadImage(String filename, boolean fullPath) {
        String fileLocation = ApplicationImagePath + filename;
        if(fullPath) {
            fileLocation = filename;
        }

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap bitmap = BitmapFactory.decodeFile(fileLocation, options);
        return bitmap;
    }
}
