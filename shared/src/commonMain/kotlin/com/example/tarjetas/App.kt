package com.example.tarjetas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import tarjetas.shared.generated.resources.Res
import tarjetas.shared.generated.resources.foto1
import tarjetas.shared.generated.resources.foto2
import tarjetas.shared.generated.resources.foto3

@Composable
fun App() {
    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFEEEEEE))
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Tarjeta(
                nombre = "Elvira Ocaña Rodríguez",
                puesto = "Desarrolladora DAM",
                correo = "example@example.com",
                ciudad = "Palma",
                imagen = Res.drawable.foto1
            )
            Tarjeta(
                nombre = "Ginés Ocaña Rodríguez",
                puesto = "Desarrollador DAM",
                correo = "example2@example.com",
                ciudad = "Palma",
                imagen = Res.drawable.foto2
            )
            Tarjeta(
                nombre = "Gustavo Ocaña Rodríguez",
                puesto = "Desarrollador DAM",
                correo = "example3@example.com",
                ciudad = "Palma",
                imagen = Res.drawable.foto3
            )
        }
    }
}

@Composable
fun Tarjeta(
    nombre: String,
    puesto: String,
    correo: String,
    ciudad: String,
    imagen: DrawableResource,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Imagen circular con borde
            Image(
                painter = painterResource(imagen),
                contentDescription = nombre,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color(0xFF1F7A63), CircleShape)
            )

            Spacer(modifier = Modifier.width(16.dp))

            // Textos organizados verticalmente
            Column(modifier = Modifier.weight(1f)) {
                Text(nombre, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(puesto, color = Color.Gray, fontSize = 13.sp)

                HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

                Text("Correo: $correo", fontSize = 13.sp)
                Text("Ciudad: $ciudad", fontSize = 13.sp)
            }
        }
    }
}
