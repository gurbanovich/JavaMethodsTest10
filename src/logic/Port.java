package logic;

import java.util.LinkedList;
import java.util.List;

public class Port {

	private final String number;
	private int cargoQ;
	private final int cargoCapacity;
	private List<Pier> piers;

	public Port(String number, int cargoQ, int cargoCapacity) {
		this.number = number;
		this.cargoQ = cargoQ;
		this.cargoCapacity = cargoCapacity;
		this.piers = new LinkedList<Pier>();
	}

	public String getNumber() {
		return number;
	}

	public int getCargoQ() {
		return cargoQ;
	}

	public int getCargoCapacity() {
		return cargoCapacity;
	}

	public List<Pier> getPiers() {
		return piers;
	}

	public void setCargoQ(int cargoQ) {
		this.cargoQ = cargoQ;
	}

	public boolean isCapacity() {
		if (getCargoQ() < getCargoCapacity())
			return true;
		return false;
	}

	public Pier isFreePier() {
		Pier freePier = null;
		flag: for (Pier p : getPiers()) {
			if (!p.getHasShip()) {
				freePier = p;
				break flag;
			}
		}
		return freePier;
	}

}
