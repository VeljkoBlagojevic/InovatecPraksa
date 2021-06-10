package grupa;

import java.util.Arrays;

import reprezentacija.Kontinent;
import reprezentacija.Reprezentacija;
import sesir.Sesir;
import utakmica.Utakmica;

public class Grupa {

	private String naziv;
	private Reprezentacija[] nizReprezentacija;
	private int brojReprezentacija;
	private Utakmica[] nizUtakmica;

	private int brojUtakmica;
	
	
	public Grupa() {
		nizReprezentacija = new Reprezentacija[4];
		brojReprezentacija = 0;
		nizUtakmica = new Utakmica[6];
		brojUtakmica = 0;
	}

	public Grupa(String naziv, Reprezentacija[] nizReprezentacija, Utakmica[] nizUtakmica) {
		super();
		this.naziv = naziv;
		this.nizReprezentacija = nizReprezentacija;
		brojReprezentacija = nizReprezentacija.length;
		this.nizUtakmica = nizUtakmica;
		brojUtakmica = nizUtakmica.length;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Reprezentacija[] getNizReprezentacija() {
		return nizReprezentacija;
	}

	public void setNizReprezentacija(Reprezentacija[] nizReprezentacija) {
		this.nizReprezentacija = nizReprezentacija;
	}
	
	public boolean dodajReprezentaciju(Reprezentacija reprezentacija) {
		if(geoProvera(reprezentacija)) {
			if(brojReprezentacija<4) {
				nizReprezentacija[brojReprezentacija++] = reprezentacija;
				return true;	
			}
			else
				return false;
		}
		else
			return false;
	}
	
	public Utakmica[] getNizUtakmica() {
		return nizUtakmica;
	}
	
	public void setNizUtakmica(Utakmica[] nizUtakmica) {
		this.nizUtakmica = nizUtakmica;
	}

	public void dodajUtakmicu(Utakmica utakmica) {
		if(brojUtakmica<6)
			nizUtakmica[brojUtakmica++] = utakmica;
	}
	
	public int getBrojReprezentacija() {
		return brojReprezentacija;
	}
	
	public void setBrojReprezentacija(int brojReprezentacija) {
		this.brojReprezentacija = brojReprezentacija;
	}
	
	@Override
	public String toString() {
		return "Grupa [naziv=" + naziv + ", nizReprezentacija=" + Arrays.toString(nizReprezentacija) + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((naziv == null) ? 0 : naziv.hashCode());
		result = prime * result + Arrays.hashCode(nizReprezentacija);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Grupa other = (Grupa) obj;
		if (naziv == null) {
			if (other.naziv != null) {
				return false;
			}
		} else if (!naziv.equals(other.naziv)) {
			return false;
		}
		if (!Arrays.equals(nizReprezentacija, other.nizReprezentacija)) {
			return false;
		}
		return true;
	}
	

	public boolean geoProvera(Reprezentacija reprezentacija) {
		for (Reprezentacija r : nizReprezentacija) {
			if(reprezentacija.nijeEvropa()) {
				if(r!=null && r.getKontinent()==reprezentacija.getKontinent())
					//throw new Exception("Vec postoji drzava u grupi koja je sa kontinenta: " + reprezentacija.getKontinent());
					return false;
			}
			if(reprezentacija.jesteEvropa())
				if(brojEvropskih()>1)
					//throw new Exception("Previse je evropskih zemalja u grupi");
					return false;
		}
		return true;
	}
	
	private int brojEvropskih() {
		int brojEvropskih = 0;
		for (Reprezentacija reprezentacija : nizReprezentacija) {
			if(reprezentacija!=null && reprezentacija.getKontinent()==Kontinent.EVROPA)
				brojEvropskih++;
		}
		return brojEvropskih;
	}
	
	public Reprezentacija reprezentacijaSaNajmanjeBodova() {
		Reprezentacija minReprezentacija = nizReprezentacija[0];
        
        for (int i = 1; i < nizReprezentacija.length; i++)
				if(manjeBodovaOdMin(i, minReprezentacija) || ( jednakBodovaSaMin(i, minReprezentacija) && manjeNetoGolovaOdMin(i, minReprezentacija) )  )
					minReprezentacija = nizReprezentacija[i];
        
        return minReprezentacija;
	}
	
	private boolean manjeBodovaOdMin(int i, Reprezentacija minReprezentacija) {
		return manjeBodovaOdMin(nizReprezentacija[i], minReprezentacija);
	}
	
	private boolean manjeBodovaOdMin(Reprezentacija reprezentacija, Reprezentacija minReprezentacija) {
		return reprezentacija.getBrojBodova() < minReprezentacija.getBrojBodova();
	}
	
	private boolean jednakBodovaSaMin(int i, Reprezentacija minReprezentacija) {
		return jednakBodovaSaMin(nizReprezentacija[i], minReprezentacija);
	}
	
	private boolean jednakBodovaSaMin(Reprezentacija reprezentacija, Reprezentacija minReprezentacija) {
		return reprezentacija.getBrojBodova() == minReprezentacija.getBrojBodova();
	}

	private boolean manjeNetoGolovaOdMin(int i, Reprezentacija minReprezentacija) {
		return manjeNetoGolovaOdMin(nizReprezentacija[i], minReprezentacija);
	}
	
	private boolean manjeNetoGolovaOdMin(Reprezentacija reprezentacija, Reprezentacija minReprezentacija) {
		return reprezentacija.getGolovi().getNetoRazlikaGolova() < minReprezentacija.getGolovi().getNetoRazlikaGolova();
	}



	public void prosleReprezentacije() {
		for (int i = 0; i < nizReprezentacija.length; i++) {
			if(nizReprezentacija[i].equals(reprezentacijaSaNajmanjeBodova()))
				nizReprezentacija[i].setProsao(false);
			else
				nizReprezentacija[i].setProsao(true);
		}
	}

	public Sesir prvoMestoKojeNijePopunjeno(int i) {
		// TODO Auto-generated method stub
		return null;
	}
}
