package com.yanle.texasholdem;

import com.yanle.texasholdem.constant.Constants;
import com.yanle.texasholdem.constant.PokerColorEnum;
import com.yanle.texasholdem.constant.PokerNumEnum;
import com.yanle.texasholdem.model.Player;
import com.yanle.texasholdem.model.Poker;
import com.yanle.texasholdem.model.PokerSuit;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Map;

public class PlayerTest extends TestCase {

    @Test
    public void testAddCard() {
        PokerSuit poker = new PokerSuit();
        Player player = new Player("周润发");
        for (int i = 0; i < Constants.HAND_CARD_NUMBERS; i++) {
            player.addCard(poker.dispatch());
        }
        assertEquals(5, player.getPokerSize());
    }

    @Test
    public void testGetCardsRankCountMap() {
        Player player = new Player("周润发");

        Poker card = new Poker(PokerColorEnum.HEART, PokerNumEnum.CARD_ACE);
        Poker card2 = new Poker(PokerColorEnum.SPADE, PokerNumEnum.CARD_JACK);
        Poker card3 = new Poker(PokerColorEnum.DIAMOND, PokerNumEnum.CARD_QUEUE);
        Poker card4 = new Poker(PokerColorEnum.CLUB, PokerNumEnum.CARD_KING);
        Poker card5 = new Poker(PokerColorEnum.CLUB, PokerNumEnum.CARD_KING);

        player.addCard(card);
        player.addCard(card2);
        player.addCard(card3);
        player.addCard(card4);
        player.addCard(card5);

        Map<Integer, Integer> rankCount = player.getPokerNumCountMap();

        assertEquals(2, rankCount.get(PokerNumEnum.CARD_KING.getNumber()).intValue());
        assertEquals(1, rankCount.get(PokerNumEnum.CARD_ACE.getNumber()).intValue());
        assertEquals(1, rankCount.get(PokerNumEnum.CARD_QUEUE.getNumber()).intValue());
        assertEquals(1, rankCount.get(PokerNumEnum.CARD_JACK.getNumber()).intValue());
    }

}
