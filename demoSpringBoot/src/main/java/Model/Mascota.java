package Model;

public class Mascota {
    public int id;
    public String nombre;
    public String tipo;

    public Mascota(String nombre) {
        this.nombre = nombre;
    }

    public Mascota(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Mascota(int id, String nombre, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
