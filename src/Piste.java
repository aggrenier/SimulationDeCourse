//============================================================================
// Programmeur: daniel
// Date: 2013-03-07
// Fichier: Piste.java
// Description: 
//============================================================================

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;

//============================================================================
public class Piste extends JComponent implements Runnable
//============================================================================
{
	//Variables d'instance
	private Thread fil = null;
	private BufferedImage tampon = 
		new BufferedImage(541,541,BufferedImage.TYPE_INT_ARGB);
	private Graphics2D gTampon = (Graphics2D)tampon.getGraphics();
	public static int n = 1400;  // 2 x pi x 220
	private int[][] x = new int[2][n];
	private int[][] y = new int[2][n];
	private int[] nim = new int[n]; //Numéro de l'image

	//Variables statiques
	private static Image imgPiste = new ImageIcon(
		Piste.class.getResource("images/piste.png")).getImage();
	private static Image imgFond = new ImageIcon(
			Piste.class.getResource("images/fond1.jpg")).getImage();	
	private Image[][] auto = Auto.auto;
		
	//----------------------------------------------------------------------------
	public Piste() 
	//----------------------------------------------------------------------------
	{
		//Calcul des coordonnées
		double delta = 2*Math.PI/n;
		for( int i=0 ; i<n ; i++ ) {
			x[0][i] = (int)(270 + 235*Math.cos(i*delta)+0.5 - 24);
			x[1][i] = (int)(270 + 211*Math.cos(i*delta)+0.5 - 24);
			y[0][i] = (int)(270 - 235*Math.sin(i*delta)+0.5 - 24);
			y[1][i] = (int)(270 - 211*Math.sin(i*delta)+0.5 - 24);
			nim[i] = (int)(1.0*auto[0].length * i / n);
		}		
		gTampon.setRenderingHint(
				RenderingHints.KEY_ANTIALIASING, 
				RenderingHints.VALUE_ANTIALIAS_ON);
		gTampon.drawImage( imgFond , 0 , 0 , 541 , 541 , this );
		gTampon.drawImage( imgPiste , 0 , 0 , this );
		//this.setPreferredSize(new Dimension(541,541));
	}
	
	//----------------------------------------------------------------------------
	public void demarrer() 
	//----------------------------------------------------------------------------
	{
		if( fil == null ) {
			
			Voiture[][] position = new Voiture[2][n];
			Voiture.setPosition( position );
			
			fil = new Thread( this );
			fil.start();
		}
	}

	//----------------------------------------------------------------------------
	public void run()
	//----------------------------------------------------------------------------
	{
		gTampon.setColor( Color.yellow );
		Voiture[] v = new Voiture[10];
		for (int j = 0; j < v.length; j++) {
			v[j] = new Voiture( -80*j , j%2 , j+1 );
		}
		
		Observateur spotter = new Observateur(v);
		spotter.demarrer();
		gTampon.setColor(new Color(255,255,255,100));
				
		do {
			gTampon.drawImage( imgFond , 0 , 0 , 541 , 541 , this );
			gTampon.drawImage( imgPiste , 0 , 0 , this );
			for (int j = 0; j < v.length; j++) {
				
				if(j == 0){
					gTampon.fillOval(
						x[v[j].voieCourante][v[j].indice], 
						y[v[j].voieCourante][v[j].indice],
						49,
						49);
				}
				
				gTampon.drawImage( 
						auto[v[j].type][nim[v[j].indice]] , 
						x[v[j].voieCourante][v[j].indice] , 
						y[v[j].voieCourante][v[j].indice] , null );
				v[j].avancer();
			}
			getGraphics().drawImage( tampon , 0 , 0 , null );
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
			}
		} while( fil != null );
		
		spotter.arreter();
	}
	
	//----------------------------------------------------------------------------
	public void arreter() 
	//----------------------------------------------------------------------------
	{
		fil = null;
	}

	//----------------------------------------------------------------------------
	public void paintComponent( Graphics g ) 
	//----------------------------------------------------------------------------
	{
		g.drawImage( tampon , 0 , 0 , this );
	}

}







