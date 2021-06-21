package com.lab.domain;

public class Tour {

  private Integer id;
  private String country;
  private String tourType;
  private Integer dayPrice;
  private Integer ticketPrice;
  private String hotelType;
  private Integer hotelPrice;
  private String city;


  public Tour(Integer id,
          String country,
          String tourType,
          Integer dayPrice,
          Integer ticketPrice,
          String hotelType,
          Integer hotelPrice,
          String city) {
    this.id = id;
    this.country = country;
    this.tourType = tourType;
    this.dayPrice = dayPrice;
    this.ticketPrice = ticketPrice;
    this.hotelType = hotelType;
    this.hotelPrice = hotelPrice;
    this.city = city;
  }

  public Tour(
              String country,
              String tourType,
              Integer dayPrice,
              Integer ticketPrice,
              String hotelType,
              Integer hotelPrice,
              String city) {
    this.country = country;
    this.tourType = tourType;
    this.dayPrice = dayPrice;
    this.ticketPrice = ticketPrice;
    this.hotelType = hotelType;
    this.hotelPrice = hotelPrice;
    this.city = city;
  }



  public String toString() {
    return id + " " + country + " " + city  + " " + tourType + " " + hotelType;
  }

  public Integer getId() {
    return id;
  }
  public void setId(Integer id){
    this.id = id;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getTourType() {
    return tourType;
  }

  public void setTourType(String tourType) {
    this.tourType = tourType;
  }

  public Integer getDayPrice() {
    return dayPrice;
  }

  public void setDayPrice(Integer dayPrice) {
    this.dayPrice = dayPrice;
  }

  public Integer getTicketPrice() {
    return ticketPrice;
  }

  public void setTicketPrice(Integer ticketPrice) {
    this.ticketPrice = ticketPrice;
  }

  public String getHotelType() {
    return hotelType;
  }

  public void setHotelType(String hotelType) {
    this.hotelType = hotelType;
  }

  public Integer getHotelPrice() {
    return hotelPrice;
  }

  public void setHotelPrice(Integer hotelPrice) {
    this.hotelPrice = hotelPrice;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }


}
