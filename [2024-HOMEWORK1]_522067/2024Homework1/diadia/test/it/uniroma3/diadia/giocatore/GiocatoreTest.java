package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 * classe test per classe Giocatore
 * @author ensra
 *
 */
public class GiocatoreTest {

	private Giocatore giocatore;

	@Before
	public void setUp() {
		this.giocatore = new Giocatore();

	}

	@Test
	public void testSetCfu() {
		this.giocatore.setCfu(2);
		assertEquals("Errore,deve essere 2", 2, this.giocatore.getCfu());
	}

	@Test
	public void testGetBorsaNotNull() {

		assertNotNull(this.giocatore.getBorsa());
	}

	@Test
	public void testGetCfu() {
		assertEquals("Errore ,deve essere 20", 20, this.giocatore.getCfu());
	}

}
