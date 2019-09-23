package models;

import org.bson.Document;

public class Agency extends DatabaseModel {
    public int id;
    public String name;

    @Override
    public Document writeToDatabase() {
        return new Document("_id", id)
                .append("name", name);
    }
}
