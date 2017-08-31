package com.dongnao.jack.redis;

import java.lang.reflect.Method;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

/** 
 * @Description redis的缓存配置类，主要配置1、key的生成策略 2、缓存管理规则 
 * @ClassName   RedisConfig 
 * @Date        2017年8月30日 下午2:06:27 
 * @Author      动脑学院-jack
 */

@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {
    /* 
     * 这个是redis中key的生成规则，可以根据自己的业务来定
     */
    @Bean
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            public Object generate(Object target, Method method,
                    Object... params) {
                String key = target.getClass().getName() + "$"
                        + method.getName() + "$" + params;
                return key;
            }
        };
    }
    
    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        RedisCacheManager rcm = new RedisCacheManager(redisTemplate);
        //设置缓存过期时间
        //rcm.setDefaultExpiration(60);//秒
        return rcm;
    }
    
    //    @Bean
    //    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
    //        StringRedisTemplate template = new StringRedisTemplate(factory);
    //        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
    //        ObjectMapper om = new ObjectMapper();
    //        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
    //        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
    //        jackson2JsonRedisSerializer.setObjectMapper(om);
    //        template.setValueSerializer(jackson2JsonRedisSerializer);
    //        template.afterPropertiesSet();
    //        return template;
    //    }
}
