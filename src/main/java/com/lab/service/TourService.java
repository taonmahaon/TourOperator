package com.lab.service;

import com.lab.dao.TourOperatorDao;
import com.lab.domain.Tour;

import java.util.List;

public class TourService {

    TourOperatorDao tourOperatorDao = new TourOperatorDao();


    public String getPass(){
        return tourOperatorDao.getAdminPass();
    }

    public Tour get(Integer id) {
        return tourOperatorDao.get(id);
    }

    public List<Tour> getAll(){
        return tourOperatorDao.getAll();
    }

    // TODO: another services in second sprint

}
