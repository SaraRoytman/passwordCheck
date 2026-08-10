# PassCheck

A simple Java tool to validate and analyze the strength of usernames and passwords. Integrated with a MySQL database for persistent user management and unique identity verification.

## Features

- Validate username and password formats against configurable rules
- Analyze password strength (length, character classes, common patterns)
- Prevent weak or common passwords
- Persist users to a MySQL database with unique identity checks
- Simple console-based interface (can be adapted for UI or web integration)

## About

PassCheck is a security-focused utility designed to help developers integrate robust user authentication and password validation into their applications. The tool enforces security best practices by validating usernames and passwords according to customizable rules, analyzing password strength based on multiple criteria, and preventing the use of weak or common passwords. It stores user credentials securely in a MySQL database with unique identity verification to prevent duplicate accounts.

## Key Components

**Validation Engine:** Checks usernames and passwords against configurable rules to ensure they meet security standards.

**Strength Analyzer:** Evaluates password complexity by examining character diversity, length, and patterns to determine overall strength levels.

**Database Integration:** Uses MySQL for persistent user storage with built-in mechanisms to ensure username uniqueness and maintain data integrity.
