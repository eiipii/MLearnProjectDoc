package com.eiipii.mlearning.model.reference

import java.net.URI
import io.lemonlabs.uri.Urn
import java.time.{Duration, Instant}

object MLearnModel extends UserProfileProperties {

  type URN = URI
  val userIDnid = "mlearn-user"
  type UserID = Urn //urn:mlearn-user:NSS_PARTIAL
  val userProfileIDnid = "mlearn-userProfile"

  type UserProfileID = Urn //urn:mlearn-userProfile:NSS_PARTIAL
  type ToolID = Urn //urn:mlearn-tool:NSS_PARTIAL
  type ActivityID = Urn //urn:mlearn-activity:NSS_PARTIAL
  val StudentsGroupIDnid = "mlearn-studentsGroup"
  type StudentsGroupID = Urn //urn:mlearn-studentsGroup:NSS_PARTIAL
  type lectureID = Urn //urn:mlearn-lecture:NSS_PARTIAL
  type LessonID = Urn //urn:mlearn-lesson:NSS_PARTIAL
  type LessonTypeID = Urn //urn:mlearn-lessonType:NSS_PARTIAL

  type MaterialID = URI
  type ResultID = URI

  type ProfileReference = String

  def createUserID(partial: String): UserID = Urn(userIDnid, partial)

  def createStudentsGroupID(groupPartial: String): StudentsGroupID = Urn(StudentsGroupIDnid, groupPartial)

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
                                  profileLectures: Map[UserProfileID, Set[Lecture]] = Map(),
                                  profileGroups: Map[UserProfileID,Set[StudentsGroup]] = Map())

//User related information
case class UserAccount(userID: UserID,
                       primaryEmail: Email,
                       validated: Boolean = false,
                       additionalEmails: Set[Email] = Set(),
                       profiles: Map[UserProfileID, UserProfile] = Map())

case class UserProfile(profileID: UserProfileID, isTeacher: Boolean)

// Model


sealed trait PresenceStatus

case object Present extends PresenceStatus

case object NotPresent extends PresenceStatus


sealed trait PresenceAttribute

case object Delayed extends PresenceAttribute

case object Online extends PresenceAttribute

case object Sick extends PresenceAttribute

case class PresenceInformation(status: PresenceStatus, attributes: Set[PresenceAttribute])

sealed trait Lecture

//TODO add lecture description
case class SingleLecture(teacher: UserProfileID,
                         group: StudentsGroupID,
                         harmonogram: List[Lesson]) extends Lecture

case class LectureWithExercises(mainTeacher: UserProfileID,
                                teacherStaff: Set[UserProfileID],
                                groups: Set[StudentsGroupID],
                                exerciseTeachers: Map[UserProfileID, StudentsGroupID],
                                harmonogram: List[Lesson]) extends Lecture


case class Lesson(lessonId: LessonID,
                  description: LessonDescription,
                  start: Instant,
                  duration: Duration,
                  teacher: UserProfileID,
                  lessonGroups: Set[StudentsGroupID],
                  plan: LessonPlan)

case class LessonDescription(title: String,
                             description: String,
                             goal: String)

case class LessonPlan(lessonPeriods: List[LessonPlanPeriod])

case class LessonPlanPeriod(name: String,
                            materials: List[MaterialID],
                            tools: List[ToolID])


case class Activity(activityId: ActivityID,
                    tool: ToolID,
                    material: MaterialID)

case class Result(resultId: ResultID,
                  activity: ActivityID,
                  userProfile: UserProfileID)


case class StudentsGroup(groupId: StudentsGroupID,
                         students: Set[UserProfileID])


case class LessonType(lessonTypeId: LessonTypeID,
                      lessonTypeName: String,
                      periods: List[LessonPeriod])

case class LessonPeriod(name: String, goal: String)
