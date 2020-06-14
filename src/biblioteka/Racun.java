package biblioteka;

import java.io.Serializable;
import java.util.ArrayList;

public class Racun implements Serializable {

	private int brojRacuna;
	private String imeMusterije;
	private int brojPosudjenihKnjiga;
	protected boolean validacija;
	private java.util.Date date;
	protected String date2;
	public ArrayList<Knjiga> pohranjeniKnjigeNaRacunu = new ArrayList<>();
	
	public Racun() {

	}

	public Racun(int brojRacuna, String imeMusterije) {

		this.brojRacuna = brojRacuna;
		this.imeMusterije = imeMusterije;

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
