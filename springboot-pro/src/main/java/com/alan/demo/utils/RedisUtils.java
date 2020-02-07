package com.alan.demo.utils;

import com.alibaba.fastjson.JSON;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtils {

    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 批量删除对应的value
     *
     * @param keys
     */
    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    /**
     * 批量删除key
     *
     * @param pattern
     */
    public void removePattern(final String pattern) {
        Set<Serializable> keys = redisTemplate.keys(pattern);
        if (keys.size() > 0) {
            redisTemplate.delete(keys);
        }

    }

    /**
     * 删除对应的value
     *
     * @param key
     */
    public void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }

    /**
     * 判断缓存中是否有对应的value
     *
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 读取缓存
     *
     * @param key
     * @return
     */
    public <T> T get(final String key, Class<T> clazz) {
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        Object obj = operations.get(key);
        if (key != null && obj != null) {
            if (clazz == int.class || clazz == Integer.class) {
                return (T) Integer.valueOf((String) obj);
            } else if (clazz == String.class) {
                return (T) obj;
            } else if (clazz == long.class || clazz == Long.class) {
                return (T) Long.valueOf((String) obj);
            } else {
                return JSON.parseObject((String) obj, clazz);
            }
        }
        return null;
    }

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     */
    public <T> boolean set(final String key, T value) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, beanToString(value));
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 写入缓存,带过期时间
     *
     * @param key
     * @param value
     * @return
     */
    public <T> boolean set(final String key, T value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, beanToString(value));
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public <T> String beanToString(T value) {
        if (value == null) {
            return null;
        }
        Class<?> clazz = value.getClass();
        if (clazz == int.class || clazz == Integer.class) {
            return "" + value;
        } else if (clazz == String.class) {
            return (String) value;
        } else if (clazz == long.class || clazz == Long.class) {
            return "" + value;
        } else {
            return JSON.toJSONString(value);
        }
    }

    /**
     * List集合写入缓存
     */
    public boolean setList(final String key, Object object) {
        boolean result = false;
        try {
            redisTemplate.opsForList().rightPush(key, object);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * List集合写入缓存,带过期时间
     */
    public boolean setList(final String key, Object object, Long expireTime) {
        boolean result = false;
        try {
            redisTemplate.opsForList().rightPush(key, object);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * List集合整个写入缓存
     */
    public boolean setListAll(final String key, List list) {
        boolean result = false;
        try {
            redisTemplate.opsForList().rightPushAll(key, list);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * List集合整个写入缓存,带过期时间
     */
    public boolean setListAll(final String key, List list, Long expireTime) {
        boolean result = false;
        try {
            redisTemplate.opsForList().rightPushAll(key, list);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 获取List集合
     */
    public List getList(final String key, long start, long end) {
        List result = null;
        result = redisTemplate.opsForList().range(key, start, end);
        return result;
    }

    /**
     * Set集合写入缓存
     */
    public boolean setSet(final String key, Set set) {
        boolean result = false;
        try {
            SetOperations<String, Object> setOperations = redisTemplate.opsForSet();
            for (Object o : set) {
                setOperations.add(key, o);
            }
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean setSet(final String key, Object object) {
        boolean result = false;
        try {
            SetOperations<String, Object> setOperations = redisTemplate.opsForSet();
            setOperations.add(key, object);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Set集合写入缓存,带过期时间
     */
    public boolean setSet(final String key, Object object, Long expireTime) {
        boolean result = false;
        try {
            SetOperations<String, Object> setOperations = redisTemplate.opsForSet();
            setOperations.add(key, object);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public boolean setSet(final String key, Set set, Long expireTime) {
        boolean result = false;
        try {
            SetOperations<String, Object> setOperations = redisTemplate.opsForSet();
            for (Object o : set) {
                setOperations.add(key, o);
            }
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 获取Set集合
     */
    public Set getSet(final String key) {
        Set result = null;
        result = redisTemplate.opsForSet().members(key);
        return result;
    }

    /**
     * Map集合写入缓存
     */
    public boolean setMap(final String key, Map map) {
        boolean result = false;
        try {
            redisTemplate.opsForHash().putAll(key, map);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Map集合写入缓存,带过期时间
     */
    public boolean setMap(final String key, Map map, Long expireTime) {
        boolean result = false;
        try {
            redisTemplate.opsForHash().putAll(key, map);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 取出Map集合
     */
    public Map getMap(final String key) {
        Map result = null;
        result = redisTemplate.opsForHash().entries(key);
        return result;
    }

    /**
     * 获取自增ID
     */
    public Long incr(String key) {
        RedisAtomicLong redisAtomicLong = new RedisAtomicLong(key, redisTemplate.getConnectionFactory());
        Long increment = redisAtomicLong.getAndIncrement();
//        if ((null == increment || increment.longValue() == 0) && liveTime > 0) {//初始设置过期时间
//            redisAtomicLong.expire(liveTime, TimeUnit.SECONDS);
//        }
        return increment;
    }
}