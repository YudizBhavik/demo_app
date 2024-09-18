package com.example.yudizapplication.dialog

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.yudizapplication.R
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

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

    @SuppressLint("SetTextI18n")
    private fun showAddUserDialog() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_add, null)
        val etDob = dialogView.findViewById<EditText>(R.id.etDob)
        val fname = dialogView.findViewById<EditText>(R.id.fname)
        val lname = dialogView.findViewById<EditText>(R.id.lname)
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
            val firstName = fname.text.toString()
            val lastName = lname.text.toString()

            tvUserData.text = "User First Name: $firstName\nUser Last Name: $lastName\nUser DOB: $selectedDateOfBirth"

            dialog.dismiss()
        }

        dialog.show()
    }

    private fun showDatePickerDialog(onDateSelected: (String) -> Unit) {
        val calendar = Calendar.getInstance()
        val year = calendar.set(Calendar.YEAR,2020)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.set(Calendar.DAY_OF_MONTH,11)
        val datePickerDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
            calendar.set(selectedYear, selectedMonth, selectedDay)

            val simpleDateFormat = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
            val formattedDate = simpleDateFormat.format(calendar.time)

            onDateSelected(formattedDate)
        }, calendar.get(Calendar.YEAR), month, calendar.get(Calendar.DAY_OF_MONTH))

        datePickerDialog.datePicker.maxDate = Calendar.getInstance().timeInMillis
        datePickerDialog.show()
    }

}
