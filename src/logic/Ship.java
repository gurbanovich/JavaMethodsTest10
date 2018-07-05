package logic;

public class Ship {

	private final String number;
	private int unloadedCargo;
	private int isLoadedCargo;
	private final int loadedCargo;
	private final int cargoCapacity;
	private boolean standAtThePier;
	private boolean loadUnloadComplete;

	public Ship(String number, int unloadedCargo, int loadedCargo, int cargoCapacity) {
		this.number = number;
		this.unloadedCargo = unloadedCargo;
		this.loadedCargo = loadedCargo;
		this.isLoadedCargo = 0;
		this.cargoCapacity = cargoCapacity;
		this.standAtThePier = false;
		this.loadUnloadComplete = false;
	}

	public String getNumber() {
		return number;
	}

	public int getUnloadedCargo() {
		return unloadedCargo;
	}

	public int getCargoCapacity() {
		return cargoCapacity;
	}

	public int getLoadedCargo() {
		return loadedCargo;
	}

	public int getIsLoadedCargo() {
		return isLoadedCargo;
	}

	public boolean getStandAtThePier() {
		return standAtThePier;
	}

	public boolean getLoadUnloadComplete() {
		return loadUnloadComplete;
	}

	public void setUnloadedCargo(int unloadedCargo) {
		this.unloadedCargo = unloadedCargo;
	}

	public void setIsLoadedCargo(int isLoadedCargo) {
		this.isLoadedCargo = isLoadedCargo;
	}

	public void setStandAtThePier(boolean standAtThePier) {
		this.standAtThePier = standAtThePier;
	}

	public void setLoadUnloadCmplete(boolean loadUnloadComplete) {
		this.loadUnloadComplete = loadUnloadComplete;
	}

	public boolean loadContainer() {
		if (getIsLoadedCargo() + getUnloadedCargo() < getCargoCapacity()) {
			setIsLoadedCargo(getIsLoadedCargo() + 1);
			return true;
		}
		return false;
	}

	public boolean unloadContainer() {
		if (getLoadedCargo() + getUnloadedCargo() > 0) {
			setUnloadedCargo(getUnloadedCargo() - 1);
			return true;
		}
		return false;
	}

	public boolean isLoaded() {
		return getIsLoadedCargo() == getLoadedCargo();
	}

	public boolean isUnloaded() {
		return getUnloadedCargo() == 0;
	}

	public void finishLoadUnloadProcess() {
		if ((getUnloadedCargo() == 0) && (getIsLoadedCargo() == getLoadedCargo()))
			setLoadUnloadCmplete(true);
	}

}
