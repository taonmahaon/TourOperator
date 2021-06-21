package com.lab.console;

import com.lab.domain.Client;
import com.lab.service.ClientService;

public class ClientConsoleIO {
    ClientService clientService = new ClientService();

    public Client create(Client client){
        return clientService.create(client);
    }

    // TODO: another CLI methods in second sprint
}
