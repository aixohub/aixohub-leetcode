package com.aixohub.leetcode.bloom;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.nio.charset.Charset;

public class Bloom {

  static    BloomFilter<CharSequence> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charset.forName("utf-8")),
            100000000,
            0.0001);


    public static void main(String[] args) {
        bloomFilter.put("死");
        bloomFilter.put("磕");
        bloomFilter.put("Redis");

        System.out.println(bloomFilter.mightContain("Redis"));
        System.out.println(bloomFilter.mightContain("死"));
        System.out.println(bloomFilter.mightContain("磕"));
        System.out.println(bloomFilter.mightContain("Java"));
    }
}
