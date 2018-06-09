package repository;

import model.Teacher;

public class TeacherRepository implements RelationalRepository<Teacher, String> {

    private static TeacherRepository instance = new TeacherRepository();

    public static TeacherRepository getInstance(){
        return instance;
    }
}
