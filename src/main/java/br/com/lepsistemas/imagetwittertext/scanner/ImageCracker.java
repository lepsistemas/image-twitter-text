package br.com.lepsistemas.imagetwittertext.scanner;

import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.tesseract.TessBaseAPI;

import static org.bytedeco.javacpp.lept.*;

import java.io.File;
import java.net.URISyntaxException;

public class ImageCracker {

    public String crackImage(String filePath) throws URISyntaxException {
    		File tessFolder = new File("src/main/resources/tessdata/");
    		String tessFolderPath = tessFolder.getAbsolutePath();
    		
    		BytePointer outText;
    		
    		TessBaseAPI api = new TessBaseAPI();
    		if (api.Init(tessFolderPath, "eng") != 0) {
    			System.err.println("tesseract");
    		}
    		
    		PIX image = pixRead("src/main/resources/" + filePath);
    		api.SetImage(image);
    		
    		outText = api.GetUTF8Text();
    		
    		String string = outText.getString();
    		
    		api.End();
    		api.close();
    		
    		outText.deallocate();
    		pixDestroy(image);
    		
    		return string;
    }
}