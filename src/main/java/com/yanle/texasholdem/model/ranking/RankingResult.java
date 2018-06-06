package com.yanle.texasholdem.model.ranking;


import com.yanle.texasholdem.constant.RankingEnum;
import com.yanle.texasholdem.model.Poker;

/**
 * @Description: 牌型解析接口的返回值
 * @Author Richard
 * @Date 2018/6/5 17:38
 */
public class RankingResult {

    private Poker highPoker; // 5张牌中最大的值
    private RankingEnum rankingEnum; // 牌型

    public Poker getHighPoker() {
        return highPoker;
    }

    public void setHighPoker(Poker highPoker) {
        this.highPoker = highPoker;
    }

    public RankingEnum getRankingEnum() {
        return rankingEnum;
    }

    public void setRankingEnum(RankingEnum rankingEnum) {
        this.rankingEnum = rankingEnum;
    }

    @Override
    public String toString() {
        return "RankingResult{" +
                "rankingEnum=" + rankingEnum.getType() +
                '}';
    }
}
