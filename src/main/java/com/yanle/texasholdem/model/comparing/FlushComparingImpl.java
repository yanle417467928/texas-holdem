package com.yanle.texasholdem.model.comparing;


import com.yanle.texasholdem.model.Player;

/**
 * @Description: 同花顺的大小比较(比较最大牌即可)
 * @Author Richard
 * @Date 2018/6/5 16:49
 */
public class FlushComparingImpl extends AbstractComparing {

    public int compare(Player o1, Player o2) {
        return this.seqComparing(o1, o2);
    }

}
