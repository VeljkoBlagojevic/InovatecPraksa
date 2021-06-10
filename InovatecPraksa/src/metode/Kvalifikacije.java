package metode;

import java.util.Arrays;

import grupa.Grupa;
import grupa.MapaGrupa;
import reprezentacija.Reprezentacija;
import sesir.Sesir;


public class Kvalifikacije {

	final static int MAX_BROJ_POKUSAJA = 15;

	//Data metoda odradi sve potrebno zajedno sa ispisom svih informacija na konzoli
	//Koristi posebnu klasu MapaGrupa za niz Grupa koje smešta u HashMap sa ključevima po nazivu grupe ("A", "B", ... "H")
	public static void kvalifikacijeSaIspisomUKonzoli() {
		
		Reprezentacija[] nizReprezentacija = IOuCSV.unosIzCSV();
		
		Provera.geoProveraPreZreba(nizReprezentacija);
		
		System.out.println("\n\nUnete reprezentacije izgledaju ovako: \n");
		IOuKonzoli.ispisReprezentacijaUKonzoli(nizReprezentacija);
		
		Arrays.sort(nizReprezentacija);
		System.out.println("\n\nNakon sto su sortirane po IHF: \n");
		IOuKonzoli.ispisReprezentacijaUKonzoli(nizReprezentacija);
		
		Sesir[] sesiri = StaticMetode.dodavanjeUSesire(nizReprezentacija);
		
		System.out.println("\n\nSesiri pre mesanja: \n");
		IOuKonzoli.ispisSesiraUKonzoli(sesiri);
		
		Grupa[] grupe = StaticMetode.inicijalizacijaGrupa();
		
		StaticMetode.mesanjeUSesirima(sesiri);
		
		System.out.println("\n\nSesiri nakon mesanja: \n");
		IOuKonzoli.ispisSesiraUKonzoli(sesiri);
		
		MapaGrupa mapaGrupa = new MapaGrupa(grupe);
		
		//StaticMetode.dodavanjeIzSesiraUGrupe(sesiri, mapaGrupa);
		dodavanjaIzSesiraUGrupeSa15Pokusaja(sesiri, mapaGrupa);
			
		
		//StaticMetode.dodeljivanjeImenaGrupama(grupe);
		mapaGrupa.dodeljivanjeImenaGrupama();
		
		System.out.println("\n\nGrupe: \n");
		//IOuKonzoli.ispisGrupaUKonzoli(grupe);
		mapaGrupa.ispisGrupaUKonzoli();
		
		//IOuCSV.ispisGrupaUCSV(grupe);
		mapaGrupa.ispisGrupaUCSV();
		
		SimulacijaUtakmica.randomRezultatiUtakmica(grupe);
		//mapaGrupa.randomRezultatiUtakmica();
		
		System.out.println("\n\nRezultati utakmica: \n");
		//IOuKonzoli.ispisRezultataUtakmicaUKonzoli(grupe);
		mapaGrupa.ispisRezultataUtakmicaUKonzoli();
		
		//IOuCSV.ispisRezultataUtakmicaUCSV(grupe);
		mapaGrupa.ispisRezultataUtakmicaUCSV();
		
		SimulacijaUtakmica.dodeljivanjeBodova(grupe);
		SimulacijaUtakmica.dodeljivanjeGolova(grupe);
		
		System.out.println("\n\nBroj bodova reprezentacija po grupama: \n");
		//IOuKonzoli.ispisBodovaUKonzoli(grupe);
		mapaGrupa.ispisBodovaUKonzoli();
		
		System.out.println("\n\nBroj golova reprezentacija po grupama: \n");
		//IOuKonzoli.ispisGolovaUKonzoli(grupe);
		mapaGrupa.ispisGolovaUKonzoli();
		
		//StaticMetode.inicijalizacijaProlaznosti(grupe);
		mapaGrupa.inicijalizacijaProlaznosti();
		
		System.out.println("\n\nProlaznost reprezentacija: \n");
		//IOuKonzoli.ispisProlaznostiUKonzoli(grupe);
		mapaGrupa.ispisProlaznostiUKonzoli();
		
		//IOuCSV.ispisZaSledecuFazuUCSV(grupe);
		mapaGrupa.ispisZaSledecuFazuUCSV();
	}


	private static void dodavanjaIzSesiraUGrupeSa15Pokusaja(Sesir[] sesiri, MapaGrupa mapaGrupa) {
		int brojPokusaja = 0;
		
		do {
			if(mapaGrupa.dodavanjeIzSesiraUGrupe(sesiri))
				break;
	        else
	        {
	        	mapaGrupa.isprazniGrupe();
	        	StaticMetode.mesanjeUSesirima(sesiri);
	        	brojPokusaja++;
	        	continue;
	        }
		} while (brojPokusaja < MAX_BROJ_POKUSAJA);

		if(brojPokusaja >= MAX_BROJ_POKUSAJA) {
			System.err.println("Nakon 15 pokusaja nije nadjen adekvatan nacin za dodeljivanje iz sesira u grupe a da se ne krse geografska ogranicenja");
			System.err.println("Nastavite da pokrecete program dok ne dodje do dobre raspodele!");
			System.exit(0);
		}
	}
	
	
	//Program koji ne ispisuje ništa u konzoli
	//Koristi statičke metode umesto HashMape za rad nad nizom Grupa
	public static void kvalifikacijeBezIspisaUKonzoli() {
		
		Reprezentacija[] nizReprezentacija = IOuCSV.unosIzCSV();
		
		Provera.geoProveraPreZreba(nizReprezentacija);
		
		Arrays.sort(nizReprezentacija);
		
		Sesir[] sesiri = StaticMetode.dodavanjeUSesire(nizReprezentacija);
		
		
		Grupa[] grupe = StaticMetode.inicijalizacijaGrupa();
		
		StaticMetode.mesanjeUSesirima(sesiri);
		
		StaticMetode.dodavanjeIzSesiraUGrupe(sesiri, grupe);
		
		
		StaticMetode.dodeljivanjeImenaGrupama(grupe);
			
		IOuCSV.ispisGrupaUCSV(grupe);
		
		SimulacijaUtakmica.randomRezultatiUtakmica(grupe);
		
		IOuCSV.ispisRezultataUtakmicaUCSV(grupe);
		
		SimulacijaUtakmica.dodeljivanjeBodova(grupe);
		SimulacijaUtakmica.dodeljivanjeGolova(grupe);
		
		StaticMetode.inicijalizacijaProlaznosti(grupe);
		
		IOuCSV.ispisZaSledecuFazuUCSV(grupe);
	}
	
}
