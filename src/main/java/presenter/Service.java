package presenter;

import java.util.List;

public abstract class Service<T> {

    public abstract T create(final T entity);

    public abstract T update(final T entity);

    public abstract List<T> findAll();

    public abstract T findById(final String id);

    public abstract void delete(final T entity);
}
