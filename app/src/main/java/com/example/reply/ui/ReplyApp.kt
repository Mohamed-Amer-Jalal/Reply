package com.example.reply.ui

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.reply.data.Email
import com.example.reply.data.MailboxType
import com.example.reply.ui.utils.ReplyContentType
import com.example.reply.ui.utils.ReplyNavigationType

@Composable
fun ReplyApp(
    viewModel: ReplyViewModel = viewModel(),
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier
) {
    val replyUiState = viewModel.uiState.collectAsState().value
    val navigationType: ReplyNavigationType
    val contentType: ReplyContentType

    when (windowSize) {
        WindowWidthSizeClass.Compact -> {
            navigationType = ReplyNavigationType.BOTTOM_NAVIGATION
            contentType = ReplyContentType.LIST_ONLY
        }

        WindowWidthSizeClass.Medium -> {
            navigationType = ReplyNavigationType.NAVIGATION_RAIL
            contentType = ReplyContentType.LIST_ONLY
        }

        WindowWidthSizeClass.Expanded -> {
            navigationType = ReplyNavigationType.PERMANENT_NAVIGATION_DRAWER
            contentType = ReplyContentType.LIST_AND_DETAIL
        }

        else -> {
            navigationType = ReplyNavigationType.BOTTOM_NAVIGATION
            contentType = ReplyContentType.LIST_ONLY
        }
    }
    ReplyHomeScreen(
        navigationType = navigationType,
        contentType = contentType,
        replyUiState = replyUiState,
        onTabPressed = { mailboxType: MailboxType ->
            viewModel.apply {
                updateCurrentMailbox(mailboxType = mailboxType)
                resetHomeScreenStates()
            }
        },
        onEmailCardPressed = { email: Email -> viewModel.updateDetailsScreenStates(email = email) },
        onDetailScreenBackPressed = { viewModel.resetHomeScreenStates() },
        modifier = modifier
    )
}