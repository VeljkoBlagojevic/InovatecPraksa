package metode;

import grupa.Grupa;
import reprezentacija.Reprezentacija;
import sesir.Sesir;

public class IOuKonzoli {

	public static void ispisReprezentacijaUKonzoli(Reprezentacija[] nizReprezentacija) {
		for (Reprezentacija reprezentacija : nizReprezentacija) {
			System.out.println(reprezentacija);
		}
	}

	public static void ispisSesiraUKonzoli(Sesir[] sesiri) {
		for (int i = 0; i < sesiri.length; i++) {
			System.out.println(sesiri[i]);
		}
	}

	

	public static void ispisBodovaUKonzoli(Grupa[] grupe) {
		for (int i = 0; i < grupe.length; i++) {
			for (int j = 0; j < grupe[i].getNizReprezentacija().length; j++) {
				System.out.println(grupe[i].getNizReprezentacija()[j].getNaziv() + ": " + grupe[i].getNizReprezentacija()[j].getBrojBodova() + " bodova");
			}
			System.out.println();
		}
	}

	public static void ispisProlaznostiUKonzoli(Grupa[] grupe) {
		for (int i = 0; i < grupe.length; i++) {
			for (int j = 0; j < grupe[i].getNizReprezentacija().length; j++) {
				if(grupe[i].getNizReprezentacija()[j].isProsao())
				System.out.println(grupe[i].getNizReprezentacija()[j].getNaziv() + " -> prosao");
				else
					System.out.println(grupe[i].getNizReprezentacija()[j].getNaziv());
			}
			System.out.println();
		}
	}

	public static void ispisRezultataUtakmicaUKonzoli(Grupa[] grupe) {
		for (int i = 0; i < grupe.length; i++) {
			for (int j = 0; j < grupe[i].getNizUtakmica().length; j++) {
				System.out.println(grupe[i].getNizUtakmica()[j]);
			}
			System.out.println();
		}
	}

	public static void ispisGolovaUKonzoli(Grupa[] grupe) {
		for (int i = 0; i < grupe.length; i++) {
			for (int j = 0; j < grupe[i].getNizReprezentacija().length; j++) {
				System.out.println(grupe[i].getNizReprezentacija()[j].getNaziv() + ": "
						+ grupe[i].getNizReprezentacija()[j].getGolovi().getBrojDatihGolova() + " datih golova, "
						+ grupe[i].getNizReprezentacija()[j].getGolovi().getBrojPrimljenihGolova() + " primljenih golova, "
						+ grupe[i].getNizReprezentacija()[j].getGolovi().getNetoRazlikaGolova() + " neto ralika golova");
			}
			System.out.println();
		}
	}

}
