package com.bancoseguro.model;

public class Transaccion {
    private int id;
    private int clienteId;
    private double monto;
    private String pais;
    private long timestamp; // Epoch millis

    public Transaccion(int id, int clienteId, double monto, String pais, long timestamp) {
        this.id = id;
        this.clienteId = clienteId;
        this.monto = monto;
        this.pais = pais;
        this.timestamp = timestamp;
    }

    // Getters
    public int getId() { return id; }
    public int getClienteId() { return clienteId; }
    public double getMonto() { return monto; }
    public String getPais() { return pais; }
    public long getTimestamp() { return timestamp; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setClienteId(int clienteId) { this.clienteId = clienteId; }
    public void setMonto(double monto) { this.monto = monto; }
    public void setPais(String pais) { this.pais = pais; }
    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }

    @Override
    public String toString() {
        return "Transaccion{id=" + id + ", clienteId=" + clienteId +
               ", monto=" + monto + ", pais='" + pais + "', timestamp=" + timestamp + "}";
    }
}
