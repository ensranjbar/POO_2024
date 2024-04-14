package it.uniroma3.diadia.giocatore;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * la classe test per classe Borsa
 * @author ensra
 *
 */
public class BorsaTest {

	private Borsa borsaPiena;
	private Borsa borsaVuota;
	private Attrezzo attrezzo01;
	private Attrezzo attrezzo02;
	
	@Before
	public void setUp() {
		borsaPiena=new Borsa();
		borsaVuota=new Borsa();
		this.attrezzo01=new Attrezzo("a01",2);
		this.attrezzo02=new Attrezzo("a02",10);
		
		this.borsaPiena.addAttrezzo(attrezzo01);
		
	}

	
	
	/**
	 * metodo test per AddAttrezzo
	 */
	public void testAddAttrezzoBorsaPiena() {
		assertEquals("Errore ,l'attrezzo non aggiunta a borsa",false,this.borsaPiena.addAttrezzo(attrezzo02));
	}
	public void testAddAttrezzoBorsaVuota() {
		assertEquals("Errore,l'attrezzo doveva essere aggiunta ",true,this.borsaVuota.addAttrezzo(attrezzo02));
	}
	public void testAddAttrezzoNullo() {
		assertEquals("Errore l'attrezzo  null",false,this.borsaPiena.addAttrezzo(null));
	}
	
	/**
	 * metodo test per getAttrezzo
	 */
	@Test
	public void testGetAttrezzoPresente() {
		assertEquals("Errore,Attrezzo deve essere presente",attrezzo01,this.borsaPiena.getAttrezzo("a01"));
	}
	@Test
	public void testAttrezzoNonPresente() {
		assertEquals("Errore ,attrezzo non  presente",null,this.borsaPiena.getAttrezzo("a03"));
	
	}
	@Test
	public void testAttrezzoNonPresente2() {
		assertEquals("Errore ,attrezzo non  presente",null,this.borsaVuota.getAttrezzo("a03"));
			
	}
	
	
	/**
	 * metodo test per hasAttrezzo
	 */
	@Test
	public void testHasAttrezzoPresente() {
		assertEquals("Errore ,Attrezzo deve essere presente ",true,this.borsaPiena.hasAttrezzo("a01"));
	}
	@Test
	public void testHasAttrezzoNonPresente() {
		assertEquals("Errore ,Attrezzo non  presente",false,this.borsaPiena.hasAttrezzo("a03"));
	}
	
	@Test
	public void testHasAttrezzoNonPresente2() {
		assertEquals("Errore ,Attrezzo non  presente ",false,this.borsaVuota.hasAttrezzo("a03"));	
	}
	/**
	 * metodo test per removeAttrezzo
	 */
	
	@Test
	public void tesAttrezzoPresente() {
		assertEquals("Errore l'Attrezzo  presente � borsa piena",true,this.borsaPiena.removeAttrezzo("a01"));
	}
	
	@Test
	public void testAttrezzoNull() {
		assertEquals("Errore attrezzo inserito  null",false,this.borsaPiena.removeAttrezzo(null));
	}
	
	@Test
	public void testAttrezzoNonPresentePerRemove() {
		assertEquals("Errore attrezzo non  presente per remove",false,this.borsaPiena.removeAttrezzo("a11"));
	}
	@Test
	public void testAttrezzoNonPresentePerRemove2() {
		assertEquals("Errore attrezzo non  presente per remove",false,this.borsaVuota.removeAttrezzo("a11"));
	}
	
	
	
}
