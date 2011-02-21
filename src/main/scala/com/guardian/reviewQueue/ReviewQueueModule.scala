package com.reviewQueue

import roboguice.config.AbstractAndroidModule
import com.guardian.reviewQueue.service.ReviewConverterService
import service.ReviewFetcherService

class ReviewQueueModule extends AbstractAndroidModule {
  protected def configure: Unit = {
    bind(classOf[ReviewConverterService]).to(classOf[ReviewConverterService])
    bind(classOf[ReviewFetcherService]).to(classOf[ReviewFetcherService])
  }
}

