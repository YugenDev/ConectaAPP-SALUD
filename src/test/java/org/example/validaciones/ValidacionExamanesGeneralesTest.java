package org.example.validaciones;

import org.example.utilidades.Mensajes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class ValidacionExamanesGeneralesTest {

    private ValidacionExamanesGenerales validacionExamanesGenerales;

    @BeforeEach
    public void setUp() {
        validacionExamanesGenerales = new ValidacionExamanesGenerales();
    }

    @Test
    public void validarIdCorrecto() {
        // 1. Preparar
        Integer idPrueba = 50;

        // 2. Ejecutar
        Boolean resultado = Assertions.assertDoesNotThrow(() -> validacionExamanesGenerales.valiadarId(idPrueba));

        // 3. Verificar
        Assertions.assertTrue(resultado);
    }

    @Test
    public void validarIdIncorrecto() {
        // 1. Preparar
        Integer idPrueba = -50;

        // 2. Ejecutar
        Exception resultado = Assertions.assertThrows(Exception.class, () -> validacionExamanesGenerales.valiadarId(idPrueba));

        // 3. Validar
        Assertions.assertEquals(Mensajes.ID_NEGATIVO.getMensaje(), resultado.getMessage());
    }

    @Test
    public void validarNombreExamenCorrecto() {
        // 1. Preparar
        String nombreExamenPrueba = "Examen de Muestra";

        // 2. Ejecutar
        Boolean resultado = Assertions.assertDoesNotThrow(() -> validacionExamanesGenerales.validarNombreExamen(nombreExamenPrueba));

        // 3. Verificar
        Assertions.assertTrue(resultado);
    }

    @Test
    public void validarNombreExamen_LongitudIncorrecta() {
        // 1. Preparar
        String nombreExamenPrueba = "Examen";

        // 2. Ejecutar
        Exception resultado = Assertions.assertThrows(Exception.class, () -> validacionExamanesGenerales.validarNombreExamen(nombreExamenPrueba));

        // 3. Validar
        Assertions.assertEquals(Mensajes.NOMBRES_LONGITUD.getMensaje(), resultado.getMessage());
    }

    @Test
    public void validarNombreExamen_FormatoIncorrecto() {
        // 1. Preparar
        String nombreExamenPrueba = "Examen123";

        // 2. Ejecutar
        Exception resultado = Assertions.assertThrows(Exception.class, () -> validacionExamanesGenerales.validarNombreExamen(nombreExamenPrueba));

        // 3. Validar
        Assertions.assertEquals(Mensajes.NOMBRES_FORMATO.getMensaje(), resultado.getMessage());
    }

    @Test
    public void validarNombreExamen_LongitudYFormatoIncorrectos() {
        // 1. Preparar
        String nombreExamenPrueba = "Examen123";

        // 2. Ejecutar
        Exception resultado = Assertions.assertThrows(Exception.class, () -> validacionExamanesGenerales.validarNombreExamen(nombreExamenPrueba));

        // 3. Validar
        Assertions.assertEquals(Mensajes.NOMBRES_LONGITUD.getMensaje(), resultado.getMessage());
        Assertions.assertEquals(Mensajes.NOMBRES_FORMATO.getMensaje(), resultado.getMessage());
    }

    @Test
    public void validarNombreExamenFuncionaCorrecto() {
        String nombreExamenPrueba = "Examen de Sangre";
        Assertions.assertDoesNotThrow(() -> validacionExamanesGenerales.validarNombreExamen(nombreExamenPrueba));
    }

    @Test
    public void validarNombreExamenIncorrecto_LongitudCorta() {
        String nombreExamenPrueba = "Corto";
        Exception resultado = Assertions.assertThrows(Exception.class, () -> validacionExamanesGenerales.validarNombreExamen(nombreExamenPrueba));
        Assertions.assertEquals(Mensajes.NOMBRES_LONGITUD.getMensaje(), resultado.getMessage());
    }

    @Test
    public void validarNombreExamenIncorrecto_LongitudLarga() {
        String nombreExamenPrueba = "EsteNombreEsMuyLargoYNoDeberiaSerAceptadoPorLaValidaciondfgdfhdhdfdfhdfhhdfhhasdkjhadsadshjadshjadsdkjhasdhjagfghfhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhjgjbhjjjgjjghjgjgjggjjgjghjgjggjgjgjhjjgjjjds";
        Exception resultado = Assertions.assertThrows(Exception.class, () -> validacionExamanesGenerales.validarNombreExamen(nombreExamenPrueba));
        Assertions.assertEquals(Mensajes.NOMBRES_LONGITUD.getMensaje(), resultado.getMessage());
    }

    @Test
    public void validarNombreExamenIncorrecto_FormatoInvalido() {
        String nombreExamenPrueba = "Examen 123"; // Contiene un número
        Exception resultado = Assertions.assertThrows(Exception.class, () -> validacionExamanesGenerales.validarNombreExamen(nombreExamenPrueba));
        Assertions.assertEquals(Mensajes.NOMBRES_FORMATO.getMensaje(), resultado.getMessage());
    }

    @Test
    public void validarImagenExamenFuncionaCorrecto() {
        String imagenExamenPrueba = "imagenDeExamen.jpg";
        Assertions.assertDoesNotThrow(() -> validacionExamanesGenerales.validarImagenExamen(imagenExamenPrueba));
    }

    @Test
    public void validarImagenExamenCorrecto_LimiteAlcanzado() {
        String imagenExamenPrueba = "imagenDeExamen.jpg";
        Assertions.assertDoesNotThrow(() -> validacionExamanesGenerales.validarImagenExamen(imagenExamenPrueba));
    }

    @Test
    public void validarImagenExamenCorrecto() {
        // 1. Preparar
        String imagenExamenPrueba = "imagenDeExamen.jpg";

        // 2. Ejecutar
        Boolean resultado = Assertions.assertDoesNotThrow(() -> validacionExamanesGenerales.validarImagenExamen(imagenExamenPrueba));

        // 3. Verificar
        Assertions.assertTrue(resultado);
    }

    @Test
    public void validarImagenExamen_LimiteAlcanzado() {
        // 1. Preparar
        String imagenExamenPrueba = "imagenExamenMuyLargaQueEsdjflksdhfksdhfkjdsfhkdsfhds,jfhkjsdhfksjdjhfkjdshfkjsdhfdskjhksdhfkjdsjkshdkjfhdskjfhsdkjfhsdkjfhdskjfhksdjxcedeElLimiteDeCaracteresEstablecidoPorLaValidacionfshdjjhdskhskjfhskdgsdkfgsdkjgskjdgkjsdgkjsghskdjghksghsdlhgsghldfsghksdlsdhkjsdjdsghkjsd.jpg";

        // 2. Ejecutar
        Exception resultado = Assertions.assertThrows(Exception.class, () -> validacionExamanesGenerales.validarImagenExamen(imagenExamenPrueba));

        // 3. Validar
        Assertions.assertEquals(Mensajes.NOMBRES_LONGITUD.getMensaje(), resultado.getMessage());
    }

}