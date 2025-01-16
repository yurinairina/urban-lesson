package com.example.a1toolbar
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var toolbarMain: Toolbar
    private lateinit var firstOperandET: EditText
    private lateinit var secondOperandET: EditText
    private lateinit var bottonSumBTN: Button
    private lateinit var bottonDifBTN: Button
    private lateinit var resultTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        toolbarMain = findViewById(R.id.toolbarMain)
        setSupportActionBar(toolbarMain)
        title = "Калькулятор времени"
        toolbarMain.subtitle = "Версия 2.0"
        toolbarMain.setLogo(R.drawable.calcul)

        firstOperandET = findViewById(R.id.firstOperandET)
        secondOperandET = findViewById(R.id.secondOperandET)

        bottonSumBTN = findViewById(R.id.bottonSumBTN)
        bottonDifBTN = findViewById(R.id.bottonDifBTN)

        resultTV = findViewById(R.id.resultTV)
        bottonSumBTN.setOnClickListener(this)
        bottonDifBTN.setOnClickListener(this)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        fun onCreateOptionsMenu(menu: Menu?): Boolean {
            menuInflater.inflate(R.menu.menu_main, menu)
            return true
        }

        fun onOptionsItemSelected(item: MenuItem): Boolean {
            when (item.itemId) {
                R.id.resertMenuMain -> {
                    firstOperandET.text.clear()
                    secondOperandET.text.clear()

                    resultTV.text = "Результат"

                    resultTV.setTextColor(this.getResources().getColor(R.color.input))

                    Toast.makeText(
                        applicationContext,
                        "Данные очищены",
                        Toast.LENGTH_LONG
                    ).show()
                }

                R.id.exitMenuMain -> {
                    Toast.makeText(
                        applicationContext,
                        "Работа завершена",
                        Toast.LENGTH_LONG
                    ).show()
                    finish()
                }
            }
            return super.onOptionsItemSelected(item)
        }
    }

    // @RequiresApi(Build.VERSION_CODES.O)
    override fun onClick(view: View) {
        if (firstOperandET.text.isEmpty() || secondOperandET.text.isEmpty()) {
            return
        }
        var firstTime = firstOperandET.text.toString()
        var secondTime = secondOperandET.text.toString()

        var result = when (view.id) {
            R.id.bottonSumBTN -> Operation(firstTime, secondTime).plusTimes().uppercase()
            R.id.bottonDifBTN -> Operation(firstTime, secondTime).minusTimes().uppercase()
            else -> " "
        }
        resultTV.text = result.toString()
        resultTV.setTextColor(this.getResources().getColor(R.color.input))

        Toast.makeText(
            this,
            "Pезультат: ${resultTV.text}",
            Toast.LENGTH_LONG
        ).show()
    }

    //textview.setTextColor(this.getResources().getColor(R.color.RED))

}
//
//1.      Добавить Toolbar с логотипом, заголовком и подзаголовком. Цвет Toolbar: #006400
//
//2.     Изменить цвет кнопок приложения: #008000
//
//3.     Добавить menu удаления полей ввода и вывода, описать логику работы (аналогично занятию).
//
//4.     Добавить всплывающее сообщение Toast с результатом при выполнении функций сложения и вычитания времени, например, «Результат: 23m45s».
//
//5.     Добавить всплывающее сообщение при очистке полей ввода и вывода - «Данные очищены», при закрытии приложения – «Приложение закрыто».
//
//
//6.     ***Изменить текст вывода информации на #8B0000 при выводе результата, при очистке и по умолчанию (при запуске) – черный.
//



