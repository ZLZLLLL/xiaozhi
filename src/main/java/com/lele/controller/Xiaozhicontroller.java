package com.lele.controller;

import com.lele.assistant.XiaozhiAgent;
import com.lele.bean.ChatForm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "硅谷小智")
@RestController
@RequestMapping("/xiaozhi")
public class Xiaozhicontroller {

    private final XiaozhiAgent xiaozhiAgent;

    public Xiaozhicontroller(XiaozhiAgent xiaozhiAgent) {
        this.xiaozhiAgent = xiaozhiAgent;
    }

    @Operation(summary = "与小智聊天")
    @PostMapping("/chat")
    public String chat(@RequestBody ChatForm chatForm) {
        return xiaozhiAgent.chat(chatForm.getMemoryId(), chatForm.getMessage());
    }
}
