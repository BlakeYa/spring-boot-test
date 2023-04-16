package org.example;

import com.mongodb.client.*;
import org.bson.Document;

public class MongoDBExample {
    public static void main(String[] args) {
        // 连接到 MongoDB 服务器
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

        // 选择数据库和集合--如果数据库不存在则创建
        MongoDatabase database = mongoClient.getDatabase("test001");
        MongoCollection<Document> collection = database.getCollection("myCollection");

        // 插入一条文档
        Document document = new Document("name", "John Doe")
                .append("age", 30)
                .append("address", new Document("street", "123 Main St")
                        .append("city", "Anytown")
                        .append("state", "CA")
                        .append("zip", "12345"));
        collection.insertOne(document);

        // 查询文档
        Document query = new Document("name", "John Doe");
        FindIterable<Document> results = collection.find(query);
        for (Document doc : results) {
            System.out.println(doc.toJson());
        }

        // 关闭连接
        mongoClient.close();
    }
}
