package ImageProcessing;

import android.graphics.Bitmap;

public class ImageProcessingContext {

    private ImageCutting _cuttingTool = null;
    private ImageLoader _imageLoader = null;
    private OCRImage _ocrImage = null;

    public ImageProcessingContext(String file) {
        _imageLoader = new ImageLoader();
        Bitmap temp = _imageLoader.loadImage(file, false);

        _cuttingTool = new ImageCutting();
        //temp = _cuttingTool.getProcessedImage(temp);

        _ocrImage = new OCRImage(temp);
    }




    public String getResult() {
        return _ocrImage.getResult();
    }


}
