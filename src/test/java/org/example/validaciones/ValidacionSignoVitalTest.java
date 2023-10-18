package org.example.validaciones;

import org.example.utilidades.Mensajes;
import org.example.utilidades.Mensajes.*;
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
        Assertions.assertEquals(Mensajes.NOMBRES_FORMATO.getMensaje(),resultado.getMessage());
    }


    @Test
    public void validarNombreIncorrecto_Longitud() {
        // 1. Preparar
        String nombrePrueba = "Corto";

        // 2. Ejecutar
        Exception resultado = Assertions.assertThrows(Exception.class, () -> validacionSignoVital.validarNombre(nombrePrueba));

        // 3. Validar
        Assertions.assertEquals(Mensajes.NOMBRES_LONGITUD.getMensaje(),resultado.getMessage());
    }

    @Test
    public void validarNombreCorrecto() {
        // 1. Preparar
        String nombrePrueba = "Nombre Correcto";

        // 2. Ejecutar
        Assertions.assertDoesNotThrow(() -> validacionSignoVital.validarNombre(nombrePrueba));
    }

    @Test
    public void validarNombreIncorrecto_Formato() {
        // 1. Preparar
        String nombrePrueba = "NombreRemeloCarameloOhsiOhsiyeah123";

        // 2. Ejecutar
        Exception resultado = Assertions.assertThrows(Exception.class, () -> validacionSignoVital.validarNombre(nombrePrueba));

        // 3. Validar
        Assertions.assertEquals(Mensajes.NOMBRES_FORMATO.getMensaje(), resultado.getMessage());
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
        Assertions.assertEquals(Mensajes.ID_NEGATIVO.getMensaje(), resultado.getMessage());
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
        Assertions.assertEquals(Mensajes.ID_NEGATIVO.getMensaje(), resultado.getMessage());
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
        Assertions.assertEquals(Mensajes.ID_NEGATIVO.getMensaje(), resultado.getMessage());
    }

}