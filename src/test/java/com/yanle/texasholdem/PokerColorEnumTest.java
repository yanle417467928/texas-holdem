package com.yanle.texasholdem;

import com.yanle.texasholdem.constant.PokerColorEnum;
import junit.framework.TestCase;
import org.junit.Test;

public class PokerColorEnumTest extends TestCase {

    @Test
    public void testGetName() {

        PokerColorEnum cardSuit1 = PokerColorEnum.HEART;
        PokerColorEnum cardSuit2 = PokerColorEnum.DIAMOND;
        PokerColorEnum cardSuit3 = PokerColorEnum.SPADE;
        PokerColorEnum cardSuit4 = PokerColorEnum.CLUB;

        assertEquals(cardSuit1.getName(), "A");
        assertEquals(cardSuit2.getName(), "B");
        assertEquals(cardSuit3.getName(), "C");
        assertEquals(cardSuit4.getName(), "D");
    }

}
