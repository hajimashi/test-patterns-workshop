# test-patterns-workshop

## Task 1
1. Checkout `task1` branch (`git checkout task1`)
2. Open `pl.kraqa.library.Task1Test`
3. Read the description carefully. Your task is to test a `Library` class. You don't need to dig into its implementation. All you need to know it's the interface. `Library` has `addBook()` method that puts a specific book into Library's index. Since then the book will be known to the system but before you would be able to borrow the book you need to add at least single copy of this book using `addCopy()` function. To find a book inside Library's index you may use `findByTitle()` or `findByAuthor()`. Last thing you may need is a method `isAvailable()` that tells you whether there is at least one free example of a book you may borrow or not.

## Task 2
1. Open [link](https://github.com/hajimashi/test-patterns-workshop/blob/task2/src/test/java/pl/kraqa/library/Task2Test.java#L19)
2. What is wrong with the setup in this test? How it can be improved?
3. Checkout `task2` branch (`git checkout task2`)
4. Open `pl.kraqa.library.Task2Test`
5. Try to refactor the code to make it more readable

## Task 2*
1. Checkout `task2` branch (`git checkout task2`)
2. Let's imagine our library decided to follow current trends and wants to let people borrow books online
3. Take a look at `pl.kraqa.library.Order` class
4. Can you implement pattern learned in the task 2 in this class?