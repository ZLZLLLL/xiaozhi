package com.lele;

import com.lele.bean.ChatMessages;
import com.mongodb.client.result.DeleteResult;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

@SpringBootTest
public class MangoCrudTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void testInsert() {
        //mongoTemplate.insert(new ChatMessages(1L, "聊天记录详情"));
    }

    @Test
    public void testInsert2() {
        ChatMessages chatMessages = new ChatMessages();
        chatMessages.setContent("聊天记录详情2");
        chatMessages.setMessageId(new ObjectId());
        mongoTemplate.insert(chatMessages);
    }

    @Test
    public void testFind() {
        ChatMessages chatMessages = mongoTemplate.findById("698d457fe085a4294d92e408", ChatMessages.class);
        System.out.println(chatMessages);
    }

    @Test
    public void testUpdate() {
        Criteria criteria = Criteria.where("_id").is("618d457fe085a4294d92e408");
        Query query = new Query(criteria);
        Update update = new Update();
        update.set("content", "修改后的聊天记录");
        //若没有则新增
        mongoTemplate.upsert(query, update, ChatMessages.class);
    }


    @Test
    public void testDelete() {
        Criteria criteria = Criteria.where("_id").is("698d457fe085a4294d92e408");
        Query query = new Query(criteria);
        DeleteResult remove = mongoTemplate.remove(query, ChatMessages.class);
        System.out.println(remove.getDeletedCount());
    }
}
