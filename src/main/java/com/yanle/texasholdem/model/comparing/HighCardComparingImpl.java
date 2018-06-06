package com.yanle.texasholdem.model.comparing;


import com.yanle.texasholdem.model.Player;

/**
 * @Description: 高牌的大小比较(按顺序比较)
 * @Author Richard
 * @Date 2018/6/5 16:49
 */
public class HighCardComparingImpl extends AbstractComparing {

    public int compare(Player o1, Player o2) {
        return this.seqComparing(o1, o2);
    }

}
