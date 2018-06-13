package com.eiipii.mlearning.model.reference

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
          SingleLecture(defaultProfileID, groupID001, List())
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
          SingleLecture(defaultProfileID, groupID001, List())
        )
      ),
      Map(
        defaultProfileID -> Set(
          StudentsGroup(groupID001, Set(student2, student1))
        )
      )
    )
  }

}
