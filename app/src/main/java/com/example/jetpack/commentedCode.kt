package com.example.jetpack


// Greeting(name = "Oscar Adam")
//             Button(onClick = {println("Button Clicked")}, content = {
//                    Text(text = "BUtton", color = Color.White)
//             })
//Icon(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription =null, tint = Color.Green)
//  Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = null)


//            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.CenterStart) {
//                Text(
//                    text = "Hello World", color = Color.Green, fontSize = 30.sp,
//                    fontWeight = FontWeight.Bold,
//                    modifier = Modifier.align(Alignment.TopStart)
//                )
//                Text(
//                    text = "Hello World", color = Color.Red, fontSize = 30.sp,
//                    fontWeight = FontWeight.Bold,
//                )
//            }

//            Column(
//                modifier = Modifier.fillMaxSize(),
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.spacedBy(10.dp),
//            ) {
//                Text(text = "Hello World", color = Color.Green, fontSize = 30.sp, )
//                Text(text = "Adam bell", color = Color.Green, fontSize = 30.sp, )
//                Text(text = "14 14 @", color = Color.Green, fontSize = 30.sp, )
//            }
//            Row (
//                modifier = Modifier.fillMaxSize(),
//                horizontalArrangement = Arrangement.SpaceEvenly,
//                verticalAlignment = Alignment.CenterVertically
//            ){
//                Text(text = "Hello", color = Color.Green, fontSize = 30.sp, )
//                Text(text = "Adam ", color = Color.Green, fontSize = 30.sp, )
//                Text(text = "bell", color = Color.Green, fontSize = 30.sp, )
//            }




// A surface container using the 'background' color from the theme
//                Surface(color = MaterialTheme.colorScheme.background) {
//                    Greeting(name = "Oscar Adam")
//                }
//                Box(
//                    modifier = Modifier
//                        .clip(CircleShape)
//                        .border(2.dp, Color.Blue, CircleShape)
//                        .fillMaxWidth()
//                        .height(200.dp)
//                        .background(Color.Green, shape = RectangleShape
//                        ),
//                    contentAlignment = Alignment.Center
//                ) {
//                    Button(onClick = { println("Button Clicked") }, content = {
//                        Text(text = "BUtton", color = Color.White)
//                    })
//                }

//                Row (
//                    modifier = Modifier.fillMaxSize(),
//
//                ){
//                    Box(modifier = Modifier
//                        .height(100.dp)
//                        .width(200.dp)
//                        .background(Color.Red)
//                    )
//                    Spacer(modifier =Modifier.width(5.dp))
//                    Box(modifier = Modifier
//                        .height(100.dp)
//                        .width(200.dp)
//                        .background(Color.Red)
//                    )
//
//                }

//                Box(
//                    modifier = Modifier.fillMaxSize(),
//                    contentAlignment = Alignment.Center,
//
//                ){
//                    Text(
//                        text = "Oscar Adam",
//                        color = Color.Blue,
//                        fontSize  = 32.sp,
//                        textDecoration = TextDecoration.Underline,
//                        modifier = Modifier.fillMaxWidth() ,
//
//
//                    )
//                }

//                Box(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .background(Color.Black )
//
//                    ,contentAlignment = Alignment.Center,){
////                    val annotedString = buildAnnotatedString {
////                        BlueGradientTEXT("Adam 1414")
////                        append("\n\n ")
////                        YellowGradientTEXT("Oscar")
//////                    }
////                    Text(text = annotedString)
//                }

//                Box(
//                    modifier = Modifier
//
//                        .fillMaxSize(),
//                   contentAlignment = Alignment.Center
//                ){
//                    Button(
//                        modifier = Modifier
//                            .width(140.dp)
//                            .height(50.dp),
//                        shape = RoundedCornerShape(20.dp),
//                        enabled = true,
//                      elevation = ButtonDefaults.buttonElevation(
//                          defaultElevation = 30.dp,
//                      ),
//                        colors = ButtonDefaults.buttonColors(
//                            containerColor = Color(0xFF35D808),
//                            contentColor = Color.White
//                        ),
//                        onClick = {
//
//                    }) {
//                        Text(text = "Click Me", color = Color.White)
//                    }
//                }