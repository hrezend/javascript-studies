import 'package:flutter/material.dart';
import 'package:mkt_contrib/src/listitem.dart';

class MyHomePage extends StatefulWidget {
  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        actions: <Widget>[
          IconButton(icon: Icon(Icons.search),color: Colors.white, onPressed: () {}),
          IconButton(icon: Icon(Icons.favorite_border),color: Colors.white, onPressed: () {}),
        ],
        title: Text("RLX"),
      ),
      body: ListView(
        children: <Widget> [
          ListItem(
            tag: "image",
          ),
          ListItem(
            tag: "image2",
          ),
          ListItem(
            tag: "image3",
          ),
          ListItem(
            tag: "image4",
          ),
        ],
      ),
      drawer: Drawer(

      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {},
        child: Icon(Icons.add, color: Colors.white,),
        backgroundColor: Theme.of(context).primaryColor,
      ),
    );
  }
}