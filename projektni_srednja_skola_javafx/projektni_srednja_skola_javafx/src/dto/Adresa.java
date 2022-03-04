package dto;

public class Adresa {
	private Integer PTTBroj;
	private String grad, drzava, ulica;
	public Adresa(Integer pTTBroj, String ulica , String grad, String drzava) {
		super();
		PTTBroj = pTTBroj;
		this.grad = grad;
		this.drzava = drzava;
		this.ulica = ulica;
	}
	@Override
	public String toString() {
		return PTTBroj + ", " + grad + ", " + drzava + ", " + ulica;
	}
	public Integer getPTTBroj() {
		return PTTBroj;
	}
	public void setPTTBroj(Integer pTTBroj) {
		PTTBroj = pTTBroj;
	}
	public String getGrad() {
		return grad;
	}
	public void setGrad(String grad) {
		this.grad = grad;
	}
	public String getDrzava() {
		return drzava;
	}
	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}
	public String getUlica() {
		return ulica;
	}
	public void setUlica(String ulica) {
		this.ulica = ulica;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + PTTBroj;
		result = prime * result + ((drzava == null) ? 0 : drzava.hashCode());
		result = prime * result + ((grad == null) ? 0 : grad.hashCode());
		result = prime * result + ((ulica == null) ? 0 : ulica.hashCode());
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
		Adresa other = (Adresa) obj;
		if (PTTBroj != other.PTTBroj)
			return false;
		if (drzava == null) {
			if (other.drzava != null)
				return false;
		} else if (!drzava.equals(other.drzava))
			return false;
		if (grad == null) {
			if (other.grad != null)
				return false;
		} else if (!grad.equals(other.grad))
			return false;
		if (ulica == null) {
			if (other.ulica != null)
				return false;
		} else if (!ulica.equals(other.ulica))
			return false;
		return true;
	}
	
	
}
