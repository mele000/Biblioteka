package biblioteka;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class Validacija implements Serializable {

	public void procitajSveIzBaze_Racuni() throws IOException, ClassNotFoundException {

		try {
			FileInputStream fi = new FileInputStream("racuni.txt");
			ObjectInputStream input = new ObjectInputStream(fi);

			try {
				while (true) {

					Racun racun = (Racun) input.readObject();
					Main.pohranjeniRacuni.add(racun);
					System.out.println(Main.pohranjeniRacuni.toString());
				}
			} catch (EOFException e) {
			}
		} catch (EOFException e1) {

		}
	}
	
	public void upisiSveUBazu_Racuni() throws IOException  {
		FileOutputStream foo = new FileOutputStream("racuni.txt");
		ObjectOutputStream outputt = new ObjectOutputStream(foo);

		for (Racun racun2 : Main.pohranjeniRacuni) {
			outputt.writeObject(racun2);
		}
		outputt.close();
		foo.close();

		for (Racun racun3 : Main.pohranjeniRacuni) {
			System.out.println(racun3.toString());
		}
	}
	
	public void procitajSveIzBaze_Knjige() throws IOException, ClassNotFoundException {
	
		try {
			FileInputStream fi = new FileInputStream("knjige.txt");
			ObjectInputStream input = new ObjectInputStream(fi);

			try {
				while (true) {

					Knjiga knjiga = (Knjiga) input.readObject();
					Main.pohranjeneKnjige.add(knjiga);
					System.out.println(Main.pohranjeneKnjige.toString());
				}
			} catch (EOFException e) {
			}
		} catch (EOFException e1) {

		}
		
		
	}
	

	public void upisiSveUBazu_Knjige() throws IOException  {
		FileOutputStream fo = new FileOutputStream("knjige.txt");
		ObjectOutputStream output = new ObjectOutputStream(fo);

		for (Knjiga knjiga2 : Main.pohranjeneKnjige) {
			output.writeObject(knjiga2);
		}
		output.close();
		fo.close();

		for (Knjiga knjiga3 : Main.pohranjeneKnjige) {
			System.out.println(knjiga3.toString());
		}

		
}
	
	public boolean postojiLiIstiRacun(int brojRacuna) {
		for (int i = 0; i < Main.pohranjeniRacuni.size(); i++) {
			if (Main.pohranjeniRacuni.get(i).getBrojRacuna() == brojRacuna) {
				return true;
			}
		}
		return false;
	}
	
	
	public boolean postojiLiIstaKnjiga(int brojKnjige) {
		for (int i = 0; i < Main.pohranjeneKnjige.size(); i++) {
			if (Main.pohranjeneKnjige.get(i).getBrojKnjige() == brojKnjige) {
				return true;
			}
		}
		return false;
	}
	
	public boolean jeLiKnjigaDostupna(int brojKnjige) {
		if (vratiKnjigu(brojKnjige).getStatusKnjige() == true) {
			return true;
		}

		return false;
	}

	public Knjiga vratiKnjigu(int brojKnjige) {

		for (int i = 0; i < Main.pohranjeneKnjige.size(); i++) {
			if (Main.pohranjeneKnjige.get(i).getBrojKnjige() == brojKnjige) {
				return Main.pohranjeneKnjige.get(i);
			}
		}

		return null;
	}

	public Racun vratiRacun(int brojRacuna) {

		for (int i = 0; i < Main.pohranjeniRacuni.size(); i++) {
			if (Main.pohranjeniRacuni.get(i).getBrojRacuna() == brojRacuna) {
				return Main.pohranjeniRacuni.get(i);
			}
		}

		return null;
	}


	public boolean imaLiKorisnikPodignutihKnjiga(int brojRacuna) {

		if (vratiRacun(brojRacuna).getBrojPosudjenihKnjiga() == 0) {
			return false;
		} else
			return true;

	}

	public void ispisiKnjigePodignute(int brojRacuna) {

		for (int i = 0; i < vratiRacun(brojRacuna).pohranjeniKnjigeNaRacunu.size(); i++) {

			System.out.println(vratiRacun(brojRacuna).pohranjeniKnjigeNaRacunu.get(i).getImeKnjige() + ", datum: "
					+ vratiRacun(brojRacuna).pohranjeniKnjigeNaRacunu.get(i).getDatum());

		}

	}
	
	}
