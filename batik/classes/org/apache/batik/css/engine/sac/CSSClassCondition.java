package org.apache.batik.css.engine.sac;
public class CSSClassCondition extends org.apache.batik.css.engine.sac.CSSAttributeCondition {
    public CSSClassCondition(java.lang.String localName, java.lang.String namespaceURI,
                             java.lang.String value) { super(localName,
                                                             namespaceURI,
                                                             true,
                                                             value);
    }
    public short getConditionType() { return SAC_CLASS_CONDITION;
    }
    public boolean match(org.w3c.dom.Element e, java.lang.String pseudoE) {
        if (!(e instanceof org.apache.batik.css.engine.CSSStylableElement))
            return false;
        java.lang.String attr =
          ((org.apache.batik.css.engine.CSSStylableElement)
             e).
          getCSSClass(
            );
        java.lang.String val =
          getValue(
            );
        int attrLen =
          attr.
          length(
            );
        int valLen =
          val.
          length(
            );
        int i =
          attr.
          indexOf(
            val);
        while (i !=
                 -1) {
            if (i ==
                  0 ||
                  java.lang.Character.
                  isSpaceChar(
                    attr.
                      charAt(
                        i -
                          1))) {
                if (i +
                      valLen ==
                      attrLen ||
                      java.lang.Character.
                      isSpaceChar(
                        attr.
                          charAt(
                            i +
                              valLen))) {
                    return true;
                }
            }
            i =
              attr.
                indexOf(
                  val,
                  i +
                    valLen);
        }
        return false;
    }
    public java.lang.String toString() { return '.' + getValue();
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1Ye2wcRxmfu4vfdvzIs3nYeThBeXDX0LpScFqaXO3G4eyY" +
                                                              "OI3AIbnM7c3dbby3u9mds88ugTYVSopEFILbhIpYIKVqQW1ToUaAoFVQJdqq" +
                                                              "BaklohTUFAkkwiOiEVL5I5TyfTN7u3t7Z4cgwNLOrWe+75v5Xr/vm33mGqmx" +
                                                              "LdLJdB7lkyazo306H6aWzdJxjdr2XphLKmci9G8Hrw5tDZPaUTI/R+1Bhdqs" +
                                                              "X2Va2h4lK1Xd5lRXmD3EWBo5hi1mM2ucctXQR8ki1R7Im5qqqHzQSDMk2Eet" +
                                                              "BGmnnFtqqsDZgCOAk5UJOElMnCS2PbjcmyDNimFOeuRLfeRx3wpS5r29bE7a" +
                                                              "EofpOI0VuKrFEqrNe4sW2WQa2mRWM3iUFXn0sNbjmGBXoqfCBGueb/3gxqlc" +
                                                              "mzDBAqrrBhfq2XuYbWjjLJ0grd5sn8by9hHyRRJJkCYfMSfdidKmMdg0BpuW" +
                                                              "tPWo4PQtTC/k44ZQh5ck1ZoKHoiT1eVCTGrRvCNmWJwZJNRzR3fBDNqucrWV" +
                                                              "Wlao+Nim2PSZg23fi5DWUdKq6iN4HAUOwWGTUTAoy6eYZW9Pp1l6lLTr4OwR" +
                                                              "ZqlUU6ccT3fYalanvADuL5kFJwsms8Senq3Aj6CbVVC4YbnqZURAOf/VZDSa" +
                                                              "BV0Xe7pKDftxHhRsVOFgVoZC3Dks88ZUPc1JV5DD1bH700AArHV5xnOGu9U8" +
                                                              "ncIE6ZAholE9GxuB0NOzQFpjQABanCybVSja2qTKGM2yJEZkgG5YLgFVgzAE" +
                                                              "snCyKEgmJIGXlgW85PPPtaFtJx/Ud+phEoIzp5mi4fmbgKkzwLSHZZjFIA8k" +
                                                              "Y/PGxON08YsnwoQA8aIAsaT5/heu37u589KrkmZ5FZrdqcNM4UnlfGr+myvi" +
                                                              "G7ZG8Bj1pmGr6PwyzUWWDTsrvUUTEGaxKxEXo6XFS3t++rmHvsv+HCaNA6RW" +
                                                              "MbRCHuKoXTHypqox636mM4tylh4gDUxPx8X6AKmD94SqMzm7O5OxGR8g8zQx" +
                                                              "VWuI/8FEGRCBJmqEd1XPGKV3k/KceC+ahJA6eEgzPF1E/olfTtKxnJFnMapQ" +
                                                              "XdWN2LBloP52DBAnBbbNxVIQ9WMx2yhYEIIxw8rGKMRBjjkLio20WThTzKZK" +
                                                              "LD4yInwJ+ZQWqkcx2sz/0z5F1HfBRCgErlgRBAINcminoaWZlVSmCzv6rj+X" +
                                                              "fF0GGSaGYylOtsDWUbl1VGwdha2jcusobB2t2JqEQmLHhXgE6Xhw2xgAACBw" +
                                                              "84aRA7sOnVgTgYgzJ+aBzZF0TVklinsoUYL2pHKho2Vq9ZUtL4fJvATpoAov" +
                                                              "UA0Ly3YrC5CljDlZ3ZyCGuWVilW+UoE1zjIUlgakmq1kOFLqjXFm4TwnC30S" +
                                                              "SoUMUzY2exmpen5y6ezEw/u+dHuYhMurA25ZA8CG7MOI6S52dwdRoZrc1uNX" +
                                                              "P7jw+FHDw4eyclOqkhWcqMOaYEwEzZNUNq6iF5MvHu0WZm8A/OYUHA/Q2Bnc" +
                                                              "owx+ektQjrrUg8IZw8pTDZdKNm7kOcuY8GZEsLaL94UQFk2Yjyvg6XYSVPzi" +
                                                              "6mITxyUyuDHOAlqIUnH3iHnuVz//4x3C3KWq0uprB0YY7/UhGQrrEJjV7oXt" +
                                                              "XosxoHv37PDXH7t2fL+IWaBYW23DbhzjgGDgQjDzl1898s57V85fDntxzqGU" +
                                                              "F1LQERVdJXGeNM6hJOy23jsPIKEGKIFR0/2ADvGpZlSa0hgm1j9a1225+JeT" +
                                                              "bTIONJgphdHmmwvw5m/bQR56/eDfO4WYkIKV2LOZRybhfYEnebtl0Uk8R/Hh" +
                                                              "t1Z+4xV6DgoFgLOtTjGBtxFhg4jQfCk0ZoITi25UFl2cv0sMwq89gvB2Md6J" +
                                                              "NhHsRKxtxWGd7c+P8hT0NVVJ5dTl91v2vf/SdaFQeVfmD4dBavbKCMRhfRHE" +
                                                              "Lwni105q54DuzktDn2/TLt0AiaMgUQF8tndbgKPFsuBxqGvqfv2TlxcfejNC" +
                                                              "wv2kUTNoup+KPCQNkADMzgEEF81P3Sv9P1EPQ5tQlVQoXzGBPuiq7t2+vMmF" +
                                                              "P6Z+sOSFbU/NXBGBaEoZy/0CP4bDJjckxV9tsDD6Q7JMgkVWzta7iL7r/LHp" +
                                                              "mfTuJ7fIDqOjvB/og3b32V9++Eb07G9fq1J6Grhhflxj40zz7RnBLcvKxaBo" +
                                                              "6zzIenf+6d/9sDu741YqBc513qQW4P9doMTG2ZE/eJRXjv1p2d57coduAfS7" +
                                                              "AuYMivzO4DOv3b9eOR0WPazE+4ret5yp129Y2NRi0KzrqCbOtIiwX+sGQDs6" +
                                                              "djU8UScAotWBt0rsuHA2G+scWb1vjrXP4vAZQI0s426bISpHWeuATh4ppGwo" +
                                                              "82oeaMadTvgTw4eUE93Dv5cxeFsVBkm36OnYV/e9ffgN4a16DA/XRr7QgDDy" +
                                                              "Faw2qfxH8BeC55/44LlxQnaUHXGnrV3l9rWYhxbZMMdFtFyB2NGO98a+efVZ" +
                                                              "qUCw7w8QsxPTX/koenJaJpS8HK2tuJ/4eeQFSaqDwwE83eq5dhEc/X+4cPRH" +
                                                              "Tx89Hna8NMBJDcCZxV0fhtwGb2G50eVJ73u09cenOiL9kKgDpL6gq0cKbCBd" +
                                                              "Hqx1diHl84J3m/JC1zkzWpyT0MYSyH0Shz3y/e7/EF9xIm6K+UE3yhfg2lJ4" +
                                                              "epwo77n1BJmNNZAEYXGQcKlqLsBefOIOJZo28lH82gBW9WqmPUcGTeAA17Wa" +
                                                              "POVKTpCMOq7Gn6TvHWp+XcowNEb1oCPx35zPusb/wLoduLYMnkHHRIO3bt3Z" +
                                                              "WOcw0PE51h7F4Rgn9dzwNSueGR75b5ihyEl7xVUKC/zSii848quD8txMa/2S" +
                                                              "mQfeFnXO/TLQDNCVKWiaL4f8+VRrWiyjCrWaZb9jip+vQRW5yU2PQ+2lijj/" +
                                                              "Kck0zcnyOZig4ZUvfp4zcKWqxgPSYfRTPgGAH6SECBa/frpznDR6dLCpfPGT" +
                                                              "fAukAwm+ftssZVPPv3Gzdb9Gui4phipbKBEFi24WBb6eaW0Z9IsveSV0LMhv" +
                                                              "eXDhndk19OD1u56UNxhFo1NTKKUJMFFeptyWYfWs0kqyanduuDH/+YZ1Jahu" +
                                                              "lwf2Mmm5L9zjkOkmRt6yQHtvd7td/jvnt730sxO1b0GR2U9CFKBpv+87mvxo" +
                                                              "BHeEAvRq+xOV2A/tlbh39G54YvKezZm//kZ0p06tWDE7fVK5/NSBX5xeeh7u" +
                                                              "J00DpAaqECuOkkbVvm9S38OUcWuUtKh2XxGOCFJUqpUVlvmYJBQzWNjFMWeL" +
                                                              "O4v3X07WVBbLyq8G0MlPMGuHUdDTTmlq8mbKPjGWuq6CaQYYvBlfQ5GVUCx7" +
                                                              "h0gyMWiapV6i9kNTgEWuOi7j+IJ4xeHivwD23Ld95RcAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "pSIAAA==");
}
