package models;

import models.record.CelestialObjectRecord;
import java.util.ArrayList;
import java.util.List;

public class CurrentCelestialObject {
    private static CurrentCelestialObject instance = null;
    private CelestialObjectRecord currentCelestialObject = null;
    private List<CurrentCelestialObjectChangeListener> listeners = new ArrayList<>();

    private CurrentCelestialObject() {}

    public static CurrentCelestialObject getInstance() {
        if (instance == null) {
            instance = new CurrentCelestialObject();
        }
        return instance;
    }

    // Observer pattern methods
    public interface CurrentCelestialObjectChangeListener {
        void onCelestialObjectChange();
    }

    public void addCurrentUserChangeListener(CurrentCelestialObjectChangeListener listener) {
        listeners.add(listener);
    }

    public void removeCurrentUserChangeListener(CurrentCelestialObjectChangeListener listener) {
        listeners.remove(listener);
    }

    public void notifyCelestialObjectChange() {
        for (CurrentCelestialObjectChangeListener listener : listeners) {
            listener.onCelestialObjectChange();
        }
    }
}