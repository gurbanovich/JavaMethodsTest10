package process;

import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import logic.Pier;
import logic.Port;
import logic.Ship;

public class PortFactory extends Thread {

	private LinkedList<Ship> ships;
	private Port port;
	private BlockingQueue<Ship> bq;

	public PortFactory(LinkedList<Ship> ships, Port port) {
		this.ships = ships;
		this.port = port;
		bq = new ArrayBlockingQueue<Ship>(port.getPiers().size());
	}

	public BlockingQueue<Ship> getBQ() {
		return bq;
	}

	public void setBQ(BlockingQueue<Ship> bq) {
		this.bq = bq;
	}

	@Override
	public void run() {
		System.out.println("The port has " + port.getCargoQ() + " conteners" + "and " + port.getCargoCapacity()
				+ " cargo capacity.");
		for (Ship s : ships) {
			try {
				if (s.getStandAtThePier() || s.getLoadUnloadComplete())
					break;
				System.out.println("The " + s.getNumber() + " has " + s.getLoadedCargo()
						+ " conteners for loading, and " + s.getUnloadedCargo() + " conteners for unloading.");
				bq.put(s);
				System.out.println(s.getNumber() + " input at the " + port.getNumber());
				if (port.isFreePier() == null)
					throw new NullPointerException("No free piers!");
				Pier pier = port.isFreePier();
				pier.toTakeShip(s);
				s.getStandAtThePier();
				PierFactory pf = new PierFactory(pier, port, s, this);
				System.out.println(s.getNumber() + " stand at the  " + pier.getNumber());
				pf.start();
			} catch (InterruptedException e) {
				System.err.println("Interrupted exception " + e);
			}
		}
	}

}
