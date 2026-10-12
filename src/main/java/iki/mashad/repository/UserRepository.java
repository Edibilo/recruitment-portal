package iki.mashad.repository;

import iki.mashad.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findUserByEmail(String email);
    boolean existsByEmail(String email);

    @Query("Select count (*) from User ")
    int totalUser();

    @Query("Select count (*) from User u " +
            "join u.role r " +
            " where r.name='ROLE_ADMIN' ")
    int totalAdmin();

    @Query("Select count (*) from User u " +
            "join u.role r " +
            " where r.name='ROLE_RECRUITER' ")
    int totalRecruiter();

    @Query("Select count (*) from User u " +
            "join u.role r " +
            " where r.name='ROLE_APPLICANT' ")
    int totalApplicant();
}
