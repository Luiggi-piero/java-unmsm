package cpj.sesion9.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cpj.sesion9.entitys.EscalaNota;
import cpj.sesion9.entitys.Escuela;
import cpj.sesion9.entitys.Estudiante;


class MapAgregateTest {
	final Escuela sist = Escuela.Sistemas;
	final Escuela soft = Escuela.Software;
	final Estudiante e1 = new Estudiante("12345678", "Angel Ungenio", 8, sist);
	final Estudiante e2 = new Estudiante("22345678", "Beto Dosantos", 9, soft);
	final Estudiante e3 = new Estudiante("32345678", "Carlos Trelles", 10, sist);
	final Estudiante e4 = new Estudiante("42345678", "David Cuadros", 11, soft);
	final Estudiante e5 = new Estudiante("52345678", "Efain Quinto", 12, sist);
	final Estudiante e6 = new Estudiante("62345678", "Felipe Sexto", 16, soft);
	final Estudiante e7 = new Estudiante("72345678", "Guzman Septimo", 18, sist);

	List<Estudiante> estudiantes;
	@BeforeEach
	public void init() {
		estudiantes = Arrays.asList(
				e1, e2, e3, e4, e5, e6, e7
				);
	}	
	
	@Test
	void listGrouping() {
		Map<Escuela, List<Estudiante>> porEscuela = estudiantes.stream()
				.collect(Collectors.groupingBy(Estudiante::getEscuela));
		
		List<Estudiante> lstSist = porEscuela.get(sist);
		List<Estudiante> expected = Arrays.asList(
				e1, e3, e5, e7
				); 
		assertEquals(expected, lstSist);

		List<Estudiante> lstSoft = porEscuela.get(soft);
		expected = Arrays.asList(
				e2, e4, e6
				); 
		assertEquals(expected, lstSoft);
	}

	@Test
	void averageGrouping() {
		Map<Escuela, Double> porEscuela = estudiantes.stream()
				.collect(Collectors.groupingBy(Estudiante::getEscuela, Collectors.averagingDouble(Estudiante::getPromedio)));
		
		Double promedio = porEscuela.get(sist);
		Double  expected = (e1.getPromedio() + e3.getPromedio() + e5.getPromedio() + e7.getPromedio()) / 4;  
		assertEquals(expected, promedio);

		promedio = porEscuela.get(soft);
		expected = (e2.getPromedio() + e4.getPromedio() + + e6.getPromedio()) / 3;  
		assertEquals(expected, promedio);
	}

	@Test
	void booleanPartition() {
		Map<Boolean, List<Estudiante>> aprobadoDesaprobado = estudiantes.stream()
				.collect(Collectors.partitioningBy(e -> e.getPromedio() >= 10.5 ));
		
		List<Estudiante> aprobados = aprobadoDesaprobado.get(true);
		List<Estudiante> expected = Arrays.asList(
				e4, e5, e6, e7
				);
		assertEquals(expected, aprobados);

		List<Estudiante> desaprobados = aprobadoDesaprobado.get(false);
		expected = Arrays.asList(
				e1, e2, e3
				);
		assertEquals(expected, desaprobados);
	}

	@Test
	void rangePartition() {
		
		//Map<EscalaNota, List<Estudiante>> xEscala = estudiantes.stream()
		//		.collect(Collectors.partitioningBy(e -> EscalaNota.evaluar(e.getPromedio())));
		Map<EscalaNota, List<Estudiante>> xEscala = estudiantes.stream()
				.collect(Collectors.groupingBy(e -> EscalaNota.evaluar(e.getPromedio())));

		List<Estudiante> result = xEscala.get(EscalaNota.MuyBaja);
		List<Estudiante> expected = Arrays.asList(
				e1
				);
		assertEquals(expected, result);

		result = xEscala.get(EscalaNota.Baja);
		expected = Arrays.asList(
				e2, e3
				);
		assertEquals(expected, result);

		result = xEscala.get(EscalaNota.Regular);
		expected = Arrays.asList(
				e4, e5
				);
		assertEquals(expected, result);

		result = xEscala.get(EscalaNota.MuyAlta);
		expected = Arrays.asList(
				e6, e7
				);
		assertEquals(expected, result);

	}

	@Test
	void groupByEscuelaAndEscala() {
		
		//Map<EscalaNota, List<Estudiante>> xEscala = estudiantes.stream()
		//		.collect(Collectors.partitioningBy(e -> EscalaNota.evaluar(e.getPromedio())));
		Map<Escuela, Map<EscalaNota, List<Estudiante>>> xEscuelaEscala = estudiantes.stream()
				.collect(
						Collectors.groupingBy(
									Estudiante::getEscuela,
									Collectors.groupingBy(e -> EscalaNota.evaluar(e.getPromedio()))
								)
						);

		List<Estudiante> result = xEscuelaEscala.get(sist).get(EscalaNota.MuyBaja);
		List<Estudiante> expected = Arrays.asList(
				e1
				);
		assertEquals(expected, result);

		result = xEscuelaEscala.get(sist).get(EscalaNota.Baja);
		expected = Arrays.asList(
				e3
				);
		assertEquals(expected, result);

		result = xEscuelaEscala.get(sist).get(EscalaNota.Regular);
		expected = Arrays.asList(
				e5
				);
		assertEquals(expected, result);

		result = xEscuelaEscala.get(sist).get(EscalaNota.MuyAlta);
		expected = Arrays.asList(
				e7
				);
		assertEquals(expected, result);

		result = xEscuelaEscala.get(soft).get(EscalaNota.Baja);
		expected = Arrays.asList(
				e2
				);
		assertEquals(expected, result);

		result = xEscuelaEscala.get(soft).get(EscalaNota.Regular);
		expected = Arrays.asList(
				e4
				);
		assertEquals(expected, result);

		result = xEscuelaEscala.get(soft).get(EscalaNota.MuyAlta);
		expected = Arrays.asList(
				e6
				);
		assertEquals(expected, result);
	}
	
}
