package ru.mail.park.game;

/**
 * Created by Andry on 21.11.16.
 */
public class Player {
    private String name;
    private int balance;
    private int currentPosition;

    public Player(String name) {
        this.name = name;
        this.balance = 15000;
        currentPosition = 0;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void changeBalance(int delta) {
        this.balance += delta;
    }

    public void changeCurrentPosition(int delta, int countFirms) {
        this.currentPosition = ( this.currentPosition + delta ) % countFirms;
    }

}
