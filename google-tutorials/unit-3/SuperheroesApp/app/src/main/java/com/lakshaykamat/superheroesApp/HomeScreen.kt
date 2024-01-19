package com.lakshaykamat.superheroesApp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lakshaykamat.superheroesApp.model.Hero
import com.lakshaykamat.superheroesApp.model.HeroesRepository

@Composable
fun SuperHeroCard(hero: Hero,modifier: Modifier = Modifier) {
    Card (modifier= Modifier.wrapContentSize()){
        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
            Column(modifier = Modifier.padding(horizontal = 8.dp).fillMaxWidth(.7f)) {
                Text(text = stringResource(id = hero.nameRes), style = MaterialTheme.typography.titleMedium)
                Text(text = stringResource(id = hero.descriptionRes), style = MaterialTheme.typography.bodySmall)
            }
            Image(
                modifier=Modifier.clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Fit,
                painter = painterResource(id = hero.imageRes),
                contentDescription = stringResource(id = hero.nameRes)
            )
        }
    }
}


@Preview
@Composable
fun SuperHeroCardPreview(modifier: Modifier = Modifier) {
    val num = 1..6
    SuperHeroCard(HeroesRepository.heroes[num.random()])
}