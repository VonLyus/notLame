package bootcamp.sparta.notlame.signIn

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import bootcamp.sparta.notlame.R
import bootcamp.sparta.notlame.mainPage.MainPageActivity

class SignInPageActivity : AppCompatActivity() {

    private lateinit var editTextId: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonLogin: Button
    private lateinit var buttonSignUp: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in_page)

        editTextId = findViewById(R.id.editTextId)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonLogin = findViewById(R.id.buttonLogin)
        buttonSignUp = findViewById(R.id.buttonSignUp)

        buttonLogin.setOnClickListener {
            val id = editTextId.text.toString()
            val password = editTextPassword.text.toString()

            if (id.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "아이디/비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()

                // Get the user information from SharedPreferences
                val sharedPrefs = getSharedPreferences("MyPrefs", MODE_PRIVATE)
                val name = sharedPrefs.getString("userName", "이름 없음")
                val age = sharedPrefs.getString("userAge", "나이 없음")
                val mbti = sharedPrefs.getString("userMBTI", "MBTI 없음")

                val intent = Intent(this, MainPageActivity::class.java)
                startActivity(intent)
            }
        }

        buttonSignUp.setOnClickListener {
            //startActivity(Intent(this, SignUpActivity::class.java))
        }
    }
}