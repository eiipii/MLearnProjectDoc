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

### Register as teacher school.

- A user have a exiting account.
- The user finds a registered school and send a registration request.
- The school administrator receives a email with information and accepts or rejects the request.
- (optional) Automatic acceptation can be realized on base of user email ( xxx@myschool.domain.edu.pl)
