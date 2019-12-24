package com.learn.mengye;

import com.alibaba.fastjson.serializer.ObjectArrayCodec;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.ArrayList;
import java.util.List;

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




}
