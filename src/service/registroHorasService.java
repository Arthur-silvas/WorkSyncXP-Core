package service;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import view.RegistroPontoVIEW;

/**
 * Essa classe é responsável por fazer todas operaçãoes que envolvem tempo dentro do projeto.
 *
 * @author Windows
 */
public class registroHorasService {
    private RegistroPontoVIEW dao; 
    
    //receber a data e hora atual do sistema
    
    //formatar o LocalTime Ex: 14:30:45.123456789 para 14:30:45 
    public LocalTime formataTempo(String tempo){
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    LocalTime localTime = LocalTime.parse(tempo, formatter);
    return localTime; 
    }
    
    //Calcular a diferença entre o horário 01 e horário 02, recebe dois valores de tempo
    public String calTempoCorrido(LocalTime startInclusive, LocalTime endExclusive){
        Duration duracao = Duration.between(startInclusive, endExclusive);
        long horas = duracao.toHours();
        long minutos = duracao.toMinutesPart();
        long segundos = duracao.toSecondsPart();
        String tempoTotal = String.format("%02d:%02d:%02d", horas, minutos, segundos);
        return tempoTotal; 
    }     
    
}
