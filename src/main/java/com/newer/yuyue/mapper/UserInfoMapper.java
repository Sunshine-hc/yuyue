package com.newer.yuyue.mapper;

import com.newer.yuyue.domain.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoMapper {

    /**
     * 登录
     * @param phone
     * @param pwd
     * @return
     */
    @Select("select * from userinfo where phone=#{phone} and pwd=#{pwd}")
    UserInfo findByParam(@Param("phone") String phone,@Param("pwd") String pwd);

    /**
     * 修改密码
     * @param pwd
     * @param userid
     * @return
     */
    @Update("update userinfo set pwd=#{pwd},LASTPASSWORDRESETDATE=now() where userid=#{userid}")
    int changepwd(@Param("pwd") String pwd,@Param("userid") int userid);

    //查询新添加的用户id
    @Select("select @@identity")
    int findAid();

    UserInfo findByUsername(@Param("phone") String phone);
}
