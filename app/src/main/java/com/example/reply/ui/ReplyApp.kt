package com.example.reply.ui

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.reply.data.Email
import com.example.reply.data.MailboxType

@Composable
fun ReplyApp(
    viewModel: ReplyViewModel = viewModel(),
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier
) {
    val replyUiState = viewModel.uiState.collectAsState().value

    when (windowSize) {
        WindowWidthSizeClass.Compact -> {

        }

        WindowWidthSizeClass.Medium -> {

        }

        WindowWidthSizeClass.Expanded -> {

        }

        else -> {

        }
    }
    ReplyHomeScreen(
        replyUiState = replyUiState,
        onTabPressed = { mailboxType: MailboxType ->
            viewModel.updateCurrentMailbox(mailboxType = mailboxType)
            viewModel.resetHomeScreenStates()
        },
        onEmailCardPressed = { email: Email -> viewModel.updateDetailsScreenStates(email = email) },
        onDetailScreenBackPressed = { viewModel.resetHomeScreenStates() },
        modifier = modifier
    )
}