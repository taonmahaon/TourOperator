package com.lab.dao;

import com.lab.domain.Tour;
import java.util.List;

public interface CrudDao<T> {

  T get(Integer id);

  List<T> getAll();

  T update(T object);

  T create(T object);

  T delete(Integer id);

}
