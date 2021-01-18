package com.webbutik.SpringBootWebbButik.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webbutik.SpringBootWebbButik.domain.Car;

public interface CarRepository extends JpaRepository<Car, Integer> {

}
