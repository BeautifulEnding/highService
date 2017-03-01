package action;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String path="G:\\Threesmall\\technology\\highservice\\images\\replacephoto.jpg";
        File photoPath=new File(path);
        try {
			BufferedImage image=ImageIO.read(photoPath);
	        System.out.println(image);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			e.getMessage();
		}

        
	}

}
