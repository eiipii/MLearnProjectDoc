package com.eiipii.mlearning.model.reference

import java.net.URI

import io.lemonlabs.uri.{Url, Urn}
import java.time.{Duration, Instant}

import com.eiipii.mlearning.model.reference.PresenceAttribute.PresenceAttribute
import com.eiipii.mlearning.model.reference.PresenceStatus.PresenceStatus

object MLearnModel extends UserProfileProperties {

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

  type ProfileReference = String

  def createUserID(partial: String): UserID = Urn(userIDnid, partial)

  def createLectureID(partial: String): LectureID = Urn(LectureIDnid, partial)

  def createLessonID(partial: String): LessonID = Urn(LessonIDnid, partial)

  type Email = String
}

import MLearnModel._

/**
  * Assumption: no '_' and '#' allowed on profile name on ui
  */
trait UserProfileProperties {

  def createDefaultProfile(userId: UserID): UserProfileID =
    createUserProfile(userId, "_default")

  def createUserProfile(userId: UserID, profileName: ProfileReference): UserProfileID =
    Urn(userProfileIDnid, userId.nss + "#" + profileName)


  def extractProfileName(profile: UserProfileID): ProfileReference =
    profile.nss.split("#").last

  def extractUserID(profile: UserProfileID): UserID =
    Urn(userIDnid, profile.nss.split("#").head)
}

//Application status per user:

case class MLearnApplicationState(accounts: Set[UserAccount] = Set(),
                                  profileLectures: Map[UserProfileID, Set[Lecture]] = Map()
                                 )

//User related information
case class UserAccount(userID: UserID,
                       primaryEmail: Email,
                       validated: Boolean = false,
                       additionalEmails: Set[Email] = Set(),
                       profiles: Map[UserProfileID, UserProfile] = Map())

case class UserProfile(profileID: UserProfileID, isTeacher: Boolean)

//Lecture model
case class Lecture(lectureID: LectureID,
                   info: LectureInfo,
                   teacher: UserProfileID,
                   studentsGroup: StudentsGroup,
                   lectureResources: ResourcesPocket,
                   schedule: List[Lesson] = List())

case class StudentsGroup(acceptedStudents: Set[UserProfileID] = Set(),
                         rejectedStudents: Set[UserProfileID] = Set(),
                         registrationClosed: Boolean = false)

case class LectureInfo(introduction: String,
                       shortDescription: String,
                       description: String)

case class Lesson(lessonId: LessonID,
                  description: LessonDescription,
                  start: Instant,
                  duration: Duration,
                  plan: List[LessonPlanPeriod] = List())

case class LessonDescription(title: String,
                             description: String,
                             goal: String)

case class LessonPlanPeriod(name: String, resources: ResourcesPocket)

case class ResourcesPocket(materials: Set[MaterialID] = Set(), tools: Set[ToolID] = Set())


//Lesson execution model

case class LessonExecutionHistory(presenceInfo: List[PresenceInformation],
                                  lessonLog: List[LessonLogEntry])

sealed trait LessonLogEntry

case class Activity(activityId: ActivityID, tool: ToolID, material: MaterialID)

case class Result(resultId: ResultID, activity: ActivityID, userProfile: UserProfileID)


case class PresenceInformation(student: UserProfileID, status: PresenceStatus, attributes: Set[PresenceAttribute])

object PresenceStatus extends Enumeration {
  type PresenceStatus = Value
  val present, notPresent = Value
}

object PresenceAttribute extends Enumeration {
  type PresenceAttribute = Value
  val delayed, online, sick = Value
}
