package testovi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import biblioteka.Knjiga;
import biblioteka.Main;
import biblioteka.Racun;
import biblioteka.Validacija;

class ValidacijaTest {

	Validacija obj;
	Knjiga knjiga;
	int brojKnjigeKojaNePostoji;
	int brojKnjigeKojaPostoji;

	Knjiga knjiga2;

	Racun racun;
	int brojRacunaKojiNePostoji;
	int brojRacunaKojiPostoji;

	Racun racun2;

	@BeforeEach
	void setUp() throws Exception {
		obj = new Validacija();
		knjiga = new Knjiga();
		knjiga.setBrojKnjige(1);
		knjiga.setStatusKnjige(false);
		Main.pohranjeneKnjige.add(knjiga);
		brojKnjigeKojaNePostoji = 5;
		brojKnjigeKojaPostoji = 1;

		knjiga2 = new Knjiga();
		knjiga2.setBrojKnjige(2);
		knjiga2.setStatusKnjige(true);
		Main.pohranjeneKnjige.add(knjiga2);

		racun = new Racun();
		racun.setBrojRacuna(1);
		Main.pohranjeniRacuni.add(racun);
		brojRacunaKojiNePostoji = 5;
		brojRacunaKojiPostoji = 1;

		racun2 = new Racun();
		racun2.setBrojRacuna(2);
		Main.pohranjeniRacuni.add(racun2);
		racun2.pohranjeniKnjigeNaRacunu.add(knjiga);
		racun2.setBrojPosudjenihKnjigaPovecaj();

	}

	@AfterEach
	void tearDown() throws Exception {
		obj = null;
		knjiga = null;
		knjiga2 = null;
		racun = null;
		racun2 = null;
	}

	@Test
	public void shouldReturnNullWhenAccountDoesntExistInAL() {
		Racun rez = obj.vratiRacun(brojRacunaKojiNePostoji);
		assertNull(rez);
	}

	@Test
	public void shouldReturnExactObjectWhenAccountExistInAL() {
		Racun rez = obj.vratiRacun(brojRacunaKojiPostoji);
		assertEquals(1, rez.getBrojRacuna());
	}

	@Test
	public void shouldReturnNullWhenBookDoesntExistInAL() {
		Knjiga rez = obj.vratiKnjigu(brojKnjigeKojaNePostoji);
		assertNull(rez);
	}

	@Test
	public void shouldReturnExactObjectWhenBookExistInAL() {
		Knjiga rez = obj.vratiKnjigu(brojKnjigeKojaPostoji);
		assertEquals(1, rez.getBrojKnjige());
	}

	@Test
	public void shouldReturnFalseWhenBookIsNotAvailable() {
		boolean rez = obj.jeLiKnjigaDostupna(1);
		assertFalse(rez);
	}

	@Test
	public void shouldReturnTrueWhenBookIsAvailable() {
		boolean rez = obj.jeLiKnjigaDostupna(2);
		assertTrue(rez);
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

	@Test
	public void shouldReturnFalseWhenAccountDoesntExistInAL() {
		boolean rez = obj.postojiLiIstiRacun(brojRacunaKojiNePostoji);
		assertFalse(rez);
	}

	@Test
	public void shouldReturnTrueWhenAccountExistInAL() {
		boolean rez = obj.postojiLiIstiRacun(brojRacunaKojiPostoji);
		assertTrue(rez);
	}

	@Test
	public void shouldReturnFalseWhenBookDoesntExistInAL() {
		boolean rez = obj.postojiLiIstaKnjiga(brojKnjigeKojaNePostoji);
		assertFalse(rez);
	}

	@Test
	public void shouldReturnTrueWhenBookExistInAL() {
		boolean rez = obj.postojiLiIstaKnjiga(brojKnjigeKojaPostoji);
		assertTrue(rez);
	}

}
