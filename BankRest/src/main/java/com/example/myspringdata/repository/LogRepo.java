package com.example.myspringdata.repository;

import com.example.myspringdata.entity.Logging;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepo extends JpaRepository<Logging, Integer> {

}
