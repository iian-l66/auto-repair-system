package service;

import exception.CpfAlreadyRegisteredException;
import exception.CpfNotFoundException;
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

    public void listClients () {
        if (clientRepository.getClientMap().isEmpty())
            System.out.println("No clients registered yet.");
        else
            clientRepository.listClients();
    }

    public Client getClient (String cpf) {
        if (!clientRepository.getClientMap().containsKey(cpf))
            throw new CpfNotFoundException("This cpf is not registered.");

        return clientRepository.getClient(cpf);
    }

    public void removeClient (String cpf) {
        if (!clientRepository.getClientMap().containsKey(cpf))
            throw new CpfNotFoundException("This cpf is not registered.");

        clientRepository.removeClient(cpf);
    }
}
