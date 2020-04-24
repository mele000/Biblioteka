package biblioteka;

public class Pregled {

	private int brojRacuna;

	VracanjeKnjige obj = new VracanjeKnjige();
	
	public Pregled() {
	}

	public Pregled(int brojRacuna) {
		this.brojRacuna = brojRacuna;

		
		if (imaLiKorisnikPodignutihKnjiga(brojRacuna) == true) {
		System.out.println("Korisnik " + obj.vratiRacun(brojRacuna).getImeMusterije() + " je podigao slijedece knjige : ");
		ispisiKnjigePodignute(brojRacuna);
		}
		else
			System.out.println("Korisnik nema nijednu knjigu kod sebe");
	}



	public boolean imaLiKorisnikPodignutihKnjiga(int brojRacuna) {

		if (obj.vratiRacun(brojRacuna).getBrojPosudjenihKnjiga() == 0) {
			return false;
		} else
			return true;

	}

	public void ispisiKnjigePodignute(int brojRacuna) {

		for (int i = 0; i < obj.vratiRacun(brojRacuna).pohranjeniKnjigeNaRacunu.size(); i++) {

			System.out.println(obj.vratiRacun(brojRacuna).pohranjeniKnjigeNaRacunu.get(i).getImeKnjige() + ", datum: "
					+ obj.vratiRacun(brojRacuna).pohranjeniKnjigeNaRacunu.get(i).getDatum());

		}

	}
}
