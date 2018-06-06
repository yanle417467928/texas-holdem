package com.yanle.texasholdem.ranking;

import com.yanle.texasholdem.constant.PokerColorEnum;
import com.yanle.texasholdem.constant.PokerNumEnum;
import com.yanle.texasholdem.constant.RankingEnum;
import com.yanle.texasholdem.model.Player;
import com.yanle.texasholdem.model.Poker;
import com.yanle.texasholdem.model.ranking.IRanking;
import com.yanle.texasholdem.model.ranking.RankingResult;
import com.yanle.texasholdem.model.ranking.RoyalFlushRankingImpl;
import junit.framework.TestCase;
import org.junit.Test;

public class RoyalFlushRankingImplTest extends TestCase {


    @Test
    public void testIsRoyalFlushRanking() {

        Poker card1 = new Poker(PokerColorEnum.HEART, PokerNumEnum.CARD_ACE);
        Poker card2 = new Poker(PokerColorEnum.HEART, PokerNumEnum.CARD_KING);
        Poker card3 = new Poker(PokerColorEnum.HEART, PokerNumEnum.CARD_QUEUE);
        Poker card4 = new Poker(PokerColorEnum.HEART, PokerNumEnum.CARD_JACK);
        Poker card5 = new Poker(PokerColorEnum.HEART, PokerNumEnum.CARD_TEN);

        Poker otherSuitCard = new Poker(PokerColorEnum.DIAMOND, PokerNumEnum.CARD_TEN);

        Player p = new Player("周润发");
        p.addCard(card1);
        p.addCard(card2);
        p.addCard(card3);
        p.addCard(card4);
        p.addCard(card5);

        IRanking ranking = new RoyalFlushRankingImpl();

        RankingResult result = ranking.resolve(p);
        assertTrue(result != null);

        assertEquals(result.getRankingEnum(), RankingEnum.ROYAL_FLUSH);

        Player p2 = new Player("周润发");
        p2.addCard(card1);
        p2.addCard(card2);
        p2.addCard(card3);
        p2.addCard(card4);
        p2.addCard(otherSuitCard);

        IRanking ranking2 = new RoyalFlushRankingImpl();

        RankingResult result2 = ranking2.resolve(p2);
        assertTrue(result2 == null);

    }

}
