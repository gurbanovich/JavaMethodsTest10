package logic;

public class Pier {

	private final String number;
	private boolean hasShip;
	
	public Pier(String number) {
		this.number = number;
		this.hasShip = false;
	}

	public String getNumber() {
		return number;
	}

	public boolean getHasShip() {
		return hasShip;
	}

	public void setHasShip(boolean hasShip) {
		this.hasShip = hasShip;
	}

	public void toTakeShip(Ship ship) {
		setHasShip(true);
	}

	public void toSentShip() {
		setHasShip(false);
	}
}
