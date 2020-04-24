package biblioteka;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class Main implements Serializable {

	public static void main(String[] args)
			throws EOFException, IOException, ClassNotFoundException, FileNotFoundException {

		try {
			FileInputStream fi = new FileInputStream("knjige.txt");
			ObjectInputStream input = new ObjectInputStream(fi);

			try {
				while (true) {

					Knjiga knjiga = (Knjiga) input.readObject();
					Knjiga.pohranjeneKnjige.add(knjiga);
					System.out.println(Knjiga.pohranjeneKnjige.toString());
				}
			} catch (EOFException e) {
			}
		} catch (EOFException e1) {

		}

		try {
			FileInputStream fi = new FileInputStream("racuni.txt");
			ObjectInputStream input = new ObjectInputStream(fi);

			try {
				while (true) {

					Racun racun = (Racun) input.readObject();
					Racun.pohranjeniRacuni.add(racun);
					System.out.println(Racun.pohranjeniRacuni.toString());
				}
			} catch (EOFException e) {
			}
		} catch (EOFException e1) {

		}
		
		
		
		
		
		
		
		
		Scanner unos = new Scanner(System.in);

		Racun racun = new Racun();
		Knjiga knjiga = new Knjiga();
		java.util.Date date = new java.util.Date();

		System.out.println("Unesite" + "\n1 ako hocete kreirati racun," + "\n2 ako hocete kreirati knjigu"
				+ "\n3 ako hocete podici knjigu" + "\n4 ako hocete vratiti knjigu"
				+ "\n5 ako hocete pregledati racun i vidjeti koje ste knjige podogli"
				+ "\nbilo koji drugi broj ako hocete zavrsiti program");

		int broj = unos.nextInt();
		while (true) {

			if (broj == 1) {

				System.out.println("Unesite broj racuna");
				int brojRacuna = unos.nextInt();
				System.out.println("\nUnesite svoje ime");
				unos.nextLine();
				String imeMusterije = unos.nextLine();

				racun = new Racun(brojRacuna, imeMusterije, 0);
				if (racun.getValidacija() == true) {
					Racun.pohranjeniRacuni.add(racun);
				}
			}

			else if (broj == 2) {

				System.out.println("Unesite broj knjige");
				int brojKnjige = unos.nextInt();
				System.out.println("\nUnesite ime knjige");
				unos.nextLine();
				String imeKnjige = unos.nextLine();

				knjiga = new Knjiga(brojKnjige, imeKnjige, true);
				if (knjiga.getValidacija() == true) {
					knjiga.pohranjeneKnjige.add(knjiga);
				}

			} else if (broj == 3) {

				System.out.println("Unesite broj racuna");
				int brojRacuna = unos.nextInt();
				System.out.println("\nUnesite broj knjige");
				int brojKnjige = unos.nextInt();

				PodizanjeKnjige podizanjeKnjige = new PodizanjeKnjige(brojRacuna, brojKnjige);

			}

			else if (broj == 4) {

				System.out.println("Unesite broj racuna");
				int brojRacuna = unos.nextInt();
				System.out.println("\nUnesite broj knjige");
				int brojKnjige = unos.nextInt();

				VracanjeKnjige vracanjeKnjige = new VracanjeKnjige(brojRacuna, brojKnjige);

			}

			else if (broj == 5) {

				System.out.println("Unesite broj racuna");
				int brojRacuna = unos.nextInt();

				Pregled pregled = new Pregled(brojRacuna);

			}

			else
				break;

			System.out.println("Unesite 1 ako hocete kreirati racun,"
					+ "\n2 ako hocete kreirati knjigu\n3 ako hocete podici knjigu" + "\n4 ako hocete vratiti knjigu"
					+ "\n5 ako hocete pregledati racun i vidjeti koje ste knjige podogli"
					+ "\nbilo koji drugi broj ako hocete zavrsiti program");

			broj = unos.nextInt();

		}

		FileOutputStream fo = new FileOutputStream("knjige.txt");
		ObjectOutputStream output = new ObjectOutputStream(fo);

		for (Knjiga knjiga2 : Knjiga.pohranjeneKnjige) {
			output.writeObject(knjiga2);
		}
		output.close();
		fo.close();

		for (Knjiga knjiga3 : Knjiga.pohranjeneKnjige) {
			System.out.println(knjiga3.toString());
		}

		
		
		FileOutputStream foo = new FileOutputStream("racuni.txt");
		ObjectOutputStream outputt = new ObjectOutputStream(foo);

		for (Racun racun2 : Racun.pohranjeniRacuni) {
			outputt.writeObject(racun2);
		}
		outputt.close();
		foo.close();

		for (Racun racun3 : Racun.pohranjeniRacuni) {
			System.out.println(racun3.toString());
		}

		
	}


	}



