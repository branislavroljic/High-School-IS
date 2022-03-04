package dao;

import java.util.List;

import dto.PredmetNaSmjeru;


public interface PredmetNaSmjeruDAO {

	PredmetNaSmjeru predmetNaSmjeru (int IdPredmeta, int IdSmjera);
	List<PredmetNaSmjeru> predmetiNaSmjeru(String nazivSmjera);
	boolean dodajPredmetNaSmjeru(PredmetNaSmjeru predmetNaSmjeru);
	boolean azurirajPredmetNaSmjeru(PredmetNaSmjeru predmetNaSmjeru);
	boolean obrisiPredmetNaSmjeru(int IdPredmeta, int IdSmjera);

}
