package com.example.springdemo.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.springdemo.entity.CreditApplication;

public interface CreditApplicationRepository extends JpaRepository<CreditApplication, Long> {
    
    @Query("""
        select creditApplication
        from CreditApplication creditApplication
        join fetch creditApplication.customer
        join fetch creditApplication.vehicle
    """)
    List<CreditApplication> findAllWithCustomerAndVehicle();

    @Query("""
        select creditApplication
        from CreditApplication creditApplication
        join fetch creditApplication.customer
        join fetch creditApplication.vehicle
        where creditApplication.status = :status
    """)
    List<CreditApplication> findByStatusWithCustomerAndVehicle(String status);

    @Query("""
        select
            creditApplication.branchId,
            count(creditApplication),
            coalesce(sum(creditApplication.loanAmount), 0),
            coalesce(avg(creditApplication.loanAmount), 0),
            coalesce(min(creditApplication.loanAmount), 0),
            coalesce(max(creditApplication.loanAmount), 0)
        from CreditApplication creditApplication
        where creditApplication.branchId = :branchId
        group by creditApplication.branchId
    """)
    Object[] getDashboardBranch(
            @Param("branchId") Long branchId);

    @Query("""
        select
            creditApplication.status,
            count(creditApplication),
            coalesce(sum(creditApplication.loanAmount), 0)
        from CreditApplication creditApplication
        where creditApplication.branchId = :branchId
        group by creditApplication.status
    """)
    List<Object[]> getDashboardByStatus(
            @Param("branchId") Long branchId);

    @Query("""
        select
            creditApplication.tenorMonth,
            count(creditApplication),
            coalesce(sum(creditApplication.loanAmount), 0)
        from CreditApplication creditApplication
        where creditApplication.branchId = :branchId
        group by creditApplication.tenorMonth
    """)
    List<Object[]> getDashboardByTenorMonth(
            @Param("branchId") Long branchId);

    @Query("""
        select
            creditApplication.vehicle.brand,
            count(creditApplication),
            coalesce(sum(creditApplication.loanAmount), 0)
        from CreditApplication creditApplication
        where creditApplication.branchId = :branchId
        group by creditApplication.vehicle.brand
    """)
    List<Object[]> getDashboardByVehicleBrand(
            @Param("branchId") Long branchId);
}