package com.example.assignment_4

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.room.Room
import com.example.assignment_4.Data.Customer
import com.example.assignment_4.Database.AdminDatabase
import com.example.assignment_4.Database.CustomerDatabase
//import com.google.android.gms.auth.api.signin.GoogleSignInOptions
//import com.google.android.gms.common.api.ApiException
//import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.auth.FirebaseUser
//import com.google.firebase.auth.GoogleAuthProvider
import org.w3c.dom.Text
import java.util.*

class LoginScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        // --------------------------------------------------- //
        // Firebase Authentication:
//        var mAuth = FirebaseAuth.getInstance()
//        createRequest()
//        var bSignIn = findViewById<Button>(R.id.GoogleBtn)
//        bSignIn.setOnClickListener{
//            signIn()
//        }
        // Initialize Shared Preferences for storing Login Data:
        val SharedPreferences = getSharedPreferences("sharedPref_data", Context.MODE_PRIVATE)

        // Register and track Username and Password:
        var usrName = findViewById<EditText>(R.id.usernameEntry).text.toString()
        var passwrd = findViewById<EditText>(R.id.passwordEntry).text.toString()

        // Handle Shared Preferences by registering in above information:
        val addData = SharedPreferences.edit()
        addData.putString("Username", usrName)
        addData.putString("Password", passwrd)

        // Room DB Calls:
        var CRoomDB = Room.databaseBuilder(applicationContext, CustomerDatabase::class.java,"CustomerDB").build()
        // var ARoomDB = Room.databaseBuilder(applicationContext, AdminDatabase::class.java,"AdminDB").build()

        // Apply changes to the Shared Preferences manager after adding the data
        addData.apply()

        // Initialize the Login Button:
        val loginButton = findViewById<Button>(R.id.loginBtn)
        loginButton.setOnClickListener {
            Thread {
                if (SharedPreferences.getString("Username", "") == "customer@gmail.com" ||
                    SharedPreferences.getString("Username", "") == CRoomDB.getDAO()
                        .findCustomerByUsername(usrName).toString().trim()
                ) {
                    val performCLogin = Intent(this@LoginScreen, MainActivity::class.java)
                    startActivity(performCLogin)
                } else if (SharedPreferences.getString("Username", "") == "admin" ||
                    SharedPreferences.getString("Username", "") == "Admin"
                ) {
                    val performALogin = Intent(this@LoginScreen, AdminMainActivity::class.java)
                    startActivity(performALogin)
                } else {
                    Toast.makeText(
                        this,
                        "User not found. Kindly verify your Username & Password and try again!",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }.start()
        }


        //Initialize the Signup TextView Click operation:
        var signUpView = findViewById<TextView>(R.id.sign_up_button)
        signUpView.setOnClickListener{
            val signUpAction = Intent(this@LoginScreen, CustomerSignup::class.java)
            startActivity(signUpAction)
        }

        // ------------------------------------------------------------------------------------------- //
        // OPTIONAL TEST FUNCTIONALITY: -
        // ** MAKE SURE TO SET 'id/testBtn' VISIBILITY TO "GONE" (or) "VISIBLE" BEFORE EXEC **
        // ** MAKE SURE TO SET 'id/testData' VISIBILITY TO "GONE" (or) "VISIBLE" BEFORE EXEC **
        // Test SharedPreferences data to check if user entry is being saved:

        // Initialize the TestButton for handling test data fir Shared Preferences
        var testButton = findViewById<Button>(R.id.testBtn)
        testButton.setOnClickListener {
            val usrName = SharedPreferences.getString("Username", "")
            val passwrd = SharedPreferences.getString("Password", "")

            // OPTIONAL TEST FUNCTIONALITY: -
            // Display SharedPreferences data to check if user entry is being saved:
            val testView = findViewById<TextView>(R.id.testData)
            testView.text = "Username: $usrName \nPassword: $passwrd"
        }
        // ------------------------------------------------------------------------------------------- //
    }

    // Google Sign-In Method:

//    var bSignIn: Button? = null
//    var user: FirebaseUser? = null
//    var mAuth: FirebaseAuth? = null
//    private var mGoogleSignInClient: GoogleSignInClient? = null
//    private fun createRequest() {
//        // Configure Google Sign In
//        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//            .requestIdToken(getString(R.string.default_web_client_id))
//            .requestEmail()
//            .build()
//        //Build a google sign in client with the options specified by gso
//        var mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
//    }
//    private fun signIn() {
//        val signInIntent = mGoogleSignInClient!!.signInIntent
//        startActivityForResult(signInIntent, RC_SIGN_IN)
//    }
//    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
//        if (requestCode == RC_SIGN_IN) {
//            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
//            try {
//                // Google Sign In was successful, authenticate with Firebase
//                val account = task.getResult(ApiException::class.java)
//                firebaseAuthWithGoogle(account.idToken)
//            } catch (e: ApiException) {
//                // Google Sign In failed, update UI appropriately
//                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
//                // ...
//            }
//        }
//    }
//    private fun firebaseAuthWithGoogle(idToken: String?) {
//        val credential = GoogleAuthProvider.getCredential(idToken, null)
//        mAuth!!.signInWithCredential(credential).addOnCompleteListener(this) { task ->
//            if (task.isSuccessful) {
//                // Sign in success, update UI with the signed-in user's information
//                val user = mAuth!!.currentUser
//                val ii = Intent(applicationContext, MainActivity::class.java)
//                startActivity(ii)
//                //updateUI(user);
//            } else {
////                 If sign in fails, display a message to the user.
////                    Object mBinding;
////                    Snackbar.make(mBinding.mainLayout, "Authentication Failed.", Snackbar.LENGTH_SHORT).show();
////                 updateUI(null);
//                Toast.makeText(this@LoginScreen, "Login Failed", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
//    companion object {
//        private const val RC_SIGN_IN = 123
//    }
}