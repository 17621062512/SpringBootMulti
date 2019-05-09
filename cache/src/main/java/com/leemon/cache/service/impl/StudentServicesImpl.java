package com.leemon.cache.service.impl;

import com.leemon.cache.pojo.Student;
import com.leemon.cache.repository.StudentRepository;
import com.leemon.cache.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author limenglong
 * @create 2019-05-09 16:35
 * @desc
 **/
//cacheNames  用来统一指定缓存放在哪里 此时方法上注解@Cacheable中的的value可以省略掉
//如果@Cacheable中的value参数没有省略，则以@Cacheable的value为准指定缓存放在哪里
@CacheConfig(cacheNames = "students")
@Transactional
@Service
public class StudentServicesImpl implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    //使用@CachePut时，需要注意：该注解的key和value必须和要更新的缓存(@Cacheable)的key和value相同
    @CachePut(key = "#a0.name")
    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    //key 代表在缓存中是以什么为键名存储Student值得
    //@Cacheable(value = "students")
    //@Cacheable(key = "getTargetClass() + getMethodName() + getArgs()")
    //@Cacheable(key = "#p0")
    @Cacheable(key = "#a0")
    //@Cacheable(key = "#root.args")
    @Override
    public Student findByName(String name) {
        return studentRepository.findByName(name);
    }


    @CachePut(key = "#a0.name")
    @Override
    public Student update(Student student) {
        return studentRepository.save(student);
    }


    //组合注解
    @Caching(evict = @CacheEvict(key = "#a0.name"))
    @Override
    public void delete(Student student) {
        studentRepository.delete(student);
    }
}
