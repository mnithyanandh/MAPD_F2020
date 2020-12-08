package com.example.assignment_4

//import com.google.android.gms.auth.api.signin.GoogleSignInOptions
//import com.google.android.gms.common.api.ApiException
//import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.auth.FirebaseUser
//import com.google.firebase.auth.GoogleAuthProvider
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.assignment_4.Database.AdminDatabase
import com.example.assignment_4.Database.CustomerDatabase
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import java.util.*

class LoginScreen : AppCompatActivity() {

    var bSignIn: Button? = null
    var user: FirebaseUser? = null
    var mAuth: FirebaseAuth? = null
    private var mGoogleSignInClient: GoogleSignInClient? = null
    companion object {
        private const val RC_SIGN_IN = 123
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

//        // --------------------------------------------------- //
//        var bSignIn = findViewById<Button>(R.id.GoogleBtn)
//        var mAuth = FirebaseAuth.getInstance()
//        createRequest()
//        bSignIn.setOnClickListener {
//            signIn()
//        }

        // --------------------------------------------------------------------------------------------------- //
        // Initialize Shared Preferences for storing Login Data:
        val SharedPreferences = getSharedPreferences("sharedPref_data", Context.MODE_PRIVATE)

        // Register and track Username and Password:
        var usrName = findViewById<EditText>(R.id.usernameEntry).text.toString()
        var passwrd = findViewById<EditText>(R.id.passwordEntry).text.toString()

        // Room DB Calls:
        var CRoomDB = Room.databaseBuilder(
            applicationContext,
            CustomerDatabase::class.java,
            "CustomerDB"
        ).build()
        //var ARoomDB = Room.databaseBuilder(applicationContext, AdminDatabase::class.java, "AdminDB").build()

        // Initialize the Login Button:
        val loginButton = findViewById<Button>(R.id.loginBtn)
        loginButton.setOnClickListener {

            // Handle Shared Preferences by registering in above information:
            val addData = SharedPreferences.edit()
            addData.putString("Username", usrName)
            addData.putString("Password", passwrd)
            // Apply changes to the Shared Preferences manager after adding the data
            addData.apply()

            //Pulling the values from Shared Preferences:
            var SP_username = SharedPreferences.getString("Username", "")
            var SP_password = SharedPreferences.getString("Password", "")

            Thread {
                var CustomerusernameData =
                    CRoomDB.getDAO().findCustomerByUsername(SP_username.toString())
                var CustomerpasswordData =
                    CRoomDB.getDAO().findByCustomerPassword(SP_password.toString())
                //var AdminusernameData = ARoomDB.getDAO().findAdminByUsername(SP_username.toString())

                if (SP_username == "Username" && SP_password == "Password") {
                    val performCLogin = Intent(this@LoginScreen, MainActivity::class.java)
                    startActivity(performCLogin)
                } else {
                    val performALogin = Intent(this@LoginScreen, AdminMainActivity::class.java)
                    startActivity(performALogin)
                }
            }.start()
        }

        //Initialize the Signup TextView Click operation:
        var signUpView = findViewById<TextView>(R.id.sign_up_button)
        signUpView.setOnClickListener {
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

//    private fun createRequest() {
//        // Configure Google Sign In
//        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//            .requestIdToken(getString(R.string.default_web_client_id))
//            .requestEmail()
//            .build()
//        //Build a google sign in client with the options specified by gso
//        var mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
//    }
//
//    private fun signIn() {
//        val signInIntent = mGoogleSignInClient!!.signInIntent
//        startActivityForResult(signInIntent, RC_SIGN_IN)
//    }
//
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
//
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
//                Toast.makeText(this@LoginScreen, "Login Failed", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
}
