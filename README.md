# FindIt-Campus-Lost-Found
Java-based campus lost and found management system for reporting, searching, and claiming lost items.

# FindIt - Campus Lost & Found System

## Project Overview

FindIt is a Java 8+ console-based application designed to help students report lost and found belongings on campus. The system allows users to record item details, search reported items, submit ownership claims, and manage the return process.

The project uses a simple layered design and local text-file storage so that records remain available after the application is closed and reopened.

## Features

- Report a lost item
- Report a found item
- View all reported items
- Search items by name, category, location, description, or type
- Submit a claim for a found item
- View all claims
- Approve or reject claims
- Mark an item as returned
- Validate required text inputs
- Handle invalid numeric input without crashing
- Persist item and claim data in the `data/` folder

## Technologies and Concepts

- Java 8 or later
- Object-oriented programming
- Classes, objects, constructors, and encapsulation
- Enums
- Collections (`List` and `ArrayList`)
- File handling using readers and writers
- Exception handling
- Layered architecture
- Modular packages

## Project Structure

```text
FindIt_Final/
├── data/
│   ├── items.txt
│   └── claims.txt
├── docs/
│   └── UML.md
├── src/com/findit/
│   ├── Main.java
│   ├── model/
│   ├── repository/
│   ├── service/
│   └── util/
├── README.md
├── statement.md
├── TESTING.md
└── GITHUB_SETUP.md
```

## Requirements

- JDK 8 or newer
- PowerShell, Command Prompt, or another terminal
- Git (only required for GitHub submission)

Check Java installation:

```powershell
java -version
javac -version
```

## Compile and Run

Open a terminal in the project root, which is the folder containing `src`.

### Compile

```powershell
javac -d out (Get-ChildItem -Path src -Recurse -Filter *.java | ForEach-Object { $_.FullName })
```

### Run

```powershell
java -cp out com.findit.Main
```

## Testing Instructions

1. Select option `1` and report a lost item.
2. Select option `2` and report a found item.
3. Select option `3` to view all items.
4. Select option `4` and search using a partial keyword.
5. Select option `5` and submit a claim using a found item ID.
6. Select option `6` to view claims.
7. Select option `7` to approve or reject a claim.
8. Select option `8` to mark an item as returned.
9. Close and restart the application to confirm that records persist.

## Storage

The application stores records in:

- `data/items.txt`
- `data/claims.txt`

The data files use a simple delimiter-based format for this academic project.

## Limitations

- The current version is a local console application.
- A fixed claimant ID is used for the basic claim workflow.
- There is no login system or multi-user access control.
- Text-file storage is suitable for a small academic dataset but is not intended for large-scale deployment.

## Future Enhancements

- Add user registration and login
- Add an administrator login
- Add a graphical or web interface
- Add image uploads for lost and found items
- Add automatic item matching
- Add email or in-app notifications
- Replace text files with SQLite or MySQL

## Author

**Name:** Abhigyan Kumar Pandey

**Registration Number:** 25BAI10989

**Course:** Programming in Java
