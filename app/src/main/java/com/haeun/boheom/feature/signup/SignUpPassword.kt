package com.haeun.boheom.feature.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.haeun.boheom.R
import com.haeun.boheom.ui.theme.Black
import com.haeun.boheom.ui.theme.Gray600
import com.haeun.boheom.ui.theme.pretendardFamily

@Composable
internal fun SignUpPassword() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 16.dp),
    ) {
        Text(
            modifier = Modifier.padding(top = 70.dp),
            text = stringResource(id = R.string.what_are_you_password),
            fontFamily = pretendardFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            color = Black,
        )
        Text(
            text = stringResource(id = R.string.what_are_you_password_description),
            fontFamily = pretendardFamily,
            fontWeight = FontWeight.Light,
            fontSize = 16.sp,
            color = Gray600,
        )
        Spacer(modifier = Modifier.height(50.dp))
    }
}