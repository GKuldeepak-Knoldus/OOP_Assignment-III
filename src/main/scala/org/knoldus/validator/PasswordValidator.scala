package org.knoldus.validator

class PasswordValidator {
  def isValidPassword(password: String): Boolean =
    """^[a-zA-Z0-9!@#$%^&].{8,12}""".r.unapplySeq(password).isDefined
}
