package com.guardian.reviewQueue.model

trait Enumeration {
  val Id: Int
  val Name: String
  val DisplayName: String
  val ShowInUI: Boolean

  def ToString = DisplayName

  def AbsoluteDifference(firstValue: Enumeration, secondValue: Enumeration): Int = Math.abs(firstValue.Id - secondValue.Id)

  def Equals(other: Enumeration): Boolean = {
    if (other == null) return false
    Id == other.Id
  }
}