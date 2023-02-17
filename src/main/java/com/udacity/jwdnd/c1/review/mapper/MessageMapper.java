package com.udacity.jwdnd.c1.review.mapper;

import com.udacity.jwdnd.c1.review.model.ChatMessage;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MessageMapper {
    @Select("SELECT * FROM MESSAGES WHERE messageid = #{messageid}")
    ChatMessage getChatMessage(Integer messageid);

    @Select("SELECT * FROM MESSAGES")
    List<ChatMessage> getMessages();

    @Insert("INSERT INTO MESSAGES (username, messagetext, messageid)"
            + "VALUES(#{username}, #{messageText}, #{messageid})")
    @Options(useGeneratedKeys = true, keyProperty = "messageid")
    int insert(ChatMessage message);

    @Delete("DELETE * FROM MESSSAGES WHERE messageid = #{messageid}")
    void delete(Integer messageid);

}
