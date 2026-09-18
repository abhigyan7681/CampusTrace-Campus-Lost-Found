# CampusTrace - Project Statement

## Problem Statement
Students frequently lose belongings on campus, while found items are often reported through informal messages. Such reports are difficult to search, verify, and track. CampusTrace provides a structured console-based system for reporting, searching, claiming, and returning lost and found items.

## Scope
The project supports item reporting, viewing, keyword searching, claim submission, claim review, status management, and local text-file persistence. It is executable directly from a terminal.

## Target Users
- Students who lose belongings
- Students or staff who find belongings
- Campus staff who review claims and manage returns

## Objectives
- Centralize lost and found records
- Generate item and claim IDs
- Support keyword-based searching
- Accept claims only for found and active items
- Provide approval and rejection workflows
- Preserve records between executions
- Demonstrate Java OOP, packages, collections, enums, validation, and file handling

## High-Level Features
1. Lost item reporting
2. Found item reporting
3. View all items
4. Search items
5. Submit claims
6. Review claims
7. Approve/reject claims
8. Return-status management
9. Persistent storage

## Functional Requirements
- FR1: Report a lost item.
- FR2: Report a found item.
- FR3: Generate a numeric item ID.
- FR4: Display stored item records.
- FR5: Search item details using partial keywords.
- FR6: Accept claims only for found and active items.
- FR7: Save claims with PENDING status.
- FR8: Approve or reject claims.
- FR9: Set an approved item's status to RETURNED.
- FR10: Load stored records after restart.

## Non-Functional Requirements
- Usability: Simple console menu.
- Reliability: Validation and basic error handling.
- Maintainability: Modular package-based structure.
- Portability: Java 8+ terminal execution.
- Persistence: Records survive application restart.
- Readability: Meaningful names and organized classes.
- Performance: Suitable for a small campus record set.

## Architecture
- Presentation: `Main.java`
- Model: item, claim, enum, and status classes
- Service: business rules and workflows
- Repository: text-file read/write operations
- Utility: validation and helper methods
- Storage: `data/items.txt` and `data/claims.txt`

## Student Details
- Name: Abhigyan Kumar Pandey
- Registration No.: 25BAI10989
- Slot: B14 + D21
