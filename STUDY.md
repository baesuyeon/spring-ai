# Spring AI란?

**Spring AI**는 **AI 애플리케이션을 만들기 위한 스프링 기반 프레임워크**이다.  
Spring 생태계의 설계 원칙을 **AI 분야에 그대로 적용**할 수 있도록 해준다.
AI 모델이나 벡터 저장소를 변경하더라도 최소한의 코드 변경으로 대응할 수 있다.

---

## 🤖 지원하는 AI 모델 벤더사

Spring AI는 다양한 AI 모델 벤더사의 AI 모델을 일관된 API로 사용할 수 있도록 한다.

- **OpenAI** - GPT 모델
- **Anthropic** - Claude 모델
- **Microsoft Azure OpenAI**
- **Amazon Bedrock**
- **Google Vertex AI**
- **Ollama**

---

## Spring AI의 추상화 방식과 구조
### Prompt
Prompt 클래스는 LLM 모델에 보낼 명령어 요청 객체이다. (입력 요청을 캡슐화한 객체)
'어떤 메시지를 보낼지', '어떤 파라미터 옵션으로 보낼지'(ChatOptions)를 담고있다. 

```java
public class Prompt implements ModelRequest<List<Message>> {

    private final List<Message> messages;

    private ChatOptions chatOptions;
}
```

```java
String response = chatClient.prompt("Tell me a joke").call().content();
```

### ChatModel
ChatModel은 다양한 LLM 모델을 일관된 방식으로 호출할 수 있도록 하는 인터페이스이다.

```java
public interface ChatModel extends Model<Prompt, ChatResponse> {

	default String call(String message) {...}

    @Override
	ChatResponse call(Prompt prompt);
}
```
ChatModel 인터페이스를 구현한 클래스의 결과는 `ChatResponse`라는 공통된 응답 객체로 리턴한다.

