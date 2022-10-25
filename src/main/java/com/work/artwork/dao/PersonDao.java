package com.work.artwork.dao;

import com.work.artwork.bean.Person;
import com.work.artwork.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonDao {
    public Person userlogin(@Param("username") String username, @Param("password") String password);
    public int register(Person person);
    public List<Person> getAllPerson(@Param("username") String username, @Param("pageStart") int PageStart, @Param("pageSize") int PageSize);
    public int getPersonCounts(@Param("username") String username);
    public int updateState(@Param("id") Integer id,@Param("state") Boolean state);
    public int updatePerson(@Param("id") Integer id);
    public int deletePerson(int id);
    public Person getPersonById(int id);
    public int editPerson(Person person);
}
