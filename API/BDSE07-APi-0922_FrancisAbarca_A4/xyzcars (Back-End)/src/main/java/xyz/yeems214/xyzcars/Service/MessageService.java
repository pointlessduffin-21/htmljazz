package xyz.yeems214.xyzcars.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;
import xyz.yeems214.xyzcars.Entity.Message;

import java.util.HashMap;
import java.util.Map;

@Service
public class MessageService {
    private static final String HOOKS_URL = "https://hooks.slack.com/services/%s";


    public void sendMessage(String userName, Message message) throws
            JsonProcessingException{
        Map<String,String> myMap=new HashMap<String, String>();

        myMap.put("xyzcars","T0594P85XGV/B059QKXCU13/d2pUrNS0xULtYB6UMxJ1m4Oa");

        String userChannelId = myMap.get(userName);
        System.out.println("username: "+userChannelId);
        System.out.println(HOOKS_URL);
        String userWebhookUrl = String.format(HOOKS_URL,userChannelId);
        RestTemplate restTemplate = new RestTemplate();
        org.springframework.http.HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ObjectMapper objectMapper = new ObjectMapper();
        String messageJson = objectMapper.writeValueAsString(message);
        HttpEntity<String> entity = new HttpEntity<>(messageJson,headers);
        System.out.println(userWebhookUrl);

        restTemplate.exchange("https://hooks.slack.com/services/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", HttpMethod.POST, entity, String.class);
    }
}