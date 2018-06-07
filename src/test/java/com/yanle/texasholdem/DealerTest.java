package com.yanle.texasholdem;

import com.yanle.texasholdem.model.Player;
import com.yanle.texasholdem.model.Dealer;
import junit.framework.TestCase;
import org.junit.Test;

public class DealerTest extends TestCase {

    @Test
    public void testDealer() {
        Player player1 = new Player("周润发");
        Player player2 = new Player("周星驰");

        Dealer dealer = new Dealer(player1, player2);

        assertEquals(2, dealer.getPlayerSize());

        Player player3 = new Player("大军");
        dealer.join(player3);
        assertEquals(3, dealer.getPlayerSize());

        dealer.start();
        assertEquals(5, player1.getPokerSize());
        assertEquals(5, player2.getPokerSize());
        assertEquals(5, player3.getPokerSize());
    }

}
