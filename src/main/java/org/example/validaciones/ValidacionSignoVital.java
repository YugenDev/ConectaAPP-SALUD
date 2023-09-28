package org.example.validaciones;

import org.example.utilidades.Utilidad;

public class ValidacionSignoVital {

    Utilidad utilidad = new Utilidad();

    public ValidacionSignoVital() {
    }

    public boolean valiadarId(Integer id) throws Exception{

        if(id<0){
            throw new Exception("Error en el ID, por favor use numeros positivos");
        }

        return true;
    }

    public boolean validarNombre(String nombre) throws Exception{
        if (nombre.length() < 10 || nombre.length() > 100){
            throw new Exception("El numero de caracteres no es correcto debe estar entre 10 y 100");
        }
        String expresionRegular="^[a-zA-Z ]+$";
        if (!this.utilidad.buscarCoincidencia(expresionRegular,nombre)){
            throw new Exception("Formato invalido");
        }
        return true;

    }

    public boolean valiadarUnidadMedida(Integer unidadMedida) throws Exception{

        if(unidadMedida<0){
            throw new Exception("Error en la unidad de medida. por favor solo use numeros positivos.");
        }

        return true;
    }

    public boolean valiadarMaximoNormal(Double maximoNormal) throws Exception{

        if(maximoNormal<0){
            throw new Exception("Error en la unidad de medida. por favor solo use numeros positivos.");
        }

        return true;
    }

    public boolean valiadarMinimoNormal(Double minimoNormal) throws Exception{

        if(minimoNormal<0){
            throw new Exception("Error en la unidad de medida. por favor solo use numeros positivos.");
        }

        return true;
    }

}
