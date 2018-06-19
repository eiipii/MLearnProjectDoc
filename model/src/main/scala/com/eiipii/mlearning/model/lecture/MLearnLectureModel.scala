package com.eiipii.mlearning.model.lecture

object MLearnLectureModel {

}


import java.time.{Duration, Instant}

import com.eiipii.mlearning.model.reference.MLearnTypeNamespace._


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

case class ResourcesPocket(materials: Set[MaterialID] = Set(),
                           tools: Set[ToolID] = Set(),
                           exercises: Set[MaterialID] = Set(),
                           tests: Set[MaterialID] = Set())

