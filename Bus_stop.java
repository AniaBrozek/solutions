package org.example;

public class Bus_stop {
    public int[] position=new int[2];
    public int numberOfPeople;
    public Bus_stop( int pion,int poziom, int numberOfPeople) {
        this.position[0]=poziom;
        this.position[1]=pion;
        this.numberOfPeople = numberOfPeople;
    }
}