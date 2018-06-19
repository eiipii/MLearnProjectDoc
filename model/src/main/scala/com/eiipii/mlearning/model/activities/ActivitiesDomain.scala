package com.eiipii.mlearning.model.activities

import com.eiipii.mlearning.model.activities.PresenceAttribute.PresenceAttribute
import com.eiipii.mlearning.model.activities.PresenceStatus.PresenceStatus
import com.eiipii.mlearning.model.reference.MLearnTypeNamespace._

object ActivitiesDomain {

}

case class LessonExecutionHistory(lessonLog: List[LessonLogEntry] = List())

sealed trait LessonLogEntry

case class Activity(activityId: ActivityID, tool: ToolID, material: MaterialID) extends LessonLogEntry

case class Result(resultId: ResultID, activity: ActivityID, userProfile: UserProfileID) extends LessonLogEntry

case class PresenceVerification(presenceInfo: List[PresenceInformation]) extends LessonLogEntry


case class PresenceInformation(student: UserProfileID, status: PresenceStatus, attributes: Set[PresenceAttribute])

object PresenceStatus extends Enumeration {
  type PresenceStatus = Value
  val present, notPresent = Value
}

object PresenceAttribute extends Enumeration {
  type PresenceAttribute = Value
  val delayed, online, sick = Value
}

