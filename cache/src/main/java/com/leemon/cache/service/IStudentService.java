package com.leemon.cache.service;

import com.leemon.cache.pojo.Student;

/**
 * @author limenglong
 * @create 2019-05-09 16:34
 * @desc
 **/
public interface IStudentService {

    Student save(Student student);

    Student findByName(String name);

    Student update(Student student);

    void delete(Student student);

}
