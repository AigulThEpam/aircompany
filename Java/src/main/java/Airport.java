import com.models.MilitaryType;
import com.planes.ExperimentalPlane;
import com.planes.MilitaryPlane;
import com.planes.PassengerPlane;
import com.planes.Plane;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// version: 1.1
// made by Vitali Shulha
// 4-Jan-2019

public class Airport {
    private List<? extends Plane> planes;

    public List<PassengerPlane> getPassengerPlane() {
        List<? extends Plane> l = this.planes;
        return l.stream()
                .filter(PassengerPlane.class::isInstance)
                .map(PassengerPlane.class::cast)
                .collect(Collectors.toList());
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        return planes.stream()
                .filter(MilitaryPlane.class::isInstance)
                .map(MilitaryPlane.class::cast)
                .collect(Collectors.toList());
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = getPassengerPlane();

        return passengerPlanes.stream()
                .max(Comparator.comparing(PassengerPlane::getPassengersCapacity))
                .orElse(null);
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();

        return militaryPlanes.stream()
                .filter(plane -> plane.getType()== MilitaryType.TRANSPORT)
                .collect(Collectors.toList());
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();

        return militaryPlanes.stream()
                .filter(plane -> plane.getType()== MilitaryType.BOMBER)
                .collect(Collectors.toList());
    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        return planes.stream()
                .filter(ExperimentalPlane.class::isInstance)
                .map(ExperimentalPlane.class::cast)
                .collect(Collectors.toList());
    }

    public Airport sortByMaxDistance() {
        Collections.sort(planes, (Comparator<Plane>) (o1, o2) -> o1.getMaxFlightDistance() - o2.getMaxFlightDistance());
        return this;
    }


    public Airport sortByMaxSpeed() {
        Collections.sort(planes, (Comparator<Plane>) (o1, o2) -> o1.getMaxSpeed() - o2.getMaxSpeed());
        return this;
    }

    public Airport sortByMaxLoadCapacity() {
        Collections.sort(planes, (Comparator<Plane>) (o1, o2) -> o1.getMaxLoadCapacity() - o2.getMaxLoadCapacity());
        return this;
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    @Override
    public String toString() {
        return "Airport{" + "Planes=" + planes.toString() + '}';
    }

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

}