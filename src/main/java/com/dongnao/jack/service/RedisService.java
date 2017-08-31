package com.dongnao.jack.service;

public interface RedisService {
    
    Object findByKey(String key);
    
    Object cacheObject(String result);
}
