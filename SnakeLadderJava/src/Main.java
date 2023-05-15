
import model.Player;
import service.GameService;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter board size");
        Integer boardSize= sc.nextInt();
        ArrayList<Player> players = new ArrayList<Player>();
        Player p1 = new Player("Chaitanya");
        Player p2 = new Player("Teja");
        players.add(p1);
        players.add(p2);
        GameService gameService = new GameService(boardSize, players);
        gameService.playGame();
    }
}