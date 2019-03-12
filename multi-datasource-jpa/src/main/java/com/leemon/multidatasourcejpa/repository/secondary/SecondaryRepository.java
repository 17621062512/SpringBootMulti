package com.leemon.multidatasourcejpa.repository.secondary;

import com.leemon.multidatasourcejpa.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecondaryRepository extends JpaRepository<User,Long> {

}
