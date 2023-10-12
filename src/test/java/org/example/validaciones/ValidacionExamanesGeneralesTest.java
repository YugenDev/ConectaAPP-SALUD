package org.example.validaciones;

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
        Assertions.assertEquals("Error en el ID, por favor use numeros positivos", resultado.getMessage());
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
        Assertions.assertEquals("El numero de caracteres no es correcto debe estar entre 10 y 150", resultado.getMessage());
    }

    @Test
    public void validarNombreExamen_FormatoIncorrecto() {
        // 1. Preparar
        String nombreExamenPrueba = "Examen123";

        // 2. Ejecutar
        Exception resultado = Assertions.assertThrows(Exception.class, () -> validacionExamanesGenerales.validarNombreExamen(nombreExamenPrueba));

        // 3. Validar
        Assertions.assertEquals("El numero de caracteres no es correcto debe estar entre 10 y 150", resultado.getMessage());
    }

    @Test
    public void validarNombreExamen_LongitudYFormatoIncorrectos() {
        // 1. Preparar
        String nombreExamenPrueba = "Examen123";

        // 2. Ejecutar
        Exception resultado = Assertions.assertThrows(Exception.class, () -> validacionExamanesGenerales.validarNombreExamen(nombreExamenPrueba));

        // 3. Validar
        Assertions.assertEquals("El numero de caracteres no es correcto debe estar entre 10 y 150", resultado.getMessage());
    }

}