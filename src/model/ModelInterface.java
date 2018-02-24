package model;

import java.util.Observer;

import javafx.beans.InvalidationListener;

public interface ModelInterface {
	public void registerObserver(Observer o);

	public void removeObserver(Observer o);
}
