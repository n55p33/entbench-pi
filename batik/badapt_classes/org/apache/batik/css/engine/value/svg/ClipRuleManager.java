package org.apache.batik.css.engine.value.svg;
public class ClipRuleManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_EVENODD_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          EVENODD_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_NONZERO_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          NONZERO_VALUE); }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_CLIP_RULE_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 NONZERO_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public ClipRuleManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1Ze5AUxRnv3YN7cXDHwQHyOLjjgOLhroiE6BHicYAc7sEV" +
                                                              "hxQ5lKV3tvd2YHZmmOm928MQkUoCSUUKEREtpfIHFoagUFasPIwGy0qUaKyo" +
                                                              "JGgsMQ+rJBIqUqmYVEgk39czs/PY2z2vKmSrpne2+/v6e/366697T14mI02D" +
                                                              "NDKVR/iAzszISpV3UcNkyXaFmuYG6ItLj5TRv225uPbWMCnvIWPS1OyUqMlW" +
                                                              "yUxJmj1kmqyanKoSM9cylkSOLoOZzOijXNbUHtIgmx0ZXZElmXdqSYYEG6kR" +
                                                              "I2Mp54acyHLWYU/AybQYaBIVmkTbgsOtMVIjafqASz7JQ97uGUHKjCvL5KQu" +
                                                              "to320WiWy0o0Jpu8NWeQ+bqmDPQqGo+wHI9sUxbbLlgTW1zggubTtZ9ePZCu" +
                                                              "Ey4YR1VV48I8cz0zNaWPJWOk1u1dqbCMuYN8jZTFyCgPMSctMUdoFIRGQahj" +
                                                              "rUsF2o9majbTrglzuDNTuS6hQpw0+SfRqUEz9jRdQmeYoZLbtgtmsHZG3lrL" +
                                                              "ygITH54fPfTIlrpny0htD6mV1W5URwIlOAjpAYeyTIIZZlsyyZI9ZKwKwe5m" +
                                                              "hkwVeacd6XpT7lUpz0L4HbdgZ1ZnhpDp+griCLYZWYlrRt68lACU/WtkSqG9" +
                                                              "YOsE11bLwlXYDwZWy6CYkaKAO5tlxHZZTXIyPciRt7HlTiAA1ooM42ktL2qE" +
                                                              "SqGD1FsQUajaG+0G6Km9QDpSAwAanEwuOin6WqfSdtrL4ojIAF2XNQRUVcIR" +
                                                              "yMJJQ5BMzARRmhyIkic+l9cu3X+vuloNkxDonGSSgvqPAqbGANN6lmIGg3Vg" +
                                                              "MdbMix2mE17YFyYEiBsCxBbND7965fYFjWdetWimDEKzLrGNSTwuHUuMeXNq" +
                                                              "+9xby1CNSl0zZQy+z3KxyrrskdacDhlmQn5GHIw4g2fW/+Iru0+wS2FS3UHK" +
                                                              "JU3JZgBHYyUto8sKM+5gKjMoZ8kOUsXUZLsY7yAV8B6TVWb1rkulTMY7yAhF" +
                                                              "dJVr4je4KAVToIuq4V1WU5rzrlOeFu85nRBSAQ+pgaeZWB/xzUk6mtYyLEol" +
                                                              "qsqqFu0yNLTfjELGSYBv09EEoH571NSyBkAwqhm9UQo4SDN7QDKRthd0ivZR" +
                                                              "JcuiZl8voEbW12cV1klVAIURQcTp/0dZObR7XH8oBCGZGkwICqyl1ZqSZEZc" +
                                                              "OpRdvvLKM/HXLLDhArE9xsliEB+xxEeE+AiIj1jiI0J8BMRHAuJJKCSkjkc1" +
                                                              "LBBACLdDMoBsXDO3+541W/c1lwH69P4R4H8kbfbtSu1uxnDSfFw6VT96Z9OF" +
                                                              "hS+HyYgYqacSz1IFN5k2oxfSl7TdXuE1Cdiv3G1jhmfbwP3O0CSWhKxVbPuw" +
                                                              "Z6nU+piB/ZyM98zgbGq4fKPFt5RB9SdnjvTfv/G+m8Ik7N8pUORISHLI3oX5" +
                                                              "PZ/HW4IZYrB5a/de/PTU4V2amyt8W4+zYxZwog3NQVwE3ROX5s2gz8Vf2NUi" +
                                                              "3F4FuZxTCD6kycagDF8qanXSOtpSCQanNCNDFRxyfFzN04bW7/YIwI7FpsHC" +
                                                              "LkIooKDYEb7UrT/xzht/XiQ86WwetZ5dv5vxVk/CwsnqRWoa6yJyg8EY0L1/" +
                                                              "pOuhhy/v3SzgCBQzBxPYgm07JCqIDnjwG6/uePeDC8fOhV0Ic9ixswkofHLC" +
                                                              "lvHX4BOC5zN8MMlgh5Vs6tvtjDcjn/J0lDzb1Q2SnwJJAcHRcpcKMJRTMk0o" +
                                                              "DNfPv2tnLXzuL/vrrHAr0OOgZcHQE7j9Nywnu1/b8o9GMU1Iws3X9Z9LZmX0" +
                                                              "ce7MbYZBB1CP3P1vTXv0FfoE7A2Qj015JxMplgh/EBHAxcIXN4n2lsDYEmxm" +
                                                              "mV6M+5eRp0iKSwfOfTJ64ycvXhHa+qssb9w7qd5qociKAghbQuzGl/JxdIKO" +
                                                              "7cQc6DAxmKhWUzMNk91yZu3ddcqZqyC2B8RKkJDNdQYkzZwPSjb1yIrfvfTy" +
                                                              "hK1vlpHwKlKtaDS5iooFR6oA6cxMQ77N6V++3dKjvxKaOuEPUuChgg6MwvTB" +
                                                              "47syo3MRkZ0/mviDpcePXhCw1K05puQz7FRfhhUFvbvIT7y95DfHHzzcb5UE" +
                                                              "c4tntgDfpH+tUxJ7/vjPgriInDZIuRLg74mefHxy+7JLgt9NLsjdkivctiBB" +
                                                              "u7w3n8j8Pdxc/vMwqeghdZJdQG/ETQnWdQ8UjaZTVUOR7Rv3F4BWtdOaT55T" +
                                                              "g4nNIzaY1tztEt6RGt9HBzA4BUO4DJ45NgbnBDEYIuJljWCZLdq52CwQ4Svj" +
                                                              "pEo3NA5aMih6y01RrXPQRFapksvLEVCZXEIO8IpN2xQskziZP/T+bpXHAG8r" +
                                                              "JWP7RWzutOQuHQzPucHtCOHrja6+4lNeYm16IExwnU4rVjGLav/YnkNHk+ue" +
                                                              "XGiBuN5fha6EQ9bTv/3P65Ejvz87SKFTxTX9RoX1McUjswJF+pZNpzhMuBh8" +
                                                              "f8zBP/24pXf5cGoS7GscourA39PBiHnFV2JQlVf2fDx5w7L01mGUF9MD7gxO" +
                                                              "+b3Ok2fvmC0dDIuTk7U4Ck5cfqZW/5KoNhgcEdUNvoUxMw+AcRjY2fAssgGw" +
                                                              "KLgwXNDNxmaTH+vVJVhL7D1yiTERMlhk42SzQ03DmReWHFRF4ljrr1Mxzt3Z" +
                                                              "hAk1pZyBOqPPPoLd3LVV2tfS9aEFwxsGYbDoGp6KPrDx/LbXRcAqESF5N3nQ" +
                                                              "AUjyVEd12ERwKZTI0QF9orvqP9j++MWnLX2CCTlAzPYd+va1yP5D1hKxDtkz" +
                                                              "C865Xh7roB3QrqmUFMGx6qNTu55/atfesO33uzmpSGiawqiaj0sov3mN93vR" +
                                                              "0nXFt2p/eqC+bBUsvg5SmVXlHVnWkfQDsMLMJjxudc/lLhxtrbFA4yQ0z9k5" +
                                                              "RZJjJZLc59i0sWO5Lvq3+kGPmfk2G7m3DR/0xVhLAPvrJca+ic19cNSRzTZV" +
                                                              "zlCOtaKDehzTXJfsvl4umQVPm21X2/BdUoy1hNkPlhh7CJvvQKEg4y2YwG4R" +
                                                              "hzxwHRxSi2ON8Ky2rVo9fIcUYy1h9NESY9/F5lGot3sZdzyRP7tl7JWPX7rn" +
                                                              "nXNSJtu3mp4VjT8HPMvssevgwnoca4Kny/ZD1/BdWIy1hJtOlxh7Fpvv+124" +
                                                              "FnKVU43ViQIfa1K76nI9dPI6eGgsjs2AZ5Nt5qbhe6gYawkv/KzE2EvY/MTy" +
                                                              "0AqWolnFKtgdD80Zul516YXjnr8OjmvAsZnwxG3r48N3XDHWEs55o8TYr7E5" +
                                                              "y8kYcFxHEnZLOPAzq67sdp3xy/+FM3IQnsCFH55OJxX852Ddk0vPHK2tnHj0" +
                                                              "rvOiRs7fZddAzZPKKor3/OR5L9cNlpKFaTXWaUoXX+9wMutz3UlC4oFW2HDe" +
                                                              "Yn2Pk6YhWeFQ1ZcHkM14gZMpJRjhUGW9eHn+AJvpYDygFrReyg9h3QcpQQvx" +
                                                              "7aX7iJNqlw6EWi9eko9hdiDB10u6s2QWDe0uFzB2PHMh/8krD6CGoQDkOazN" +
                                                              "9FWo4o8rp4TLWn9dxaVTR9esvffKF560bvIkhe7cibOMgsLNui/Mn1Wais7m" +
                                                              "zFW+eu7VMaerZjkVpe8m0aubgDHsQuLWbXLgastsyd9wvXts6Yu/2lf+FtTC" +
                                                              "m0mIwplgc+GtQU7PwiFxc6ywQIVznbhza5372MCyBam/vifuZUjBbUyQPi6d" +
                                                              "O37P2wcnHWsMk1EdZCQUyywnrjNWDKjrmdRn9JDRsrkyBypi3Kjiq37H4Aqj" +
                                                              "uHsIv9juHJ3vxSteTpoLa/rCi/FqRetnxnItqyZxGqifR7k9zpnVd9zL6nqA" +
                                                              "we3xHGNyVomA0QDIxmOduu7cj46YpYs8MzB4zYDtZ+IVm2v/BdGjVxbUHgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "rpCJxBtBMhpUPIH2cm0SdbXWtpV3GbjW8FZbVBq6M2wYSCAI7tTbTFcnnMGi" +
       "NmItMNW3eIomGFVF7CE/aE9wTE2nlU19ata2sd2ryjgZzU2Mb/RMVNruhCWM" +
       "jl1aU6W+zNOxy6eTpNKROGNd23aCQB0mY0pNVjROp7Y4JyrxYrTQKAxHMn3e" +
       "5yaWZjZqs5yt1nGbU5bEgBs0LMP3kUmah3VB65iIJ2Td6Y5hGJeS69RiUQu3" +
       "s7bYHyRpMFxvcHfoNceMj6cwtVlxUgcs2gOUrjtshzeyRV9Gan0uGQtzssoO" +
       "2q4PFtu2UalMlmBe13q9udXJmbVciUUkY1AcASCLh2beazXRlYb5brfO+jub" +
       "H0yGaXMHYh0UhcVwqwTTej3KbW821MVkp4tGNXDjuk236zFXdVaDsObByq5X" +
       "2XT5IFbRmb1YWcTCWZpbFg8m1GRkpJEswRalpaG/GXQaGVvN2ybKCSNjJFAS" +
       "2tarwXKKUvGuXjGHjL01a0PMruMcXE2B/TpM7I8ksaJLSFuiZ1w+Fxa51ZuG" +
       "4hhXtHy+Gm2D2GpENrtg7BqyqsFdmXczRKNNxtI0rDeKY3bcVxtZbZ0MG5yW" +
       "pwnBpTO9NqVb46zmL9z2lpT4NWBp0/3Zug0PUGvohvVAkPOMY7DQwoAjrzDf" +
       "cVb0bBRGddtrLIx5i2AmcRAosZo4riQ2xk4GCzgC+l+SoLFROLVSDSwKcVxB" +
       "ao2BM17wjfpCZ8mtiIyxpkO2ZYZsKiCeN4JaR0DpEN1tNKWprsXEjOFx3q/1" +
       "4zU8mWfVzm7pWs5gHKoy3qoKkYUizfXKcPzW1LDjTiA4STqs+40WXQefHst+" +
       "gKJua772sT6atcy1NEiJviNQU6aT75pYIHv1NIMrg0mdZJ2gNyBQdDpKVy20" +
       "hstmNWaIMVgMCKPqx1OdC7CtIMudXGDGY9evw1MOpcBIWN54IM5XS5F3V6tK" +
       "O5lEYV7nrV7DHSxrBK6snRpjNtfaUhmwCFhIzAnSUIWJN+IMjR8u2wrhVDqj" +
       "2FvjmTrwOSVT21qdlTyWjVNMXGH6iN5ZSbO/1NuK6bY1Wce7SDVqBjV2iSvV" +
       "aJB3awwx0eCW6ePN3tBlcXMq5nR7sHQbbsv3GnNq6bTlVFzMubYSxNvteIA2" +
       "qwCWTU3BJH0znagBRUc6PHGQpagHmJ0PlhUlwhYTUfEFw1x4SsuuitFGxYmA" +
       "jajlZkWp4DM6yOR2Eq/CoLmO4Jq1rQzCec+u2mQCVjqpMgxZHmMSfZBKzSxh" +
       "yUXubLRcROtYbdLLuqINx/o2Eniju+EzltGb8rSOMbVEcohlMDGRviz0WD4D" +
       "a65v0Et8bPi2zDntEc4Fvpl1M0+vjw19V8eIRmdnRERAxm3wN6rH6SxU5p5L" +
       "ibDf0+HBjlNCJ3XIcJcJ6XCnbznMbOees5DbOdV0dp1EqafEkM4Wrt2psjiZ" +
       "2lM5ijDJaDTX3jpoTfJuI1/joVAB32q1GHj20Fik4DtP7XSKT+HtC9uNuK/c" +
       "eDk+BjQsrKhgX8BX+L7qkSJ5/HiTq/xdusUG+qlNRqjYWXjdzU73yl2Fj73r" +
       "6Wfk6ceRi4ebs2II3RW63ndYSqxYp5q6DFp60813UCbl4ebJpuFn3vX3D87f" +
       "rL39BRyLvP6cnOeb/PnJJz43fIP0wYvQbcdbiM85dj3L9OTZjcO7fSWMfGd+" +
       "ZvvwdceWfaCw2BvAUz+0bP3GRxM39IILpRfsx/4We98/cIu6HyySJIQe0APS" +
       "0RRfDxWZ8d3yILtkeOsph3l7CF3euK6liM6JM6XPt6VzusuyIDyrfbFh+p2H" +
       "2n/nS6/9+25R96NF8u4QerkedBzdFsPi0OJI/aLuHSd6vufF6vk4eDqHenZe" +
       "ej0/fIu6jxbJB0Pofr241VBu8d1Eyx9/EVpeKQofAg9xqCXx0mv5M7eo+3iR" +
       "PBNCV1QlPFLv+EzwnB/fph9eNym1/ukXofX9ReEj4GEOtWZeeq1/6RZ1v1wk" +
       "nzyrNX2IP+yJip96ESqWS8DD4Fkdqrh66VX87VvUPVskv75XEVe2YmTtj3qO" +
       "jhPe+PzHISf0pTV+40VY4xVF4WPguX5ojesvvTW+cIu6PyiSz4TQvcAapKw4" +
       "YXHgsL9cRJxo+NkXomEKbHvuGkNxDvvq59yk2t/+kT71zJU7X/UM/6flSf7x" +
       "DZ27KOjObWRZp4/NTuUveb6y1UsV7tofonnl3x+H0OP/p5sWYNaCtBT+i3vW" +
       "L4XQI8/LGh6eAp1m/IsQes0tGEPo0j5zmufLYJ24EQ8QC6SnKf8qhK6epwRS" +
       "lP+n6f4mhO4+oQOd7jOnSf4WtA5IiuzXvCN/rz+/uU4c43A80wtnY7RjR7n/" +
       "+RzlVFj32JlgrLyOdxQ4RfsLedelTz8zor//G82P729LSJaY50Urd1LQ5f3F" +
       "jePg65GbtnbU1iXiiW/e+4t3PX4UKN67F/hkfp2S7fU3vo7Qt72wvECQ/9qr" +
       "fvm7fvaZL5cHfv8LG+92bicpAAA=");
}
