package com.yinghu.yinghu.config;

/**
 * @Classname RedisConfig
 * @Description TODO
 * @Date 2022/10/13 15:26
 * @Created by whz
 */


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

/**
     * Redis的核心配置类，这个类提供了两个方法（其实提供了两个bean，这两个bean会加载到spring的context里边，供使用者进行调用)
     */
    //@Configuration//这个标签，通常与@bean结合使用，当@bean使用到该类的方法上，代表将该方法做为一个bean交给了spring的context
    @EnableCaching//允许我们使用缓存
    public class RedisConfig {

        @Bean//此时，将我们的redisTemplate加载到了我们的spring的上下文中，applicationContext
        public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
            //为了自己开发方便,使用String，Object类型
            RedisTemplate<String, Object> template = new RedisTemplate();
            template.setConnectionFactory(factory);
            //序列化配置，使用json解析任意的对象，将对象解析成可以序列化的对象
            Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
            //使用Mapper对象进行转义
            ObjectMapper om = new ObjectMapper();
            om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
            om.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.WRAPPER_ARRAY);
            //开始序列化对象
            jackson2JsonRedisSerializer.setObjectMapper(om);

            // String 类型的序列化
            StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
            //key采用String序列化的方式
            template.setKeySerializer(stringRedisSerializer);
            //hash采用String序列化的方式
            template.setHashKeySerializer(stringRedisSerializer);
            //value序列化方式采用jackson
            template.setValueSerializer(jackson2JsonRedisSerializer);
            //hash的value序列化方式采用jackson
            template.setHashKeySerializer(jackson2JsonRedisSerializer);
            template.afterPropertiesSet();
            return template;
        }

        @Bean
        public CacheManager cacheManager(RedisConnectionFactory factory) {
            //1.序列话（一般用于key值）
            RedisSerializer<String> redisSerializer = new StringRedisSerializer();
            //2.引入json串的转化类（一般用于value的处理）
            Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
            ObjectMapper objectMapper = new ObjectMapper();
            //2.1设置objectMapper的访问权限
            objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
            //2.2指定序列化输入类型,就是将数据库里的数据按照一定类型存储到redis缓存中。
            // objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);//最近升级SpringBoot，发现enableDefaultTyping方法过期过期了。可以使用下面的方法代替
            objectMapper.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.WRAPPER_ARRAY);
            jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
            //3.序列话配置，乱码问题解决以及我们缓存的时效性
            RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig().
                    entryTtl(Duration.ofSeconds(1000)).//缓存时效性设置
                    serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(redisSerializer)).//key序列化
                    serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer)).//value序列化
                    disableCachingNullValues();//空值不存入缓存
            //4.创建cacheManager链接并设置属性
            RedisCacheManager cacheManager = RedisCacheManager.builder(factory).cacheDefaults(config).build();
            return cacheManager;
        }
    }



