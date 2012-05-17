package java_generics;

import java.util.List;

public class Foo {
    public List<? extends Appendable> getList() {
        return null;
    }

    void test() {
//        List<String> ls = getList();
    }
}
