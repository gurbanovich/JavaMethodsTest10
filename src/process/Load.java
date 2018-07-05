package process;

import java.util.concurrent.Phaser;

import logic.Port;
import logic.Ship;

public class Load extends Thread {

	private Phaser phaser;
	private Port port;
	private Ship ship;

	public Load(Phaser phaser, Port port, Ship ship) {
		this.phaser = phaser;
		this.port = port;
		this.ship = ship;
		this.phaser.register();
	}

	@Override
	public void run() {
		System.out.println("The " + ship.getNumber() + " start being loaded");
		while (!ship.isLoaded()) {
			try {
				if (ship.loadContainer()) {
					Thread.sleep(5000);
					port.setCargoQ(port.getCargoQ() - 1);
				} else
					Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.err.println("Interrupted exception " + e);
			}
		}
		System.out.println("The " + ship.getNumber() + " has been loaded " + ship.getLoadedCargo() + " conteners .");
		phaser.arriveAndAwaitAdvance();
		System.out.println("The " + ship.getNumber() + " finish being loaded");
	}
}
