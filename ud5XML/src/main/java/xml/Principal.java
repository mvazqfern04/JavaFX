/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xml;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;


/**
 *
 * @author alumno
 */
public class Principal {

    public static void main(String[] args) throws FileNotFoundException {
        try {
            JAXBContext context = JAXBContext.newInstance(Materia.class);
            ArrayList<Alumno> als=new ArrayList();
            als.add(new Alumno(1,10,"yo","no"));
            als.add(new Alumno(2,7,"yotu","si"));
            als.add(new Alumno(3,5,"mario","vazquez"));
            Materia porgramacion = new Materia("juan","programacion",300,als);
            
//            Unmarshaller um = context.createUnmarshaller();
//            FileInputStream fis = new FileInputStream("prueba.xml");
//            Materia xml = (Materia) um.unmarshal(fis);
            //Escritura
            Marshaller mars = context.createMarshaller();
            mars.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            mars.marshal(porgramacion, new FileOutputStream("prueba2.xml"));

        } catch (JAXBException jax) {
            System.err.println("error cagada");
        }
    }
}
