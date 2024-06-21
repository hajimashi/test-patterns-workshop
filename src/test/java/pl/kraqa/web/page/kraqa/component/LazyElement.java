package pl.kraqa.web.page.kraqa.component;

import java.util.function.Supplier;

public class LazyElement<T> {
    private T element;
    private Supplier<T> loadAction;

    public LazyElement(Supplier<T> loadAction) {
        this.loadAction = loadAction;
    }

    public T get() {
        if (element == null) {
            element = loadAction.get();
        }

        return element;
    }
}
