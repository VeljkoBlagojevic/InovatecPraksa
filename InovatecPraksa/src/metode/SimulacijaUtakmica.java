package metode;

import java.util.Random;

import grupa.Grupa;
import utakmica.Utakmica;

public class SimulacijaUtakmica {

	public static void randomRezultatiUtakmica(Grupa[] grupe) {
		Random random = new Random();
	
		for (int g = 0; g < grupe.length; g++)
			for (int i = 0; i < 4; i++)
				for (int j = i+1; j < 4; j++)
					if(j>i)
						grupe[g].dodajUtakmicu(new Utakmica(grupe[g], grupe[g].getNizReprezentacija()[i], grupe[g].getNizReprezentacija()[j], random.nextInt(51), random.nextInt(51)));
	}

	public static void dodeljivanjeBodova(Grupa[] grupe) {
		for (int i = 0; i < grupe.length; i++) {
			for (int j = 0; j < grupe[i].getNizUtakmica().length; j++) {
				if(daLiJePobedilaPrva(grupe, i, j)) {
					pobedaPrve(grupe, i, j);
				}
				else if(daLiJePobedilaDruga(grupe, i, j)) {
					pobedaDruge(grupe, i, j);
				}
				else {
					neresenoJe(grupe, i, j);
				}
			}
		}
	}
	
	private static void pobedaPrve(Grupa[] grupe, int i, int j) {
		pobedilaJePrva(grupe, i, j);
		izgubilaJeDruga(grupe, i, j);
	}

	private static void pobedaDruge(Grupa[] grupe, int i, int j) {
		pobedilaJeDruga(grupe, i, j);
		izgubilaJePrva(grupe, i, j);
	}

	private static void neresenoJe(Grupa[] grupe, int i, int j) {
		neresenoJe(grupe[i].getNizUtakmica()[j]);
	}
	
	private static void neresenoJe(Utakmica utakmica) {
		utakmica.getR1().nereseno();
		utakmica.getR2().nereseno();
	}

	private static void pobedilaJePrva(Grupa[] grupe, int i, int j) {
		pobedilaJePrva(grupe[i].getNizUtakmica()[j]);
	}
	
	private static void pobedilaJePrva(Utakmica utakmica) {
		utakmica.getR1().pobedila();
	}

	private static void izgubilaJePrva(Grupa[] grupe, int i, int j) {
		izgubilaJePrva(grupe[i].getNizUtakmica()[j]);
	}
	
	private static void izgubilaJePrva(Utakmica utakmica) {
		utakmica.getR1().izgubila();
	}

	private static void pobedilaJeDruga(Grupa[] grupe, int i, int j) {
		pobedilaJeDruga(grupe[i].getNizUtakmica()[j]);
	}
	
	private static void pobedilaJeDruga(Utakmica utakmica) {
		utakmica.getR2().pobedila();
	}

	private static void izgubilaJeDruga(Grupa[] grupe, int i, int j) {
		izgubilaJeDruga(grupe[i].getNizUtakmica()[j]);
	}
	
	private static void izgubilaJeDruga(Utakmica utakmica) {
		utakmica.getR2().izgubila();
	}

	private static boolean daLiJePobedilaPrva(Grupa[] grupe, int i, int j) {
		return daLiJePobedilaPrva(grupe[i].getNizUtakmica()[j]);
	}
	
	private static boolean daLiJePobedilaPrva(Utakmica utakmica) {
		return utakmica.getBrojGolova1() > utakmica.getBrojGolova2();
	}
	
	private static boolean daLiJePobedilaDruga(Grupa[] grupe, int i, int j) {
		return daLiJePobedilaDruga(grupe[i].getNizUtakmica()[j]);
	}
	
	private static boolean daLiJePobedilaDruga(Utakmica utakmica) {
		return utakmica.getBrojGolova1() < utakmica.getBrojGolova2();
	}
	

	
	
	public static void dodeljivanjeGolova(Grupa[] grupe) {
		for (int i = 0; i < grupe.length; i++) {
			for (int j = 0; j < grupe[i].getNizUtakmica().length; j++) {
				grupe[i].getNizUtakmica()[j].getR1().dodajDateGolove((grupe[i].getNizUtakmica()[j].getBrojGolova1()));
				grupe[i].getNizUtakmica()[j].getR1().dodajPrimljeneGolove(grupe[i].getNizUtakmica()[j].getBrojGolova2());
				grupe[i].getNizUtakmica()[j].getR2().dodajDateGolove((grupe[i].getNizUtakmica()[j].getBrojGolova2()));
				grupe[i].getNizUtakmica()[j].getR2().dodajPrimljeneGolove(grupe[i].getNizUtakmica()[j].getBrojGolova1());
			}
		}
	}
	
}