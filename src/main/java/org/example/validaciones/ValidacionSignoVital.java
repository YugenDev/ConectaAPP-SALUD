package org.example.validaciones;

import org.example.utilidades.Mensajes;
import org.example.utilidades.Utilidad;

public class ValidacionSignoVital {

    Utilidad utilidad = new Utilidad();

    public ValidacionSignoVital() {
    }

    public boolean valiadarId(Integer id) throws Exception{

        if(id<0){
            throw new Exception(Mensajes.NOMBRES_LONGITUD.getMensaje());
        }

        return true;
    }

    public boolean validarNombre(String nombre) throws Exception {
        if (nombre.length() < 10 || nombre.length() > 100) {
            throw new Exception(Mensajes.NOMBRES_LONGITUD.getMensaje());
        }
        String expresiónRegular = "^[a-zA-Z ]+$";
        if (!this.utilidad.buscarCoincidencia(expresiónRegular, nombre)) {
            throw new Exception(Mensajes.NOMBRES_FORMATO.getMensaje());
        }
        return true;
    }

    public boolean valiadarUnidadMedida(Integer unidadMedida) throws Exception{

        if(unidadMedida<0){
            throw new Exception(Mensajes.NOMBRES_FORMATO.getMensaje());
        }

        return true;
    }

    public boolean valiadarMaximoNormal(Double maximoNormal) throws Exception{

        if(maximoNormal<0){
            throw new Exception(Mensajes.ID_NEGATIVO.getMensaje());
        }

        return true;
    }

    public boolean valiadarMinimoNormal(Double minimoNormal) throws Exception{

        if(minimoNormal<0){
            throw new Exception(Mensajes.ID_NEGATIVO.getMensaje());
        }

        return true;
    }

}
