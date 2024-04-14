package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {

	private Stanza stanzaNord;
	private Stanza stanzaSud;
	private Stanza stanzaEst;
	private Stanza stanzaOvest;
	private Stanza stanzaVuotaAdiacente;
	private Stanza stanzaPiena;
	
	private Attrezzo attrezzo01;
	private Attrezzo attrezzo02;
	private Attrezzo attrezzo03;
	private Attrezzo attrezzo04;
	private Attrezzo attrezzo05;
	private Attrezzo attrezzo06;
	private Attrezzo attrezzo07;
	private Attrezzo attrezzo08;
	private Attrezzo attrezzo09;
	private Attrezzo attrezzo10;
	private Attrezzo attrezzo11;
	
	@Before
	public void setUp() {
		this.stanzaNord=new Stanza("nord");
		this.stanzaSud=new Stanza("sud");
		this.stanzaEst=new Stanza("est");
		this.stanzaOvest=new Stanza("ovest");
		this.stanzaVuotaAdiacente=new Stanza("stanza vuota adiacente");
		this.stanzaPiena=new Stanza("stanza piena ");
		/*
		 * this.stanzaVuotaAdiacente.impostaStanzaAdiacente("nord", stanzaNord);
		this.stanzaVuotaAdiacente.impostaStanzaAdiacente("sud", stanzaSud);
		this.stanzaVuotaAdiacente.impostaStanzaAdiacente("est", stanzaEst);
		this.stanzaVuotaAdiacente.impostaStanzaAdiacente("ovest", stanzaOvest);
		*/
		this.attrezzo01=new Attrezzo("a01",2);
		this.attrezzo02=new Attrezzo("a02",10);
		this.attrezzo03=new Attrezzo("a03",4);
		this.attrezzo04=new Attrezzo("a04",1);
		this.attrezzo05=new Attrezzo("a05",3);
		this.attrezzo06=new Attrezzo("a06",20);
		this.attrezzo07=new Attrezzo("a07",15);
		this.attrezzo08=new Attrezzo("a08",4);
		this.attrezzo09=new Attrezzo("a09",1);
		this.attrezzo10=new Attrezzo("a10",2);
		this.attrezzo11=new Attrezzo("a11",25);
		
		
		
		this.stanzaPiena.addAttrezzo(attrezzo01);
		this.stanzaPiena.addAttrezzo(attrezzo02);
		this.stanzaPiena.addAttrezzo(attrezzo03);
		this.stanzaPiena.addAttrezzo(attrezzo04);
		this.stanzaPiena.addAttrezzo(attrezzo05);
		this.stanzaPiena.addAttrezzo(attrezzo06);
		
		
		
	}
	
	
	
	
	/**
	 * metodo Test per impostaStanzaAdiacente 
	 */
	
	@Test
	public void testImpostaAdiacenteNord() {
		this.stanzaPiena.impostaStanzaAdiacente("nord", stanzaNord);
		assertEquals("Errore per impostazione Nord",stanzaNord,this.stanzaPiena.getStanzaAdiacente("nord"));
	}
	@Test
	public void testImpostaAdiacenteSud() {
		this.stanzaPiena.impostaStanzaAdiacente("sud", stanzaSud);
		assertEquals("Errore per impostazione a Sud",stanzaSud,this.stanzaPiena.getStanzaAdiacente("sud"));
	}
	@Test
	public void testImpostaAdiacenteEst() {
		this.stanzaPiena.impostaStanzaAdiacente("est", stanzaEst);		
		assertEquals("Errore per impostazione a Est",stanzaEst,this.stanzaPiena.getStanzaAdiacente("est"));
		
	}
	@Test
	public void testImpostaAdiacenteOvest() {
		this.stanzaPiena.impostaStanzaAdiacente("ovest", stanzaOvest);
		assertEquals("Errore per impostazione a Ovest",stanzaOvest,this.stanzaPiena.getStanzaAdiacente("ovest"));
		
	}
	@Test
	public void testImpostaAdiacenteDirezioneNulla() {
		this.stanzaPiena.impostaStanzaAdiacente(null, stanzaEst);
		assertEquals("Errore Impostazione direzione Nulla",null,this.stanzaPiena.getStanzaAdiacente(null));
	}
	
	@Test 
	public void testImpostaDirezioneErrata() {
		this.stanzaPiena.impostaStanzaAdiacente("uds", stanzaSud);
		assertEquals("Errore Impostazione su direzione Sbagliata",stanzaSud,this.stanzaPiena.getStanzaAdiacente("uds"));
		
	}
	
	@Test 
	public  void testImpostaStanzaAdiacenteNulla() {
		this.stanzaPiena.impostaStanzaAdiacente("nord", null);
		assertEquals("Errore su Impostazione direzione errata e stanza adiacente nulla",null,this.stanzaPiena.getStanzaAdiacente("nord"));
	}
	
	/**
	 * metodo Test per  getStanzaAdiacente
	 */
	
	@Test
	public void testAdiacenteNord() {
		this.stanzaVuotaAdiacente.impostaStanzaAdiacente("nord", stanzaNord);
		assertEquals("Errrore adiacente Nord",stanzaNord,this.stanzaVuotaAdiacente.getStanzaAdiacente("nord"));
	}
	@Test
	public void testAdiacenteSud() {
		this.stanzaVuotaAdiacente.impostaStanzaAdiacente("sud", stanzaSud);
		assertEquals("Errore adiacente sud" ,stanzaSud,this.stanzaVuotaAdiacente.getStanzaAdiacente("sud"));
	}
	@Test
	public void testAdiacenteEst() {
		this.stanzaVuotaAdiacente.impostaStanzaAdiacente("est", stanzaEst);
		assertEquals("Errore adiacente est",stanzaEst,this.stanzaVuotaAdiacente.getStanzaAdiacente("est"));	
	}
	@Test
	public void testAdiacenteOvest() {
		this.stanzaVuotaAdiacente.impostaStanzaAdiacente("ovest", stanzaOvest);
		assertEquals("Errore adiacente ovest",stanzaOvest,this.stanzaVuotaAdiacente.getStanzaAdiacente("ovest"));
	}
	

	
	
	
	/**
	 * metodo Test per getDescrizione
	 */
	
	/**
	 * metodo Test per addAttrezzo
	 */
	@Test 
	public void testAddAttrezzoStanzaPiena() {
		this.stanzaPiena.addAttrezzo(attrezzo08);
		this.stanzaPiena.addAttrezzo(attrezzo09);
		this.stanzaPiena.addAttrezzo(attrezzo07);
		this.stanzaPiena.addAttrezzo(attrezzo11);
		assertEquals("Errore non ha potuto aggiungerlo",false,this.stanzaPiena.addAttrezzo(attrezzo10) );
	}
	
	@Test 
	public void testAddAttrezzoStanzaVuota() {
		assertEquals("Errore,doveva aggiungerlo",true,this.stanzaVuotaAdiacente.addAttrezzo(attrezzo11));
		
	}
	@Test 
	public void testAddAttrezzoNessunAttrezzo() {
		assertEquals("Errore, non abbiamo aggiunto niente",false,this.stanzaVuotaAdiacente.addAttrezzo(null));
	}
	
	/**
	 * metodo Test per hasAttrezzo
	 */
	@Test
	public void testHasAttrezzoConAttrezzoPresente() {
		assertEquals("Errore l'attrezzo è presente",true,this.stanzaPiena.hasAttrezzo("a01"));
	}
	
	@Test
	public void testHasAttrezzoNonPresente() {
		assertEquals("Errore, l'attrezzo non è presente ",false,this.stanzaPiena.hasAttrezzo("a11"));
	}
	@Test
	public void testHasAttrezzoNonPresente2() {
		assertEquals("Errore, l'attrezzo non è presente ",false,this.stanzaVuotaAdiacente.hasAttrezzo("a11"));
	}
	@Test
	public void testHasAttrezzoSconosciuto() {
		assertEquals("Errore ,l'attrezzo non esiste in generale",false,this.stanzaPiena.hasAttrezzo("aaa"));
	}
	/**
	 * metodo Test per getAttrezzi
	 */
	@Test 
	public void testGetAttrezzoPresente() {
		assertEquals("Errore ,l'attrezzo è presente ",attrezzo02,this.stanzaPiena.getAttrezzo("a02"));
	}
	
	@Test 
	public void testGetAttrezzoNonPresente() {
		assertEquals("Errore,l'attrezzo non è presente",null,this.stanzaPiena.getAttrezzo("a11"));
		
	}
	@Test 
	public void testGetAttrezzoNonPresente2() {
		assertEquals("Errore,l'attrezzo non è presente",null,this.stanzaVuotaAdiacente.getAttrezzo("a11"));
			}
	
	@Test 
	public void testGetAttrezzoSconosciuto() {
		assertEquals("Errore,l'attrezzo è sconosciuto",null,this.stanzaPiena.getAttrezzo("aaaa"));
		
		
	}
	
	
	/**
	 * metodo Test per removeAttrezzo
	 */
	
	
	 @Test  
	public void testAttrezzoPresente() {
		assertEquals("Errore,attrezzo è stata cancellata",true,this.stanzaPiena.removeAttrezzo("a03"));
	}
	@Test
	public void testAttrezzoNonPresente() {
		assertEquals("Errore l'attrezzo non è presente per remove",false,this.stanzaPiena.removeAttrezzo("a09"));
	}

	@Test
	public void testAttrezzoNull() {
		assertEquals("Errore, l'attrezzo è null",false,this.stanzaPiena.removeAttrezzo(null));
	}
	




	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
