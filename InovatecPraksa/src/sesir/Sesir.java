package sesir;

import java.util.Arrays;

import reprezentacija.Reprezentacija;

public class Sesir {

	private Reprezentacija[] nizReprezentacija;
	private int brojReprezentacija = 0;
	
	public Sesir() {
		nizReprezentacija = new Reprezentacija[8];
	}

	public Sesir(Reprezentacija[] nizReprezentacija) {
		super();
		this.nizReprezentacija = nizReprezentacija;
	}

	public Reprezentacija[] getNizReprezentacija() {
		return nizReprezentacija;
	}

	public void setNizReprezentacija(Reprezentacija[] nizReprezentacija) {
		this.nizReprezentacija = nizReprezentacija;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Sesir other = (Sesir) obj;
		if (!Arrays.equals(nizReprezentacija, other.nizReprezentacija)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Sesir [" + Arrays.toString(nizReprezentacija) + "]";
	}

	
	public void dodajReprezentaciju(Reprezentacija reprezentacija) {
		nizReprezentacija[brojReprezentacija++] = reprezentacija;
	}
	
	
}
