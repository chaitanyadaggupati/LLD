package DAO;

import model.Player;

import java.util.ArrayDeque;
import java.util.Deque;

public class BoardDao {
     Deque<Player> players= new ArrayDeque<Player>();

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Player getPlayer() {
        if (players.size()>0) {
            return players.pop();
        }
        return null;
    }

}
