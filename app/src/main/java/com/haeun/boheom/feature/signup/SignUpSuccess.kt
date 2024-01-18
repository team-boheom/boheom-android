package com.haeun.boheom.feature.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.haeun.boheom.R
import com.haeun.boheom.ui.theme.Black
import com.haeun.boheom.ui.theme.Gray600
import com.haeun.boheom.ui.theme.pretendardFamily

@Composable
internal fun SignUpSuccess(
    moveToMain: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 16.dp),
    ) {
        Text(
            modifier = Modifier.padding(top = 70.dp),
            text = stringResource(id = R.string.sign_up_success),
            fontFamily = pretendardFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            color = Black,
        )
        Text(
            text = stringResource(id = R.string.now_start_adventure),
            fontFamily = pretendardFamily,
            fontWeight = FontWeight.Light,
            fontSize = 16.sp,
            color = Gray600,
        )
        Image(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 138.dp)
                .size(200.dp),
            painter = painterResource(id = R.drawable.sign_up_success),
            contentDescription = stringResource(id = R.string.sign_up_success),
        )
        Spacer(modifier = Modifier.weight(1f))
        BasicButton(
            onClick = moveToMain,
            value = null,
            text = stringResource(id = R.string.start_sign_in),
        )
    }
}