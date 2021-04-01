package org.knoldus.models

sealed trait UserType

object UserType{

  case object ADMIN extends UserType

  case object CUSTOMER extends UserType
}