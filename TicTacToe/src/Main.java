import DAO.BoardDao;
import model.Board;
import model.Player;
import service.GameService;

public class Main {
    public static void main(String[] args) {
        Player p1 = new Player("Chaitanya", "X");
        Player p2 = new Player("Teja", "O");
        BoardDao boardDao = new BoardDao();
        boardDao.addPlayer(p1);
        boardDao.addPlayer(p2);
        Board board = new Board(3);
        GameService gameService = new GameService(boardDao,board);
        gameService.playGame();
    }
}