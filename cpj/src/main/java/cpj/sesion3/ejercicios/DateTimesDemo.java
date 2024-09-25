package cpj.sesion3.ejercicios;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class DateTimesDemo {

	// Laboratorio 3 - 3.1
	void showAhora() {
		System.out.println("****En Inglés****");
		System.out.println("Este momento es:");
		System.out.format("%s%n", LocalDateTime.now().format(DateTimeFormatter.ofPattern("EEEE dd/MMMM/yyyy HH:mm:ss", Locale.of("en", "US"))));
		System.out.format("%nEste momento en otras ciudades:%n");
		
		DateTimeFormatter dtFormatEn = DateTimeFormatter.ofPattern("EEEE dd/MMMM/yyyy HH:mm:ss",  Locale.of("en", "US"));
		LocalDateTime ahoraEnSaoPauloEn = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));  //"UTC-05:00" "Australia/Sydney" "America/Sao_Paulo"
		System.out.format("Sao Paulo: %s %n", ahoraEnSaoPauloEn.format(dtFormatEn));
		
		// Laboratorio 3 - 3.2
		LocalDateTime ahoraEnSydneyEn = LocalDateTime.now(ZoneId.of("Australia/Sydney")); 
		System.out.format("Sydney: %s %n", ahoraEnSydneyEn.format(dtFormatEn));
		LocalDateTime ahoraEnUTCMeno7En = LocalDateTime.now(ZoneId.of("UTC-07:00")); 
		System.out.format("Sydney: %s %n", ahoraEnUTCMeno7En.format(dtFormatEn));	
		
		System.out.println();
		System.out.println("****En Español****");
		System.out.println("Este momento es:");
		System.out.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS:%1$tN%n", LocalDateTime.now());
		System.out.format("%1$tA %1$te, %1$tB, %1$tY %1$tl %1$tp %1$tM min %1$tS sec %n",LocalDateTime.now());
		System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("EEEE dd/MMMM/yyyy HH:mm:ss", new Locale("es", "PE"))));
	
		System.out.format("%nEste momento en otras ciudades:%n");
		DateTimeFormatter dtFormat = DateTimeFormatter.ofPattern("EEEE dd/MMMM/yyyy HH:mm:ss");
		LocalDateTime ahoraEnSaoPaulo = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));  //"UTC-05:00" "Australia/Sydney" "America/Sao_Paulo"
		System.out.format("Sao Paulo: %s %n", ahoraEnSaoPaulo.format(dtFormat));

		// Laboratorio 3 - 3.2
		LocalDateTime ahoraEnSydney = LocalDateTime.now(ZoneId.of("Australia/Sydney")); 
		System.out.format("Sydney: %s %n", ahoraEnSydney.format(dtFormat));
		LocalDateTime ahoraEnUTCMeno7 = LocalDateTime.now(ZoneId.of("UTC-07:00")); 
		System.out.format("Sydney: %s %n", ahoraEnUTCMeno7.format(dtFormat));	
		System.out.println("*******************************************");
		
	}
	
	// Laboratorio 3 - 3.3
	void showFechasConocidas(){
		MonthDay sanPedro = MonthDay.of(Month.JUNE, 29);
		LocalDate esteSanPedro = sanPedro.atYear(Year.now().getValue());
		LocalDate este28DeJulio1 = LocalDate.of(2024, 7, 28);
		LocalDate este28DeJulio = Year.now().atMonth(Month.JULY).atDay(28);
		LocalDate este28DeJulio_2 = LocalDate.of(Year.now().getValue(), Month.JULY, 28);
		LocalDate esteSantaRosa = Year.now().atMonth(Month.AUGUST).atDay(30);
		LocalDate esteInicioDePrimavera = Year.now().atMonth(Month.MARCH).atDay(21);
	}
	
	void showFeriados(){
		DateTimeFormatter dtFormat = DateTimeFormatter.ofPattern("EEEE dd/MMMM/yyyy", new Locale("es", "PE"));
		List<LocalDate> feriadosDelAnio = Arrays.asList(
				LocalDate.of(Year.now().getValue(), Month.JANUARY, 1),
				LocalDate.of(Year.now().getValue(), Month.JULY, 28),
				LocalDate.of(Year.now().getValue(), Month.DECEMBER, 25)
				);
				
		System.out.format("%n%nLos dias feriados del año son:%n");
		for (LocalDate feriado: feriadosDelAnio) {
			System.out.format("%s%n", feriado.format(dtFormat));
		}
		
		// Laboratorio 3 - 3.4
		// Otro formato
		DateTimeFormatter dfFormatShort = DateTimeFormatter.ofPattern("EE dd/MM/yyyy", Locale.of("es", "PE"));
		List<LocalDate> otrosFeriados = Arrays.asList(
						LocalDate.of(Year.now().getValue(), Month.MAY, 1),
						LocalDate.of(Year.now().getValue(), Month.DECEMBER, 31)
						);
		System.out.format("%n%nOtros feriados del año son:%n");
		for (LocalDate fer: otrosFeriados) {
			System.out.format("%s%n", fer.format(dfFormatShort));
		}
	}

	// Laboratorio 3 - 3.5
	void showFechasDiversas(){
		Instant inicio = Instant.now();
		LocalDateTime mananaLaMismaHora = LocalDateTime.now().plusDays(1);
		LocalDateTime ayerLaMismaHora = LocalDateTime.now().minusDays(1); 
		LocalDateTime pasadoMananaLaMismaHora = LocalDateTime.now().plusDays(2);
		LocalDateTime comoHoyDelSgteMes = LocalDateTime.now().plusMonths(1);
		
		LocalDateTime santaRosa = LocalDateTime.of(LocalDateTime.now().getYear(), Month.AUGUST, 30, 0, 0);
		LocalDateTime unaSemanaAnteDeSantaRosa = santaRosa.minusWeeks(1); //Year.now().atMonth(Month.AUGUST).atDay(30).minusWeeks(1); 
		
		LocalDateTime unaHoraAnteDelInicioDeLaProximaClase = LocalDateTime.now().plusWeeks(1).minusHours(1);
		Instant termino = Instant.now();
		Duration transcurrido = Duration.between(inicio, termino);
		System.out.format("El tiempo transcurrido es de %d segundos y %d de nanosegundos %n", transcurrido.getSeconds(), transcurrido.getNano());
	}
	
	public static void main(String[] args) {
		DateTimesDemo demo = new DateTimesDemo();
		demo.showAhora();
		demo.showFeriados();
		demo.showFechasDiversas();
	}

}
