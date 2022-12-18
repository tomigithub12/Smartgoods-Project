package com.example.smartgoods.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.smartgoods.domain.SmartGoods;
import com.example.smartgoods.domain.SmartGoodsUser;

@Repository
public interface SmartGoodsRepository extends JpaRepository<SmartGoods, Long> {
	

	List<SmartGoods> findAllByuserUUID(@Param("user_UUID") String uuid);
	
}
