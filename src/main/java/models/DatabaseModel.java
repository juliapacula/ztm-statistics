package models;

import org.bson.Document;

public abstract class DatabaseModel {
    public abstract Document writeToDatabase();
}
