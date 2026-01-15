# Multi-Client Chat Application

A Java-based multi-client chat application that allows multiple users to connect and communicate in real-time using socket programming.

## Features

- Support for multiple clients connecting simultaneously
- Real-time message broadcasting to all connected clients
- Client-server architecture using Java sockets
- Thread-based handling for each client connection
- User join/leave notifications
- Simple command-line interface

## Technologies

- Java
- Socket Programming (TCP/IP)
- Multi-threading
- Input/Output Streams

## Project Structure

The application consists of the following main components:
- **ChatServer**: Manages server operations and client connections
- **ClientHandler**: Handles individual client communication threads
- **ChatClient**: Client-side application for connecting to the server
- **Main**: Entry point for running the application

## How to Run

### Starting the Server
1. Compile the Java files:
```
   javac *.java
```
2. Run the server:
```
   java ChatServer
```
   The server will start listening for client connections.

### Connecting Clients
1. In a new terminal, run the client:
```
   java ChatClient
```
2. Enter your username when prompted
3. Start chatting! Messages will be broadcast to all connected clients

## How It Works

- The server listens on a specific port for incoming client connections
- Each client connection is handled by a separate thread (ClientHandler)
- Messages from any client are broadcast to all other connected clients
- The server maintains a list of all active client handlers

## Author

Built as part of learning Java networking and concurrent programming.
