package reprezentacija;

public class Bodovi {

	private int brojPobeda;
	private int brojPoraza;
	private int brojNeresenih;
	private int brojBodova;
	
	public Bodovi() {
		
	}

	public Bodovi(int brojPobeda, int brojPoraza, int brojNeresenih, int brojBodova) {
		super();
		this.brojPobeda = brojPobeda;
		this.brojPoraza = brojPoraza;
		this.brojNeresenih = brojNeresenih;
		this.brojBodova = brojBodova;
	}

	public int getBrojPobeda() {
		return brojPobeda;
	}

	public void setBrojPobeda(int brojPobeda) {
		this.brojPobeda = brojPobeda;
	}

	public int getBrojGubitaka() {
		return brojPoraza;
	}

	public void setBrojGubitaka(int brojGubitaka) {
		this.brojPoraza = brojGubitaka;
	}

	public int getBrojNeresenih() {
		return brojNeresenih;
	}

	public void setBrojNeresenih(int brojNeresenih) {
		this.brojNeresenih = brojNeresenih;
	}

	public int getBrojBodova() {
		izranucajBrojBodova();
		return brojBodova;
	}

	private void izranucajBrojBodova() {
		brojBodova = 3 * brojPobeda + 1 * brojNeresenih + 0 * brojPoraza;
	}

	public void setBrojBodova(int brojBodova) {
		this.brojBodova = brojBodova;
	}
	
	public void dodajPobedu() {
		brojPobeda++;
	}
	
	public void dodajPoraz() {
		brojPoraza++;
	}

	public void dodajNeresen() {
		brojNeresenih++;
	}
	
	
	
	
}
