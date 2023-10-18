package org.example.utilidades;

public enum Mensajes {


    ID_NEGATIVO("Error en el ID, por favor use numeros positivos"),
    NOMBRES_LONGITUD("El número de caracteres no es correcto debe estar entre 10 y 100"),

    NOMBRES_FORMATO("Formato invalido");

    private String mensaje;

    Mensajes(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
