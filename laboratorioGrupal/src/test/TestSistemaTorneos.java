package test;

import java.util.List;
import java.time.LocalDate;
import modelo.Sistema;
import modelo.Asistencia;
import modelo.Entrenador;
import modelo.Equipo;
import modelo.Ganador;
import modelo.Goleador;
import modelo.Jugador;
import modelo.Posicion;
import modelo.Torneo;
public class TestSistemaTorneos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			Sistema s = new Sistema();

			cargarDatos.cargar(s);

			try {
				System.out.println("EQUIPOS:");
				for (Equipo e: s.getEquipos()) {
					System.out.println(e);
				}
				
				System.out.println("\nJUGADORES:");
				for (Jugador j: s.getJugadores()) {
					System.out.println(j);
				}
				
				System.out.println("\nENTRENADORES:");
				for (Entrenador e: s.getEntrenadores()) {
					System.out.println(e);
				}

			} catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
			
	        try {
	        	System.out.println("\n4.) ganadores el 15/4/2025 en Clausura 2025:\n");
	        	Torneo torneo = s.traerTorneoPorNombre("Clausura 2025");
	            List<Ganador> ganadores = torneo.ganadoresEnFecha(LocalDate.of(2025, 4, 15));
	            for (Ganador g : ganadores) {
	            	System.out.println(g);
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
	        	System.out.println("\n6.) Jugadores nacidos entre Enero 1960 y 1987:\n");
	        	List<Jugador> jugadoresNacidos = s.buscarJugadoresNacidosEntre(LocalDate.of(1960, 1, 1), LocalDate.of(1987, 1, 1));
	        	
	        	for(Jugador viejo: jugadoresNacidos) {
	        		System.out.println(viejo);
	        	}
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	        
	        
	        try {
	        	System.out.println("\n7.) Equipos creados antes de 1904:\n");
	        	List<Equipo> equiposAnteriores = s.buscarEquiposFundadosAntesDe(LocalDate.of(1904, 1, 1));
	        	for(Equipo anterior: equiposAnteriores) {
	        		System.out.println(anterior);
	        	}
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	        
	        
	        try {
	        	System.out.println("\n8.) Altura promedio de todos los equipos:\n");
	        	for(Equipo actual : s.getEquipos()) {
	        		System.out.println(String.format("Equipo: %-15s | Altura: %6.2fm",
	        				actual.getNombre().length()>15 ? actual.getNombre().substring(0,15):actual.getNombre(),
	        				actual.calcularAlturaPromedio()
	        				));
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
	        
	        
	        try {
	        	System.out.println("\n10.) Puntos de Boca en Clausura 2025:\n");
	        	Torneo torneo = s.traerTorneoPorNombre("Clausura 2025");
	        	System.out.println("Puntos: " + torneo.calcularPuntosEquipo(torneo.getEquipo(1)));
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	        
	        
	        try {
	        	System.out.println("\n11.) Tabla de Posicion de Clausura 2025:\n");
	        	Torneo torneo = s.traerTorneoPorNombre("Clausura 2025");
	        	System.out.println(String.format("%-30s","EQUIPOS")+" | GOLES");
	        	for(Posicion pos : torneo.generarTablaPosiciones()) {
	        		System.out.println(pos);
	        	}
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	        
	        
	        try {
	        	System.out.println("\n12.) Goles de Sergio Romero:\n");
	        	Torneo torneo = s.traerTorneoPorNombre("Clausura 2025");
	        	Jugador sergio = s.traerJugadorPorId(1);
	        	System.out.println("Goles: " + torneo.traerGolesDeJugador(sergio));
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	        
	        
	        try {
	        	System.out.println("\n13.) Asistencias de Sergio Romero:\n");
	        	Torneo torneo = s.traerTorneoPorNombre("Clausura 2025");
	        	Jugador sergio = s.traerJugadorPorId(1);
	        	System.out.println("Asistencias: " + torneo.traerAsistenciasDeJugador(sergio));
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	        
	        try {
	        	System.out.println("\n14.) Tabla de Goleadores de Clausura 2025:\n");
	        	Torneo torneo = s.traerTorneoPorNombre("Clausura 2025");
	        	System.out.println(String.format("%-30s","JUGADORES")+" | GOLES");
	        	for(Goleador goleador: Goleador.generarTablaGoleador(torneo)) {
	        		System.out.println(goleador);
	        	}
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	        
	        try {
	        	System.out.println("\n15.) Tabla de Asistidores de Clausura 2025:\n");
	        	Torneo torneo = s.traerTorneoPorNombre("Clausura 2025");
	    		System.out.println(String.format("%-30s","JUGADORES")+" | ASISTENCIAS");
	        	for(Asistencia asist: Asistencia.generarTablaAsistencia(torneo)) {
	        		System.out.println(asist);
	        	}
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	        
	    }
	}
