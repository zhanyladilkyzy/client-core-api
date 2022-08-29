package kz.dar.academy.backend.repository;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

public interface ClientRepository extends CrudRepository<ClientEntity, String> {
    ClientEntity getClientEntityByClientId(String clientId);

    @Transactional
    void deleteClientEntityById(Long id);

}
