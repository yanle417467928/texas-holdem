package com.yanle.texasholdem.ranking;

import com.yanle.texasholdem.constant.PokerColorEnum;
import com.yanle.texasholdem.constant.PokerNumEnum;
import com.yanle.texasholdem.constant.RankingEnum;
import com.yanle.texasholdem.model.Player;
import com.yanle.texasholdem.model.Poker;
import com.yanle.texasholdem.model.ranking.IRanking;
import com.yanle.texasholdem.model.ranking.RankingResult;
import com.yanle.texasholdem.model.ranking.TwoPairsRankingImpl;
import junit.framework.TestCase;
import org.junit.Test;

public class TwoPairsRankingImplTest extends TestCase {


    @Test
    public void testIsTwoPairsRanking() {

        Poker card13 = new Poker(PokerColorEnum.HEART, PokerNumEnum.CARD_KING);
        Poker card1313 = new Poker(PokerColorEnum.DIAMOND, PokerNumEnum.CARD_KING);
        Poker card12 = new Poker(PokerColorEnum.SPADE, PokerNumEnum.CARD_QUEUE);
        Poker card1212 = new Poker(PokerColorEnum.CLUB, PokerNumEnum.CARD_QUEUE);
        Poker card9 = new Poker(PokerColorEnum.HEART, PokerNumEnum.CARD_NINE);

        Poker otherSuitCard = new Poker(PokerColorEnum.DIAMOND, PokerNumEnum.CARD_TEN);

        Player p = new Player("周润发");
        p.addCard(card13);
        p.addCard(card1313);
        p.addCard(card1212);
        p.addCard(card12);
        p.addCard(card9);

        IRanking ranking = new TwoPairsRankingImpl();

        RankingResult result = ranking.resolve(p);
        assertTrue(result != null);

        assertEquals(result.getRankingEnum(), RankingEnum.TWO_PAIR);

        Player p2 = new Player("周润发");
        p2.addCard(card13);
        p2.addCard(card1313);
        p2.addCard(card12);
        p2.addCard(card9);
        p2.addCard(otherSuitCard);

        IRanking ranking2 = new TwoPairsRankingImpl();

        RankingResult result2 = ranking2.resolve(p2);
        assertTrue(result2 == null);

    }

}
