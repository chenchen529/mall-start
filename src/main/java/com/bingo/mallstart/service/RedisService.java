package com.bingo.mallstart.service;


public interface RedisService {
    /**
     * 存储数据
     * @param key
     * @param value
     */
    void set(String key, String value);

    /**
     * 读取数据
     * @param key
     */
    String get(String key);

    /**
     * 设置过期时间
     * @param key
     * @param expire
     * @return
     */
    boolean expire(String key, Long expire);

    /**
     * 删除数据
     * @param key
     */
    void remove(String key);

    /**
     * 自增操作
     * @param key
     * @param delta
     * @return
     */
    Long increment(String key, long delta);


}
