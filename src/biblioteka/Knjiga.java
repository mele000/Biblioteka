package biblioteka;

import java.io.Serializable;

public class Knjiga implements Serializable {

	private String datum;
	private boolean statusKnjige = true;
	protected boolean validacija;
	private int brojKnjige;
	private String imeKnjige;

	public Knjiga() {
	}

	public Knjiga(int brojKnjige, String imeKnjige, boolean statusKnjige) {

		this.imeKnjige = imeKnjige;
		this.statusKnjige = statusKnjige;
		this.brojKnjige = brojKnjige;

		

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
