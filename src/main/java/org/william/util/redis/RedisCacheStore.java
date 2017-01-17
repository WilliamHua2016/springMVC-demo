package org.william.util.redis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * Redis操作客户端接口
 */
@Repository
public class RedisCacheStore {

	@Autowired
	protected RedisTemplate redisTemplate;

	/**
	 * 保存数据到redis
	 * 
	 * @param key
	 * @param value
	 */
	public void save(final String key, final Object value) {
		redisTemplate.execute(new RedisCallback<Object>() {
			public Object doInRedis(RedisConnection connection)
					throws DataAccessException {
				connection.set(
						redisTemplate.getStringSerializer().serialize(key),
						redisTemplate.getStringSerializer().serialize(value));
				return null;
			}
		});
	}

	/**
	 * 保存数据到redis
	 * 
	 * @param key
	 * @param value
	 */
	public void set(Object key, Object value) {
		redisTemplate.opsForValue().set(key, value);
	}

	/**
	 * 保存数据到redis
	 * 
	 * @param key
	 * @param value
	 */
	public void set(Object key, List value) {
		redisTemplate.opsForList().rightPush(key, value);
	}

	/**
	 * 保存数据到redis
	 * 
	 * @param key
	 * @param value
	 */
	@SuppressWarnings("unchecked")
	public void set(Object key, Map value) {
		redisTemplate.opsForHash().putAll(key, value);
	}

	/**
	 * 保存数据到redis
	 * 
	 * @param key
	 * @param value
	 */
	public void set(Object key, Object hashKey, Object value) {
		redisTemplate.opsForHash().put(key, hashKey, value);
	}

	/**
	 * 获取redis数据
	 * 
	 * @param key
	 * @param value
	 */
	public Object get(Object key, Object hashKey) {
		return redisTemplate.opsForHash().get(key, hashKey);
	}

	/**
	 * 保存数据到redis
	 * 
	 * @param key
	 * @param value
	 * @param time
	 *            超时时间（秒）
	 */
	public void save(final String key, final Object value, final long time) {
		redisTemplate.execute(new RedisCallback<Object>() {
			public Object doInRedis(RedisConnection connection)
					throws DataAccessException {
				connection.setEx(
						redisTemplate.getStringSerializer().serialize(key),
						time,
						redisTemplate.getStringSerializer().serialize(value));
				return null;
			}
		});
	}

	/**
	 * 获取redis的数据
	 * 
	 * @param key
	 * @return
	 */
	public Object get(final Object key) {
		return redisTemplate.execute(new RedisCallback<Object>() {
			@Override
			public Object doInRedis(RedisConnection connection)
					throws DataAccessException {
				byte[] keyTemp = redisTemplate.getStringSerializer().serialize(
						key);
				if (connection.exists(keyTemp)) {
					byte[] value = connection.get(keyTemp);
					Object name = redisTemplate.getStringSerializer()
							.deserialize(value);
					return name;
				}
				return null;
			}
		});
	}

	/**
	 * 批量删除redis的数据
	 * 
	 * @param keys
	 */
	public void delete(List<String> keys) {
		redisTemplate.delete(keys);
	}

	/**
	 * 删除redis的数据
	 * 
	 * @param key
	 */
	public void delete(Object key) {
		redisTemplate.delete(key);
	}

	protected RedisSerializer<String> getRedisSerializer() {
		return redisTemplate.getStringSerializer();
	}

}
