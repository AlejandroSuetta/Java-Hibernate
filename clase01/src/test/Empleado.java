package test;

import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
 //Mapear herencias
@DiscriminatorValue("empleado") //una sola tabla (metodo single table)
//@PrimaryKeyJoinColumn(name = "empleado_id")   Esto es para hacer una tabla por entidad (metodo join)
public class Empleado extends Persona{
    private int numero; 

    public Empleado() {super();}

    public Empleado(int numero) {this.numero = numero;}

    public Empleado(int numero, String nombre, Date fechaNacimiento, boolean esCasado, double sueldo) {
        super(nombre, fechaNacimiento, esCasado, sueldo);
        this.numero = numero;
    }

    public int getNumero() {return numero;}
    public void setNumero(int numero) {this.numero = numero;}    
}