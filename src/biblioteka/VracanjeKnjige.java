package biblioteka;

public class VracanjeKnjige {

	private int brojRacuna;
	private int brojKnjige;
	private java.util.Date date;

	public VracanjeKnjige() {
	}

	public VracanjeKnjige(int brojRacuna, int brojKnjige) {

		this.brojRacuna = brojRacuna;
		this.brojKnjige = brojKnjige;

		Racun racun = new Racun();
		Knjiga knjiga = new Knjiga();

		if (racun.postojiLiIstiRacun(brojRacuna) == true) {

			if (knjiga.postojiLiIstaKnjiga(brojKnjige) == true && jeLiKnjigaDostupna(brojKnjige) == false) {

				vratiKnjigu(brojKnjige).setStatusKnjige(true);
				vratiRacun(brojRacuna).setBrojPosudjenihKnjigaSmanji();
				System.out.println(vratiKnjigu(brojKnjige).getStatusKnjige());
				System.out.println(vratiRacun(brojRacuna).getBrojPosudjenihKnjiga()); // dole provjerav knjige koje su pohranjene u arrayu a mi necemo to..
			}

			else
				System.out.println("Knjiga ne postoji ili nije dostupna");
		}

		else
			System.out.println("Vas racun nije pronaden");

	}

	public boolean jeLiKnjigaDostupna(int brojKnjige) {
		if (vratiKnjigu(brojKnjige).getStatusKnjige() == true) {
			return true;
		}

		return false;
	}

	public Knjiga vratiKnjigu(int brojKnjige) {

		for (int i = 0; i < Knjiga.pohranjeneKnjige.size(); i++) {
			if (Knjiga.pohranjeneKnjige.get(i).getBrojKnjige() == brojKnjige) {
				return Knjiga.pohranjeneKnjige.get(i);
			}
		}

		return null;
	}

	public Racun vratiRacun(int brojRacuna) {

		for (int i = 0; i < Racun.pohranjeniRacuni.size(); i++) {
			if (Racun.pohranjeniRacuni.get(i).getBrojRacuna() == brojRacuna) {
				return Racun.pohranjeniRacuni.get(i);
			}
		}

		return null;
	}

}
