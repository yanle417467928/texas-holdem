package com.yanle.texasholdem.model.ranking;

import com.yanle.texasholdem.constant.PokerColorEnum;
import com.yanle.texasholdem.model.Player;
import com.yanle.texasholdem.model.Poker;

import java.util.List;

/**
 * @Description: 抽象牌型解析接口, 抽象解析流程
 * @Author Richard
 * @Date 2018/6/5 17:38
 */
public abstract class AbstractRanking implements IRanking {
    public RankingResult resolve(Player player) {
        this.preResolve(player);
        RankingResult result = this.doResolve(player);
        this.postResolve(player, result);
        return result;
    }

    private void preResolve(Player player) {

    }

    private void postResolve(Player player, RankingResult result) {
        if (result != null) {
            result.setHighPoker((player.getPokers().get(0)));
        }
        player.setRankingResult(result);
    }

    protected abstract RankingResult doResolve(Player player);

    /**
     * 是否同花
     * @param pokers 玩家手中扑克牌
     * @return 是否同花
     */
    protected boolean isSameSuit(List<Poker> pokers) {
        if (pokers == null || pokers.size() == 0) {
            return false;
        }
        if (pokers.size() == 1) {
            return true;
        }
        if (pokers.size() > 1) {
            Poker poker = pokers.get(0);
            PokerColorEnum colorEnum = poker.getColor();
            for (int i = 1; i < pokers.size(); i++) {
                if (colorEnum != pokers.get(i).getColor()) {
                    return false;
                }
            }
        }
        return true;
    }
}
