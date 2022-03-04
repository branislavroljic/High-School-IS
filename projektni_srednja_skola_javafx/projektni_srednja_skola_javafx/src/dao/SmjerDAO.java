package dao;

import java.util.List;

import dto.Smjer;


public interface SmjerDAO {
	
	Smjer smjer (int IdSmjera);
	List<Smjer> smjerovi (String nazivSkole); // moze ovdje i naziv faksa npr
	boolean dodajSmjer(Smjer smjer);
	boolean azurirajSmjer(Smjer smjer);
	boolean obirisiSmjer(int IdSmjera);
}
