package org.apache.batik.bridge.svg12;
public class SVG12BridgeExtension extends org.apache.batik.bridge.SVGBridgeExtension {
    public float getPriority() { return 0.0F; }
    public java.util.Iterator getImplementedExtensions() { return java.util.Collections.
                                                                    EMPTY_LIST.
                                                             iterator(
                                                               );
    }
    public java.lang.String getAuthor() { return "The Apache Batik Team.";
    }
    public java.lang.String getContactAddress() { return "batik-dev@xmlgraphics.apache.org";
    }
    public java.lang.String getURL() { return "http://xml.apache.org/batik";
    }
    public java.lang.String getDescription() { return "The required SVG 1.2 tags";
    }
    public void registerTags(org.apache.batik.bridge.BridgeContext ctx) {
        super.
          registerTags(
            ctx);
        ctx.
          putBridge(
            new org.apache.batik.bridge.svg12.SVGFlowRootElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.svg12.SVGMultiImageElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.svg12.SVGSolidColorElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.svg12.SVG12TextElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.svg12.XBLShadowTreeElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.svg12.XBLContentElementBridge(
              ));
        ctx.
          setDefaultBridge(
            new org.apache.batik.bridge.svg12.BindableElementBridge(
              ));
        ctx.
          putReservedNamespaceURI(
            null);
        ctx.
          putReservedNamespaceURI(
            org.apache.batik.util.SVGConstants.
              SVG_NAMESPACE_URI);
        ctx.
          putReservedNamespaceURI(
            org.apache.batik.util.XBLConstants.
              XBL_NAMESPACE_URI);
    }
    public boolean isDynamicElement(org.w3c.dom.Element e) {
        java.lang.String ns =
          e.
          getNamespaceURI(
            );
        if (org.apache.batik.util.XBLConstants.
              XBL_NAMESPACE_URI.
              equals(
                ns)) {
            return true;
        }
        if (!org.apache.batik.util.SVGConstants.
               SVG_NAMESPACE_URI.
              equals(
                ns)) {
            return false;
        }
        java.lang.String ln =
          e.
          getLocalName(
            );
        if (ln.
              equals(
                org.apache.batik.util.SVGConstants.
                  SVG_SCRIPT_TAG) ||
              ln.
              equals(
                org.apache.batik.util.SVG12Constants.
                  SVG_HANDLER_TAG) ||
              ln.
              startsWith(
                "animate") ||
              ln.
              equals(
                "set")) {
            return true;
        }
        return false;
    }
    public SVG12BridgeExtension() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Hysw9jg2x+DAB3hs7YoEQHh0vECYB0+PI0nP2EHIx1pA0B8WGHsWm+9zUgMg" +
       "rGO2Yqmme9L2gfH0OIBRhWNheKKORNGxg5GPNSCwW/g4oWBRvpswef3lXJqL" +
       "5c8WgO4cNqc5qbZYAk5tUAfRhPSl7diEJBCUk9JBQ415YP50HMCcjGMYbvY6" +
       "iOwdO5j5WAuDORnBHLpBCcWMZKhNljpisd8UgO4NbH4FQVm11w1DeakqDqeg" +
       "7vXBF4CyPGoYGqP61dLd+f8FxmlOpox2LYpn+Bk5f8jIPxGUJ4/WVkw/uvV1" +
       "cXDNXPRXw4EkntI0XyntL6vLTIvFVQFNtbz3MMXXHzmZU/DaFmp88S1E+INk" +
       "+oCT6XmYINjJFz/9h6CHID3MK779dB9zUunRwVTyxU/yV05KgARfL5uuhSzN" +
       "JwFgG0A2XZR72SH0OfVq+vTdZSzMqrPE/2tuPZzqdMq5U0dv33T3pVWPyptH" +
       "RaMjIzhLFZxw5P1m5ig/P+9s7lxlG5dcqXlq4iK3Ysu6+fTvTVgVGKu4JZwZ" +
       "uIqzmzI3cm8cW336F/vLXoNacxspAqufvM3375b8K6c5babgELEtknuS66GW" +
       "uCNsXvKd4TXL4x+/Ke6RiDz5zc5P36dcOL7914dmHGssJlXtZAKcKVm6l1QK" +
       "H+1iyqDVSyapdlsag53OVaplHRNr0NYpVlYCFwfOSZlevJLmZEHu0Tf3Ir9S" +
       "M4aYtdZI6TGcBg6aVV6Pe6WTdRuSMs0Ag9fjO+0zGU1QG2CpfZEO03Tvc0t/" +
       "bgq3j48eWqAtKhOv+Fb+byjMoq97HwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1aeewsWVWu92bmzcq8NzMs48BszBt0aPxV9d7lANJbdVV3" +
       "dVX1Vt1dAkPtXfvetcAog1EIJEB0QIwwMQYCkmGJQkQNOsYFCMSIwQUTgYBR" +
       "EIjwB2hExVvVv/0thMxoJ3X79l3OPd+55351+t775Leh6wIfKrmOmaqmE+7J" +
       "Sbinm/W9MHXlYG9I1hneD2Spa/JBMAdlj4gv/Oj57//g7ZsLZ6FzHHQHb9tO" +
       "yIeaYwdTOXDMrSyR0Pmj0r4pW0EIXSB1fsvDUaiZMKkF4cMkdPOxriF0kTxQ" +
       "AQYqwEAFuFABbh+1Ap2eJduR1c178HYYeNDPQ2dI6Jwr5uqF0P0nhbi8z1v7" +
       "YpgCAZBwQ/6bBaCKzokP3XeIfYf5EsDvKMGP/9qrL/zONdB5Djqv2bNcHREo" +
       "EYJBOOgWS7YE2Q/akiRLHHSbLcvSTPY13tSyQm8Ouj3QVJsPI18+NFJeGLmy" +
       "X4x5ZLlbxBybH4mh4x/CUzTZlA5+XaeYvAqwPvcI6w4hlpcDgDdpQDFf4UX5" +
       "oMu1hmZLIXTv6R6HGC+OQAPQ9XpLDjfO4VDX2jwogG7fzZ3J2yo8C33NVkHT" +
       "65wIjBJCd11RaG5rlxcNXpUfCaE7T7djdlWg1Y2FIfIuIfSc080KSWCW7jo1" +
       "S8fm59vUS9/6Whu3zxY6S7Jo5vrfADrdc6rTVFZkX7ZFedfxlheT7+Sf+8k3" +
       "nYUg0Pg5pxrv2vze6777ipfc89Snd22ef5k2tKDLYviI+F7h1s+/oPsQek2u" +
       "xg2uE2j55J9AXrg/s1/zcOKClffcQ4l55d5B5VPTv1i//oPyN89CNxHQOdEx" +
       "Iwv40W2iY7maKfsD2ZZ9PpQlArpRtqVuUU9A14M8qdnyrpRWlEAOCehasyg6" +
       "5xS/gYkUICI30fUgr9mKc5B3+XBT5BMXgqDrwQPdAp4XQbtP8R1CMrxxLBnm" +
       "Rd7WbAdmfCfHH8CyHQrAthtYAF5vwIET+cAFYcdXYR74wUberxB8TVJlONiq" +
       "5Qo8YwflSqco6SehbAcA+17ubu7/10BJjvhCfOYMmIwXnKYCE6wi3DEl2X9E" +
       "fDzq9L/74Uc+e/ZwaezbKoQqYOy93dh7xdh7u7H3irH3Ljc2dOZMMeSzcx12" +
       "cw9mzgAcANjxlodmrxq+5k0vvAY4nRtfC8yeN4WvTNLdI9YgCm4UgetCT70r" +
       "foz9BeQsdPYk2+Z6g6Kb8u5MzpGHXHjx9Cq7nNzzb/z69z/yzkedo/V2gr73" +
       "aeDSnvkyfuFpC/uOKEuAGI/Ev/g+/uOPfPLRi2ehawE3AD4MeeC/gGruOT3G" +
       "ieX88AE15liuA4AVx7d4M6864LObwo3vxEclxdTfWuRvAzZ+GbSfnHD4vPYO" +
       "N0+fvXOVfNJOoSio92Uz9z1//5ffqBbmPmDp88feezM5fPgYM+TCzhcccNuR" +
       "D8x9WQbt/vFdzK++49tv/LnCAUCLBy434MU87QJGAFMIzPxLn/a++OUvvfcL" +
       "Z4+cJgSvxkgwNTHZgfwh+JwBz//kTw4uL9it6tu7+9Ry3yG3uPnILzrSDbCM" +
       "CRZg7kEXF7blSJqi8YIp5x77X+cfLH/8W2+9sPMJE5QcuNRLfrSAo/Kf6ECv" +
       "/+yr//2eQswZMX/LHdnvqNmOOu84ktz2fT7N9Uge++u7f/1T/HsACQPiC7RM" +
       "LrgMKuwBFROIFLYoFSl8qq6SJ/cGxxfCybV2LBp5RHz7F77zLPY7f/TdQtuT" +
       "4czxeR/z7sM7V8uT+xIg/nmnVz3OBxvQrvYU9coL5lM/ABI5IFEEvBbQPqCf" +
       "5ISX7Le+7vp/+JM/fe5rPn8NdBaDbjIdXsL4YsFBNwJPl4MNYK7E/dlX7Lw5" +
       "vgEkFwqo0CXgdw5yZ/HrGqDgQ1fmGiyPRo6W653/SZvCG776H5cYoWCZy7yE" +
       "T/Xn4CfffVf35d8s+h8t97z3PcmllAwit6O+lQ9a3zv7wnN/fha6noMuiPth" +
       "IcubUb6IOBAKBQexIggdT9SfDGt27/CHD+nsBaep5tiwp4nm6FUA8nnrPH/T" +
       "0YQ/lJwBC/G6yl5zD8l/v6LoeH+RXsyTn9xZPc/+FFixQRFegh6KZvNmIeeh" +
       "EHiMKV48WKMsCDeBiS/qZrMQ8xwQYBfekYPZ28VoO67K0+pOiyLfuKI3PHyg" +
       "K5j9W4+EkQ4I997yT2//3Nse+DKYoiF03TY3H5iZYyNSUR4B//KT77j75se/" +
       "8paCgAD7sK9/8Juvz6WOroY4T3p50j+AelcOdVa81Uk+CMcFT8hSgfaqnsn4" +
       "mgWodbsf3sGP3v5l491f/9AudDvthqcay296/M0/3Hvr42ePBcwPXBKzHu+z" +
       "C5oLpZ+1b2Efuv9qoxQ9sH/5yKN/+IFH37jT6vaT4V8f/Lv50N/+9+f23vWV" +
       "z1wmzrjWdJ7GxIbn78NrAdE++JBlTq52FuWpActctz+k59giaW6wVacWdSOH" +
       "7UTGZtNWJXWcqOuYmuibJlrKLMPfVldRDbUqicaLS64XqtyIXzrhiGltJgvg" +
       "e6znNdkZbSTYFA1cM+T4pCWPw4BdTlNzXoqlsKnIkliC5agqZ2ljGkY6U21S" +
       "5WwblcQWXCnVM7PZ0sZpLHAEgVJ1rV0Ssnaj3BDS+VLnyXDpL0Jfaq/qcLpo" +
       "W+iWZjTXjEYz1th6smVLjtQVBE7mWH/c1NiMpaoWi8nr7dpKBvgQWQaJVdZ6" +
       "pufhVcOzvCpXQyiWncprcbpG9MmkgRAeL4vLioMkrNUcx31bTEex0eytZ4Jq" +
       "0lQsEtJytJ7Um/Ue1aqPKqU+Px3L1pazqSkmhVhnYNQTdhLi7DCoumklzXoz" +
       "pLaeWq1Oh2yh7ag5W+NqGOhUiW0HdNetGKUtTqfbftIZu74bid2BXBXZYJKE" +
       "RjDRXHTlC9SQR6Q6vTWGBOEpxFREiYU4Fam4MdwsqRlb9uhudYFqsuZzvLpJ" +
       "ol44t8AK3egaZ2eV4WxW4aWR4GJ4NBjMvBrRDNWOZdscP2MXEU+Uxt20RQ9w" +
       "KZygq8XQkxEr9GxFlzbzdYeQMFnFJqYTp2mlMUxYLTDRue/QScR55mKBiOJ8" +
       "rqx5Y2Qz7ZUnVfBO5s6HJDmwNsnK6S9n2UJ1qj6R1MQlNsm81lBcI9aE4lzb" +
       "S2bxdrXuxcOl57eTEdLsNDfpElExVq/2U6qlTQ0BdzWk3fZpdphsIyrDRibt" +
       "LGhE61DTEdUgwphyPdFW8Vm3PeEccU5kzcaMCBcW2+ZcVVlq07bg0vRkuujH" +
       "i0k6Joflbpez2hZC9Wh1yKElJvSQUtCTSgaPWp15x7aoMbLqwazYWwwGPW9t" +
       "Y9ZYafdSVkMphlBtRejC1rCr4htPxfQZTOukWakLVVu3hgsj45MZn0mYNKcx" +
       "NPUxJ1NsDnhuNBKxkB1qA58n0yCdrFah4Oq9mT1fqzGSEVnN6hH4PJuj8mjV" +
       "3BpyCQkSbxnb3NrbuNxQncLLkTGfsjprCNa4FqSmFdiLxJC9hNVJeS7aGuP1" +
       "vPmW2+oit00kc+RpfC2dwPFAo4m4sxguunLJw3VFlOpMqmwHMqUam7rSnQB3" +
       "WfZhY1qtp7FIlqbcYOAtsCqrr7rAT3otaaNq880sbk5QPJYdPPb5aRC0+3GN" +
       "Z7sYHavVptXrT0KK49T1KoiD5dCMyNCOax7LIyyzrDtZdSJwk8omqm9R35lP" +
       "RwxuOV5bW4znwbqrz2PHqQwwi1raVaIWCkKIuBTqI2o2QaU4oIfGkI8lw4rw" +
       "hHI20Yoj/A7CC8vyjO3OljYxbBqkg2eTcrtHtNUVWTFkeBvSsLgdtQf6uCaN" +
       "2qu1seK6rI556ITGBmjWNNkxbRiKufWzjTDvO7pL9D2mvyhnXSRk1ZFm6qRK" +
       "41wZo0YLM61aJYHAXN0mF5g6Vs1lyafx8cLqj8fqtklztma1cIqTtXJNSTmO" +
       "mqNGRuGbrVBRmFVjbY5Ee9aJ04kxqdS7aL9FNYZ2XO1MmB7PMMumv601eANH" +
       "k42sjfURPWhoGY31B9N1X58RxLxeSqVOHXWjEsYskC7qGJNYNzCzxjiVzkYk" +
       "0qBLCdspPli6bQLXN+7SGKiN+gBTUiUI1i3b64cSp4/LC5503cmaGGt9KeOF" +
       "eTONymhJJKg2EiBcKNSNaqsMHAyla8sJRWgkKyd8PVkS4wZVayBbK+xkTT5E" +
       "Kmui3A7wQbUztBKBmDc6ktrr+M0KUqqVq1W9XnEkNVtPGkN6s8RkEOBwQzsd" +
       "rNJRjTFWzGYjBH1mYBHccoj2qBSZNPplSW7SCLV2a4PapEs5FcvvWbyTmAu+" +
       "PNUbWYZ6WKNcqwfjnsSS0mA7q5V9stXYUDVYkoOhIreCiNnqyxFPqGzmO7Iy" +
       "Tde90nK6rW8E0gnomg7P5XKJa5WSBO1gRHczwAR82deCzajTSfqjbd9URaHs" +
       "CHE6ViYNYSoISuIzUoqJAjozcLIap54sz5G60hd8mhw1YZlu6Bw5KhO82l9G" +
       "9UVtzvJGgmLu0BfmSLOLN0SsHXI4D897nL4UK1V2aduC0U1hoRuoXn9tR1ln" +
       "2s/sJTvqbZf9VgjDTTpFbFkiZwzWWHgGR5E8+Nck6v0WPrMkhInnXKhE/Uq0" +
       "Lm26lu51OjWj0xiIgP67VQovV+prJJJ6REoyc6XZa5SoQXXDWrzo1DlYNVZa" +
       "dT2kgsisyCT4t2GMl/RwzqrdoNkzwrEmKfXZyPMtporrNb4CZ07XNBVqMF21" +
       "K+VJs9dMKtVSaaD7aTOIdHdYGVZ73S2CqipSTXw2AouSs7RJMi2v/GnDKwkT" +
       "udUqDyWeHi5MdVWiWETtlWw17JJjREEJSqBXytauSNFSAqs2zhLFqrWzqLvQ" +
       "q0tRwe3eOmInAb9ROV5nvFWaWZyPxuORhjnUbLUAf3eX8qw15LHBhHamrRW9" +
       "0RRj0G87jS6SjtuhH3vrME7dAPxXavM1TEUwSm3260Ez6hqjoK/KjWjgKuSm" +
       "SRAdVIokLXRqNjFrMyVtEQOzSKnftDJfMUtcNZupY8NqeprSQxke3srmwvFU" +
       "IiRimslSv63aieupDaFP+m1DJfA0ytANIyLbHhO3xgu7jje66CpqWzQCw8yK" +
       "magiPUPlyaaeYrQsjplaq9VoTytUE56MnKEOcyjdXNmlZFhHk0lTbk6TuWdg" +
       "9ekmxKyZG850fiB6it/0tmgqDgbGdqWKUcUgvKUflemA4bhQitjKKHJ65XnA" +
       "ygvBaXbsbNiVsBmKtCV9XFkpQxRdtdZ0E9P9md2gMxK0JyXR3ixphW/wUWrZ" +
       "Tqms9uwtqQPVg4HJ1bpurYQMZzEpk0Pe9UrVALzhk1paawzbw61dJVfhajW3" +
       "rEZ9O24nAYs5ylIh2y0YjkilWtFdrO/A1oLoZ/W1rWOiJ6RTRZGQsrmM19My" +
       "IU1SfI33FZxKuSpcn/fxypDcYJZuAIeQVYqcM4sRVUFTjQj00XjTbOsx6pBT" +
       "WIGpsjBcClkL1kpTGBZxuSQrlblR7ttuAriHxqxlM3McNK6NeHiKdcQaZ+sk" +
       "HEZ4xmX1ml+Rm1494AWCN8ettO2EtI9LTr1fXgR6FFO0bpd0JmiRmUHbodxe" +
       "Nxl1KY/Xad1L5HINGIqUpVWpEyxRNUhKXm/bbZmbuTFvBZhv1NobGCzOlQED" +
       "gs6q1c0mSLoyZSjAUzHdyLszMYMlalMLyj2bmvQoW026fZadpfEA5VMV9ng8" +
       "qeNJbI0HTKdCLzplPQGUxccDDk+DGNXVSlLqtTvVTdBcO/0JvkG2/e66g5QY" +
       "ArGZSh8nkrLbRjqt5QAPllYJBbHaWPUHdGXtWZaMkhVVwRGa6ExBoLmRRyN6" +
       "Sg0StT5gqFk3XsJqzVl2pls3iGWlaq6GHlkXW0uVromUJ9Y9gVu3jXq4aCvT" +
       "DTMzm5LWH3a6CwMddia1cn3N1BF83BX1wXgtbNcNjY4luq7Xl+2oR0/tDk66" +
       "na64HHOjDWXqrhZIrQWQTQl4DZuwVrkcl3syb4CQR1ab21UHq3VTZuCsBx7T" +
       "KEukVFJaWGKZtOskFXLt2qWOUVdaOsEkg8WwBi9ZI4ajLVsWVz1qxUxXca1v" +
       "2CGBrFI7JBtbck5sMXaCUaGQVcfj1QoHjLOAezxmua3WrNwvEZRRcrrzxspa" +
       "E5Q+xDIY3TS6ONGrjkfNJip1gD0jexqz8zRZwCmL1Edqe6qQ9SjazDJqGGPq" +
       "AGlXVty0WZkBOyusV9rOJW6WjT2f6cOVMGK4zJPGXn2BSNtqdV512SWTuiE+" +
       "5cc6kW1IjEviOlO26poKMyU0aJqJOahLorcyvZo2qq6DqFFS5ltA7OxgFNWG" +
       "XMxFhJdZGVEVrZa4rFYbGLwlVw7FAwZ1216kbMfVarMutEYNsS7wgton+6Fh" +
       "R7NGY7CMulSw2o6k2nxF1pISPJIbU62X1TOxzlQbkkiTTbRckyx8EARDcxVy" +
       "7ZE4Yq2GWZ6M8FJZS70e8F/elcyAV+tVmuVdE59Sfv7GZ811F4sVesaZ8nZI" +
       "Wlwfj5C5UiV8dDau8WsQuxCN+UDsqA2eZRuM3FjOpWk0GwdIW0UVnS4h2WBR" +
       "ngwqXVfh+jRSnW9FJIQF1avqtZa89NrhaENvS5hQElJ97HhoE4/b7fyv8it/" +
       "vN2K24qNmcOTNN1s5hWDH+Nf+q7q/jx58HAzuvicu8pm9LENOyjfebj7Sgdk" +
       "xa7De9/w+BMS/b7y2f2NzmUI3Rg67k8D88rmMVE3AEkvvvIOy7g4HzzagPvU" +
       "G/71rvnLN6/5MY4Y7j2l52mRvz1+8jODF4m/cha65nA77pKTy5OdHj65CXeT" +
       "L4eRb89PbMXdfWjZwrovAM/evmX3Lr/Nf1kvOFN4wW7ur7KP7F+lrtgZt0Lo" +
       "ZlUOGV9zfC1Mi4bTY47C5vt/psOHRy5k/6iNnuMDFQX6IeZn54UvAU9jH3Pj" +
       "mcf82FXqfjFPXhdCdwLMhOWasiWD16R0eBoWnNg6O+l2Uz4ufPkR8fcnX/n8" +
       "e7KPPLnbGRP4QA6h0pXuDVx6dSE/f3rwKmdoRyfK3xv8zFPf+Br7qoPVcvOh" +
       "IW/OId1xNUMebMjefrRdT4RycUKT17z5aEIffRoTente+HzwvHxfj5c/8xP6" +
       "+FXq3pknbwMkAia0HYHFWIAbHIF7+9MF9wB4+vvg+s88uN+8St1v5clvAGoH" +
       "4PJrHrwYtiXJl4PgFMh3P12Qd4JnvA9y/MyDfPIqdR/Ok/eH0DkAcjElTyH7" +
       "wNNFdh942H1k7DOP7BNXqfuDPPndELoVIOvJgehr7sF56zGEH3saCAsWyOuF" +
       "fYTCM4PwzP5Z/z6FPHilawW7uwT7N5AKSX92FXt8Ok/+OIRu8WVVCwAXzXk1" +
       "uNwb59qto0lHFnrqaVjojoMl/Ni+hR77P7HQHbmF4qq4JznWXn/3Win6/c1V" +
       "7PHFPPmrELqgBb0UxA2auN/zcja5XnAcU+btI7N8/scxSxJCz77c9Y/8/PrO" +
       "Sy6e7S5LiR9+4vwNz3ti8XfFDYjDC003ktANSmSax48bj+XPub6saAXAG3eH" +
       "j27x9bUQuvuq11NApFF8F7p/ddfpn0PoeVfoBBhjlzne/hvAmqfbA7nF9/F2" +
       "3wqhm47aAVG7zPEm/xZC14AmefY77sE8v/hKCIBtT1k2OXMyMj6ct9t/1Lwd" +
       "C6YfOBEmFPcID8LViNmPRj7yxJB67Xcb79vd9xBNPstyKTeQ0PW7qyeHIe/9" +
       "V5R2IOsc/tAPbv3ojQ8eBBy37hQ+WiPHdLv38hcq+pYbFlcgsk8872Mvff8T" +
       "XyqOYf8X6xx4YuApAAA=");
}
