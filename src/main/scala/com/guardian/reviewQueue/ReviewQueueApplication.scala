package com.reviewQueue

import com.google.inject.Module
import roboguice.application.RoboApplication
import java.util.List

class ReviewQueueApplication extends RoboApplication {
  protected override def addApplicationModules(modules: List[Module]): Unit = {
    modules.add(new ReviewQueueModule)
  }
}

