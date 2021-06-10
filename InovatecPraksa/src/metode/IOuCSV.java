package metode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import grupa.Grupa;
import reprezentacija.Reprezentacija;

public class IOuCSV {

	public static Reprezentacija[] unosIzCSV() {
		String file = "src/ulaz.csv";
		BufferedReader reader = null;
		String line = "";
		Reprezentacija[] nizReprezentacija = new Reprezentacija[32];
		int brojReprezentacija = 0;
		try {
			reader = new BufferedReader(new FileReader(file));
			
			while ((line = reader.readLine()) != null) {
				String[] row = line.split(",");
				nizReprezentacija[brojReprezentacija++] = new Reprezentacija(row[0], row[1], row[2]);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nizReprezentacija;
	}

	public static void ispisGrupaUCSV(Grupa[] grupe) {
		try {
			PrintWriter out = new PrintWriter(new File("src/grupe.csv"));
			
			for (int i = 0; i < grupe.length; i++) {
				out.printf("%s,1. %s,2. %s,3. %s,4. %s\n", grupe[i].getNaziv(),
						grupe[i].getNizReprezentacija()[0].getNaziv(),
						grupe[i].getNizReprezentacija()[1].getNaziv(),
						grupe[i].getNizReprezentacija()[2].getNaziv(),
						grupe[i].getNizReprezentacija()[3].getNaziv());
			}
			out.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void ispisRezultataUtakmicaUCSV(Grupa[] grupe) {
		try {
			PrintWriter out = new PrintWriter(new File("src/rezultatiUtakmica.csv"));
			
			for (int i = 0; i < grupe.length; i++) {
				for (int j = 0; j < grupe[i].getNizUtakmica().length; j++) {
					out.printf("%s,%s,%s,%d,%d\n", grupe[i].getNaziv(),
							grupe[i].getNizUtakmica()[j].getR1().getNaziv(),
							grupe[i].getNizUtakmica()[j].getR2().getNaziv(),
							grupe[i].getNizUtakmica()[j].getBrojGolova1(),
							grupe[i].getNizUtakmica()[j].getBrojGolova2());
				}
			}
			out.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void ispisZaSledecuFazuUCSV(Grupa[] grupe) {
		try {
			PrintWriter out = new PrintWriter(new File("src/sledecaFaza.csv"));
			
			for (int i = 0; i < grupe.length; i++) {
				out.printf("%s", grupe[i].getNaziv());
				for (int j = 0; j < grupe[i].getNizReprezentacija().length; j++) {
					out.print(",");
					if(grupe[i].getNizReprezentacija()[j].isProsao()) {						
						out.printf("%d. %s - %s", j+1, grupe[i].getNizReprezentacija()[j].getNaziv(), "prosao");
					}
					else
						out.printf("%d. %s", j+1, grupe[i].getNizReprezentacija()[j].getNaziv());
				}
				out.print("\n");
			}
			out.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
