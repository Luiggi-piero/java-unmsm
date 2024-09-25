package cpj.sesion1.intro;

import java.util.Scanner;

public class CalculadorBinario {

	private int op1;
	private int op2;
	private String operando;

	public CalculadorBinario() {
		// Contructor que llama a otro constructor
		this(0, 0, "+");
	}

	public CalculadorBinario(int op1, int op2, String operando) {
		this.op1 = op1;
		this.op2 = op2;
		this.operando = operando;
	}

	public int getOp1() {
		return op1;
	}

	public void setOp1(int op1) {
		this.op1 = op1;
	}

	public int getOp2() {
		return op2;
	}

	public void setOp2(int op2) {
		this.op2 = op2;
	}

	public String getOperando() {
		return operando;
	}

	public void setOperando(String operando) {
		this.operando = operando;
	}

	public double getResultado() {
		int resultado = 0;
		if ("+".equals(operando)) {
			resultado = op1 + op2;
		} else if ("-".equals(operando)) {
			resultado = op1 - op2;
		} else if ("*".equals(operando)) {
			resultado = op1 * op2;
		} else if ("/".equals(operando)) {
			resultado = op1 / op2;
		} else {
			throw new RuntimeException("Operador no soportado o invalido");
		}
		return resultado;
	}

	public static double demoUsandoConstructorConArg(Scanner scan) {
		// Demostración usando constructor con argumento
		System.out.print("Ingrese el operando 1: ");
		int op1 = scan.nextInt();

		System.out.print("Ingrese el operando 2: ");
		int op2 = scan.nextInt();
		System.out.print("Ingrese el operando: ");
		String operando = scan.next();
		
		CalculadorBinario bc2 = new CalculadorBinario(op1, op2, operando);
		System.out.printf("%d %s %d es: %.2f%n", bc2.getOp1(), bc2.getOperando(), bc2.getOp2(), bc2.getResultado());
		return bc2.getResultado();
	}

	public static double demoUsadoContructorNoArg(Scanner scan) {
		CalculadorBinario bc = new CalculadorBinario();
		System.out.print("Ingrese el operando 1: ");
		bc.setOp1(scan.nextInt());

		System.out.print("Ingrese el operando 2: ");
		bc.setOp2(scan.nextInt());

		System.out.printf("%d %s %d es: %.1f%n", bc.getOp1(), bc.getOperando(), bc.getOp2(), bc.getResultado());
		return bc.getResultado();
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		demoUsadoContructorNoArg(scan);
		demoUsandoConstructorConArg(scan);
		scan.close();
	}

	@Override
	public String toString() {
		return "CalculadorBinario [op1=" + op1 + ", op2=" + op2 + ", operando=" + operando + "]";
	}

}
