/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practivaexamen;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Persistencia {

    public final static String pathCSV = "recursos/pelis";

    public static void guardarPelicula(Pelicula p) throws FileNotFoundException {

        FileOutputStream fos = new FileOutputStream(pathCSV, true);
        PrintWriter pw = new PrintWriter(fos);
        pw.append(p.toCSVFormat());
        pw.close();
    }
    
    public static boolean modificarPelicula(Pelicula vieja,Pelicula nueva) throws FileNotFoundException{
        boolean toret=false;
        if(eliminarPelicula(vieja)){
            guardarPelicula(nueva);
            toret = true;
        }
        return toret;
    }

    private static boolean eliminarPelicula(Pelicula p) throws FileNotFoundException {
        List<Pelicula> pelis =getPeliculas();
        if(pelis.contains(p)){
            FileOutputStream fos = new FileOutputStream(pathCSV,false);
            PrintWriter pw = new PrintWriter(fos);
            for(Pelicula pi:pelis){
                pw.println(pi.toCSVFormat());
            }
            pw.close();
            return true;
        }
        return false;
    }

    public static List<Pelicula> getPeliculas() throws FileNotFoundException{
        ArrayList<Pelicula> pelis = new ArrayList();
        FileInputStream f = new FileInputStream(pathCSV);
        Scanner sc = new Scanner(f);
        sc.nextLine();
        while(sc.hasNext()){
            pelis.add(new Pelicula(sc.nextLine()));
        }
        return pelis;
    }
}
