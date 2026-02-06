package com.lele;

import com.lele.assistant.Assistant;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.service.AiServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AiServiceTest {

    @Autowired
    @Qualifier("openAiChatModel")
    private ChatLanguageModel chatLanguageModel;
    @Test
    public void testAiService(){
        Assistant assistant = AiServices.create(Assistant.class, chatLanguageModel);
        String answer = assistant.chat("你是谁?");
        System.out.println(answer);
    }


    @Autowired
    private Assistant assistant;
    @Test
    public void testAssistants(){
        String answer = assistant.chat("现在是什么时间");
        System.out.println(answer);
    }

}
