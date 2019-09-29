package com.poc.FinancialManager.userDao;

import com.poc.FinancialManager.model.UserProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface for JPA operations on UserProfile model.
 */
@Repository
public interface UserDaoRepository  extends CrudRepository<UserProfile, Integer> {
}
