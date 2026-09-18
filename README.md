# CampusTrace - Campus Lost & Found System

CampusTrace is a Java 8+ console-based application for reporting lost and found belongings, searching records, submitting ownership claims, and managing item returns.

## Features
- Report lost items
- Report found items
- View all items
- Search using partial keywords
- Submit claims for found and active items
- View, approve, and reject claims
- Mark items as returned
- Persistent text-file storage in `data/items.txt` and `data/claims.txt`
- Input validation and error handling

## Technology
Java 8+, OOP, packages, collections, enums, file handling, and command-line execution.

## Structure
```text
CampusTrace_Final/
├── data/
│   ├── items.txt
│   └── claims.txt
├── src/com/campustrace/
│   ├── Main.java
│   ├── model/
│   ├── repository/
│   ├── service/
│   └── util/
├── README.md
└── statement.md
```

## Compile and Run (PowerShell)
```powershell
javac -d out (Get-ChildItem -Path src -Recurse -Filter *.java | ForEach-Object { $_.FullName })
java -cp out com.campustrace.Main
```

## Testing
Test item reporting, viewing, partial-keyword search, claim submission, claim approval/rejection, status updates, and restart persistence.

## Student Details
- **Name:** Abhigyan Kumar Pandey
- **Registration No.: 25BAI10989
- **Slot:** B14 + D21
