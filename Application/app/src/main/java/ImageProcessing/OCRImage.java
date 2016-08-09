package ImageProcessing;

import android.graphics.Bitmap;

public class OCRImage {
    private Bitmap _bitmap = null;

    public OCRImage(Bitmap bitmap) {
        this._bitmap = bitmap;
    }

    public String getResult() {
        return "";
    }
}
