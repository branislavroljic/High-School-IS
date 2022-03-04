package mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import dao.SkolaDAO;
import dto.Adresa;
import dto.Skola;
import dto.Telefon;
import javafx.scene.control.Alert.AlertType;

public class SkolaDAOImpl implements SkolaDAO {

	private Connection c = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private CallableStatement cs = null;

	@Override
	public List<Skola> skole(String nazivSkole) {
		List<Skola> skoleList = new ArrayList<>();

		c = null;
		ps = null;
		rs = null;
		String query = "select s.JIB as JIB, NazivSkole, ADRESA_PTTBroj, ADRESA_Ulica, ADRESA_Grad, ADRESA_Drzava, group_concat(BrojTelefona) as BrojeviTelefona, Vrsta, email, Osnivac "
				+ "from skola s " + "inner join telefon t on s.JIB = t.SKOLA_JIB " + "where s.NazivSkole like ? "
				+ "group by s.JIB ";
		try {
			c = ConnectionPool.getInstance().checkOut();
			ps = c.prepareStatement(query);
			ps.setString(1, Utilities.preparePattern(nazivSkole));
			rs = ps.executeQuery();

			while (rs.next()) {
				String skolaJIB = rs.getString("JIB");
				List<String> telefoniString = new ArrayList<String>(
						Arrays.asList(rs.getString("BrojeviTelefona").split(",")));
				List<Telefon> telefoniList = new ArrayList<>();
				telefoniString.forEach(t -> telefoniList.add(new Telefon(t, skolaJIB)));
				skoleList.add(new Skola(skolaJIB, rs.getString("NazivSkole"),
						new Adresa(rs.getInt("ADRESA_PTTBroj"), rs.getString("ADRESA_Ulica"),
								rs.getString("ADRESA_Grad"), rs.getString("ADRESA_Drzava")),
						telefoniList, rs.getString("Vrsta"), rs.getString("email"), rs.getString("Osnivac")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			application.forms.Utilities.showAlert(AlertType.ERROR, "GRESKA", "Greska : " + e.getErrorCode(),
					e.getMessage());
		} finally {
			ConnectionPool.getInstance().checkIn(c);
			mysql.Utilities.close(ps, rs);
		}
		return skoleList;
	}

	@Override
	public boolean dodajSkolu(Skola skola) {

		c = null;
		ps = null;
		cs = null;

		String querySkola = "{CALL dodaj_skolu(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
		String queryTelefon = "insert into telefon values (?, ?)";

		try {
			c = ConnectionPool.getInstance().checkOut();
			cs = c.prepareCall(querySkola);
			cs.setString(1, skola.getJIB());
			cs.setString(2, skola.getNaziv());
			cs.setString(3, skola.getEmail());
			cs.setString(4, skola.getVrsta());
			cs.setString(5, skola.getOsnivac());
			cs.setString(6, skola.getAdresa().getUlica());
			cs.setInt(7, skola.getAdresa().getPTTBroj());
			cs.setString(8, skola.getAdresa().getGrad());
			cs.setString(9, skola.getAdresa().getDrzava());
			cs.execute();

			ps = c.prepareStatement(queryTelefon);
			ps.setString(2, skola.getJIB());
			for (Telefon tel : skola.getBrojeviTelefona()) {
				System.out.println(tel.getBrojTelefona());
				ps.setString(1, tel.getBrojTelefona());
				if (ps.executeUpdate() != 1)
					return false;
			}
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			application.forms.Utilities.showAlert(AlertType.ERROR, "GRESKA", "Greska : " + e.getErrorCode(),
					e.getMessage());
		} finally {
			ConnectionPool.getInstance().checkIn(c);
			mysql.Utilities.close(ps, cs);
		}

		return false;
	}

	@Override
	public boolean azurirajSkolu(Skola skola) {
		c = null;
		ps = null;
		cs = null;
		String querySkola = "{CALL azuriraj_skolu(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
		String queryTelefon = "insert into telefon values (?, ?)";

		try {
			c = ConnectionPool.getInstance().checkOut();
			cs = c.prepareCall(querySkola);
			cs.setString(1, skola.getJIB());
			cs.setString(2, skola.getNaziv());
			cs.setString(3, skola.getEmail());
			cs.setString(4, skola.getVrsta());
			cs.setString(5, skola.getOsnivac());
			cs.setString(6, skola.getAdresa().getUlica());
			cs.setInt(7, skola.getAdresa().getPTTBroj());
			cs.setString(8, skola.getAdresa().getGrad());
			cs.setString(9, skola.getAdresa().getDrzava());
			cs.execute();

			ps = c.prepareStatement(queryTelefon);
			ps.setString(2, skola.getJIB());
			for (Telefon tel : skola.getBrojeviTelefona()) {
				ps.setString(1, tel.getBrojTelefona());
				if (ps.executeUpdate() != 1)
					return false;
			}
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			application.forms.Utilities.showAlert(AlertType.ERROR, "GRESKA", "Greska : " + e.getErrorCode(),
					e.getMessage());
		} finally {
			ConnectionPool.getInstance().checkIn(c);
			mysql.Utilities.close(cs, ps);
		}

		return false;
	}

	@Override
	public boolean obrisiSkolu(String JIB) {
		c = null;
		ps = null;

		String query = "delete from skola s where s.JIB=?";

		try {
			c = ConnectionPool.getInstance().checkOut();
			ps = c.prepareStatement(query);
			ps.setString(1, JIB);

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
	public Skola skola(String JIB) {
		c = null;
		ps = null;
		rs = null;
		String query = "select s.JIB as JIB, NazivSkole, ADRESA_PTTBroj, ADRESA_Ulica, ADRESA_Grad, ADRESA_Drzava, group_concat(BrojTelefona) as BrojeviTelefona, Vrsta, email, Osnivac "
				+ "from skola s " + "inner join telefon t on s.JIB = t.SKOLA_JIB " + "where s.JIB = ? "
				+ "group by s.JIB ";
		try {
			c = ConnectionPool.getInstance().checkOut();
			ps = c.prepareStatement(query);
			ps.setString(1, JIB);
			rs = ps.executeQuery();

			if (rs.next()) {
				List<String> telefoniString = new ArrayList<String>(
						Arrays.asList(rs.getString("BrojeviTelefona").split(",")));
				List<Telefon> telefoniList = new ArrayList<>();
				telefoniString.forEach(t -> telefoniList.add(new Telefon(t, JIB)));
				return new Skola(JIB, rs.getString("NazivSkole"),
						new Adresa(rs.getInt("ADRESA_PTTBroj"), rs.getString("ADRESA_Ulica"),
								rs.getString("ADRESA_Grad"), rs.getString("ADRESA_Drzava")),
						telefoniList, rs.getString("Vrsta"), rs.getString("email"), rs.getString("Osnivac"));
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

}
