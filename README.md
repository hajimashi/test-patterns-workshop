# test-patterns-workshop

## Task 1
1. Checkout `task1` branch (`git checkout task1`)
2. Open `pl.kraqa.library.Task1Test`
3. Read the description carefully. Your task is to test a `Library` class. You don't need to dig into its implementation. All you need to know it's the interface. `Library` has `addBook()` method that puts a specific book into Library's index. Since then the book will be known to the system but before you would be able to borrow the book you need to add at least single copy of this book using `addCopy()` function. To find a book inside Library's index you may use `findByTitle()` or `findByAuthor()`. Last thing you may need is a method `isAvailable()` that tells you whether there is at least one free example of a book you may borrow or not. 