package model;

public class Instructor {
    public final static String NAME = "name";
    public final static String IND = "ind";

    private String name;
    private String ind;

    public Instructor() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInd() {
        return ind;
    }

    public void setInd(String ind) {
        this.ind = ind;
    }
}
