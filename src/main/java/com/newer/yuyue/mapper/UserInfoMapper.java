package com.newer.yuyue.mapper;

import com.newer.yuyue.domain.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoMapper {

    UserInfo findByUsername(@Param("aname") String aname);
}
