package rwiftkey.themes

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.topjohnwu.superuser.Shell
import com.topjohnwu.superuser.ipc.RootService
import dagger.hilt.android.AndroidEntryPoint
import rwiftkey.themes.rootservice.PrivilegedProvider
import rwiftkey.themes.rootservice.PrivilegedRootService
import rwiftkey.themes.ui.screen.RwiftkeyApp


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    companion object {
        init {
            Shell.setDefaultBuilder(
                Shell.Builder.create()
                    .setFlags(Shell.FLAG_MOUNT_MASTER)
                    .setTimeout(10)
            )
        }
    }

    private fun bindRootService() {
        val intent = Intent(this, PrivilegedRootService::class.java)
        RootService.bind(intent, PrivilegedProvider.connection)
        Log.d(BuildConfig.APPLICATION_ID, "bindRootService()")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        Shell.getShell {}
        setContent { RwiftkeyApp() }
        if (Shell.getShell().isRoot)
            bindRootService()
    }
}