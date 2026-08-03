# PassCheck

A simple Java tool to validate and analyze the strength of usernames and passwords. Integrated with a MySQL database for persistent user management and unique identity verification.

## Features

- Validate username and password formats against configurable rules
- Analyze password strength (length, character classes, common patterns)
- Prevent weak or common passwords
- Persist users to a MySQL database with unique identity checks
- Simple console-based interface (can be adapted for UI or web integration)

## Requirements

- Java 8 or later
- Maven (optional, if project uses Maven)
- MySQL database (5.7+ recommended)

## Quick start

1. Clone the repository:

   git clone https://github.com/SaraRoytman/PassCheck.git

2. Build the project (if using Maven):

   mvn clean package

3. Configure the database connection (see Configuration below).

4. Run the application from the command line or your IDE.

## Configuration

Create a MySQL database and a user with appropriate permissions. Update the application's database configuration (typically in a properties or config file in `src/main/resources` or a constants class) with the following settings:

- DB host (e.g., localhost)
- DB port (e.g., 3306)
- Database name
- Username
- Password

Example JDBC URL:

```
jdbc:mysql://localhost:3306/passcheck_db?useSSL=false&serverTimezone=UTC
```

If the repository does not yet contain a config file, you can add a `config.properties` or set environment variables and update the code to read them.

## Usage

Typical usage flow:

1. Start the application
2. Create or register a new user (username + password)
3. The tool validates the username and password against the rules
4. If valid and strong enough, the user is saved to the database
5. The application reports the validation result and strength analysis

Example (console):

- Enter username: `alice`
- Enter password: `S3cur3P@ss!`
- Output: `Password strength: Strong — accepted`

## Rules & Recommendations

- Enforce a minimum password length (e.g., 8 or 12 characters)
- Require at least two character classes: uppercase, lowercase, digits, symbols
- Disallow common or breached passwords (consider integrating a blacklist or online API)
- Rate-limit registration attempts to prevent brute-force
- Hash and salt passwords before storing (use a strong algorithm like bcrypt, Argon2, or PBKDF2)

## Database Schema (example)

A simple `users` table example:

```
CREATE TABLE users (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(255) NOT NULL UNIQUE,
  password_hash VARCHAR(255) NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

Adjust columns as needed for your hashing strategy and additional metadata.

## Testing

- Add unit tests for validation and strength analysis logic
- Use integration tests for DB interactions (can use an in-memory DB for tests or a test MySQL instance)

## Contributing

Contributions are welcome. Please open issues for bugs or feature requests and submit pull requests for changes. Include tests and update the README where appropriate.

## License

Specify a license for the repository (e.g., MIT). If you don't have one yet, add a `LICENSE` file.

## Contact

For questions, reach out to the repository owner.
