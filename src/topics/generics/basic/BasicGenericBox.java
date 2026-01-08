package topics.generics.basic;

public class BasicGenericBox<T>{
    private T content;

    public BasicGenericBox(T content) {
        this.content = content;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public void displayContent(){
        System.out.println("Content Type: "+ content.getClass().getName());
        System.out.println("Content Value: "+content);
    }

    static void main() {
        BasicGenericBox<Integer> intBox = new BasicGenericBox<>(100);
        intBox.displayContent();
        System.out.println("Retrieved: "+intBox.getContent());

        BasicGenericBox<String> stringBox = new BasicGenericBox<>("hello coder");
        stringBox.displayContent();

        BasicGenericBox<Double> doubleBox = new BasicGenericBox<>(78.89);
        doubleBox.displayContent();
        doubleBox.setContent(99.99);
        System.out.println("Updated content: "+doubleBox.getContent());
    }
}
