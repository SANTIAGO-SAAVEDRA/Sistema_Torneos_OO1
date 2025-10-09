package test;

import java.util.List;
import java.time.LocalDate;
import modelo.Sistema;
import modelo.Entrenador;
import modelo.Equipo;
import modelo.EstadisticaPartido;
import modelo.Ganador;
import modelo.Jugador;
import modelo.Partido;
import modelo.Torneo;

public class TestSistemaTorneos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			Sistema s = new Sistema();

	        s.agregarEntrenador("Carlos", "Bianchi", 12345678, LocalDate.of(1950, 4, 26), "4-4-2");
	        s.agregarEntrenador("Marcelo", "Gallardo", 23456789, LocalDate.of(1976, 1, 18), "4-3-1-2");
	        s.agregarEntrenador("Ricardo", "Gareca", 34567890, LocalDate.of(1958, 2, 10), "4-4-2");
	        s.agregarJugador("Lionel", "Messi", 12345679, LocalDate.of(1987, 6, 24), 1.70f, 70f, "Delantero", 10);
	        s.agregarJugador("Ángel", "Di María", 22345679, LocalDate.of(1988, 2, 14), 1.78f, 75f, "Extremo", 11);
	        s.agregarJugador("Emiliano", "Martínez", 32345679, LocalDate.of(1992, 9, 2), 1.95f, 85f, "Arquero", 1);
	        
	        Entrenador bianchi = null;
	        Entrenador gallardo = null;
		
	        try {
	            bianchi = s.traerEntrenadorPorId(1);
	            gallardo = s.traerEntrenadorPorId(2);
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	        
	        s.agregarEquipo("Boca Juniors", bianchi, LocalDate.of(1905, 4, 3));
	        s.agregarEquipo("River Plate", gallardo, LocalDate.of(1901, 5, 25));

	        s.crearTorneo("Clausura 2025", LocalDate.of(2025, 4, 1), LocalDate.of(2025, 8, 1));

	        try {
	            Equipo equipo = s.traerEquipoPorId(1);
	            System.out.println("Cantidad Jugadores " + equipo.getJugadores().size() + " jugadores.");
	            equipo.agregarJugador(s.traerJugadorPorId(1));
	            equipo.agregarJugador(s.traerJugadorPorId(2));
	            equipo.eliminarJugador(2);
	            System.out.println("Cantidad Jugadores " + equipo.getJugadores().size() + " jugadores.");
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	        System.out.println();

	        try {
	            Jugador jugador = s.traerJugadorPorId(1);
	            System.out.println("Jugador encontrado: " + jugador.getNombre() + " " + jugador.getApellido());
	            Torneo torneo = s.traerTorneoPorNombre("Clausura 2025");
	            System.out.println("Torneo encontrado: " + torneo.getNombre());
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	        System.out.println();

	        try {
	            List<Entrenador> lista = s.getEntrenadoresPorTactica("4-4-2");
	            for (Entrenador e : lista) {
	                System.out.println("Entrenador: " + e.getNombre() + " " + e.getApellido());
	            }
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	        System.out.println();
	        
	        try {
	            Equipo boca = s.traerEquipoPorId(1);
	            Equipo river = s.traerEquipoPorId(2);

	            s.agregarPartido(LocalDate.of(2025, 4, 15), boca, river, "La Bombonera");
	            Partido partido = s.traerPartidoPorId(1);

	            s.agregarEstadistica(partido, boca, 2, 1, 90);
	            s.agregarEstadistica(partido, river, 1, 0, 90);

	            Torneo torneo = s.traerTorneoPorNombre("Clausura 2025");
	            torneo.agregarPartido(partido);

	            List<Ganador> ganadores = torneo.ganadoresEnFecha(LocalDate.of(2025, 4, 15));
	            for (Ganador g : ganadores) {
	                System.out.println("Ganador: " + g.getGanador().getNombre() +
	                                   " | Goles: " + g.getGoles() +
	                                   " | Fecha: " + g.getFecha());
	            }
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	    }
	}
