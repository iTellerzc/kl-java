package com.iteller.kl.java.lang.iterable;

import java.util.Iterator;

/**
 * author:18060903(iTeller_zc)
 * date:2019/10/22 9:50
 * description:
 */
public class MyIterable implements Iterable<String> {

    private String value;

    public Iterator<String> iterator() {
        return new MyIterator();
    }

    class MyIterator implements Iterator<String>{

        private int cursor;

        private int length;

        public boolean hasNext() {
            //todo check
            return cursor <= length;
        }

        public String next() {
            return null;
        }

        public void remove() {

        }
    }
}
