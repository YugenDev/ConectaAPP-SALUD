package org.example.validaciones;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class ValidacionSignoVitalTest {

    private ValidacionSignoVital validacionSignoVital;

    @BeforeEach
    public void setUp() {
        validacionSignoVital = new ValidacionSignoVital();
    }

    @Test
    public void validarIdCorrecto() {
        // 1. Preparar
        Integer idPrueba = 50;

        // 2. Ejecutar
        Boolean resultado = Assertions.assertDoesNotThrow(() -> validacionSignoVital.valiadarId(idPrueba));

        // 3. Verificar
        Assertions.assertTrue(resultado);
    }

    @Test
    public void validarIdIncorrecto() {
        // 1. Preparar
        Integer idPrueba = -50;

        // 2. Ejecutar
        Exception resultado = Assertions.assertThrows(Exception.class, () -> validacionSignoVital.valiadarId(idPrueba));

        // 3. Validar
        Assertions.assertEquals("Error en el ID, por favor use numeros positivos", resultado.getMessage());
    }


    @Test
    public void validarNombreIncorrecto_Longitud() {
        // 1. Preparar
        String nombrePrueba = "Corto";

        // 2. Ejecutar
        Exception resultado = Assertions.assertThrows(Exception.class, () -> validacionSignoVital.validarNombre(nombrePrueba));

        // 3. Validar
        Assertions.assertEquals("El numero de caracteres no es correcto debe estar entre 10 y 100", resultado.getMessage());
    }

    @Test
    public void validarNombreIncorrecto_Formato() {
        // 1. Preparar
        String nombrePrueba = "Nombre123";

        // 2. Ejecutar
        Exception resultado = Assertions.assertThrows(Exception.class, () -> validacionSignoVital.validarNombre(nombrePrueba));

        // 3. Validar
        Assertions.assertEquals("El numero de caracteres no es correcto debe estar entre 10 y 100", resultado.getMessage());
    }

    @Test
    public void validarUnidadMedidaCorrecta() {
        // 1. Preparar
        Integer unidadMedidaPrueba = 5;

        // 2. Ejecutar
        Boolean resultado = Assertions.assertDoesNotThrow(() -> validacionSignoVital.valiadarUnidadMedida(unidadMedidaPrueba));

        // 3. Verificar
        Assertions.assertTrue(resultado);
    }

    @Test
    public void validarUnidadMedidaIncorrecta() {
        // 1. Preparar
        Integer unidadMedidaPrueba = -5;

        // 2. Ejecutar
        Exception resultado = Assertions.assertThrows(Exception.class, () -> validacionSignoVital.valiadarUnidadMedida(unidadMedidaPrueba));

        // 3. Validar
        Assertions.assertEquals("Error en la unidad de medida. por favor solo use numeros positivos.", resultado.getMessage());
    }

    @Test
    public void validarMaximoNormalCorrecto() {
        // 1. Preparar
        Double maximoNormalPrueba = 100.0;

        // 2. Ejecutar
        Boolean resultado = Assertions.assertDoesNotThrow(() -> validacionSignoVital.valiadarMaximoNormal(maximoNormalPrueba));

        // 3. Verificar
        Assertions.assertTrue(resultado);
    }

    @Test
    public void validarMaximoNormalIncorrecto() {
        // 1. Preparar
        Double maximoNormalPrueba = -100.0;

        // 2. Ejecutar
        Exception resultado = Assertions.assertThrows(Exception.class, () -> validacionSignoVital.valiadarMaximoNormal(maximoNormalPrueba));

        // 3. Validar
        Assertions.assertEquals("Error en la unidad de medida. por favor solo use numeros positivos.", resultado.getMessage());
    }

    @Test
    public void validarMinimoNormalCorrecto() {
        // 1. Preparar
        Double minimoNormalPrueba = 10.0;

        // 2. Ejecutar
        Boolean resultado = Assertions.assertDoesNotThrow(() -> validacionSignoVital.valiadarMinimoNormal(minimoNormalPrueba));

        // 3. Verificar
        Assertions.assertTrue(resultado);
    }

    @Test
    public void validarMinimoNormalIncorrecto() {
        // 1. Preparar
        Double minimoNormalPrueba = -10.0;

        // 2. Ejecutar
        Exception resultado = Assertions.assertThrows(Exception.class, () -> validacionSignoVital.valiadarMinimoNormal(minimoNormalPrueba));

        // 3. Validar
        Assertions.assertEquals("Error en la unidad de medida. por favor solo use numeros positivos.", resultado.getMessage());
    }

}