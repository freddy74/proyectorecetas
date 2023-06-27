/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ListaEnlazada;
import Modelo.Nodo;
import Modelo.Producto;
import Vista.JFrmDatos;
import Vista.PanelDatos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;

/**
 *
 * @author Sofi
 */
public class ControladorPrincipal implements ActionListener {

    private PanelDatos panelDatos;
    private JFrmDatos frmDatos;
    private Producto producto;
    private Nodo nodo;
    private ListaEnlazada listaP;
    private String codigo;
    private int cantidad;
    private String descripcion;
    private double precio;

    public ControladorPrincipal() {
        
        this.panelDatos = panelDatos;
        this.frmDatos = new JFrmDatos(this);
        this.panelDatos= frmDatos.getPanel();
        this.listaP = new ListaEnlazada();
        panelDatos.setLista(  listaP);
//        this.panelDatos.setLista(lista);

    }

    public double calcularTotal() {
        double preciototal = 0;

        for (int indice = 0; indice < listaP.getLongitud(); indice++) {
            preciototal += listaP.getProducto(indice).getPrecioTotal();
        }
        return preciototal;
    }
     
    

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Registrar":
                codigo = panelDatos.getTextCodigo();
                cantidad = panelDatos.getTextCantidad();
                descripcion = panelDatos.getTextDescripcion();
                precio = panelDatos.getTextPrecio();
                System.out.println("Registrar");
               
                if(listaP.getProducto(codigo) != null){
                    System.err.println("ese codigo ya se uso");
                }
                else{
                    producto = new Producto(codigo,  cantidad,descripcion, precio);
                    listaP.insertarPrincipio(producto);
                    System.err.println("se agregó");
                    panelDatos.estadoInicial();
                    panelDatos.setTabla(listaP.getTabla());
                    //test
                    panelDatos.setJlPreciototal(calcularTotal());
                }
                break;

            case "Revertir":
                System.out.println("Revertir");
                 codigo = panelDatos.getTextCodigo();
                listaP.eliminarUltimo();
                 panelDatos.setTabla(listaP.getTabla());
                 panelDatos.setJlPreciototal(calcularTotal());

                break;
            case "Imprimir":
                System.out.println("Imprimir");
//                listaP.toString();
                // frmDatos.getPanel().setTabla(this.lista.getTabla(), producto.etiquetasProducto);
                JOptionPane.showMessageDialog(null, calcularTotal());
                 while(listaP.getLongitud() > 0){
                    listaP.eliminarPrincipio();
                    System.out.println(listaP.getLongitud());
                }
                panelDatos.setTabla(listaP.getTabla());
                panelDatos.setJlPreciototal(calcularTotal());
                
                break;

               
            default:
                throw new AssertionError();
        }

    }

    public static void main(String[] args) {
        new ControladorPrincipal();
    }

}
