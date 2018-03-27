package br.com.lepsistemas.imagetwittertext.scanner;

import static org.bytedeco.javacpp.opencv_core.*;
import static org.bytedeco.javacpp.opencv_imgcodecs.*;
import static org.bytedeco.javacpp.opencv_imgproc.*;

import java.io.File;

import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacpp.opencv_core.CvSize;

public class ScannerImpl implements Scanner {

	@Override
	public String getTextFromImage(String imageFilePath) {
		File imageFile = new File(imageFilePath);
		String imagePathFile = imageFile.getAbsolutePath();
		IplImage image = cvLoadImage(imagePathFile);
		return null;
	}
	
	private IplImage downgradeScaleImage(IplImage image, int percent) {
		IplImage finalImage = cvCreateImage(new CvSize((image.width() * percent)/100, (image.height() * percent)/100), image.depth(), image.nChannels());
		cvResize(image, finalImage);
		return finalImage;
	}

}
