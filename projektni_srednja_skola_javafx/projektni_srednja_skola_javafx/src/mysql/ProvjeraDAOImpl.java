package mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import dao.DAOFactory;
import dao.DAOFactoryType;
import dao.ProvjeraDAO;
import dto.Provjera;
import javafx.scene.control.Alert.AlertType;

public class ProvjeraDAOImpl implements ProvjeraDAO {

	private Connection c = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private CallableStatement cs = null;

	@Override
	public Provjera provjera(Date date, Integer odjeljenje, Integer idPredmeta, Integer idSmjera) {
		c = null;
		ps = null;
		rs = null;

		String query = "select Tip, TrajanjeMin, BrojNegativnihOcjena, BrojPrisutnihUcenika, Ponovljena, PROSTORIJA_Broj"
				+ " from provjera " + "where Datum = ? and Odjeljenje = ? and IdPredmeta = ? and IdSmjera = ? ";
		try {
			c = ConnectionPool.getInstance().checkOut();
			ps = c.prepareStatement(query);
			ps.setDate(1, date);
			ps.setInt(2, odjeljenje);
			ps.setInt(3, idPredmeta);
			ps.setInt(4, idSmjera);
			rs = ps.executeQuery();

			if (rs.next()) {
				return new Provjera(date, odjeljenje,
						DAOFactory.getFactory(DAOFactoryType.MySQL).getPredmetNaSmjeruDAO().predmetNaSmjeru(idPredmeta,
								idSmjera),
						rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getBoolean(5), rs.getInt(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			application.forms.Utilities.showAlert(AlertType.ERROR, "GRESKA", "Greska : " + e.getErrorCode(),
					e.getMessage());
		} finally {
			ConnectionPool.getInstance().checkIn(c);
			mysql.Utilities.close(ps, rs);
		}
		return null;
	}

	@Override
	public List<Provjera> provjere(Date date, Integer odjeljenje, String nazivPredmeta, String nazivSmjera) {
		c = null;
		ps = null;
		rs = null;
		List<Provjera> provjereList = new ArrayList<>();

		String query = "select Datum, Odjeljenje, pr.IdPredmeta, s.IdSmjera, Tip, TrajanjeMin, BrojNegativnihOcjena, BrojPrisutnihUcenika, Ponovljena, PROSTORIJA_Broj"
				+ " from provjera p " + "inner join predmet pr on p.IdPredmeta = pr.IdPredmeta "
				+ " inner join smjer s on s.IdSmjera = p.IdSmjera ";
		query += "where pr.Naziv like ? ";
		query += " and s.Naziv like ? ";

		if (date != null)
			query += " and Datum=? ";
		if (odjeljenje != null)
			query += " and Odjeljenje=? ";

		try {
			c = ConnectionPool.getInstance().checkOut();
			ps = c.prepareStatement(query);
			ps.setString(1, Utilities.preparePattern(nazivPredmeta));
			ps.setString(2, Utilities.preparePattern(nazivSmjera));
			int i = 3;
			if (date != null)
				ps.setDate(i++, date);
			if (odjeljenje != null)
				ps.setInt(i++, odjeljenje);

			System.out.println(ps.toString());

			rs = ps.executeQuery();

			while (rs.next()) {
				provjereList.add(new Provjera(rs.getDate(1), rs.getInt(2),
						DAOFactory.getFactory(DAOFactoryType.MySQL).getPredmetNaSmjeruDAO()
								.predmetNaSmjeru(rs.getInt(3), rs.getInt(4)),
						rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getBoolean(9), rs.getInt(10)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			application.forms.Utilities.showAlert(AlertType.ERROR, "GRESKA", "Greska : " + e.getErrorCode(),
					e.getMessage());
		} finally {
			ConnectionPool.getInstance().checkIn(c);
			mysql.Utilities.close(ps, rs);
		}
		return provjereList;
	}

	@Override
	public boolean dodajProvjeru(Provjera provjera) {
		c = null;
		ps = null;

		String query = "insert into provjera (Datum, IdPredmeta, IdSmjera, Tip, TrajanjeMin, BrojNegativnihOcjena,BrojPrisutnihUcenika, Ponovljena, PROSTORIJA_Broj, Odjeljenje)"
				+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			c = ConnectionPool.getInstance().checkOut();
			ps = c.prepareStatement(query);
			ps.setDate(1, provjera.getDatum());
			ps.setInt(2, provjera.getPredmetNaSmjeru().getPredmet().getIdPredmeta());
			ps.setInt(3, provjera.getPredmetNaSmjeru().getSmjer().getIdSmjera());
			ps.setString(4, provjera.getTip());
			ps.setInt(5, provjera.getTrajanje());
			ps.setInt(6, provjera.getBrojNegativnihOcjena());
			ps.setInt(7, provjera.getBrojPrisutnihUcenika());
			if (provjera.getPonovljena() == null)
				ps.setNull(8, java.sql.Types.BOOLEAN);
			else
				ps.setBoolean(8, provjera.getPonovljena());
			ps.setInt(9, provjera.getProstorija());
			ps.setInt(10, provjera.getOdjeljenje());

			return ps.executeUpdate() == 1;

		} catch (SQLException e) {
			e.printStackTrace();
			application.forms.Utilities.showAlert(AlertType.ERROR, "GRESKA", "Greska : " + e.getErrorCode(),
					e.getMessage());
		} finally {
			ConnectionPool.getInstance().checkIn(c);
			mysql.Utilities.close(ps);
		}
		return false;
	}

	@Override
	public boolean azurirajProvjeru(Provjera provjera) {
		c = null;
		ps = null;

		String query = "update provjera set Tip=?, TrajanjeMin=?, BrojNegativnihOcjena=?,BrojPrisutnihUcenika=?, Ponovljena=?, PROSTORIJA_Broj=? "
				+ "where Datum=? and Odjeljenje = ? and IdPredmeta=? and IdSmjera=?";

		try {
			c = ConnectionPool.getInstance().checkOut();
			ps = c.prepareStatement(query);
			ps.setString(1, provjera.getTip());
			ps.setInt(2, provjera.getTrajanje());
			ps.setInt(3, provjera.getBrojNegativnihOcjena());
			ps.setInt(4, provjera.getBrojPrisutnihUcenika());
			if (provjera.getPonovljena() == null)
				ps.setNull(5, java.sql.Types.BOOLEAN);
			else
				ps.setBoolean(5, provjera.getPonovljena());
			ps.setInt(6, provjera.getProstorija());
			ps.setDate(7, provjera.getDatum());
			ps.setInt(8, provjera.getOdjeljenje());
			ps.setInt(9, provjera.getPredmetNaSmjeru().getPredmet().getIdPredmeta());
			ps.setInt(10, provjera.getPredmetNaSmjeru().getSmjer().getIdSmjera());

			return ps.executeUpdate() == 1;

		} catch (SQLException e) {
			e.printStackTrace();
			application.forms.Utilities.showAlert(AlertType.ERROR, "GRESKA", "Greska : " + e.getErrorCode(),
					e.getMessage());
		} finally {
			ConnectionPool.getInstance().checkIn(c);
			mysql.Utilities.close(ps);
		}
		return false;
	}

	@Override
	public boolean obirisProvjeru(Date date, Integer odjeljenje, Integer idPredmeta, Integer idSmjera) {
		c = null;
		ps = null;

		String query = "delete from provjera where Datum=? and Odjeljenje = ? and IdPredmeta=? and IdSmjera=?";

		try {
			c = ConnectionPool.getInstance().checkOut();
			ps = c.prepareStatement(query);
			ps.setDate(1, date);
			ps.setInt(2, odjeljenje);
			ps.setInt(3, idPredmeta);
			ps.setInt(4, idSmjera);

			return ps.executeUpdate() == 1;

		} catch (SQLException e) {
			e.printStackTrace();
			application.forms.Utilities.showAlert(AlertType.ERROR, "GRESKA", "Greska : " + e.getErrorCode(),
					e.getMessage());
		} finally {
			ConnectionPool.getInstance().checkIn(c);
			mysql.Utilities.close(ps);
		}
		return false;
	}

	@Override
	public boolean evidentirajOcjenuIzProvjere(Provjera provjera, String JMBUcenika, Integer ocjena) {
		c = null;
		cs = null;

		String query = "{call dodaj_novo_radjenje_provjere_ucenika(?, ?, ?, ?, ?, ?, ?, ?)}";

		try {
			c = ConnectionPool.getInstance().checkOut();
			cs = c.prepareCall(query);
			cs.setString(1, JMBUcenika);
			cs.setDate(2, provjera.getDatum());
			cs.setInt(3, provjera.getOdjeljenje());
			cs.setInt(4, provjera.getPredmetNaSmjeru().getPredmet().getIdPredmeta());
			cs.setInt(5, provjera.getPredmetNaSmjeru().getSmjer().getIdSmjera());
			cs.setInt(6, ocjena);
			cs.registerOutParameter(7, Types.BOOLEAN);
			cs.registerOutParameter(8, Types.VARCHAR);
			cs.execute();

			if (!cs.getBoolean(7)) {
				application.forms.Utilities.showAlert(AlertType.ERROR, "GRESKA", "Neuspjesno evidentiranje",
						cs.getString(8));
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			application.forms.Utilities.showAlert(AlertType.ERROR, "GRESKA", "Greska : " + e.getErrorCode(),
					e.getMessage());
		} finally {
			ConnectionPool.getInstance().checkIn(c);
			mysql.Utilities.close(cs);
		}

		return true;

	}

}
