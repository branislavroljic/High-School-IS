package dto;

public class Predmet {
	
	private int IdPredmeta;
	private String naziv;
	
	public Predmet(int idPredmeta, String naziv) {
		super();
		IdPredmeta = idPredmeta;
		this.naziv = naziv;
	}
	
	public Predmet () {}

	public Integer getIdPredmeta() {
		return IdPredmeta;
	}

	public void setIdPredmeta(int idPredmeta) {
		IdPredmeta = idPredmeta;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + IdPredmeta;
		result = prime * result + ((naziv == null) ? 0 : naziv.hashCode());
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
		Predmet other = (Predmet) obj;
		if (IdPredmeta != other.IdPredmeta)
			return false;
		if (naziv == null) {
			if (other.naziv != null)
				return false;
		} else if (!naziv.equals(other.naziv))
			return false;
		return true;
	}
	
	
}
