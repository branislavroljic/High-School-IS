package dto;

public class Prostorija {

	private Integer broj;
	private String tip;
	public Prostorija(Integer broj, String tip) {
		super();
		this.broj = broj;
		this.tip = tip;
	}
	
	public Prostorija () {}

	public Integer getBroj() {
		return broj;
	}

	public void setBroj(Integer broj) {
		this.broj = broj;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((broj == null) ? 0 : broj.hashCode());
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
		Prostorija other = (Prostorija) obj;
		if (broj == null) {
			if (other.broj != null)
				return false;
		} else if (!broj.equals(other.broj))
			return false;
		return true;
	}
	
	
}
