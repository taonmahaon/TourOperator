package com.lab.service;

import com.lab.dao.ClientDao;
import com.lab.dao.ClientsDao;
import com.lab.domain.Client;

public class ClientService {
    ClientsDao clientsDao = new ClientDao();

    public Client create(Client client){
       return clientsDao.create(client);
    }

    public Client get(Integer clientId){
        return clientsDao.get(clientId);
    }

    // TODO: another services in second sprint
}
