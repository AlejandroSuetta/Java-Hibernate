package test;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Direccion {
    @Id
    @GeneratedValue
    private long id;
    private String calle;
    private String altura;

    public Direccion() {}

    public Direccion(String calle, String altura) {
        this.id = id;
        this.calle = calle;
        this.altura = altura;
    }

    public long getId() {return id;}
    public void setId(long id) {this.id = id;}
    public String getCalle() {return calle;}
    public void setCalle(String calle) {this.calle = calle;}
    public String getAltura() {return altura;}
    public void setAltura(String altura) {this.altura = altura;}
}