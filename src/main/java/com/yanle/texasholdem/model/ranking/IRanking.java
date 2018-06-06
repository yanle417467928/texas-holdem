package com.yanle.texasholdem.model.ranking;


import com.yanle.texasholdem.model.Player;

/**
 * @Description: 牌型解析接口, 负责解析玩家手中的牌处于什么牌型
 * @Author Richard
 * @Date 2018/6/5 17:38
 */
public interface IRanking {
    RankingResult resolve(Player player);
}
