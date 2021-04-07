package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _146LRUCache {
    public static void main(String args[]){
        LRUCache lruCache=new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        System.out.println(lruCache.get(2));
        lruCache.put(4,4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }
}

class LRUCache {
    HashMap<Integer,Integer> cache;
    int nums;
//    实际上存储的不是值而是键，存储值就要面临重复的问题，而且存储值没法直接得到键，而存储键可以直接得到值
    List<Integer> key;

    public LRUCache(int capacity) {
        cache=new HashMap<Integer, Integer>();
        key=new ArrayList<>();
        nums=capacity;
    }

    public int get(int key) {
        if(this.key.contains(key)){
            this.key.remove(this.key.indexOf(key));
            this.key.add(key);
            return cache.get(key);
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if(this.key.contains(key)) {
            this.key.remove(this.key.indexOf(key));
            this.key.add(key);
            cache.put(key,value);
        }else{
            if(this.key.size()>=nums){
                this.key.remove(0);
            }
            this.key.add(key);
            cache.put(key,value);
        }

    }
}
