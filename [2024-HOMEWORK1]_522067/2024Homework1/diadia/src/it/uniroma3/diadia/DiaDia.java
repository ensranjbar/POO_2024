package it.uniroma3.diadia;

import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author docente di POO (da un'idea di Michael Kolling and David J. Barnes)
 * 
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""
			+ "Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n"
			+ "Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"
			+ "I locali sono popolati da strani personaggi, " + "alcuni amici, altri... chissa!\n"
			+ "Ci sono attrezzi che potrebbero servirti nell'impresa:\n"
			+ "puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n"
			+ "o regalarli se pensi che possano ingraziarti qualcuno.\n\n"
			+ "Per conoscere le istruzioni usa il comando 'aiuto'.";

	static final private String[] elencoComandi = { "vai + <direzione>", "aiuto", "fine" ,"prendi + <nomeAttrezzo>","posa + <nomeAtrrezzo>"};
	
	private static IOConsole io;
	private Partita partita;

	public DiaDia() {
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione;
		io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		
		do
			istruzione =io.leggiRiga();
		while (!processaIstruzione(istruzione));

	}

	/**
	 * Processa una istruzione
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false
	 *         altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
	
		Comando comandoDaEseguire = new Comando(istruzione);
	
		if(comandoDaEseguire.getNome()==null) {
			io.mostraMessaggio("devi digitare qualcosa");
			return false;
		}
		
		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine();
			return true;
		}
		else if (comandoDaEseguire.getNome().equals("vai")) {
			this.vai(comandoDaEseguire.getParametro());
		}

		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else
			io.mostraMessaggio("Comando sconosciuto");
		if(this.partita.getGiocatore().getCfu()==0) {
			io.mostraMessaggio("le cfu sono  terminati");
			this.fine();
		}
		if (this.partita.vinta()) {
			io.mostraMessaggio("Hai vinto!");
			return true;
		} else
			return false;
	}

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for (int i = 0; i < elencoComandi.length; i++)
			io.mostraMessaggio(elencoComandi[i] + " ");
		io.mostraMessaggio("");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra e ne stampa il
	 * nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if (direzione == null)
			io.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			io.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(cfu--);
		}
		io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}
	
	
	/**
	 * metodo prendi
	 * rimossi da Stanza aggiunti alla borsa
	 */
	public boolean prendi(String attrezzo) {
		if(this.partita.getStanzaCorrente().hasAttrezzo(attrezzo)) {
			Attrezzo attrezzoPreso=this.partita.getStanzaCorrente().getAttrezzo(attrezzo);
			if(this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzoPreso)) {
				if(this.partita.getStanzaCorrente().removeAttrezzo(attrezzo)) {
					io.mostraMessaggio("l'attrezzo "+attrezzo+"è stata preso da stanza e aggiunta nella borsa");
					return true;}
				}
				else
					io.mostraMessaggio("vai oltre al limite ");
			
			}
			else
				io.mostraMessaggio(" attrezzo non prensente");
				
		return false;
		}
	
	
	/**
	 * metodo posa
	 * rimossi dalla borsa e aggiunti in stanza
	 */
	public boolean posa(String attrezzo) {
		if(this.partita.getGiocatore().getBorsa().hasAttrezzo(attrezzo)) {
			Attrezzo attrezzoPosato=this.partita.getGiocatore().getBorsa().getAttrezzo(attrezzo);
			if(this.partita.getStanzaCorrente().addAttrezzo(attrezzoPosato)) {
				if(this.partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo)) {
					io.mostraMessaggio("l'attrezzo"+attrezzo+"è stata posato in stanza e rimossa da borsa");
					return true;
				}
			}
			else 
				io.mostraMessaggio("stanza è piena,mi dispiace");
				}	
			else
				io.mostraMessaggio("oggetto non è presente");
			return false;
	
	}
	
	
	

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		io.mostraMessaggio("Grazie di aver giocato!"); // si desidera smettere
	}

	public static void main(String[] argc) {
		io=new IOConsole();//abbiamo creato una sola istanza
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}