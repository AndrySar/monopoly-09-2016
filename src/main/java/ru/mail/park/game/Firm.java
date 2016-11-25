package ru.mail.park.game;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andry on 21.11.16.
 */
public class Firm {

    private String name;
    private int cost;
    private Player player = null;
    private Integer level = 0;
    private List<Integer> upgradeCostList = new ArrayList<>();


    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public Player getPlayer() {
        return player;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public boolean upgrate(){
        if(player != null){
            if(level <= 2 && player.getBalance() >= upgradeCostList.get(level)){
                player.changeBalance((-1)*upgradeCostList.get(level));
                cost += upgradeCostList.get(level);
                level++;
                return true;
            }
        }
        return false;
    }
}
