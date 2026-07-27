package service;

public interface CrudService <T>{
    void add (T t);
    void list ();
    T get (Long id);
    void remove (Long id);
}
