package com.alan.demo.mapper;
import com.alan.demo.entity.Book;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface BookMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book
     *
     * @mbg.generated Mon Mar 09 13:47:00 CST 2020
     */
    int deleteByPrimaryKey(Integer bid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book
     *
     * @mbg.generated Mon Mar 09 13:47:00 CST 2020
     */
    int insert(Book record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book
     *
     * @param bid
     * @mbg.generated Mon Mar 09 13:47:00 CST 2020
     */
    Book selectByPrimaryKey(Integer bid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book
     *
     * @mbg.generated Mon Mar 09 13:47:00 CST 2020
     */
    List<Book> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book
     *
     * @mbg.generated Mon Mar 09 13:47:00 CST 2020
     */
    int updateByPrimaryKey(Book record);
}