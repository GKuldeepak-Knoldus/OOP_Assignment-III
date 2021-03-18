package org.knoldus.dao

trait DAO [T]{

  def createUser(t:T) : Boolean

  def listUser(): List[T]

  def updateUser(id: Int , name: String) : Boolean

  def deleteUser(id: Int) : Boolean

  def listUserId() : List[Int]

  def getUserNameById(id : Int) : String

}
