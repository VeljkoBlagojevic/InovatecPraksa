package metode;

import java.io.IOException;

import reprezentacija.Kontinent;
import reprezentacija.Reprezentacija;

public interface Provera {
	
	public static void geoProveraPreZreba(Reprezentacija[] nizReprezentacija) {
		try {
			if(proveraBrojaPoKontinentu(nizReprezentacija) == false)
				System.exit(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}
	}

	
	static boolean proveraBrojaPoKontinentu(Reprezentacija[] nizReprezentacija) throws IOException {
		// TODO Auto-generated method stub
		if(brojAfrickih(nizReprezentacija) != 5)
			throw new IOException("Preveliki je broj timova iz Afrike");
		if(brojAzijskih(nizReprezentacija) != 5)
			throw new IOException("Preveliki je broj timova iz Azije");
		if(brojEvropskih(nizReprezentacija) != 14)
			throw new IOException("Preveliki je broj timova iz Evrope");
		if(brojSevernoCentralnoAmerickih(nizReprezentacija) != 3)
			throw new IOException("Preveliki je broj timova iz Severne i Centralne Amerike");
		if(brojOkeanijskih(nizReprezentacija) > 1 ||
			(brojJuznoAmerkih(nizReprezentacija) > 4 && brojOkeanijskih(nizReprezentacija) == 1))
			throw new IOException("Preveliki je broj timova iz Okeanije");		
		if(brojJuznoAmerkih(nizReprezentacija) > 5 ||
				(brojJuznoAmerkih(nizReprezentacija) == 4 && brojOkeanijskih(nizReprezentacija) == 1) ||
				brojJuznoAmerkih(nizReprezentacija) < 4)
			throw new IOException("Preveliki je broj timova iz Juzne Amerike");
		return true;
		
	}

	static int brojAfrickih(Reprezentacija[] nizReprezentacija) {
		return brojUKontinentu(nizReprezentacija, Kontinent.AFRIKA);
	}

	static int brojAzijskih(Reprezentacija[] nizReprezentacija) {
		return brojUKontinentu(nizReprezentacija, Kontinent.AZIJA);
	}

	static int brojEvropskih(Reprezentacija[] nizReprezentacija) {
		return brojUKontinentu(nizReprezentacija, Kontinent.EVROPA);
	}

	static int brojSevernoCentralnoAmerickih(Reprezentacija[] nizReprezentacija) {
		return brojUKontinentu(nizReprezentacija, Kontinent.SEVERNA_CENTRALNA_AMERIKA);
	}

	static int brojJuznoAmerkih(Reprezentacija[] nizReprezentacija) {
		return brojUKontinentu(nizReprezentacija, Kontinent.JUZNA_AMERIKA);
	}
	
	static int brojOkeanijskih(Reprezentacija[] nizReprezentacija) {
		return brojUKontinentu(nizReprezentacija, Kontinent.OKEANIJA);
	}


	static int brojUKontinentu(Reprezentacija[] nizReprezentacija, Kontinent kontinent) {
		int brojac = 0;
		for (Reprezentacija reprezentacija : nizReprezentacija) {
			if(reprezentacija.getKontinent() == kontinent)
				brojac++;
		}
		return brojac;
	}
}
