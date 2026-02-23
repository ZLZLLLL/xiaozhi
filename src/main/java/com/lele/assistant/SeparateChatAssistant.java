package com.lele.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

@AiService(
        wiringMode = EXPLICIT,
        chatModel = "openAiChatModel",
        chatMemoryProvider = "chatMemoryProvider"
)
public interface SeparateChatAssistant {

    //@SystemMessage("你是我的好朋友，请用东北话回答问题")
    @SystemMessage(fromResource = "my-prompt-template.txt")
    String chat(@MemoryId int memoryId, @UserMessage String userMessage);


    @UserMessage("你是我的好朋友，请用四川话回答问题，并且添加一些表情符号。 {{mes}}")
        //{{it}}表示这里唯一的参数的占位符
    String chat2(@MemoryId int memoryId, @V("mes") String userMessage);

    @SystemMessage(fromResource = "my-prompt-template3.txt")
    String chat3(@MemoryId int memoryId,
                 @UserMessage String userMessage,
                 @V("username") String username,
                 @V("age") int age
    );
}
