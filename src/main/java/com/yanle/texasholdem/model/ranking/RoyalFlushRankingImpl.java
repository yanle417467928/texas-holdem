package com.yanle.texasholdem.model.ranking;


import com.yanle.texasholdem.constant.PokerNumEnum;
import com.yanle.texasholdem.constant.RankingEnum;
import com.yanle.texasholdem.model.Player;
import com.yanle.texasholdem.model.Poker;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 解析玩家手中的牌是不是皇家同花顺(即是 10 J Q K A 且同色)
 * @Author Richard
 * @Date 2018/6/5 17:38
 */
public class RoyalFlushRankingImpl extends AbstractRanking {

    protected RankingResult doResolve(Player player) {

        RankingResult result = null;

        List<Poker> pokers = player.getPokers();
        if (this.isSameSuit(pokers)) { // 如果是同色
            List<PokerNumEnum> ranks = new ArrayList<PokerNumEnum>();
            for (Poker poker : pokers) {
                ranks.add(poker.getNum());
            }
            if (ranks.contains(PokerNumEnum.CARD_TEN) // 且是10 J Q K A
                    && ranks.contains(PokerNumEnum.CARD_JACK)
                    && ranks.contains(PokerNumEnum.CARD_QUEUE)
                    && ranks.contains(PokerNumEnum.CARD_KING)
                    && ranks.contains(PokerNumEnum.CARD_ACE)) {
                result = new RankingResult();
                result.setRankingEnum(RankingEnum.ROYAL_FLUSH);
            }
        }

        return result;
    }

}
