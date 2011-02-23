package com.guardian.reviewQueue.data
import com.db4o.{ObjectSet, Db4o, ObjectContainer}
import com.guardian.reviewQueue.model.Entity
import java.io.File
import scala.collection.JavaConversions.asScalaBuffer

class db4oRepository[T <: Entity](dbFilePath: String)(implicit man: Manifest[T]) {
  private var oc : ObjectContainer = _
  val config = Db4o.newConfiguration

  protected var tClass  = man.erasure.asInstanceOf[Class[T]]


  protected def db: ObjectContainer = {
    try {
      if (oc == null || oc.ext.isClosed) oc = Db4o.openFile(config, dbFilePath)
      return oc
    }
    catch {
      case e: Exception => {
        return null
      }
    }
  }

  def close = {
    if (oc != null) {
      oc.close
      oc = null
    }
  }

  def commit = {
    db.commit
  }

  def rollback = {
    db.rollback
  }

  def save(entity: T) = {
    if (entity.Id == 0) entity.Id = getNextId
    db.store(entity)
    db.commit
  }

  def getAll : List[T] = {
    val results = db.query(tClass)
    return results.toList
  }

  def getById(id: Int): T = {
    val example: T = tClass.newInstance
    example.Id = id
    val results = db.queryByExample(example)
    if (results.size == 0) return null.asInstanceOf[T]
    return results.get(0)
  }

  def deleteDatabase = {
    close
    new File(dbFilePath).delete
  }

  def backup(path: String) = {
    db.ext.backup(path)
  }

  def restore(path: String) = {
    deleteDatabase
    new File(path).renameTo(new File(dbFilePath))
    new File(path).delete
  }

  def getNextId: Int = {
    val result: ObjectSet[IncrementedId] = db.queryByExample(classOf[IncrementedId])
    var ii: IncrementedId = null
    var nextId: Int = 0
    if (result.hasNext) {
      ii = result.next.asInstanceOf[IncrementedId]
    }
    else {
      ii = new IncrementedId
    }
    nextId = ii.getNextID
    db.store(ii)
    return nextId
  }
}