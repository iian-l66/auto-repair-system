package service;

import exception.CpfAlreadyRegisteredException;
import exception.ClientNotFoundException;
import model.Client;
import repository.ClientRepository;

import java.util.stream.Collectors;

public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void addClient (Client client) {
        if (clientRepository.getClientMap().values().stream()
                .anyMatch(x -> x.getCpf().equals(client.getCpf())))
            throw new CpfAlreadyRegisteredException("this cpf already exists");

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
        return clientRepository.getClientMap().values().stream()
                .filter(x -> x.getCpf().equals(cpf)).findFirst().orElseThrow(
                        () -> new ClientNotFoundException("This cpf is not registered."));
    }

    public void removeClient (Long id) {
        if (!clientRepository.getClientMap().containsKey(id))
            throw new ClientNotFoundException("This id is not registered.");

        clientRepository.removeClient(id);
    }

    public void removeClient (String cpf) {
        clientRepository.removeClient(clientRepository.getClientMap().values().stream()
                .filter(x -> x.getCpf().equals(cpf)).findFirst().orElseThrow(
                        () -> new ClientNotFoundException("This cpf is not registered.")).getId());
    }
}
