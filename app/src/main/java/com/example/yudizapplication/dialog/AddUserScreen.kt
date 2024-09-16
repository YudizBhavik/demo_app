package com.example.yudizapplication.dialog

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.yudizapplication.R
import java.util.Calendar

class AddUserScreen : AppCompatActivity() {
    private lateinit var tvUserData: TextView
    private lateinit var btnAddUser: Button
    private var selectedDateOfBirth: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user_screen)

        tvUserData = findViewById(R.id.tvUserData)
        btnAddUser = findViewById(R.id.btnAddUser)

        btnAddUser.setOnClickListener {
            showAddUserDialog()
        }
    }

    private fun showAddUserDialog() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_add, null)
        val etDob = dialogView.findViewById<EditText>(R.id.etDob)
        val btnSubmit = dialogView.findViewById<Button>(R.id.btnSubmit)

        etDob.setOnClickListener {
            showDatePickerDialog { date ->
                selectedDateOfBirth = date
                etDob.setText(date)
            }
        }

        val dialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .setCancelable(true)
            .create()

        btnSubmit.setOnClickListener {
            tvUserData.text = "User DOB: $selectedDateOfBirth"
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun showDatePickerDialog(onDateSelected: (String) -> Unit) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
            val date = "$selectedDay/${selectedMonth + 1}/$selectedYear"
            onDateSelected(date)
        }, year, month, day)

        datePickerDialog.show()
    }
}