package com.aixohub.leetcode.bloom;


import java.util.concurrent.*;

/**
 * 1. key对应对象在cache，直接返回结果
 * 2. key对应对象不在cache， 调用private 发方法计算结果，放入缓存，返回结果
 *
 * tip
 * 1. key对应对象不在cache，并发请求
 *   1.1 key相同，触发一次计算，其它请求阻塞（避免cpu浪费）
 *   1.2 key不相同，并行计算（提升响应速度）
 *
 * 2. 根据key计算结果时间比较长
 */
public class LocalCache {
    private final static ExecutorService executorService = Executors.newSingleThreadExecutor();
    private final static ConcurrentHashMap<String, Boolean> LOCAL_CALC  = new ConcurrentHashMap<>();
    private final static ConcurrentHashMap<String, Object> LOCAL_TIME  = new ConcurrentHashMap<>();
    private final static ConcurrentHashMap<String, Object> LOCAL_CACHE  = new ConcurrentHashMap<>();


    public Object get(String key){
        if(key == null){
            return null;
        }
        Object value = LOCAL_CACHE.get(key);
        if(value != null){
            return value;
        }

        //判断key 是否在计算
        while (LOCAL_CALC.get(key)){
            Thread.yield();
        }


        ThreadObject threadObject = new ThreadObject(key, LOCAL_TIME, LOCAL_CALC);
        Future future = executorService.submit(threadObject);

        return LOCAL_CACHE.get(key);


    }





    class ThreadObject implements Callable {
        String key;
        private   ConcurrentHashMap<String, Object> LOCAL_TIME ;
        private   ConcurrentHashMap<String, Boolean> LOCAL_CALC ;

        public ThreadObject(String key, ConcurrentHashMap<String, Object> LOCAL_TIME, ConcurrentHashMap<String, Boolean> LOCAL_CALC) {
            this.key = key;
            this.LOCAL_TIME = LOCAL_TIME;
            this.LOCAL_CALC = LOCAL_CALC;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        @Override
        public Object call() throws Exception {
            return cal(key);
        }

        private  synchronized Object cal(String key){
            // 时间耗时比较长
            long start = System.currentTimeMillis();
            int i = key.hashCode();
            long end = System.currentTimeMillis();
            LOCAL_TIME.put(key, end-start);
            LOCAL_CALC.put(key, Boolean.FALSE);
            return i;
        }
    }
}
