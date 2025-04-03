package com.example.demo.model;

public class Ticket {
    private String id;
    private String nro;
    private String userId;
    private String date;
    private String ruc;
    private String amount;

    public Ticket() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNro() {
        return nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id='" + id + '\'' +
                ", nro='" + nro + '\'' +
                ", userId='" + userId + '\'' +
                ", date='" + date + '\'' +
                ", ruc='" + ruc + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}
