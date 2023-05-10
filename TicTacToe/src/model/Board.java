package model;

import java.util.*;

public class Board {
    Integer size;
    ArrayList<List<String>> board;
    Player player;

    public Integer getSize() {
        return size;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Board(Integer size) {
        this.size = size;
        this.board = new ArrayList<List<String>>(size);
        this.player=null;
        initializeBoard(size);
    }

    public void initializeBoard(Integer size) {
        for (int i=0;i<size;i++) {
            List<String> innerList = new ArrayList<String>();
            for (int j=0;j<size;j++) {
                innerList.add(" ");
            }
            this.board.add(innerList);
        }
    }

    public boolean isFull() {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                if (this.board.get(i).contains(" ")) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidMove(int x, int y) {
        if (0<=x && x<this.size && 0<=y && y<this.size && this.board.get(x).get(y)==" ") {
            return true;
        }
        return false;
    }

    public void printBoard() {
        System.out.println(this.board.toString());
    }

    public void makeMove(Player player,Integer x, Integer y) {
        this.board.get(x).set(y, player.getSymbol());
    }

    public boolean isWinningMove(Player player,Integer x, Integer y) {
        Integer row,col,diag,rdiag;
        row = col = diag = rdiag = 0;
        for (int i=0;i<this.size;i++) {
            if (this.board.get(x).get(i)==player.getSymbol()) {
                row++;
            }
            if (this.board.get(i).get(y)==player.getSymbol()) {
                col++;
            }
            if (this.board.get(i).get(i)==player.getSymbol()) {
                diag++;
            }
            if (this.board.get(i).get(this.size-i-1)==player.getSymbol()) {
                rdiag++;
            }

        }
        if (row==this.size||col==this.size||diag==this.size||rdiag==this.size) {
            return true;
        }
        return false;
    }
}
