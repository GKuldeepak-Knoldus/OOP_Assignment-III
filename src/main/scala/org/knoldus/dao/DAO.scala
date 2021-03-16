package org.knoldus.dao

trait DAO [T]{

  def createUser(t:T) : Boolean

  def listUser(): List[(Int , T)]

  def updateUser(id: Int , name: String) : Boolean

  def deleteUser(id: Int) : Boolean

  def getUserNameByName(id : Int) : String

  def getRepository() : collection.mutable.Map[Int , T]
}
