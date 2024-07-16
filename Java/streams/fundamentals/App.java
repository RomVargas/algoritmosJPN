package com.debuggeando_ideas.fundamentals;

public class App {

    public static void main(String[] args) {
        ProductDB pdb = new ProductDB();
        EmployeeDB edb = new EmployeeDB();

        System.out.println(pdb.getById(20L));
        System.out.println(edb.getById(30L));
    }

}
