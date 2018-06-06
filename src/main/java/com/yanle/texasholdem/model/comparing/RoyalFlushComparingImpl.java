package com.yanle.texasholdem.model.comparing;


import com.yanle.texasholdem.model.Player;

/**
 * @Description: 皇家同花顺的大小比较(唯一, 不考虑花色, 返回0)
 * @Author Richard
 * @Date 2018/6/6 08:38
 */
public class RoyalFlushComparingImpl extends AbstractComparing {
    public int compare(Player o1, Player o2) {
        return 0;
    }
}
