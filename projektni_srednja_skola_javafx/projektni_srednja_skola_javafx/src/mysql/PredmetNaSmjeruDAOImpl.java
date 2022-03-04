package mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import dao.DAOFactory;
import dao.DAOFactoryType;
import dao.PredmetNaSmjeruDAO;
import dto.Predmet;
import dto.PredmetNaSmjeru;
import javafx.scene.control.Alert.AlertType;

public class PredmetNaSmjeruDAOImpl implements PredmetNaSmjeruDAO {

	private Connection c = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private CallableStatement cs = null;

	@Override
	public List<PredmetNaSmjeru> predmetiNaSmjeru(String nazivSmjera) {
		List<PredmetNaSmjeru> predmetNaSmjeruList = new ArrayList<PredmetNaSmjeru>();
		c = null;
		ps = null;
		rs = null;

		String query = "select p.IdPredmeta, p.Naziv as NazivPredmeta, s.IdSmjera,  "
				+ " Tip, Razred, MinimalniBrojPismenihProvjera, MinimalniBrojUsmenihProvjera   "
				+ "from predmet_na_smjeru pns  " + "inner join smjer s on s.IdSmjera= pns.IdSmjera "
				+ "inner join predmet p on p.IdPredmeta = pns.IdPredmeta " + "where s.Naziv like ? ";

		try {
			c = ConnectionPool.getInstance().checkOut();
			ps = c.prepareStatement(query);
			ps.setString(1, Utilities.preparePattern(nazivSmjera));
			rs = ps.executeQuery();

			while (rs.next())
				predmetNaSmjeruList.add(new PredmetNaSmjeru(new Predmet(rs.getInt(1), rs.getString(2)),
						DAOFactory.getFactory(DAOFactoryType.MySQL).getSmjerDAO().smjer(rs.getInt(3)), rs.getString(4),
						rs.getInt(5), rs.getInt(6), rs.getInt(7)));
		} catch (SQLException e) {
			e.printStackTrace();
			application.forms.Utilities.showAlert(AlertType.ERROR, "GRESKA", "Greska : " + e.getErrorCode(), e.getMessage());
		} finally {
			ConnectionPool.getInstance().checkIn(c);
			 mysql.Utilities.close(ps, rs);
		}
		return predmetNaSmjeruList;
	}
	@Override
	public boolean dodajPredmetNaSmjeru(PredmetNaSmjeru predmetNaSmjeru) {
		c = null;
		cs = null;

		String query = "{CALL dodaj_predmet_na_smjeru(?, ?, ?, ?, ?, ?, ?, ?, ?)}";

		try {
			c = ConnectionPool.getInstance().checkOut();
			cs = c.prepareCall(query);
			cs.setInt(1, predmetNaSmjeru.getPredmet().getIdPredmeta());
			cs.setString(2, predmetNaSmjeru.getPredmet().getNaziv());
			cs.setInt(3, predmetNaSmjeru.getSmjer().getIdSmjera());
			cs.setString(4, predmetNaSmjeru.getTip());
			cs.setInt(5, predmetNaSmjeru.getRazred());
			cs.setInt(6, predmetNaSmjeru.getMinimalniBrojPismenihProvjera());
			cs.setInt(7, predmetNaSmjeru.getMinimalniBrojUsmenihProvjera());
			cs.registerOutParameter(8, Types.BOOLEAN);
			cs.registerOutParameter(9, Types.VARCHAR);
			cs.execute();

			if (!cs.getBoolean(8)) {
				application.forms.Utilities.showAlert(AlertType.ERROR, "GRESKA", cs.getString(9), null);
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			application.forms.Utilities.showAlert(AlertType.ERROR, "GRESKA", "Greska : " + e.getErrorCode(), e.getMessage());
		} finally {
			ConnectionPool.getInstance().checkIn(c);
			 mysql.Utilities.close(cs);
		}

		return true;
	}

	@Override
	public boolean azurirajPredmetNaSmjeru(PredmetNaSmjeru predmetNaSmjeru) {
		c = null;
		cs = null;

		String query = "{CALL azuriraj_predmet_na_smjeru(?, ?, ?, ?, ?, ?, ?, ?, ?)}";

		try {
			c = ConnectionPool.getInstance().checkOut();
			cs = c.prepareCall(query);
			cs.setInt(1, predmetNaSmjeru.getPredmet().getIdPredmeta());
			cs.setString(2, predmetNaSmjeru.getPredmet().getNaziv());
			cs.setInt(3, predmetNaSmjeru.getSmjer().getIdSmjera());
			cs.setString(4, predmetNaSmjeru.getTip());
			cs.setInt(5, predmetNaSmjeru.getRazred());
			cs.setInt(6, predmetNaSmjeru.getMinimalniBrojPismenihProvjera());
			cs.setInt(7, predmetNaSmjeru.getMinimalniBrojUsmenihProvjera());
			cs.registerOutParameter(8, Types.BOOLEAN);
			cs.registerOutParameter(9, Types.VARCHAR);
			cs.execute();

			if (!cs.getBoolean(8)) {
				application.forms.Utilities.showAlert(AlertType.ERROR, "GRESKA", cs.getString(9), null);
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			application.forms.Utilities.showAlert(AlertType.ERROR, "GRESKA", "Greska : " + e.getErrorCode(), e.getMessage());
		} finally {
			ConnectionPool.getInstance().checkIn(c);
			 mysql.Utilities.close(cs);
		}
		return true;
	}

	@Override
	public boolean obrisiPredmetNaSmjeru(int IdPredmeta, int IdSmjera) {
		c = null;
		ps = null;

		String query = "delete from predmet_na_smjeru pns where pns.IdPredmeta=? and pns.IdSmjera=? ";
		try {
			c = ConnectionPool.getInstance().checkOut();
			ps = c.prepareStatement(query);
			ps.setInt(1, IdPredmeta);
			ps.setInt(2, IdSmjera);

			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
			application.forms.Utilities.showAlert(AlertType.ERROR, "GRESKA", "Greska : " + e.getErrorCode(), e.getMessage());
		} finally {
			ConnectionPool.getInstance().checkIn(c);
			 mysql.Utilities.close(ps);
		}
		return false;
	}

	@Override
	public PredmetNaSmjeru predmetNaSmjeru(int IdPredmeta, int IdSmjera) {
		c = null;
		ps = null;
		rs = null;

		String query = "select Tip, Razred, MinimalniBrojPismenihProvjera, MinimalniBrojUsmenihProvjera   "
				+ "from predmet_na_smjeru pns  " + "where pns.IdPredmeta = ? and pns.IdSmjera = ? ";

		try {
			c = ConnectionPool.getInstance().checkOut();
			ps = c.prepareStatement(query);
			ps.setInt(1, IdPredmeta);
			ps.setInt(2, IdSmjera);
			rs = ps.executeQuery();

			if (rs.next()) {
				DAOFactory daoFactory = DAOFactory.getFactory(DAOFactoryType.MySQL);
				return new PredmetNaSmjeru(daoFactory.getPredmetDAO().predmet(IdPredmeta),
						daoFactory.getSmjerDAO().smjer(IdSmjera), rs.getString(1), rs.getInt(2), rs.getInt(3),
						rs.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			application.forms.Utilities.showAlert(AlertType.ERROR, "GRESKA", "Greska : " + e.getErrorCode(), e.getMessage());
		} finally {
			ConnectionPool.getInstance().checkIn(c);
			 mysql.Utilities.close(ps, rs);
		}
		return null;
	}

}
