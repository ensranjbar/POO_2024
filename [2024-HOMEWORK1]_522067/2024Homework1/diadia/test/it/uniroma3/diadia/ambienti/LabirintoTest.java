package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 * classe test per  classe Labirinto
 * @author ensra
 *
 */
public class LabirintoTest {
	private Labirinto labirinto;
	private Stanza stanza1;
	private Stanza stanza2;
	
	@Before
	public void setUp() {
		this.labirinto=new Labirinto();
		stanza1=this.labirinto.getStanzaCorrente();
		stanza2=this.labirinto.getStanzaVincente();
	}

	@Test
	public void testStanzaCorrente() {
		assertEquals(stanza1, this.labirinto.getStanzaCorrente());
	}
	
	@Test
	public void testStanzaVincente() {
		assertEquals(stanza2,this.labirinto.getStanzaVincente());
	}

}
