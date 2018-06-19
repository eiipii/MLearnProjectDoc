package com.eiipii.mlearning.model.users

import com.eiipii.mlearning.model.reference.MLearnTypeNamespace.{ProfileName, UserProfileID}
import com.eiipii.mlearning.model.reference.{MLearnApplicationState, MLearnTypeNamespace}
import io.lemonlabs.uri.Urn
import org.scalatest.{FlatSpec, Matchers}

class UserDomainProfileContract extends FlatSpec with Matchers {

  it should "create userID and profiles" in {

    val userID: Urn = MLearnTypeNamespace.createUserID("testUser1")
    userID.toString() shouldBe ("urn:mlearn-user:testUser1")

    val profile1 = MLearnTypeNamespace.createUserProfile(userID, "NauczycielSTO")
    val profile2 = MLearnTypeNamespace.createUserProfile(userID, "EnglishOK")
    profile1.toString() shouldBe ("urn:mlearn-userProfile:testUser1/NauczycielSTO")
    profile2.toString() shouldBe ("urn:mlearn-userProfile:testUser1/EnglishOK")
  }

  it should "has default profile" in {

    val userID: Urn = MLearnTypeNamespace.createUserID("testUser1")
    userID.toString() shouldBe ("urn:mlearn-user:testUser1")

    val defaultProfile = MLearnTypeNamespace.createDefaultProfile(userID)

    defaultProfile.toString() shouldBe ("urn:mlearn-userProfile:testUser1/default")

    MLearnTypeNamespace.extractUserID(defaultProfile) shouldBe userID
  }

  it should "Map between userID and ProfileID" in {
    import org.scalatest.prop.TableDrivenPropertyChecks._
    val testData =
      Table(
        ("userID", "ProfileName"), // First tuple defines column names
        ("test1", "p1"), // Subsequent tuples define the data
        ("path/p1/pe/dpd/user", "any"),
        ("kfdlgksdlfgnsldfnglskdfg", "any")
      )
    forAll(testData) { (userName: String, profileName: ProfileName) =>

      val userID: Urn = MLearnTypeNamespace.createUserID(userName)
      val profileID = MLearnTypeNamespace.createUserProfile(userID, profileName)

      MLearnTypeNamespace.extractUserID(profileID) shouldBe (userID)
    }
  }

  it should "not allow '/' values in profile name" in {

    val userID: Urn = MLearnTypeNamespace.createUserID("testUser1")

    the[IllegalArgumentException] thrownBy {
      MLearnTypeNamespace.createUserProfile(userID, "bad/name")
    } should have message "Profile name can only be alphanumeric."
  }

}
