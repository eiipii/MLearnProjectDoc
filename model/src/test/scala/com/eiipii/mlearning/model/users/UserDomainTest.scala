package com.eiipii.mlearning.model.users

import com.eiipii.mlearning.model.reference.MLearnTypeNamespace
import com.eiipii.mlearning.model.reference.MLearnTypeNamespace.{UserID, UserProfileID}
import org.scalatest.{FlatSpec, Matchers}

class UserDomainTest extends FlatSpec with Matchers {

  val testUserID: UserID = MLearnTypeNamespace.createUserID("user1")
  val defaultProfileID: UserProfileID = MLearnTypeNamespace.createDefaultProfile(testUserID)

  it should "Create a user account" in {
    val userAdded = UserAccount(
      testUserID,
      "user1@eiipii.com",
      validated = false,
      Set(),
      Map(defaultProfileID -> UserProfile(defaultProfileID, false))
    )

    val userValidated = UserAccount(
      testUserID,
      "user1@eiipii.com",
      validated = true
    )

  }

  it should "Add email to user" in {
    val userValidated = UserAccount(testUserID, "user1@eiipii.com", validated = true)

    val afterEmailAdded = UserAccount(testUserID,
      "user1@eiipii.com",
      validated = true,
      Set("secondEmail@eiipii.com")
    )
  }

  it should "Enable user teacher mode" in {

    val userValidated = UserAccount(testUserID, "user1@eiipii.com", validated = true)
    //User request teacher account
    // Administrator accepts
    val afterProfileToTeacher = UserAccount(
      testUserID,
      "user1@eiipii.com",
      validated = true,
      Set(),
      Map(defaultProfileID -> UserProfile(defaultProfileID, true))
    )
  }
}
