package com.example.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unitconverter.ui.theme.UnitConverterTheme
import kotlin.math.absoluteValue
import kotlin.math.roundToInt
import kotlin.reflect.KProperty

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UnitConverter()
                }
            }
        }
    }
}

@Composable
fun UnitConverter() {


    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }
    var inputUnit by remember { mutableStateOf("Meters") }
    var outputUnit by remember { mutableStateOf("Meters") }
    var iExpanded by remember { mutableStateOf(false) }
    var oExpanded by remember { mutableStateOf(false) }
    val conversionFactor = remember { mutableStateOf(1.0) }
    val oconversionFactor = remember { mutableStateOf(1.0) }
    fun convertUnits(){
        val inputValueDouble = inputValue.toDoubleOrNull() ?: 0.0
        val result = (inputValueDouble * conversionFactor.value * 100.0 / oconversionFactor.value).roundToInt()/100.0
        outputValue = result.toString()
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Unit Converter")
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = inputValue, onValueChange = {
            inputValue = it
        },
            label = { Text(text = "Enter the value") })

        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Box {
                Button(onClick = { iExpanded = true }) {
                    Text(text = inputUnit)
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Down"
                    )
                }
                DropdownMenu(expanded = iExpanded, onDismissRequest = { iExpanded = false }) {
                    DropdownMenuItem(text = { Text(text = "Centimeter") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Centimeter"
                            conversionFactor.value = 0.01

                        })
                    DropdownMenuItem(text = { Text(text = "Inches") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Centimeter"
                            conversionFactor.value = 0.0254
                            convertUnits()
                        })
                    DropdownMenuItem(text = { Text(text = "Foot") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Feet"
                            conversionFactor.value = 0.304841
                            convertUnits()
                        })
                    DropdownMenuItem(text = { Text(text = "Millimeter") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Millimeter"
                            conversionFactor.value = 0.001
                            convertUnits()
                        })
                    DropdownMenuItem(text = { Text(text = "Meter") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Meter"
                            conversionFactor.value = 1.0
                            convertUnits()
                        })
                    DropdownMenuItem(text = { Text(text = "Kilometer") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Kilometer"
                            conversionFactor.value = 1000.0

                        })
                    DropdownMenuItem(text = { Text(text = "Nanometer") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Nanometer"
                            conversionFactor.value = 0.000000001

                        })
                    DropdownMenuItem(text = { Text(text = "Micrometer") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Micrometer"
                            conversionFactor.value = 0.000001

                        })
                    DropdownMenuItem(text = { Text(text = "Mile") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Mile"
                            conversionFactor.value = 1609.344

                        })
                    DropdownMenuItem(text = { Text(text = "Yard") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Yard"
                            conversionFactor.value = 0.9144028

                        })

                }
            }

            Spacer(modifier = Modifier.width(16.dp))
            Box {
                Button(onClick = { oExpanded = true }) {
                    Text(text = outputUnit)
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Down"
                    )
                }
                DropdownMenu(expanded = oExpanded, onDismissRequest = { oExpanded = false }) {
                    DropdownMenuItem(text = { Text(text = "Centimeter") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "Centimeter"
                            oconversionFactor.value = 0.01

                        })

                    DropdownMenuItem(text = { Text(text = "Inches") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "Inches"
                            oconversionFactor.value = 0.0254

                        })

                    DropdownMenuItem(text = { Text(text = "Feet") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "Feet"
                            oconversionFactor.value = 0.305

                        })

                    DropdownMenuItem(text = { Text(text = "Millimeter") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "Millimeter"
                            oconversionFactor.value = 0.001

                        })

                    DropdownMenuItem(text = { Text(text = "Meter") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "Meter"
                            oconversionFactor.value = 1.0

                        })
                    DropdownMenuItem(text = { Text(text = "Kilometer") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "Kilometer"
                            oconversionFactor.value = 1000.0

                        })
                    DropdownMenuItem(text = { Text(text = "Nanometer") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "Nanometer"
                            oconversionFactor.value = 0.000000001

                        })
                    DropdownMenuItem(text = { Text(text = "Micrometer") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "Micrometer"
                            oconversionFactor.value = 0.000001

                        })
                    DropdownMenuItem(text = { Text(text = "Mile") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "Mile"
                            oconversionFactor.value = 1609.344

                        })
                    DropdownMenuItem(text = { Text(text = "Yard") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "Yard"
                            oconversionFactor.value = 0.9144028

                        })

                }
            }
        }
            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { convertUnits() }) {
                Text(text = "Convert")
            }

            Spacer(modifier = Modifier.height(150.dp))

            Text(text = "Result: $outputValue $outputUnit")

        }
    }



@Preview(showBackground = true)
    @Composable
    fun UnitConverterPreview() {
        UnitConverter()


}
