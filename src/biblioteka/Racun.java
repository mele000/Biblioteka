package biblioteka;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class Racun implements Serializable {

	private int brojRacuna;
	private String imeMusterije;
	private int brojPosudjenihKnjiga;
	private boolean validacija;
	public static ArrayList<Racun> pohranjeniRacuni = new ArrayList<>();
	public ArrayList<Knjiga> pohranjeniKnjigeNaRacunu = new ArrayList<>();

	public Racun() {

	}

	public Racun(int brojRacuna, String imeMusterije, int brojPosudjenihKnjiga) {

		this.brojRacuna = brojRacuna;
		this.imeMusterije = imeMusterije;
		this.brojPosudjenihKnjiga = brojPosudjenihKnjiga;

		if (brojRacuna >= 0) {
			if (postojiLiIstiRacun(brojRacuna) == false) {
				validacija = true;
			}

			else if (postojiLiIstiRacun(brojRacuna) == true) {
				validacija = false;
				System.out.println(imeMusterije + ", postoji vec jedan racun sa tim brojem,pokusajte neki drugi");
			}
		}

		else if (brojRacuna < 0) {
			validacija = false;
			System.out.println(imeMusterije + ", broj racuna ne smije biti negativan");
		}

		if (validacija) {
			System.out.println("Izradili ste racun");
		}

	}

	public boolean postojiLiIstiRacun(int brojRacuna) {
		for (int i = 0; i < pohranjeniRacuni.size(); i++) {
			if (Racun.pohranjeniRacuni.get(i).getBrojRacuna() == brojRacuna) {
				return true;
			}
		}
		return false;
	}

	public int getBrojRacuna() {
		return brojRacuna;
	}

	public void setBrojRacuna(int brojRacuna) {
		this.brojRacuna = brojRacuna;
	}

	public String getImeMusterije() {
		return imeMusterije;
	}

	public int getBrojPosudjenihKnjiga() {
		return brojPosudjenihKnjiga;
	}

	public void setBrojPosudjenihKnjigaPovecaj() {
		brojPosudjenihKnjiga++;
	}

	public void setBrojPosudjenihKnjigaSmanji() {
		brojPosudjenihKnjiga--;
	}

	public boolean getValidacija() {
		return validacija;
	}

	@Override
	public String toString() {
		return "Racun [brojRacuna=" + brojRacuna + ", imeMusterije=" + imeMusterije + ", brojPosudjenihKnjiga="
				+ brojPosudjenihKnjiga + "]";
	}

}
