package service;

import exception.CpfAlreadyRegisteredException;
import exception.ClientNotFoundException;
import model.Client;
import repository.ClientRepository;

public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void addClient (Client client) {
        if (clientRepository.getClientMap().containsKey(client.getId()))
            throw new CpfAlreadyRegisteredException("This cpf already registered!");

        clientRepository.addClient(client);
    }

    public void listClients () {
        if (clientRepository.getClientMap().isEmpty())
            System.out.println("No clients registered yet.");
        else
            clientRepository.listClients();
    }

    public Client getClient (Long id) {
        if (!clientRepository.getClientMap().containsKey(id))
            throw new ClientNotFoundException("This id is not registered.");

        return clientRepository.getClient(id);
    }

    public Client getClient (String cpf) {
        Client client = clientRepository.getClientMap().values().stream()
                .filter(x -> x.getCpf().equals(cpf)).findFirst().orElse(null);

        if (client == null)
            throw new ClientNotFoundException("This cpf is not registered.");

        return client;
    }

    public void removeClient (Long id) {
        if (!clientRepository.getClientMap().containsKey(id))
            throw new ClientNotFoundException("This cpf is not registered.");

        clientRepository.removeClient(id);
    }
}
