package topics.generics.basic;

public class GenericPair<K,V> {
    private K key;
    private V value;

    public GenericPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public void display(){
        System.out.println("Key: " + key + " (Type: " + key.getClass().getSimpleName() + ")");
        System.out.println("Value: " + value + " (Type: " + value.getClass().getSimpleName() + ")");

    }
    static void main() {
        GenericPair<String,Integer> agePair = new GenericPair<>("Age",25);
        agePair.display();

        GenericPair<Integer, String> idNamePair = new GenericPair<>(62, "Subham");
        idNamePair.display();

        GenericPair<String, Double> pricePair = new GenericPair<>("Product Price", 599.99);
        pricePair.display();

        GenericPair<Boolean, Double> statusPair = new GenericPair<>(true, 78.88);
        statusPair.display();
    }
}
