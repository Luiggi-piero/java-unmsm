package cpj.sesion5.lab;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AgendaApp extends ConsolaApp {

	private static String[] opciones = { "Registrar evento", "Editar evento", "Eliminar evento", "Listar eventos",
			"Buscar por asunto", "Buscar por rango de fecha", "Salir" };

	private static List<Evento> listaEventos = new ArrayList<>();

	public AgendaApp() {
		super(opciones);
	}

	public static void main(String[] args) {
		AgendaApp demo = new AgendaApp();
		demo.start();
	}

	@Override
	protected void procesarOpcion(int opcion) {

		Scanner scan = new Scanner(System.in);

		switch (opcion) {
		case 1:
			registrarEvento(scan);
			mostrarOpciones();
			break;
		case 2:
			editarEvento(scan);
			mostrarOpciones();
			break;
		case 3:
			eliminarEvento(scan);
			mostrarOpciones();
			break;
		case 4:
			listarEventos();
			mostrarOpciones();
			break;
		case 5:
			buscarPorAsunto(scan);
			mostrarOpciones();
			break;
		case 6:
			buscarPorRango(scan);
			mostrarOpciones();
			break;
		case 7:
			terminarPrograma();
			break;
		default:
			break;
		}
		scan.close();
	}

	private void terminarPrograma() {
		System.out.println("*** Programa terminado");
		System.exit(0);
	}

	private void registrarEvento(Scanner scan) {
		Scanner scannerAsunto = new Scanner(System.in);
		System.out.print("Ingrese el asunto: ");
		String asunto = scannerAsunto.nextLine();

		LocalDateTime fecha = agregarFecha(scan);

		System.out.print("Desea ingresar un lugar (SI/NO): ");
		String tieneLugar = scan.next();

		if (tieneLugar.toLowerCase().equals("no")) {
			Evento evento = new Evento(listaEventos.size() + 1, asunto, fecha);
			agregarEvento(evento);
			return;
		}

		Scanner scanner = new Scanner(System.in);
		System.out.print("Ingrese el lugar: ");
		String lugar = scanner.nextLine();
		Evento eventoConLugar = new Evento(listaEventos.size() + 1, asunto, fecha, lugar);
		agregarEvento(eventoConLugar);
	}

	private LocalDateTime agregarFecha(Scanner scan) {
		System.out.print("Ingrese el año: ");
		int anio = scan.nextInt();
		System.out.print("Ingrese el mes: ");
		int mes = scan.nextInt();
		System.out.print("Ingrese el día: ");
		int dia = scan.nextInt();
		System.out.print("Ingrese la hora: ");
		int hora = scan.nextInt();
		LocalDateTime dateTime = LocalDateTime.of(anio, mes, dia, hora, 0);
		return dateTime;
	}

	private void agregarEvento(Evento evento) {
		listaEventos.add(evento);
		System.out.println("*** Creado con exito! ***");
		System.out.println(listaEventos);
	}

	private void editarEvento(Scanner scan) {
		System.out.print("Ingrese el id: ");
		int id = scan.nextInt();
		int indice = buscarEventoPorId(listaEventos, id);
		if (indice == -1) {
			System.out.println("*** No existe el evento con ese id ***");
			return;
		}
		Evento nuevoEvento = solicitarNuevosDatosDelEvento(scan, id);
		actualizarEvento(nuevoEvento, indice);
	}

	private Evento solicitarNuevosDatosDelEvento(Scanner scan, int id) {
		Scanner scannerAsunto = new Scanner(System.in);
		System.out.println();
		System.out.println("*** Editando evento ***");
		System.out.print("Ingrese el asunto: ");
		String asunto = scannerAsunto.nextLine();

		LocalDateTime fecha = agregarFecha(scan);

		System.out.print("Desea ingresar un lugar (SI/NO): ");
		String tieneLugar = scan.next();

		if (tieneLugar.toLowerCase().equals("no")) {
			Evento evento = new Evento(id, asunto, fecha);
			return evento;
		}

		Scanner scanner = new Scanner(System.in);
		System.out.print("Ingrese el lugar: ");
		String lugar = scanner.nextLine();
		Evento eventoConLugar = new Evento(id, asunto, fecha, lugar);
		return eventoConLugar;
	}

	private static int buscarEventoPorId(List<Evento> eventos, int id) {
		for (int i = 0; i < eventos.size(); i++) {
			if (eventos.get(i).id == id) {
				return i;
			}
		}
		return -1;
	}

	private void actualizarEvento(Evento evento, int indice) {
		listaEventos.set(indice, evento);
		System.out.println("*** Editado con exito! ***");
		System.out.println(listaEventos);
	}

	private void eliminarEvento(Scanner scan) {
		System.out.println();
		System.out.print("ELIMINAR - Ingrese el id del evento: ");
		int id = scan.nextInt();
		int indice = buscarEventoPorId(listaEventos, id);
		if (indice == -1) {
			System.out.println("*** No existe el evento con ese id ***");
			return;
		}
		listaEventos.remove(indice);
		System.out.println("*** Eliminado con éxito! ***");
	}

	private void listarEventos() {
		int totalEventos = listaEventos.size();
		 LocalDateTime ahora = LocalDateTime.now();
		
		if(totalEventos == 0) {
			System.out.println("*** No hay eventos por mostrar ***");
			return;
		}
		
		List<Evento> eventosFuturos = listaEventos.stream()
                .filter(evento -> evento.getFecha().isAfter(ahora) || evento.getFecha().isEqual(ahora))
                .collect(Collectors.toList());
		
		eventosFuturos.forEach(System.out::println);
	}
	
	private void buscarPorRango(Scanner scan) {
		System.out.println();
		System.out.println("Ingrese la fecha de inicio");
		LocalDateTime fechaInicio = agregarFecha(scan);
		System.out.println();
		System.out.println("Ingrese la fecha final");
		LocalDateTime fechaFinal = agregarFecha(scan);
		
		List<Evento> eventosBuscados = listaEventos.stream()
				.filter(evento -> evento.getFecha().isAfter(fechaInicio) && evento.getFecha().isBefore(fechaFinal))
				.collect(Collectors.toList());
		
		if(eventosBuscados.size() == 0) {
			System.out.println("*** No hay eventos encontrados ***");
			return;
		}
		
		eventosBuscados.forEach(System.out::println);
	}
	
	private void buscarPorAsunto(Scanner scan) {
		System.out.println();
		System.out.print("Ingrese el asunto: ");
		String asunto = scan.nextLine();
		List<Evento> eventosEncontrados = listaEventos.stream()
				.filter(evento -> evento.getAsunto().toLowerCase().contains(asunto))
				.collect(Collectors.toList());
		
		if(eventosEncontrados.size() == 0) {
			System.out.println("*** No se encontraron eventos ***");
			return;
		}
		eventosEncontrados.forEach(System.out::println);
	}
}
