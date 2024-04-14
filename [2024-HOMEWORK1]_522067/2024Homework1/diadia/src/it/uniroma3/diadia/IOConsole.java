package it.uniroma3.diadia;

import java.util.Scanner;

public class IOConsole {
	/**
	 * questo metodo stampa il messaggio
	 * @param msg
	 */
	public void mostraMessaggio(String msg) {
		System.out.println(msg);
	}

	/**
	 * questo metodo legge la riga che è stata inserita come Input
	 * @return
	 */
	public String leggiRiga() {
		Scanner scannerDiLinee = new Scanner(System.in);
		String riga = scannerDiLinee.nextLine();
		//scannerDiLinee.close();
		return riga;
	}
}