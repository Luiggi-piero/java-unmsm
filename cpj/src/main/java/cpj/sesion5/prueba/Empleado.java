package cpj.sesion5.prueba;

public class Empleado extends Persona {
	private int sueldo;
	private String cargo;
	public Empleado(int edad, String nombre, int sueldo, String cargo) {
		super(edad, nombre);
		this.sueldo = sueldo;
		this.cargo = cargo;
	}
	public int getSueldo() {
		return sueldo;
	}
	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	@Override
	public void hablar() {
		System.out.println("Soy un empleado");
	}
}
