package com.guardian.reviewQueue.activities

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget._
import com.google.inject.Inject
import com.reviewQueue.R
import com.reviewQueue.adapters.ReviewAdapter
import com.reviewQueue.model.Review
import com.reviewQueue.model.ReviewTypes
import com.reviewQueue.service.interfaces.IReviewFetcherService
import roboguice.activity.RoboActivity
import roboguice.activity.RoboListActivity
import java.io.IOException
import java.util.List
import com.guardian.R
import com.guardian.reviewQueue.model.Review

object HomeActivity {
  private[activities] final val COUNTRIES:  Array[String] = Array[String]("England", "Scotland", "Northern Ireland", "Wales")
}

class HomeActivity extends RoboListActivity {
  /**Called when the activity is first created. */
  @Override def onCreate(savedInstanceState: Bundle): Unit = {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.main)
    try {
      var reviews: List[Review] = _reviewFetcher.getReviews(ReviewTypes.Unknown)
      setListAdapter(new Nothing(this, reviews))
      var lv = getListView
      lv.setTextFilterEnabled(true)
      lv.setOnItemClickListener(new Nothing {
        def onItemClick(parent: Nothing, view: View, position: Int, id: Long): Unit = {
          Toast.makeText(getApplicationContext, (view.asInstanceOf[Nothing]).getText, Toast.LENGTH_SHORT).show
        }
      })
    }
    catch {
      case ex: IOException => {
        val msg: String = ex.getMessage
      }
    }
  }

  @Inject private[activities] var _reviewFetcher: Nothing = null
  @Inject private[activities] var _repository: Nothing = null
}

