package test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@NamedQueries({ //Tambien hay NamedNativeQuery para escribir en SQL. Hay que agregar un resultClass = entity.class
    @NamedQuery(
        name = "recuperarPersonas",
        query = "from Persona"
    )
})

@Entity
//Mapear herencias
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)   //una sola tabla (metodo single table)
@DiscriminatorColumn(name = "tipo_persona", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("persona")
//@Inheritance(strategy = InheritanceType.JOINED)   Esto es para hacer una tabla por entidad (metodo join)
public class Persona {
            @Id
            @GeneratedValue
            private int idPersona;
            private String nombre;
            private Date fechaNacimiento;
            private boolean esCasado;
            private double sueldo;
            @ManyToOne(fetch = FetchType.LAZY) //FetchType puede ser lazy o eager(trae todo inclusive los datos de las relaciones)
            private Direccion direccion;
            @OneToMany
            @JoinColumn(name = "persona_id")
            private List<Telefono> telefonos = new ArrayList();

    public Persona() {
    }

    public Persona(int idPersona, String nombre, Date fechaNacimiento, boolean esCasado, double sueldo) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.esCasado = esCasado;
        this.sueldo = sueldo;
    }

    public Persona(String nombre, Date fechaNacimiento, boolean esCasado, double sueldo) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.esCasado = esCasado;
        this.sueldo = sueldo;
    }

    public int getIdPersona() {return idPersona;}
    public void setIdPersona(int idPersona) {this.idPersona = idPersona;}
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public Date getFechaNacimiento() {return fechaNacimiento;}
    public void setFechaNacimiento(Date fechaNacimiento) {this.fechaNacimiento = fechaNacimiento;}
    public boolean isEsCasado() {return esCasado;}
    public void setEsCasado(boolean esCasado) {this.esCasado = esCasado;}
    public double getSueldo() {return sueldo;}
    public void setSueldo(double sueldo) {this.sueldo = sueldo;}
    public Direccion getDireccion() {return direccion;}
    public void setDireccion(Direccion direccion) {this.direccion = direccion;}
    public List<Telefono> getTelefonos() {return telefonos;}
    public void setTelefonos(List<Telefono> telefonos) {this.telefonos = telefonos;}
    
    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", esCasado=" + esCasado + ", sueldo=" + sueldo + '}';
    }
}