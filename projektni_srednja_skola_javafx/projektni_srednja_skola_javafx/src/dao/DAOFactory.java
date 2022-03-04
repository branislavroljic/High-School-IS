package dao;

import mysql.MySQLDAOFactory;

public abstract class DAOFactory {
	
	public abstract SkolaDAO getSkolaDAO();
	public abstract SmjerDAO getSmjerDAO();
	public abstract PredmetDAO getPredmetDAO();
	public abstract PredmetNaSmjeruDAO getPredmetNaSmjeruDAO();
	public abstract ProvjeraDAO getProvjeraDAO();
	public abstract ProstorijaDAO getProstorijaDAO();
	public abstract UcenikDetaljnoDAO getUcenikDetaljnoDAO();
	
	public static DAOFactory getFactory (DAOFactoryType daoFactoryType) {
		if(daoFactoryType.equals(DAOFactoryType.MySQL)) {
			return MySQLDAOFactory.getInstance();
		}
		else 
			throw new IllegalArgumentException();
	}
}

