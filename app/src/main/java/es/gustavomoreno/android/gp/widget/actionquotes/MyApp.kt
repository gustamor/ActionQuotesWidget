package es.gustavomoreno.android.gp.widget.actionquotes

import android.app.Application
import com.onesignal.OneSignal
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MyApp : Application() {
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate() {
        super.onCreate()
        OneSignal.initWithContext(this, getString(R.string.onesignal_id))
        GlobalScope.launch {
            OneSignal.Notifications.requestPermission(true)
        }
    }
}