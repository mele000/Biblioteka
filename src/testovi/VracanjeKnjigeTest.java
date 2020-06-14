package testovi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import biblioteka.Knjiga;
import biblioteka.Main;
import biblioteka.Racun;
import biblioteka.Validacija;

class VracanjeKnjigeTest {

	Validacija obj;
	Racun racun;
	Knjiga knjiga;
	Knjiga knjiga2;
	int brojRacunaKojiNePostoji;
	int brojRacunaKojiPostoji;
	int brojKnjigeKojaNePostoji;
	int brojKnjigeKojaPostoji;

	@BeforeEach
	void setUp() throws Exception {
		obj = new Validacija();

		racun = new Racun();
		knjiga = new Knjiga();
		knjiga2 = new Knjiga();

		racun.setBrojRacuna(1);
		knjiga.setBrojKnjige(1);
		knjiga2.setBrojKnjige(2);

		knjiga.setStatusKnjige(false);
		knjiga2.setStatusKnjige(true);

		brojRacunaKojiNePostoji = 86393;
		brojRacunaKojiPostoji = 1;
		brojKnjigeKojaNePostoji = 213;
		brojKnjigeKojaPostoji = 1;

		Main.pohranjeniRacuni.add(racun);
		Main.pohranjeneKnjige.add(knjiga);
		Main.pohranjeneKnjige.add(knjiga2);

	}

	@AfterEach
	void tearDown() throws Exception {
		obj = null;
		racun = null;
		knjiga = null;
		knjiga2 = null;
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

}
