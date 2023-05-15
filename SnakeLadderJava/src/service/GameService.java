package service;

import dao.GameDao;
import model.Board;
import model.Dice;
import model.Player;

import java.util.ArrayList;

public class GameService {
    GameDao gameDao;
    Board board;
    Dice dice = new Dice();

    public GameService(Integer size, ArrayList<Player> players) {
        this.board = new Board(size);
        this.gameDao = new GameDao();

        gameDao.setLadders();
        gameDao.setSnakes();

        for (Player player:players) {
            gameDao.addPlayer(player);
        }
    }

    public void playGame() {
        while (true) {
            Integer diceNum = this.dice.rollDIce();
            Player player = this.gameDao.getPlayer();
            System.out.println(player.getName()+" turn, dice num: "+diceNum.toString());
            Integer position = player.getPosition();
            Integer newPosition = position+diceNum;
            if (newPosition> board.getSize()) {
                this.gameDao.addPlayer(player);
                continue;
            }
            if (newPosition.equals(board.getSize())) {
                System.out.println(player.getName()+ " wins");
                player.setWon(true);
                break;
            }

            if (!this.gameDao.getSnakes(position).equals(position)) {
                newPosition = this.gameDao.getSnakes(position);
                System.out.println("Snake bits,new position is "+newPosition.toString());
            } else if (!this.gameDao.getLadder(position).equals(position)) {
                newPosition = this.gameDao.getLadder(position);
                System.out.println("Ladder climbed,new position is "+newPosition.toString());
            } else {
                System.out.println("New position is "+newPosition.toString());
            }

            player.setPosition(newPosition);
            this.gameDao.addPlayer(player);
        }
    }


}
