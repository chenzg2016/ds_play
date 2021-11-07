package com.czg.optional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author chenzg
 * @date 8/2/21 9:58 PM
 * @description
 * jdk7 到8的map 和 flatMap区别
 */
public class MapAndFlatMapTest {

    public static void main(String[] args){

        List<Student> studentList = new ArrayList<Student>();

        studentList.add(new Student("Robert", "5st grade", Arrays.asList(new String[]{ "history", "math", "geography"})));
        studentList.add(new Student("Martin","8st grade", Arrays.asList(new String[]{"economics","biology"})));
        studentList.add(new Student("Robert","9st grade", Arrays.asList(new String[]{"science","math"})));
        //java7
        Set<String> coursesSet = new HashSet<>();

        for(Student student:studentList){
            List<String> courses = student.getCourse();
            for(String course:courses){
                coursesSet.add(course);
            }
        }
        //java8
        System.out.println(coursesSet);

        Set<String> courses = studentList.stream().flatMap(e -> e.getCourse().stream()).collect(Collectors.toSet());

        System.out.println(courses);
        //java7
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> newList = new ArrayList<Integer>();

        for(Integer num:intList){
            newList.add(num*num);
        }

        //java8
        System.out.println(newList.toString());
        List<Integer> intList1 = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> newList1 = intList1.stream().map( e -> e * e ).collect(Collectors.toList());

        System.out.println(newList1);
    }

}
