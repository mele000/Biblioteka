package testovi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import biblioteka.Knjiga;
import biblioteka.Main;
import biblioteka.Racun;
import biblioteka.Validacija;

class KnjigaTest {

	
	Validacija val;
	Knjiga knjiga;
	int brojKnjigeKojaNePostoji;
	int brojKnjigeKojaPostoji;


	
	@BeforeEach
	void setUp() throws Exception {
		val = new Validacija();
		knjiga = new Knjiga();
		knjiga.setBrojKnjige(1);
		Main.pohranjeneKnjige.add(knjiga);
		brojKnjigeKojaNePostoji = 5;
		brojKnjigeKojaPostoji = 1;


	}

	@AfterEach
	void tearDown() throws Exception {
		val = null;
		knjiga = null;

	}

	@Test
	public void shouldReturnFalseWhenAccountDoesntExistInAL() {
		boolean rez = val.postojiLiIstaKnjiga(brojKnjigeKojaNePostoji);
		assertFalse(rez);
	}

	@Test
	public void shouldReturnTrueWhenAccountExistInAL() {
		boolean rez = val.postojiLiIstaKnjiga(brojKnjigeKojaPostoji);
		assertTrue(rez);
	}


}
