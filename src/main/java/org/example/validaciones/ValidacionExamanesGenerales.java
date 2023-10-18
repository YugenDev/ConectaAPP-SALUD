package org.example.validaciones;

import org.example.utilidades.Mensajes;
import org.example.utilidades.Utilidad;

public class ValidacionExamanesGenerales {

    Utilidad utilidad = new Utilidad();

    public ValidacionExamanesGenerales() {
    }

    public boolean valiadarId(Integer id) throws Exception{

        if(id<0){
            throw new Exception(Mensajes.ID_NEGATIVO.getMensaje());
        }

        return true;
    }

    public boolean validarNombreExamen(String nombreExamen) throws Exception{
        System.out.println(nombreExamen.length());
        if (nombreExamen.length() < 10 || nombreExamen.length() > 150){
            throw new Exception(Mensajes.NOMBRES_LONGITUD.getMensaje());
        }
        String expresionRegular="^[a-zA-Z ]+$";
        if (!this.utilidad.buscarCoincidencia(expresionRegular,nombreExamen)){
            throw new Exception(Mensajes.NOMBRES_FORMATO.getMensaje());
        }
        return true;

    }

    public Boolean validarImagenExamen(String imagenExamen)throws Exception {

        if (imagenExamen.length() >= 200) {
            throw new Exception(Mensajes.NOMBRES_LONGITUD.getMensaje());
        }

        return true;
    }


}
