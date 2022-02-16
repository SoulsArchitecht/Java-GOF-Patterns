package gof_patterns.Pattern10_FlyWeight;

/**Легковес — это структурный паттерн проектирования, который позволяет вместить бóльшее
количество объектов в отведённую оперативную память. Легковес экономит память, разделяя
общее состояние объектов между собой, вместо хранения одинаковых данных в каждом объекте.*/

import java.util.WeakHashMap;

public class FlyWeightExample {
    public static void main(String[] args) {
        StudentCache cache = new StudentCache();
        StudentUniversityInfo mike = cache.getStudentUniversityInfo("IT");
        StudentUniversityInfo mike2 = cache.getStudentUniversityInfo("IT");
        System.out.println(mike.equals(mike2));
    }
}

class Hostel {

}

//personal modified fields
class StudentPersonalInfo {
    String name;
    int age;
    String homeAddress;
    int course;
    double averageMark;

}

// public constant fields
class StudentUniversityInfo {
    String faculty;
    String universityCity;
    Hostel hostelAddress;

    public StudentUniversityInfo(String faculty, String universityCity, Hostel hostelAddress) {
        this.faculty = faculty;
        this.universityCity = universityCity;
        this.hostelAddress = hostelAddress;
    }
}

class StudentCache {
    private static final WeakHashMap<String, StudentUniversityInfo> studentUniversityInfos = new WeakHashMap<>();

    public StudentUniversityInfo getStudentUniversityInfo(String name) {
        StudentUniversityInfo studentUniversityInfo = studentUniversityInfos.get(name);
        if (studentUniversityInfo == null) {
            studentUniversityInfo = createStudentInfo(name);
            studentUniversityInfos.put(name, studentUniversityInfo);
        }
        return studentUniversityInfo;
    }

    private StudentUniversityInfo createStudentInfo (String faculty) {
        switch (faculty) {
            case "IT":
                return new StudentUniversityInfo(faculty, "New York", new Hostel());
            case "Management":
                return new StudentUniversityInfo(faculty, "Los Angeles", new Hostel());
            default:
                throw new IllegalArgumentException("there is no such faculty");
        }
    }
}