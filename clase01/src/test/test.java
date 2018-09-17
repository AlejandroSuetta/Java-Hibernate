package test;

import java.lang.reflect.Array;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class test {
    public static void main(String[] args) {
        /*
        //Clase 01
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session sesion=sf.openSession();
        Transaction tran= sesion.beginTransaction();
        
        //Guardado
        //Persona p1=new Persona("Jorge",new Date(),true,20000);
        //sesion.save(p1);
        //System.out.println("Id: "+p1.getIdPersona());
        
        
        //Modificacion
        //int idPersona=1;
        //Persona p1=(Persona)sesion.get(Persona.class, idPersona);
        //p1.setNombre("Alejandro");
        //sesion.update(p1);
        //System.out.println(p1);
        
        //Borrado
        //Persona p1=(Persona)sesion.get(Persona.class, idPersona);
        //sesion.delete(p1);
        
        
        //Listar
        //List<Persona>personas=sesion.createQuery("from Persona").list();
        //for(Persona p:personas){
        //    System.out.println(p);
        //}
        
        tran.commit();
        sesion.close();
        sf.close();
        */
        
        //Clase 02
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session sesion=sf.openSession();
        Transaction tran= sesion.beginTransaction();
        
        /*Generar personas, direcciones y telefonos
        Direccion d1 = new Direccion();
        d1.setCalle("Callao");
        d1.setAltura("1234");
        sesion.save(d1);
        
        Telefono t1 = new Telefono();
        t1.setNumero("223545");
        sesion.save(t1);
        
        Telefono t2 = new Telefono();
        t2.setNumero("55234");
        sesion.save(t2);
        
        Persona p1 = new Persona("Jorge", new Date(), true, 20000);
        p1.setDireccion(d1);
        p1.getTelefonos().add(t1);
        p1.getTelefonos().add(t2);
        sesion.save(p1);
        System.out.println("Id: " + p1.getIdPersona());
        
        Direccion d2 = new Direccion();
        d2.setCalle("Libertado");
        d2.setAltura("5525");
        sesion.save(d2);
        
        Telefono t3 = new Telefono();
        t3.setNumero("223658465545");
        sesion.save(t3);
        
        Telefono t4 = new Telefono();
        t4.setNumero("5525434");
        sesion.save(t4);
        
        Telefono t5 = new Telefono();
        t5.setNumero("22375745545");
        sesion.save(t5);
        
        Telefono t6 = new Telefono();
        t6.setNumero("43434345");
        sesion.save(t6);
        
        Persona p2 = new Persona("Juan", new Date(), false, 50000);
        p2.setDireccion(d2);
        p2.getTelefonos().add(t3);
        p2.getTelefonos().add(t5);
        sesion.save(p2);
        System.out.println("Id: " + p2.getIdPersona());
        
        Persona p3 = new Persona("Julian", new Date(), true, 10000);
        p3.setDireccion(d2);
        p3.getTelefonos().add(t4);
        p3.getTelefonos().add(t6);
        sesion.save(p3);
        System.out.println("Id: " + p3.getIdPersona());
        */
        
        /*
        int idPersona = 1;
        Persona p1 = (Persona) sesion.get(Persona.class, idPersona);
        System.out.println("Nombre: " + p1.getNombre());
        System.out.println("Direccion: " + p1.getDireccion().getCalle());
        for(Telefono t : p1.getTelefonos()) {
            System.out.println("Telefono: " + t.getNumero());
        }
        */
        
        /*
        //Consultas
        Query query1 = sesion.createQuery("from Persona");
        List<Persona> personas1 = query1.list();
        for(Persona personaTMP : personas1) {
            System.out.println("Id: " + personaTMP.getIdPersona());
            System.out.println("Nombre: " + personaTMP.getNombre());
        }
        
        Query query1 = sesion.createQuery("from Persona as p where p.sueldo > 10000");
        List<Persona> personas1 = query1.list();
        for(Persona personaTMP : personas1) {
            System.out.println("Id: " + personaTMP.getIdPersona());
            System.out.println("Nombre: " + personaTMP.getNombre());
        }
        
        Query query1 = sesion.createQuery("from Persona as p where p.sueldo > :sueldoX"); //: indica una variable llamada sueldoX
        query1.setDouble("sueldoX", 20000);
        List<Persona> personas1 = query1.list();
        for(Persona personaTMP : personas1) {
            System.out.println("Id: " + personaTMP.getIdPersona());
            System.out.println("Nombre: " + personaTMP.getNombre());
        }
        
        Query query1 = sesion.createQuery("from Persona as p where p.direccion.calle = :calleX");
        query1.setString("calleX", "Libertado"); //el "Libertador" es case sensitive. EN el caso de mysql no es necesario, pero en otras bases de datos si es importante
        List<Persona> personas1 = query1.list();
        for(Persona personaTMP : personas1) {
            System.out.println("Id: " + personaTMP.getIdPersona());
            System.out.println("Nombre: " + personaTMP.getNombre());
        }
        
        Query query1 = sesion.createQuery("from Persona as p where p.id = :idPersona");
        query1.setLong("idPersona", 3);
        Persona personaUniq = (Persona) query1.uniqueResult(); //uniqueResult() es para cuando hay un solo resultado
        System.out.println("Id: " + personaUniq.getIdPersona());
        System.out.println("Nombre: " + personaUniq.getNombre());
        
        Query query2 = sesion.createQuery("select p.direccion from Persona" + " as p where p.id = :idPersona");
        query2.setLong("idPersona", 1);
        Direccion direccionUniq = (Direccion) query2.uniqueResult();
        System.out.println("Calle: " + direccionUniq.getCalle());
        System.out.println("Altura: " + direccionUniq.getAltura());
        
        Query query2 = sesion.createQuery("select p.telefonos from Persona" + " as p where p.id = :idPersona");
        query2.setLong("idPersona", 2);
        List<Telefono> telefonos = query2.list();
        for(Telefono telefonoTMP : telefonos) {
            System.out.println("Numero: " + telefonoTMP.getNumero());
        }
        
        Query query1 = sesion.createQuery("from Persona as p where p.sueldo > :sueldoX or p.nombre like :nombreX order by nombre desc"); //es desc para decendente o nada para default acendente
        query1.setDouble("sueldoX", 20000);
        query1.setString("nombreX", "%Jorge%");
        List<Persona> personas1 = query1.list();
        for(Persona personaTMP : personas1) {
            System.out.println("Id: " + personaTMP.getIdPersona());
            System.out.println("Nombre: " + personaTMP.getNombre());
        }
        
        Query query1 = sesion.createQuery("select count(*) from Persona as p where p.sueldo > :sueldoX"); //sirve para count, max, min, avarage y todas esas funciones
        query1.setDouble("sueldoX", 10000);
        long cantidad = (Long) query1.uniqueResult();
        System.out.println("Cantidad: " + cantidad);
        
        Query query1 = sesion.createQuery("select max(p.sueldo) from Persona as p");
        double sueldo = (Double) query1.uniqueResult();
        System.out.println("Sueldo Maximo: " + sueldo);
        
        Query query2 = sesion.createQuery("select avg(p.sueldo) from Persona as p");
        double sueldoAvg = (Double) query2.uniqueResult();
        System.out.println("Promedio de sueldos: " + sueldoAvg);
        
        tran.commit();
        sesion.close();
        sf.close();
        */
        /*
        //Clase 03     
        Query query = sesion.createQuery("select p.id, p.nombre from Persona as p where p.id = 1");
        Object[] row = (Object[]) query.uniqueResult(); //devuelve un Object String, y cada posicion es un dato
        String nombre = (String) row[1];
        int id = (Integer) row[0];
        System.out.println("nombre: " + nombre);
        System.out.println("id: " + id);
        
        
        Query query2 = sesion.createQuery("select p.id, p.nombre from Persona as p where p.id = 1");
        List<Object[]> rows = query2.list(); //devuelve un List de Object String (como una matris)
        for(Object[] rowTmp : rows) {
            System.out.println("nombre: " + rowTmp[1]);
            System.out.println("id: " + rowTmp[0]);
        }
        
        Query query3 = sesion.createQuery("from Persona");
        query3.setFirstResult(0); //Cual es la posicion en la que empieza (indice de la List<>)
        query3.setMaxResults(10); //Paginar. En este caso se muestran 10
        List<Persona> personaPaginado = query3.list();
        for(Persona personaTMP : personaPaginado) {
            System.out.println("Id: " + personaTMP.getIdPersona());
            System.out.println("Nombre: " + personaTMP.getNombre());
            System.out.println("Fecha: " + personaTMP.getFechaNacimiento());
            System.out.println("Sueldo: " + personaTMP.getSueldo());
        }
        
        SQLQuery sqlQuery1 = sesion.createSQLQuery("select persona.* from persona");
        sqlQuery1.addEntity(Persona.class);
        List<Persona> personas = sqlQuery1.list();
        for(Persona personaTMP : personas) {
            System.out.println("Id: " + personaTMP.getIdPersona());
            System.out.println("Nombre: " + personaTMP.getNombre());
            System.out.println("Fecha: " + personaTMP.getFechaNacimiento());
            System.out.println("Sueldo: " + personaTMP.getSueldo());
            System.out.println("Direccion: " + personaTMP.getDireccion());
        }
        */
        /*
        Query queryX = sesion.getNamedQuery("recuperarPersonas");
        List<Persona> personas = queryX.list();
        for(Persona personaTMP : personas) {
            System.out.println("Id: " + personaTMP.getIdPersona());
            System.out.println("Nombre: " + personaTMP.getNombre());
            System.out.println("Fecha: " + personaTMP.getFechaNacimiento());
            System.out.println("Sueldo: " + personaTMP.getSueldo());
            System.out.println("Direccion: " + personaTMP.getDireccion());
        }
        
        
        //Crear Empleados
        Empleado e1 = new Empleado(12, "Horacio", new Date(), true, 25000);
        Empleado e2 = new Empleado(25, "Carlos", new Date(), false, 30000);
        Empleado e3 = new Empleado(63, "German", new Date(), true, 12000);
        sesion.save(e1);
        sesion.save(e2);
        sesion.save(e3);
        
        //Crear Directores
        Director d1 = new Director("RRHH", "Jose", new Date(), true, 100000);
        Director d2 = new Director("Finansas", "Martin", new Date(), false, 120000);
        Director d3 = new Director("Direccion", "Julian", new Date(), false, 180000);
        sesion.save(d1);
        sesion.save(d2);
        sesion.save(d3);
        */
        
        
        tran.commit();
        sesion.close();
        sf.close();
    } 
}