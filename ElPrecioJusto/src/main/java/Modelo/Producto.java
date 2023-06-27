/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Sofi
 */
public class Producto {

    private String codigo;
    private int cantidad;
    private String descripcion;
    private double precio;
    private double precioTotal;

    public Producto() {
    }


    public Producto(String codigo, int cantidad, String descripcion, double precio) {
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.precio = precio;
        this.precioTotal= precioTotal;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
       public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }
        public void calcularTotal(){
        precioTotal = cantidad * precio;
    }

    public String datosTabla(int columna) {
        switch (columna) {
            case 0:
                return codigo;
            case 1:
                return descripcion;
            case 2:
                return Integer.toString(getCantidad());
            case 3:
                return String.valueOf(precio);
                 case 4:
                calcularTotal();
                return String.valueOf(precioTotal);
            default:
                return null;
        }
    }
}
