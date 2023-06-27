/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Modelo.Producto;

/**
 *
 * @author Sofi
 */
public class ListaEnlazada {

     private int longitud;
    private Nodo cabeza;
    
    
    public ListaEnlazada(){
        longitud = 0;
        cabeza= null;
    }
    
    public void insertarPrincipio(Producto producto){
        Nodo nodo = new Nodo(producto);
        nodo.setSiguiente(cabeza);
        cabeza = nodo;
        longitud++;
    }
    
    public void insertarFinal(Producto producto){
        Nodo nodo = new Nodo(producto);
        if(cabeza == null){
            cabeza = nodo;
        }
        else{
            Nodo puntero = cabeza;
            while(puntero.getSiguiente() != null){
                puntero = puntero.getSiguiente();
            }
            puntero.setSiguiente(nodo);
        }
        longitud++;
    }
    
    public void insertarDespues(int posicion,Producto producto){
        Nodo nodo = new Nodo(producto);
        if (cabeza == null) {
            cabeza = nodo;
        } else {
            Nodo puntero = cabeza;
            int contador = 0;
            while (contador < posicion && puntero.getSiguiente() != null) {
                puntero = puntero.getSiguiente();
                contador++;

            }
            nodo.setSiguiente(puntero.getSiguiente());
            puntero.setSiguiente(nodo);

        }
        longitud++;

    }
    public String actualizar(String codigo, int cantidad){
        Nodo puntero = cabeza;
        for(int indice = 0; indice < longitud; indice++){
            if(puntero.getProducto().getCodigo().equals(codigo)){
                puntero.getProducto().setCantidad(cantidad);
                return "La cantidad se actualizó ";
            }
            puntero = puntero.getSiguiente();
        }
        return "Error"; 
    }

     public Producto getProducto(String codigo){
        if(cabeza == null){
            return null;
        }
        else{
            Nodo puntero = cabeza;
            for(int indice = 0; indice < longitud; indice++){
                if(puntero.getProducto().getCodigo().equals(codigo)){
                    return puntero.getProducto();
                }
                puntero = puntero.getSiguiente();
            }
        }
        return null;
    }
      public Producto getProducto(int posicion){
        if(cabeza == null){
            return null;
        }
        else{
            Nodo puntero = cabeza;
            int contador = 0;
            while(contador < posicion && puntero.getSiguiente() != null){
                puntero = puntero.getSiguiente();
                contador++;
            }
            if(contador != posicion){
                return null;
            }
            else{
                return puntero.getProducto();
            }
        }
    }

    public int getLongitud() {
        return longitud;
    }

    public boolean isVacia() {
        return cabeza == null;
    }

    public void eliminarPrincipio() {
        if (cabeza != null) {
            Nodo primer = cabeza;
            cabeza = cabeza.getSiguiente();
            primer.setSiguiente(null);
            longitud--;
        }
    }

    public void eliminarUltimo() {
        if (cabeza != null) {
            if (cabeza.getSiguiente() == null) {
                cabeza = null;
                longitud--;
            } else {
                Nodo puntero = cabeza;
                while (puntero.getSiguiente().getSiguiente() != null) {
                    puntero = puntero.getSiguiente();
                }
                puntero.setSiguiente(null);
                longitud--;
            }

        }
    }

    public void eliminarPosicion(String codigo) {
        Nodo puntero = cabeza;
        if(cabeza.getSiguiente() == null){
            cabeza = null;
            longitud--;
        }
        else if(cabeza.getProducto().getCodigo().equals(codigo)){
            Nodo aux = cabeza;
            cabeza = cabeza.getSiguiente();
            aux.setSiguiente(null);
            longitud--;
        }
        else{
            int contador = 0;
            while(contador < longitud){
                if(puntero.getProducto().getCodigo().equals(codigo) ){
                    Nodo temporal = puntero.getSiguiente();
                    puntero.setSiguiente(temporal.getSiguiente());
                    temporal.setSiguiente(null);
                    longitud--;
                    break;
                }
                puntero = puntero.getSiguiente();
            }
        }

    }

    public String toString() {
        String datosLista = "";

        Nodo nodo = null;
        Nodo aux = null;
        if (cabeza != null) {
            nodo = cabeza;
        }
        for (int elemento = 0; elemento < longitud; elemento++) {
            datosLista += "  " + nodo.getProducto();
            aux = nodo.getSiguiente();
            nodo = aux;

        }
        return datosLista;
    }

    public String[][] getTabla() {
      String[][] datosProducto = new String[getLongitud()][5];
        if(cabeza != null){
            for (int fila = 0; fila < longitud; fila++) {
                for (int columna = 0; columna < 5; columna++) {
                    datosProducto[fila][columna] = getProducto(fila).datosTabla(columna);
                }
            }   
        }
        return datosProducto;
    }
}

//        String[][] matriz = new String[this.longitud][Producto.etiquetasProducto.length];
//        for (int contador = 0; contador < matriz.length; contador++) {
//            for (int cuenta = 0; cuenta < matriz[0].length; cuenta++) {
//              matriz[contador][cuenta] = this.getDato(contador).datosTabla(cuenta);
//              matriz[contador][cuenta] = String.valueOf(this.getDato(contador));
//            }
//        }
//        return matriz;

