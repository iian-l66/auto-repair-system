package model;

public abstract class BaseEntity {
    protected final Long id;

    protected BaseEntity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
