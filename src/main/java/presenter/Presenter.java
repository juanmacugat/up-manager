package presenter;

import java.util.List;

public abstract class Presenter<T> {

    public abstract void create(final T entity);

    public abstract void update(final T entity);

    public abstract List<T> findAll();

    public abstract void delete(final T entity);
}
