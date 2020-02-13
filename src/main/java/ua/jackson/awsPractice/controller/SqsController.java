package ua.jackson.awsPractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ua.jackson.awsPractice.service.SqsService;

import java.util.List;

@RestController
public class SqsController {

    public static final String LOCAL_QUEUE_URL = "http://localhost:4576/queue/";

    @Autowired
    private SqsService sqsService;

    @GetMapping("/create/{queueName}")
    public void createQueue(@PathVariable String queueName) {

        sqsService.createQueue(queueName);
    }

    @GetMapping("/all")
    public List<String> getQueues() {
        return sqsService.queuesNames();
    }

    @GetMapping("/del/{queueName}")
    public String deleteQueue(@PathVariable String queueName) {
        sqsService.deleteQueue(queueName);

        return queueName + " has been deleted";
    }

    @GetMapping("/addM/q/{queueUrl}")
    public void addMsgToQueue(@PathVariable String queueUrl) {

//        String sqsQueueUrl = LOCAL_QUEUE_URL + queueUrl;
        sqsService.addMsgToQueue(queueUrl);
        System.out.println("Message aws added");
    }


    @GetMapping("/delM/{queueName}")
    public void deleteMsgFromQueue(@PathVariable String queueName) {
        sqsService.deleteMsgFromQueue(queueName);
    }

    @GetMapping("/g10/{queueName}")
    public List<String> last10MsgFromQueue(@PathVariable String queueName) {
        return sqsService.last10MsgFromQueue(queueName);
    }

}