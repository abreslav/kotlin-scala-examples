package _05_nulls.java;

public class Container<T> {
    private T t;

    public Container(T t) {
        this.t = t;
    }

//    @NotNull
    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}

