package com.lele.tools;

import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import dev.langchain4j.agent.tool.ToolMemoryId;
import org.springframework.stereotype.Component;

@Component
public class CalculatorTools {

    @Tool
    double sum(double a, double b) {
        System.out.println("调用加法运算");
        return a + b;
    }

    @Tool(name = "平方根运算", value = "计算给定参数的平方根")
    double squareRoot(
            @P(value = "需要计算平方根的参数", required = true) double x,
            @ToolMemoryId int memoryId
    ) {
        System.out.println("调用平方根运算" + memoryId);
        return Math.sqrt(x);
    }

}
