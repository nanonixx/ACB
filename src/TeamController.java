
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TeamController {

	Scanner s = new Scanner(System.in);

	private Connection connection;

	public TeamController(Connection connection) {
		this.connection = connection;
	}

	public void showTeams() throws SQLException, IOException {


		Statement st = connection.createStatement();
		ResultSet rs;

		rs = st.executeQuery("SELECT * FROM team");
		while (rs.next()) {
			System.out.println("Name: " + rs.getString("name") + " " +
							   "Type: " + rs.getString("type") + " " +
							   "Country: " + rs.getString("country") + " " +
							   "City: " + rs.getString("city") + " " +
							   "Court name: " + rs.getString("court_name"));
		}

		rs.close();
		st.close();
	}


	public void showPlayers() throws SQLException{

		Statement st = connection.createStatement();
		ResultSet rs;

		System.out.print("Nom de l'equip: ");
		String team = s.nextLine();

		rs = st.executeQuery("SELECT first_name, last_name FROM player WHERE team_name ='" + team + "';");

		while (rs.next()) {
			System.out.println("Name: " + rs.getString("first_name") + " " + rs.getString("last_name"));
		}

		rs.close();
		st.close();
	}

//	public void
}
