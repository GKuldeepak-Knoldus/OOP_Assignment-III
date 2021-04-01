package org.knoldus.models

import scala.concurrent.Future

trait DAO[T] {

  def createUser(t: T): Future[Boolean]

  def listUser(): Future[List[T]]

  def updateUser(id: Int, name: String): Future[Boolean]

  def deleteUser(id: Int): Future[Boolean]

  def listUserId(): Future[List[Int]]

  def getUserNameById(id: Int): Future[String]

}
