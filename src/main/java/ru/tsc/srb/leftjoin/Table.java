package ru.tsc.srb.leftjoin;

import java.util.List;

public class Table {

    private String nameTable;
    private String nameId;
    private List<String> namesValuesList;
    private List<Row> rowsList;

    public Table(String nameTable, String nameId, List<String> namesValuesList) {
        this.nameTable = nameTable;
        this.nameId = nameId;
        this.namesValuesList = namesValuesList;
    }

    public String getNameTable() {
        return nameTable;
    }

    public void setNameTable(String nameTable) {
        this.nameTable = nameTable;
    }

    public String getNameId() {
        return nameId;
    }

    public void setNameId(String nameId) {
        this.nameId = nameId;
    }

    public List<String> getNamesValuesList() {
        return namesValuesList;
    }

    public void setNamesValuesList(List<String> namesValuesList) {
        this.namesValuesList = namesValuesList;
    }

    public List<Row> getRowsList() {
        return rowsList;
    }

    public void setRowsList(List<Row> rowsList) {
        this.rowsList = rowsList;
    }
}
