package compose.material.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Tab
import androidx.compose.material.Text
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.TextField
import androidx.compose.ui.res.colorResource
import compose.material.theme.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransactionsScreen() {
    var selectedIndex by remember { mutableStateOf(0) }

    val list = listOf("Gelir Ekle", "Gider Ekle")

    // -- Verileri tutmak için değişkenler --
    var gelirMiktari by remember { mutableStateOf("") }
    var gelirKategorisi by remember { mutableStateOf("") }
    var gelirAciklamasi by remember { mutableStateOf("") }
    var giderMiktari by remember { mutableStateOf("") }
    var giderKategorisi by remember { mutableStateOf("") }
    var giderAciklamasi by remember { mutableStateOf("") }
    var isExpanded by remember { mutableStateOf(false) }
    var moneyTranferPeriod by remember { mutableStateOf("Transfer Sıklığı") }

    Column {
        TabRow(
            selectedTabIndex = selectedIndex,
            modifier = Modifier
                .padding(vertical = 14.dp, horizontal = 8.dp)
                .clip(RoundedCornerShape(50))
                .background(Color(0xFFC4C4C4)),
            indicator = { Box {} }
        ) {
            list.forEachIndexed { index, text ->
                val selected = selectedIndex == index
                Tab(
                    modifier = if (selected) Modifier
                        .clip(RoundedCornerShape(50))
                        .background(Color(0xFF673AB7))
                    else Modifier
                        .clip(RoundedCornerShape(50))
                        .background(Color(0xFFC4C4C4)),
                    selected = selected,
                    onClick = { selectedIndex = index },
                    text = { Text(text, color = Color(0xFFFFFFFF)) }
                )
            }
        }

        //GELİR EKLE
        if (selectedIndex == 0) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = CenterHorizontally,
            ) {
                OutlinedTextField(
                    value = gelirKategorisi,
                    onValueChange = { gelirKategorisi = it },
                    label = { Text("Gelir Kategorisi") },
                )
                OutlinedTextField(
                    value = gelirMiktari,
                    onValueChange = { itV -> gelirMiktari = itV.filter { it.isDigit() } },
                    label = { Text("Gelir Miktarı") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                OutlinedTextField(
                    value = gelirAciklamasi,
                    onValueChange = { gelirAciklamasi = it },
                    label = { Text("Gelir Açıklaması") },
                )
                Box {
                    ExposedDropdownMenuBox(
                        modifier = Modifier.padding(top = 10.dp),
                        expanded = isExpanded,
                        onExpandedChange = { isExpanded = it },
                    ) {
                        TextField(
                            modifier = Modifier.menuAnchor(),
                            value = moneyTranferPeriod,
                            onValueChange = {},
                            readOnly = true,
                            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded) },
                            colors = ExposedDropdownMenuDefaults.outlinedTextFieldColors(
                                containerColor = colorResource(id = R.color.acikGri),
                                textColor = Color.White
                            ),
                        )
                        DropdownMenu(
                            modifier = Modifier
                                .background(Color.LightGray),
                            expanded = isExpanded,
                            onDismissRequest = { isExpanded = false }
                        ) {
                            DropdownMenuItem(
                                text = { Text(text = "Günlük") },
                                onClick = { moneyTranferPeriod = "Günlük"; isExpanded = false })
                            DropdownMenuItem(
                                text = { Text(text = "Haftalık") },
                                onClick = { moneyTranferPeriod = "Haftalık"; isExpanded = false })
                            DropdownMenuItem(
                                text = { Text(text = "Aylık") },
                                onClick = { moneyTranferPeriod = "Aylık"; isExpanded = false })
                            DropdownMenuItem(
                                text = { Text(text = "Yıllık") },
                                onClick = { moneyTranferPeriod = "Yıllık"; isExpanded = false })
                        }
                    }
                }
                OutlinedButton(onClick = { /* TODO buraya kaydetme kısmı gelcek */ }) { Text("Kaydet") }
            }

            //GİDER EKLE
        } else if (selectedIndex == 1) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = CenterHorizontally,
            ) {
                OutlinedTextField(
                    value = giderKategorisi,
                    onValueChange = { giderKategorisi = it },
                    label = { Text("Gider Kategorisi") },
                )
                OutlinedTextField(
                    value = giderMiktari,
                    onValueChange = { itV -> giderMiktari = itV.filter { it.isDigit() } },
                    label = { Text("Gider Miktarı") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                OutlinedTextField(
                    value = giderAciklamasi,
                    onValueChange = { giderAciklamasi = it },
                    label = { Text("Gider Açıklaması") },
                )
                Box {
                    ExposedDropdownMenuBox(
                        modifier = Modifier.padding(top = 10.dp),
                        expanded = isExpanded,
                        onExpandedChange = { isExpanded = it },
                    ) {
                        TextField(
                            modifier = Modifier.menuAnchor(),
                            value = moneyTranferPeriod,
                            onValueChange = {},
                            readOnly = true,
                            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded) },
                            colors = ExposedDropdownMenuDefaults.outlinedTextFieldColors(
                                containerColor = colorResource(id = R.color.acikGri),
                                textColor = Color.White
                            ),
                        )
                        DropdownMenu(
                            modifier = Modifier
                                .background(Color.LightGray),
                            expanded = isExpanded,
                            onDismissRequest = { isExpanded = false }
                        ) {
                            DropdownMenuItem(
                                text = { Text(text = "Günlük") },
                                onClick = { moneyTranferPeriod = "Günlük"; isExpanded = false })
                            DropdownMenuItem(
                                text = { Text(text = "Haftalık") },
                                onClick = { moneyTranferPeriod = "Haftalık"; isExpanded = false })
                            DropdownMenuItem(
                                text = { Text(text = "Aylık") },
                                onClick = { moneyTranferPeriod = "Aylık"; isExpanded = false })
                            DropdownMenuItem(
                                text = { Text(text = "Yıllık") },
                                onClick = { moneyTranferPeriod = "Yıllık"; isExpanded = false })
                        }
                    }
                }
                OutlinedButton(onClick = { /* Verileri kaydetme işlemi */ }) { Text("Kaydet") }

            }
        }
    }
}