package org.knoldus.validator

import org.scalatest.flatspec.AsyncFlatSpec

class eMailValidatorTesting extends AsyncFlatSpec {
  val eMailValidator = new eMailValidator

  "isValidEmail " should "return true " in {
    val result = eMailValidator.isValidEmail("hupta@gmail.com")
    assert(result)
  }

  it should "return false because of @ symbol " in {
    val result = eMailValidator.isValidEmail("guptagmail.com")
    assert(!result)
  }
}
