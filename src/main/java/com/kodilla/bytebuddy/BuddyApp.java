package com.kodilla.bytebuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class BuddyApp {

    //pierwsze zadanie
//    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        Class<?> dynamicBookClass = new ByteBuddy()
//                .subclass(Book.class)
//                .method(ElementMatchers.named("toString"))
//                .intercept(FixedValue.value("Hello my Buddy!"))
//                .make()
//                .load(Book.class.getClassLoader(), ClassLoadingStrategy.Default.WRAPPER)
//                .getLoaded();
//
//        Class[] parameterTypes = { String.class, String.class, int.class};
//
//        System.out.println(dynamicBookClass.getDeclaredConstructor(parameterTypes)
//                .newInstance("title", "author", 2010));
//    }
    public static void main(String[] args) {
        List<Book> books = BooksGenerator.generate(100);
        BooksFilter booksFilter = new BooksFilter(books);
        List<Book> filteredBooks = booksFilter.onlyBooksOlderThan(20);
        System.out.println(filteredBooks.size());
    }
}
