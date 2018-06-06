package com.yanle.texasholdem.comparing;

import com.yanle.texasholdem.constant.PokerColorEnum;
import com.yanle.texasholdem.constant.PokerNumEnum;
import com.yanle.texasholdem.constant.RankingEnum;
import com.yanle.texasholdem.model.Player;
import com.yanle.texasholdem.model.Poker;
import com.yanle.texasholdem.model.ranking.IRanking;
import com.yanle.texasholdem.model.ranking.RankingResult;
import com.yanle.texasholdem.model.ranking.StraightFlushRankingImpl;
import junit.framework.TestCase;
import org.junit.Test;

public class StraightFlushComparingImplTest extends TestCase {

    @Test
    public void testComparing() {
        Poker card1 = new Poker(PokerColorEnum.HEART, PokerNumEnum.CARD_FOUR);
        Poker card2 = new Poker(PokerColorEnum.HEART, PokerNumEnum.CARD_FIVE);
        Poker card3 = new Poker(PokerColorEnum.HEART, PokerNumEnum.CARD_SIX);
        Poker card4 = new Poker(PokerColorEnum.HEART, PokerNumEnum.CARD_SEVEN);
        Poker card5 = new Poker(PokerColorEnum.HEART, PokerNumEnum.CARD_EIGHT);

        Player p = new Player("周润发");
        p.addCard(card1);
        p.addCard(card2);
        p.addCard(card3);
        p.addCard(card4);
        p.addCard(card5);

        IRanking ranking = new StraightFlushRankingImpl();
        RankingResult result = ranking.resolve(p);

        assertTrue(result != null);
        assertEquals(result.getRankingEnum(), RankingEnum.STRAIGHT_FLUSH);


        Poker card21 = new Poker(PokerColorEnum.SPADE, PokerNumEnum.CARD_FOUR);
        Poker card22 = new Poker(PokerColorEnum.SPADE, PokerNumEnum.CARD_FIVE);
        Poker card23 = new Poker(PokerColorEnum.SPADE, PokerNumEnum.CARD_SIX);
        Poker card24 = new Poker(PokerColorEnum.SPADE, PokerNumEnum.CARD_SEVEN);
        Poker card25 = new Poker(PokerColorEnum.SPADE, PokerNumEnum.CARD_EIGHT);

        Player p2 = new Player("周润发");
        p2.addCard(card21);
        p2.addCard(card22);
        p2.addCard(card23);
        p2.addCard(card24);
        p2.addCard(card25);

        IRanking ranking2 = new StraightFlushRankingImpl();
        RankingResult result2 = ranking2.resolve(p2);

        assertTrue(result2 != null);
        assertEquals(result2.getRankingEnum(), RankingEnum.STRAIGHT_FLUSH);

        assertEquals(0, p.compareTo(p2));
    }
}
