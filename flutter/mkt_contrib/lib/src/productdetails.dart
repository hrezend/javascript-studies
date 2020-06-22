import 'package:flutter/material.dart';

class ProductDetail extends StatefulWidget {

  final String tag;
  const ProductDetail({Key key, this.tag}) : super(key: key);

  @override
  _ProductDetailState createState() => _ProductDetailState();
}

class _ProductDetailState extends State<ProductDetail> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.tag),
      ),
      body: Center(
        child: Hero(child: Image.network("https://a-static.mlcdn.com.br/618x463/pacoca-rolha-pacoquita-c-25-santa-helena/docemalu/2602/26faad599c62e97998d5ed376e573be2.jpg"), tag: widget.tag,)
      ),
    );
  }
}