package net.yazh.MatrixConcat.Model;

/**
 * Class for describing a table row
 */
public class Row implements Comparable<Row>{
    private int id;
    private String v1;
    private String v2;
    private int table;

    public Row(){
        this(0, null, null, 0);
    }

    public Row(int id, String v1, String v2, int table){
        this.id = id;
        this.v1 = v1;
        this.v2 = v2;
        this.table = table;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getV1() {
        return v1;
    }

    public void setV1(String v1) {
        this.v1 = v1;
    }

    public String getV2() {
        return v2;
    }

    public void setV2(String v2) {
        this.v2 = v2;
    }

    public int getTable() {
        return table;
    }

    public void setTable(int table) {
        this.table = table;
    }

    @Override
    public int compareTo(Row o) {
        return id > o.getId() ? 1 : id < o.getId() ? -1 : 0;
    }
}
