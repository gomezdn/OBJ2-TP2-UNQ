package Empleado;

import java.time.LocalDate;
import java.util.HashMap;

public class EmpleadoContratado extends Empleado{
	int numeroDeContrato;
	MedioDePago medioDePago;
	
	public EmpleadoContratado(String nombre, String direccion, EstadoCivil estadoCivil, LocalDate fechaNacimiento,
			float sueldoBasico, int numeroDeContrato, MedioDePago medioDePago) {
		
	super(nombre, direccion, fechaNacimiento, estadoCivil, sueldoBasico);
	this.numeroDeContrato = numeroDeContrato;
	this.medioDePago = medioDePago;
}
	
	public int getNumeroDeContrato() {
		return this.numeroDeContrato;
	}
	
	public MedioDePago getMedioDePago() {
		return this.medioDePago;
	}
	
	public void setMedioDePago(MedioDePago medioDePago) {
		this.medioDePago = medioDePago;
	}
	
	@Override
	public HashMap<String, Float> desgloseDeSueldoBruto() {
		HashMap<String, Float> sueldoBruto = new HashMap<String, Float>();
		sueldoBruto.put("Sueldo basico", this.getSueldoBasico());
		
		return sueldoBruto;
	}

	@Override
	public HashMap<String, Float> desgloseDeRetenciones() {
		HashMap<String, Float> retenciones = new HashMap<String, Float>();
		retenciones.put("Gastos Administrativos Contractuales", (float) 50);
		
		return retenciones;
	}
}
