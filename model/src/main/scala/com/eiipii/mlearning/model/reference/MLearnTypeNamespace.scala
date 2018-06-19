package com.eiipii.mlearning.model.reference

import java.net.URI

import io.lemonlabs.uri.Urn

object MLearnTypeNamespace extends UserProfileProperties with ModelIDCreation {

  type URN = URI
  val userIDnid = "mlearn-user"
  type UserID = Urn //urn:mlearn-user:NSS_PARTIAL
  val userProfileIDnid = "mlearn-userProfile"

  type UserProfileID = Urn //urn:mlearn-userProfile:NSS_PARTIAL
  type ActivityID = Urn //urn:mlearn-activity:NSS_PARTIAL
  val LectureIDnid = "mlearn-lecture"
  type LectureID = Urn //urn:mlearn-lecture:NSS_PARTIAL
  val LessonIDnid = "mlearn-lesson"
  type LessonID = Urn //urn:mlearn-lesson:NSS_PARTIAL
  val LessonTypeIDnid = "mlearn-lessonType"
  type LessonTypeID = Urn //urn:mlearn-lessonType:NSS_PARTIAL

  type MaterialID = URI
  type ResultID = URI
  type ToolID = URI

  type ProfileName = String

  type Email = String
}

import MLearnTypeNamespace._

trait ModelIDCreation {

  def createUserID(partial: String): UserID = Urn(userIDnid, partial)

  def createLectureID(partial: String): LectureID = Urn(LectureIDnid, partial)

  def createLessonID(partial: String): LessonID = Urn(LessonIDnid, partial)
}

/**
  * Assumption: no '/' allowed on profile name on ui
  * Assumption: "default" profile name is not allowed
  */

trait UserProfileProperties {

  def createDefaultProfile(userId: UserID): UserProfileID =
    createUserProfile(userId, "default")

  def createUserProfile(userId: UserID, profileName: ProfileName): UserProfileID = {
    if (!profileName.matches("\\w+")) {
      throw new IllegalArgumentException(s"Profile name can only be alphanumeric.")
    }
    Urn(userProfileIDnid, userId.nss + "/" + profileName)
  }


  def extractProfileName(profile: UserProfileID): ProfileName =
    profile.nss.split("/").last

  def extractUserID(profile: UserProfileID): UserID =
    Urn(userIDnid,
      profile.nss.substring(0, profile.nss.lastIndexOf("/"))
    )
}
