# Resolution Reminder

A simple web application to help users set New Year's resolutions and receive reminders on specific dates.

## Table of Contents
1. [Introduction](#introduction)
2. [Features](#features)
2. [Tech Stack](#tech-stack)
3. [Project Structure](#project-structure)
4. [Getting Started]($getting-started)

## Introduction
Resolution Reminder is a tool designed to help users keep track of their New Year's resolutions by allowing them to set goals and schedule reminders.

## Features
- User authentification (register and login).
- Create and manage New Year's resolutions.
- Automatic email reminders for resolutions.

## Tech Stack
- Java (Spring Boot)
- MySQL
- Spring Data JPA
- Spring Security
- Thymeleaf (optional for front-end)

## Project Structure
src/main/java/com/example/resolutionreminder/
├── model            # Entity classes
├── repository       # Database interactions
├── service          # Business logic
├── controller       # Handles HTTP requests
└── config           # Application configuration