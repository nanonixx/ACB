
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



	public void createTeam() throws SQLException {
		Statement st = connection.createStatement();

		System.out.print("Nom de l'equip a crear: ");
		String name = s.nextLine();
		System.out.print("Tipus (National Team, Club): ");
		String type = s.nextLine();
		System.out.print("País de l'equip: ");
		String country = s.nextLine();
		System.out.print("Ciutat de l'equip");
		String city = s.nextLine();
		System.out.print("Nom del camp: ");
		String court = s.nextLine();


		st.executeUpdate("INSERT INTO team VALUES ('"+name+"', '"+type+"', '"+country+"', '"+city+"', '"+court+"');");

		st.close();

	}

	public void createMatch() throws SQLException {
		Statement st = connection.createStatement();

		System.out.print("Equip local: ");
		String home_team= s.nextLine();
		System.out.print("Equip visitant: ");
		String visitor_team = s.nextLine();
		System.out.print("Data del partir: ");
		String match_date = s.nextLine();
		System.out.print("Audiencia: ");
		String attendance = s.nextLine();
		System.out.print("MVP: ");
		String mvp = s.nextLine();


		st.executeUpdate("INSERT INTO team VALUES ('"+home_team+"', '"+visitor_team+"', '"+match_date+"', '"+attendance+"', '"+mvp+"');");

		st.close();
	}


	public void stats() throws SQLException {
		Statement st = connection.createStatement();

		ResultSet rs;

		rs = st.executeQuery("SELECT * FROM match_statistics");
		while (rs.next()) {
			System.out.println("Equip local: " + rs.getString("home_team") + " " +
					"Equip visitant: " + rs.getString("visitor_team") + " " +
					"Data del partit: " + rs.getString("match_date") + " " +
					"ID jugador: " + rs.getString("player") + " " +
					"Minuts jugats: " + rs.getString("minutes_played") + " " +
					"Punts: " + rs.getString("points") + " " +
					"Rebots ofensius: " + rs.getString("offensive_rebounds") + " " +
					"Rebots defensius: " + rs.getString("defensive_rebounds") + " " +
					"Assistències:  " + rs.getString("assists") + " " +
					"Faltes comeses: " + rs.getString("committed_fouls") + " " +
					"Faltes recebudes: " + rs.getString("received_fouls") + " " +
					"Intents de tirs lliures: " + rs.getString("free_throw_attempts") + " " +
					"Tirs lliures: " + rs.getString("free_throw_made") + " " +
					"Intents de dos punts: " + rs.getString("two_point_attempts") + " " +
					"Dos punts: " + rs.getString("two_point_made") + " " +
					"Intents de triples: " + rs.getString("three_point_attempts") + " " +
					"Triples: " + rs.getString("three_point_made") + " " +
					"Bloqueigs: " + rs.getString("blocks") + " " +
					"Vegades bloquejat: " + rs.getString("blocks_against") + " " +
					"Intercepcions: " + rs.getString("steals") + " " +
					"Turnovers: " + rs.getString("turnovers") + " " +
					"Puntuació MVP: " + rs.getString("mvp_score"));
		}

		rs.close();
		st.close();

	}
}
