package com.spring.rentACar.repositories;

import com.spring.rentACar.entities.Bill;
import com.spring.rentACar.services.dtos.responses.bill.GetBillListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface BillRepository extends JpaRepository<Bill, Integer> {

    // Derived Query Method - 1
    List<Bill> findByDateGreaterThanEqual(LocalDate date);

    // Derived Query Method - 2
    List<Bill> findByDateOrderByPriceDesc(LocalDate date);

    // JPQL - 1
    @Query("Select new com.spring.rentACar.services.dtos.responses.bill.GetBillListResponse(b.date, b.price) from Bill b")
    List<GetBillListResponse> getAllJPQL();

    // JPQL - 2
    @Query("Select new com.spring.rentACar.services.dtos.responses.bill.GetBillListResponse(b.date, b.price)" +
            " from Bill b where b.date = :date")
    List<GetBillListResponse> getByDateJPQL(LocalDate date);
}
