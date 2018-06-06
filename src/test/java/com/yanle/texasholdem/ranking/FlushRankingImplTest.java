package com.yanle.texasholdem.ranking;

import com.yanle.texasholdem.constant.PokerColorEnum;
import com.yanle.texasholdem.constant.PokerNumEnum;
import com.yanle.texasholdem.constant.RankingEnum;
import com.yanle.texasholdem.model.Player;
import com.yanle.texasholdem.model.Poker;
import com.yanle.texasholdem.model.ranking.FlushRankingImpl;
import com.yanle.texasholdem.model.ranking.IRanking;
import com.yanle.texasholdem.model.ranking.RankingResult;
import junit.framework.TestCase;
import org.junit.Test;

public class FlushRankingImplTest extends TestCase {


    @Test
    public void testIsFlushRanking() {

        Poker card13 = new Poker(PokerColorEnum.HEART, PokerNumEnum.CARD_KING);
        Poker card12 = new Poker(PokerColorEnum.HEART, PokerNumEnum.CARD_QUEUE);
        Poker card11 = new Poker(PokerColorEnum.HEART, PokerNumEnum.CARD_JACK);
        Poker card10 = new Poker(PokerColorEnum.HEART, PokerNumEnum.CARD_TEN);
        Poker card8 = new Poker(PokerColorEnum.HEART, PokerNumEnum.CARD_EIGHT);

        Poker otherSuitCard = new Poker(PokerColorEnum.DIAMOND, PokerNumEnum.CARD_TEN);

        Player p = new Player("周润发");
        p.addCard(card8);
        p.addCard(card10);
        p.addCard(card11);
        p.addCard(card12);
        p.addCard(card13);

        IRanking ranking = new FlushRankingImpl();

        RankingResult result = ranking.resolve(p);
        assertTrue(result != null);

        assertEquals(result.getRankingEnum(), RankingEnum.FLUSH);

        Player p2 = new Player("周润发");
        p2.addCard(card8);
        p2.addCard(card10);
        p2.addCard(card11);
        p2.addCard(card12);
        p2.addCard(otherSuitCard);

        IRanking ranking2 = new FlushRankingImpl();

        RankingResult result2 = ranking2.resolve(p2);
        assertTrue(result2 == null);

    }

}
