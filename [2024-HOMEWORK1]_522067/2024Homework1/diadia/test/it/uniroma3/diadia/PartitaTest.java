package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {
	/*queste tre partita per vedere se partita è vinta
	 * metodo vinta*/
	
		private Partita partita1;//corrente è diverso da vincente
		private Partita partita2;//corrente uguale a vincente
		private Partita partita3;//corrente è null
		private Stanza corrente1;
		
		
	/*queste partite per vedere se partita isFinita*/
		/*metodo isFinita*/
		private Partita partita4;
		private Partita partita5;
		private Partita partita6;
		private Partita partita7;
		private Partita partita8;
		private Partita partita9;
		private Partita partita10;
		private Partita partita11;
		private Partita partita12;
		
		
	
		@Before
		public void setUp() {
			
			//corrente è diverso da vincente 
			//metodo vinta
			this.partita1=new Partita();
			this.corrente1=new Stanza("corrente1");
			this.partita1.setStanzaCorrente(corrente1);
			
			
			//corrente è uguale vincente
			this.partita2=new Partita();
			this.partita2.setStanzaCorrente(this.partita2.getStanzaVincente());
			
			//corrente è null
			this.partita3=new Partita();
			
			
			
			/*per metodo isFinita*/
			
			//finita=1,vinta=0,cfu=1
			this.partita4=new Partita();
			this.partita4.setFinita();
			
			//finita=1,vinta=1,cfu=1
			this.partita5=new Partita();
			this.partita5.setFinita();
			this.partita5.setStanzaCorrente(this.partita5.getStanzaVincente());
			
			//finita=1,vinta=1,cfu=0
			this.partita6=new Partita();
			this.partita6.setFinita();
			this.partita6.setStanzaCorrente(this.partita6.getStanzaVincente());
			this.partita6.getGiocatore().setCfu(0);
			
			//finita=0,vinta=0,cfu=1
			this.partita7=new Partita();
		
			//finita=0,vinta=1,,cfu=1
			this.partita8=new Partita();
			this.partita8.setStanzaCorrente(this.partita8.getStanzaVincente());
			
			//finita=0,vinta=1,cfu=0
			this.partita9=new Partita();
			this.partita9.setStanzaCorrente(this.partita9.getStanzaVincente());
			this.partita9.getGiocatore().setCfu(0);
			
			/*
			this.partita10=new Partita();
			this.partita11=new Partita();
			this.partita12=new Partita();*/
			
		}
		
		
		/**
		 * test per metodo vinta
		 */
		@Test
		public void testPartita1CorrenteDiversoDaVincente(){
			assertEquals(false,this.partita1.vinta());
		}
		@Test
		public void testPartita2CorrenteUgualeVincente() {
			assertEquals(true,this.partita2.vinta());
		}
		@Test
		public void testPartita3CorrenteNull() {
			assertEquals(false ,this.partita3.vinta());
		}
		
		
		/**
		 * test per metodo isFinita
		 */
		@Test
		public void testIsFinita1Vinta0Cfu1() {
			assertEquals(true,this.partita4.isFinita()); 
		}
		@Test
		public void testIsFinita1Vinta1Cfu1() {
			assertEquals(true,this.partita5.isFinita());
		}
		@Test
		 public void testIsFinita1Vinta1Cfu0() {
			assertEquals(true,this.partita6.isFinita());
		}
		@Test
		public void testIsFinita0Vinta0Cfu1() {
			assertEquals(false,this.partita7.isFinita());
		}
		@Test
		public void testIsFinita0Vinta1Cfu1() {
			assertEquals(true,this.partita8.isFinita());
		}
		@Test
		public void testIsFinita0Vinta1Cfu0() {
			assertEquals(true,this.partita9.isFinita());
		}
}
