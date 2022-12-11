package com.example.smartgoods.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.smartgoods.domain.SmartGoodsUser;

@Repository
public interface SmartGoodsUserRepository extends JpaRepository<SmartGoodsUser, String> {

}
