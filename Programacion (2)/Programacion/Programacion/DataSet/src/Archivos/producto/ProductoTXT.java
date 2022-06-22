package Archivos.producto;

import Clases.Producto;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ProductoTXT {
    File f = new File("Producto.txt");

    public boolean AgregarProducto(Producto objProducto) throws IOException {

        FileWriter fw = new FileWriter(f,true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.flush();

        bw.append(objProducto.getId()+",");
        bw.append(objProducto.getCategoria()  +",");
        bw.append(objProducto.getNombre() + "\n");

        bw.close();
        fw.close();

        return true;
    }

    public ArrayList<Producto> LeerProcducto() throws FileNotFoundException {
        ArrayList<Producto> ArrayClientes = new ArrayList<>();
        StringTokenizer st;

        Scanner entrada = new Scanner("");
        String sCadena;
        try {
            entrada = new Scanner(f);
            while (entrada.hasNext()) {
                sCadena = entrada.nextLine();
                if(sCadena == null) {break;}
                st = new StringTokenizer(sCadena, ",");
                while (st.hasMoreTokens()) {
                    Producto Objtmp = new Producto(st.nextToken(), st.nextToken(), st.nextToken());
                    ArrayClientes.add(Objtmp);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            entrada.close();
        }
        return ArrayClientes;
    }
}
