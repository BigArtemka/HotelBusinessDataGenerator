package ru.filimonov.hotelbusinessdatagenerator.service;

import org.springframework.stereotype.Service;
import ru.filimonov.hotelbusinessdatagenerator.domain.Client;
import ru.filimonov.hotelbusinessdatagenerator.repository.ClientRepository;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    public int count() {
        return (int) clientRepository.count();
    }

    public void createClient(Client client) {
        clientRepository.save(client);
    }

    public Client findById(Integer id) {
        return clientRepository.findById(id).orElse(null);
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }
}
