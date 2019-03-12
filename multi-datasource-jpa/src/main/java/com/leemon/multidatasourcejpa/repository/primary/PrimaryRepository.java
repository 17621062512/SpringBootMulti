package com.leemon.multidatasourcejpa.repository.primary;

import com.leemon.multidatasourcejpa.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrimaryRepository extends JpaRepository<User,Long> {

    User findUserByName(String name);

}
