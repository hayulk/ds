package com.hdmc.ds;

import model.Person;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class DsApplication {

	public static void main(String[] args) {
//		SpringApplication.run(DsApplication.class, args);
        Person person = new Person(12, "aaaaaa");
        System.out.println(person.toString());

        int[] arr = {3, 2, 0, 1, 4};
        Arrays.sort(arr, 0, 3); // 배열 요소 0, 1, 2 만 정렬
        System.out.println(Arrays.toString(arr)); // [0, 2, 3, 1, 4]


        int[][] arr2 = {
                {10, 20, 30},
                {40, 50, 60},
                {70, 80, 90},
                {100, 200, 300}
        };

        for (int i = 0; i < arr2.length; i++) {    // 먼저 열 부분을 순회하고
            for (int j = 0; j < arr2[i].length; j++) { // 행 부분을 순회하며 각 원소를 출력
                System.out.print(arr2[i][j] + " ");

            }
        }
        System.out.println();
        System.out.println(Arrays.deepToString(arr2));

        class myObject {
            int id;
            String description;

            myObject(int id, String description) {
                this.id = id;
                this.description = description;
            }

            @Override
            public String toString() {
                return "MyObject{id=" + id + ", description='" + description + "'}";
            }
        }

// myObject 클래스를 담을 수 있는 공간 3개 크기의 객체 배열 생성
        myObject[] arrayObj = new myObject[3];

// 객체 배열 초기화
        arrayObj[0] = new myObject(101, "first");
        arrayObj[1] = new myObject(102, "second");
        arrayObj[2] = new myObject(103, "third");

// 객체 배열 사용
        System.out.println(arrayObj[0].description); // "first  array, John"

        /* ************************************ */

// 객체 배열 선언 + 초기화 한번에
        myObject[] arrayObj2 = {
                new myObject(101, "fifth"),
                new myObject(101, "second"),
                new myObject(101, "third")
        };
        System.out.println(arrayObj2[0].id); // "first  array, John"
        // 각 객체의 필드 출력
        for (myObject obj : arrayObj2) {
            System.out.println(obj); // MyObject{id=..., description='...'}

        }

        // 클래스에 Comparable<> 인터페이스를 구현한다
        class User implements Comparable<User> {
            String name;
            int age;

            User(String name, int age) {
                this.name = name;
                this.age = age;
            }

            @Override
            public int compareTo(User user) {
                // 비교 로직을 구현
                if (this.age < user.age) {
                    return -1;
                } else if (this.age == user.age) {
                    return 0;
                } else {
                    return 1;
                }
            }
        }

        User[] users = {
                new User("홍길동", 32),
                new User("김춘추", 64),
                new User("임꺽정", 48),
                new User("박혁거세", 14),
        };

        Arrays.sort(users); // 나이순 정렬
        // Arrays.sort(users, Collections.reverseOrder()); // 역순 정렬

        for (User u : users) { // 출력
            System.out.println(u.name + " " + u.age + "세");
        }
    }

}

