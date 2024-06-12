# Leaderboard API

This is a RESTful API service built using Spring Boot to manage the Leaderboard for a Coding Platform, utilizing MongoDB to persist the data. The platform hosts a single contest with a leaderboard, managing user registrations, score updates, and badge awards.

## Requirements

- Implement CRUD operations for user registrations.
- Each user has:
  - User ID (Unique Identifier)
  - Username
  - Score (0 <= Score <= 100)
  - Badges (Code Ninja, Code Champ, Code Master)
- User registration requires User ID and Username.
- Users start with a score of 0 and no badges.
- Only score updates are allowed via PUT requests.
- Award badges based on score thresholds:
  - 1 <= Score < 30 -> Code Ninja
  - 30 <= Score < 60 -> Code Champ
  - 60 <= Score <= 100 -> Code Master
- Each user can have a maximum of three unique badges.
- User retrieval is sorted based on score with O(nlogn) complexity.
- Include basic JUnit test cases.
- Perform basic validation for all fields.
- Handle common errors and return appropriate HTTP codes.

## Endpoints

- **GET /users** - Retrieve a list of all registered users, sorted by score.
- **GET /users/{userId}** - Retrieve details of a specific user.
- **POST /users** - Register a new user to the contest.
- **PUT /users/{userId}** - Update the score of a specific user.
- **DELETE /users/{userId}** - Deregister a specific user from the contest.

## Validation and Error Handling

- Validate fields (e.g., Score > 0).
- Handle errors with appropriate HTTP codes (e.g., 404 for User not found).

## Running the Application

To run the application:

1. Clone the repository: 
   
2. Navigate to the project directory: 
   
3. Build the project: 
 
4. Run the application: 
   

## Testing

- Basic JUnit test cases are included to verify operations.
- Use tools like Postman to test the API endpoints.
- Ensure all CRUD operations and validations are thoroughly tested.

## Postman Collection

You can find a collection of API requests for testing the endpoints inside the demo folder.
