package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ProstorijaDAO;
import javafx.scene.control.Alert.AlertType;

public class ProstorijaDAOImpl implements ProstorijaDAO {

	@Override
	public List<Integer> brojeviProstorija() {
		List<Integer> retVal = new ArrayList<Integer>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "select Broj from prostorija";

		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);


			rs = ps.executeQuery();

			while (rs.next())
				retVal.add(rs.getInt(1));
		} catch (SQLException e) {
			e.printStackTrace();
			 application.forms.Utilities.showAlert(AlertType.ERROR, "GRESKA", "Greska : " + e.getErrorCode(), e.getMessage());
		} finally {
			ConnectionPool.getInstance().checkIn(conn);
			 mysql.Utilities.close(ps, rs);
		}
		return retVal;

	}

}
