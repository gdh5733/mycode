package com.alan.demo.mapper;
import com.alan.demo.entity.Money;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MoneyMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table money
     *
     * @mbg.generated Mon Mar 09 13:49:01 CST 2020
     */
    int insert(Money record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table money
     *
     * @mbg.generated Mon Mar 09 13:49:01 CST 2020
     */
    List<Money> selectAll();
}