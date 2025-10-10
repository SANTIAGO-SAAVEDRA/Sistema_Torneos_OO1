package test;

import java.util.List;
import java.time.LocalDate;
import modelo.Sistema;
import modelo.Entrenador;
import modelo.Equipo;
import modelo.Ganador;
import modelo.Jugador;
import modelo.Partido;
import modelo.Torneo;
public class TestSistemaTorneos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			Sistema s = new Sistema();

			cargarDatos.cargar(s);
			
	        try {
	        	System.out.println("\n4.) ganadores el 15/4/2025 en Clausura 2025:\n");
	        	Torneo torneo = s.traerTorneoPorNombre("Clausura 2025");
	            List<Ganador> ganadores = torneo.ganadoresEnFecha(LocalDate.of(2025, 4, 15));
	            for (Ganador g : ganadores) {
	                System.out.println("Ganador: " + g.getGanador().getNombre() +
	                                   " | Goles: " + g.getGoles() +
	                                   " | Fecha: " + g.getFecha());
	            }
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	        
	        
	        try {
	        	System.out.println("\n5.) Entrenador con Tactica favorita 4-4-2\n");
	        	List<Entrenador> entrenadores442 = s.getEntrenadoresPorTactica("4-4-2");
	        	
	        	for(Entrenador entrenador : entrenadores442) {
	        		System.out.println(entrenador);
	        	}
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	        
	        
	        try {
	        	System.out.println("\n6.) Jugadores nacidos entre 1960 y 1990:\n");
	        	List<Jugador> jugadoresNacidos = s.getJugadoresNacidosEntre(LocalDate.of(1960, 1, 1), LocalDate.of(1990, 1, 1));
	        	
	        	for(Jugador viejo: jugadoresNacidos) {
	        		System.out.println(viejo);
	        	}
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	        
	        
	        try {
	        	System.out.println("\n7.) Equipos creados antes de 1903:\n");
	        	List<Equipo> equiposAnteriores = s.buscarEquiposFundadosAntesDe(LocalDate.of(1903, 6, 15));
	        	for(Equipo anterior: equiposAnteriores) {
	        		System.out.println(anterior);
	        	}
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	        
	        
	        try {
	        	System.out.println("\n8.) Altura promedio de todos los equipos:\n");
	        	for(Equipo actual : s.getEquipos()) {
	        		System.out.println("La altura promedio de " + actual.getNombre()
					+ "es: " + actual.calcularAlturaPromedio()+"m.");
	        	}
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }


	        try {
	        	System.out.println("\n9.) Equipo con mayor altura promedio en Clausura 2025:\n");
	        	Torneo torneo = s.traerTorneoPorNombre("Clausura 2025");
	        	System.out.println(torneo.equipoConMayorAlturaPromedio());
	        	
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	    }
	}
