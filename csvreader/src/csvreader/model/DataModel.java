package csvreader.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

public class DataModel {
    @CsvBindByPosition(position = 0)
    @CsvBindByName(column = "orderDate")
    private String orderDate;
    @CsvBindByPosition(position = 1)
    @CsvBindByName(column = "region")
    private String region;
    @CsvBindByPosition(position = 2)
    @CsvBindByName(column = "rep1")
    private String rep1;
    @CsvBindByPosition(position = 3)
    @CsvBindByName(column = "rep2")
    private String rep2;
    @CsvBindByPosition(position = 4)
    @CsvBindByName(column = "item")
    private String item;
    @CsvBindByPosition(position = 5)
    @CsvBindByName(column = "units")
    private String units;
    @CsvBindByPosition(position = 6)
    @CsvBindByName(column = "unitCost")
    private String unitCost;
    @CsvBindByPosition(position = 7)
    @CsvBindByName(column = "total")
    private String total;

    public DataModel(String orderDate, String region, String rep1, String rep2, String item, String units, String unitCost, String total) {
        this.orderDate = orderDate;
        this.region = region;
        this.rep1 = rep1;
        this.rep2 = rep2;
        this.item = item;
        this.units = units;
        this.unitCost = unitCost;
        this.total = total;
    }


    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setRep1(String rep1) {
        this.rep1 = rep1;
    }

    public void setRep2(String rep2) {
        this.rep2 = rep2;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public void setUnitCost(String unitCost) {
        this.unitCost = unitCost;
    }

    public void setTotal(String total) {
        this.total = total;
    }
    public String getOrderDate() {
        return orderDate;
    }

    public String getRegion() {
        return region;
    }

    public String getRep1() {
        return rep1;
    }

    public String getRep2() {
        return rep2;
    }

    public String getItem() {
        return item;
    }

    public String getUnits() {
        return units;
    }

    public String getUnitCost() {
        return unitCost;
    }

    public String getTotal() {
        return total;
    }


}
