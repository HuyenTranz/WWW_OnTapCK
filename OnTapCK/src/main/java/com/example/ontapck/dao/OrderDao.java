package com.example.ontapck.dao;

import com.example.ontapck.entity.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao extends JpaRepository<Orders, Integer> {
    Page<Orders> findAll(Pageable pageable);

    @Query("Select o from Orders o where o.ProName like %:keyword%")
    List<Orders> search(@Param("keyword") String keyword);

    Orders findByID(int id);
}
