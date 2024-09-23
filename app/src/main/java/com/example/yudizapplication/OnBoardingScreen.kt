package com.example.yudizapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.yudizapplication.IntentExample.IntentExample
import com.example.yudizapplication.activity.FirstScreen
import com.example.yudizapplication.coordinator.CoordinatorScreen
import com.example.yudizapplication.dialog.AddUserScreen
import com.example.yudizapplication.exp_menu.ContextScreen
import com.example.yudizapplication.fontExample.FontScreen
import com.example.yudizapplication.fragments.FragmentExample
import com.example.yudizapplication.layout.Second_Task
import com.example.yudizapplication.recyclerview.model.PersonInformation
import com.example.yudizapplication.selector.LoginScreen
import com.example.yudizapplication.sharedpreferences.SharedPreferencesExample
import com.example.yudizapplication.snackbar.SnackbarScreen
import com.example.yudizapplication.start_activity.StartActivity
import com.example.yudizapplication.user_permission.ShowContact
import com.example.yudizapplication.viewpager.OnBordingViewpager
import com.example.yudizapplication.views.RegistrationForm

class OnBoardingScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_on_boarding_screen)


       var activity = findViewById<Button>(R.id.btn_activity)
       var layout = findViewById<Button>(R.id.btn_layout)
       var views = findViewById<Button>(R.id.btn_view)
       var selector = findViewById<Button>(R.id.btn_selector)
       var viewpagger = findViewById<Button>(R.id.btn_viewpagger)
       val recyclerview = findViewById<Button>(R.id.btn_recyclerView)
       val btn_coordinator = findViewById<Button>(R.id.btn_coordinator)
       val btn_snackbar = findViewById<Button>(R.id.btn_snackbar)
       val btn_font = findViewById<Button>(R.id.btn_font)
       val btn_context_menu = findViewById<Button>(R.id.menu)
       val btn_dialog = findViewById<Button>(R.id.btn_dialog)
       val btn_s_activity = findViewById<Button>(R.id.btn_S_activity)
       val btn_fragment_exp = findViewById<Button>(R.id.fragment_exp)
       val btn_user_permission = findViewById<Button>(R.id.user_permission)
       val btn_sharedpreference = findViewById<Button>(R.id.btn_sharedpreferences)
       val btn_intent_exp = findViewById<Button>(R.id.btn_intent_exp)

        activity.setOnClickListener {
            intent = Intent(applicationContext, FirstScreen::class.java)
            startActivity(intent)
        }
        layout.setOnClickListener {
            intent = Intent(applicationContext, Second_Task::class.java)
            startActivity(intent)
        }
        views.setOnClickListener {
            intent = Intent(applicationContext, RegistrationForm::class.java)
            startActivity(intent)
        }
        selector.setOnClickListener {
            intent = Intent(applicationContext, LoginScreen::class.java)
            startActivity(intent)
        }
        viewpagger.setOnClickListener {
            intent = Intent(applicationContext, OnBordingViewpager::class.java)
            startActivity(intent)
        }
        recyclerview.setOnClickListener {
            intent = Intent(applicationContext, PersonInformation::class.java)
            startActivity(intent)
        }
        btn_coordinator.setOnClickListener {
            intent = Intent(applicationContext, CoordinatorScreen::class.java)
            startActivity(intent)
        }
        btn_snackbar.setOnClickListener {
            intent = Intent(applicationContext, SnackbarScreen::class.java)
            startActivity(intent)
        }
        btn_font.setOnClickListener {
            intent = Intent(applicationContext, FontScreen::class.java)
            startActivity(intent)
        }
        btn_context_menu.setOnClickListener {
            intent = Intent(applicationContext, ContextScreen::class.java)
            startActivity(intent)
        }
        btn_dialog.setOnClickListener {
            intent = Intent(applicationContext, AddUserScreen::class.java)
            startActivity(intent)
        }
        btn_s_activity.setOnClickListener {
            intent = Intent(applicationContext, StartActivity::class.java)
            startActivity(intent)
        }
        btn_fragment_exp.setOnClickListener {
            intent = Intent(applicationContext, FragmentExample::class.java)
            startActivity(intent)
        }
        btn_user_permission.setOnClickListener {
            intent = Intent(applicationContext, ShowContact::class.java)
            startActivity(intent)
        }
        btn_sharedpreference.setOnClickListener {
            intent = Intent(applicationContext, SharedPreferencesExample::class.java)
            startActivity(intent)
        }
        btn_intent_exp.setOnClickListener {
            intent = Intent(applicationContext, IntentExample::class.java)
            startActivity(intent)
        }

    }
}
