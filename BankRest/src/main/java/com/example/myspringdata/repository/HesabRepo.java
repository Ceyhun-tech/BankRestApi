package com.example.myspringdata.repository;

import com.example.myspringdata.entity.Hesab;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface HesabRepo extends JpaRepository<Hesab, Integer> {
    @Query("select balans from Hesab where id = ?1")
     int balanstap(int id);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Hesab set balans = balans+?2 where id=?1")
     void depozit(int id, int balans);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Hesab set balans = balans-?2 where id=?1")
     void balansazalt(int id, int balans);

}
