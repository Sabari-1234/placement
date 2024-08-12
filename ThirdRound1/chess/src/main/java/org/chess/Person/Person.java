package org.chess.Person;

import java.util.ArrayList;

public class Person implements Comparable <Person> {
    int personId;
    String personName;
    double points;
    int buyPoints;
    ArrayList<Integer> played=new ArrayList<>();
    boolean plyedOrNot;
    public Person(int personId, String personName) {
        this.personId = personId;
        this.personName = personName;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public int getBuyPoints() {
        return buyPoints;
    }

    public void setBuyPoints(int buyPoints) {
        this.buyPoints = buyPoints;
    }

    public ArrayList<Integer> getPlayed() {
        return played;
    }

    public void setPlayed(int player) {
        this.played.add(player);
    }

    public boolean isPlyedOrNot() {
        return plyedOrNot;
    }

    public void setPlyedOrNot(boolean plyedOrNot) {
        this.plyedOrNot = plyedOrNot;
    }

    @Override
    public int compareTo(Person person) {
        if(Double.compare(this.points,person.points)==0){
            return Double.compare(this.buyPoints,person.buyPoints);
        }
        return Double.compare(this.points,person.points);
    }
}
