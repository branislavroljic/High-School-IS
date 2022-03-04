package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.forms.Utilities;
import dao.PredmetDAO;
import dto.Predmet;
import javafx.scene.control.Alert.AlertType;

public class PredmetDAOImpl implements PredmetDAO{
	private Connection c = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public Predmet predmet(int IdPredmeta) {
		c = null;
		ps = null;
		rs = null;

		String query = "select Naziv from predmet p where p.IdPredmeta=?";

		try {
			c = ConnectionPool.getInstance().checkOut();
			ps = c.prepareStatement(query);
			ps.setInt(1, IdPredmeta);
			rs = ps.executeQuery();

			if (rs.next())
				return new Predmet(IdPredmeta, rs.getString(1));
		} catch (SQLException e) {
			e.printStackTrace();
			Utilities.showAlert(AlertType.ERROR, "GRESKA", "Greska : " + e.getErrorCode(), e.getMessage());
		} finally {
			ConnectionPool.getInstance().checkIn(c);
			mysql.Utilities.close(ps, rs);
		}
		return null;
	}
}
