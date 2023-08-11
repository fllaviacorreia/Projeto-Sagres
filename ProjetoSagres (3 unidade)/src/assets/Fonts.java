package assets;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

public class Fonts {
	//create the font
//	private Font customFont = null;

	public Font setFont(String src, float size) {
		try {
			//create the font to use. Specify the size
//			customFont = Font.createFont(Font.TRUETYPE_FONT, new File("assets/fonts/open_sans_regular.ttf")).deriveFont(20f);
//			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//			//register the font
//			ge.registerFont(customFont);
			
			
			 //Returned font is of pt size 1
		     Font font = Font.createFont(Font.TRUETYPE_FONT, new File(src));

		     //Derive and return a 12 pt version:
		     //Need to use float otherwise
		     //it would be interpreted as style

		     return font.deriveFont(size);
		     
		} catch (IOException|FontFormatException e) {
			e.printStackTrace();
		}
		
		return null;
	}

//	public Font getCustomFont() {
////		if(customFont == null) {
////			setFont(); 
////		}
////		return customFont;
//	}
//
//	public void setCustomFont(Font customFont) {
//		this.customFont = customFont;
//	}
	

}
