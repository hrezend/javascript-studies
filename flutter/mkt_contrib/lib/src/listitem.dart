import 'package:flutter/material.dart';
import 'package:mkt_contrib/src/productdetails.dart';

class ListItem extends StatelessWidget {

  final String tag;
  const ListItem({Key key, this.tag = ""}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return ListTile(
      title: Text("Teste"),
      subtitle: Text("R\$ 0.50"),
      leading: Hero(child: Image.network("https://a-static.mlcdn.com.br/618x463/pacoca-rolha-pacoquita-c-25-santa-helena/docemalu/2602/26faad599c62e97998d5ed376e573be2.jpg"), tag: tag,),
      trailing: IconButton(icon: Icon(Icons.shopping_basket), color: Theme.of(context).accentColor, onPressed: () {},),
      onTap: () {
        Navigator.of(context).push(MaterialPageRoute(builder: (context) => ProductDetail(
          tag: tag,
        )));
      },
    );
  }
}