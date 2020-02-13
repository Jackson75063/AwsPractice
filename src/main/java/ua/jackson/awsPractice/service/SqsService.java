package ua.jackson.awsPractice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.*;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SqsService {

    public static final String LOCAL_QUEUE_URL = "http://localhost:4576/queue/";
    @Autowired
    private SqsClient sqsClient;

    public void createQueue(String queueName){
        CreateQueueRequest createQueueRequest = CreateQueueRequest.builder().queueName(queueName).build();
        sqsClient.createQueue(createQueueRequest);
        System.out.println("QUEUE " + queueName + " creater");
    }

    public List<String> queuesNames(){
        ListQueuesResponse listQueuesResponse = sqsClient.listQueues();
        return listQueuesResponse.queueUrls();
    }

    public void deleteQueue(String queueName){
        DeleteQueueRequest deleteQueueRequest = DeleteQueueRequest.builder().queueUrl(LOCAL_QUEUE_URL +queueName).build();
        sqsClient.deleteQueue(deleteQueueRequest);
        System.out.println("Queue " + queueName + "is deleted");
    }

    public void addMsgToQueue(String queueName){
        String queueUrl = LOCAL_QUEUE_URL + queueName;
        SendMessageRequest send_msg_request = SendMessageRequest.builder()
                .queueUrl(queueUrl)
                .messageBody("hello world")
                .delaySeconds(5)
                .build();
        sqsClient.sendMessage(send_msg_request);
        System.out.println("Message : " + "msgBody" + " was added to queue: " +queueUrl);
    }

    public void deleteMsgFromQueue(String queueName){
        String queueUrl = LOCAL_QUEUE_URL + queueName;
//        DeleteMessageRequest builder = DeleteMessageRequest.builder().queueUrl(queueUrl).build();
//        sqsClient.deleteMessage(builder);

        ReceiveMessageRequest receiveMessageRequest = ReceiveMessageRequest.builder()
                .queueUrl(queueUrl)
                .maxNumberOfMessages(5)
                .build();
        List<Message> messages= sqsClient.receiveMessage(receiveMessageRequest).messages();

        for (Message message : messages) {
            DeleteMessageRequest deleteMessageRequest = DeleteMessageRequest.builder()
                    .queueUrl(queueUrl)
                    .receiptHandle(message.receiptHandle())
                    .build();
            sqsClient.deleteMessage(deleteMessageRequest);
        }
    }

    public List<String> last10MsgFromQueue(String queueName){
        String queueUrl = LOCAL_QUEUE_URL + queueName;
        ReceiveMessageRequest receiveMessageRequest = ReceiveMessageRequest.builder().queueUrl(queueUrl).maxNumberOfMessages(10).build();
        ReceiveMessageResponse receiveMessageResponse = sqsClient.receiveMessage(receiveMessageRequest);
        return receiveMessageResponse.messages().stream().map(Message::body).collect(Collectors.toList());
    }



}
