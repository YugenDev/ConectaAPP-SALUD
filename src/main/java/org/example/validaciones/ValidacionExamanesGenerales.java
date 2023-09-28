package org.example.validaciones;

import org.example.utilidades.Utilidad;

public class ValidacionExamanesGenerales {

    Utilidad utilidad = new Utilidad();

    public ValidacionExamanesGenerales() {
    }

    public boolean valiadarId(Integer id) throws Exception{

        if(id<0){
            throw new Exception("Error en el ID, por favor use numeros positivos");
        }

        return true;
    }

    public boolean validarNombreExamen(String nombreExamen) throws Exception{
        if (nombreExamen.length() < 10 || nombreExamen.length() > 150){
            throw new Exception("El numero de caracteres no es correcto debe estar entre 10 y 150");
        }
        String expresionRegular="^[a-zA-Z ]+$";
        if (!this.utilidad.buscarCoincidencia(expresionRegular,nombreExamen)){
            throw new Exception("Formato invalido");
        }
        return true;

    }

    public Boolean validarImagenExamen(String imagenExamen)throws Exception {

        if (imagenExamen.length() >= 200) {
            throw new Exception("Limite de caracteres alcanzado");
        }

        return true;
    }


}
