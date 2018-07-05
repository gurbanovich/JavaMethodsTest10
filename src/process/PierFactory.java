package process;

import java.util.concurrent.Phaser;

import logic.Pier;
import logic.Port;
import logic.Ship;

public class PierFactory extends Thread {

	private Pier pier;
	private Port port;
	private Ship ship;
	private PortFactory pf;
	private Phaser phaser;

	public PierFactory(Pier pier, Port port, Ship ship, PortFactory pf) {
		this.pier = pier;
		this.port = port;
		this.ship = ship;
		this.pf = pf;
		this.phaser = new Phaser();
		this.phaser.register();
	}

	@Override
	public void run() {
		try {
			new Unload(phaser, port, ship).start();
			new Load(phaser, port, ship).start();
			phaser.arriveAndAwaitAdvance();
			ship.finishLoadUnloadProcess();
			phaser.arriveAndDeregister();
			pier.toSentShip();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.err.println("Interrupted exception " + e);
		}
		System.out.println("The  " + pier.getNumber() + " sent the " + ship.getNumber());
		pf.getBQ().poll();
		System.out.println("The " + ship.getNumber() + " output from " + "the  " + port.getNumber());
	}

}
