package org.example.validaciones;

import org.example.utilidades.Utilidad;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidacionAfiliado {

    Utilidad utilidad= new Utilidad(); // inyeccion de dependencia
    int nombre;
    public ValidacionAfiliado() {
    }
    public boolean valiadarId(Integer id) throws Exception{

        if(id<0){
            throw new Exception("Error en el ID. por favor solo use numeros positivos.");
        }

        return true;
    }
    public boolean validarNombre(String nombre) throws Exception{
        if (nombre.length() < 3 || nombre.length() > 40){
            throw new Exception("El numero de caracteres no es correcto debe estar entre 3 y 40");
            }
        String expresionRegular="^[a-zA-Z ]+$";
        if (!this.utilidad.buscarCoincidencia(expresionRegular,nombre)){
            throw new Exception("Formato invalido");
        }
        return true;

    }

    public Boolean validarApellido(String apellidos)throws Exception{

        if (apellidos.length()<10 || apellidos.length()>50){
            throw new Exception("Los apellidos ingresados no cumplen con los requisitos");
        }
        String expresionRegular="^[a-zA-Z ]+$";
        if (!this.utilidad.buscarCoincidencia(expresionRegular,apellidos)){
            throw new Exception("Formato invalido");
        }
        return true;

    }

    public Boolean validarDocumento(String documento)throws Exception{
        if (documento.length()<7 || documento.length()>10){
            throw new Exception("Documento con longitud invalida");
        }
        String expresionRegular="^[0-9]+$";
        if (!this.utilidad.buscarCoincidencia(expresionRegular,documento)){
            throw new Exception("Formato invalido");
        }
        return true;

    }

    public Boolean validarCiudad(Integer ciudad)throws Exception{
        if (ciudad < 1123){
            throw new Exception("La ciudad/municipio no es valido");
        }
        return true;

    }

    public Boolean validarDepartamento(Integer departamento)throws Exception{
        if (departamento < 32){
            throw new Exception("El departamento no es valido");
        }
        return true;

    }

    public boolean validarCorreoElectronico(String correoElectronico) throws Exception{
        String expresionRegular="^[A-Za-z0-9+_.-]+@(.+)$";
        if (!this.utilidad.buscarCoincidencia(expresionRegular,correoElectronico)){
            throw new Exception("No cumple con el formato de correo electronico");
        }
        return true;

    }

    public Boolean validarTelefono(String telefono)throws Exception{
        if (telefono.length()!=10){
            throw new Exception("Cantidad de caracteres invalida");
        }
        String expresionRegular="^[0-9 ]+$";
        if (!this.utilidad.buscarCoincidencia(expresionRegular,telefono)){
            throw new Exception("Caracteres no admitidos, por favor solo utilice numeros");
        }
        return true;

    }


}
