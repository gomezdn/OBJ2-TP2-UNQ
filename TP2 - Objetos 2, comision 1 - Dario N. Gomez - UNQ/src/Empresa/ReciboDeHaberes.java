package Empresa;

import java.time.LocalDate;

public class ReciboDeHaberes {
	String nombreDeEmpleado;
	String direccionDeEmpleado;
	LocalDate fechaDeEmision;
	float sueldoBruto;
	float sueldoNeto;
	String desgloseDeConceptos;
	
	ReciboDeHaberes(String nombreDeEmpleado, String direccionDeEmpleado, LocalDate fechaDeEmision,
						float sueldoBruto, float sueldoNeto, String desgloseDeConceptos) {
		this.nombreDeEmpleado = nombreDeEmpleado;
		this.direccionDeEmpleado = direccionDeEmpleado;
		this.fechaDeEmision = fechaDeEmision;
		this.sueldoBruto = sueldoBruto;
		this.sueldoNeto = sueldoNeto;
		this.desgloseDeConceptos = desgloseDeConceptos;
	}
	
	public String getNombreDeEmpleado() {
		return nombreDeEmpleado;
	}

	public String getDireccionDeEmpleado() {
		return direccionDeEmpleado;
	}

	public LocalDate getFechaDeEmision() {
		return fechaDeEmision;
	}

	public float getSueldoBruto() {
		return sueldoBruto;
	}

	public float getSueldoNeto() {
		return sueldoNeto;
	}

	public String getDesgloseDeConceptos() {
		return desgloseDeConceptos;
	}
	
}
