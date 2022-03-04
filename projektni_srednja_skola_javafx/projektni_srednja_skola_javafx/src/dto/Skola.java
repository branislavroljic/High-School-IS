package dto;

import java.util.List;

public class Skola {
	private String JIB;
	private String naziv;
	private Adresa adresa;
	private List<Telefon> brojeviTelefona;
	private String vrsta;
	private String email;
	private String osnivac;
	

	public Skola(String jIB, String naziv, Adresa adresa, List<Telefon> brojeviTelefona, String vrsta, String email,
			String osnivac) {
		super();
		JIB = jIB;
		this.naziv = naziv;
		this.adresa = adresa;
		this.brojeviTelefona = brojeviTelefona;
		this.vrsta = vrsta;
		this.email = email;
		this.osnivac = osnivac;
	}
	public String getJIB() {
		return JIB;
	}
	public void setJIB(String jIB) {
		JIB = jIB;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Telefon> getBrojeviTelefona() {
		return brojeviTelefona;
	}
	public void setBrojeviTelefona(List<Telefon> brojeviTelefona) {
		this.brojeviTelefona = brojeviTelefona;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getVrsta() {
		return vrsta;
	}
	public void setVrsta(String vrsta) {
		this.vrsta = vrsta;
	}
	public String getOsnivac() {
		return osnivac;
	}
	public void setOsnivac(String osnivac) {
		this.osnivac = osnivac;
	}
	public Adresa getAdresa() {
		return adresa;
	}
	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((JIB == null) ? 0 : JIB.hashCode());
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
		Skola other = (Skola) obj;
		if (JIB == null) {
			if (other.JIB != null)
				return false;
		} else if (!JIB.equals(other.JIB))
			return false;
		return true;
	}
	
	
}
