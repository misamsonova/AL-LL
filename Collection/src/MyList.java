public interface MyList {
    void add(Person p);
    void add(Person p, int index);
    boolean remove(Person p);
    boolean removeAt(int index);
    Person get(int index);
    void set(int index, Person p);

    Object subList(int fromIndex, int toIndex);
    int size();

}
