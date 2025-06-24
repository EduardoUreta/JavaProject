package com.ejemplo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class PedidoServiceTest {
    DescuentoRepository mockRepo = mock(DescuentoRepository.class); 
    PedidoService service = new PedidoService(mockRepo);

    @Test
    void testSinDescuentoYEnvioNormal() {
        double total = service.calcularTotal(100, false, false);
        assertEquals(110.0, total);
    }
    @Test
        void testConDescuentoYEnvioExpress() {
        double total = service.calcularTotal(100, true, true);
        assertEquals(110.0, total); // 100 - 10% + 20
    }
    @Test
        void testConDescuentoYEnvioNormal() {
        double total = service.calcularTotal(200, true, false);
        assertEquals(190.0, total);
    }
    @Test
        void testSinDescuentoYEnvioExpress() {
        double total = service.calcularTotal(150, false, true);
        assertEquals(170.0, total);
    }
}
