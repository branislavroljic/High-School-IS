package dao;

import java.util.List;

import dto.Skola;

public interface SkolaDAO {
	
	Skola skola (String JIB);
	
	List<Skola> skole(String JIB);

	boolean dodajSkolu(Skola skola);

	boolean azurirajSkolu(Skola skola);

	boolean obrisiSkolu(String JIB);
}
