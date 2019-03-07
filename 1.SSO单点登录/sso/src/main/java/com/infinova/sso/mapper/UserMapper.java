package com.infinova.sso.mapper;

import com.infinova.sso.entity.User;
import org.apache.ibatis.annotations.Select;

/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author fanxb
 * @date 2019/3/5 9:34
 */
public interface UserMapper {

    /**
     * Description:通过loginID获取用户信息
     *
     * @author fanxb
     * @date 2019/3/5 9:55
     * @param id
     * @return com.infinova.sso.entity.User
     */
    @Select("select RecID recId,LoginID loginId,Pwd password from siteviewusers where LoginID=#{id}")
    User selectByLoginId(String id);
}
