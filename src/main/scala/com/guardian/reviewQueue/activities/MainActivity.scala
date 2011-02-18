package com.guardian.reviewQueue.activities

import _root_.android.app.Activity
import _root_.android.os.Bundle
import _root_.android.widget.TextView
import com.guardian.reviewQueue.model.Review

class MainActivity extends Activity {
  override def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(new TextView(this) {
      val r = new Review("test")
      setText(r.name)
    })
  }
}