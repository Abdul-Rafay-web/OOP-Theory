import java.io.*;
import java.util.*;
class EntityList<T> {
    private ArrayList<T> entities;

    public EntityList() {
        entities = new ArrayList<>();
    }

    public void add(T entity) {
        entities.add(entity);
    }

    public T get(int index) throws EntityNotFoundException {
        if (index < 0 || index >= entities.size()) {
            throw new EntityNotFoundException("Entity not found at index: " + index);
        }
        return entities.get(index);
    }

    public int size() {
        return entities.size();
    }

    public ArrayList<T> getAll() {
        return new ArrayList<>(entities);
    }

    public void remove(T entity) {
        entities.remove(entity);
    }

    public void saveToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(entities);
            System.out.println("Data saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void loadFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            entities = (ArrayList<T>) ois.readObject();
            System.out.println("Data loaded from " + filename);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}