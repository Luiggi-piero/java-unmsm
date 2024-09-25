package cpj.sesion4.acceso;

import cpj.sesion4.acceso.otro.A;

public class AccesoDemo {
	void useA() {
		A a = new A();
		a.var1 = 1;  // public
		
		//a.var2 = 2;  // protected solo desde el mismo paquete, clase y subclse
		//a.var3 = 3;  // sin modificador solo desde el mismo paquete y clase
	}
}
