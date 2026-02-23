package com.lele;

import com.lele.assistant.MemoryChatAssistant;
import com.lele.assistant.SeparateChatAssistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PromptTest {

    @Autowired
    private SeparateChatAssistant separateChatAssistant;

    @Test
    public void testSystemPrompt(){
        String answer = separateChatAssistant.chat(5, "今天几号");
        System.out.println(answer);
    }


    @Autowired
    private MemoryChatAssistant memoryChatAssistant;

    @Test
    public void testUserMessage() {
        String answer1 = memoryChatAssistant.chat("我是环环");
        System.out.println(answer1);

        String answer2 = memoryChatAssistant.chat("我是环环");
        System.out.println(answer2);

        String answer3 = memoryChatAssistant.chat("我是环环");
        System.out.println(answer3);
    }


    @Test
    public void testV() {
        String answer1 = separateChatAssistant.chat2(6, "我是环环");
        System.out.println(answer1);
        String answer2 = separateChatAssistant.chat2(6, "我是谁");
        System.out.println(answer2);
    }

    @Test
    public void testUserInfo() {
        int age =21;
        String username = "lele";

        String answer = separateChatAssistant.chat3(18, "你知道我的名字和年龄吗？", username, age);
        System.out.println(answer);
    }
}
