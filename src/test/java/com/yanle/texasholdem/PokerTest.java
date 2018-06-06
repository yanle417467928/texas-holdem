package com.yanle.texasholdem;

import com.yanle.texasholdem.constant.PokerColorEnum;
import com.yanle.texasholdem.constant.PokerNumEnum;
import com.yanle.texasholdem.model.Poker;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PokerTest extends TestCase {

    @Test
    public void testEquals() {

        Poker poker1 = new Poker(PokerColorEnum.HEART, PokerNumEnum.CARD_ACE);
        Poker poker2 = new Poker(PokerColorEnum.HEART, PokerNumEnum.CARD_ACE);
        Poker poker3 = new Poker(PokerColorEnum.SPADE, PokerNumEnum.CARD_ACE);

        assertEquals(poker1, poker1);
        assertEquals(poker1, poker2);
        assertFalse(poker1 == poker2);
    }

    @Test
    public void testHashcode() {


        Poker poker1 = new Poker(PokerColorEnum.HEART, PokerNumEnum.CARD_ACE);
        Poker poker2 = new Poker(PokerColorEnum.HEART, PokerNumEnum.CARD_ACE);
        Poker poker3 = new Poker(PokerColorEnum.SPADE, PokerNumEnum.CARD_ACE);

        assertEquals(poker1.hashCode(), poker1.hashCode());
        assertEquals(poker1.hashCode(), poker2.hashCode());
        assertFalse(poker1.hashCode() == poker3.hashCode());
    }

    @Test
    public void testToString() {

        Poker poker1 = new Poker(PokerColorEnum.HEART, PokerNumEnum.CARD_ACE);
        Poker poker2 = new Poker(PokerColorEnum.SPADE, PokerNumEnum.CARD_JACK);
        Poker poker3 = new Poker(PokerColorEnum.DIAMOND, PokerNumEnum.CARD_QUEUE);
        Poker poker4 = new Poker(PokerColorEnum.CLUB, PokerNumEnum.CARD_KING);

        assertEquals(poker1.toString(), "A14");
        assertEquals(poker2.toString(), "C11");
        assertEquals(poker3.toString(), "B12");
        assertEquals(poker4.toString(), "D13");
    }

    @Test
    public void testCompareTo() {
        List<Poker> cards = new ArrayList<Poker>();
        Poker poker1 = new Poker(PokerColorEnum.HEART, PokerNumEnum.CARD_ACE);
        Poker poker2 = new Poker(PokerColorEnum.SPADE, PokerNumEnum.CARD_KING);
        Poker poker3 = new Poker(PokerColorEnum.DIAMOND, PokerNumEnum.CARD_QUEUE);

        cards.add(poker1);
        cards.add(poker2);
        cards.add(poker3);

        Collections.sort(cards);

        assertEquals(poker1, cards.get(0));
        assertEquals(poker2, cards.get(1));
        assertEquals(poker3, cards.get(2));
    }

}
