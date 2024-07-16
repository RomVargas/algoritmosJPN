package com.debuggeando_ideas.fundamentals.interfaces;

public class App {
    public static void main(String[] args) {
        DatabaseService mongo = new MongoDb();
        DatabaseService postgres = new PostgresDB();

        System.out.println(mongo.getById(20L));
        System.out.println(postgres.getById(30L));
    }
}
