package dto;

public class Ucenik {

	private String JMB;
	private Integer odjeljenje, razred;
	private String brojMaticneKnjige, email;
	
	public Ucenik(String jMB, Integer odjeljenje, Integer razred, String brojMaticneKnjige, String email) {
		super();
		JMB = jMB;
		this.odjeljenje = odjeljenje;
		this.razred = razred;
		this.brojMaticneKnjige = brojMaticneKnjige;
		this.email = email;
	}
	
	public Ucenik () {}

	public String getJMB() {
		return JMB;
	}

	public void setJMB(String jMB) {
		JMB = jMB;
	}

	public Integer getOdjeljenje() {
		return odjeljenje;
	}

	public void setOdjeljenje(Integer odjeljenje) {
		this.odjeljenje = odjeljenje;
	}

	public Integer getRazred() {
		return razred;
	}

	public void setRazred(Integer razred) {
		this.razred = razred;
	}

	public String getBrojMaticneKnjige() {
		return brojMaticneKnjige;
	}

	public void setBrojMaticneKnjige(String brojMaticneKnjige) {
		this.brojMaticneKnjige = brojMaticneKnjige;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((JMB == null) ? 0 : JMB.hashCode());
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
		Ucenik other = (Ucenik) obj;
		if (JMB == null) {
			if (other.JMB != null)
				return false;
		} else if (!JMB.equals(other.JMB))
			return false;
		return true;
	}
	
	
}
