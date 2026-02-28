# Digital University System with Access Control Layer

## Project Title
Digital University System with Authentication and Role-Based Access Control

## Team Information
- Team Name: `HappyNewYear-Team07`
- Member 1: `<Name>`, NUID: `<NUID>`, Role: Administrator Use Case
- Member 2: `<Name>`, NUID: `<NUID>`, Role: Faculty Use Case
- Member 3: `<Name>`, NUID: `<NUID>`, Role: Student Use Case

## Project Overview
This project implements a Digital University System with a role-based access control layer. It supports Admin, Faculty, and Student users with separate work areas and authorized features after login.

Key objectives:
- Enforce authentication (`login/logout`)
- Enforce authorization (`role-based feature access`)
- Implement required role responsibilities
- Provide validation and error handling for user operations

## Installation and Setup
### Prerequisites
- Java JDK 17+ (tested with JDK 19)
- NetBeans IDE (recommended) or any Java IDE

### Setup Steps
1. Clone repository:
```bash
git clone <your-repo-url>
cd dong-jiant-INFO5100-Midterm-HappyNewYear-Team07-
```
2. Open project in NetBeans (or compile with your IDE build tool).
3. Run main class: `Business.ProfileWorkAreaMainFrame`

## Authentication and Access Control
### Authentication
- Login is required from the main frame.
- Credentials are validated against `UserAccountDirectory`.
- Successful login updates `lastAccessTime`.
- Logout clears active session and returns to home screen.

### Authorization
- Role access is validated before opening each role panel:
  - Admin profile -> Admin work area
  - Faculty profile -> Faculty work area
  - Student profile -> Student work area
- Unauthorized role/session attempts are blocked with error messages.

### Demo Credentials
- Admin: `admin / admin`
- Faculty: `faculty / faculty`
- Student: `student / student`

## Features Implemented
### Admin Use Case
- Administer user accounts (view/update/delete)
- Register persons (HR panel)
- Manage student records (add/update/delete/view)
- Manage faculty records (add/update/delete/view)
- View own profile

### Faculty Use Case
- Manage courses (create/update course details)
- Manage own profile
- Generate performance reports (course and grade records)
- Manage student profiles (view interests/hobbies/progress, update progress)

### Student Use Case
- Manage coursework (assignment submission + tracking)
- Register for classes (enroll/drop)
- Perform graduation audit (completed vs required credits)
- Review transcript (course history + grades/in-progress status)
- Manage own profile data (hobbies/interests/progress)

## Usage Instructions
1. Start app and login with one of the demo users.
2. Admin:
- Open user/person management panels and perform CRUD operations.
3. Faculty:
- Add or update courses.
- View student profiles and optionally update progress.
- Generate reports and record grades.
4. Student:
- Enroll/drop courses.
- Submit assignments for enrolled courses.
- Run graduation audit.
- Open transcript.

## Testing Guide
### Core Test Cases
1. Authentication
- Valid login succeeds.
- Invalid login fails with message.
2. Authorization
- Admin cannot access Faculty/Student features directly.
- Faculty and Student only see their own feature set.
3. CRUD and Validation
- Duplicate IDs/usernames are blocked.
- Empty required fields are blocked.
- Delete/update actions refresh tables.
4. Student/Faculty Functional Flows
- Student enrolls -> can submit assignment.
- Faculty records grade -> student transcript reflects result.
- Graduation audit updates after completed courses.

### Validation Checklist
- Null checks for required objects and inputs
- Input format checks for numeric fields (credits/grades)
- Friendly warning/error dialogs for invalid states

## Challenges and Solutions
- Challenge: Incomplete role panel stubs.
- Solution: Implemented button actions and shared in-memory academic data store.

- Challenge: Build break from duplicate `ConfigureABusiness` classes.
- Solution: Removed duplicate source file and kept a single seeded configuration.

- Challenge: Inconsistent session handling.
- Solution: Added explicit session-aware login/logout flow in main frame.

## Future Enhancements
- Persist data to database instead of in-memory storage
- Add password hashing and stronger credential policy
- Add dedicated UI panels for transcript/report tables (instead of dialog-heavy flows)
- Add unit tests and integration tests for all role flows

## Contribution Breakdown
- Member 1 (Admin): Admin user/person/student/faculty management, validations, profile view
- Member 2 (Faculty): Course management, performance reporting, student-profile management
- Member 3 (Student): Coursework, registration, audit, transcript, profile updates
- Shared: Access-control integration, debugging, testing, README, demo video, slides

## Presentation and Demo Submission
- Prepare 5-minute team slide deck:
  - Architecture
  - Access control design
  - Role feature walkthrough
  - Testing evidence
  - Challenges + future work
- Upload demo video:
  - `.mp4` file on Canvas
  - Unlisted YouTube link on Canvas

## Git and Submission Checklist
- Each member: at least 10 commits on own branch
- Each member: at least 5 pull requests
- Main branch: at least 30 commits total
- Main branch must run successfully
- Include this README in repository root
