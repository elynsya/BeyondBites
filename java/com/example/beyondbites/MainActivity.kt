package com.example.beyondbites

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.beyondbites.ui.theme.BeyondBitesTheme

enum class ActionType {
    CLAIM_VOUCHER,
    SUBMIT_FORM,
    DONATION
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BeyondBitesTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ThankYouScreen(actionType = ActionType.CLAIM_VOUCHER)
                }
            }
        }
    }
}

@Composable
fun ThankYouScreen(actionType: ActionType) {
    val message = when (actionType) {
        ActionType.CLAIM_VOUCHER -> "Thank you! You have successfully claimed your voucher."
        ActionType.SUBMIT_FORM -> "Thank you! You have successfully filled out the form."
        ActionType.DONATION -> "Thank you! Your donation is greatly appreciated."
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = message,
                style = MaterialTheme.typography.displayMedium,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { /* Navigate back or to another screen */ }) {
                Text(text = "Back to Home")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ThankYouScreenPreview() {
    BeyondBitesTheme {
        ThankYouScreen(actionType = ActionType.SUBMIT_FORM)
    }
}
