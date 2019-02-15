package ru.tsc.srb.leftjoin;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Некорректно введены параметры на вход");
            return;
        }

        CreatingQueries creatingQueries = new CreatingQueries();

        for (String fileTable: args) {
            try {
                creatingQueries.createTableFromFile(fileTable);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        creatingQueries.printTablesFromFile();

        creatingQueries.createRowsInnerJoinTableList();

        creatingQueries.createRowsLeftJoinTableList();

        creatingQueries.printRowsLeftJoinTableList();
    }
}
