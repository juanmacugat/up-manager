package repository;

import domain.Grade;

public class GradeRepository implements RelationalRepository<Grade, String> {

    private static GradeRepository instance = new GradeRepository();

    public static GradeRepository getInstance(){
        return instance;
    }
}
