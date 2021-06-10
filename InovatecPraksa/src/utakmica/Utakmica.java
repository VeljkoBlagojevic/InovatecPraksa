package utakmica;

import grupa.Grupa;
import reprezentacija.Reprezentacija;

public class Utakmica {

	private Grupa grupa;
	private Reprezentacija r1;
	private Reprezentacija r2;
	private int brojGolova1;
	private int brojGolova2;
	

	public Utakmica() {
		// TODO Auto-generated constructor stub
	}


	public Utakmica(Grupa grupa, Reprezentacija r1, Reprezentacija r2, int brojGolova1, int brojGolova2) {
		super();
		this.grupa = grupa;
		this.r1 = r1;
		this.r2 = r2;
		this.brojGolova1 = brojGolova1;
		this.brojGolova2 = brojGolova2;
	}


	public Grupa getGrupa() {
		return grupa;
	}


	public void setGrupa(Grupa grupa) {
		this.grupa = grupa;
	}


	public Reprezentacija getR1() {
		return r1;
	}


	public void setR1(Reprezentacija r1) {
		this.r1 = r1;
	}


	public Reprezentacija getR2() {
		return r2;
	}


	public void setR2(Reprezentacija r2) {
		this.r2 = r2;
	}


	public int getBrojGolova1() {
		return brojGolova1;
	}


	public void setBrojGolova1(int brojGolova1) {
		this.brojGolova1 = brojGolova1;
	}


	public int getBrojGolova2() {
		return brojGolova2;
	}


	public void setBrojGolova2(int brojGolova2) {
		this.brojGolova2 = brojGolova2;
	}


	@Override
	public String toString() {
		/*return "Utakmica [grupa=" + grupa + ", r1=" + r1 + ", r2=" + r2 + ", brojGolova1=" + brojGolova1
				+ ", brojGolova2=" + brojGolova2 + "]";
	
	*/
		
		return r1.getNaziv() + "  " + brojGolova1 + " : " + brojGolova2 + "  " + r2.getNaziv() ;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((grupa == null) ? 0 : grupa.hashCode());
		result = prime * result + ((r1 == null) ? 0 : r1.hashCode());
		result = prime * result + ((r2 == null) ? 0 : r2.hashCode());
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
		Utakmica other = (Utakmica) obj;
		if (grupa == null) {
			if (other.grupa != null) {
				return false;
			}
		} else if (!grupa.equals(other.grupa)) {
			return false;
		}
		if (r1 == null) {
			if (other.r1 != null) {
				return false;
			}
		} else if (!r1.equals(other.r1)) {
			return false;
		}
		if (r2 == null) {
			if (other.r2 != null) {
				return false;
			}
		} else if (!r2.equals(other.r2)) {
			return false;
		}
		return true;
	}

}
