package cpj.sesion5.lab;

import java.time.LocalDateTime;

public class Evento {
	int id;
	private String asunto;
	private LocalDateTime fecha;
	String lugar;
	
	public Evento(int id, String asunto, LocalDateTime fecha) {
		this.id = id;
		this.asunto = asunto;
		this.fecha = fecha;
		this.lugar = null;
	}
	
	public Evento(int id, String asunto, LocalDateTime fecha, String lugar) {
		this.id = id;
        this.asunto = asunto;
        this.fecha = fecha;
        this.lugar = lugar;
    }

	@Override
	public String toString() {
		return "\n Evento [id=" + id + ", asunto=" + asunto + ", fecha=" + fecha + ", lugar=" + (lugar != null ? lugar : "Sin lugar") + "] \n";
	}
	
	public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
    
    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }
}
