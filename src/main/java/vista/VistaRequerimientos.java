package vista;

import java.util.ArrayList;

import controlador.ControladorRequerimientos;
import modelo.dao.Requerimiento_1Dao;
import modelo.dao.Requerimiento_2Dao;
import modelo.dao.Requerimiento_3Dao;
import modelo.vo.Requerimiento_1Vo;
import modelo.vo.Requerimiento_2Vo;
import modelo.vo.Requerimiento_3Vo;

public class VistaRequerimientos {

    public static final ControladorRequerimientos controlador = new ControladorRequerimientos();

    public static ArrayList<Requerimiento_1Vo> requerimiento1() {
        try {
            var requerimiento_1Dao = new Requerimiento_1Dao();
            var lista = requerimiento_1Dao.requerimiento1();

            // for (Requerimiento_1Vo requerimiento_1Vo: lista) {
            //     System.out.println(requerimiento_1Vo.getCiudad_Residencia()+" "+requerimiento_1Vo.getSalario());
            // }
            
            return lista;

        } catch (Exception e) {
            // System.out.println("Se ha producido el siguiente error:" + e.getMessage());
            // e.printStackTrace();
            return new ArrayList<Requerimiento_1Vo>();
        }
    }

    public static ArrayList<Requerimiento_2Vo> requerimiento2() {
        try {
            var requerimiento_2Dao = new Requerimiento_2Dao();
            var lista2 = requerimiento_2Dao.requerimiento2();

            // for (Requerimiento_2Vo requerimiento_2Vo: lista2) {
            //     System.out.println(requerimiento_2Vo.getID_Proyecto()+" "+requerimiento_2Vo.getProveedor());
            // }
            return lista2;

        } catch (Exception e) {
            // System.out.println("Se ha producido el siguiente error:" + e.getMessage());
            // e.printStackTrace();
            return new ArrayList<Requerimiento_2Vo>();
        }
    }

    public static ArrayList<Requerimiento_3Vo> requerimiento3() {
        try {
            var requerimiento_3Dao = new Requerimiento_3Dao();
            var lista3 = requerimiento_3Dao.requerimiento3();

            // for (Requerimiento_3Vo requerimiento_3Vo: lista3) {
            //     System.out.println(requerimiento_3Vo.getId_Proyecto()+" "+requerimiento_3Vo.getNombre_Material());
            // }
            return lista3;

        } catch (Exception e) {
            // System.out.println("Se ha producido el siguiente error:" + e.getMessage());
            // e.printStackTrace();
            return new ArrayList<Requerimiento_3Vo>();
        }
    }

}
