package biblioteka;

import java.io.EOFException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Main implements Serializable {

	public static ArrayList<Racun> pohranjeniRacuni = new ArrayList<>();
	public static ArrayList<Knjiga> pohranjeneKnjige = new ArrayList<>();
	static Validacija val = new Validacija();

	public static void main(String[] args)
			throws EOFException, IOException, ClassNotFoundException, FileNotFoundException {

		// CITANJE I ZAPISIVNAJE U ARR LIST
		val.procitajSveIzBaze_Knjige();
		val.procitajSveIzBaze_Racuni();

		Scanner unos = new Scanner(System.in);

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

				Racun racun = new Racun(brojRacuna, imeMusterije);

				if (brojRacuna >= 0) {
					if (val.postojiLiIstiRacun(brojRacuna) == false) {
						racun.validacija = true;
					}

					else if (val.postojiLiIstiRacun(brojRacuna) == true) {
						racun.validacija = false;
						System.out
								.println(imeMusterije + ", postoji vec jedan racun sa tim brojem,pokusajte neki drugi");
					}
				}

				else if (brojRacuna < 0) {
					racun.validacija = false;
					System.out.println(imeMusterije + ", broj racuna ne smije biti negativan");
				}

				if (racun.validacija) {
					System.out.println("Izradili ste racun");
				}

				if (racun.getValidacija() == true) {
					pohranjeniRacuni.add(racun);
				}
			}

			else if (broj == 2) {

				System.out.println("Unesite broj knjige");
				int brojKnjige = unos.nextInt();
				System.out.println("\nUnesite ime knjige");
				unos.nextLine();
				String imeKnjige = unos.nextLine();

				Knjiga knjiga = new Knjiga(brojKnjige, imeKnjige, true);

				if (brojKnjige >= 0) {
					if (val.postojiLiIstaKnjiga(brojKnjige) == false) {
						knjiga.validacija = true;
					} else if (val.postojiLiIstaKnjiga(brojKnjige) == true) {
						knjiga.validacija = false;
						System.out.println(imeKnjige
								+ ", postoji vec jedna knjiga sa istim brojem,pokusajte napraviti neku drugu");

					}
				}

				else if (brojKnjige < 0) {
					knjiga.validacija = false;
					System.out.println(imeKnjige + " - broj knjige ne smije biti negativan");
				}

				if (knjiga.validacija) {
					System.out.println("Uspjesno ste kreirali odredjenu knjigu");
				}

				if (knjiga.getValidacija() == true) {
					Main.pohranjeneKnjige.add(knjiga);
				}

			} else if (broj == 3) {

				System.out.println("Unesite broj racuna");
				int brojRacuna = unos.nextInt();
				System.out.println("\nUnesite broj knjige");
				int brojKnjige = unos.nextInt();

				
				java.util.Date date = new java.util.Date();
				val.vratiRacun(brojRacuna).date2 = date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();

				if (val.postojiLiIstiRacun(brojRacuna) == true) {

					if (val.postojiLiIstaKnjiga(brojKnjige) == true && val.jeLiKnjigaDostupna(brojKnjige) == true) {

						if (val.vratiRacun(brojRacuna).getBrojPosudjenihKnjiga() > 2) {
							System.out.println("Vec imate 3 posudjene knjige");
						}

						else {
							val.vratiKnjigu(brojKnjige).setStatusKnjige(false);
							val.vratiRacun(brojRacuna).setBrojPosudjenihKnjigaPovecaj();
							val.vratiRacun(brojRacuna).pohranjeniKnjigeNaRacunu.add(val.vratiKnjigu(brojKnjige));
							val.vratiRacun(brojRacuna).pohranjeniKnjigeNaRacunu
									.get(val.vratiRacun(brojRacuna).pohranjeniKnjigeNaRacunu.size() - 1)
									.setDatum(val.vratiRacun(brojRacuna).date2);
							System.out.println(val.vratiRacun(brojRacuna).getBrojPosudjenihKnjiga());
							System.out.println(val.vratiKnjigu(brojKnjige).getStatusKnjige());
						}
					}

					else
						System.out.println("Knjiga ne postoji ili nije dostupna");
				}

				else
					System.out.println("Vas racun nije pronaden");

			}

			else if (broj == 4) {

				System.out.println("Unesite broj racuna");
				int brojRacuna = unos.nextInt();
				System.out.println("\nUnesite broj knjige");
				int brojKnjige = unos.nextInt();


				if (val.postojiLiIstiRacun(brojRacuna) == true) {

					if (val.postojiLiIstaKnjiga(brojKnjige) == true && val.jeLiKnjigaDostupna(brojKnjige) == false) {

						val.vratiKnjigu(brojKnjige).setStatusKnjige(true);
						val.vratiRacun(brojRacuna).setBrojPosudjenihKnjigaSmanji();
						System.out.println(val.vratiKnjigu(brojKnjige).getStatusKnjige());
						System.out.println(val.vratiRacun(brojRacuna).getBrojPosudjenihKnjiga()); // dole provjerav
																									// knjige koje su
																									// pohranjene u
																									// arrayu a mi
																									// necemo to..
					}

					else
						System.out.println("Knjiga ne postoji ili nije dostupna");
				}

				else
					System.out.println("Vas racun nije pronaden");

			}

			else if (broj == 5) {

				System.out.println("Unesite broj racuna");
				int brojRacuna = unos.nextInt();


				if (val.imaLiKorisnikPodignutihKnjiga(brojRacuna) == true) {
					System.out.println("Korisnik " + val.vratiRacun(brojRacuna).getImeMusterije()
							+ " je podigao slijedece knjige : ");
					val.ispisiKnjigePodignute(brojRacuna);
				} else
					System.out.println("Korisnik nema nijednu knjigu kod sebe");
			}

			else
				break;

			System.out.println("Unesite 1 ako hocete kreirati racun,"
					+ "\n2 ako hocete kreirati knjigu\n3 ako hocete podici knjigu" + "\n4 ako hocete vratiti knjigu"
					+ "\n5 ako hocete pregledati racun i vidjeti koje ste knjige podogli"
					+ "\nbilo koji drugi broj ako hocete zavrsiti program");

			broj = unos.nextInt();

		}

		// ZAPISIVANJE SVE U ARRAY LISTU
		val.upisiSveUBazu_Knjige();
		val.upisiSveUBazu_Racuni();

	}

}
