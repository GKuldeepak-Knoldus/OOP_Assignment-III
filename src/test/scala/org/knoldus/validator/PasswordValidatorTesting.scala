package org.knoldus.validator

import org.scalatest.flatspec.AsyncFlatSpec

class PasswordValidatorTesting extends AsyncFlatSpec{
  val passwordValidator = new PasswordValidator

  "isValidPassword" should "return true " in {
    val result = passwordValidator.isValidPassword("KG@1234Gupta")
    assert(result)
  }

  it should "return false because of less length " in {
    val result = passwordValidator.isValidPassword("KG")
    assert(!result)
  }

  it should "return false because of more length " in {
    val result = passwordValidator.isValidPassword("KGiygdygdsyvbuiyfbusbvybsuivbfvyb")
    assert(!result)
  }

  it should "return false because of number " in {
    val result = passwordValidator.isValidPassword("KG@gupta")
    assert(!result)
  }
}
