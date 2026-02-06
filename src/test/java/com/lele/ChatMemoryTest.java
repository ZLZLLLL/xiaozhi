package com.lele;

import com.lele.assistant.Assistant;
import com.lele.assistant.MemoryChatAssistant;
import com.lele.assistant.SeparateChatAssistant;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.spring.AiService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class ChatMemoryTest {

    @Autowired
    private Assistant assistant;

    @Autowired
    @Qualifier("openAiChatModel")
    private ChatLanguageModel chatLanguageModel;


    @Test
    public void testChatMemory() {
        String answer = assistant.chat("我是zl");
        System.out.println(answer);

        answer = assistant.chat("我是谁？");
        System.out.println(answer);
    }


    @Test
    public void testChatMemory2() {

        //第一轮对话
        UserMessage userMessage1 = UserMessage.userMessage("我是环环");
        ChatResponse chatResponse1 = chatLanguageModel.chat(userMessage1);
        AiMessage aiMessage1 = chatResponse1.aiMessage();
        //输出大语言模型的回复
        System.out.println(aiMessage1.text());

        //第二轮对话
        UserMessage userMessage2 = UserMessage.userMessage("你知道我是谁吗");
        ChatResponse chatResponse2 = chatLanguageModel.chat(Arrays.asList(userMessage1, aiMessage1, userMessage2));
        AiMessage aiMessage2 = chatResponse2.aiMessage();
        //输出大语言模型的回复
        System.out.println(aiMessage2.text());
    }


    @Autowired
    private MemoryChatAssistant memoryChatAssistant;
    @Test
    public void testChatMemory3() {

        String answer = memoryChatAssistant.chat("我是张木易");
        System.out.println(answer);
        answer = memoryChatAssistant.chat("你知道我是谁吗？");
        System.out.println(answer);
    }


    @Autowired
    private SeparateChatAssistant separateChatAssistant;
    @Test
    public void testChatMemory4() {
        String answer = separateChatAssistant.chat(1,"我是张木易");
        System.out.println(answer);
        answer = separateChatAssistant.chat(1,"我是谁？");
        System.out.println(answer);
        answer = separateChatAssistant.chat(2,"我是谁？");
        System.out.println(answer);
    }
}
