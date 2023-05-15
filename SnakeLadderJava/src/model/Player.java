package model;

public class Player {
    String name;
    Boolean isWon;
    Integer position;

    public Player(String name) {
        this.name = name;
        this.isWon=false;
        this.position=0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getWon() {
        return isWon;
    }

    public void setWon(Boolean won) {
        isWon = won;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }
}
