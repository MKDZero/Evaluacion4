package cl.inacap.puntaarenas.evaluacion4.Modelo;

/**
 * Created by Zero on 17-12-2017.
 */

public class Pedidos {

    String id;
    String nombre_producto;
    String nombre_cliente;
    String direccion;
    String precio;


    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }
    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }
    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public Pedidos() {
        this.id= id;
        this.nombre_cliente = nombre_cliente;
        this.nombre_producto = nombre_producto;
        this.direccion = direccion;
        this.precio = precio;
    }
}
