User stories
============

US.0001 Group Creation
----------------------

A teacher can use the system for a group of students on the school, but first it must define the group.

- Teacher creates a new group of students, a unique registration link is created and provided to the teacher.
- Teacher share the registration link with all the students.
- Students enter to the registration link and register/connect a account with the group.
- Teacher verifies the list of registered accounts and accepts then on the group.
- Accepted students receive a notification of acceptance.
- Teacher closes the groups for registration. This disables the registration link.

For VER-1 a teacher can access only the groups that he/she has created.

US.0002 Lecture definition
--------------------------

For VER-1 we will only allow ad-hoc lecture definition for a single teacher.

### School lecture
As a teacher
- The group is selected.
- The lecture parameters are defined.
- One or many lesson type are selected.
- A optional step to define a lessons plan is provided.

US.0003 Multiple emails binding
-------------------------------

A person can have different emails: private, from school, work email, etc.
Because a single account can have different profiles, it may be necessary to bind different emails to a single account.

- A user have a existing account.
- The user requests to addition of a new email to the account.
- A email to verify the email ownership is send with detailed explication about the process.
- The process is the accepted or rejected on the email links.

The user has a primary email address that can be changed over time. 
The primary email can not be deleted. 
Other emails can be deleted.


US.0004 Working profile
-----------------------

A account can be used with different profiles. A user can be a student on different schools, training companies, public courses, etc.
There are also teacher profiles that can be related to a school, company, certifications, etc.

### Register as teacher.

- A user have a exiting account.
- The user requests a new profile as teacher.
- System administrators accept or reject the creation of the profile.


### ~~Register as school's teacher. (for VER-2)~~

- A user have a exiting account.
- The user finds a registered school and send a registration request.
- The school administrator receives a email with information and accepts or rejects the request.
- (optional) Automatic acceptation can be realized on base of user email ( xxx@myschool.domain.edu.pl)

US.0005 Class assistance verification
-------------------------------------

A teacher during a class needs to verify the presence of the students.

Context:
- Teacher has a lesson with a group in the context of a defined lecture.
- If the teacher had defined a plan of lessons with the group, then it is use to suggest any possible information.

A assistance list will look like this:

| student | Status  | Delayed| Remotely| Mobile info |
|---------|---------|--------|---------|-------------|
| Jan Kol | Present |        |         |             |
| Stud1   | Absent  |        |    X    |             |
| Stud2   | Present |   X    |         |             |
| Stud3   | Present |        |         |   PRESENT   |
| Stud4   | Present |        |         |   REMOTELY  |

where presence status is defined as:
- status enumeration: Present, Absent
- attribute enumeration: Delayed, Remotely

### Checking list be reading the students names.

- The teacher opens the groups lists for the current lesson according to the plan.
- OPTIONAL: It is possible to create a new lesson independently of the plan
- Teacher checks all present persons, maybe reading the list and check on the list

### Checking list by voice recognition

- The teacher opens the groups lists for the current lesson according to the plan.
- The voice recognition options is enabled
- Students says they lastname in order, and the application records and analyzes the sound to verify presence.
- Teacher can review results and correct any errors.

### Checking list with students interaction by mobile app.

- Opening the list group, the system send a request for information to all students mobile apps.
- The presence list contains the student’s mobile information.
- Application selected the students status on base of the mobile information.
- The teacher can override the calculated status to any other and can check/uncheck all the attributed.

The mobile information will contain a summary of all accessible information from the student mobile application.
The display style for a student can be modified depending on the mobile information, like for example when the GPS
coordinates do not match expected location.

Presence status is defined only with enumerations. In the case that additional information can be registered, like
delay time, then it should be calculated without the interaction of the users.

US.0006 Lessons planing for VER-1
---------------------------------

In the context of a lecture, a lessons plan can be defined.
The lessons plan will be used to guide the teacher in dependency of the current time and GPS location.
It will be possible to define ad-hoc lessons independently of the plan.  

For any lecture without lessons plan, the systems suggest to the user to create a lessons plan

- Teacher selects a lecture and starts the lessons plan definition
- Systems ask for basic plan parameters: duration, etc
- System suggest different plan wizards: Periodical, weekly, custom.
- The teacher gets a report with the days/hours generated and relevant holidays information.
- The teacher accepts the plan or modifies it as long as it is required.

A plan is just used to suggest and inform, so on every time the lessons plan can be changed, even for lessons on the pass.

US.0007 Learning material creation and use
------------------------------------------

### Register a material from file

As a teacher
- Open the material registration page
- Select presentation from the list of materials types
- Select the file of the presentation
- A unique URI is generated and assigned to the material.
- After the file is uploaded, a summary of the detected type and metadata is presented
- If license information is not available on the metadata, then a license selection form is provided
- Copyright warning information is presented and must be confirmed 
- Teacher confirms the material creation.

### Add metadata to material

As a student during a lesson
- Select a learning material (URI in context selected) from the list provided from the teacher
- Select details and use "add info" button
- From a popup list select in with context you want to add the information: Lesson, Lecture, Personal
- Use a metadata form to add attributes to the material in the selected context.

The different context change when the attribute is visible and used for search:
- Personal: Always used and visible
- Lecture: Only when present lecture context is used
- Lesson: Only when present lesson context is used

US.008 Quiz preparation
-----------------------

A quiz is a list of questions with several response options. Correct answer to a questions can be one or many options.

As a teacher
- Open the quiz application link (https://quiz..../)
- Login is realized automatically or user is redirected to login
- A new quiz can be created or a previous file can be uploaded to edit
- After edition, the quiz can be saved as a epub file.  