package ru.polyakov.transferme.data.model;

public class HomeModel {
    private String dateFrom;
    private String dateTo;

    public HomeModel(String dateFrom, String dateTo) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }
}
