import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

public class ACBMain {

	public static void main(String[] args) throws IOException, SQLException, ParseException {
		ACBMenu menu = new ACBMenu();
		
		ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
		Connection c = connectionFactory.connect();

		TeamController teamController = new TeamController(c);
		PlayerController playerController = new PlayerController(c);
		
		
//		Connection conn = null;
//		Identity identity;
//		int option;
//		int intents = 0;
//		DBAccessor dbaccessor = new DBAccessor();
//		dbaccessor.init();
//		while (intents < 3 && conn == null) {
//			identity = menu.authenticate(intents);
//			// prova de test
//			identity.toString();
//
//			conn = dbaccessor.getConnection(identity);
//			intents++;
//		}

		int option = menu.mainMenu();
		while (option > 0 && option < 12) {
			switch (option) {
			case 1:
				teamController.showTeams();
				break;

			case 2:
				playerController.showPlayers();
				break;

			case 3:
				teamController.createTeam();
				break;

			case 4:
				playerController.createPlayer();
				break;

			case 5:
				teamController.createMatch();
				break;

			case 6:
				playerController.showTeamlessPlayers();
				break;

			case 7:
				playerController.assignPlayer();
				break;

			case 8:
				playerController.desvincular();
				break;

			case 9:
				teamController.stats();
				break;

			case 10:
				System.exit(0);
				break;

			default:
				System.out.println("Introdueixi una de les opcions anteriors");
				break;

			}
			option = menu.mainMenu();
		}

	}

}
