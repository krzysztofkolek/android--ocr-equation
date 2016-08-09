package ImageProcessing;

import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageSaver extends ApplicationImageContent {

    private byte[] _bitmap = null;


    public ImageSaver() {
        super();
    }

    public void setData(Bitmap bitmap) {
        this._bitmap = transformImageToByteArray(bitmap);
    }

    public void setData(byte[] bitmap) {
        this._bitmap = bitmap;
    }

    private byte[] transformImageToByteArray(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();

        return byteArray;
    }

    public void saveImage() throws Exception {
        if (_bitmap == null) {
            throw new Exception("No data!");
        }

        try {
            FileOutputStream outStream = null;

            outStream = new FileOutputStream(getFileWithPath());
            outStream.write(_bitmap);
            outStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }


}


