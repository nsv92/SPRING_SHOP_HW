package ru.gb.spring_shop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.gb.spring_shop.roles.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

    Role findOneByName(String roleName);

}
