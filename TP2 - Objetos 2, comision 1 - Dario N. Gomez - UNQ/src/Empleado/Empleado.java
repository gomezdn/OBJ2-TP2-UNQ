package Empleado;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;

abstract public class Empleado {
	private String nombre;
	private String direccion;
	private LocalDate fechaNacimiento;
	private EstadoCivil estadoCivil;
	private float sueldoBasico;
	
	protected Empleado(String nombre, String direccion, LocalDate fechaNacimiento,
			 	EstadoCivil estadoCivil, float sueldoBasico) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.fechaNacimiento = fechaNacimiento;
		this.estadoCivil = estadoCivil;
		this.sueldoBasico = sueldoBasico;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getDireccion() {
		return this.direccion;
	}
	
	public EstadoCivil getEstadoCivil() {
		return this.estadoCivil;
	}
	
	public LocalDate getFechaNacimiento() {
		return this.fechaNacimiento;
	}
	
	public float getSueldoBasico() {
		return this.sueldoBasico;
	}
	
	public int edad() {
		return (int) ChronoUnit.YEARS.between(LocalDate.now(), fechaNacimiento);
	}
	
	public void setSueldoBasico(float sueldo) {
		this.sueldoBasico = sueldo;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	public float sueldoBruto() {
		return  this.desgloseDeSueldoBruto()
					.values().stream()
					.reduce((float)0, (accu, current) -> accu + current);
			 
	}
	
	public float retencionesDeSueldo() {
		return this.desgloseDeRetenciones()
				   .values().stream()
				   .reduce((float)0, (accu, current) -> accu + current);
	}
	
	public float sueldoNeto() {
		return this.sueldoBruto() - this.retencionesDeSueldo();
	}
	
	abstract public HashMap<String, Float> desgloseDeSueldoBruto();
	
	abstract public HashMap<String, Float> desgloseDeRetenciones();
}
