package com.guardian.reviewQueue.model

object Enumeration {
  def AbsoluteDifference(firstValue: Enumeration, secondValue: Enumeration): Int = {
    return Math.abs(firstValue.Id - secondValue.Id)
  }
}

abstract class Enumeration extends Entity {
  def this() {
    this ()
    `super`
  }

  protected def this(id: Int, name: String) {
    this ()
    `this`(id, name, name, true)
  }

  protected def this(id: Int, name: String, displayName: String, showInUI: Boolean) {
    this ()
    Id = id
    Name = name
    DisplayName = displayName
    ShowInUI = showInUI
  }

  def ToString: String = {
    return DisplayName
  }

  def Equals(other: Enumeration): Boolean = {
    if (other == null) {
      return false
    }
    return Id == other.Id
  }

  var ShowInUI: Boolean = null
  var Name: String = null
  var DisplayName: String = null
}