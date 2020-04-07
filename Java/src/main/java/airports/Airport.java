package airports;

import planes.ExperimentalPlane;
import models.MilitaryType;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collection;
import java.util.logging.Logger;

public class Airport {
  private List<? extends Plane> planes;

  public Airport(List<? extends Plane> planes) {
    this.planes = planes;
  }

  public List<PassengerPlane> getPassengerPlanes() {
    List<PassengerPlane> passengerPlaneList = new ArrayList<>();
    for (Plane plane : planes) {
      if (plane instanceof PassengerPlane) {
        passengerPlaneList.add((PassengerPlane) plane);
      }
    }
    return passengerPlaneList;
  }

  public List<MilitaryPlane> getMilitaryPlanes() {
    List<MilitaryPlane> militaryPlaneList = new ArrayList<>();
    for (Plane plane : planes) {
      if (plane instanceof MilitaryPlane) {
        militaryPlaneList.add((MilitaryPlane) plane);
      }
    }
    return militaryPlaneList;
  }

  public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
    List<PassengerPlane> passengerPlanes = getPassengerPlanes();
    PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);
    for (PassengerPlane passengerPlane : passengerPlanes) {
      if (passengerPlane.getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
        planeWithMaxCapacity = passengerPlane;
      }
    }
    return planeWithMaxCapacity;
  }

  public List<MilitaryPlane> getTransportMilitaryPlanes() {
    List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();
    List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
    for (MilitaryPlane plane : militaryPlanes) {
      if (plane.getType() == MilitaryType.TRANSPORT) {
        transportMilitaryPlanes.add(plane);
      }
    }
    return transportMilitaryPlanes;
  }

  public List<MilitaryPlane> getBomberMilitaryPlanes() {
    List<MilitaryPlane> bomberMilitaryPlanes = new ArrayList<>();
    List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
    for (MilitaryPlane plane : militaryPlanes) {
      if (plane.getType() == MilitaryType.BOMBER) {
        bomberMilitaryPlanes.add(plane);
      }
    }
    return bomberMilitaryPlanes;
  }

  public List<ExperimentalPlane> getExperimentalPlanes() {
    List<ExperimentalPlane> experimentalPlanes = new ArrayList<>();
    for (Plane plane : planes) {
      if (plane instanceof ExperimentalPlane) {
        experimentalPlanes.add((ExperimentalPlane) plane);
      }
    }
    return experimentalPlanes;
  }

  public Airport sortByMaxDistance() {
    planes.sort(Comparator.comparingInt(Plane::getMaxFlightDistance));
    return this;
  }

  public Airport sortByMaxSpeed() {
    planes.sort(Comparator.comparingInt(Plane::getMaxSpeed));
    return this;
  }

  public Airport sortByMaxLoadCapacity() {
    planes.sort(Comparator.comparingInt(Plane::getMaxLoadCapacity));
    return this;
  }

  public List<Plane> getPlanes() {
    return (List<Plane>) planes;
  }

  public void logCollectionContent(Collection<Plane> collection) {
    Logger log = Logger.getLogger(Airport.class.getName());
    for (Plane plane : collection) log.info("Processed" + plane);
  }

  @Override
  public String toString() {
    return "airports.Airport{" +
        "Planes=" + planes.toString() +
        '}';
  }
}
