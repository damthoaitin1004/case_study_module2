package reponsitory;

import model.fancility.Facility;
import model.fancility.House;

import java.util.List;
import java.util.Map;

public interface IFacilityRepository {
    List<Facility> getFacilityList();
    void removeVilla(Facility facility);
    void removeRoom(Facility facility);
    void removeHouse(Facility facility);
    void addVilla(Facility facility);
    void addHouse(Facility facility);
    void addRoom(Facility facility);
    Facility getByCode(String code);
}
