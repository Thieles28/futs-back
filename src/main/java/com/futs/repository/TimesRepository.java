package com.futs.repository;

import com.futs.model.Time;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimesRepository extends JpaRepository<Time, Long> {
}
