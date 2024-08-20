package com.base_java.baselts.service.impl;

import com.base_java.baselts.service.IBaseRedisService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class BaseRedisService<K,F,V> implements IBaseRedisService<K,F,V> {
    RedisTemplate<K,V> redisTemplate;
    HashOperations<K,F,V> hashOperations;
    @Override
    public void set(K key, V value) {
        redisTemplate.opsForValue().set(key,value);
    }

    @Override
    public void setTimeToLive(K key, long timeoutIndays) {
        redisTemplate.expire(key,timeoutIndays, TimeUnit.DAYS);
    }

    @Override
    public void hashSet(K key, F field, V value) {
        hashOperations.put(key, field, value);
    }

    @Override
    public boolean hashExists(K key, F field) {
        return hashOperations.hasKey(key,field);
    }

    @Override
    public Object get(K key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public Map<F,V> getField(K key) {
        return hashOperations.entries(key);

    }

    @Override
    public Object hashGet(K key, F field) {
        return hashOperations.get(key,field);
    }

    @Override
    public List<V> hashGetByFieldPrefix(K key, F filedPrefix) {
        List<V> objects = new ArrayList<>();
        Map<F, V> hashEntries = hashOperations.entries(key);
        for (Map.Entry<F, V> entry : hashEntries.entrySet()) {
            if (entry.getKey().toString().startsWith(filedPrefix.toString())) {
                objects.add(entry.getValue());
            }
        }
        return objects;
    }

    @Override
    public Set<F> getFieldPrefixes(K key) {
        return hashOperations.entries(key).keySet();
    }

    @Override
    public void delete(K key) {
        redisTemplate.delete(key);
    }

    @Override
    public void delete(K key, F field) {
        hashOperations.delete(key,field);
    }

    @Override
    public void delete(K key, List<F> fields) {
        for (F field:fields){
            hashOperations.delete(key,field);
        }
    }
}