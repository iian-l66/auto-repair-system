package service;

import exception.CpfAlreadyRegisteredException;
import model.Client;
import repository.ClientRepository;

public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void addClient (Client client) {
        if (clientRepository.getClientMap().containsKey(client.getCpf()))
            throw new CpfAlreadyRegisteredException("This cpf already registered!");

        clientRepository.addClient(client);
    }
}
