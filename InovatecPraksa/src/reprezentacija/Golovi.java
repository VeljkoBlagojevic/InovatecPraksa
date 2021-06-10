package reprezentacija;

public class Golovi {

	private int brojDatihGolova;
	private int brojPrimljenihGolova;
	private int netoRazlikaGolova;
	
	public Golovi() {
		brojDatihGolova = 0;
		brojPrimljenihGolova = 0;
		netoRazlikaGolova = 0;
	}

	public Golovi(int brojDatihGolova, int brojPrimljenihGolova, int netoRazlikaGolova) {
		super();
		this.brojDatihGolova = brojDatihGolova;
		this.brojPrimljenihGolova = brojPrimljenihGolova;
		this.netoRazlikaGolova = netoRazlikaGolova;
	}

	public int getBrojDatihGolova() {
		return brojDatihGolova;
	}

	public void setBrojDatihGolova(int brojDatihGolova) {
		this.brojDatihGolova = brojDatihGolova;
	}

	public int getBrojPrimljenihGolova() {
		return brojPrimljenihGolova;
	}

	public void setBrojPrimljenihGolova(int brojPrimljenihGolova) {
		this.brojPrimljenihGolova = brojPrimljenihGolova;
	}

	public int getNetoRazlikaGolova() {
		izracunajNetoRazlikuGolova();
		return netoRazlikaGolova;
	}

	private void izracunajNetoRazlikuGolova() {
		netoRazlikaGolova = brojDatihGolova - brojPrimljenihGolova;
	}

	public void setNetoRazlikaGolova(int netoRazlikaGolova) {
		this.netoRazlikaGolova = netoRazlikaGolova;
	}
	
	public void dodajDateGolove(int dodatniDatiGolovi) {
		brojDatihGolova += dodatniDatiGolovi;
	}
	
	public void dodajPrimljeneGolove(int dodatniPrimljeniGolovi) {
		brojPrimljenihGolova += dodatniPrimljeniGolovi;
	}
	
}
