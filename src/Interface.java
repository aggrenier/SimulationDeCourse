import java.awt.Dimension;

import javax.swing.*;



public class Interface extends JFrame {
	
	private Fabriquer fab = new Fabriquer();	
	private JTabbedPane jtpTab = new JTabbedPane();
	private Simulateur sim = new Simulateur();
	
	
	public Interface(){
		
		this.add(jtpTab);
		
		jtpTab.add(fab, "Fabrication");
		jtpTab.add(sim,"Simulateur");
		
		//this.setPreferredSize(new Dimension(100,800));
		this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible( true );
	}
	
	public static void main(String[] args) {
		
		try {
			// Set System L&F
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			// handle exception
		}
		
		new Interface();
	}
}
