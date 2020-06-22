import 'package:flutter/material.dart';
import 'package:mkt_contrib/src/myhomepage.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primaryColor: Color(0xFF7159C1),
        accentColor: Colors.amber,
        //visualDensity: VisualDensity.adaptativePlatformDensity,
      ),
      home: MyHomePage(),
    );
  }
}

