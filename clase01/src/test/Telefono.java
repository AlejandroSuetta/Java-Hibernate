package test;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Telefono {
    @Id
    @GeneratedValue
    private long id;
    private String numero;

    public Telefono() {
    }

    public Telefono(String numero) {
        this.id = id;
        this.numero = numero;
    }

    public long getId() {return id;}
    public void setId(long id) {this.id = id;}
    public String getNumero() {return numero;}
    public void setNumero(String numero) {this.numero = numero;}
}