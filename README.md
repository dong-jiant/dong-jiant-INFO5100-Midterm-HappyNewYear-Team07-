## Project Title
Digital University System with Authentication and Role-Based Access Control

## Team Information
- Team Name: HappyNewYear-Team07
- Member 1: Jianting Dong  NUID: 003161996  Role: Administrator Use Case & System Architecture
- Member 2: Jiachuan Li  Role: Faculty Use Case
- Member 3: Yiru Chen  Role: Student Use Case

## Project Overview
This project implements a Digital University System integrated with a role-based authentication and access control layer.
The system supports three primary roles:
- Administrator
- Faculty
- Student

Each user must authenticate through login before accessing any functionality.
After successful authentication, access to features is strictly controlled based on the user's assigned role.

Key Objectives
- Enforce secure authentication (login/logout)
- Enforce authorization (role-based feature control)
- Implement required role responsibilities
- Provide validation and user-friendly error handling
- Maintain session consistency across role transitions

## Installation and Setup
Prerequisites
- Java JDK 17+ (tested with JDK 19)
- NetBeans IDE (recommended) or any Java IDE

Setup Steps
1.Clone repository:
git clone https://github.com/dong-jiant/dong-jiant-INFO5100-Midterm-HappyNewYear-Team07-.git
cd dong-jiant-INFO5100-Midterm-HappyNewYear-Team07-
2.Open project in NetBeans (or compile with your IDE build tool).
3.Run main class: ProfileWorkAreaMainFrame

## Authentication and Access Control
Authentication
- Login is required from the main frame.
- Credentials are validated against UserAccountDirectory.
- Successful login updates lastAccessTime.
- Logout clears the active session and returns the user to the home screen.
- Invalid credentials trigger a friendly error dialog.

Authorization
Role access is validated before opening each role panel:
•Admin profile -> Admin work area
•Faculty profile -> Faculty work area
•Student profile -> Student work area

Unauthorized role/session attempts are blocked with error messages.
Session integrity is enforced so that switching users properly resets the previous session.

Demo Credentials
•Admin: admin / admin
•Faculty: faculty / faculty
•Student: student / student

## Features Implemented
Admin Use Case
- Administer user accounts (view/update/delete)
- Register persons (HR panel)
- Manage student records (add/update/delete/view)
- Manage faculty records (add/update/delete/view)
- View own profile

Faculty Use Case
- Manage courses (create/update course details)
- Manage own profile
- Generate performance reports (course and grade records)
- Manage student profiles (view interests/hobbies/progress, update progress)

Student Use Case
- Manage coursework (assignment submission + tracking)
- Register for classes (enroll/drop)
- Perform graduation audit (completed vs required credits)
- Review transcript (course history + grades/in-progress status)
- Manage own profile data (hobbies/interests/progress)

## Usage Instructions
- Start the app and log in with one of the demo credentials.
- Admin: Open user/person management panels and perform CRUD operations.
- Faculty: Add or update courses. View student profiles and optionally update progress. Generate reports and record grades.
- Student: Enroll/drop courses. Submit assignments for enrolled courses. Run graduation audit. Open transcript.

## Testing Guide
Core Test Cases
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

 Validation Checklist
- Null checks for required objects and inputs
- Input format checks for numeric fields (credits/grades)
- Friendly warning/error dialogs for invalid states

## Challenges and Solutions
- Challenge: Incomplete role panel stubs.  Solution: Implemented button actions and shared in-memory academic data store.
- Challenge: Build break from duplicate ConfigureABusiness classes.  Solution: Removed duplicate source file and kept a single seeded configuration.
- Challenge: Inconsistent session handling.  Solution: Added explicit session-aware login/logout flow in main frame.

## Future Enhancements
- Persist data to database instead of in-memory storage
- Add password hashing and stronger credential policy
- Add dedicated UI panels for transcript/report tables
- Add unit tests and integration tests for all role flows

## Contribution Breakdown
- Member 1 - Jianting Dong (Admin & System Architecture): Set up GitHub repository and project skeleton; built entire data layer (Business, PersonDirectory, UserAccountDirectory, FacultyDirectory, StudentDirectory, CourseDirectory, EnrollmentDirectory); implemented all Admin use case features; managed branch merging and integration; recorded demo video; co-created presentation slides
- Member 2 - Jiachuan Li (Faculty): Implemented all Faculty use case panels (Manage Courses, Performance Reports, Manage Student Profiles, My Profile); connected Faculty panels to CourseDirectory and EnrollmentDirectory; fixed course update and semester handling logic
- Member 3 - Yiru Chen (Student): Implemented all Student use case panels (Course Registration, Coursework Management, Graduation Audit, View Transcript); implemented enrollment validation and duplicate prevention; built graduation audit credit calculation logic; co-created presentation slides；Due to merge conflicts in compiled files and extension timing, final integration into main was completed during system consolidation to ensure a stable runnable version.
- Shared: Access-control integration, debugging, testing, README, demo video, slides

## Git and Submission Checklist
- Each member: at least 10 commits on own branch
- Each member: at least 5 pull requests
- Main branch: at least 30 commits total
- Main branch must run successfully
- Include this README in repository root
