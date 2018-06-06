package com.yanle.texasholdem;

import com.yanle.texasholdem.model.Poker;
import com.yanle.texasholdem.model.PokerSuit;
import junit.framework.TestCase;
import org.junit.Test;

public class PokerSuitTest extends TestCase {

    @Test
    public void testGetSize() {
        PokerSuit pokerSuit = new PokerSuit();
        assertEquals(52, pokerSuit.getSize());
    }

    @Test
    public void testDispatch() {
        PokerSuit pokerSuit = new PokerSuit();

        pokerSuit.dispatch();
        assertEquals(51, pokerSuit.getSize());

        pokerSuit.dispatch();
        assertEquals(50, pokerSuit.getSize());
    }
}
