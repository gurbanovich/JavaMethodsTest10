package process;

import java.util.concurrent.Phaser;

import logic.Port;
import logic.Ship;

public class Unload extends Thread {

	private Phaser phaser;
	private Port port;
	private Ship ship;

	public Unload(Phaser phaser, Port port, Ship ship) {
		this.phaser = phaser;
		this.port = port;
		this.ship = ship;
		this.phaser.register();
	}

	@Override
	public void run() {
		System.out.println("The " + ship.getNumber() + " start being unloaded");
		while (!ship.isUnloaded()) {
			try {
				if (port.isCapacity()) {
					ship.unloadContainer();
					Thread.sleep(5000);
					port.setCargoQ(port.getCargoQ() + 1);
				} else
					Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.err.println("Interrupted exception " + e);
			}
		}
		System.out.println("The " + ship.getNumber() + " has " + ship.getUnloadedCargo() + " conteners for unloading.");
		phaser.arriveAndAwaitAdvance();
		System.out.println("The " + ship.getNumber() + " finish being unloaded");
	}

}
