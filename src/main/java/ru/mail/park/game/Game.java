package ru.mail.park.game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.WebSocketSession;
import ru.mail.park.model.Id;
import ru.mail.park.model.UserProfile;

import javax.validation.constraints.NotNull;
import java.util.*;

/**
 * Created by Andry on 21.11.16.
 */
public class Game {

    private static final Logger LOGGER = LoggerFactory.getLogger(Game.class);

    @NotNull
    private List<WebSocketSession> stepList = new ArrayList<>();

    @NotNull
    private Map<WebSocketSession, Player> players = new HashMap<>();

    @NotNull
    private Map<Integer, Firm> firms = new HashMap<>();

    @NotNull
    private Integer countFirms = 31;

    private Integer currentPlayerNumber = 0;

    @NotNull
    private final Random random = new Random();

    public void addPlayer(WebSocketSession ws, String name) {
        if(players.get(ws) == null) {
            players.put(ws, new Player(name));
            stepList.add(ws);
        }
    }

    public int doStep() {

        int number1 = random.nextInt(6);
        int number2 = random.nextInt(6);

        int sum = number1 + number2;

        Player player = players.get(stepList.get(currentPlayerNumber));

        if(player != null) {
            player.changeCurrentPosition(number1 + number2, countFirms);

            int position = player.getCurrentPosition();

            final Firm firm = firms.get(position);


        }
        return 0;
    }





    public void setPlayerToFirm(String username, int firmId) {
        Firm firm = firms.get(firmId);
        Player player = players.get(username);

        if(firm != null && player != null){
            firm.setPlayer(player);
        }else{
            LOGGER.warn(String.format("Change player(%s) in firm(%s) is invalid", username, firmId));
        }
    }

    public void changePlayerBalance(String username, int delta){
        if(delta != 0){
            Player player = players.get(username);
            if(player != null)
                player.changeBalance(delta);
        }
    }

    public boolean buyFirm(String username, int firmId) {
        Firm firm = firms.get(firmId);
        Player player = players.get(username);

        if(firm != null && player != null && firm.getPlayer() != null){
            // TODO
        }else{
            LOGGER.warn(String.format("Change player(%s) in firm(%s) is invalid", username, firmId));
        }
        return false;
    }

    public boolean upgradeFirm(int firmId) {
        Firm firm = firms.get(firmId);

        if(firm != null){
            return firm.upgrate();
        }
        return false;
    }





}
