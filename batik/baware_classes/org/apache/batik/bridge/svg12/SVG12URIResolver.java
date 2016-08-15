package org.apache.batik.bridge.svg12;
public class SVG12URIResolver extends org.apache.batik.bridge.URIResolver {
    public SVG12URIResolver(org.w3c.dom.svg.SVGDocument doc, org.apache.batik.bridge.DocumentLoader dl) {
        super(
          doc,
          dl);
    }
    protected java.lang.String getRefererBaseURI(org.w3c.dom.Element ref) {
        org.apache.batik.dom.AbstractNode aref =
          (org.apache.batik.dom.AbstractNode)
            ref;
        if (aref.
              getXblBoundElement(
                ) !=
              null) {
            return null;
        }
        return aref.
          getBaseURI(
            );
    }
    protected org.w3c.dom.Node getNodeByFragment(java.lang.String frag,
                                                 org.w3c.dom.Element ref) {
        org.apache.batik.dom.xbl.NodeXBL refx =
          (org.apache.batik.dom.xbl.NodeXBL)
            ref;
        org.apache.batik.dom.xbl.NodeXBL boundElt =
          (org.apache.batik.dom.xbl.NodeXBL)
            refx.
            getXblBoundElement(
              );
        if (boundElt !=
              null) {
            org.apache.batik.dom.xbl.XBLShadowTreeElement shadow =
              (org.apache.batik.dom.xbl.XBLShadowTreeElement)
                boundElt.
                getXblShadowTree(
                  );
            org.w3c.dom.Node n =
              shadow.
              getElementById(
                frag);
            if (n !=
                  null) {
                return n;
            }
            org.w3c.dom.NodeList nl =
              refx.
              getXblDefinitions(
                );
            for (int i =
                   0;
                 i <
                   nl.
                   getLength(
                     );
                 i++) {
                n =
                  nl.
                    item(
                      i).
                    getOwnerDocument(
                      ).
                    getElementById(
                      frag);
                if (n !=
                      null) {
                    return n;
                }
            }
        }
        return super.
          getNodeByFragment(
            frag,
            ref);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1Ya2wcVxW+u347fju2Qxw7ieO4ipPu1k2DVDm0jR072XT9" +
                                                              "kJ1YYk2zuTt7d3fi2ZnJzF177RJIC6jhTxWFNA1F8S9XVVFpK0QFSLQyqkRb" +
                                                              "FZBaIqCgBiT+lEdEI6TyI7zOuTOzMzvrdVSEWGnuzN577jn3vL5zZl66RapM" +
                                                              "g/QylYf4ss7M0JjKp6lhsuSoQk3zJMzFpWcr6N9OfzT5YJBUx0hThpoTEjXZ" +
                                                              "uMyUpBkjPbJqcqpKzJxkLIk7pg1mMmORcllTY6RDNiNZXZElmU9oSYYEc9SI" +
                                                              "klbKuSEncpxFbAac9EThJGFxkvAR//JwlDRImr7skm/zkI96VpAy68oyOWmJ" +
                                                              "nqWLNJzjshKOyiYfzhtkv64py2lF4yGW56GzyiHbBCeih0pM0Pdq8yd3LmVa" +
                                                              "hAnaqapqXKhnzjBTUxZZMkqa3dkxhWXNc+RLpCJKtniIOemPOkLDIDQMQh1t" +
                                                              "XSo4fSNTc9lRTajDHU7VuoQH4mR3MROdGjRrs5kWZwYOtdzWXWwGbXcVtLW0" +
                                                              "LFHxmf3hK8+ebvluBWmOkWZZncXjSHAIDkJiYFCWTTDDPJJMsmSMtKrg7Flm" +
                                                              "yFSRV2xPt5lyWqU8B+53zIKTOZ0ZQqZrK/Aj6GbkJK4ZBfVSIqDsf1UphaZB" +
                                                              "105XV0vDcZwHBetlOJiRohB39pbKBVlNcrLTv6OgY/+jQABba7KMZ7SCqEqV" +
                                                              "wgRps0JEoWo6PAuhp6aBtEqDADQ42V6WKdpap9ICTbM4RqSPbtpaAqo6YQjc" +
                                                              "wkmHn0xwAi9t93nJ459bk4efflw9rgZJAM6cZJKC598Cm3p9m2ZYihkM8sDa" +
                                                              "2DAYvUo7X78YJASIO3zEFs33v3j7kQO9629bNN0b0EwlzjKJx6W1RNN7O0b3" +
                                                              "PViBx6jVNVNG5xdpLrJs2l4ZzuuAMJ0FjrgYchbXZ37y+QvfZn8OkvoIqZY0" +
                                                              "JZeFOGqVtKwuK8w4xlRmUM6SEVLH1OSoWI+QGniOyiqzZqdSKZPxCKlUxFS1" +
                                                              "Jv6DiVLAAk1UD8+ymtKcZ53yjHjO64SQGrhIA1z3EOsn7pzQcEbLsjCVqCqr" +
                                                              "Wnja0FB/MwyIkwDbZsIJiPqFsKnlDAjBsGakwxTiIMPshYQhJ9MsbC6mh+4P" +
                                                              "z84dG7r/1EzEzgAjhKGm/z+E5FHT9qVAAJywww8BCmTPcU1JMiMuXcmNjN1+" +
                                                              "Of6uFV6YEraNOAmB3JAlNyTkhiy5ISE35JdLAgEhbivKt/wN3lqAvAfgbdg3" +
                                                              "+9iJMxf7KiDQ9KVKMDWS9hUVoFEXHBxEj0uvtDWu7L459GaQVEZJG5V4jipY" +
                                                              "T44YaUAqacFO5oYElCa3QuzyVAgsbYYmsSQAVLlKYXOp1UAPnOdkq4eDU78w" +
                                                              "U8Plq8eG5yfr15aemPvyfUESLC4KKLIK8Ay3TyOUFyC73w8GG/FtfuqjT165" +
                                                              "el5zYaGoyjjFsWQn6tDnDwi/eeLS4C76Wvz18/3C7HUA25xCmgEi9vplFKHO" +
                                                              "sIPgqEstKJzSjCxVcMmxcT3PGNqSOyMitVU8b4Ww2IJp2A3XATsvxR1XO3Uc" +
                                                              "u6zIxjjzaSEqxOdm9eu//vkfDwpzO8Wk2dMFzDI+7AEwZNYmoKrVDduTBmNA" +
                                                              "9+G16W88c+upeRGzQLFnI4H9OI4CcIELwcxfe/vcB7+7uXYj6MY5hwqeS0Aj" +
                                                              "lC8oifOkfhMlQdqAex4AQAXwAaOm/5QK8SmnZJpQGCbWP5r3Dr32l6dbrDhQ" +
                                                              "YMYJowN3Z+DOf2aEXHj39N97BZuAhAXYtZlLZqF6u8v5iGHQZTxH/on3e775" +
                                                              "Fr0O9QEw2ZRXmIDZoLBBUGi+jZNuhJSlg1IoqWURRhBEjmpSLsvsfgdoBsrB" +
                                                              "jkMY1ShAl4iDQ2LTfWJ8AG0oxBGxNozDXtObT8Up6+m94tKlGx83zn38xm1h" +
                                                              "gOLmzRs+E1QftiIWh4E8sO/y491xamaA7oH1yS+0KOt3gGMMOEqA5OaUgScv" +
                                                              "CjabuqrmNz9+s/PMexUkOE7qFVBxnIq8JXWQMMzMAF7n9YcfseJlqRaGFqEq" +
                                                              "KVG+ZAJ9tnPjaBjL6lz4b+UHXd87/MLqTRG4usWj28vwHhz2F0JY/Kr99dMb" +
                                                              "wkUcDNJTrsUR7dnak1dWk1PPD1mNSFtx2zAGXfF3fvnPn4au/f6dDepUHdf0" +
                                                              "exW2yBSPzCCKLCovE6L7cyHuw6bLf/hhf3rk01QWnOu9S+3A/ztBicHylcJ/" +
                                                              "lLee/NP2kw9lznyKIrHTZ04/yxcnXnrn2IB0OShaXas+lLTIxZuGvYYFoQaD" +
                                                              "nl5FNXGmUYT9nkIAdKBjB+A6aAfAwY2BWsSOGAdxuNcBxTrd0DiEIUv6cLFx" +
                                                              "E56+dA/YnYSNHO1edMGXMfC/OEVsE5g4jcMsJ61pxq1aZoyAx6Gxcdi2iNTB" +
                                                              "F4SQ9YIgFg7jcNI6+8P/ZV7ixJgu5qcKRmjHtX64RmwjjGxiWBzmSu1XbqvP" +
                                                              "DjY6498zOMwL1gubWCuLQ8qy1iQE+8jyuEHTXvhu8ToBSVxrpf8X1sqDCH/r" +
                                                              "iQC3reRF13o5k15eba7tWj31K5HnhReoBsjYVE5RPAHvDf5q3WApWajcYOG9" +
                                                              "Lm5LnPRs2hZzUiXu4viL1qYVTrrKbILmwHrw0p+3reilB77i7qW7wEm9Swes" +
                                                              "rAcvyVc4qQASfPyq7rhoTzkNPCbNB0pLgHBix92c6MH8PUUQKD5YOHCVsz5Z" +
                                                              "QIO/emLy8duffd7q2CSFrqyIF1x4X7eaxwLk7S7LzeFVfXzfnaZX6/YG7Wht" +
                                                              "tQ7s5ku3J5THADl0jJztvnbG7C90NR+sHX7jZxer34eqM08CFCBm3vO5wHo3" +
                                                              "hp4oB7VmPupWG88HL9FnDe97bvmhA6m//lZUV2K9/OwoTx+Xbrzw2C8ub1uD" +
                                                              "fmxLhFRBgWT5GKmXzaPL6gyTFo0YaZTNsTwcEbjIVImQ2pwqn8uxSDJKmjDI" +
                                                              "KSKVsIttzsbCLPb7nPSVfLPY4C0JOpElAEQtpyZFEYDy5M4UfUlxqkZO130b" +
                                                              "3JmCK7eW6h6Xjn69+UeX2irGIVGL1PGyrzFziUJF8n5ccUtUiwWH/4ZfAK5/" +
                                                              "4YVOxwm8c9I2an9o2FX40gAtj7VWEY9O6LpDW31Rt7LmKg7X8jjPSWDQnvXU" +
                                                              "IPz7LSH/OfGIw/X/ALn+fRxoFQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "7fzY8H8BN0V0KvwgAAA=");
}
