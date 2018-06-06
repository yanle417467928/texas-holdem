package com.yanle.texasholdem.model.ranking;


import com.yanle.texasholdem.constant.RankingEnum;
import com.yanle.texasholdem.model.Player;

/**
 * @Description: 默认实现, 返回HighCard类型
 * @Author Richard
 * @Date 2018/6/5 17:38
 */
public class DefaultRankingImpl extends AbstractRanking {

    protected RankingResult doResolve(Player player) {

        RankingResult result = new RankingResult();
        result.setRankingEnum(RankingEnum.HIGH_CARD);

        return result;
    }

}
