package com.lele;

import com.lele.assistant.SeparateChatAssistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ToolsTest {

    @Autowired
    private SeparateChatAssistant separateChatAssistant;

    @Test
    public void testCalculatorTools(){
        String answer = separateChatAssistant.chat(9, "计算36278132197的平方根");
        System.out.println(answer);
    }
}
