package com.haeun.boheom.feature.signin

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.haeun.boheom.R
import com.haeun.boheom.ui.theme.Black
import com.haeun.boheom.ui.theme.Gray100
import com.haeun.boheom.ui.theme.Gray500
import com.haeun.boheom.ui.theme.Main
import com.haeun.boheom.ui.theme.White
import com.haeun.boheom.ui.theme.pretendardFamily

private val signInImages = listOf(
    R.drawable.sign_in_1,
    R.drawable.sign_in_2,
    R.drawable.sign_in_3,
    R.drawable.sign_in_4,
    R.drawable.sign_in_5,
)

private val signInDescriptions = listOf(
    R.string.sign_in_1,
    R.string.sign_in_2,
    R.string.sign_in_3,
    R.string.sign_in_4,
    R.string.sign_in_5,
)

@Composable
internal fun SignIn(
    moveToSignUp: () -> Unit,
) {
    val imgIndex = remember { androidx.compose.animation.core.Animatable(initialValue = 0f) }
    val currentImage = signInImages[imgIndex.value.toInt()]
    val currentDescription = signInDescriptions[imgIndex.value.toInt()]

    val id = remember { mutableStateOf("") }
    val password = remember {
        mutableStateOf("")
    }

    LaunchedEffect(Unit) {
        imgIndex.animateTo(
            targetValue = signInImages.lastIndex.toFloat() + 1,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = 4000),
                repeatMode = RepeatMode.Restart,
            ),
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
    ) {
        Image(
            modifier = Modifier
                .size(180.dp)
                .padding(top = 68.dp),
            painter = painterResource(id = currentImage),
            contentDescription = stringResource(id = currentDescription),
        )
        Spacer(modifier = Modifier.height(60.dp))
        SignInInputs(
            id = id.value,
            onIdChange = { id.value = it },
            password = password.value,
            onPasswordChange = { password.value = it }
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
                    onClick = { /*TODO*/ },
                )
                .background(
                    color = Main,
                )
                .padding(vertical = 14.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = stringResource(id = R.string.sign_in),
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
                text = stringResource(id = R.string.dont_have_account_yet),
                fontFamily = pretendardFamily,
                fontWeight = FontWeight.Light,
                fontSize = 12.sp,
                color = Black,
            )
            Text(
                modifier = Modifier.clickable(onClick = moveToSignUp),
                text = stringResource(id = R.string.sign_up),
                fontFamily = pretendardFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Main,
            )
        }
        Spacer(modifier = Modifier.height(90.dp))
    }
}

@Composable
private fun SignInInputs(
    id: String,
    onIdChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit,
) {
    Column {
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
                    shape = RoundedCornerShape(8.dp)
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
        Spacer(modifier = Modifier.height(20.dp))
        // 비밀번호 필드
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
                    shape = RoundedCornerShape(8.dp)
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
    }
}