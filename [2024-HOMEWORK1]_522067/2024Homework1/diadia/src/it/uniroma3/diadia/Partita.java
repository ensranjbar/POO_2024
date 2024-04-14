package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	private Labirinto labirinto;
	private Giocatore giocatore;
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	private boolean finita;

	public Partita() {
		labirinto = new Labirinto();
		
		this.finita = false;
		stanzaCorrente = labirinto.getStanzaCorrente();
		stanzaVincente =labirinto.getStanzaVincente();
		giocatore = new Giocatore();

	}

	/**
	 * 
	 * @return stanzaVincente
	 */
	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

	/**
	 * aggiorna stanzaCorrente con la prossima
	 * 
	 * @param stanzaCorrente
	 */
	public void setStanzaCorrente(Stanza prossimaStanza) {
		this.stanzaCorrente = prossimaStanza;
	}

	/**
	 * 
	 * @return stanzaCorrente
	 */
	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}

	/**
	 * 
	 * @return giocatore
	 */
	public Giocatore getGiocatore() {
		return giocatore;
	}

	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * 
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente() == this.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * 
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (this.giocatore.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

}
