package model;

public class Board {
    Integer size;
    Integer start;
    Integer end;

    public Board(Integer size) {
        this.size = size;
        this.start=1;
        this.end=this.start+size-1;

    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }
}
