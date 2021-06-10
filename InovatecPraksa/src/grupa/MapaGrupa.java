package grupa;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;

import java.util.Random;

import metode.StaticMetode;
import reprezentacija.Reprezentacija;
import sesir.Sesir;
import utakmica.Utakmica;

public class MapaGrupa {
	
	HashMap<String, Grupa> mapaGrupa;
	
	public MapaGrupa() {
		mapaGrupa = new HashMap<>(8);
	}
	
	public MapaGrupa(Grupa[] grupe) {
		mapaGrupa = new HashMap<>(8);

		
		for (int i = 0; i < grupe.length; i++) {
			mapaGrupa.put(StaticMetode.brojUSlovo(StaticMetode.velikoSlovo(i)), grupe[i]);
		}
	}

	public HashMap<String, Grupa> getMapaGrupa() {
		return mapaGrupa;
	}

	public void setMapaGrupa(HashMap<String, Grupa> mapaGrupa) {
		this.mapaGrupa = mapaGrupa;
	}
	
	public Grupa getGrupa(String naziv) {
		return mapaGrupa.get(naziv);
	}

	public boolean dodavanjeIzSesiraUGrupe(Sesir[] sesiri) {
		for (int i = 0; i < sesiri.length; i++) {
			for (int j = 0; j < mapaGrupa.size(); j++) {
				if(!rednaGrupa(j).dodajReprezentaciju(sesiri[i].getNizReprezentacija()[j]))
					return false;
			}
		}
		return true;
	}


	public void dodeljivanjeImenaGrupama() {
		for (int i = 0; i < mapaGrupa.size(); i++)
			rednaGrupa(i).setNaziv(StaticMetode.brojUSlovo(StaticMetode.velikoSlovo(i)));
	}
	
