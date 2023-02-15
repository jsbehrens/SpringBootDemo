package com.udacity.jwdnd.c1.review.mapper;

import com.udacity.jwdnd.c1.review.model.ChatMessage;
import org.apache.ibatis.annotations.*;

@Mapper
public interface MessageMapper {
    @Select("SELECT * FROM MESSAGES WHERE messageid = #{messageid}")
    ChatMessage getChatMessage(Integer messageid);

    @Insert("INSERT INTO MESSAGES (username, text, messageid)"
            + "VALUES(#{username}, #{text}, #{messageid})")
    @Options(useGeneratedKeys = true, keyProperty = "messageid")
    int insert(ChatMessage message);

    @Delete("DELETE * FROM MESSSAGES WHERE messageid = #{messageid}")
    void delete(Integer messageid);

}
