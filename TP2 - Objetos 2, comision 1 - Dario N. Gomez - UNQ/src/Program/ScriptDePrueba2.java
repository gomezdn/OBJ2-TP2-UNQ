package Program;

import java.time.LocalDate;
import java.util.ArrayList;

import Empleado.Empleado;
import Empleado.EmpleadoContratado;
import Empleado.EmpleadoPermanente;
import Empleado.EstadoCivil;
import Empleado.MedioDePago;
import Empresa.Empresa;
import Empresa.ReciboDeHaberes;

public class ScriptDePrueba2 {
	
	static void imprimirLiquidacion(ReciboDeHaberes liquidacion) {
		System.out.println("Fecha: " + liquidacion.getFechaDeEmision());
		System.out.println("Empleado: " + liquidacion.getNombreDeEmpleado());
		System.out.println("Direccion de empleado: " + liquidacion.getDireccionDeEmpleado());
		System.out.println("Sueldo bruto: " + liquidacion.getSueldoBruto());
		System.out.println("Sueldo neto: " + liquidacion.getSueldoNeto());
		System.out.println("\n" + "Desglose: " + "\n" + liquidacion.getDesgloseDeConceptos());
		System.out.println("-----------------------------------");
	}
	
	public static void main(String[] args) {
		EmpleadoPermanente empleado1 = new EmpleadoPermanente("Anibal", "Av Cabildo 3550", EstadoCivil.SOLTERO, 
											LocalDate.of(1993, 10, 31), 40000, 2, 2);
		EmpleadoContratado empleado2 = new EmpleadoContratado("Carlos", "Av Cabildo 3560", EstadoCivil.VIUDO, 
				LocalDate.of(1994, 11, 29), 50000, 1135, MedioDePago.CHEQUE);
		EmpleadoPermanente empleado3 = new EmpleadoPermanente("Silvana", "Av Cabildo 3570", EstadoCivil.CASADO, 
				LocalDate.of(1995, 12, 31), 70000, 2, 8);
		
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		empleados.add(empleado1) ; empleados.add(empleado2) ; empleados.add(empleado3) ;
		
		Empresa empresita = new Empresa("Empresita S.A", 34567890, empleados);
		
				
		empresita.liquidarSueldos();
		ArrayList<ReciboDeHaberes> liquidaciones = empresita.getLiquidaciones();
		
		for (ReciboDeHaberes liquidacion : liquidaciones) {
			imprimirLiquidacion(liquidacion);
		}
		
	}
}

//c) Para realizar esta extensión del modelo, ¿necesitó modificar la clase Empresa? ¿Por qué?
//		No, ya que el nuevo tipo de empleado es polimórfico respecto al resto de los empleados.
