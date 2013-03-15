import java.awt.*;

import javax.swing.*;

public class MorceauPisteDemo extends JLabel {

	private int valeur = 0;

	// variable statique
	static ImageIcon img[] = new ImageIcon[11];

	static {

		for (int i = 0; i < 6; i++) {

			img[i] = new ImageIcon(MorceauPisteDemo.class.getResource("piste/piste"+i+".png"));
		}
	}

	public MorceauPisteDemo() {

		this(0);
	}

	// constructeur avec parametre
	public MorceauPisteDemo(int valeur) {

		// initialise la valeur
		this.valeur = valeur;
		this.setBackground(Color.white);

		// Methode qui initilise le composant
		initialieGUI();
		EnregistrerListeners();
	}

	// initialiste les elements visuels
	private void initialieGUI() {

		this.setIcon(img[valeur]);
	}

	// enregistrer les Listeners
	private void EnregistrerListeners() {

		// this.addMouseListener(this);
	}

}
