package data;

public interface FileObjectMapper<T> {
    T mapToObject(String string);
}
