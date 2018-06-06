package com.yanle.texasholdem.comparing;
import com.yanle.texasholdem.constant.PokerColorEnum;
import com.yanle.texasholdem.constant.PokerNumEnum;
import com.yanle.texasholdem.constant.RankingEnum;
import com.yanle.texasholdem.model.Player;
import com.yanle.texasholdem.model.Poker;
import com.yanle.texasholdem.model.ranking.FullHouseRankingImpl;
import com.yanle.texasholdem.model.ranking.IRanking;
import com.yanle.texasholdem.model.ranking.RankingResult;
import junit.framework.TestCase;
import org.junit.Test;

public class FullHouseComparingImplTest extends TestCase {

    @Test
    public void testComparing() {
        Poker card1 = new Poker(PokerColorEnum.HEART, PokerNumEnum.CARD_FOUR);
        Poker card2 = new Poker(PokerColorEnum.SPADE, PokerNumEnum.CARD_FOUR);
        Poker card3 = new Poker(PokerColorEnum.DIAMOND, PokerNumEnum.CARD_FOUR);
        Poker card4 = new Poker(PokerColorEnum.CLUB, PokerNumEnum.CARD_TWO);
        Poker card5 = new Poker(PokerColorEnum.HEART, PokerNumEnum.CARD_TWO);

        Player p = new Player("周润发");
        p.addCard(card1);
        p.addCard(card2);
        p.addCard(card3);
        p.addCard(card4);
        p.addCard(card5);

        IRanking ranking = new FullHouseRankingImpl();
        RankingResult result = ranking.resolve(p);

        assertTrue(result != null);
        assertEquals(result.getRankingEnum(), RankingEnum.FULL_HOUSE);


        Poker card21 = new Poker(PokerColorEnum.SPADE, PokerNumEnum.CARD_TWO);
        Poker card22 = new Poker(PokerColorEnum.DIAMOND, PokerNumEnum.CARD_TWO);
        Poker card23 = new Poker(PokerColorEnum.CLUB, PokerNumEnum.CARD_TWO);
        Poker card24 = new Poker(PokerColorEnum.HEART, PokerNumEnum.CARD_TEN);
        Poker card25 = new Poker(PokerColorEnum.SPADE, PokerNumEnum.CARD_TEN);

        Player p2 = new Player("周润发");
        p2.addCard(card21);
        p2.addCard(card22);
        p2.addCard(card23);
        p2.addCard(card24);
        p2.addCard(card25);

        IRanking ranking2 = new FullHouseRankingImpl();
        RankingResult result2 = ranking2.resolve(p2);

        assertTrue(result2 != null);
        assertEquals(result2.getRankingEnum(), RankingEnum.FULL_HOUSE);

        assertEquals(-1, p.compareTo(p2));
    }
}
