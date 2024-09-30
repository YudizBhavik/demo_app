package com.example.yudizapplication.Retrofit

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yudizapplication.R
import com.example.yudizapplication.Retrofit.adapter.UserAdapter
import com.example.yudizapplication.Retrofit.api.User_API
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.Toast

class RetrofitExampleScreen : AppCompatActivity() {

    private val BASE_URL = "https://caa47d4ea3b5af6328af.free.beeceptor.com/"
    private val TAG = "CHECK_RESPONSE"
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: UserAdapter
    private val userList = mutableListOf<Data_User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit_example_screen)

        recyclerView = findViewById(R.id.recycler_view_user)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val btn_show_all = findViewById<Button>(R.id.btn_show_all)
        val btn_add_person = findViewById<Button>(R.id.btn_add_person)

        btn_show_all.setOnClickListener {
            getAllUsers()
        }

        // Open dialog on "Add person" button click
        btn_add_person.setOnClickListener {
            showAddUserDialog()
        }
    }

    private fun getAllUsers() {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(User_API::class.java)

        api.getUser().enqueue(object : Callback<List<Data_User>> {
            override fun onResponse(call: Call<List<Data_User>>, response: Response<List<Data_User>>) {
                if (response.isSuccessful) {
                    response.body()?.let { responseUserList ->
                        userList.clear()
                        userList.addAll(responseUserList)
                        adapter = UserAdapter(userList)
                        recyclerView.adapter = adapter
                    }
                } else {
                    Log.e(TAG, "onResponse: Error: ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<List<Data_User>>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}", t)
            }
        })
    }

    private fun showAddUserDialog() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_user, null)
        val dialogBuilder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setCancelable(true)

        val dialog = dialogBuilder.create()
        dialog.show()

        val etUserName = dialogView.findViewById<EditText>(R.id.et_user_name)
        val etUserAge = dialogView.findViewById<EditText>(R.id.et_user_age)
        val etUserCompany = dialogView.findViewById<EditText>(R.id.et_user_company)
        val btnAddUser = dialogView.findViewById<Button>(R.id.btn_add_user)

        btnAddUser.setOnClickListener {
            val name = etUserName.text.toString()
            val age = etUserAge.text.toString().toIntOrNull()
            val company = etUserCompany.text.toString()

//            if (name.isNotEmpty() && age != null && company.isNotEmpty()) {
//                val newUser = Data_User(id = -1, name_user = name, age = age, company = company)
//
//                // Add new user to list and notify adapter
//                userList.add(newUser)
//                adapter.notifyItemInserted(userList.size - 1)
//
//                dialog.dismiss()  // Close the dialog
//            } else {
//                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
//            }
        }
    }
}
