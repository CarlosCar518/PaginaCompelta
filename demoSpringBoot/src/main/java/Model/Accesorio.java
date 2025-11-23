package Model;

public class Accesorio {
    public int id;
    public String nombre;
    public int precioUnitario;
    public int cantidad;


    public Accesorio() {
    }

    public Accesorio(int id, String nombre, int precio, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.precioUnitario = precio;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(int precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
