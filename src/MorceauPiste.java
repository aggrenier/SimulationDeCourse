import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MorceauPiste extends JLabel {

	private int valeur = 0;

	// variable statique
	static ImageIcon img[] = new ImageIcon[11];

	static {

		for (int i = 0; i < 6; i++) {

			img[i] = new ImageIcon(
					MorceauPisteDemo.class.getResource("piste/piste" + i
							+ ".png"));
		}
	}

	public MorceauPiste() {

		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.setPreferredSize(new Dimension(100, 100));
		this.setInheritsPopupMenu(true);
	}

	// initialiste les elements visuels
	public void setValeur(int valeur) {

		this.valeur = valeur;
		this.setIcon(img[valeur]);
	}
}
