package dto;

public class Telefon {
	private String brojTelefona;
	private String skolaJIB;
	
	public Telefon(String brojTelefona, String skolaJIB) {
		super();
		this.brojTelefona = brojTelefona;
		this.skolaJIB = skolaJIB;
	}
	
	public String getSkolaJIB() {
		return skolaJIB;
	}

	public void setSkolaJIB(String skolaJIB) {
		this.skolaJIB = skolaJIB;
	}

	public String getBrojTelefona() {
		return brojTelefona;
	}
	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brojTelefona == null) ? 0 : brojTelefona.hashCode());
		result = prime * result + ((skolaJIB == null) ? 0 : skolaJIB.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefon other = (Telefon) obj;
		if (brojTelefona == null) {
			if (other.brojTelefona != null)
				return false;
		} else if (!brojTelefona.equals(other.brojTelefona))
			return false;
		if (skolaJIB == null) {
			if (other.skolaJIB != null)
				return false;
		} else if (!skolaJIB.equals(other.skolaJIB))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return brojTelefona;
	}
}
