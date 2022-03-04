package dao;

import java.sql.Date;
import java.util.List;

import dto.Provjera;

public interface ProvjeraDAO {

	Provjera provjera(Date date, Integer odjeljenje, Integer idPredmeta, Integer idSmjera);

	List<Provjera> provjere(Date date, Integer odjeljenje, String nazivPredmeta, String nazivSmjera);
	
	boolean evidentirajOcjenuIzProvjere (Provjera provjera, String JMBUcenika, Integer ocjena);

	boolean dodajProvjeru(Provjera provjera);

	boolean azurirajProvjeru(Provjera provjera);

	boolean obirisProvjeru(Date date, Integer odjeljenje, Integer idPredmeta, Integer idSmjera);
}
