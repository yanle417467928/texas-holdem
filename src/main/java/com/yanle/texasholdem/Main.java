package com.yanle.texasholdem;


import com.yanle.texasholdem.model.Player;
import com.yanle.texasholdem.model.Dealer;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Dealer d = new Dealer();

        Player player1 = new Player("周星驰");
        Player player2 = new Player("周润发");

        d.join(player1);
        d.join(player2);

        d.start();
        d.showHand();

        List<Player> players = d.getRankingPlayers();

        System.out.println("按牌面大 -->> 小输出各位玩家牌面信息");
        for (Player player : players) {
            System.out.println(player.toString());
        }
    }

}
