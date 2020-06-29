package com.mtb.designpatter.builderpatternex;

/**
 * @author MithileshB
 * @created 13/06/2020 - 8:45 PM
 * @project DesignPattern
 */
public final class Student {

    private final int id;
    private final String name;
    private final String address;

    public Student(StudentBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.address = builder.address;
    }

    public static class StudentBuilder {
        private int id;
        private String name;
        private String address;

        private StudentBuilder() {

        }

        public Student build() {
            return new Student(this);
        }

        public static StudentBuilder newInstance() {
            return new StudentBuilder();
        }

        public StudentBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public StudentBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder withAddress(String address) {
            this.address = address;
            return this;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

class StudentBuilderDemo {
    private volatile Student student;

    public StudentBuilderDemo() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread t1 started");
                student = Student.StudentBuilder.newInstance().withId(5)
                        .withName("Mithilesh")
                        .withAddress("Nagpur")
                        .build();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread t2 started");
                 student = Student.StudentBuilder.newInstance().withId(4)
                        .withName("Mithilesh")
                        .withAddress("Nagpur")
                        .build();

            }
        });
        t1.start();
        t2.start();
    }

    public Student getStudent() {
        return student;
    }
}

class StudentBuilderMain {
    public static void main(String[] args) {

        StudentBuilderDemo studentBuilderDemo = new StudentBuilderDemo();
        System.out.println(studentBuilderDemo.getStudent());
        Student student = Student.StudentBuilder.newInstance().withId(1)
                .withName("Mithilesh")
                .withAddress("Nagpur")
                .build();

        System.out.println(student);

    }


}