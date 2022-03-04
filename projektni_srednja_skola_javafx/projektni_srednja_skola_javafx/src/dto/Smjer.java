package dto;

public class Smjer {
	
	private Integer IdSmjera;
	private Integer trajanjeGodina;
	private String naziv;
	private String zvanje;
	private Skola skola;
	
	public Smjer() {}
	
	public Smjer(int idSmjera, int trajanjeGodina, String naziv, String zvanje, Skola skola) {
		super();
		IdSmjera = idSmjera;
		this.trajanjeGodina = trajanjeGodina;
		this.naziv = naziv;
		this.zvanje = zvanje;
		this.skola = skola;
	}

	public Integer getIdSmjera() {
		return IdSmjera;
	}

	public void setIdSmjera(Integer idSmjera) {
		IdSmjera = idSmjera;
	}

	public Integer getTrajanjeGodina() {
		return trajanjeGodina;
	}

	public void setTrajanjeGodina(Integer trajanjeGodina) {
		this.trajanjeGodina = trajanjeGodina;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getZvanje() {
		return zvanje;
	}

	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}

	public Skola getSkola() {
		return skola;
	}

	public void setSkola(Skola skola) {
		this.skola = skola;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + IdSmjera;
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
		Smjer other = (Smjer) obj;
		if (IdSmjera != other.IdSmjera)
			return false;
		return true;
	}
	
}
