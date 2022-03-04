package dto;

import java.sql.Date;

public class Provjera {

	private Date datum;
	private Integer odjeljenje;
	private PredmetNaSmjeru predmetNaSmjeru;
	private String tip;
	private Integer trajanje;
	private Integer brojNegativnihOcjena;
	private Integer brojPrisutnihUcenika;
	private Boolean ponovljena;
	private Integer prostorija;

	public Provjera() {
	}

	public Provjera(Date datum, Integer odjeljenje, PredmetNaSmjeru predmetNaSmjeru, String tip, Integer trajanje,
			Integer brojNegativnihOcjena, Integer brojPrisutnihUcenika, Boolean ponovljena, Integer prostorija) {
		super();
		this.datum = datum;
		this.odjeljenje = odjeljenje;
		this.predmetNaSmjeru = predmetNaSmjeru;
		this.tip = tip;
		this.trajanje = trajanje;
		this.brojNegativnihOcjena = brojNegativnihOcjena;
		this.brojPrisutnihUcenika = brojPrisutnihUcenika;
		this.ponovljena = ponovljena;
		this.prostorija = prostorija;
	}

	public Integer getOdjeljenje() {
		return odjeljenje;
	}

	public void setOdjeljenje(Integer odjeljenje) {
		this.odjeljenje = odjeljenje;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public PredmetNaSmjeru getPredmetNaSmjeru() {
		return predmetNaSmjeru;
	}

	public void setPredmetNaSmjeru(PredmetNaSmjeru predmetNaSmjeru) {
		this.predmetNaSmjeru = predmetNaSmjeru;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public Integer getTrajanje() {
		return trajanje;
	}

	public void setTrajanje(Integer trajanje) {
		this.trajanje = trajanje;
	}

	public Integer getBrojNegativnihOcjena() {
		return brojNegativnihOcjena;
	}

	public void setBrojNegativnihOcjena(Integer brojNegativnihOcjena) {
		this.brojNegativnihOcjena = brojNegativnihOcjena;
	}

	public Integer getBrojPrisutnihUcenika() {
		return brojPrisutnihUcenika;
	}

	public void setBrojPrisutnihUcenika(Integer brojPrisutnihUcenika) {
		this.brojPrisutnihUcenika = brojPrisutnihUcenika;
	}

	public Boolean getPonovljena() {
		return ponovljena;
	}

	public void setPonovljena(Boolean ponovljena) {
		this.ponovljena = ponovljena;
	}

	public Integer getProstorija() {
		return prostorija;
	}

	public void setProstorija(Integer prostorija) {
		this.prostorija = prostorija;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datum == null) ? 0 : datum.hashCode());
		result = prime * result + ((predmetNaSmjeru == null) ? 0 : predmetNaSmjeru.hashCode());
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
		Provjera other = (Provjera) obj;
		if (datum == null) {
			if (other.datum != null)
				return false;
		} else if (!datum.equals(other.datum))
			return false;
		if (predmetNaSmjeru == null) {
			if (other.predmetNaSmjeru != null)
				return false;
		} else if (!predmetNaSmjeru.equals(other.predmetNaSmjeru))
			return false;
		return true;
	}

}
