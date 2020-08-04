package com.kl.math.lru;

import java.io.*;
import java.util.*;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/5/25 19:10
 * description:
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作：
 * 获取数据 get 和 写入数据 put 。
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；
 * 如果密钥不存在，则插入该组「密钥/数据值」。
 * 当缓存容量达到上限时,它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 */
public class LRUCacheWithArray {

    private Map<Integer, Integer> cacheMap;

    private int capacity;

    private int[] ttlArray;

    public LRUCacheWithArray(int capacity){
        this.cacheMap = new HashMap<>(capacity);
        this.capacity = capacity;
        ttlArray = new int[capacity];
    }

    public int get(int key){
        Integer value = cacheMap.get(key);
        if(value == null){
            return -1;
        }else{
            //trigger ttl
            ttl(key);
            return value;
        }
    }

    private void ttl(Integer key) {
        int index = ttlArrayIndex(key);
        //found
        if(index != -1){
            if(realLength() == capacity){
                //remove first
                int[] leftHalf = Arrays.copyOfRange(ttlArray, 0, index);
                int[] rightHalf = Arrays.copyOfRange(ttlArray, index + 1, capacity);
                ttlArray = merge(leftHalf, rightHalf);
                ttlArray[capacity-1] = key;
            }else {
                int[] leftHalf = Arrays.copyOfRange(ttlArray, 0, index);
                int[] rightHalf = Arrays.copyOfRange(ttlArray, index+1, capacity);
                ttlArray = merge(leftHalf, rightHalf);
                ttlArray[realLength()] = key;
            }
        }else{
            // not found
            if(realLength() == capacity){
                //remove first
                int[] leftHalf =  Arrays.copyOfRange(ttlArray, 1, capacity);
                int[] rightHalf = {0};
                ttlArray = merge(leftHalf, rightHalf);
                ttlArray[capacity-1] = key;
            }else {
                if(realLength() > 0){
                    ttlArray[realLength()] = key;
                }else{
                    ttlArray[0] = key;
                }
            }
        }
    }

    private int[] merge(int[] leftHalf, int[] rightHalf) {
        int[] concatArray = new int[capacity];
        System.arraycopy(leftHalf, 0, concatArray, 0, leftHalf.length);
        System.arraycopy(rightHalf, 0, concatArray, leftHalf.length, rightHalf.length);
        return concatArray;
    }

    private int ttlArrayIndex(Integer key) {
        for(int index = 0; index < realLength(); index ++){
            if(Integer.compare(ttlArray[index], key) == 0){
                return index;
            }
        }
        return -1;
    }

    private int realLength() {
        int realLength = 0;
        for(Integer data : ttlArray){
            if(Integer.compare(data,0) != 0){
                realLength++ ;
            }
        }
        return realLength;
    }

    public void put(int key, int value){
        //remove head
        if(cacheMap.size() == capacity){
            if (!cacheMap.containsKey(key)){
                //sync clear map queue
                removeTTLHeader();
            }
        }

        //put or recover
        cacheMap.put(key, value);

        //ttl
        ttl(key);

        /*System.out.println("put key:" + key + ", value:" + value
                + ", cacheMap:" + cacheMap + ", size:" + cacheMap.size()
                + ", ttlArray:" + Arrays.toString(ttlArray) + ", ttlArray real size:" + realLength() + ".");*/
    }

    private void removeTTLHeader() {
        Integer header = ttlArray[0];
        if(Integer.compare(header, 0) != 0){
            System.out.println("remove least recent use key:" + header + ", value:" + cacheMap.get(header));
            cacheMap.remove(header);
        }
    }

    public static void main(String[] args) throws IOException {
        //test1();

        //test2();

        //test3();

        //test4();

        testFromFile();
    }

    private static void testFromFile() throws IOException {
        long startTime = System.currentTimeMillis();
        File file = null;
        FileReader fileReader = null;
        BufferedReader br = null;
        try {
            file = new File(LRUCacheWithArray.class.getClassLoader().getResource("lru.txt").getFile());
            fileReader = new FileReader(file);
            br = new BufferedReader(fileReader);
            String firstLine = br.readLine();
            firstLine = firstLine.substring(1, firstLine.length()-1);
            //System.out.println(firstLine);
            String[] keyArray = firstLine.split(",");
            //System.out.println(Arrays.toString(keyArray));
            String secondLine = br.readLine();
            secondLine = secondLine.substring(1, secondLine.length()-1);
            //System.out.println(secondLine);
            String[] valueArray = secondLine.split("],");
            //System.out.println(Arrays.toString(valueArray));
            LRUCacheWithArray cache = new LRUCacheWithArray(Integer.valueOf(valueArray[0].substring(1)));
            for(int i =1; i< keyArray.length - 1; i++){
                if(keyArray[i].contains("get")){
                    cache.get(Integer.valueOf(valueArray[i].substring(1)));
                }else{
                    String[] putValue = valueArray[i].split(",");
                    //System.out.println(Arrays.toString(putValue));
                    cache.put(Integer.valueOf(putValue[0].substring(1)), Integer.valueOf(putValue[1]));
                }
            }
            if(keyArray[keyArray.length-1].contains("get")){
                cache.get(Integer.valueOf(valueArray[keyArray.length-1].substring(1, valueArray[keyArray.length-1].length()-1)));
            }else{
                String[] putValue = valueArray[keyArray.length-1].split(",");
                //System.out.println(Arrays.toString(putValue));
                cache.put(Integer.valueOf(putValue[0].substring(1)), Integer.valueOf(putValue[1].substring(0, putValue[1].length()-1)));
            }

            long endTime = System.currentTimeMillis();
            System.out.println("spent:" + (endTime - startTime) + " ms");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            br.close();
            fileReader.close();
        }
    }

