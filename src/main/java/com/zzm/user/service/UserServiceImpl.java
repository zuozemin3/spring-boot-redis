package com.zzm.user.service;

import com.zzm.user.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private StringRedisTemplate stringRedisTemplate;

  @Override
  public UserVo findByUserId(Integer userId) {
    stringRedisTemplate.opsForValue().set("aaa", "111");
    return new UserVo();
  }
}
