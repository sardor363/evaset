package uz.pdp.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.springsecurity.entity.Customer;
import uz.pdp.springsecurity.entity.Trade;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    List<Customer> findAllByBranch_Id(Integer branch_id);

    @Query(value = "select * from Customer c inner join branches b on b.business_id = ?1",nativeQuery = true)
    List<Trade> findAllByBusinessId(Integer businessId);
}
