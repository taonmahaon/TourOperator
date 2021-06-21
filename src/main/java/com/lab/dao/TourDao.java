package com.lab.dao;

import com.lab.domain.Tour;
import java.util.List;

public interface TourDao extends CrudDao<Tour> {

    String getAdminPass();

}
