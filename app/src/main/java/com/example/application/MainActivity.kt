package com.example.application

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.application.ui.theme.ApplicationTheme
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.application.ui.theme.AppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                TransparentStatusBar()

                Box(
                    Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colors.background)
                ){
                    val navController = rememberNavController()
                    NavHost(navController, startDestination = "Home"){



                        composable("about"){
                            AboutScreen(onNavigateUp = {
                                navController.popBackStack()
                            })
                        }

                        composable("details/id={id}?name={name}",
                            arguments = listOf(navArgument("id"){
                                type = NavType.LongType
                            },
                                navArgument("name"){
                                    type=NavType.StringType
                                    nullable=true
                                }),
                        ){
                            val arguements = requireNotNull(it.arguments)
                            val id = arguements.getLong("id")
                            val name = arguements.getString("name")

                            DetailsScreen(id, name,onNavigateUp ={
                                navController.popBackStack()
                            } )
                        }
                    }
                }

            }



        }
    }
    @Composable
    private fun TransparentStatusBar(){
        val status = MaterialTheme.colors.background
        SideEffect {
            window.statusBarColor = status.toArgb()
            window.navigationBarColor = status.toArgb()
        }
    }

    @Composable
    fun DetailsScreen(id:Long, name:String?, onNavigateUp: () -> Unit) {
        val article = recipe.first {
            it.id == id
        }
        Scaffold {
            Column(Modifier.padding(it)) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 10.dp)
                ) {
                    IconButton(onClick = onNavigateUp) {
                        Icon(Icons.Rounded.ArrowBack, contentDescription = "Go Back")
                    }

                }

                Image(
                    painterResource(article.image), contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(16f / 9f), contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(20.dp))
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp)
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.h4, text = article.title
                    )
                    Spacer(modifier = Modifier.height(20.dp))

                    Text(text = "Ingredients", style = MaterialTheme.typography.h4)
                    Spacer(modifier = Modifier.height(20.dp))

                    Text(modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.body2, text = "${article.ingredients}"
                    )
                    Spacer(modifier = Modifier.height(30.dp))

                    Text(text = "Methodology", style = MaterialTheme.typography.h4)
                    Spacer(modifier = Modifier.height(20.dp))

                    Text(modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.body2, text = "${article.method}"
                    )
                    Text(text = "Click link below for a sample video", textAlign = TextAlign.Right,
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "${article.video}")



                }
            }
        }
    }



    @Composable
    fun  AboutScreen(onNavigateUp: () -> Unit){
        Scaffold {
            Column (Modifier.padding(it)) {
                AppBar(title ="About", onNavigateUp)
                Spacer(Modifier.height(20.dp))
                Column(Modifier.padding(16.dp)) {
                    Text("This is the about page.")
                    Spacer(Modifier.height(20.dp))
                    val na = LocalUriHandler.current
                    Button(onClick = {
                        na.openUri("https://developer.android.com")
                    }){
                        Text("Go to developer.android.com to read more")
                    }

                    }

                }
            }

            }
    @Composable
    fun AppBar(title :String, onNavigateUp: () -> Unit){
        Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 10.dp)
        ){
            IconButton(onClick = onNavigateUp) {
                Icon(Icons.Rounded.ArrowBack, contentDescription = "Go back")
                Spacer(Modifier.width(10.dp))
                Text(title, style = MaterialTheme.typography.h6)

            }
        }
    }}



