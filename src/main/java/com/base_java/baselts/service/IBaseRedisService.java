package com.base_java.baselts.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IBaseRedisService<K,F,V> {
    //lưu cặp key value vào trong redis
    void set(K key,V value);
    // set tg để cho dữ liệu bộ nhớ cache trong redis tồn tại hết tg thì xóa
    void setTimeToLive(K key,long timeoutIndays);
    void hashSet(K key, F field, V value);

    // kểm tra xem cos tồn tại cái key và field đấy k
    boolean hashExists(K key,F field);
    //lấy ra
    Object get(K key);
    public Map<F,V> getField(K key);
    Object hashGet(K key,F field);
    List<V> hashGetByFieldPrefix(K key, F filedPrefix);
    Set<F> getFieldPrefixes(K key);
    void delete(K key);
    void delete(K key, F field);
    void delete(K key,List<F> fields);
}
