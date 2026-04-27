# 📚 Library Management System (Java CLI)

## 📌 Project Overview

This is a **Command-Line Library Management System** built using Java.
It allows librarians to manage books, members, and borrowing operations efficiently using **OOP concepts and file handling**.

The system stores data in text files to ensure **data persistence**, so information is not lost after the program stops.

---

## 🚀 Features

### 📖 Book Management

* Add new books
* Remove books from library
* View all books with availability status

### 👤 Member Management

* Register new members
* Track borrowed books

### 🔄 Borrow & Return

* Borrow books (if available)
* Return books
* Prevent borrowing already issued books

### 💾 Data Persistence

* Books stored in `books.txt`
* Data loaded automatically on program start
* Data saved after every operation

---

## 🛠️ Technologies Used

* **Java**
* **OOP Concepts** (Encapsulation, Classes, Objects)
* **File Handling (BufferedReader & BufferedWriter)**
* **ArrayList**
* **Exception Handling**
* **CLI (Command Line Interface)**

---

## 📂 Project Structure

```
LibraryManagement/
│
├── Main.java          # Entry point (menu-driven program)
├── Library.java      # Core logic (book & member operations)
├── Book.java         # Book model class
├── Member.java       # Member model class
├── FileHandler.java  # File read/write operations
├── books.txt         # Data storage file
```

---

## ▶️ How to Run

1. Clone the repository:

```
git clone https://github.com/your-username/library-management-system.git
```

2. Open project in IDE (Eclipse / IntelliJ)

3. Compile and run:

```
javac *.java
java Main
```

---

## 🧪 Sample Menu

```
=== Library Management System ===
1. Add Book
2. Register Member
3. Borrow Book
4. Return Book
5. Display Books
6. Remove Book
0. Exit
```

---

## 📁 Data Format (books.txt)

```
101,Java Basics,James,true
102,C++,Bjarne,true
```

* `true` → Available
* `false` → Borrowed

---

## ⚠️ Error Handling

* Handles invalid inputs
* Prevents borrowing unavailable books
* Prevents removing non-existing books
* Displays user-friendly messages

---

## 🎯 Learning Outcomes

* Practical implementation of **OOP principles**
* Understanding of **file-based data persistence**
* Experience with **Java collections (ArrayList)**
* Building a **menu-driven CLI application**

---

## 👩‍💻 Author

**Meemansa Sakhla**

---
