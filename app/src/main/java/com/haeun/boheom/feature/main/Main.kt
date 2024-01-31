package com.haeun.boheom.feature.main

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.haeun.boheom.R
import com.haeun.boheom.ui.theme.Black
import com.haeun.boheom.ui.theme.Gray400
import com.haeun.boheom.ui.theme.Gray50
import com.haeun.boheom.ui.theme.Gray500
import com.haeun.boheom.ui.theme.Green600
import com.haeun.boheom.ui.theme.pretendardFamily

val tag = listOf(
    "태그",
    "4인",
    "뱅",
)

@Composable
internal fun Main() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Gray50)
            .padding(top = 65.dp)
    ) {
        MainHeader(nickname = "최하은",
            profile = "https://buffer.com/cdn-cgi/image/w=1000,fit=contain,q=90,f=auto/library/content/images/size/w1200/2023/10/free-images.jpg",
            onProfileClick = {})
        Spacer(modifier = Modifier.height(26.dp))
        ListHeader(
            text = stringResource(id = R.string.recent_recruitment_post),
        )
        Spacer(modifier = Modifier.height(10.dp))
        RecruitmentPost(
            tag = tag,
            title = "같이 뱅 하실래요?",
            content = "같이 뱅 할사람 모여라 블라블라블라블라블라블라블라블라블라블라블라블라블블라블라블블라블라블",
            view = 4,
            recruitment = 10,
            applyCount = 5,
        )
    }
}

@Composable
private fun MainHeader(
    modifier: Modifier = Modifier,
    nickname: String,
    profile: String,
    onProfileClick: () -> Unit,
) {
    Column(
        modifier = modifier.padding(horizontal = 16.dp),
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = "안녕하세요, ${nickname}님! 👋",
                fontFamily = pretendardFamily,
                fontWeight = FontWeight.Light,
                fontSize = 16.sp,
            )
            AsyncImage(
                modifier = modifier
                    .clip(shape = CircleShape)
                    .border(
                        width = 0.5.dp,
                        color = Gray400,
                    )
                    .size(40.dp)
                    .clickable { onProfileClick() },
                model = profile,
                contentDescription = stringResource(id = R.string.profile_image),
            )
        }
        Text(
            modifier = modifier.padding(bottom = 5.dp),
            text = stringResource(id = R.string.board_game),
            fontFamily = pretendardFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
        )
        Text(
            text = stringResource(id = R.string.start_adventure),
            fontFamily = pretendardFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
        )
    }
}

@Composable
fun ListHeader(
    modifier: Modifier = Modifier,
    text: String,
) {
    Row(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .shadow(
                elevation = 15.dp,
                shape = RoundedCornerShape(20.dp),
                spotColor = Color.Gray,
            )
            .clip(RoundedCornerShape(20.dp))
            .background(color = Color.White),
    ) {
        Spacer(modifier = Modifier.width(15.dp))
        Text(
            modifier = modifier.padding(vertical = 12.dp),
            text = text,
            fontFamily = pretendardFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 13.sp,
        )
    }
}

@Composable
fun RecruitmentPost(
    modifier: Modifier = Modifier,
    tag: List<String>,
    title: String,
    content: String,
    view: Int,
    recruitment: Int,
    applyCount: Int,
) {
    Column(
        modifier = modifier
            .width(272.dp)
            .shadow(
                elevation = 15.dp,
                shape = RoundedCornerShape(8.dp),
                spotColor = Color.Gray,
            )
            .clip(RoundedCornerShape(8.dp))
            .background(color = Color.White)
            .padding(
                vertical = 20.dp,
                horizontal = 24.dp,
            )
    ) {
        Text(
            text = tag[1],
            fontFamily = pretendardFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            color = Green600,
        )
        Spacer(modifier = modifier.height(8.dp))
        Text(
            text = title,
            fontFamily = pretendardFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            color = Black,
        )
        Spacer(modifier = modifier.height(12.dp))
        Text(
            text = content,
            fontFamily = pretendardFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            color = Gray500,
            overflow = TextOverflow.Ellipsis,
            maxLines = 2,
        )
        Spacer(modifier = modifier.height(22.dp))
        Row {
            Image(
                modifier = modifier.size(16.dp),
                painter = painterResource(id = R.drawable.ic_eye),
                contentDescription = stringResource(id = R.string.icon_eye),
            )
            Text(
                text = view.toString(),
                fontFamily = pretendardFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                color = Gray500,
            )
            Image(
                modifier = modifier.size(16.dp),
                painter = painterResource(id = R.drawable.ic_eye),
                contentDescription = stringResource(id = R.string.icon_eye),
            )
        }
    }
}