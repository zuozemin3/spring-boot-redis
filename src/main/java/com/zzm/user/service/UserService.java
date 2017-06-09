package com.zzm.user.service;

import com.zzm.user.vo.UserVo;

public interface UserService {

  UserVo findByUserId(Integer userId);

}
