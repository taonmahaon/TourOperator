package com.lab.dao;

import com.lab.domain.Client;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDao implements ClientsDao{
    CommonConnection commonConnection = new CommonConnection();
    @Override
    public Client get(Integer id) {
        try (var conn = commonConnection.connect();
             var stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(String.format("SELECT * FROM CLIENTS WHERE ID = '%s'", id)))
        {
            rs.next();
            return  new Client(rs.getInt("id"), rs.getString("name"), rs.getString("email"));
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Client> getAll() {
        try (var conn = commonConnection.connect();
             var stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM CLIENTS")) {
            var clientList = new ArrayList<Client>();
            while(rs.next()){
                Client client;
                client = new Client(rs.getInt("ID"),
                        rs.getString("NAME"),
                        rs.getString("EMAIL"));
                clientList.add(client);
            }

            return clientList;
        }

        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return new ArrayList<>();
    }


    @Override
    public Client update(Client client) {
        try (var conn = commonConnection.connect();
             var stmt = conn.createStatement();) {
            ResultSet rs = stmt.executeQuery(String.format("SELECT * FROM CLIENTS WHERE ID = '%s'", client.getId()));
            rs.next();
            stmt.executeUpdate(String.format("UPDATE INTO CLIENTS (NAME, EMAIL) VALUES ('%s', '%s')", client.getName(),client.getEmail()));
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return client;
    }


    @Override
    public Client create(Client client) {
        try (var conn = commonConnection.connect();
             var stmt = conn.createStatement();) {
            ResultSet rs = stmt.executeQuery(String.format("SELECT * FROM CLIENTS WHERE NAME = '%s' and email = '%s'", client.getName(), client.getEmail()));
            if (!rs.next()){
            stmt.executeUpdate(String.format("INSERT INTO CLIENTS (NAME, EMAIL) VALUES ('%s', '%s')", client.getName(),client.getEmail()));
            rs = stmt.executeQuery(String.format("SELECT * FROM CLIENTS WHERE NAME = '%s' and email = '%s'", client.getName(), client.getEmail()));
            rs.next();}
            client.setId(rs.getInt("ID"));
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    return client;
    }

    @Override
    public Client delete(Integer id) {
        Client client = null;
        try (var conn = commonConnection.connect();
             var stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery((String.format("SELECT * FROM CLIENTS WHERE ID = '%s'", id))))
        {   rs.next();
                client = new Client(rs.getInt("ID"),
                    rs.getString("NAME"),
                    rs.getString("EMAIL"));
                stmt.executeQuery((String.format("DELETE FROM CLIENTS WHERE ID = '%s'", id)));
            return client;
        }

        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return client;
    }
}
