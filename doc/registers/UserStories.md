User stories
============


US.0001 Group Creation
----------------------

A teacher can use the system fora group of students on the school.

- Teacher creates a new group of students, a unique registrator link is created.
- Teacher share the registration link with all the students.
- Students enter to the registration link and register/connect a account with the group.
- Teacher verifies the list of registered accounts and confirms then to accept on the group.
- Accepted students receive a notification of acceptance.
- Teacher closes the groups for registration. This disables the registration link.


US.0002 Course definition
-------------------------

To organize the work for a group, a teacher selects from a list of resources, materials, exercises and prepares a Course definition.

TODO Course definition schema.

US.0003 Teacher registration
----------------------------

All account can be used as a students account. To have a teacher account:

- The teacher registers a account using a email.
- The teacher requests the creation of a Teacher profile for the account.
- The system validates the user email and accepts or rejects the profile addition.


US.0004 Multiple emails binding
-------------------------------

A person can have different emails: private, from school, work email, etc.
Because a single account can have different profiles, it may be necessary to bind different emails to a single account.

- A user have a existing account.
- The user requests to addition of a new email to the account.
- A email to verify the email ownership is send with detailed explication about the process.
- The process is the accepted or rejected on the email links.

TODO: How to remove a email from an account.
TODO: Is it possible to reset the password on every email?
TODO: Are profiles and emails related? How?

US.0005 Working profile
-----------------------

A account can be user with different profiles. A Person can be a student on different schools, training companies, public courses, etc.
There are also teacher profiles that can be related to a school, company, certifications, etc.

### Register as school's teacher.

- A user have a exiting account.
- The user finds a registered school and send a registration request.
- The school administrator receives a email with information and accepts or rejects the request.
- (optional) Automatic acceptation can be realized on base of user email ( xxx@myschool.domain.edu.pl)

### Register as trainer.

- A user have a exiting account.
- The user requests a new profile as trainer on a selected topic.
- System administrators accept or reject the creation of the profile.

US.0006 Class assistance verification
-------------------------------------

A teacher during a class needs to verify the presence of the students.

Context:
- Teacher has a lesson with a group.
- Group is defined by the teacher.
- If the teacher had defined a plan of lessons with the group, then it is use to suggest any possible information.

Presence status and attributes:

- There can be different types of lessons. Depending on the lesson type, the students can have different “presence” status. (Present, delayed, Not present, remotely, telepathically)
- A student has one and only one status value per lesson. The can be defined “attribute” values for the presence list, like “delayed”, “remotely”, “sick”, etc.

A assistance list will look like this:

| student | Present | Absend | Delated | Remotely | Mobile info |
|---------|---------|--------|---------|----------|-------------|
| Jan Kol |   X     |        |         |          |             |
| Stud1   |   X     |        |    X    |          |             |
| Stud2   |         |   X    |         |          |             |
| Stud3   |   X     |        |         |          |   PRESENT   |
| Stud4   |   X     |        |         |     X    |   REMOTELY  |


### Checking list be reading the students names.

- The teacher opens the groups lists for the current lesson according to the plan.
- OPTIONAL: It is possible to create a new lesson independently of the plan
- Teacher checks all present persons, maybe reading the list and check on the list

### Checking list with students interaction by mobile app.

- Opening the list group sends command to the students to confirm the presence
- The presence list contains the student’s mobile information.
- Application selected the students status on base of the mobile information.
- The teacher can override the calculated status to any other and can check/uncheck all the attributed.

US.0007 Lessons planing
-----------------------

For a group a teacher can define a plan of lessons on the future. 
The plan will be used to guide the teacher in dependency of the current time and GPS location.
It will be possible to define ad-hoc lessons independently of the plan.  

- For any group, the systems suggest to the user to create a lessons plan
- Teacher selects a groups and starts the plan definition
- Systems ask for basic plan parameters: Lesson type, duration, etc
- System suggest different plan wizards: Periodical, weekly, custom.
- The teacher gets a report with the days/hours generated and relevant holidays information.
- The teacher accepts the plan or modifies it as long as it is required.

A plan is just used to suggest and inform, so on every time the plan can be changed, event for lessons on the pass.