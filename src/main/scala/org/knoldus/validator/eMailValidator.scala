package org.knoldus.validator

class eMailValidator {
  def isValidEmail(email: String): Boolean =
    """^[a-zA-Z0-9]+@[a-zA-Z0-9]+(\.)+(com|net|org)""".r.unapplySeq(email).isDefined
}
