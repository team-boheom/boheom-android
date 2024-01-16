package com.haeun.boheom.feature.landing

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.material3.ExperimentalTvMaterial3Api
import com.haeun.boheom.R
import com.haeun.boheom.ui.theme.Black
import com.haeun.boheom.ui.theme.Gray600
import com.haeun.boheom.ui.theme.Main
import com.haeun.boheom.ui.theme.White
import com.haeun.boheom.ui.theme.pretendardFamily

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
internal fun Landing(
    moveToSignIn: () -> Unit,
    moveToSignUp: () -> Unit,
) {
    /*val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()*/

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 16.dp),
    ) {
        Image(
            modifier = Modifier
                .size(170.dp)
                .padding(top = 70.dp),
            painter = painterResource(id = R.drawable.landing_image),
            contentDescription = stringResource(id = R.string.landing_message_board_game),
        )
        Text(
            text = stringResource(id = R.string.landing_message_explain),
            fontFamily = pretendardFamily,
            fontWeight = FontWeight.Light,
            fontSize = 16.sp,
            color = Gray600,
        )
        Spacer(modifier = Modifier.weight(1f))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(8.dp))
                .border(
                    width = 1.dp,
                    color = Main,
                )
                .clickable(
                    onClick = moveToSignUp,
                )
                .background(
                    color = Main,
                )
                .padding(vertical = 14.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = stringResource(id = R.string.start),
                color = White,
                fontFamily = pretendardFamily,
                fontWeight = FontWeight.Medium,
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Text(
                text = stringResource(id = R.string.already_start),
                fontFamily = pretendardFamily,
                fontWeight = FontWeight.Light,
                fontSize = 12.sp,
                color = Black,
            )
            Text(
                modifier = Modifier.clickable(onClick = moveToSignIn),
                text = stringResource(id = R.string.sign_in),
                fontFamily = pretendardFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Main,
            )
        }
        Spacer(modifier = Modifier.height(90.dp))
    }
}