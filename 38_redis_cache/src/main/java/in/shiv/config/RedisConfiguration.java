package in.shiv.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import in.shiv.binding.Country;

@Configuration
public class RedisConfiguration {

	@Bean
	JedisConnectionFactory factory() {
		JedisConnectionFactory jedis = new JedisConnectionFactory();
//		jedis.setHostName(null);
//		jedis.setPassword(null);
//		jedis.setPort(0);
		return jedis;
	}

	@Bean
	RedisTemplate<String, Country> getTemplate() {
		RedisTemplate<String, Country> redisTemplate = new RedisTemplate<String, Country>();
		redisTemplate.setConnectionFactory(factory());
		return redisTemplate;
	}
}
