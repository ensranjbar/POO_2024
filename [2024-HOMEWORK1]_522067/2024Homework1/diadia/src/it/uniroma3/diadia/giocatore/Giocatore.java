package it.uniroma3.diadia.giocatore;

/**
 * è una classe che definisce un giocatore e cfu iniziali e setCfu
 * @author ensra
 *
 */
public class Giocatore {

	static final private int CFU_INIZIALI = 20;
	private int cfu;
	private Borsa borsa;

	/* COSTRUTTORE */
	public Giocatore() {
		this.cfu = CFU_INIZIALI;
		this.borsa = new Borsa();
	}

	public Borsa getBorsa() {
		return borsa;
	}

	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;
	}

}
