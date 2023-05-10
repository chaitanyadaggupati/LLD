package service;

import DAO.BoardDao;
import model.Board;
import model.Player;

import java.util.Scanner;

public class GameService {
    BoardDao boardDao;
    Board board;

    public GameService(BoardDao boardDao, Board board) {
        this.boardDao = boardDao;
        this.board = board;
    }

    public void playGame() {
        while (!isBoardFull()) {
            Player currentPlayer = boardDao.getPlayer();
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter x value");
            Integer x = sc.nextInt();
            System.out.println("Enter y value");
            Integer y = sc.nextInt();
            if (this.board.isValidMove(x,y)) {
                makeMove(currentPlayer,x,y);
            } else {
                System.out.println("not valid move");
            }
            this.board.printBoard();
            if (isWinningMove(currentPlayer,x,y)) {
                currentPlayer.setWon(true);
                System.out.println(currentPlayer.getName()+" Won");
                this.board.setPlayer(currentPlayer);
                break;
            }
            boardDao.addPlayer(currentPlayer);
        }
        if (this.board.getPlayer()==null) {
            System.out.println("Nobody Won, It's a tie");
        }
    }

    public boolean isBoardFull() {
        return this.board.isFull();
    }

    public void makeMove(Player currentPlayer, int x,int y) {
        this.board.makeMove(currentPlayer,x,y);
    }

    public Boolean isWinningMove(Player currentPlayer, Integer x,Integer y) {
        return this.board.isWinningMove(currentPlayer,x,y);
    }

}
