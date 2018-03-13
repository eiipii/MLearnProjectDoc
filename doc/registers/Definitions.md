Definitions
===========


Learning material
-----------------

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

 - URI (mandatory)
 - Estimated time necessary to perform the material activities
 - Difficulty level
 - Duration

Learning tool
-------------

A **learning tool** is a program or functionality that allows to interact with a learning material, possible allowing to generate a learning result.

 
Learning results
----------------

A **learning result** is the immutable final response to a learning material provided by a user using a learning tool.

Group
-----

A **group** is a set of students, identified by authenticated accounts on the system.

The system will record the complete history of a group content.

A group is identified by unique URN.

Lesson
------

A **lesson** is a continuous and bounded in time interaction between a teacher and a one or many group.

A lesson is identified by a unique URN.

Lesson type
-----------

TODO

Presence status
---------------

A **presence status** is the information about student assistance to a lesson.

The possible value of a presence status is defined on the lesson type and consist of:
- Single value from predefined status enumeration
- Set of values from predefined attributes enumeration

Lesson plan
-----------

A **lesson plan** is a schedule of potential lessons in time.

Lecture
-------

A **lecture** defined a context with
 - One or many teachers
 - One main teacher
 - One or many groups
 - One or many lesson types
 - One lesson plan

TODO: Czy to definiuje nasze pojecia:
- Kurs 
  - Wyklad (1 nauczyciel, 1 grupa)
  - Wyklad ze cwiczeniami (1 nauczyciel, 1 grupa, 2 typu zajec)
  - Wyklad  + grupy prowadzone przez cwiczeniowcow. (1+n nauczycieli, n grupa)
  - Seminarium (Tu student moze tez wrzucac materialy)

Activities
----------

A **activity** is an interaction of a user with a teaching material.

TODO: czy to definiuje
- Praca domowa, wejsciowka, zejsciowka. To jest zwiazane z typem zajec, po przed, co po, co w trakcie.


Organization
------------

Not defined on VER-1