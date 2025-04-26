package com.mycom.myapp.auth.dao;

import com.mycom.myapp.user.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;


// 사용자가 입력한 userEmail, userPassword 중 userEmail로 select 해서 있으면 나머지 데이터를 포함해서 UserDto 객체를 없으면 null을 Return
@Mapper
public interface LoginDao {
    UserDto login(String userEmail);
}
