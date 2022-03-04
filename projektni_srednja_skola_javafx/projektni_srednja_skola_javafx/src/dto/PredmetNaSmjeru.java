package dto;

public class PredmetNaSmjeru {
	
	private Predmet predmet;
	private Smjer smjer;
	private String tip;
	private int razred;
	private int minimalniBrojPismenihProvjera, minimalniBrojUsmenihProvjera;
	
	public PredmetNaSmjeru () {}
	
	public PredmetNaSmjeru(Predmet predmet, Smjer smjer, String tip, int razred, int minimalniBrojPismenihProvjera,
			int minimalniBrojUsmenihProvjera) {
		super();
		this.predmet = predmet;
		this.smjer = smjer;
		this.tip = tip;
		this.razred = razred;
		this.minimalniBrojPismenihProvjera = minimalniBrojPismenihProvjera;
		this.minimalniBrojUsmenihProvjera = minimalniBrojUsmenihProvjera;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public Smjer getSmjer() {
		return smjer;
	}

	public void setSmjer(Smjer smjer) {
		this.smjer = smjer;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public int getRazred() {
		return razred;
	}

	public void setRazred(int razred) {
		this.razred = razred;
	}

	public int getMinimalniBrojPismenihProvjera() {
		return minimalniBrojPismenihProvjera;
	}

	public void setMinimalniBrojPismenihProvjera(int minimalniBrojPismenihProvjera) {
		this.minimalniBrojPismenihProvjera = minimalniBrojPismenihProvjera;
	}

	public int getMinimalniBrojUsmenihProvjera() {
		return minimalniBrojUsmenihProvjera;
	}

	public void setMinimalniBrojUsmenihProvjera(int minimalniBrojUsmenihProvjera) {
		this.minimalniBrojUsmenihProvjera = minimalniBrojUsmenihProvjera;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((predmet == null) ? 0 : predmet.hashCode());
		result = prime * result + ((smjer == null) ? 0 : smjer.hashCode());
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
		PredmetNaSmjeru other = (PredmetNaSmjeru) obj;
		if (predmet == null) {
			if (other.predmet != null)
				return false;
		} else if (!predmet.equals(other.predmet))
			return false;
		if (smjer == null) {
			if (other.smjer != null)
				return false;
		} else if (!smjer.equals(other.smjer))
			return false;
		return true;
	}
	
	
}
