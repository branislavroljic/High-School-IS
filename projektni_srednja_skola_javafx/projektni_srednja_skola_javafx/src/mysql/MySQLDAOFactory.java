package mysql;

import dao.DAOFactory;
import dao.PredmetDAO;
import dao.PredmetNaSmjeruDAO;
import dao.ProstorijaDAO;
import dao.ProvjeraDAO;
import dao.SkolaDAO;
import dao.SmjerDAO;
import dao.UcenikDetaljnoDAO;

public class MySQLDAOFactory extends DAOFactory {

	private static MySQLDAOFactory instance = new MySQLDAOFactory();

	private MySQLDAOFactory() {
	}

	public static MySQLDAOFactory getInstance() {
		return instance;
	}

	@Override
	public SkolaDAO getSkolaDAO() {
		// TODO Auto-generated method stub
		return new SkolaDAOImpl();
	}

	@Override
	public SmjerDAO getSmjerDAO() {
		// TODO Auto-generated method stub
		return new SmjerDAOImpl();
	}

	@Override
	public PredmetDAO getPredmetDAO() {
		// TODO Auto-generated method stub
		return new PredmetDAOImpl();
	}

	@Override
	public PredmetNaSmjeruDAO getPredmetNaSmjeruDAO() {
		// TODO Auto-generated method stub
		return new PredmetNaSmjeruDAOImpl();
	}

	@Override
	public ProvjeraDAO getProvjeraDAO() {
		// TODO Auto-generated method stub
		return new ProvjeraDAOImpl();
	}

	@Override
	public ProstorijaDAO getProstorijaDAO() {
		// TODO Auto-generated method stub
		return new ProstorijaDAOImpl();
	}

	@Override
	public UcenikDetaljnoDAO getUcenikDetaljnoDAO() {
		// TODO Auto-generated method stub
		return new UcenikDetaljnoDAOImpl();
	}

}
