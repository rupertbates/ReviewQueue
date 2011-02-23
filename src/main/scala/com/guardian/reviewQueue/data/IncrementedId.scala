package com.guardian.reviewQueue.data

class IncrementedId {
  var id: Int = 0
  def getNextID: Int = {
    return ({
      id += 1; id - 1
    })
  }

  def resetId: Unit = {
    id = 0
  }
}