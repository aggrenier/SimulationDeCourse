public class Observateur extends Thread {

	private Voiture[] v = null;
	private boolean enMarche = false;

	public Observateur(Voiture v[]) {

		this.v = v;
	}

	public void run() {

		do {

			java.util.Arrays.sort(v);

			try {

				Thread.sleep(500);
			} catch (Exception e) {
			}

		} while (enMarche);
	}

	public void demarrer() {

		enMarche = true;
		start();
	}

	public void arreter() {

		enMarche = false;
	}
}
