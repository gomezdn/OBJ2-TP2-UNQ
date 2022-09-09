package Empleado;

import java.time.LocalDate;
import java.util.HashMap;

public class EmpleadoPermanente extends Empleado {
	private int cantidadDeHijos;
	private int antiguedad;
	
	public EmpleadoPermanente(String nombre, String direccion, EstadoCivil estadoCivil, LocalDate fechaNacimiento,
				float sueldoBasico, int cantidadDeHijos, int antiguedad) {
		
		super(nombre, direccion, fechaNacimiento, estadoCivil, sueldoBasico);
		this.cantidadDeHijos = cantidadDeHijos;
		this.antiguedad = antiguedad;
	}
	
	public int getCantidadDeHijos() {
		return this.cantidadDeHijos;
	}
	
	public int getAntiguedad() {
		return this.antiguedad;
	}
	
	public void setCantidadDeHijos(int cantidadDeHijos) {
		this.cantidadDeHijos = cantidadDeHijos;
	}
	
	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}
	
	@Override
	public HashMap<String, Float> desgloseDeSueldoBruto() {
		HashMap<String, Float> sueldoBruto = new HashMap<String, Float>();
		float montoSueldoBasico = this.getSueldoBasico();
		float montoAsignacionPorHijo = 150 * this.getCantidadDeHijos();
		float montoAsignacionPorConyuge = this.getEstadoCivil() == EstadoCivil.CASADO ? 100 : 0;
		float montoAntiguedad = 50 * this.getAntiguedad();
		
		sueldoBruto.put("Sueldo Basico", montoSueldoBasico);
		sueldoBruto.put("Asignacion por hijo", montoAsignacionPorHijo);
		sueldoBruto.put("Asignacion por conyuge", montoAsignacionPorConyuge);
		sueldoBruto.put("Antiguedad" , montoAntiguedad);
		
		return sueldoBruto;
	}	
	
	@Override
	public HashMap<String, Float> desgloseDeRetenciones() {
		HashMap<String, Float> retenciones = new HashMap<String, Float>();
		float montoObraSocial = (float) (this.sueldoBruto() * 0.10 + 20 * this.getCantidadDeHijos());
		float montoAportesJubilatorios = (float) (this.sueldoBruto() * 0.15);
		
		retenciones.put("Obra social", montoObraSocial);
		retenciones.put("Aportes jubilatorios", montoAportesJubilatorios);
		
		return retenciones;
		
	}

}
