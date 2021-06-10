package metode;

import grupa.Grupa;
import grupa.MapaGrupa;
import reprezentacija.Reprezentacija;
import sesir.Sesir;

public class StaticMetode {

	public static void mesanjeUSesirima(Sesir[] sesiri) {
		for (int i = 0; i < sesiri.length; i++) {
			for (int j = 0; j < sesiri[i].getNizReprezentacija().length; j++) {
				int index = (int)(Math.random() * sesiri[i].getNizReprezentacija().length);
				
				Reprezentacija temp = sesiri[i].getNizReprezentacija()[j];
				sesiri[i].getNizReprezentacija()[j] = sesiri[i].getNizReprezentacija()[index];
				sesiri[i].getNizReprezentacija()[index] = temp;
			}
		}
	}

	public static Sesir[] dodavanjeUSesire(Reprezentacija[] nizReprezentacija) {
		Sesir[] sesiri = new Sesir[4];
		int brojacZaSesire = 0;
		for (int i = 0; i < sesiri.length; i++) {
			sesiri[i] = new Sesir();
			for (int j = 0; j < 8; j++) {
				sesiri[i].dodajReprezentaciju(nizReprezentacija[brojacZaSesire++]);
			}
		}
		return sesiri;
	}

	public static Grupa[] inicijalizacijaGrupa() {
		Grupa[] grupe = new Grupa[8];
		for (int i = 0; i < grupe.length; i++) {
			grupe[i] = new Grupa();
		}
		return grupe;
	}
	
	
	public static void dodavanjeIzSesiraUGrupe(Sesir[] sesiri, Grupa[] grupe) {
		int brojPokusaja = 0;
		
		do {
			try {
				for (int i = 0; i < sesiri.length; i++) {
					for (int j = 0; j < grupe.length; j++) {
						grupe[j].dodajReprezentaciju(sesiri[i].getNizReprezentacija()[j]);
					}
				}
				break;
			} catch (Exception e) {
				StaticMetode.mesanjeUSesirima(sesiri);
				praznjenjeGrupa(grupe);
				brojPokusaja++;
				continue;
			}
			
		} while (brojPokusaja < 15);
		
		if(brojPokusaja >= 15)
			System.err.println("Random selekcijom je doslo da kršenja geografskih ograničenja, NASTAVITE da pokrećete program sve do trenutka kada ne bude bilo greške");
	}

	private static void praznjenjeGrupa(Grupa[] grupe) {
		for (int i = 0; i < 8; i++) {
			grupe[i].setBrojReprezentacija(0);
		}
		
		for (int i = 0; i < 8; i++) {
			//mapaGrupa.get(StaticMetode.brojUSlovo(i+65)).setNizReprezentacija(null);
			Reprezentacija[] nizZaBrisanje = grupe[i].getNizReprezentacija();
			for (int j = 0; j < 4; j++) {
				nizZaBrisanje[j] = null;
			}
			grupe[i].setNizReprezentacija(null);
		}
	}
	
	public static void dodavanjeIzSesiraUGrupe(Sesir[] sesiri, MapaGrupa mapaGrupa) {
		try {
			for (int i = 0; i < sesiri.length; i++) {
				for (int j = 0; j < mapaGrupa.getMapaGrupa().size(); j++)
					mapaGrupa.getGrupa(StaticMetode.brojUSlovo(StaticMetode.velikoSlovo(j))).dodajReprezentaciju(sesiri[i].getNizReprezentacija()[j]);
			}
		} catch (Exception e) {
			System.err.println("Random selekcijom je doslo da kršenja geografskih ograničenja, NASTAVITE da pokrećete program sve do trenutka kada ne bude bilo greške");
			e.printStackTrace();
		}
	}
	


	public static void dodeljivanjeImenaGrupama(Grupa[] grupe) {
		for (int i = 0; i < grupe.length; i++) {
			grupe[i].setNaziv(brojUSlovo(StaticMetode.velikoSlovo(i)));
		}
	}



	public static void inicijalizacijaProlaznosti(Grupa[] grupe) {
		for (Grupa grupa : grupe) {
			grupa.prosleReprezentacije();
		}
	}

	public static String brojUSlovo(int broj) {
		//int REDIX=16;//redix 16 is for Hexadecimal value  
		//return  Character.toString(Character.forDigit(broj,REDIX));
		return Character.toString((char)(broj));
	}
	
	public static int velikoSlovo(int i) {
		return i+65;
	}
	

}
