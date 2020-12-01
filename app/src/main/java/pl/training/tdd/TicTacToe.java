package pl.training.tdd;

import java.util.ArrayList;
import java.util.List;

public class TicTacToe {

    private Boolean isBegin;
    private List<String> players;

    public TicTacToe() {
        players = new ArrayList<>();
    }

    public int begin(String firstPlayer, String secondPlayer) {
        if (!firstPlayer.isBlank() && !secondPlayer.isBlank()) {
            players.add(firstPlayer);
            players.add(secondPlayer);
            this.isBegin = true;
            return players.size();
        }
        return 0;
    }
}
