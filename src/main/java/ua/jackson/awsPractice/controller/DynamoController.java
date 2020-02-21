package ua.jackson.awsPractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class DynamoController {

    @Autowired
    DynamoDbClient dynamoDbClient;

    @GetMapping("/createDBD")
    public String createDynamoDBTable(){

        String tableName = "table2";
        String key = "key1";

        System.out.format("Creating table \"%s\" with a simple primary key: \"Name\".\n", tableName);

        CreateTableRequest request = CreateTableRequest.builder()
                .attributeDefinitions(AttributeDefinition.builder()
                        .attributeName(key)
                        .attributeType(ScalarAttributeType.S)
                        .build())
                .keySchema(KeySchemaElement.builder()
                        .attributeName(key)
                        .keyType(KeyType.HASH)
                        .build(),
                        KeySchemaElement.builder()
                        .attributeName("asdwq")
                        .keyType(KeyType.HASH)
                        .build())
                .provisionedThroughput(ProvisionedThroughput.builder()
                        .readCapacityUnits( new Long(10))
                        .writeCapacityUnits(new Long(10))
                        .build())
                .tableName(tableName)
                .build();
        try {
            CreateTableResponse response = dynamoDbClient.createTable(request);
            System.out.println(response.tableDescription().tableName());
        } catch (DynamoDbException e) {
            System.err.println(e.getMessage());
//            System.exit(1);
        }
        return "CREATED";
    }


    @GetMapping("/printList")
    public void printDBList(){

        boolean moreTables = true;
        String lastName = null;

        while(moreTables) {
            try {
                ListTablesResponse response = null;
                if (lastName == null) {
                    ListTablesRequest request = ListTablesRequest.builder().build();
                    response = dynamoDbClient.listTables(request);
                } else {
                    ListTablesRequest request = ListTablesRequest.builder()
                            .exclusiveStartTableName(lastName).build();
                    response = dynamoDbClient.listTables(request);
                }

                List<String> tableNames = response.tableNames();

                if (tableNames.size() > 0) {
                    for (String curName : tableNames) {
                        System.out.format("* %s\n", curName);
                    }
                } else {
                    System.out.println("No tables found!");
                    System.exit(0);
                }

                lastName = response.lastEvaluatedTableName();
                if (lastName == null) {
                    moreTables = false;
                }
            } catch (DynamoDbException e) {
                System.err.println(e.getMessage());
//                System.exit(1);
            }
        }

    }


    @GetMapping("/deleteTable")
    public String deleteTable(){

        DeleteTableRequest deleteTableRequest = DeleteTableRequest.builder().tableName("table2").build();


        DeleteTableResponse deleteTableResponse = dynamoDbClient.deleteTable(deleteTableRequest);
        System.out.println(deleteTableResponse.tableDescription());
        return "deleted";
    }


    @GetMapping("/addSmth")
    public String addSmth(){


        HashMap<String,AttributeValue> itemValues = new HashMap<>();

// Add content to the table
//        itemValues.put("key1", AttributeValue.builder().s("key1").build());
        itemValues.put("Artist", AttributeValue.builder().s(String.valueOf(1L)).build());
        itemValues.put("songTitle", AttributeValue.builder().s("John Cena").build());
        itemValues.put("albumTitle", AttributeValue.builder().s("albumTitleValue").build());
        itemValues.put("awards", AttributeValue.builder().s("awardVal").build());

// Create a PutItemRequest object
        PutItemRequest request = PutItemRequest.builder()
                .tableName("Music")
                .item(itemValues)
                .build();

        try {
            dynamoDbClient.putItem(request);
            System.out.println("Music" +" was successfully updated");

        } catch (ResourceNotFoundException e) {
            System.err.format("Error: The table \"%s\" can't be found.\n", "Music");
            System.err.println("Be sure that it exists and that you've typed its name correctly!");
            System.exit(1);
        } catch (DynamoDbException e) {
            System.err.println(e.getMessage());
//            System.exit(1);
        }

        return "Value was added";
    }

}
