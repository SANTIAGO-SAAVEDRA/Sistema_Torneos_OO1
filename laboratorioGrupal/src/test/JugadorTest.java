package test;
import modelo.Jugador;
import java.time.LocalDate;
public class JugadorTest {
	public static void main(String[] args) {
		try {
			Jugador palermo = new Jugador(1,"Martin","Palermo",12321312,LocalDate.of(1990, 12, 3),5f,3f,"Delantero",10);
			System.out.println(palermo);
		}
		catch(Exception error) {
			System.out.println(error.getMessage());
		}
		try {
			Jugador pepito = new Jugador(2,"Pepito","Malo",12321312,LocalDate.of(2015, 12, 3),5f,3f,"Delantero",10);
			System.out.println(pepito);
		}
		catch(Exception error) {
			System.out.println(error.getMessage());
		}
	}
}
