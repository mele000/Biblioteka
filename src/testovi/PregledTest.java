package testovi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import biblioteka.Knjiga;
import biblioteka.Pregled;
import biblioteka.Racun;

class PregledTest {

	Pregled obj;
	Racun racun;
	Racun racun2;
	Knjiga knjiga;
	int brojRacunaKojiNePostoji;
	int brojRacunaKojiPostoji;

	@BeforeEach
	void setUp() throws Exception {
		obj = new Pregled();
		racun = new Racun();
		racun2 = new Racun();
		knjiga = new Knjiga();
		racun.setBrojRacuna(1);
		racun2.setBrojRacuna(2);
		knjiga.setBrojKnjige(1);
		brojRacunaKojiNePostoji = 86393;
		brojRacunaKojiPostoji = 1;
		Racun.pohranjeniRacuni.add(racun);
		Racun.pohranjeniRacuni.add(racun2);
		Knjiga.pohranjeneKnjige.add(knjiga);
		racun2.pohranjeniKnjigeNaRacunu.add(knjiga);

	}

	@AfterEach
	void tearDown() throws Exception {
		obj = null;
		racun = null;
		knjiga = null;
		racun2 = null;
	}


	@Test
	public void shouldReturnFasleWhenUserDontHaveAnyBook() {
		boolean rez = obj.imaLiKorisnikPodignutihKnjiga(1);
		assertFalse(rez);
	}

	@Test
	public void shouldReturnTrueWhenUserHaveAnyBook() {
		boolean rez = obj.imaLiKorisnikPodignutihKnjiga(2);
		assertTrue(rez);
	}

}
