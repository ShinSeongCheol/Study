package chap06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class chap06_11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Student[] students = new Student[N];
        for(int i=0; i<N; i++) {
            students[i] = new Student(sc.next(), sc.nextInt());
        }

        Comparator<Student> comparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getGrade() - o2.getGrade();
            }
        };

        Arrays.sort(students, comparator);

        for(Student s : students) {
            System.out.println(s.getName());
        }
    }
}

class Student {
    private String name;
    private int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName(){
        return this.name;
    }

    public int getGrade() {
        return this.grade;
    }
}
