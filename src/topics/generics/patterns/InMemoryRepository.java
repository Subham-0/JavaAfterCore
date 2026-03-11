package topics.generics.patterns;

import java.util.*;
import java.util.function.Function;

public class InMemoryRepository<T, ID> implements Repository<T, ID>{

    private Map<ID, T> storage = new HashMap<>();
    private Function<T, ID> idExtractor;

    public InMemoryRepository(java.util.function.Function<T, ID> idExtractor) {
        this.idExtractor = idExtractor;
    }

    @Override
    public T save(T entity) {
        ID id = idExtractor.apply(entity);
        storage.put(id, entity);
        System.out.println("Saved: " + entity);
        return entity;
    }
    @Override
    public Optional<T> findById(ID id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void delete(ID id) {
        T removed = storage.remove(id);
        if (removed != null) {
            System.out.println("Deleted: " + removed);
        } else {
            System.out.println("Entity with id " + id + " not found");
        }
    }

    @Override
    public boolean exists(ID id) {
        return storage.containsKey(id);
    }

    @Override
    public long count() {
        return storage.size();
    }
}
