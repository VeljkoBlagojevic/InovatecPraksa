package reprezentacija;

import java.io.IOException;

public class Reprezentacija implements Comparable<Reprezentacija> {

	private String naziv;
	private Kontinent kontinent;
	private int IHF;
	private Bodovi bodovi;
	private boolean prosao;
	private Golovi golovi;
	
	public Reprezentacija() {
		bodovi = new Bodovi();
		golovi = new Golovi();
	}

	public Reprezentacija(String naziv, Kontinent kontinent, int iHF) {
		super();
		this.naziv = naziv;
		this.kontinent = kontinent;
		IHF = iHF;
		golovi = new Golovi();
		bodovi = new Bodovi();
	}
	
	public Reprezentacija(String naziv, String kontinent, String iHF) {
		super();
		this.naziv = naziv;
		this.kontinent =
				kontinent.equals("Afrika") ? Kontinent.AFRIKA :
				kontinent.equals("Azija") ? Kontinent.AZIJA :
				kontinent.equals("Evropa") ? Kontinent.EVROPA :
				kontinent.equals("Severna i Centralna Amerika") ? Kontinent.SEVERNA_CENTRALNA_AMERIKA :
				kontinent.equals("Okeanija") ? Kontinent.OKEANIJA :
				kontinent.equals("Juzna Amerika") ? Kontinent.JUZNA_AMERIKA : Kontinent.EVROPA;
		IHF = Integer.parseInt(iHF);
		golovi = new Golovi();
		bodovi = new Bodovi();
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Kontinent getKontinent() {
		return kontinent;
	}

	public void setKontinent(Kontinent kontinent) {
		this.kontinent = kontinent;
	}

	public int getIHF() {
		return IHF;
	}

	public void setIHF(int iHF) throws IOException {
		if(iHF < 1 || iHF > 32)
			throw new IOException("Nije unesen ispravan IHF");
		IHF = iHF;
	}
	
	public int getBrojBodova() {
		return bodovi.getBrojBodova();
	}

	/*public void setBrojBodova(int brojBodova) {
		bodovi.setBrojBodova(brojBodova);
	}*/
	
	
	public boolean isProsao() {
		return prosao;
	}

	public void setProsao(boolean prosao) {
		this.prosao = prosao;
	}

	public Golovi getGolovi() {
		return golovi;
	}

	public void setGolovi(Golovi golovi) {
		this.golovi = golovi;
	}

	public Bodovi getBodovi() {
		return bodovi;
	}

	public void setBodovi(Bodovi bodovi) {
		this.bodovi = bodovi;
	}

	@Override
	public String toString() {
		return "Reprezentacija [naziv=" + naziv + ", kontinent=" + kontinent + ", IHF=" + IHF + "]";
	}
	
	/*
	@Override
	public String toString() {
		return naziv + IHF ;
	}*/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((kontinent == null) ? 0 : kontinent.hashCode());
		result = prime * result + ((naziv == null) ? 0 : naziv.hashCode());
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
		Reprezentacija other = (Reprezentacija) obj;
		if (kontinent != other.kontinent) {
			return false;
		}
		if (naziv == null) {
			if (other.naziv != null) {
				return false;
			}
		} else if (!naziv.equals(other.naziv)) {
			return false;
		}
		return true;
	}

	@Override
	public int compareTo(Reprezentacija reprezentacija) {
		return this.IHF - reprezentacija.IHF; 
	}

	public boolean nijeEvropa() {
		return !jesteEvropa();
	}

	public boolean jesteEvropa() {
		return this.kontinent.equals(Kontinent.EVROPA);
	}
	
	/*public void dodajBrojBodova(int brojBodova) {
		this.brojBodova += brojBodova;
	}*/
	
	public void pobedila() {
		if(bodovi!=null)
			bodovi.dodajPobedu();
	}
	
	public void izgubila() {
		if(bodovi!=null)
			bodovi.dodajPoraz();
	}
	
	public void nereseno() {
		if(bodovi!=null)
			bodovi.dodajNeresen();
	}

	public void dodajDateGolove(int dodatniDatiGolovi) {
		if(golovi!=null)
			golovi.dodajDateGolove(dodatniDatiGolovi);
	}
	
	public void dodajPrimljeneGolove(int dodatniPrimljeniGolovi) {
		if(golovi!=null)
			golovi.dodajPrimljeneGolove(dodatniPrimljeniGolovi);
	}
	


	
	
	

}
