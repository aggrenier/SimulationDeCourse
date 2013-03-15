//============================================================================
// Programmeur: Daniel
// Date: 2013-03-08=7
// Fichier: Simulateur.java
// Description: 
//============================================================================

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//============================================================================
public class Simulateur extends JPanel implements ActionListener
//============================================================================
{
	//Variables
	private Piste piste = new Piste();
	private JButton jbtnDemarrer = new JButton("D�marrer");
	private JButton jbtnArreter = new JButton("Arr�ter");

	//------------------------------------------------------------------------
	public Simulateur()
	//------------------------------------------------------------------------
	{
		super();
		JPanel jpnlBas = new JPanel( new GridLayout(1,2,5,5) );
		this.setLayout( new BorderLayout(5,5) );
		this.add( piste );
		this.add( jpnlBas , "South" );
		jpnlBas.add( jbtnArreter );
		jpnlBas.add( jbtnDemarrer );
		//((JPanel)getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		jbtnDemarrer.addActionListener(this);
		jbtnArreter.addActionListener(this);
	}
	
	//------------------------------------------------------------------------
	public void actionPerformed( ActionEvent ae )
	//------------------------------------------------------------------------
	{
		Object src = ae.getSource();
		if( src == jbtnDemarrer ) {
			piste.demarrer();
		}
		else if( src == jbtnArreter ) {
			piste.arreter();
		}
	}	
}
