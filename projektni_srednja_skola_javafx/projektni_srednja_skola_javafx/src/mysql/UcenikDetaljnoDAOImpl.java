package mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.UcenikDetaljnoDAO;
import javafx.scene.control.Alert.AlertType;

public class UcenikDetaljnoDAOImpl implements UcenikDetaljnoDAO{

	@Override
	public List<List<Object>> uceniciDetalji() {
		List<List<Object>> lista = new ArrayList<>();
		Connection conn = null;
		CallableStatement cs = null;
		ResultSet rs = null;

		String query = "select * from ucenik_detaljno";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			cs = conn.prepareCall(query);

			rs = cs.executeQuery();
			while (rs.next()) {
				List<Object> red = new ArrayList<Object>();
				red.add(rs.getString(1)); //jmb
				red.add(rs.getString(2));  //prezime, ime
				red.add(rs.getString(3)); //skola
				red.add(rs.getString(4)); //smjer
				red.add(rs.getString(5)); //razred-odjeljenje
				red.add(rs.getString(6));
				red.add(rs.getDouble(7)); //prosjek
				lista.add(red);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			 application.forms.Utilities.showAlert(AlertType.ERROR, "GRESKA", "Greska : " + e.getErrorCode(), e.getMessage());
		} finally {
			ConnectionPool.getInstance().checkIn(conn);
			mysql.Utilities.close(cs, rs);
		}
		return lista;
	}
}
