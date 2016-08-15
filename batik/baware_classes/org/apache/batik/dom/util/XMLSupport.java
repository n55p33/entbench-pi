package org.apache.batik.dom.util;
public final class XMLSupport implements org.apache.batik.util.XMLConstants {
    private XMLSupport() { super(); }
    public static java.lang.String getXMLLang(org.w3c.dom.Element elt) { org.w3c.dom.Attr attr =
                                                                           elt.
                                                                           getAttributeNodeNS(
                                                                             XML_NAMESPACE_URI,
                                                                             "lang");
                                                                         if (attr !=
                                                                               null) {
                                                                             return attr.
                                                                               getNodeValue(
                                                                                 );
                                                                         }
                                                                         for (org.w3c.dom.Node n =
                                                                                elt.
                                                                                getParentNode(
                                                                                  );
                                                                              n !=
                                                                                null;
                                                                              n =
                                                                                n.
                                                                                  getParentNode(
                                                                                    )) {
                                                                             if (n.
                                                                                   getNodeType(
                                                                                     ) ==
                                                                                   org.w3c.dom.Node.
                                                                                     ELEMENT_NODE) {
                                                                                 attr =
                                                                                   ((org.w3c.dom.Element)
                                                                                      n).
                                                                                     getAttributeNodeNS(
                                                                                       XML_NAMESPACE_URI,
                                                                                       "lang");
                                                                                 if (attr !=
                                                                                       null) {
                                                                                     return attr.
                                                                                       getNodeValue(
                                                                                         );
                                                                                 }
                                                                             }
                                                                         }
                                                                         return "en";
    }
    public static java.lang.String getXMLSpace(org.w3c.dom.Element elt) {
        org.w3c.dom.Attr attr =
          elt.
          getAttributeNodeNS(
            XML_NAMESPACE_URI,
            "space");
        if (attr !=
              null) {
            return attr.
              getNodeValue(
                );
        }
        for (org.w3c.dom.Node n =
               elt.
               getParentNode(
                 );
             n !=
               null;
             n =
               n.
                 getParentNode(
                   )) {
            if (n.
                  getNodeType(
                    ) ==
                  org.w3c.dom.Node.
                    ELEMENT_NODE) {
                attr =
                  ((org.w3c.dom.Element)
                     n).
                    getAttributeNodeNS(
                      XML_NAMESPACE_URI,
                      "space");
                if (attr !=
                      null) {
                    return attr.
                      getNodeValue(
                        );
                }
            }
        }
        return "default";
    }
    public static java.lang.String defaultXMLSpace(java.lang.String data) {
        int nChars =
          data.
          length(
            );
        java.lang.StringBuffer result =
          new java.lang.StringBuffer(
          nChars);
        boolean space =
          false;
        for (int i =
               0;
             i <
               nChars;
             i++) {
            char c =
              data.
              charAt(
                i);
            switch (c) {
                case 10:
                case 13:
                    space =
                      false;
                    break;
                case ' ':
                case '\t':
                    if (!space) {
                        result.
                          append(
                            ' ');
                        space =
                          true;
                    }
                    break;
                default:
                    result.
                      append(
                        c);
                    space =
                      false;
            }
        }
        return result.
          toString(
            ).
          trim(
            );
    }
    public static java.lang.String preserveXMLSpace(java.lang.String data) {
        int nChars =
          data.
          length(
            );
        java.lang.StringBuffer result =
          new java.lang.StringBuffer(
          nChars);
        for (int i =
               0;
             i <
               data.
               length(
                 );
             i++) {
            char c =
              data.
              charAt(
                i);
            switch (c) {
                case 10:
                case 13:
                case '\t':
                    result.
                      append(
                        ' ');
                    break;
                default:
                    result.
                      append(
                        c);
            }
        }
        return result.
          toString(
            );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "A3dpTzZlFwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "6G5pN5/ivzWj8nDWXkmbH9+YKQA1bDgzdBAmZ/ysvARYqm6JRjb5kwFwM0O6" +
       "sj/DGJSbwC5XFkYpI/VaUGBnLpVqYHdTo22yWtqiGYmNW2A3daGf2kBly9cd" +
       "W2IdG5R77/unD3z11x/9JrArDZ2OUp0Dcx6asRemFfAvP/+h+2975lvvy1IV" +
       "yFPjX3r5vidTqt2bSJ2+1tOmkTbNfVHvS0XlsjW+I/pBN0suipxJe0t3Zj3d" +
       "BEk42ivv4Kfu+ubyo9/+9KZ0O+67x4CV9z7zKz/Yff8zO4cK5kevq1kP42yK" +
       "5ozp2/c07EEP32qWDKPxzy889ce/99TTG67uOlr+1cHu5tN//T9f3X32W1++" +
       "QQ1yyrB/CMMGF5NW0afI/U9nzCtoLCUDU2VKsLpYDRk0v5RoHO0Rg0YF1dtW" +
       "o6vyCdPyJ62mNJoHq6YC9woTlAhKkWDNpuwwYFdifdynB1yjXqcas4iI+27e" +
       "pkjO4MgJ1tdtDV16fbeKBlw1RNRypTVu0+0yBefL0/xaKcklpaAwI31klZS1" +
       "0iuXiW65HEWB2iUwmZpP0IHsztbTBRZ1vaAwYuQF0qEFtV5dBFaeEmstYzXs" +
       "4ItVV12UiwrtTIZOrdEoDZoN1EwoYexJls7NxnLBHDcUnpUcvlVXuhMpMRF9" +
       "bbhug10uJi4rxGhvPB7keG0gEPPYbDiD/JLCgvLAmZd683FMWibOxEt7znNi" +
       "H0Z7+SmtTtq8hJVKTECUSCbXCgddpcAKVm3QWpQbQtNqFt3lRHf9Qqk7F7HV" +
       "kMvnxIFJNPBJcVZoBb18WGHDRRj7Gt7SHVzueg7C9kibHo97Uq8TcOvaujPL" +
       "NwWBrbsiy7haEnRQSaWQ0Zw35CFmDhfuAh0tF93msk77iIsXWhV8HvIlt9+q" +
       "tevMOu+6vcpYqlfVGWFPeKRNO2NixU9qPcplxLBkUrHY8REHL4z8Za1Bo3jb" +
       "ahVWHMt2BHHgLBeck1to4aDYaEj0fFnXKgY+MUxULSQMFbDLOS/3rFCacN4Y" +
       "IccFBwmCHijPSn4NFdBGxTa7K45YO3x/Wqp2HGHhU702Liv9uT7K4YRuy/Ul" +
       "3vNMnLORVp3C2w3di/22XyEnJamojNb4HLfobhAP6lhrGEVkn+cnzthkm9Ol" +
       "o3vT9qBCuev+YKF49Kqm85ZTrCOaXav1arpQ79E2ryOcMBJMs58EXY0sYAuf" +
       "dIsi2e8zxcmgt6wjlGYUxHoPtDAmNYPCGiWNspUUTWo8X1vVpeh5BFPxRq3K" +
       "HFlWJ3xCkF3M7xRLio2j0bTuDkkt9uJlzGGlaWR52NopodhUWq4JXmdJxVys" +
       "m40E4wxcmhV6MZIvjPHmCtfQ2jhqrCV4OG0tBLMXDY11fR57Q4Nu0tasJKxz" +
       "SoWN4A5ZLhtqjA9Qs9F356G4jHlMbFR7gTt31yWTx/3V3CImDS6Gh0WN0VTa" +
       "mMat8Rih3WWrrpmzdMzTDM7hWjky36frVL2PSO2CqyvdUkemlZFDCPmkypFd" +
       "QqhJBFpcEPpQsqZFfLmocZ0RNXVdE6snelwrz6RFvdU0STkYCRXXV3VBbxaL" +
       "DXquJV6Tq2tzdGn2/EGvTHF6K2jZIcOIA3uSVLS4y7JNXcK1sRuZfb1Oqg22" +
       "XxhOY6OFNhumPBnWLK9UQQm43vHZidEW2WLYmlc1viMozDiMzHZ+KjjMDPOR" +
       "JsBPVhNXGk9nVdVfkUK+Z3sKIUYFGM6Pu7IwqbQxI8Y0yvRbwFUEv7KG0XV3" +
       "oS+jYMH7s05YxPF83OZz3Nh14jnq8l3VDehuXxckAUFgx+FqmFILFu4qbvJR" +
       "Nanx0zrVF8crjQsN1JkbjYDCJgo6XHaRPk6Fg3xkznHWo4nIxCpxGYYFPq4q" +
       "SksVVitSpya1OVzj6Xxn5SAVeUWYQc4cLNYg4ckJHRdYIqqtuOGUaFBIs7Vw" +
       "SaHCNOm2jMxwMUx6eQytgkKQqlXWVbtYN8uxYlW7kRcNDH49dEdavk3HwHuG" +
       "U39l0tIKYSZdRR7MWyiqM/CYr8wQvDkPCCbJs6Mc4c/UXtISg6Cp5P0iOaE0" +
       "mZDkhMAWCpxjmYAMMT80FytMNZIkCgiq7zYC3tEQpi2UuGanq9RKOLvmi/my" +
       "pJiDNlpN4lmVQHlOQcmkKvKkX8HMXE6C17UCUpbCeQ0t0athO+hxtlqZm8Jq" +
       "gtZb7jggOSeInA5ICBY5q5Bd1JTyVItERsO2U5g0W94kwhy01PKQWZFAuDzb" +
       "1+g2YmO4V4VrNg4rXKVcLBF+GaU4cclTJaTPsrzAVBRsZIXBKsYXuYhi2UUF" +
       "c1XF8ctk1a7GIu53hvUBRy1JjQ9ktAojUV1BAm1WYvkSWysbARzZLCa6TV6K" +
       "vCodoy22YK19Yx6oi5ZRyMUDMRLoHEGbQjyrezHSdAqF0VBrqTMpXJTXY2+F" +
       "yGRRH1Djaq2JapJfpVYC2+vFIRe6ahQOg7LLREa5GS+Z5XjRs1VKa3dWXYTv" +
       "lbrDZaO7FuZqaPTCkhEjvS5SHY/bmkrWK6SMcSrjN/MrfspXYUJk8p6CYbOo" +
       "uuiu6f6qF9kNdSnmC/JC6jDzec2d6N04P+7FCjxqTVxF5m01mlZmjFIYLMs5" +
       "rrWKiji3oKryksg3w0F9QvQwxZ2OhnKgDvuoNC1qE7mw6ruL3oxQmtRgBdwP" +
       "zkUqC2oiuCjndU40m83crNd0AsM0yxg2nBtTgxfqk4ncKC9z4mK9TspSaVkI" +
       "I1qsa56ad9t9Fp7FdSNc+pbOVLiCVbI7ic8UhDquaCjGj3xy7daoUjFPwLmS" +
       "zGCjNT9u1VbeoD9iI7OW89ZkHA4n2qotDwrjQd2tETQcMONAWOBi0hKKCoII" +
       "uO6rVnEpUlaxp+kzvjjQhjov+e2RxgwobBDpeNRvhHI4Hg0ELZR8n6wmC3c5" +
       "ppbFrplnJKTKCxU87PVtUzVkyS+QuQ5sYEKZCpkOSq6pgSqXCzDem3fw4aiu" +
       "rgglX0+wqWMlah2f8YWGX18jIB/mGFrNEcMlPp6S9dJoXTcYXB/ExYSszdtG" +
       "v4ZPR4tRx/HhSjesOb1pTRlxy6W/ECjfzed8rUfTswqYrtCc2CD1VF1LaBbH" +
       "o8Z6hboYYEEgXVptuFwNxUmjo8ahMCdqznA6byZ1A0RJwSGNfrNVJoq+2Yym" +
       "DXlVWbUYEDu0PoKnYsIbqp5fDRgkmvaJhGVoz6xiVo5oLGlOH4zssVLu1JAu" +
       "MXWlJTwyhkhTMphex2PNLlYjWgOsosP0atRXIksl3X61QFcXczliy/DQ7lit" +
       "Sr7Bq9FciDSW0/ojOEL9SZWfrUKaoBsyP+NtdjJtojVpyRLJkDO5aWNmjBBn" +
       "4a0izWPVYlQCVYAEl/HYx+aTXkcHhXPHtl2hY+lGIhYaAjcxhAk2w8N2MR8h" +
       "SkyF+dmUmqs+I9FNKz9FtRwqihV/RtqTsCCYnrwuS2jEmut8eaxq1fFq0KdH" +
       "o3l1VMJLlL0cjbs+g1R7w5FI6ISMoLrmEl4umhEFNU+zpRyDtNr16TIsGJzI" +
       "4oKkMKXcFMOEIObGSpCPXZ7UdXNkciLiFtaTqIUO215tTDeNQalL9jqV6tJF" +
       "eIEORMZLkjzaonLcYDFY6LrRKzKdKipUF0Wj3he9sFrFfb2CaraSU0DKkuNy" +
       "TW+DRMslLrucigzmGfUOO5d4UKqtJiUTH7EKLwXKYjgkcoWxjVbaOO8UMVWl" +
       "p8GQUdxGBPdMvUqpE3RCKihMkFGFSMqE1GMGWrPMTDRVmuBiEE58022XjSmy" +
       "9BmzLU7kkstiFjcYl5qYM+rmF0tankWjfmVADKU13Ieb9FqJYLIgO8O1YDRi" +
       "kky3IG97dbvAO7MN78ENBdj8pQPUq9j9JDeecOdgwub2/Cz7XDx+2H34/Gx7" +
       "qHJif8/9yHVHwvvHwQc3VOme8P6bXV1k+8GPv/uZ52TmE8jO3rkVH0DnA9v5" +
       "SUOJFOPQrKcApcdvvvftZjc32/OUL777X+8bvmX+9ldxTPzgMT6Pk/xk9/kv" +
       "N98k/eYOdPLgdOW6O6WjSFePnqlc8JQg9KzhkZOV+w+M8PpU54+C54k9Izxx" +
       "46PaVzBrY+NCx84GTxy13d2p7eKClJ3ip5eUihVkePEtzhTfkTZeAF3QlABY" +
       "uSNuduPU1h/9V9qNHyaZddhHxb8Cnj3czff/r/jpzyQDeM8t5Hw6bd4ZQLdt" +
       "5OSAiyvHBH3XDyvoT4BntCfo6EcjKJUB/MYtBP1g2vxqAF2SFVUMjZsJ+2s/" +
       "rLCPgcffE9b/UQr7sVsI+9tp82wAXXY8xVe8SLmJtB95NdImIBq291/pWf69" +
       "192nb+6Apc88d+nc654b/U12BXRwT3u+A50Dda5x+Oj10PsZwKyqZ/yf3xzE" +
       "OtnX7wTQ6296IxdAp9KvjNlPbOA/GUCvuRF8AJ0E7WHI54GGjkMG0Ons+zDc" +
       "C0DyLVwAndm8HAb5HKAOQNLX33ducFK7OatOThxK83v+kxnirlcyxAHK4buk" +
       "dGnI/vmwn8bDzX8frkkvPEf33vES/onNXZZkiOt1SuVcBzq7uVY7WAoevim1" +
       "fVpnWo+9fMdnz79xf9m6Y8Pw1pcP8fbgje+N6qYTZDc96z963R+8+Xef+0Z2" +
       "cPx/KtPp55IiAAA=");
}
