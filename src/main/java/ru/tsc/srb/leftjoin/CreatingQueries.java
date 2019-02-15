package ru.tsc.srb.leftjoin;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CreatingQueries {

    private List<Table> tablesFromFileList;
    private List<Row> rowLeftJoinTablesList;

    public CreatingQueries() {
        this.tablesFromFileList = new ArrayList<>();
        this.rowLeftJoinTablesList = new ArrayList<>();
    }

    public void createTableFromFile(String fileTable) throws IOException {
        File file = new File(fileTable);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        int z = 1;
        String nameTable = "";
        Table tableFromFile = null;
        List<Row> rowsList = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null) {
            if (z == 1) {
                nameTable = line;
            } else {
                String[] arr = line.split("\t");
                if (z == 2) {
                    String nameId = arr[0];
                    List<String> namesValuesList = new ArrayList<>();
                    for (int i = 1; i < arr.length; i++) {
                        namesValuesList.add(arr[i]);
                    }
                    tableFromFile = new Table(nameTable, nameId, namesValuesList);
                } else {
                    int id = Integer.parseInt(arr[0]);
                    List<String> valuesList = new ArrayList<>();
                    for (int i = 1; i < arr.length; i++) {
                        valuesList.add(arr[i]);
                    }
                    Row row = new Row(id, valuesList);
                    rowsList.add(row);
                }
            }
            z++;
        }
        tableFromFile.setRowsList(rowsList);
        tablesFromFileList.add(tableFromFile);
    }

    public void printTablesFromFile() {
        for (Table tableFromFile: tablesFromFileList) {
            System.out.println(tableFromFile.getNameTable());
            System.out.print(tableFromFile.getNameId() + " ");
            List<String> namesValuesList = tableFromFile.getNamesValuesList();
            for (String nameValue: namesValuesList) {
                System.out.print(nameValue + " ");
            }
            System.out.println();
            List<Row> rowsList = tableFromFile.getRowsList();
            for (Row row: rowsList) {
                System.out.print(row.getId() + " ");
                List<String> valuesList = row.getValuesList();
                for (String value: valuesList) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public void createRowsInnerJoinTableList() {
        for (Row row1: tablesFromFileList.get(0).getRowsList()) {
            for (Row row2: tablesFromFileList.get(1).getRowsList()) {
                if (row1.getId() == row2.getId()) {
                    Row row = new Row(row1.getId(), row1.getValuesList());
                    row.getValuesList().addAll(row2.getValuesList());
                }
            }
        }
    }

    public void createRowsLeftJoinTableList() {
        for (Row row1: tablesFromFileList.get(0).getRowsList()) {
            if (rowLeftJoinTablesList.indexOf(row1) == -1) {
                Row row2 = new Row(row1.getId(), row1.getValuesList());
                rowLeftJoinTablesList.add(row2);
            }
        }
    }

    public void printRowsLeftJoinTableList() {
        for (Row row : rowLeftJoinTablesList) {
            System.out.print(row.getId() + " ");
            List<String> valuesList = row.getValuesList();
            for (String value : valuesList) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
