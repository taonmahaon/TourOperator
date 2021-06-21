package com.lab.console;

import com.lab.domain.Tour;
import com.lab.service.TourService;

public class TourConsoleIO {
    TourService tourService = new TourService();

    public String getPass(){
        return tourService.getPass();
    }

    public StringBuilder tourList(){
        var forReturn = new StringBuilder();
        for (Tour line:tourService.getAll()) {
            forReturn.append(line).append("\n");
        }
        return forReturn;
    }

    public Tour get(Integer id){
        return tourService.get(id);
    }

    public void outputTour(Integer id) {
        System.out.println(tourService.get(id));
    }

    // TODO: another CLI methods in second sprint

}
