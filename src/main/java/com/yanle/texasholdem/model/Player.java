package com.yanle.texasholdem.model;

import com.yanle.texasholdem.constant.RankingEnum;
import com.yanle.texasholdem.model.comparing.ComparingFacade;
import com.yanle.texasholdem.model.comparing.IComparing;
import com.yanle.texasholdem.model.ranking.RankingResult;

import java.util.*;

/**
 * @Description: 玩家模型
 * @Author Richard
 * @Date 2018/6/5 17:35
 */
public class Player implements Comparable<Player> {
    private String name;
    private List<Poker> pokers; // 玩家手上的五张牌
    private RankingResult rankingResult; // 牌型校验结果

    public Player(String name) {
        this.pokers = new ArrayList<Poker>();
        this.name = name;
    }

    /**
     * 获得手上的牌的张数
     *
     * @return
     */
    public int getPokerSize() {
        return this.pokers.size();
    }

    /**
     * 增加手牌
     *
     * @param poker
     */
    public void addCard(Poker poker) {
        this.pokers.add(poker);
        Collections.sort(this.pokers);
    }

    public List<Poker> getPokers() {
        return pokers;
    }

    public RankingResult getRankingResult() {
        if (rankingResult == null) {
            rankingResult = new RankingResult();
            rankingResult.setRankingEnum(RankingEnum.HIGH_CARD);
            rankingResult.setHighPoker(this.pokers.get(0));
        }
        return rankingResult;
    }

    public void setRankingResult(RankingResult rankingResult) {
        this.rankingResult = rankingResult;
    }

    /**
     * 计算 5张牌中点数出现情况，如果有相同点数的牌，该点数出现次数+1
     *
     * @return
     */
    public Map<Integer, Integer> getPokerNumCountMap() {
        List<Poker> pokers = this.getPokers();
        Map<Integer, Integer> rankCount = new HashMap<Integer, Integer>();
        for (Poker card : pokers) {
            Integer number = new Integer(card.getNum().getNumber());
            if (!rankCount.containsKey(number)) {
                rankCount.put(number, 1);
            } else {
                rankCount.put(number, rankCount.get(number) + 1);
            }
        }
        return rankCount;
    }

    public int compareTo(Player o) {
        int selfPriority = this.getRankingResult().getRankingEnum().getPriority();
        int otherPriority = o.getRankingResult().getRankingEnum().getPriority();
        if (selfPriority < otherPriority) {
            return 1;
        }
        if (selfPriority > otherPriority) {
            return -1;
        }
        if (selfPriority == otherPriority) {
            IComparing cmp = ComparingFacade.getComparing(this.getRankingResult().getRankingEnum());
            return cmp.compare(this, o);
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", pokers=" + pokers +
                ", rankingResult=" + rankingResult +
                '}';
    }
}
