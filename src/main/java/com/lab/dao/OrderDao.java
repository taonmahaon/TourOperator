package com.lab.dao;

import com.lab.domain.Client;
import com.lab.domain.Order;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderDao implements OrdersDao{
    CommonConnection commonConnection = new CommonConnection();
    @Override
    public Order get(Integer id) {
        try (var conn = commonConnection.connect();
             var stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(String.format("SELECT * FROM ORDERS WHERE ID = '%s'", id)))
        {
            rs.next();
            return  new Order(rs.getInt("id"),
                    rs.getInt("client_id"),
                    rs.getInt("tour_id"),
                    rs.getInt("duration"),
                    rs.getInt("total_cost"),
                    rs.getString("uid"));
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public Order create(Order order) {
        try (Connection conn = commonConnection.connect();
             var stmt = conn.createStatement();
        )
        {   stmt.executeUpdate(String.format("INSERT INTO ORDERS (CLIENT_ID, TOUR_ID, DURATION, TOTAL_COST, UID) VALUES ('%s', '%s', '%s', '%s', '%s')",
                order.getClientId(), order.getTourId(), order.getDuration(), order.getTotalCost(), order.getUid()));
            ResultSet rs = stmt.executeQuery(String.format("SELECT * FROM ORDERS WHERE UID = '%s'", order.getUid()));
            rs.next();
            order.setId(rs.getInt("ID"));
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return order;
    }

    // TODO: in second sprint =)

    @Override
    public Order update(Order order) {
        return null;
    }

    @Override
    public Order delete(Integer id) {
        return null;
    }

    @Override
    public List<Order> getAll() {
        return null;
    }
}
