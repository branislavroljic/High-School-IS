package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.DAOFactory;
import dao.DAOFactoryType;
import dao.SmjerDAO;
import dto.Smjer;
import javafx.scene.control.Alert.AlertType;

public class SmjerDAOImpl implements SmjerDAO {

	private Connection c = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public Smjer smjer(int IdSmjera) {
		c = null;
		ps = null;
		rs = null;

		String query = "select Trajanje_Godina, Naziv, Zvanje, skola_jib from smjer s where s.IdSmjera = ? ";
		try {
			c = ConnectionPool.getInstance().checkOut();
			ps = c.prepareStatement(query);
			ps.setInt(1, IdSmjera);
			rs = ps.executeQuery();

			if (rs.next()) {
				return new Smjer(IdSmjera, rs.getInt(1), rs.getString(2), rs.getString(3),
						DAOFactory.getFactory(DAOFactoryType.MySQL).getSkolaDAO().skola(rs.getString(4)));
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
	public List<Smjer> smjerovi(String nazivSkole) {
		List<Smjer> smjerList = new ArrayList<Smjer>();
		c = null;
		ps = null;
		rs = null;

		String query = "select IdSmjera, Trajanje_Godina, Naziv, Zvanje, skola_jib  from smjer s "
				+ " inner join skola sk on sk.JIB = s.SKOLA_JIB where sk.NazivSkole like ? " + "ORDER BY Naziv ASC ";

		try {
			c = ConnectionPool.getInstance().checkOut();
			ps = c.prepareStatement(query);
			ps.setString(1, Utilities.preparePattern(nazivSkole));
			rs = ps.executeQuery();

			while (rs.next())
				smjerList.add(new Smjer(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
						DAOFactory.getFactory(DAOFactoryType.MySQL).getSkolaDAO().skola(rs.getString(5))));
		} catch (SQLException e) {
			e.printStackTrace();
			application.forms.Utilities.showAlert(AlertType.ERROR, "GRESKA", "Greska : " + e.getErrorCode(),
					e.getMessage());
		} finally {
			ConnectionPool.getInstance().checkIn(c);
			mysql.Utilities.close(ps, rs);
		}
		return smjerList;
	}

	@Override
	public boolean dodajSmjer(Smjer smjer) {
		c = null;
		ps = null;

		String query = "insert into smjer values (?, ?, ?, ?, ?) ";
		try {
			c = ConnectionPool.getInstance().checkOut();
			ps = c.prepareStatement(query);
			ps.setInt(1, smjer.getIdSmjera());
			ps.setInt(2, smjer.getTrajanjeGodina());
			ps.setString(3, smjer.getNaziv());
			ps.setString(4, smjer.getSkola().getJIB());
			ps.setString(5, smjer.getZvanje());

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
	public boolean azurirajSmjer(Smjer smjer) {
		c = null;
		ps = null;

		String query = "update smjer set Trajanje_Godina=?, Naziv=?, SKOLA_JIB=?, Zvanje=? where IdSmjera=? ";
		try {
			c = ConnectionPool.getInstance().checkOut();
			ps = c.prepareStatement(query);
			ps.setInt(1, smjer.getTrajanjeGodina());
			ps.setString(2, smjer.getNaziv());
			ps.setString(3, smjer.getSkola().getJIB());
			ps.setString(4, smjer.getZvanje());
			ps.setInt(5, smjer.getIdSmjera());

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
	public boolean obirisiSmjer(int IdSmjera) {
		c = null;
		ps = null;

		String query = "delete from smjer where IdSmjera=?";
		try {
			c = ConnectionPool.getInstance().checkOut();
			ps = c.prepareStatement(query);
			ps.setInt(1, IdSmjera);

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

}
