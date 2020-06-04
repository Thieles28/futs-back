package com.futs.repository;

import com.futs.model.Times;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimesRepository extends JpaRepository<Times, Long> {
}
