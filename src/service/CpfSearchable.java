package service;

public interface CpfSearchable<T> {
    T get (String cpf);
    void remove (String cpf);
}
