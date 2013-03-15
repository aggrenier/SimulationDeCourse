//============================================================================
// Programmeur: Daniel
// Date: 2013-03-13
// Fichier: Auto.java
// Description: 
//============================================================================

import java.awt.*;
import javax.swing.*;
import java.awt.image.*;

//============================================================================
public class Auto 
//============================================================================
{

	//Variables statiques
	public static BufferedImage[][] auto = new BufferedImage[6][360];
	
	static {
		Image[] img = new Image[6];
		for (int i = 0; i < img.length; i++) {
			img[i] = new ImageIcon(
				Auto.class.getResource("images/auto"+i+".png")).getImage();	
		}
		double delta = 2*Math.PI/auto[0].length;
		Graphics2D g = null;
		for( int i=0 ; i<img.length ; i++ ) {
			for( int j=0 ; j<auto[0].length ; j++ ) {
				auto[i][j] = new BufferedImage(49,49,BufferedImage.TYPE_INT_ARGB);
				g = auto[i][j].createGraphics();
				g.rotate(-j*delta,24,24);
				g.drawImage( img[i] , 0 , 0 , null );
				g.rotate(j*delta,24,24);
			}
		}
	}	
}
























































