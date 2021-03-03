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
				teamController.showPlayers();
				break;

			case 3:
				// Crea equip
				break;

			case 4:
				// Crea jugador
				break;

			case 5:
				// Crea partit
				break;

			case 6:
				// Mostra jugadors a un equip
				break;

			case 7:
				// Assigna jugador a un equip
				break;

			case 8:
				// Desvincula jugador d'un equip
				break;

			case 9:
				// Carrega estadístiques
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
