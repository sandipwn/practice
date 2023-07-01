package com.example.radical;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.fasterxml.jackson.databind.util.ClassUtil;

import java.util.*;
import java.util.stream.Stream;

public class Codevasya {
    public static void main(String[] args)
    {
        List< Student > studentList = new ArrayList< Student >();
        studentList.add(new Student(3,"sandip","history","arts",80));
        studentList.add(new Student(4,"mangesh","math","science",78));
        studentList.add(new Student(7,"lucky","physics","science",80));
        studentList.add(new Student(8,"jay","marathi","arts",89));
        studentList.add(new Student(10,"kirtnesh","chemistry","science",68));

        List<Map<String,Object>> list = new ArrayList<>();
        for(Student s:studentList)
        {
            Map<String,Object> map=new HashMap<>();
            map.put("id",s.getId());
            map.put("name",s.getName());
            map.put("subject",s.getSubject());
            map.put("department",s.getDepartment());
            map.put("marks",s.getMarks());

            list.add(map);

        }

        //first way
        for(Map<String,Object> map:list)
        {
            System.out.print("{");
            for(Map.Entry<String,Object> entry:map.entrySet())
            {
                System.out.print(entry.getKey()+":"+entry.getValue()+" ");
            }
            System.out.println("}");
        }
        //second way
        for(Map<String,Object> map:list)
        {
            System.out.print("{");
            for(String key:map.keySet())
            {
                System.out.print(key+":"+ map.get(key)+" ");
            }
            System.out.println("}");
        }


        Map<Integer,Integer> map = new HashMap<>();

        map.entrySet().stream().filter(
                keys->keys.getKey() >2 );
        }
}

       /* Table Name :- Employee_salary
        Column 1 - empId
        column 2 - salary

        Table Name :- Employee
        Column 1 - empId
        column 2 - emp_name

        Find the employeename with their salary

        select e.emp_name,es.salary from Employee_salary es join Employee e on e.empId=es.empId;*/