package ru.tsc.srb.leftjoin;

import java.util.List;

public class Row {

    private int id;
    private List<String> valuesList;

    public Row(int id, List<String> valuesList) {
        this.id = id;
        this.valuesList = valuesList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getValuesList() {
        return valuesList;
    }

    public void setValuesList(List<String> valuesList) {
        this.valuesList = valuesList;
    }
}
