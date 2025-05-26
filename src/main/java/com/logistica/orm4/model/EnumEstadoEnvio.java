package com.logistica.orm4.model;

public enum EnumEstadoEnvio {
    RECIBIDO("Recibido"),
    EN_TRANSITO("En tránsito"),
    EN_REPARTO("En reparto"),
    ENTREGADO("Entregado"),
    DEVUELTO("Devuelto"),
    CANCELADO("Cancelado");

    private final String descripcion;

    EnumEstadoEnvio(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}
