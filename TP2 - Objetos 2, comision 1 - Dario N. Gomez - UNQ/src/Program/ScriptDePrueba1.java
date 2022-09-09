package Program;

import java.time.LocalDate;
import java.util.ArrayList;

import Empleado.Empleado;
import Empleado.EmpleadoPermanente;
import Empleado.EstadoCivil;
import Empresa.Empresa;

public class ScriptDePrueba1 {
	
	public static void main(String[] args) {
		EmpleadoPermanente empleado1 = new EmpleadoPermanente("Anibal", "Av Cabildo 3550", EstadoCivil.SOLTERO, 
											LocalDate.of(1993, 10, 31), 40000, 2, 2);
		EmpleadoPermanente empleado2 = new EmpleadoPermanente("Carlos", "Av Cabildo 3560", EstadoCivil.VIUDO, 
				LocalDate.of(1994, 11, 29), 50000, 3, 4);

		
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		empleados.add(empleado1) ; empleados.add(empleado2) ;
		
		Empresa empresita = new Empresa("Empresita S.A", 34567890, empleados);
		
				
		float totalDeSueldosNetos = empresita.totalSueldosNetos();
		
		System.out.println("Sueldos netos totales de la empresa: " + totalDeSueldosNetos);
	}
}
