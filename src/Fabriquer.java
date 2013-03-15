import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class Fabriquer extends JPanel implements MouseListener, ActionListener {

	private int morceaupisteActuel = -1;
	private int morceaupistedemoActual = -1;
	private boolean valeur = false;

	private JLabel morceaupiste[] = new MorceauPiste[48];
	private int morceauListe[] = new int[48];
	private JLabel morceaupistedemo[] = new MorceauPisteDemo[6];

	private JPanel jplCentre = new JPanel(new FlowLayout());
	private JPanel jplPiste = new JPanel(new GridLayout(6, 8));
	private JPanel jplMorceau = new JPanel(new GridLayout(6, 1, 10, 5));
	private JPanel jplBas;

	private JLabel jlbLoad = new JLabel(new ImageIcon(getClass().getResource(
			"icon/save.png")));
	private JLabel jlbDelete = new JLabel(new ImageIcon(getClass().getResource(
			"icon/delete.png")));

	static ImageIcon img[] = new ImageIcon[11];

	static {

		for (int i = 0; i < 6; i++) {

			img[i] = new ImageIcon(
					MorceauPisteDemo.class.getResource("piste/piste" + i
							+ ".png"));
		}
	}

	public Fabriquer() {

		super(new BorderLayout());

		this.initialieGUI();
		this.EnregistrerListeners();
	}

	private void initialieGUI() {
		this.add(this.jplCentre, "Center");

		jplBas = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2 = (Graphics2D) g;

				Line2D line = new Line2D.Double(0, 0, 5000, 0);
				g2.setColor(Color.black);
				g2.setStroke(new BasicStroke(1));
				g2.draw(line);
			}
		};

		jplBas.setLayout(new FlowLayout());
		this.add(jplBas, "South");
		// jplBas.setBackground(new Color(255, 255, 255, 75));

		jplBas.add(jlbLoad);
		jlbLoad.setBackground(new Color(220, 220, 220, 200));

		jplBas.add(jlbDelete);
		jlbDelete.setBackground(new Color(220, 220, 220, 200));

		this.jplCentre.add(this.jplPiste, "Center");
		jplPiste.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		JPanel jplFiller = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2 = (Graphics2D) g;

				Line2D line = new Line2D.Double(this.getWidth() / 2, 0,
						this.getWidth() / 2, this.getHeight());
				g2.setColor(Color.black);
				g2.setStroke(new BasicStroke(1));
				g2.draw(line);
			}
		};
		jplFiller.setPreferredSize(new Dimension(50, 750));
		jplCentre.add(jplFiller);

		for (int i = 0; i < 48; i++) {

			this.morceaupiste[i] = new MorceauPiste();
			this.jplPiste.add(this.morceaupiste[i]);
			//this.jplPiste.setBackground(new Color(220, 220, 220, 200));
		}

		this.jplCentre.add(this.jplMorceau, "East");
		for (int i = 0; i < 6; i++) {

			morceaupistedemo[i] = new MorceauPisteDemo(i);
			this.morceaupistedemo[i].setBorder(BorderFactory
					.createLineBorder(Color.BLACK));
			jplMorceau.add(morceaupistedemo[i]);
		}

		//this.setBackground(new Color(220, 220, 220, 75));
		jplCentre.setBackground(new Color(220, 220, 220, 200));
		jplFiller.setBackground(new Color(220, 220, 220, 50));
		jplPiste.setBackground(new Color(220, 220, 220, 50));
		jplMorceau.setBackground(new Color(220, 220, 220, 200));
		jplBas.setBackground(Color.white);

		repaint();
	}

	private void EnregistrerListeners() {

		for (int i = 0; i < morceaupiste.length; i++) {

			morceaupiste[i].addMouseListener(this);
		}

		for (int i = 0; i < morceaupistedemo.length; i++) {

			morceaupistedemo[i].addMouseListener(this);
		}

		jlbLoad.addMouseListener(this);
		jlbDelete.addMouseListener(this);
	}

	public void mouseClicked(MouseEvent me) {

	}

	public void mouseEntered(MouseEvent me) {

		Object src = me.getSource();

		for (int i = 0; i < this.morceaupiste.length; i++) {

			if (src == this.morceaupiste[i] && this.morceaupisteActuel != i) {

				this.morceaupiste[i].setOpaque(true);

			}
		}

		for (int i = 0; i < morceaupistedemo.length; i++) {

			if (src == this.morceaupistedemo[i]
					&& this.morceaupistedemoActual != i) {

				this.morceaupistedemo[i].setOpaque(true);
			}
		}

		if (src == jlbLoad) {

			jlbLoad.setOpaque(true);
		}

		if (src == jlbDelete) {

			jlbDelete.setOpaque(true);
		}

		repaint();
	}

	public void mouseExited(MouseEvent me) {

		Object src = me.getSource();

		for (int i = 0; i < this.morceaupiste.length; i++) {

			if (src == this.morceaupiste[i] && this.morceaupisteActuel != i) {

				this.morceaupiste[i].setOpaque(false);
			}
		}

		for (int i = 0; i < morceaupistedemo.length; i++) {

			if (src == this.morceaupistedemo[i]
					&& this.morceaupistedemoActual != i) {

				this.morceaupistedemo[i].setOpaque(false);
			}
		}

		if (src == jlbLoad) {

			jlbLoad.setOpaque(false);
		}

		if (src == jlbDelete) {

			jlbDelete.setOpaque(false);
		}

		repaint();
	}

	public void mousePressed(MouseEvent me) {

		Object src = me.getSource();

		if (src == jlbLoad) {

			JOptionPane.showMessageDialog(this, "ehh... Saved!");
		}

		else if (src == jlbDelete) {

			effacerPiste();
		}

		PiecePisteDessin(src);

		repaint();
	}

	public void mouseReleased(MouseEvent me) {

	}

	private void PiecePisteDessin(Object src) {

		for (int i = 0; i < this.morceaupiste.length; i++) {

			this.morceaupiste[i].setOpaque(false);

			if (src == this.morceaupiste[i]) {

				this.morceaupiste[i].setOpaque(true);
				this.morceaupisteActuel = i;

				if (this.valeur == true) {

					this.morceaupiste[i].setIcon(img[morceaupistedemoActual]);
					morceauListe[i] = morceaupistedemoActual;
					valeur = false;
				}
			}
		}

		for (int i = 0; i < morceaupistedemo.length; i++) {

			this.morceaupistedemo[i].setOpaque(false);

			if (src == this.morceaupistedemo[i]) {

				this.morceaupistedemo[i].setOpaque(true);
				this.morceaupistedemoActual = i;
				valeur = true;
			}
		}
	}

	public void actionPerformed(ActionEvent e) {

		Object src = e.getSource();
	}

	private void effacerPiste() {

		for (int i = 0; i < 48; i++) {

			morceaupiste[i].setIcon(null);
			morceaupiste[i].revalidate();
			morceauListe[i] = -1;

			this.morceaupiste[i].setBorder(BorderFactory
					.createLineBorder(Color.BLACK));
		}

		for (int i = 0; i < morceaupistedemo.length; i++) {

			this.morceaupistedemo[i].setBorder(BorderFactory
					.createLineBorder(Color.BLACK));
		}
	}
}
