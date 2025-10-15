package test;

import modelo.Entrenador;
import modelo.Sistema;
import modelo.Equipo;
import modelo.Jugador;
import modelo.Partido;
import modelo.Torneo;
import java.time.LocalDate;

public class cargarDatos {
	public static void cargar(Sistema s) {

		// === ENTRENADORES ===
		Entrenador bianchi = s.agregarEntrenador("Carlos", "Bianchi", 12345678, LocalDate.of(1950, 4, 26), "4-4-2");
		Entrenador gallardo = s.agregarEntrenador("Marcelo", "Gallardo", 23456789, LocalDate.of(1976, 1, 18), "4-3-1-2");
		Entrenador gareca = s.agregarEntrenador("Ricardo", "Gareca", 34567890, LocalDate.of(1958, 2, 10), "4-4-2");
		Entrenador scaloni = s.agregarEntrenador("Lionel", "Scaloni", 45678901, LocalDate.of(1978, 5, 16), "4-3-3");

		// === EQUIPOS ===
		Equipo boca = s.agregarEquipo("Boca Juniors", bianchi, LocalDate.of(1905, 4, 3));
		Equipo river = s.agregarEquipo("River Plate", gallardo, LocalDate.of(1901, 5, 25));
		Equipo velez = s.agregarEquipo("Vélez Sarsfield", gareca, LocalDate.of(1910, 1, 1));
		Equipo racing = s.agregarEquipo("Racing Club", scaloni, LocalDate.of(1903, 3, 25));

		// === JUGADORES ===
		Jugador romero = s.agregarJugador("Sergio", "Romero", 101, LocalDate.of(1987, 2, 22), 1.92f, 85f, "Arquero", 1);
		Jugador rojo = s.agregarJugador("Marcos", "Rojo", 102, LocalDate.of(1990, 3, 20), 1.86f, 82f, "Defensor", 6);
		Jugador cavani = s.agregarJugador("Edinson", "Cavani", 103, LocalDate.of(1987, 2, 14), 1.84f, 78f, "Delantero", 10);

		Jugador armani = s.agregarJugador("Franco", "Armani", 201, LocalDate.of(1986, 10, 16), 1.89f, 83f, "Arquero", 1);
		Jugador enzo = s.agregarJugador("Enzo", "Perez", 202, LocalDate.of(1986, 2, 22), 1.78f, 75f, "Mediocampista", 8);
		Jugador borja = s.agregarJugador("Miguel", "Borja", 203, LocalDate.of(1993, 1, 26), 1.83f, 80f, "Delantero", 9);

		Jugador pratto = s.agregarJugador("Lucas", "Pratto", 301, LocalDate.of(1988, 6, 4), 1.87f, 82f, "Delantero", 9);
		Jugador godin = s.agregarJugador("Diego", "Godín", 302, LocalDate.of(1986, 2, 16), 1.85f, 78f, "Defensor", 2);
		Jugador almada = s.agregarJugador("Thiago", "Almada", 303, LocalDate.of(2001, 4, 26), 1.71f, 68f, "Mediocampista", 10);

		Jugador arias = s.agregarJugador("Gabriel", "Arias", 401, LocalDate.of(1987, 9, 13), 1.88f, 82f, "Arquero", 1);
		Jugador sigali = s.agregarJugador("Leonardo", "Sigali", 402, LocalDate.of(1987, 5, 29), 1.82f, 78f, "Defensor", 2);
		Jugador rojas = s.agregarJugador("Matías", "Rojas", 403, LocalDate.of(1995, 11, 3), 1.80f, 75f, "Mediocampista", 10);

		// === ASIGNAR JUGADORES A EQUIPOS ===
		boca.agregarJugador(romero);
		boca.agregarJugador(rojo);
		boca.agregarJugador(cavani);

		river.agregarJugador(armani);
		river.agregarJugador(enzo);
		river.agregarJugador(borja);

		velez.agregarJugador(pratto);
		velez.agregarJugador(godin);
		velez.agregarJugador(almada);

		racing.agregarJugador(arias);
		racing.agregarJugador(sigali);
		racing.agregarJugador(rojas);

		
		Torneo clausura = s.crearTorneo("Clausura 2025", 
                LocalDate.of(2025, 4, 1), 
                LocalDate.of(2025, 8, 1));


		clausura.agregarEquipo(boca);
		clausura.agregarEquipo(racing);
		clausura.agregarEquipo(river);
		clausura.agregarEquipo(velez);
		
		
		Partido p1 = s.agregarPartido(
                LocalDate.of(2025, 4, 15),
                boca,
                river,
                "La Bombonera"
        );
        s.agregarEstadistica(p1, boca,romero, 2, 1, 90);
        s.agregarEstadistica(p1, river,enzo, 1, 0, 90);
        clausura.agregarPartido(p1);

        Partido p2 = s.agregarPartido(
                LocalDate.of(2025, 4, 22),
                racing,
                velez,
                "Cilindro de Avellaneda"
        );
        s.agregarEstadistica(p2, racing, rojas, 1, 1, 88);
        s.agregarEstadistica(p2, racing, sigali, 0, 0, 90);
        s.agregarEstadistica(p2, velez, pratto, 1, 0, 90);
        s.agregarEstadistica(p2, velez, almada, 0, 1, 85);
        clausura.agregarPartido(p2);

        Partido p3 = s.agregarPartido(
                LocalDate.of(2025, 5, 1),
                river,
                velez,
                "Monumental"
        );
        s.agregarEstadistica(p3, river, borja, 2, 0, 89);
        s.agregarEstadistica(p3, river, enzo, 0, 2, 90);
        s.agregarEstadistica(p3, velez, almada, 1, 0, 90);
        clausura.agregarPartido(p3);

        
        Partido p4 = s.agregarPartido(
                LocalDate.of(2025, 5, 8),
                boca,
                racing,
                "La Bombonera"
        );
        s.agregarEstadistica(p4, boca, cavani, 2, 0, 90);
        s.agregarEstadistica(p4, boca, rojo, 0, 1, 90);
        s.agregarEstadistica(p4, racing, rojas, 1, 0, 90);
        clausura.agregarPartido(p4);

        
        Partido p5 = s.agregarPartido(
                LocalDate.of(2025, 5, 15),
                river,
                boca,
                "Monumental"
        );
        s.agregarEstadistica(p5, river, borja, 1, 0, 90);
        s.agregarEstadistica(p5, river, enzo, 0, 1, 90);
        s.agregarEstadistica(p5, boca, cavani, 1, 0, 90);
        clausura.agregarPartido(p5);


	}
}