    private static void test4() {
        LRUCacheWithArray cache = new LRUCacheWithArray( 10 );

        cache.put(10, 13);
        cache.put(3, 17);
        cache.put(6, 11);
        cache.put(10, 5);
        cache.put(9, 10);
        cache.get(13);
        cache.put(2, 19);
        cache.get(2);
        cache.put(5, 25);
        cache.get(8);
        cache.put(9, 22);
        cache.put(5, 5);
        cache.put(1, 30);
        cache.get(11);
        cache.put(9, 12);
        cache.get(7);
        cache.get(5);
        cache.get(8);
        cache.get(9);
        cache.put(4, 30);
        cache.put(9, 3);
        cache.get(9);
        cache.get(10);
        cache.get(10);
        cache.put(6, 14);
        cache.put(3, 1);
        cache.get(3);

        cache.put(10, 11);
        cache.get(8);
        cache.put(2, 14);
        cache.get(1);
        cache.get(5);
        cache.get(4);
        cache.put(11, 4);
        cache.put(12, 24);
        cache.put(5, 18);
        cache.get(13);
        cache.put(7, 23);
        cache.get(8);
        cache.get(12);
        cache.put(3, 27);
        cache.put(2, 12);
        cache.get(5);
        cache.put(2, 9);

        cache.put(13, 4);
        cache.put(8, 18);
        cache.put(1, 7);
        cache.get(6);
        cache.put(9, 29);
        cache.put(8, 21);
        cache.get(5);
        cache.put(6, 30);
        cache.put(1, 12);
        cache.get(10);
        cache.put(4, 15);
        cache.put(7, 22);
        cache.put(11, 26);
        cache.put(8, 17);
        cache.put(9, 29);
        cache.get(5);
        cache.put(3, 4);
        cache.put(11, 30);
        cache.get(12);
        cache.put(4, 29);
        cache.get(3);
        cache.get(9);
        cache.get(6);
        cache.put(3, 4);
        cache.get(1);
        cache.get(10);
        cache.put(3, 29);
        cache.put(10, 28);
        cache.put(1, 20);
        cache.put(11, 13);
        cache.get(3);
        cache.put(3, 12);
        cache.put(3, 8);
        cache.put(10, 9);
        cache.put(3, 26);
        cache.get(8);
        cache.get(7);
        cache.get(5);
        cache.put(13, 17);
        cache.put(2, 27);
        cache.put(11, 15);
        cache.get(12);
        cache.put(9, 19);
        cache.put(2, 15);
        cache.put(3, 16);
        cache.get(1);
        cache.put(12, 17);
        cache.put(9, 1);
        cache.put(6, 19);
        cache.get(4);
        cache.get(5);
        cache.get(5);
        cache.put(8, 1);
        cache.put(11, 7);
        cache.put(5, 2);
        cache.put(9, 28);
        cache.get(1);
        cache.put(2, 2);
        cache.put(7, 4);
        cache.put(4, 22);
        cache.put(7, 24);
        cache.put(9, 26);
        cache.put(13, 28);
        cache.put(11, 26);
    }

    private static void test3() {
        LRUCacheWithArray cache = new LRUCacheWithArray( 2 );

        cache.get(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);
        cache.put(3, 3);
        cache.get(2);
        cache.put(4, 4);
        cache.get(1);
        cache.get(3);
        cache.get(4);
    }

    private static void test2() {
        LRUCacheWithArray cache = new LRUCacheWithArray( 2 );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);
        cache.put(3, 3);
        cache.get(2);
        cache.put(4, 4);
        cache.get(1);
        cache.get(3);
        cache.get(4);
    }

    private static void test1() {
        LRUCacheWithArray cache = new LRUCacheWithArray( 2 );

        cache.get(2);

        cache.put(2, 6);
        cache.get(1);
        cache.put(1, 5);

        cache.put(1,2);

        cache.get(1);
        cache.get(2);
    }
}
