package biblioteka;

import java.io.Serializable;
import java.util.ArrayList;

public class Knjiga implements Serializable {

	private String datum;
	private boolean statusKnjige = true;
	private boolean validacija;
	public static ArrayList<Knjiga> pohranjeneKnjige = new ArrayList<>();
	private int brojKnjige;
	private String imeKnjige;

	public Knjiga() {
	}

	public Knjiga(int brojKnjige, String imeKnjige, boolean statusKnjige) {

		this.imeKnjige = imeKnjige;
		this.statusKnjige = statusKnjige;
		this.brojKnjige = brojKnjige;

		if (brojKnjige >= 0) {
			if (postojiLiIstaKnjiga(brojKnjige) == false) {
				validacija = true;
			} else if (postojiLiIstaKnjiga(brojKnjige) == true) {
				validacija = false;
				System.out.println(
						imeKnjige + ", postoji vec jedna knjiga sa istim brojem,pokusajte napraviti neku drugu");

			}
		}

		else if (brojKnjige < 0) {
			validacija = false;
			System.out.println(imeKnjige + " - broj knjige ne smije biti negativan");
		}

		if (validacija) {
			System.out.println("Uspjesno ste kreirali odredjenu knjigu");
		}

	}

	public boolean postojiLiIstaKnjiga(int brojKnjige) {
		for (int i = 0; i < pohranjeneKnjige.size(); i++) {
			if (Knjiga.pohranjeneKnjige.get(i).getBrojKnjige() == brojKnjige) {
				return true;
			}
		}
		return false;
	}

	public int getBrojKnjige() {
		return brojKnjige;
	}


	public void setBrojKnjige(int brojKnjige) {
		this.brojKnjige = brojKnjige;
	}
	
	public void setDatum(String datum) {
		this.datum = datum;
	}

	public String getDatum() {
		return datum;
	}

	public String getImeKnjige() {
		return imeKnjige;
	}

	public boolean getStatusKnjige() {
		return statusKnjige;
	}

	public void setStatusKnjige(boolean statusKnjige) {
		this.statusKnjige = statusKnjige;
	}

	public boolean getValidacija() {
		return validacija;
	}

	@Override
	public String toString() {
		return "Knjiga [brojKnjige=" + brojKnjige + ", imeKnjige=" + imeKnjige + ", statusKnjige=" + statusKnjige + "]";
	}
}
