Definitions
===========

MLearn User
-----------

Identifier: URN
Schema: urn:mlearn:user:NSS_PARTIAL

Uniquely identifier account.

MLearning User Profile
----------------------

Identifier: URN
Schema: urn:mlearn:userProfile:NSS_PARTIAL

A unique URN identifier that allows to calculate a user account identifier and a internal profile name.  

Learning material
-----------------

Identifier: URI

**Teaching material** or **material** is a immutable content that can be exported, imported, stored as a single file, retrieved , shared and used to learn.

Some teaching materials will require a specific program or tool to be used.

Examples of teaching materials are:

 - Text, books, articles
 - Images, music, videos, presentations
 - Statistical data
 - Quiz, exercise list, test
 - Online training courses

The followings are not example of teaching materials:

 - Web pages. There are dynamic and change over time.
 - Quiz generators.
 - Reports, if the content may change over time.
 - Quiz results, tests statistics

 
Teaching material can have attributes as:
 - Estimated time necessary to perform the material activities
 - Difficulty level
 - Duration

Learning tool
-------------

Identifier: URI

A **learning tool** is a program or functionality that allows to interact with a learning material, possible allowing to generate a learning result.

A tool may be presented as the URL to the related tool page. For tools integrated with MLearning, the URL will lead to a metadata information about the tools interfaces and capabilities. 

Activity
--------

Identifier: URN
Schema: urn:mlearn:activity:NSS_PARTIAL

A **activity** is an interaction of a user with a teaching material with a specific learning tool.

 
Learning results
----------------

Identifier: URI

A **learning result** is the immutable final response to a learning material provided by a user using a learning tool during an activity.

Students Group
--------------

Identifier: URN
Schema: urn:mlearn:studentsGroup:NSS_PARTIAL

A **group** is a set of students, identified by a user profile on the system.

The system will record the complete history of a group content.

A group is identified by unique URN.

Lesson
------

Identifier: URN
Schema: urn:mlearn:lesson:NSS_PARTIAL

A **lesson** is a continuous and bounded in time interaction between a teacher and a one or many group.

A **lesson** has a title.

A **lesson** has a lesson plan, it is a list periods with attachments.
Each period will have a name and a goal.
To each period there can be attached materials and learning tools.

During a lesson realization, teachers will be able to conduct any activity. 
The attached materials and learning tools will help to provide hints to the teacher. 

Lesson type
-----------

Identifier: URN
Schema: urn:mlearn:lessonType:NSS_PARTIAL

A predefined **lesson type** defines a order for the realization of a lesson. 
A lesson type have a list of named lesson periods.
A lesson period defines a name and a goal.

A lesson instance will link to each period a set of potential activities and materials.

Presence information
--------------------

Identifier: none

A **presence information** is the information about student assistance to a lesson.

The possible value of a presence status is defined on the lesson type and consist of:
- Single value from predefined status enumeration
- Set of values from predefined attributes enumeration

Presence Status
---------------

Identifier: URN
Schema: urn:mlearn:presenceStatus:NSS_PARTIAL

A enumeration value for presence information

Presence Attribute
---------------

Identifier: URN
Schema: urn:mlearn:presenceAttribute:NSS_PARTIAL

A enumeration value for presence attributes.

Lessons plan
-----------

Identifier: none

A **lessons plan** is a schedule of potential lessons in time.

Lecture
-------

Identifier: URI

A **lecture** defined a context with
 - One or many teachers
 - One main teacher
 - One or many groups
 - One or many lesson types
 - One lesson plan

Organization
------------

Not defined on VER-1