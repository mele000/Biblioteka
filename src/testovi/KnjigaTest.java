package testovi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import biblioteka.Knjiga;
import biblioteka.Racun;

class KnjigaTest {

	
	Knjiga obj;
	Knjiga knjiga;
	int brojKnjigeKojaNePostoji;
	int brojKnjigeKojaPostoji;


	
	@BeforeEach
	void setUp() throws Exception {
		obj = new Knjiga();
		knjiga = new Knjiga();
		knjiga.setBrojKnjige(1);
		Knjiga.pohranjeneKnjige.add(knjiga);
		brojKnjigeKojaNePostoji = 5;
		brojKnjigeKojaPostoji = 1;


	}

	@AfterEach
	void tearDown() throws Exception {
		obj = null;
		knjiga = null;

	}

	@Test
	public void shouldReturnFalseWhenAccountDoesntExistInAL() {
		boolean rez = obj.postojiLiIstaKnjiga(brojKnjigeKojaNePostoji);
		assertFalse(rez);
	}

	@Test
	public void shouldReturnTrueWhenAccountExistInAL() {
		boolean rez = obj.postojiLiIstaKnjiga(brojKnjigeKojaPostoji);
		assertTrue(rez);
	}


}
