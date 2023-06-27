/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Sofi
 */
public class Nodo {

    private Nodo siguiente;
    private int dato;
    private Producto producto;
    

    public Nodo(Producto producto ) {
        this.producto = producto;
        siguiente = null;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
         this.producto = producto;
    }
    
    

}
