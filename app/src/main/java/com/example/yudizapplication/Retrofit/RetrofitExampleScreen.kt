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
import com.example.yudizapplication.Retrofit.model.Data_User
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

    private val BASE_URL = "https://ca08dcf2b64311a4c43d.free.beeceptor.com/api/"
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

        btn_add_person.setOnClickListener {
            showAddUserDialog()
        }
    }

    // Show all users (Display the users)
    private fun getAllUsers() {
        val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(User_API::class.java)

        api.getUser().enqueue(object : Callback<List<Data_User>> {
            override fun onResponse(
                call: Call<List<Data_User>>,
                response: Response<List<Data_User>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let { responseUserList ->
                        userList.clear()
                        userList.addAll(responseUserList)

                        adapter = UserAdapter(
                            users = userList,
                            editClickListener = { user ->
                                showEditUserDialog(user)
                            },
                            deleteClickListener = { user ->
                                removeUser(user)
                            }
                        )
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

    // Add user Dialog
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

            if (name.isNotEmpty() && age != null && company.isNotEmpty()) {
                val newUser = Data_User("", name, age, company)

                val interceptor = HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
                val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

                val api = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(User_API::class.java)

                api.addUser(newUser).enqueue(object : Callback<List<Data_User>> {
                    override fun onResponse(
                        call: Call<List<Data_User>>,
                        response: Response<List<Data_User>>
                    ) {
                        if (response.isSuccessful) {
                            Toast.makeText(
                                this@RetrofitExampleScreen,
                                "User added successfully",
                                Toast.LENGTH_SHORT
                            ).show()
                            dialog.dismiss()
                            getAllUsers()
                        }
                    }

                    override fun onFailure(call: Call<List<Data_User>>, t: Throwable) {
                        Log.e(TAG, "Error: ${t.message}")
                        dialog.dismiss()
                    }
                })
            } else {
                Toast.makeText(
                    this@RetrofitExampleScreen,
                    "Please fill all fields",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    // Edit user Dialog
    private fun showEditUserDialog(user: Data_User) {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_user, null)
        val dialogBuilder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setCancelable(true)
        val dialog = dialogBuilder.create()
        dialog.show()

        val etUserName = dialogView.findViewById<EditText>(R.id.et_user_name)
        val etUserAge = dialogView.findViewById<EditText>(R.id.et_user_age)
        val etUserCompany = dialogView.findViewById<EditText>(R.id.et_user_company)
        val btnUpdateUser = dialogView.findViewById<Button>(R.id.btn_add_user)

        etUserName.setText(user.name)
        etUserAge.setText(user.age.toString())
        etUserCompany.setText(user.company)

        btnUpdateUser.setOnClickListener {
            val name = etUserName.text.toString()
            val age = etUserAge.text.toString().toIntOrNull()
            val company = etUserCompany.text.toString()

            if (name.isNotEmpty() && age != null && company.isNotEmpty()) {
                val updatedUser = Data_User(user.id, name, age, company)
                val interceptor = HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
                val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

                val api = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(User_API::class.java)

                api.updateUser(user.id, updatedUser).enqueue(object : Callback<Data_User> {
                    override fun onResponse(call: Call<Data_User>, response: Response<Data_User>) {
                        if (response.isSuccessful) {
                            Toast.makeText(
                                this@RetrofitExampleScreen,
                                "User updated successfully",
                                Toast.LENGTH_SHORT
                            ).show()
                            dialog.dismiss()
                            getAllUsers()
                        }
                    }

                    override fun onFailure(call: Call<Data_User>, t: Throwable) {
                        Log.e(TAG, "Error: ${t.message}")
                        dialog.dismiss()
                    }
                })
            } else {
                Toast.makeText(
                    this@RetrofitExampleScreen,
                    "Please fill all fields",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    // Remove user
    private fun removeUser(user: Data_User) {
        val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(User_API::class.java)

        api.deleteUser(user.id).enqueue(object : Callback<Data_User> {
            override fun onResponse(call: Call<Data_User>, response: Response<Data_User>) {
                if (response.isSuccessful) {
                    Toast.makeText(
                        this@RetrofitExampleScreen,
                        "User deleted successfully",
                        Toast.LENGTH_SHORT
                    ).show()
                    getAllUsers()
                }
            }

            override fun onFailure(call: Call<Data_User>, t: Throwable) {
                Log.e(TAG, "Error: ${t.message}")
            }
        })
    }
}
