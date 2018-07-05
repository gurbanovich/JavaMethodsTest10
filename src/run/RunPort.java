package run;

import java.util.LinkedList;

import logic.Pier;
import logic.Port;
import logic.Ship;
import process.PortFactory;

public class RunPort {

	public static void main(String[] args) {
		Port port = new Port("my Port", 55, 60);

		port.getPiers().add(new Pier("pier1"));
		port.getPiers().add(new Pier("pier2"));
		port.getPiers().add(new Pier("pier3"));

		LinkedList<Ship> myShips = new LinkedList<Ship>();

		myShips.add(new Ship("ship1", 12, 16, 18));
		myShips.add(new Ship("ship2", 7, 5, 10));
		myShips.add(new Ship("ship3", 14, 10, 14));
		myShips.add(new Ship("ship4", 18, 20, 21));
		myShips.add(new Ship("ship5", 15, 15, 18));
		myShips.add(new Ship("ship6", 7, 16, 18));
		myShips.add(new Ship("ship7", 12, 3, 12));

		PortFactory pf = new PortFactory(myShips, port);
		pf.start();

		System.out.println("The port has "+port.getCargoQ()+" conteners");
		
	}

}
