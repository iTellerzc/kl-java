package com.kl.flink;

/**
 * author:18060903(iTeller_zc)
 * date:2019/10/21 15:49
 * description:
 */
public class WordWithCount {

    public String word;
    public long count;

    public WordWithCount() {}

    public WordWithCount(String word, long count) {
        this.word = word;
        this.count = count;
    }

    @Override
    public String toString() {
        return word + " : " + count;
    }
}
