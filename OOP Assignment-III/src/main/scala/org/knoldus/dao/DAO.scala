package org.knoldus.dao

import java.util.UUID

trait DAO [T]{

  def createUser(t:T)

  def listUser(): List[UUID]

  def updateUser(id: UUID , name: String)

  def deleteUser(id: UUID)
}
