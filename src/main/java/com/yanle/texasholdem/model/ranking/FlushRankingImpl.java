package com.yanle.texasholdem.model.ranking;


import com.yanle.texasholdem.constant.RankingEnum;
import com.yanle.texasholdem.model.Player;
import com.yanle.texasholdem.model.Poker;

import java.util.List;

/**
 * @Description: 解析玩家手中的牌是不是同花(花色连续一样)
 * @Author Richard
 * @Date 2018/6/5 17:38
 */
public class FlushRankingImpl extends AbstractRanking {

    protected RankingResult doResolve(Player player) {

        RankingResult result = null;

        List<Poker> pokers = player.getPokers();
        if (this.isSameSuit(pokers)) { // 如果是同色
            result = new RankingResult();
            result.setRankingEnum(RankingEnum.FLUSH);
        }

        return result;
    }

}
