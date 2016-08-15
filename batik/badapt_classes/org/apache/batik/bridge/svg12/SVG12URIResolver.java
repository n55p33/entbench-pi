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
    public static final long jlc$SourceLastModified$jl7 = 1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1Ya2wcVxW+u347fju2Qxw7ieO4ipPu1k2DVDm0jR072bB+" +
                                                              "yE4ssabZ3J29uzvx7Mxk5q69dgmkBdTwp4pCmoai+JerChTaClEBEq2MKtFW" +
                                                              "BaSWCCioAYk/5RHRCKn8CK9z7szszM56HRUhVpo7s/eee849r++cmRu3SZVp" +
                                                              "kF6m8hBf1pkZGlP5NDVMlhxVqGmehLm49FwF/dvpDycfDpLqGGnKUHNCoiYb" +
                                                              "l5mSNGOkR1ZNTlWJmZOMJXHHtMFMZixSLmtqjHTIZiSrK7Ik8wktyZBgjhpR" +
                                                              "0ko5N+REjrOIzYCTniicJCxOEj7iXx6OkgZJ05dd8m0e8lHPClJmXVkmJy3R" +
                                                              "s3SRhnNcVsJR2eTDeYPs1zVlOa1oPMTyPHRWOWSb4ET0UIkJ+l5p/vjupUyL" +
                                                              "MEE7VVWNC/XMGWZqyiJLRkmzOzumsKx5jnyRVETJFg8xJ/1RR2gYhIZBqKOt" +
                                                              "SwWnb2RqLjuqCXW4w6lal/BAnOwuZqJTg2ZtNtPizMChltu6i82g7a6CtpaW" +
                                                              "JSo+uz985bnTLd+tIM0x0iyrs3gcCQ7BQUgMDMqyCWaYR5JJloyRVhWcPcsM" +
                                                              "mSryiu3pNlNOq5TnwP2OWXAypzNDyHRtBX4E3YycxDWjoF5KBJT9ryql0DTo" +
                                                              "2unqamk4jvOgYL0MBzNSFOLO3lK5IKtJTnb6dxR07P8sEMDWmizjGa0gqlKl" +
                                                              "MEHarBBRqJoOz0LoqWkgrdIgAA1OtpdlirbWqbRA0yyOEemjm7aWgKpOGAK3" +
                                                              "cNLhJxOcwEvbfV7y+Of25OFnnlCPq0ESgDMnmaTg+bfApl7fphmWYgaDPLA2" +
                                                              "NgxGr9LO1y4GCQHiDh+xRfP9L9x57EDv+lsWTfcGNFOJs0zicWkt0fTujtF9" +
                                                              "D1fgMWp1zZTR+UWaiyybtleG8zogTGeBIy6GnMX1mZ987sK32Z+DpD5CqiVN" +
                                                              "yWUhjlolLavLCjOOMZUZlLNkhNQxNTkq1iOkBp6jssqs2alUymQ8QioVMVWt" +
                                                              "if9gohSwQBPVw7OspjTnWac8I57zOiGkBi7SANd9xPqJOyc0nNGyLEwlqsqq" +
                                                              "Fp42NNTfDAPiJMC2mXACon4hbGo5A0IwrBnpMIU4yDB7IWHIyTQLm4vpoQfD" +
                                                              "s3PHhh48NROxM8AIYajp/w8hedS0fSkQACfs8EOAAtlzXFOSzIhLV3IjY3de" +
                                                              "ir9jhRemhG0jTkIgN2TJDQm5IUtuSMgN+eWSQECI24ryLX+DtxYg7wF4G/bN" +
                                                              "Pn7izMW+Cgg0fakSTI2kfUUFaNQFBwfR49LLbY0ru28NvREklVHSRiWeowrW" +
                                                              "kyNGGpBKWrCTuSEBpcmtELs8FQJLm6FJLAkAVa5S2FxqNdAD5znZ6uHg1C/M" +
                                                              "1HD56rHh+cn6taUn5770QJAEi4sCiqwCPMPt0wjlBcju94PBRnybn/7w45ev" +
                                                              "ntdcWCiqMk5xLNmJOvT5A8Jvnrg0uIu+Gn/tfL8wex3ANqeQZoCIvX4ZRagz" +
                                                              "7CA46lILCqc0I0sVXHJsXM8zhrbkzohIbRXPWyEstmAadsN1wM5LccfVTh3H" +
                                                              "LiuyMc58WogK8ZlZ/fqvf/7Hg8LcTjFp9nQBs4wPewAMmbUJqGp1w/akwRjQ" +
                                                              "fXBt+uvP3n56XsQsUOzZSGA/jqMAXOBCMPNX3zr3/u9urd0MunHOoYLnEtAI" +
                                                              "5QtK4jyp30RJkDbgngcAUAF8wKjpP6VCfMopmSYUhon1j+a9Q6/+5ZkWKw4U" +
                                                              "mHHC6MC9GbjznxohF945/fdewSYgYQF2beaSWaje7nI+Yhh0Gc+Rf/K9nm+8" +
                                                              "Sa9DfQBMNuUVJmA2KGwQFJpv46QbIWXpoBRKalmEEQSRo5qUyzK73wGagXKw" +
                                                              "4xBGNQrQJeLgkNj0gBgfQhsKcUSsDeOw1/TmU3HKenqvuHTp5keNcx+9fkcY" +
                                                              "oLh584bPBNWHrYjFYSAP7Lv8eHecmhmge2h98vMtyvpd4BgDjhIguTll4MmL" +
                                                              "gs2mrqr5zY/f6DzzbgUJjpN6BVQcpyJvSR0kDDMzgNd5/dHHrHhZqoWhRahK" +
                                                              "SpQvmUCf7dw4GsayOhf+W/lB1/cOv7h6SwSubvHo9jK8D4f9hRAWv2p//fSG" +
                                                              "cBEHg/SUa3FEe7b21JXV5NQLQ1Yj0lbcNoxBV/ydX/7zp6Frv397gzpVxzX9" +
                                                              "foUtMsUjM4gii8rLhOj+XIj7oOnyH37Ynx75JJUF53rvUTvw/05QYrB8pfAf" +
                                                              "5c2n/rT95COZM5+gSOz0mdPP8lsTN94+NiBdDopW16oPJS1y8aZhr2FBqMGg" +
                                                              "p1dRTZxpFGG/pxAAHejYAbgO2gFwcGOgFrEjxkEc7ndAsU43NA5hyJI+XGzc" +
                                                              "hKcv3QN2J2EjR7sXXfBlDPwvThHbBCZO4zDLSWuacauWGSPgcWhsHLYtInXw" +
                                                              "BSFkvSCIhcM4nLTO/uh/mZc4MaaL+amCEdpxrR+uEdsII5sYFoe5UvuV2+qz" +
                                                              "g43O+PcMDvOC9cIm1srikLKsNQnBPrI8btC0F75bvE5AEtda6f+FtfIgwt96" +
                                                              "IsBtK3nRtV7OpJdWm2u7Vk/9SuR54QWqATI2lVMUT8B7g79aN1hKFio3WHiv" +
                                                              "i9sSJz2btsWcVIm7OP6itWmFk64ym6A5sB689OdtK3rpga+4e+kucFLv0gEr" +
                                                              "68FL8mVOKoAEH7+iOy7aU04Dj0nzgdISIJzYcS8nejB/TxEEig8WDlzlrE8W" +
                                                              "0OCvnph84s6nX7A6NkmhKyviBRfe163msQB5u8tyc3hVH993t+mVur1BO1pb" +
                                                              "rQO7+dLtCeUxQA4dI2e7r50x+wtdzftrh1//2cXq96DqzJMABYiZ93wusN6N" +
                                                              "oSfKQa2Zj7rVxvPBS/RZw/ueX37kQOqvvxXVlVgvPzvK08elmy8+/ovL29ag" +
                                                              "H9sSIVVQIFk+Rupl8+iyOsOkRSNGGmVzLA9HBC4yVSKkNqfK53IskoySJgxy" +
                                                              "ikgl7GKbs7Ewi/0+J30l3yw2eEuCTmQJAFHLqUlRBKA8uTNFX1KcqpHTdd8G" +
                                                              "d6bgyq2luselo19r/tGltopxSNQidbzsa8xcolCRvB9X3BLVYsHhv+EXgOtf" +
                                                              "eKHTcQLvnLSN2h8adhW+NEDLY61VxKMTuu7QVt/Qray5isO1PM5zEhi0Zz01" +
                                                              "CP9+U8h/XjzicP0/ZT4yBmgVAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "a0RKOZ+g8lFej12vpIr4AMUGY5VqUKsY54XpEOl2DRvMQ+PFvuhRJuvGelBy" +
       "aINmVsjIWveLDD+px05CN+LO0Mcm5WZpGotRg1/YLaSHdUc1N14Z+cbILgbW" +
       "SjCX5UXIqFMyT2EJzbYYkikZPYTo+d2RNa9IEXDCftVrUg3e1JNFW8irK6Nn" +
       "UM2O4GLYcNW1mSRP2it+qboSodbrBcZ3JEN35/xqPqzn45hpyubCRAVe7TlM" +
       "u94riTSpdSNGXDfDucKhcY5RigjTsiwD76/yTVZtUJYpjNTcXKk7Bqo4mslP" +
       "VaHRJ+tFWo3abo1kCnG5jQ86ekPLRUOlXyNrEYI2G2HO8PiRIrbpFtP18oku" +
       "8ks/r4yChd+qNQqKSvFOIZmNhrkxL+hxPPcNuV1NbHXUljEirrQtalIwZ7Uq" +
       "6vVKxVmu4TQQfKVzdMyPtYVhG6QQkviCYajZeGaQ9FKjBxE9Wq4KOrPEnMrC" +
       "81ZeUTDGsTmoDnSbozje15WaamvseoD1uTXKeM5iZPGCWCUQNGH09hLTUbZO" +
       "S7Wov+oysZi36HZMNtfGylutWk65SNMjpVHv610KL5qTOtiJy9q8bSP1PLF2" +
       "McuhiHE5bmAowXeIeDQAkRk69kBpeKV+R9PKVXrIRFS1TkyFhQOvq5ossXmF" +
       "XQ7quOJVm0y97hvJpMWwCaGRXIlYTEuSrLu1hTaUTa2dX4yWhEoXR93GwESI" +
       "sR+wlErnZJ4dNHGiWHZjcpJr+NFURdetchue030LBX7O53BVzSvCkh0RxaUy" +
       "HrcEetDC1sqwXCPJ+TTvBsUqHQ6bS4PrsEOdl+21yy9jut12sB7v4qOAbWKO" +
       "aPpN0qu2Bl3SrLS6ZH1Z5wSELbaiFS3VG0hizSpBRy3gMFXoNJCK29FyolXx" +
       "hbGFoGh+0K039bKH66s13qf6fn69MDBxEdTKfWxoxXMLRtdlRA4tXxJ5QEUt" +
       "kYikzS4TjpB6tRtarpoPiCDXtmBfIatrOSrV6ZU8mNk4EU7Ks6GgJiheL1cM" +
       "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" +
       "bPi/lF1kBfwgAAA=");
}
