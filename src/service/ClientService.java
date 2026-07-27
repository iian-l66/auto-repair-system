package service;

import exception.CarAlreadyRegisteredException;
import exception.CpfAlreadyRegisteredException;
import exception.ClientNotFoundException;
import model.Car;
import model.Client;
import repository.ClientRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ClientService implements CrudService<Client>, CpfSearchable<Client> {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void add (Client client) {
        if (clientRepository.getClientMap().values().stream()
                .anyMatch(x -> x.getCpf().equals(client.getCpf())))
            throw new CpfAlreadyRegisteredException("this cpf already exists");

        clientRepository.addClient(client);
    }

    @Override
    public void list () {
        if (clientRepository.getClientMap().isEmpty())
            System.out.println("No clients registered yet.");
        else
            clientRepository.listClients();
    }


    public void addCar (Client client, Car car) {
        if (client.listCars().stream().anyMatch(c -> c.
                getPlate().equals(car.getPlate())))
            throw new CarAlreadyRegisteredException("This plate already registered.");

        client.addCar(car);
    }

    @Override
    public Client get(Long id) {
        if (!clientRepository.getClientMap().containsKey(id))
            throw new ClientNotFoundException("This id is not registered.");

        return clientRepository.getClient(id);
    }

    @Override
    public Client get(String cpf) {
        return clientRepository.getClientMap().values().stream()
                .filter(x -> x.getCpf().equals(cpf)).findFirst().orElseThrow(
                        () -> new ClientNotFoundException("This cpf is not registered."));
    }

    @Override
    public void remove (Long id) {
        if (!clientRepository.getClientMap().containsKey(id))
            throw new ClientNotFoundException("This id is not registered.");

        clientRepository.removeClient(id);
    }

    @Override
    public void remove (String cpf) {
        clientRepository.removeClient(clientRepository.getClientMap().values().stream()
                .filter(x -> x.getCpf().equals(cpf)).findFirst().orElseThrow(
                        () -> new ClientNotFoundException("This cpf is not registered.")).getId());
    }
}
