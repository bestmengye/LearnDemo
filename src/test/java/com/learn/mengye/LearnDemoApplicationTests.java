package com.learn.mengye;

import com.alibaba.fastjson.serializer.ObjectArrayCodec;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
class LearnDemoApplicationTests {

	@Autowired
	private StringRedisTemplate redis;

	@Test
	void contextLoads() {
		redis.opsForValue().set("mengye","孟野");
	}

	@Test
	public void redisHandleList() {
		List<String> list=new ArrayList<>();
		list.add("mengye");
		list.add("gengxiang");
		list.add("xiaoheng");
		list.add("chengfeng");
		//redis左边写入一个List  返回所有集合数量
		Long count = redis.opsForList().leftPushAll("testList", list);
		//redis从list集合左边写入一个String  返回所有集合数量
		Long push = redis.opsForList().leftPush("testList", "111111111111111");
		System.out.println(push);

	}

	@Test
	public void redisHandleSet() {
		/*Set<String> set=new HashSet<>();
		set.add("mengye");
		set.add("gengxiang");
		set.add("xiaoheng");
		set.add("chengfeng");
		Boolean b1 = redis.opsForZSet().add("test", "mengye", 0);
		Boolean b2 = redis.opsForZSet().add("test", "gengxiang", 3);
		Boolean b3 = redis.opsForZSet().add("test", "hahha", 5);
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);*/
		//redis.opsForZSet().add("test", "chengfeng", 4);
		//倒序取出排名
		Long rank = redis.opsForZSet().reverseRank("test", "gengxiang");
		System.out.println(rank);
		//升序取出排名
		Long noRank = redis.opsForZSet().rank("test", "hahha");
		Double score = redis.opsForZSet().score("test", "gengx");
		System.out.println(score);
		System.out.println(noRank);
	}

	@Test
	public void redisHandleSetV1() {
//		Boolean member = redis.opsForSet().isMember("name", "mengye");
//		System.out.println(member);
		double s=9.0/8.0;
		System.out.println(s);


	}




}