	public void ispisGrupaUKonzoli() {
		for (int i = 0; i < mapaGrupa.size(); i++) {
			System.out.println(rednaGrupa(i));
		}
	}

	
	public void ispisGrupaUCSV() {
		try {
			PrintWriter out = new PrintWriter(new File("src/grupe.csv"));
			
			for (int i = 0; i < mapaGrupa.size(); i++) {
				out.printf("%s,1. %s,2. %s,3. %s,4. %s\n", rednaGrupa(i).getNaziv(),
						rednaGrupa(i).getNizReprezentacija()[0].getNaziv(),
						rednaGrupa(i).getNizReprezentacija()[1].getNaziv(),
						rednaGrupa(i).getNizReprezentacija()[2].getNaziv(),
						rednaGrupa(i).getNizReprezentacija()[3].getNaziv());
			}
			out.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void randomRezultatiUtakmica() {
		Random random = new Random();
	
		for (int g = 0; g < mapaGrupa.size(); g++)
			for (int i = 0; i < 4; i++)
				for (int j = i+1; j < 4; j++)
					if(j>i)
						rednaGrupa(g).dodajUtakmicu(new Utakmica(rednaGrupa(g), rednaGrupa(g).getNizReprezentacija()[i], rednaGrupa(g).getNizReprezentacija()[j], random.nextInt(51), random.nextInt(51)));
	}
	
	public void ispisRezultataUtakmicaUKonzoli() {
		for (int i = 0; i < mapaGrupa.size(); i++) {
			for (int j = 0; j < rednaGrupa(i).getNizUtakmica().length; j++) {
				System.out.println(rednaGrupa(i).getNizUtakmica()[j]);
			}
			System.out.println();
		}
	}
	
	
	public void ispisRezultataUtakmicaUCSV() {
		try {
			PrintWriter out = new PrintWriter(new File("src/rezultatiUtakmica.csv"));
			
			for (int i = 0; i < mapaGrupa.size(); i++) {
				for (int j = 0; j < rednaGrupa(i).getNizUtakmica().length; j++) {
					out.printf("%s,%s,%s,%d,%d\n", rednaGrupa(i).getNaziv(),
							rednaGrupa(i).getNizUtakmica()[j].getR1().getNaziv(),
							rednaGrupa(i).getNizUtakmica()[j].getR2().getNaziv(),
							rednaGrupa(i).getNizUtakmica()[j].getBrojGolova1(),
							rednaGrupa(i).getNizUtakmica()[j].getBrojGolova2());
				}
			}
			out.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void ispisBodovaUKonzoli() {
		for (int i = 0; i < mapaGrupa.size(); i++) {
			for (int j = 0; j < rednaGrupa(i).getNizReprezentacija().length; j++) {
				System.out.println(rednaGrupa(i).getNizReprezentacija()[j].getNaziv() + ": " + rednaGrupa(i).getNizReprezentacija()[j].getBrojBodova() + " bodova");
			}
			System.out.println();
		}
	}
	
	public void ispisGolovaUKonzoli() {
		for (int i = 0; i < mapaGrupa.size(); i++) {
			for (int j = 0; j < rednaGrupa(i).getNizReprezentacija().length; j++) {
				System.out.println(rednaGrupa(i).getNizReprezentacija()[j].getNaziv() + ": "
						+ rednaGrupa(i).getNizReprezentacija()[j].getGolovi().getBrojDatihGolova() + " datih golova, "
						+ rednaGrupa(i).getNizReprezentacija()[j].getGolovi().getBrojPrimljenihGolova() + " primljenih golova, "
						+ rednaGrupa(i).getNizReprezentacija()[j].getGolovi().getNetoRazlikaGolova() + " neto ralika golova");
			}
			System.out.println();
		}
	}
	
	public void inicijalizacijaProlaznosti() {
		for (int i = 0; i < mapaGrupa.size(); i++) {
			rednaGrupa(i).prosleReprezentacije();
		}
	}
	
	public void ispisProlaznostiUKonzoli() {
		for (int i = 0; i < mapaGrupa.size(); i++) {
			for (int j = 0; j < rednaGrupa(i).getNizReprezentacija().length; j++) {
				if(rednaGrupa(i).getNizReprezentacija()[j].isProsao())
				System.out.println(rednaGrupa(i).getNizReprezentacija()[j].getNaziv() + " -> prosao");
				else
					System.out.println(rednaGrupa(i).getNizReprezentacija()[j].getNaziv());
			}
			System.out.println();
		}
	}
	
	public void ispisZaSledecuFazuUCSV() {
		try {
			PrintWriter out = new PrintWriter(new File("src/sledecaFaza.csv"));
			
			for (int i = 0; i < mapaGrupa.size(); i++) {
				out.printf("%s", rednaGrupa(i).getNaziv());
				for (int j = 0; j < rednaGrupa(i).getNizReprezentacija().length; j++) {
					out.print(",");
					if(rednaGrupa(i).getNizReprezentacija()[j].isProsao()) {						
						out.printf("%d. %s - %s", j+1, rednaGrupa(i).getNizReprezentacija()[j].getNaziv(), "prosao");
					}
					else
						out.printf("%d. %s", j+1, rednaGrupa(i).getNizReprezentacija()[j].getNaziv());
				}
				out.print("\n");
			}
			out.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Grupa rednaGrupa(int j) {
		return mapaGrupa.get(StaticMetode.brojUSlovo(StaticMetode.velikoSlovo(j)));
	}

	public void isprazniGrupe() {
		
		for (int i = 0; i < 8; i++) {
			mapaGrupa.get(StaticMetode.brojUSlovo(StaticMetode.velikoSlovo(i))).setBrojReprezentacija(0);
		}
		
		
		
		for (int i = 0; i < 8; i++) {
			//mapaGrupa.get(StaticMetode.brojUSlovo(i+65)).setNizReprezentacija(null);
			Reprezentacija[] nizZaBrisanje = mapaGrupa.get(StaticMetode.brojUSlovo(StaticMetode.velikoSlovo(i))).getNizReprezentacija();
			for (int j = 0; j < 4; j++) {
				nizZaBrisanje[j] = null;
			}
		}
	}

}
