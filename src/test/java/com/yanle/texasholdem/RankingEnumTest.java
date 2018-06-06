package com.yanle.texasholdem;

import com.yanle.texasholdem.constant.RankingEnum;
import junit.framework.TestCase;
import org.junit.Test;

public class RankingEnumTest extends TestCase {

    @Test
    public void testGetNumber() {

        RankingEnum ruleRanking1 = RankingEnum.FLUSH;

        assertEquals(ruleRanking1.getType(), "同花");
        assertEquals(ruleRanking1.getPriority(), 600);
    }

}
