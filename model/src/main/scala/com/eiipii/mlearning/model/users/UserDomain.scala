package com.eiipii.mlearning.model.users

import com.eiipii.mlearning.model.reference.MLearnTypeNamespace.{Email, UserID, UserProfileID}

object UserDomain {

}

//User related information
case class UserAccount(userID: UserID,
                       primaryEmail: Email,
                       validated: Boolean = false,
                       additionalEmails: Set[Email] = Set(),
                       profiles: Map[UserProfileID, UserProfile] = Map())

case class UserProfile(profileID: UserProfileID, isTeacher: Boolean)
