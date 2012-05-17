package generics.java;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Foo {
    @NotNull
    public List<? extends Appendable> getList() {
        return null;
    }

    void test() {
//        List<String> ls = getList();
    }

}
