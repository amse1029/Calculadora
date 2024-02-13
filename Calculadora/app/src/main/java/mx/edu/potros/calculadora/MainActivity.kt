package mx.edu.potros.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var numAnterior: Double = 0.0
    var numNuevo: Double = 0.0
    var operacionPendiente: String = ""

    lateinit var numero: TextView
    lateinit var total:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        total = findViewById<TextView>(R.id.txTotal)
        numero = findViewById<TextView>(R.id.txNumero)

        val uno = findViewById<Button>(R.id.uno)
        val dos = findViewById<Button>(R.id.dos)
        val tres = findViewById<Button>(R.id.tres)
        val cuatro = findViewById<Button>(R.id.cuatro)
        val cinco = findViewById<Button>(R.id.cinco)
        val seis = findViewById<Button>(R.id.seis)
        val siete = findViewById<Button>(R.id.siete)
        val ocho = findViewById<Button>(R.id.ocho)
        val nueve = findViewById<Button>(R.id.nueve)
        val cero = findViewById<Button>(R.id.cero)
        val mas = findViewById<Button>(R.id.mas)
        val menos = findViewById<Button>(R.id.menos)
        val por = findViewById<Button>(R.id.por)
        val division = findViewById<Button>(R.id.division)
        val result = findViewById<Button>(R.id.result)
        val borrar = findViewById<Button>(R.id.borrar)

        val listener = View.OnClickListener { view ->
            val numeroSeleccionado = (view as Button).text.toString()
            numero.append(numeroSeleccionado)
            total.append(numeroSeleccionado)

        }

        uno.setOnClickListener {
            val texto = uno.text.toString()
            numero.text = texto
        }

        dos.setOnClickListener {
            val texto = dos.text.toString()
            numero.text = texto
        }

        tres.setOnClickListener {
            val texto = tres.text.toString()
            numero.text = texto
        }

        cuatro.setOnClickListener {
            val texto = cuatro.text.toString()
            numero.text = texto
        }

        cinco.setOnClickListener {
            val texto = cinco.text.toString()
            numero.text = texto
        }

        seis.setOnClickListener {
            val texto = seis.text.toString()
            numero.text = texto
        }

        siete.setOnClickListener {
            val texto = siete.text.toString()
            numero.text = texto
        }

        ocho.setOnClickListener {
            val texto = ocho.text.toString()
            numero.text = texto
        }

        nueve.setOnClickListener {
            val texto = nueve.text.toString()
            numero.text = texto
        }

        cero.setOnClickListener {
            val texto = cero.text.toString()
            numero.text = texto
        }

        mas.setOnClickListener {
            operacion("+")
        }

        menos.setOnClickListener {
            operacion("-")
        }

        por.setOnClickListener {
            operacion("*")
        }

        division.setOnClickListener {
            operacion("/")
        }

        result.setOnClickListener {
            if (total.text.isNotEmpty()) {
                numNuevo = total.text.toString().toDouble()
                operacionFinal()
            }
        }

        borrar.setOnClickListener {
            numero.text =""
            total.text = ""
            numAnterior = 0.0
            numNuevo = 0.0
            operacionPendiente = ""
        }
    }

    private fun operacion(op: String) {
        if (total.text.isNotEmpty()) {

            numAnterior = total.text.toString().toDouble()
            operacionPendiente = op
            total.text = ""
            numero.append(op)
        }
    }

    private fun operacionFinal() {
        when (operacionPendiente) {
            "+" -> total.text = (numAnterior + numNuevo).toString()
            "-" -> total.text = (numAnterior - numNuevo).toString()
            "*" -> total.text = (numAnterior * numNuevo).toString()
            "/" -> {
                if (numNuevo != 0.0) {
                    total.text = (numAnterior / numNuevo).toString()
                } else {
                    total.text = "Error"
                }
            }
        }
        numAnterior = 0.0
        numNuevo = 0.0
        operacionPendiente = ""

    }

}
