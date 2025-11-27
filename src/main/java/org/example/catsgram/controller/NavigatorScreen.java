package org.example.catsgram.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//class Context { // создаём класс для хранения объектов зависимостей
//    static MapService MAP_SERVICE = new SomeMapService();
//    static LocationService LOCATION_SERVICE = new GpsService();
//}
interface LocationService {
     public static void print(){
     }
}

interface MapService {
}

@Component
class GoogleMapService implements MapService {
// поля и методы
}

@Component
class GpsService implements LocationService {
// ...
}

@Component
public class NavigatorScreen {
    MapService mapService;
    LocationService locationService;

    @Autowired
    public NavigatorScreen(
            MapService mapService,
            LocationService locationService) {
        this.mapService = mapService;
        this.locationService = locationService;
    }
    // методы, использующие mapService и locationService

//    public void updateScreen() {
//        Coordinates coordinates =
//                locationService.getCoordinates();
//        MapData map = mapService.getMap(coordinates, zoomLevel);
//// дальше: вывести карту на экран
//    }
}
