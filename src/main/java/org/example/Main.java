package org.example;

import org.example.entidades.Afiliado;
import org.example.entidades.Examenesgenerales;
import org.example.entidades.Signovital;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner entradaTeclado = new Scanner(System.in);


        Afiliado afiliado = new Afiliado();

        System.out.println("digita su nombre: ");
        afiliado.setNombres(entradaTeclado.nextLine());

        System.out.println("Digite sus apellidos");
        afiliado.setApellidos(entradaTeclado.nextLine());

        System.out.println("Digite su documento: ");
        afiliado.setDocumento(entradaTeclado.nextLine());

        System.out.println("Digite su correo electronico (ejemplo12345@correo.com): ");
        afiliado.setCorreoElectronico(entradaTeclado.nextLine());

        System.out.println("Digite su telefono: ");
        afiliado.setTelefono(entradaTeclado.nextLine());

        System.out.println("Digite su fecha de nacimiento: ");
        afiliado.setFechaNacimiento(LocalDate.now());

        System.out.println("Digita su id de usuario: ");
        afiliado.setId(entradaTeclado.nextInt());

        System.out.println("Escoja su ciudad: ");
        afiliado.setCiudad(entradaTeclado.nextInt());

        System.out.println("Escoja su departamento");
        afiliado.setDepartamento(entradaTeclado.nextInt());

        Examenesgenerales examenesgenerales = new Examenesgenerales();

        examenesgenerales.setId(entradaTeclado.nextInt());

        examenesgenerales.setFechaExamen(null);

        examenesgenerales.setImagenExamen(entradaTeclado.nextLine());

        examenesgenerales.setNombreExamen(entradaTeclado.nextLine());

        Signovital signovital = new Signovital();

        signovital.setId(null);

        signovital.setFecha(null);

        signovital.setNombre(null);

        signovital.setMaximoNormal(null);

        signovital.setMinimoNormal(null);

        signovital.setUnidadMedida(null);

    }
}