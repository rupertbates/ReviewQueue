package com.guardian.reviewQueue.model

import java.util.Date

class Log extends Entity {
  var Date: Date = null
  var Thread: String = null
  var Context: String = null
  var Level: String = null
  var Logger: String = null
  var Message: String = null
  var Exception: String = null
}