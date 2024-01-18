package com.haeun.boheom.feature.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.haeun.boheom.R
import com.haeun.boheom.ui.theme.Black
import com.haeun.boheom.ui.theme.Gray100
import com.haeun.boheom.ui.theme.Gray300
import com.haeun.boheom.ui.theme.Gray500
import com.haeun.boheom.ui.theme.Gray600
import com.haeun.boheom.ui.theme.Gray700
import com.haeun.boheom.ui.theme.Main
import com.haeun.boheom.ui.theme.White
import com.haeun.boheom.ui.theme.pretendardFamily

@Composable
internal fun SignUpId(
    moveToSignUpPassword: () -> Unit,
) {
    val id = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 16.dp),
    ) {
        Text(
            modifier = Modifier.padding(top = 70.dp),
            text = stringResource(id = R.string.enter_your_id),
            fontFamily = pretendardFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            color = Black,
        )
        Text(
            text = "닉네임 + 님의 아이디를 알려주세요.",
            fontFamily = pretendardFamily,
            fontWeight = FontWeight.Light,
            fontSize = 16.sp,
            color = Gray600,
        )
        Spacer(modifier = Modifier.height(50.dp))
        IdField(
            id = id.value,
            onIdChange = { id.value = it },
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .clickable {
                    /*TODO 이전*/
                },
            text = stringResource(id = R.string.before),
            fontFamily = pretendardFamily,
            fontWeight = FontWeight.Medium,
            color = Gray700,
            fontSize = 12.sp,
        )
        Spacer(modifier = Modifier.height(15.dp))
        BasicButton(
            onClick = moveToSignUpPassword,
            value = id.value,
            text = stringResource(id = R.string.next),
        )
        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Composable
private fun IdField(
    id: String,
    onIdChange: (String) -> Unit,
) {
    Text(
        text = stringResource(id = R.string.id),
        fontFamily = pretendardFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = Gray500,
    )
    Spacer(modifier = Modifier.height(4.dp))
    BasicTextField(
        value = id,
        onValueChange = onIdChange,
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
                    if (id.isEmpty()) {
                        Text(
                            text = stringResource(id = R.string.enter_id),
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

@Composable
fun BasicButton(
    onClick: () -> Unit,
    value: String,
    text: String,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(8.dp))
            .border(
                width = 1.dp,
                color = if (value.isEmpty()) {
                    Gray300
                } else {
                    Main
                },
            )
            .clickable(
                onClick = onClick,
            )
            .background(
                color = if (value.isEmpty()) {
                    Gray300
                } else {
                    Main
                },
            )
            .padding(vertical = 14.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = text,
            color = White,
            fontFamily = pretendardFamily,
            fontWeight = FontWeight.Medium,
        )
    }
    Spacer(modifier = Modifier.height(20.dp))
}