package com.eiipii.mlearning.model.reference

import java.net.URI
import java.time.{Duration, Instant}

import com.eiipii.mlearning.model.reference.MLearnModel.UserProfileID
import org.scalatest.FlatSpec

class MLearnModelTest extends FlatSpec {

  it should "Create a user account" in {

    val initialState = MLearnApplicationState()

    val userAdded = MLearnApplicationState(
      Set(
        UserAccount(MLearnModel.createUserID("user1"), "user1@eiipii.com")
      )
    )

    val userValidated = MLearnApplicationState(
      Set(
        UserAccount(MLearnModel.createUserID("user1"), "user1@eiipii.com", validated = true)
      )
    )

  }

  it should "Add email to user" in {

    val userValidated = MLearnApplicationState(
      Set(
        UserAccount(MLearnModel.createUserID("user1"), "user1@eiipii.com", validated = true)
      )
    )

    val afterEmailAdded = MLearnApplicationState(
      Set(
        UserAccount(MLearnModel.createUserID("user1"), "user1@eiipii.com", validated = true, Set("secondEmail@eiipii.com"))
      )
    )
  }

  it should "Enable user teacher mode" in {

    val userID = MLearnModel.createUserID("user1")
    val userValidated = MLearnApplicationState(
      Set(
        UserAccount(userID, "user1@eiipii.com", validated = true)
      )
    )

    val defaultProfileID: UserProfileID = MLearnModel.createDefaultProfile(userID)
    val afterProfileToTeacher = MLearnApplicationState(
      Set(
        UserAccount(
          MLearnModel.createUserID("user1"),
          "user1@eiipii.com",
          validated = true,
          Set("secondEmail@eiipii.com"),
          Map(defaultProfileID -> UserProfile(defaultProfileID, true)))
      )
    )
  }

  it should "Create first lecture" in {
    val teacherID = MLearnModel.createUserID("user1")
    val defaultProfileID: UserProfileID = MLearnModel.createDefaultProfile(teacherID)
    val teacherUser = MLearnApplicationState(
      Set(
        UserAccount(
          teacherID,
          "user1@eiipii.com",
          validated = true,
          Set("secondEmail@eiipii.com"),
          Map(defaultProfileID -> UserProfile(defaultProfileID, true)))
      )
    )

    val groupID001 = MLearnModel.createStudentsGroupID("grupa0001")
    val lecture001ID = MLearnModel.createLectureID("lecture001")
    val afterLectureCreate = MLearnApplicationState(
      Set(
        UserAccount(
          teacherID,
          "user1@eiipii.com",
          validated = true,
          Set("secondEmail@eiipii.com"),
          Map(defaultProfileID -> UserProfile(defaultProfileID, true)))
      ),
      Map(
        defaultProfileID -> Set(
          SingleLecture(
            lecture001ID,
            LectureInfo("intro", "opis", "pelne opis"),
            defaultProfileID,
            groupID001,
            List())
        )
      ),
      Map(
        defaultProfileID -> Set(
          StudentsGroup(groupID001, Set())
        )
      )
    )
    val student1 = MLearnModel.createUserID("student1")
    val student2 = MLearnModel.createUserID("student2")
    val afterStudentsRegistration = MLearnApplicationState(
      Set(
        UserAccount(
          teacherID,
          "user1@eiipii.com",
          validated = true,
          Set("secondEmail@eiipii.com"),
          Map(defaultProfileID -> UserProfile(defaultProfileID, true))
        ),
        UserAccount(
          student1,
          "student1@eiipii.com",
          validated = true
        ),
        UserAccount(
          student2,
          "student2@eiipii.com",
          validated = true
        )
      ),
      Map(
        defaultProfileID -> Set(
          SingleLecture(
            lecture001ID,
            LectureInfo("intro", "opis", "pelne opis"),
            defaultProfileID,
            groupID001,
            List())
        )
      ),
      Map(
        defaultProfileID -> Set(
          StudentsGroup(groupID001, Set(student2, student1))
        )
      )
    )


  }

  it should "create a lesson plan for a lecture" in {
    val lecture001ID = MLearnModel.createLectureID("lecture001")
    val teacherID = MLearnModel.createUserID("user1")
    val defaultProfileID: UserProfileID = MLearnModel.createDefaultProfile(teacherID)
    val groupID001 = MLearnModel.createStudentsGroupID("grupa0001")
    // Now lesson plan is created
    val singleLectureJustCreated = SingleLecture(
      lecture001ID,
      LectureInfo("intro", "opis", "pelne opis"),
      defaultProfileID,
      groupID001,
      List())

    val material1 = URI.create("https://material.eiipii.com/example/material1.pdf")
    val material2 = URI.create("https://material.eiipii.com/example/material2.pdf")
    val material3 = URI.create("https://material.eiipii.com/example/material3.pdf")

    val tool1 = URI.create("https://tools.eiipii.com/example/quizApp.xml")
    val tool2 = URI.create("https://tools.eiipii.com/example/losowanie.xml")
    val toolOnlineJavascriptIDE = URI.create("https://tools.eiipii.com/example/javascriptOnlineIDE.xml")

    val lectureAfterLessonPlan = SingleLecture(
      lecture001ID,
      LectureInfo("intro", "opis", "pelne opis"),
      defaultProfileID,
      groupID001,
      List(
        Lesson(
          MLearnModel.createLessonID("less001"),
          LessonDescription("Wstep do programowanie", "Co robia komputery i dlaczego. ...", "Zrozumienie dlaczego uzywamy komputerow i piszemy programy"),
          Instant.now(),
          Duration.ofHours(1),
          teacherID,
          Set(groupID001),
          LessonPlan(
            List(
              LessonPlanPeriod("_default", List(material1, material2), List(tool1))
            )
          )
        ),
        Lesson(
          MLearnModel.createLessonID("less002"),
          LessonDescription("Operacje na liczbach", "Proste operacje na liczbach i pokazanie problemow z reprezentacja liczb na komputerze.", "umiejetnosc implementacji wzorow i rownan."),
          Instant.now(), //TODO api do tworzenia czasu
          Duration.ofHours(1),
          teacherID,
          Set(groupID001),
          LessonPlan(
            List(
              LessonPlanPeriod("Teoria", List(material1, material3), List(tool2)),
              LessonPlanPeriod("Cwiczenia", List(material1, material3), List(tool2)),
              LessonPlanPeriod("Przyklady niepoprawnych obliczen", List(material1, material3), List(tool2)),
              LessonPlanPeriod("Cwiczenia z wartosciami granicznymi", List(material3), List(toolOnlineJavascriptIDE))
            )
          )
        )
      )
    )


  }
}
