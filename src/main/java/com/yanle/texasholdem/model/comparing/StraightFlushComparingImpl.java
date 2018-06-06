package com.yanle.texasholdem.model.comparing;


import com.yanle.texasholdem.model.Player;


/**
 * @Description:  同花顺的大小比较(按顺序比较)
 * @Author Richard
 * @Date 2018/6/6 08:38
 */
public class StraightFlushComparingImpl extends AbstractComparing {

    public int compare(Player o1, Player o2) {
        return this.seqComparing(o1, o2);
    }

}
