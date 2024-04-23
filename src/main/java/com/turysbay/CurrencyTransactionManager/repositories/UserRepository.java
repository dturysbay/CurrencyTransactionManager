package com.turysbay.CurrencyTransactionManager.repositories;

import com.turysbay.CurrencyTransactionManager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
