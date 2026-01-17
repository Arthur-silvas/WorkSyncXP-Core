package service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Arthur
 */


public class registroHorasServiceTest {
    
    private registroHorasService registrohorasservice;
    
    public registroHorasServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        registrohorasservice = new registroHorasService();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testFormataTempo() throws Exception {
        //Ex: Horário atual noformato 14:30:45.123456789 para 14:30:45 
        LocalTime tempo = LocalTime.of(14, 30, 45, 123456789); //Tempo atual da máquina
        LocalTime tempoEsperado = LocalTime.of(14,30,45); //Tempo formatado
        String horaFormatada = tempo.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        //asset de comparação (ambos no formato LocalTime)
        assertEquals(tempoEsperado, registrohorasservice.formataTempo(horaFormatada));
    }
    
    @Test
    public void testCalTempoCorrido() throws Exception {
        //Calcula o horário trabalhando como horário de entrada e saída. 
        LocalTime startInclusive = LocalTime.of(07, 00, 00);
        LocalTime endExclusive = LocalTime.of(15, 00, 00);
        String tempoEsperado = "08:00:00"; //retorna o resultado em String
        assertEquals(tempoEsperado, registrohorasservice.calTempoCorrido(startInclusive, endExclusive));
        
    }
    
    @Test
    public void testCalHorasExtra() throws Exception{
        LocalTime startInclusive = LocalTime.of(07, 00, 00);
        LocalTime endExclusive = LocalTime.of(17, 00, 00); // 2 Horas extras (em 8 horas de seviço diário)
        String resultado = registrohorasservice.calHorasExtra(startInclusive, endExclusive);
        assertEquals("02:00:00", resultado);
    }
    
    
}
