package dao;

import model.Player;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class GameDao {
    Deque<Player> players = new ArrayDeque<Player>();
    Map<Integer,Integer> snakes = new HashMap<Integer,Integer>();
    Map<Integer,Integer> ladders = new HashMap<Integer,Integer>();

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Player getPlayer() {
        Player player = players.poll();
        return player;
    }

    public void setSnakes() {
        this.snakes.put(15,6);
        this.snakes.put(25,20);
        this.snakes.put(60,45);
        this.snakes.put(88,60);
    }

    public Integer getSnakes(Integer position) {
        return snakes.getOrDefault(position, position);
    }

    public void setLadders() {
        System.out.println(this.ladders);
        this.ladders.put(10,20);
        this.ladders.put(32,50);
        this.ladders.put(40,58);
        this.ladders.put(65,80);
        this.ladders.put(85,98);
    }

    public Integer getLadder(Integer position) {
        return ladders.getOrDefault(position, position);
    }
}
