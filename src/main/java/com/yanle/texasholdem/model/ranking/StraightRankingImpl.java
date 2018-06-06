package com.yanle.texasholdem.model.ranking;


import com.yanle.texasholdem.constant.RankingEnum;
import com.yanle.texasholdem.model.Player;
import com.yanle.texasholdem.model.Poker;

import java.util.List;

/**
 * @Description: 解析玩家手中的牌是不是顺子
 * @Author Richard
 * @Date 2018/6/5 17:38
 */
public class StraightRankingImpl extends AbstractRanking {

    protected RankingResult doResolve(Player player) {

        RankingResult result = null;

        List<Poker> cards = player.getPokers();
        if (!this.isSameSuit(cards)) { // 如果是同色
            boolean isStraight = true;
            Poker previousCard = null;
            for (Poker card : cards) {
                if (previousCard != null) {
                    if (card.getNum().getNumber() - previousCard.getNum().getNumber() != -1) {
                        isStraight = false;
                        break;
                    }
                }
                previousCard = card;
            }
            if (isStraight == true) {
                result = new RankingResult();
                result.setRankingEnum(RankingEnum.STRAIGHT);
            }

        }

        return result;
    }

}
