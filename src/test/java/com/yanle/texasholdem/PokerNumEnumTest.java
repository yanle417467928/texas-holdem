package com.yanle.texasholdem;

import com.yanle.texasholdem.constant.PokerNumEnum;
import junit.framework.TestCase;
import org.junit.Test;

public class PokerNumEnumTest extends TestCase {

    @Test
    public void testGetNumber() {

        PokerNumEnum cardRank1 = PokerNumEnum.CARD_ACE;
        PokerNumEnum cardRank2 = PokerNumEnum.CARD_TWO;
        PokerNumEnum cardRank3 = PokerNumEnum.CARD_TEN;

        assertEquals(14, cardRank1.getNumber().intValue());
        assertEquals(2, cardRank2.getNumber().intValue());
        assertEquals(10, cardRank3.getNumber().intValue());
    }

}
