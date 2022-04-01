package by.tms.dao.jpa;

public class CONSTANT {
    public static final String findAllByName = "select u from User u where u.name = :name";
    public static final String findAll = "select u from User u";
    public static final String findByUsername = "select u from User u where u.name = :name";

}
