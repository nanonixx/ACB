import javax.annotation.processing.Generated;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PlayerController {

	Scanner s = new Scanner(System.in);

	private Connection connection;
	
	public PlayerController(Connection connection) {
		this.connection = connection;
	}

	public void showPlayers() throws SQLException {

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

	public void createPlayer() throws SQLException {

		Statement st = connection.createStatement();


		System.out.print("Codi llicència federació: ");
		String federation_license_code  = s.nextLine();
		System.out.print("Nom del jugador: ");
		String first_name = s.nextLine();
		System.out.print("Cognom del jugador: ");
		String last_name = s.nextLine();
		System.out.print("Dia de naixement: ");
		String birth_date = s.nextLine();
		System.out.print("Gènere (M/F): ");
		String gender = s.nextLine();
		System.out.print("Alçada (cm): ");
		String height = s.nextLine();
		System.out.print("Nom de l'equip on juga: ");
		String team_name = s.nextLine();
		System.out.print("Vegades que ha sigut MVP: ");
		String mvp_total = s.nextLine();


		st.executeUpdate("INSERT INTO player VALUES (" +
				"'"+federation_license_code+"', " +
				"'"+first_name+"', " +
				"'"+last_name+"', " +
				"'"+birth_date+"', " +
				"'"+gender+"', " +
				"'"+height+"', " +
				"'"+team_name+"', " +
				"'"+mvp_total+"');");

		st.close();


	}

	public void showTeamlessPlayers() throws SQLException {

		Statement st = connection.createStatement();
		ResultSet rs;

		rs = st.executeQuery("SELECT first_name, last_name FROM player WHERE team_name ='';");

		while (rs.next()) {
			System.out.println("Name: " + rs.getString("first_name") + " " + rs.getString("last_name"));
		}

		rs.close();
		st.close();
	}

	public void assignPlayer() throws SQLException {
		Statement st = connection.createStatement();

		System.out.print("ID del jugador a assignar: ");
		String federation_license_code  = s.nextLine();
		System.out.print("Nou equip del jugador: ");
		String team_name = s.nextLine();
	}


	public void desvincular() throws SQLException {
		Statement st = connection.createStatement();

		System.out.print("ID del jugador a desvincular: ");
		String federation_license_code  = s.nextLine();

	}
}
