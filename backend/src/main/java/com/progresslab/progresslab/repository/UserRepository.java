package com.progresslab.progresslab.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.progresslab.progresslab.model.User;

/*
 * USER REPOSITORY 
 * 
 * When spring boot starts:
 * 1. Spring data discovers this repository interface.
 * 2. We do not create an implementation class ourselves.
 * 3. Spring data JPA generated a working implementation at runtime.
 * 4. Spring creates/manages an object that implements this inetrface.
 * 
 * That generated repository object can later:
 * - save users
 * - find users
 * - delete users
 * - check whether the users exists

*/
public interface UserRepository extends JpaRepository<User, Long> {
    /*
      *JpaRepository<User, Long>
      *
      * User:
      * This repository manages User entities.
      * 
      * Long:
      * User's primary key is a Long
      * 
      * Extending JpaRepository automatically give us methods such as:
      * 
      * save(..)
      * findById(...)
      * findAll()
      * deleteById(...)
      * existsById(...)
    */

      /*
        *Spring Data reads this method name and generates the query.
        *
        * findByEmailIgnoreCase:
        * Find the user whose email matches, ignoring uppercase/lowercase
        * 
        * Optional<User> means:
        * - a User may be found
        * - or no User may be found
      */
    Optional<User> findByEmailIgnoreCase(String email);
    /* 
     * Returns only true/false.
     *
     * Example:
     * true  -> email already belongs to an account
     * false -> email is available
     */
    boolean existsByEmailIgnoreCase(String email);
}