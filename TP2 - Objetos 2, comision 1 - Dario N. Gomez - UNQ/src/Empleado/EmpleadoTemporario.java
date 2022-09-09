package Empleado;

import java.time.LocalDate;
import java.util.HashMap;

public class EmpleadoTemporario extends Empleado {
	private int cantidadDeHsExtra;
	private LocalDate fechaDeEfectivizacion;
	
	public EmpleadoTemporario(String nombre, String direccion, LocalDate fechaNacimiento,
						EstadoCivil estadoCivil, float sueldoBasico, int cantidadDeHsExtra,
						LocalDate fechaDeEfectivizacion) {
		
		super(nombre, direccion, fechaNacimiento, estadoCivil, sueldoBasico);
		this.cantidadDeHsExtra = cantidadDeHsExtra;
		this.fechaDeEfectivizacion = fechaDeEfectivizacion;
	}
	
	public int getCantidadDeHsExtra() {
		return this.cantidadDeHsExtra;
	}
	
	public LocalDate getFechaDeEfectivizacion() {
		return this.fechaDeEfectivizacion;
	}
	
	public void setCantidadDeHsExtra(int cantidadDeHsExtra) {
		this.cantidadDeHsExtra = cantidadDeHsExtra;
	}
	
	public void setFechaDeEfectivizacion(LocalDate fechaDeEfectivizacion) {
		this.fechaDeEfectivizacion = fechaDeEfectivizacion;
	}
	
	@Override
	public HashMap<String, Float> desgloseDeSueldoBruto() {
		HashMap<String, Float> sueldoBruto = new HashMap<String, Float>();
		float montoSueldoBasico = this.getSueldoBasico();
		float montoHorasExtra = this.getCantidadDeHsExtra() * 40;
		
		sueldoBruto.put("Sueldo basico", montoSueldoBasico);
		sueldoBruto.put("Horas extra", montoHorasExtra);
		
		return sueldoBruto;
	}
	
	@Override
	public HashMap<String, Float> desgloseDeRetenciones() {
		HashMap<String, Float> retenciones = new HashMap<String, Float>();
		float montoObraSocial = (float) ((this.sueldoBruto() * 0.10) + (this.edad() > 50 ? 25 : 0));
		float montoAportesJubilatorios = (float) (this.sueldoBruto() * 0.10) + (this.getCantidadDeHsExtra() * 5);
		
		retenciones.put("Obra social", montoObraSocial);
		retenciones.put("Aportes jubilatorios", montoAportesJubilatorios);
		
		return retenciones;
		
	}
}
