public class Main {
    public static void main(String[] args) {

        // Создаем экземпляры MyArrayList и MyLinkedList
        MyList arrayList = new MyArrayList();
        MyList linkedList = new MyLinkedList();

        // Создаем несколько объектов Person
        Person person1 = new Person("Alice", 1);
        Person person2 = new Person("Bob", 2);
        Person person3 = new Person("Charlie", 3);
        Person person4 = new Person("Dave", 4);

        // MyArrayList: добавляем элементы
        arrayList.add(person1);
        arrayList.add(person2);
        arrayList.add(person3);
        arrayList.add(person4, 1); // добавляем person4 на индекс 1

        // MyLinkedList: добавляем элементы
        linkedList.add(person1);
        linkedList.add(person2);
        linkedList.add(person3);
        linkedList.add(person4, 1); // добавляем person4 на индекс 1

        // MyArrayList: выводим элемент по индексу
        System.out.println("ArrayList - get(1): " + arrayList.get(1).getName());

        // MyLinkedList: выводим элемент по индексу
        System.out.println("LinkedList - get(1): " + linkedList.get(1).getName());

        // MyArrayList: заменяем элемент по индексу
        arrayList.set(2, new Person("Eve", 5));
        System.out.println("ArrayList - get(2) after set: " + arrayList.get(2).getName());

        // MyLinkedList: заменяем элемент по индексу
        linkedList.set(2, new Person("Eve", 5));
        System.out.println("LinkedList - get(2) after set: " + linkedList.get(2).getName());

        // MyArrayList: получение подсписка
        Person[] subArray = (Person[]) arrayList.subList(0, 2);
        System.out.println("ArrayList - subList(0, 2): " + subArray[0].getName() + ", " + subArray[1].getName());

        // MyLinkedList: получение подсписка
        MyLinkedList.Node[] subList = (MyLinkedList.Node[]) linkedList.subList(0, 2);
        System.out.println("LinkedList - subList(0, 2): " + subList[0].value.getName() + ", " + subList[1].value.getName());


        // MyArrayList: удаляем элемент по индексу
        arrayList.removeAt(1);
        System.out.println("ArrayList - get(1) after removeAt: " + arrayList.get(1).getName());

        // MyLinkedList: удаляем элемент по индексу
        linkedList.removeAt(1);
        System.out.println("LinkedList - get(1) after removeAt: " + linkedList.get(1).getName());

        // MyArrayList: удаляем конкретный объект
        arrayList.remove(person1);
        System.out.println("ArrayList - size after remove: " + arrayList.size());

        // MyLinkedList: удаляем конкретный объект
        linkedList.remove(person1);
        System.out.println("LinkedList - size after remove: " + linkedList.size());

        // MyArrayList: размер списка
        System.out.println("ArrayList - size: " + arrayList.size());

        // MyLinkedList: размер списка
        System.out.println("LinkedList - size: " + linkedList.size());


    }
}