# Java AI LangChain4j 项目--小智医疗

这是一个基于Spring Boot和LangChain4j的AI聊天应用项目，集成了多种AI服务，包括OpenAI兼容接口（如MiniMax）和阿里云通义千问。

## 技术栈

- **Java 21**: 使用较新的Java版本
- **Spring Boot 3.2.6**: 应用框架
- **LangChain4j 1.0.0-beta3**: AI集成框架
- **MongoDB**: 用于持久化聊天记忆
- **Knife4j**: API文档工具

## 项目结构

```
src/
├── main/
│   ├── java/com/lele/
│   │   ├── assistant/          # AI助手接口定义
│   │   │   ├── Assistant.java
│   │   │   ├── MemoryChatAssistant.java
│   │   │   └── SeparateChatAssistant.java
│   │   ├── bean/               # 实体类
│   │   │   └── ChatMessages.java
│   │   ├── config/             # 配置类
│   │   │   ├── MemoryChatAssistantConfig.java
│   │   │   └── SeparateChatAssistantConfig.java
│   │   ├── story/              # 存储层实现
│   │   │   └── MongoChatMemoryStore.java
│   │   └── JavaAiLangchin4jApplication.java
│   └── resources/
│       └── application.yaml
└── test/java/com/lele/
    ├── AiServiceTest.java      # AI服务测试
    ├── ChatMemoryTest.java     # 记忆功能测试
    ├── JavaAiLangchin4jApplicationTests.java
    ├── MangoCrudTest.java      # MongoDB操作测试
    └── llmTest.java           # LLM模型测试
```

## 主要组件

### 1. AI助手接口

- **Assistant**: 基础聊天助手接口，无记忆功能
- **MemoryChatAssistant**: 带有短期记忆的聊天助手
- **SeparateChatAssistant**: 支持多个独立会话的记忆助手，每个会话有独立ID

### 2. 配置类

- **MemoryChatAssistantConfig**: 配置短期记忆聊天助手，使用窗口记忆策略(最多保留10条消息)
- **SeparateChatAssistantConfig**: 配置多会话助手，使用MongoDB作为记忆存储

### 3. 数据存储

- **MongoChatMemoryStore**: 实现LangChain4j的ChatMemoryStore接口，使用MongoDB持久化聊天历史
- **ChatMessages**: MongoDB文档实体，存储聊天消息的JSON序列化数据

## 功能特性

### 多AI模型支持

项目同时接入了多种AI模型服务：
- MiniMax (通过OpenAI兼容接口)
- 阿里云通义千问 (Qwen)

### 记忆管理

提供三种不同的记忆管理模式：

1. **无记忆模式**:
   - 每次对话都是独立的
   - 不保留历史上下文

2. **短期记忆模式**:
   - 使用窗口记忆策略
   - 最多保留最近10条消息

3. **多会话记忆模式**:
   - 支持多个独立会话
   - 每个会话有独立ID
   - 使用MongoDB持久化存储

### 持久化存储

使用MongoDB存储聊天历史，支持跨会话记忆：
- 自动序列化/反序列化聊天消息
- 按会话ID进行数据隔离
- 支持消息的增删改查操作

## 配置说明

### application.yaml

```yaml
server:
  port: 8099

langchain4j:
  open-ai:
    chat-model:
      base-url: https://api.minimaxi.com/v1
      api-key: ${MINIMAX_M2.1_LANGCHAIN}
      model-name: MiniMax-M2.1
      log-requests: true
      log-responses: true
      temperature: 0.8
      timeout: PT60S
  community:
    dashscope:
      chat-model:
        api-key: ${ALI_BAILIAN}
        model-name: qwen-plus

logging:
  level:
    root: debug

spring:
  data:
    mongodb:
      uri: mongodb://admin:123456@localhost:27017/chat_memory_db?authSource=admin
```

## 运行环境

- 服务端口: 8099
- MongoDB连接: localhost:27017，认证信息为admin/123456
- 需要设置环境变量: MINIMAX_M2.1_LANGCHAIN 和 ALI_BAILIAN

### Docker配置

项目提供了docker-compose.yml文件用于快速启动MongoDB:

```yaml
version: "3.8"

services:
  mongodb:
    image: mongo:latest
    container_name: mongo
    restart: always

    ports:
      - "27017:27017"

    environment:
      MONGO_INITDB_ROOT_USERNAME: admin
      MONGO_INITDB_ROOT_PASSWORD: 123456

    volumes:
      - ./data:/data/db
```

## 测试说明

项目包含多种测试用例：

- **llmTest**: 测试不同AI模型(OpenAI、MiniMax、阿里云通义千问)
- **AiServiceTest**: 测试AI助手服务
- **ChatMemoryTest**: 测试各种记忆功能(无记忆、短期记忆、多会话记忆)
- **MangoCrudTest**: 测试MongoDB基本操作

## 项目特点

1. **多AI模型支持**: 同时接入MiniMax和阿里云通义千问
2. **多种记忆策略**: 提供无记忆、短期记忆、多会话记忆三种模式
3. **持久化存储**: 使用MongoDB存储聊天历史，支持跨会话记忆
4. **容器化部署**: 提供docker-compose.yml用于MongoDB容器化部署
5. **灵活扩展**: 基于LangChain4j框架，易于接入更多AI服务

## 快速开始

1. 克隆项目并进入项目目录
2. 设置环境变量 `MINIMAX_M2.1_LANGCHAIN` 和 `ALI_BAILIAN`
3. 启动MongoDB (可使用docker-compose.yml)
4. 运行 `mvn spring-boot:run` 启动应用
5. 访问 http://localhost:8099

彩蛋：新年快乐
