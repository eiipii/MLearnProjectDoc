package com.eiipii.mlearning.model.reference

import com.eiipii.mlearning.model.lecture.Lecture
import com.eiipii.mlearning.model.reference.MLearnTypeNamespace._
import com.eiipii.mlearning.model.users.UserAccount

object MLearnModel {

}


//Application status per user:

case class MLearnApplicationState(accounts: Set[UserAccount] = Set(),
                                  profileLectures: Map[UserProfileID, Set[Lecture]] = Map())


