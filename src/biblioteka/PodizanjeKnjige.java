package biblioteka;

import java.sql.Date;
import java.util.ArrayList;

public class PodizanjeKnjige {

	private int brojRacuna;
	private int brojKnjige;
	private java.util.Date date;
	private String date2;

	public PodizanjeKnjige() {
	}

	public PodizanjeKnjige(int brojRacuna, int brojKnjige) {

		java.util.Date date = new java.util.Date();

		this.brojRacuna = brojRacuna;
		this.brojKnjige = brojKnjige;
		this.date2 = date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();

		VracanjeKnjige obj = new VracanjeKnjige();
		Knjiga obj2 = new Knjiga();
		Racun obj3 = new Racun();

		if (obj3.postojiLiIstiRacun(brojRacuna) == true) {

			if (obj2.postojiLiIstaKnjiga(brojKnjige) == true && obj.jeLiKnjigaDostupna(brojKnjige) == true) {

				if (obj.vratiRacun(brojRacuna).getBrojPosudjenihKnjiga() > 2) {
					System.out.println("Vec imate 3 posudjene knjige");
				}

				else {
					obj.vratiKnjigu(brojKnjige).setStatusKnjige(false);
					obj.vratiRacun(brojRacuna).setBrojPosudjenihKnjigaPovecaj();
					obj.vratiRacun(brojRacuna).pohranjeniKnjigeNaRacunu.add(obj.vratiKnjigu(brojKnjige));
					obj.vratiRacun(brojRacuna).pohranjeniKnjigeNaRacunu
							.get(obj.vratiRacun(brojRacuna).pohranjeniKnjigeNaRacunu.size() - 1).setDatum(this.date2);
					System.out.println(obj.vratiRacun(brojRacuna).getBrojPosudjenihKnjiga());
					System.out.println(obj.vratiKnjigu(brojKnjige).getStatusKnjige());
				}
			}

			else
				System.out.println("Knjiga ne postoji ili nije dostupna");
		}

		else
			System.out.println("Vas racun nije pronaden");

	}

}
