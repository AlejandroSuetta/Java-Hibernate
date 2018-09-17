package test;

import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
//Mapear herencias 
@DiscriminatorValue("director") //una sola tabla (metodo single table)
//@PrimaryKeyJoinColumn(name = "director_id")   Esto es para hacer una tabla por entidad (metodo join)
public class Director extends Persona{
    private String area;

    public Director() {super();}
    
    public Director(String area) {this.area = area;}
    
    public Director(String area, String nombre, Date fechaNacimiento, boolean esCasado, double sueldo) {
        super(nombre, fechaNacimiento, esCasado, sueldo);
        this.area = area;
    }

    public String getArea() {return area;}
    public void setArea(String area) {this.area = area;} 
}