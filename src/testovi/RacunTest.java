package testovi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import biblioteka.Main;
import biblioteka.Racun;
import biblioteka.Validacija;



class RacunTest {

	
	Validacija obj;
	Racun racun;
	int brojRacunaKojiNePostoji;
	int brojRacunaKojiPostoji;

	
	
	@BeforeEach
	void setUp() throws Exception {
		obj = new Validacija();
		racun = new Racun();
		racun.setBrojRacuna(1);
		Main.pohranjeniRacuni.add(racun);
		brojRacunaKojiNePostoji = 5;
		brojRacunaKojiPostoji = 1;

	}

	@AfterEach
	void tearDown() throws Exception {
		obj = null;
		racun = null;

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


}
