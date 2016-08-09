package ImageProcessing;

import android.os.Environment;
import java.io.File;

public abstract class ApplicationImageContent {
    public String ApplicationImagePath = "/sdcard/";
    public String FileName = null;
    public String DefaultFileName = "temp";

    public ApplicationImageContent() {
        chceckAndCreateDirectory();
    }

    public void setFileName(String filename) {
        FileName = filename;
    }

    private void chceckAndCreateDirectory() {
        File dir = new File(ApplicationImagePath);
        if(!dir.exists() && dir.isDirectory()) {
            dir.mkdir();
        }
    }

    public String getFileWithPath() {
        if(FileName == null) {
            FileName = DefaultFileName;
        }
        return String.format("/%s/%s.jpg", ApplicationImagePath, FileName);
    }
}
