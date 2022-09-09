package Empresa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

import Empleado.Empleado;

public class Empresa {
	private String nombre;
	private int cuit;
	private ArrayList<Empleado> empleados;
	private ArrayList<ReciboDeHaberes> liquidaciones;
	
	public Empresa(String nombre, int cuit, ArrayList<Empleado> empleados) {
		this.nombre= nombre;
		this.cuit = cuit;
		this.empleados = empleados;
		this.liquidaciones = new ArrayList<ReciboDeHaberes>();
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int getCuit() {
		return this.cuit;
	}
	
	public ArrayList<ReciboDeHaberes> getLiquidaciones() {
		return this.liquidaciones;
	}
	
	public ArrayList<Empleado> getEmpleados() {
		return this.empleados;
	}
	
	private ReciboDeHaberes liquidarSueldo(Empleado empleado) {
		String desgloseDeConceptos = "";
		
		for (Map.Entry<String, Float> concepto : empleado.desgloseDeSueldoBruto().entrySet()) {
			String desgloseDeConcepto = concepto.getKey() + ": " + concepto.getValue();
			desgloseDeConceptos += desgloseDeConcepto + "\n";
		}
		
		for (Map.Entry<String, Float> concepto : empleado.desgloseDeRetenciones().entrySet()) {
			String desgloseDeConcepto = concepto.getKey() + ": " + concepto.getValue();
			desgloseDeConceptos += desgloseDeConcepto + "\n";
		}
		
		ReciboDeHaberes recibo = new ReciboDeHaberes(empleado.getNombre(),
													 empleado.getDireccion(),
													 LocalDate.now(),
													 empleado.sueldoBruto(),
													 empleado.sueldoNeto(),
													 desgloseDeConceptos);
		
		return recibo;
		
	}

	private void registrarLiquidacion(ReciboDeHaberes liquidacion) {
		this.liquidaciones.add(liquidacion);
	}
	
	public void liquidarSueldos() {
		for (Empleado empleado : this.getEmpleados()) {
			this.registrarLiquidacion(liquidarSueldo(empleado));			
		}
	}
	
	public float totalSueldosNetos() {
		float sueldosNetos = 0;
		
		for (Empleado empleado : this.getEmpleados()) {
			sueldosNetos += empleado.sueldoNeto();
		}
		
		return sueldosNetos;
	}
	
	public float totalSueldosBrutos() {
		float sueldosBrutos = 0;
		
		for (Empleado empleado : this.getEmpleados()) {
			sueldosBrutos += empleado.sueldoBruto();
		}
		
		return sueldosBrutos;
		
	}

}
