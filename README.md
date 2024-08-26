Introduction
Blogging Plateform is a backend application built with Spring Boot, designed to power the backend functionality for an youtube like social media platform. It provides RESTful APIs for managing user accounts, posts, comments, likes, and other essential features to create a complete social networking experience.

Features
User Management: Register, login, and manage user accounts.
Post Management: Create, view, update, and delete posts.
Comment Management: Add, view, and delete comments on posts.
Follow Management: Follow or unfollow other users.
Feed: View a personalized feed of posts from followed users.
Prerequisites
Before running the InstaBackend project, make sure you have the following prerequisites installed:
Java Development Kit (JDK) - version 11 or higher
Apache Maven or Gradle (build tool)
Database system (e.g., MySQL, PostgreSQL) for storing application data
AWS for deployment
API Endpoints
Authentication
POST /api/auth/signup: Register a new user.
POST /api/auth/login: Authenticate and log in the user.
User Management
GET /api/users/{userId}: Get user information by ID.
GET /api/users/{username}: Get user information by username.
PUT /api/users/{userId}: Update user information.
DELETE /api/users/{userId}: Delete user account.
Post Management
POST /api/posts: Create a new post.
GET /api/posts/{postId}: Get post details by ID.
GET /api/posts/user/{userId}: Get all posts by a specific user.
GET /api/posts/feed: Get a personalized feed of posts from followed users.
PUT /api/posts/{postId}: Update post content.
DELETE /api/posts/{postId}: Delete a post.
Comment Management
POST /api/comments: Add a comment to a post.
GET /api/comments/{commentId}: Get comment details by ID.
PUT /api/comments/{commentId}: Update a comment.
DELETE /api/comments/{commentId}: Delete a comment.
Follow Management
POST /api/users/{userId}/follow: Follow a user.
DELETE /api/users/{userId}/follow: Unfollow a user.
AWS server to run and deploy out application
Contributing
Contributions to the InstaBackend project are welcome! If you find any issues or have suggestions for improvements, feel free to create a pull request or open an issue in the repository.
License
The InstaBackend project is licensed under the MIT License. You are free to use, modify, and distribute the application as per the terms of the license. See the LICENSE file for more details.
