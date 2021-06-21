package com.lab.dao;

import com.lab.domain.Client;
import com.lab.domain.Tour;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class TourOperatorDao implements TourDao {

CommonConnection commonConnection = new CommonConnection();

    private String adminPass = "admin";
    String SQL = "SELECT * FROM tours";

    public String getAdminPass(){
        return adminPass;
    }

    @Override
    public Tour get(Integer id) {
        try (var conn = commonConnection.connect();
             var stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL))
        {
            Tour tour = null;
            while(rs.next()){
                if (rs.getInt("TOUR_ID") == id){
                    tour = new Tour(id,
                            rs.getString("COUNTRY") ,
                            rs.getString("TOUR_TYPE"),
                            rs.getInt("DAY_PRICE"),
                            rs.getInt("TICKETS_PRICE"),
                            rs.getString("HOTEL_TYPE"),
                            rs.getInt("HOTEL_PRICE"),
                            rs.getString("CITY"));
                }
            }
            return tour;
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
            return null;
    }

    @Override
    public List<Tour> getAll() {
        try (var conn = commonConnection.connect();
             var stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL))
        {
            var toursList = new ArrayList<Tour>();
            while(rs.next()){
                    Tour tour;
                    tour = new Tour(rs.getInt("TOUR_ID"),
                            rs.getString("COUNTRY"),
                            rs.getString("TOUR_TYPE"),
                            rs.getInt("DAY_PRICE"),
                            rs.getInt("TICKETS_PRICE"),
                            rs.getString("HOTEL_TYPE"),
                            rs.getInt("HOTEL_PRICE"),
                            rs.getString("CITY"));
                toursList.add(tour);
                }
            conn.close();
            return toursList;
            }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
    }
        return new ArrayList<>();
  }

    @Override
    public Tour update(Tour tour) {
        try (var conn = commonConnection.connect();
             var stmt = conn.createStatement();) {
            ResultSet rs = stmt.executeQuery(String.format("SELECT * FROM TOURS WHERE TOUR_ID = '%s'", tour.getId()));
            rs.next();
            stmt.executeUpdate(String.format("UPDATE INTO CLIENTS (COUNTRY, TOUR_TYPE, DAY_PRICE, TICKETS_PRICE, HOTEL_TYPE, HOTEL_PRICE, CITY) " +
                            "VALUES ('%s','%s','%s','%s','%s','%s','%s')",
                    tour.getCountry(), tour.getTourType(), tour.getDayPrice(), tour.getTicketPrice(), tour.getHotelType(), tour.getHotelPrice(), tour.getCity()));
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return tour;
    }

    @Override
    public Tour create(Tour tour) {
        try (var conn = commonConnection.connect();
             var stmt = conn.createStatement();) {
            ResultSet rs = stmt.executeQuery(String.format("SELECT * FROM TOURS WHERE COUNTRY = '%s' and TOUR_TYPE = '%s' and HOTEL_TYPE = '%s'",
                    tour.getCountry(), tour.getTourType(), tour.getHotelType()));
            if (!rs.next()){
                stmt.executeUpdate(String.format("INSERT INTO TOURS (COUNTRY, TOUR_TYPE, DAY_PRICE, TICKETS_PRICE, HOTEL_TYPE, HOTEL_PRICE, CITY) " +
                        "VALUES ('%s','%s','%s','%s','%s','%s','%s')",
                        tour.getCountry(),tour.getTourType(),tour.getDayPrice(),tour.getTicketPrice(),tour.getHotelType(),tour.getHotelPrice(),tour.getCity()));
                rs = stmt.executeQuery(String.format("SELECT * FROM TOURS WHERE COUNTRY = '%s' and TOUR_TYPE = '%s' and HOTEL_TYPE = '%s'",
                        tour.getCountry(), tour.getTourType(), tour.getHotelType()));
                rs.next();}
            tour.setId(rs.getInt("ID"));
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return tour;
    }

    @Override
    public Tour delete(Integer id) {
        Tour tour = null;
        try (var conn = commonConnection.connect();
             var stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery((String.format("SELECT * FROM TOURS WHERE ID = '%s'", id))))
        {   rs.next();
            tour = new Tour(rs.getInt("TOUR_ID"),
                    rs.getString("COUNTRY"),
                    rs.getString("TOUR_TYPE"),
                    rs.getInt("DAY_PRICE"),
                    rs.getInt("TICKETS_PRICE"),
                    rs.getString("HOTEL_TYPE"),
                    rs.getInt("HOTEL_PRICE"),
                    rs.getString("CITY"));
            stmt.executeQuery((String.format("DELETE FROM TOURS WHERE ID = '%s'", id)));
            return tour;
        }

        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return tour;
    }

}
