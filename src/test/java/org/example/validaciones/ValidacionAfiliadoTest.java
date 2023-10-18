package org.example.validaciones;

import org.example.utilidades.Mensajes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidacionAfiliadoTest {

    //Para ejecutar una prueba debo instanciar un objeto de la clase que voy a probar

    private ValidacionAfiliado validacionAfiliado;
    private Mensajes mensajes;
    @BeforeEach
    public void setUp() {
        validacionAfiliado = new ValidacionAfiliado();
    }

    @Test
    public void validarIdCorrecto() {
        // 1. Preparar
        Integer idPrueba = 50;

        // 2. Ejecutar
        Boolean resultado = Assertions.assertDoesNotThrow(() -> validacionAfiliado.validarId(idPrueba));

        // 3. Verificar
        Assertions.assertTrue(resultado);
    }

    @Test
    public void validarIdIncorrecto() {
        // 1. Preparar
        Integer idPrueba = -50;

        // 2. Ejecutar
        Exception resultado = Assertions.assertThrows(Exception.class, () -> validacionAfiliado.validarId(idPrueba));

        // 3. Validar
        Assertions.assertEquals(Mensajes.ID_NEGATIVO.getMensaje(), resultado.getMessage());
    }

    @Test
    public void validarCiudadFuncionaCorrecto() {
        // 1. Preparar
        Integer ciudadPrueba = 1123;

        // 2. Ejecutar
        Boolean resultado = Assertions.assertDoesNotThrow(() -> validacionAfiliado.validarCiudad(ciudadPrueba));

        // 3. Verificar
        Assertions.assertTrue(resultado);
    }

    @Test
    public void validarCiudadIncorrecto() {
        // 1. Preparar
        Integer ciudadPrueba = 1122;

        // 2. Ejecutar
        Exception resultado = Assertions.assertThrows(Exception.class, () -> validacionAfiliado.validarCiudad(ciudadPrueba));

        // 3. Validar
        Assertions.assertEquals("La ciudad/municipio no es valido", resultado.getMessage());
    }

    @Test
    public void validarDepartamentoFuncionaCorrecto() {
        // 1. Preparar
        Integer departamentoPrueba = 32;

        // 2. Ejecutar
        Boolean resultado = Assertions.assertDoesNotThrow(() -> validacionAfiliado.validarDepartamento(departamentoPrueba));

        // 3. Verificar
        Assertions.assertTrue(resultado);
    }

    @Test
    public void validarDepartamentoIncorrecto() {
        // 1. Preparar
        Integer departamentoPrueba = 31;

        // 2. Ejecutar
        Exception resultado = Assertions.assertThrows(Exception.class, () -> validacionAfiliado.validarDepartamento(departamentoPrueba));

        // 3. Validar
        Assertions.assertEquals("El departamento no es valido", resultado.getMessage());
    }

    @Test
    public void validarCorreoElectronicoFuncionaCorrecto() {
        // 1. Preparar
        String correoPrueba = "example@example.com";

        // 2. Ejecutar
        Boolean resultado = Assertions.assertDoesNotThrow(() -> validacionAfiliado.validarCorreoElectronico(correoPrueba));

        // 3. Verificar
        Assertions.assertTrue(resultado);
    }

    @Test
    public void validarCorreoElectronicoIncorrecto() {
        // 1. Preparar
        String correoPrueba = "invalid-email";

        // 2. Ejecutar
        Exception resultado = Assertions.assertThrows(Exception.class, () -> validacionAfiliado.validarCorreoElectronico(correoPrueba));

        // 3. Validar
        Assertions.assertEquals(Mensajes.NOMBRES_FORMATO.getMensaje(), resultado.getMessage());
    }



    @Test
    public void validarTelefonoCorrecto() {
        // 1. Preparar
        String telefonoPrueba = "1234567890";

        // 2. Ejecutar
        Boolean resultado = Assertions.assertDoesNotThrow(() -> validacionAfiliado.validarTelefono(telefonoPrueba));

        // 3. Verificar
        Assertions.assertTrue(resultado);
    }

    @Test
    public void validarTelefonoIncorrecto_Longitud() {
        // 1. Preparar
        String telefonoPrueba = "12345";

        // 2. Ejecutar
        Exception resultado = Assertions.assertThrows(Exception.class, () -> validacionAfiliado.validarTelefono(telefonoPrueba));

        // 3. Validar
        Assertions.assertEquals(Mensajes.NOMBRES_LONGITUD.getMensaje(), resultado.getMessage());
    }

    @Test
    public void validarTelefonoIncorrecto_Caracteres() {
        // 1. Preparar
        String telefonoPrueba = "12A3456789";

        // 2. Ejecutar
        Exception resultado = Assertions.assertThrows(Exception.class, () -> validacionAfiliado.validarTelefono(telefonoPrueba));

        // 3. Validar
        Assertions.assertEquals("Caracteres no admitidos, por favor solo utilice numeros", resultado.getMessage());
    }

    @Test
    public void validarNombreFuncionaCorrecto() {
        String nombrePrueba = "John Doe";
        Assertions.assertDoesNotThrow(() -> validacionAfiliado.validarNombre(nombrePrueba));
    }

    @Test
    public void validarNombreIncorrecto_LongitudCorta() {
        String nombrePrueba = "A";
        Exception resultado = Assertions.assertThrows(Exception.class, () -> validacionAfiliado.validarNombre(nombrePrueba));
        Assertions.assertEquals(Mensajes.NOMBRES_LONGITUD.getMensaje(), resultado.getMessage());
    }

    @Test
    public void validarNombreIncorrecto_LongitudLarga() {
        String nombrePrueba = "EsteNombreEsMuyLargoYNoDeberiaSerAceptadoPorLaValidacion";
        Exception resultado = Assertions.assertThrows(Exception.class, () -> validacionAfiliado.validarNombre(nombrePrueba));
        Assertions.assertEquals(Mensajes.NOMBRES_LONGITUD.getMensaje(), resultado.getMessage());
    }

    @Test
    public void validarNombreIncorrecto_FormatoInvalido() {
        String nombrePrueba = "John2Doe"; // Contiene un número
        Exception resultado = Assertions.assertThrows(Exception.class, () -> validacionAfiliado.validarNombre(nombrePrueba));
        Assertions.assertEquals(Mensajes.NOMBRES_FORMATO.getMensaje(), resultado.getMessage());
    }

    @Test
    public void validarApellidoFuncionaCorrecto() {
        String apellidoPrueba = "Smith Johnson";
        Assertions.assertDoesNotThrow(() -> validacionAfiliado.validarApellido(apellidoPrueba));
    }

    @Test
    public void validarApellidoIncorrecto_LongitudCorta() {
        String apellidoPrueba = "A B";
        Exception resultado = Assertions.assertThrows(Exception.class, () -> validacionAfiliado.validarApellido(apellidoPrueba));
        Assertions.assertEquals(Mensajes.NOMBRES_LONGITUD.getMensaje(), resultado.getMessage());
    }

    @Test
    public void validarApellidoIncorrecto_LongitudLarga() {
        String apellidoPrueba = "EsteApellidoEsMuyLargoYNoDeberiaSerAceptadoPorLaValidacion";
        Exception resultado = Assertions.assertThrows(Exception.class, () -> validacionAfiliado.validarApellido(apellidoPrueba));
        Assertions.assertEquals(Mensajes.NOMBRES_LONGITUD.getMensaje(), resultado.getMessage());
    }

    @Test
    public void validarApellidoIncorrecto_FormatoInvalido() {
        String apellidoPrueba = "Smith2Johnson"; // Contiene un número
        Exception resultado = Assertions.assertThrows(Exception.class, () -> validacionAfiliado.validarApellido(apellidoPrueba));
        Assertions.assertEquals(Mensajes.NOMBRES_FORMATO.getMensaje(), resultado.getMessage());
    }
}