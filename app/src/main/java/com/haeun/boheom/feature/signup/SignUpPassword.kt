package com.haeun.boheom.feature.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.haeun.boheom.R
import com.haeun.boheom.ui.theme.Black
import com.haeun.boheom.ui.theme.Gray100
import com.haeun.boheom.ui.theme.Gray500
import com.haeun.boheom.ui.theme.Gray600
import com.haeun.boheom.ui.theme.White
import com.haeun.boheom.ui.theme.pretendardFamily

@Composable
internal fun SignUpPassword(
    moveToSignUpSuccess: () -> Unit,
) {
    val password = remember { mutableStateOf("") }
    val checkPassword = remember { mutableStateOf("") }

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
        PasswordInputs(
            password = password.value,
            checkPassword = checkPassword.value,
            onPasswordChange = { password.value = it },
            onCheckPasswordChange = { checkPassword.value = it },
        )
        Spacer(modifier = Modifier.weight(1f))
        BasicButton(
            onClick = moveToSignUpSuccess,
            value = checkPassword.value,
            text = stringResource(id = R.string.next),
        )
        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Composable
private fun PasswordInputs(
    password: String,
    checkPassword: String,
    onPasswordChange: (String) -> Unit,
    onCheckPasswordChange: (String) -> Unit,
) {
    Text(
        text = stringResource(id = R.string.password),
        fontFamily = pretendardFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = Gray500,
    )
    Spacer(modifier = Modifier.height(4.dp))
    BasicTextField(
        value = password,
        onValueChange = onPasswordChange,
        modifier = Modifier
            .background(White)
            .border(
                width = 1.dp,
                color = Gray100,
                shape = RoundedCornerShape(8.dp),
            ),
        decorationBox = { innerTextField ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .padding(12.dp),
                verticalArrangement = Arrangement.Center,
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                ) {
                    if (password.isEmpty()) {
                        Text(
                            text = stringResource(id = R.string.enter_password),
                            fontFamily = pretendardFamily,
                            fontWeight = FontWeight.Normal,
                            color = Gray500,
                        )
                    }
                    innerTextField()
                }
            }
        },
    )
    Spacer(modifier = Modifier.height(20.dp))
    Text(
        text = stringResource(id = R.string.check_password),
        fontFamily = pretendardFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = Gray500,
    )
    Spacer(modifier = Modifier.height(4.dp))
    BasicTextField(
        value = checkPassword,
        onValueChange = onCheckPasswordChange,
        modifier = Modifier
            .background(White)
            .border(
                width = 1.dp,
                color = Gray100,
                shape = RoundedCornerShape(8.dp),
            ),
        decorationBox = { innerTextField ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .padding(12.dp),
                verticalArrangement = Arrangement.Center,
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                ) {
                    if (checkPassword.isEmpty()) {
                        Text(
                            text = stringResource(id = R.string.enter_password),
                            fontFamily = pretendardFamily,
                            fontWeight = FontWeight.Normal,
                            color = Gray500,
                        )
                    }
                    innerTextField()
                }
            }
        },
    )
}