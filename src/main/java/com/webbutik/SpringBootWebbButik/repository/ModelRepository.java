package com.webbutik.SpringBootWebbButik.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webbutik.SpringBootWebbButik.domain.ModelOfCar;



public interface ModelRepository extends JpaRepository<ModelOfCar, Integer> {

}
