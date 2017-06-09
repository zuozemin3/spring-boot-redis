package com.zzm.user.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class UserServiceTest {

  @Autowired
  private UserService userService;

  @Autowired
  private StringRedisTemplate stringRedisTemplate;

  @Test
  public void findByUserId() {
    stringRedisTemplate.opsForValue().set("name", "ZuoZeMin");
    Assert.assertEquals(stringRedisTemplate.opsForValue().get("name"), "ZuoZeMin");
  }

}
