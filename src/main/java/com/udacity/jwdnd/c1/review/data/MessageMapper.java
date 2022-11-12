package com.udacity.jwdnd.c1.review.data;

import com.udacity.jwdnd.c1.review.models.ChatMessage;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface MessageMapper {
    @Select("select * from messages where username = #{username}")
    ChatMessage getMessage(String username);

    @Select("select * from messages")
    ArrayList<ChatMessage> getAllMessage();

    @Insert("insert into messages (username, messagetext) values(#{username}, #{messagetext})")
    @Options(useGeneratedKeys = true, keyProperty = "messageid")
    Integer insert(ChatMessage chatMessage);

    @Delete("delete from messages where messageid = #{id}")
    void delete(Integer id);
}
