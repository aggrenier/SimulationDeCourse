//============================================================================
// Programmeur: dmorin
// Date: 2013-03-12
// Fichier: Voiture.java
// Description: 
//============================================================================


//============================================================================
public class Voiture implements Comparable<Voiture>
//============================================================================
{

	//Variables d'instance
	private int numero = 0;
	private double vitesse = 0.0;	//Vitesse courante
	private double vitessePreferee = 0.0;	//Vitesse preferee
	public int type = (int)(Math.random()*6);
	public int voieCourante = 0;
	private double distance = 0.0;
	private int rang = 0;
	public int indice = 0;
	private int nbTours = 0;
	
	//Variables statiques
	private static Voiture[][] position = null;
	
	//------------------------------------------------------------------------
	public Voiture( int distance , int vc , int n ) 
	//------------------------------------------------------------------------
	{
		this.distance = distance;
		this.voieCourante = vc;
		this.numero = n;
		switch( type ) {
		case 0:
		case 1:
			vitessePreferee = Math.random()*2+4;
			break;
		case 2:
		case 3:
			vitessePreferee = Math.random()*2+2;
			break;
		case 4:
		case 5:
			vitessePreferee = Math.random()*1.5+0.5;
			break;
		}
		this.indice = getIndice();
		position[voieCourante][indice] = this;
	}

	//------------------------------------------------------------------------
	public static void setPosition( Voiture[][] position ) 
	//------------------------------------------------------------------------
	{
		Voiture.position = position;
	}
	
	//------------------------------------------------------------------------
	private int getIndice() 
	//------------------------------------------------------------------------
	{
		return (int)((distance+Piste.n)%Piste.n);
	}
	
	//------------------------------------------------------------------------
	public void avancer() 
	//------------------------------------------------------------------------
	{
		position[voieCourante][indice] = null;
		Voiture v = null;
		for (int i = 1; i < 50; i++) {
			if( (v=position[voieCourante][(indice+i)%Piste.n])!=null ) {
				vitesse = v.vitesse;
				break;
			}
		}
		if( v == null ) {
			distance += vitesse;
			if( vitesse<vitessePreferee ) vitesse += 0.1;
			indice = getIndice();
		}
		position[voieCourante][indice] = this;
	}	

	@Override
	public int compareTo(Voiture v) {
		
		int rep = 0;
		
		if(this.distance > v.distance){
			rep = -1;
		}
		else if(this.distance < v.distance){
			rep = 1;
		}
		return rep;
	}	
}







