import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sun.org.apache.xpath.internal.operations.Mod
import kotlin.math.sqrt

class Calculator {

    private var display = mutableStateOf("0")
    private var storedValue = 0.0
    private var currentOperation = ""
    private var startNew = false
    private val displayNum: Double
        get() = display.value.toDouble()

    @Composable
    fun draw() {
        Column() {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.2f)
                    .background(Color.DarkGray)
            ) {
                Text(text = display.value, color = Color.White, fontSize = 50.sp, modifier = Modifier.padding(10.dp))
            }
            Row(modifier = Modifier .background(Color.DarkGray) .weight(1f) .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                Button(modifier = Modifier .padding(2.dp) .background(Color.Black) .weight(1f) .fillMaxHeight(), colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black), onClick = {percentage()}) {
                    Text(text = "%", color = Color.White, fontSize = 30.sp)
                }
                Button(modifier = Modifier .padding(2.dp) .background(Color.Black) .weight(1f) .fillMaxHeight(), colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black), onClick = {display.value = "0"}) {
                    Text(text = "CE", color = Color.White, fontSize = 30.sp)
                }
                Button(modifier = Modifier .padding(2.dp) .background(Color.Black) .weight(1f) .fillMaxHeight(), colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black), onClick = {clear()}) {
                    Text(text = "C", color = Color.White, fontSize = 30.sp)
                }
                Button(modifier = Modifier .padding(2.dp) .background(Color.Black) .weight(1f) .fillMaxHeight(), colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black), onClick = {deleteOne()}) {
                    Text(text = "DEL", color = Color.White, fontSize = 30.sp)
                }
            }

            Row(modifier = Modifier .background(Color.DarkGray)  .fillMaxWidth() .weight(1f), horizontalArrangement = Arrangement.SpaceEvenly) {
                Button(modifier = Modifier .padding(2.dp) .background(Color.Black) .weight(1f) .fillMaxHeight(), colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black), onClick = {display.value = (1 / displayNum).toString(); startNew = true }) {
                    Text(text = "1/x", color = Color.White, fontSize = 30.sp)
                }
                Button(modifier = Modifier .padding(2.dp) .background(Color.Black) .weight(1f) .fillMaxHeight(), colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black), onClick = {display.value = (displayNum * displayNum).toString(); startNew = true}) {
                    Text(text = "x^2", color = Color.White, fontSize = 30.sp)
                }
                Button(modifier = Modifier .padding(2.dp) .background(Color.Black) .weight(1f) .fillMaxHeight(), colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black), onClick = {display.value = sqrt(displayNum).toString(); startNew = true}) {
                    Text(text = "sqrt(x)", color = Color.White, fontSize = 30.sp)
                }
                Button(modifier = Modifier .padding(2.dp) .background(Color.Black) .weight(1f) .fillMaxHeight(), colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black), onClick = {operation("/")}) {
                    Text(text = "/", color = Color.White, fontSize = 30.sp)
                }
            }

            Row(modifier = Modifier .background(Color.DarkGray) .fillMaxWidth() .weight(1f), horizontalArrangement = Arrangement.SpaceEvenly) {
                Button(modifier = Modifier .padding(2.dp) .background(Color.Black) .weight(1f) .fillMaxHeight(), colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black), onClick = {appendNum("7")}) {
                    Text(text = "7", color = Color.White, fontSize = 30.sp)
                }
                Button(modifier = Modifier .padding(2.dp) .background(Color.Black) .weight(1f) .fillMaxHeight(), colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black), onClick = {appendNum("8")}) {
                    Text(text = "8", color = Color.White, fontSize = 30.sp)
                }
                Button(modifier = Modifier .padding(2.dp) .background(Color.Black) .weight(1f) .fillMaxHeight(), colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black), onClick = {appendNum("9")}) {
                    Text(text = "9", color = Color.White, fontSize = 30.sp)
                }
                Button(modifier = Modifier .padding(2.dp) .background(Color.Black) .weight(1f) .fillMaxHeight(), colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black), onClick = {operation("X")}) {
                    Text(text = "X", color = Color.White, fontSize = 30.sp)
                }
            }

            Row(modifier = Modifier .background(Color.DarkGray)  .fillMaxWidth() .weight(1f), horizontalArrangement = Arrangement.SpaceEvenly) {
                Button(modifier = Modifier .padding(2.dp) .background(Color.Black) .weight(1f) .fillMaxHeight(), colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black), onClick = {appendNum("4")}) {
                    Text(text = "4", color = Color.White, fontSize = 30.sp)
                }
                Button(modifier = Modifier .padding(2.dp) .background(Color.Black) .weight(1f) .fillMaxHeight(), colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black), onClick = {appendNum("5")}) {
                    Text(text = "5", color = Color.White, fontSize = 30.sp)
                }
                Button(modifier = Modifier .padding(2.dp) .background(Color.Black) .weight(1f) .fillMaxHeight(), colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black), onClick = {appendNum("6")}) {
                    Text(text = "6", color = Color.White, fontSize = 30.sp)
                }
                Button(modifier = Modifier .padding(2.dp) .background(Color.Black) .weight(1f) .fillMaxHeight(), colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black), onClick = {operation("-")}) {
                    Text(text = "-", color = Color.White, fontSize = 30.sp)
                }
            }

            Row(modifier = Modifier .background(Color.DarkGray)  .fillMaxWidth() .weight(1f), horizontalArrangement = Arrangement.SpaceEvenly) {
                Button(modifier = Modifier .padding(2.dp) .background(Color.Black) .weight(1f) .fillMaxHeight(), colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black), onClick =  {appendNum("1")}) {
                    Text(text = "1", color = Color.White, fontSize = 30.sp)
                }
                Button(modifier = Modifier .padding(2.dp) .background(Color.Black) .weight(1f) .fillMaxHeight(), colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black), onClick = {appendNum("2")}) {
                    Text(text = "2", color = Color.White, fontSize = 30.sp)
                }
                Button(modifier = Modifier .padding(2.dp) .background(Color.Black) .weight(1f) .fillMaxHeight(), colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black), onClick = {appendNum("3")}) {
                    Text(text = "3", color = Color.White, fontSize = 30.sp)
                }
                Button(modifier = Modifier .padding(2.dp) .background(Color.Black) .weight(1f) .fillMaxHeight(), colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black), onClick = {operation("+")}) {
                    Text(text = "+", color = Color.White, fontSize = 30.sp)
                }
            }

            Row(modifier = Modifier .background(Color.DarkGray)  .fillMaxWidth() .weight(1f), horizontalArrangement = Arrangement.SpaceEvenly) {
                Button(modifier = Modifier .padding(2.dp) .background(Color.Black) .weight(1f) .fillMaxHeight(), colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black), onClick = { display.value = (-displayNum).toString()}) {
                    Text(text = "+/-", color = Color.White, fontSize = 30.sp)
                }
                Button(modifier = Modifier .padding(2.dp) .background(Color.Black) .weight(1f) .fillMaxHeight(), colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black), onClick = {appendNum("0")}) {
                    Text(text = "0", color = Color.White, fontSize = 30.sp)
                }
                Button(modifier = Modifier .padding(2.dp) .background(Color.Black) .weight(1f) .fillMaxHeight(), colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black), onClick = {appendNum(".")}) {
                    Text(text = ".", color = Color.White, fontSize = 30.sp)
                }
                Button(modifier = Modifier .padding(2.dp) .background(Color.Black) .weight(1f) .fillMaxHeight(), colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black), onClick = {operation("=")}) {
                    Text(text = "=", color = Color.White, fontSize = 30.sp)
                }
            }
        }
    }

    private fun appendNum(num: String) {
        if (display.value == "0" || startNew) {
            display.value = num
            startNew = false
        }
        else
            display.value += num
    }

    private fun deleteOne() {
        if (display.value != "0") {
            display.value = display.value.dropLast(1)
            if (display.value == "")
                display.value = "0"
        }
    }

    private fun operation(newOp: String) {
        when(currentOperation) {
            "+" -> { display.value = (displayNum + storedValue).toString() }
            "-" -> { display.value = (storedValue - displayNum).toString() }
            "X" -> { display.value = (displayNum * storedValue).toString() }
            "/" -> { display.value = (storedValue / displayNum).toString() }
            "" -> { storedValue = displayNum }
        }
        storedValue = displayNum
        currentOperation = newOp
        startNew = true
    }

    private fun clear() {
        display.value = "0"
        storedValue = 0.0
        currentOperation = ""
    }

    private fun percentage() {
        if (currentOperation == "X" || currentOperation == "/")
        {
            display.value = (displayNum / 100).toString()
        }
        else if (currentOperation == "+" || currentOperation == "-")
        {
            display.value = (storedValue * displayNum / 100).toString()
        }
    }
}