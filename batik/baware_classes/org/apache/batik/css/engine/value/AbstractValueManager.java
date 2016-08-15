package org.apache.batik.css.engine.value;
public abstract class AbstractValueManager extends org.apache.batik.css.engine.value.AbstractValueFactory implements org.apache.batik.css.engine.value.ValueManager {
    public org.apache.batik.css.engine.value.Value createFloatValue(short unitType,
                                                                    float floatValue)
          throws org.w3c.dom.DOMException { throw createDOMException(
                                                    ); }
    public org.apache.batik.css.engine.value.Value createStringValue(short type,
                                                                     java.lang.String value,
                                                                     org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        throw createDOMException(
                );
    }
    public org.apache.batik.css.engine.value.Value computeValue(org.apache.batik.css.engine.CSSStylableElement elt,
                                                                java.lang.String pseudo,
                                                                org.apache.batik.css.engine.CSSEngine engine,
                                                                int idx,
                                                                org.apache.batik.css.engine.StyleMap sm,
                                                                org.apache.batik.css.engine.value.Value value) {
        if (value.
              getCssValueType(
                ) ==
              org.w3c.dom.css.CSSValue.
                CSS_PRIMITIVE_VALUE &&
              value.
              getPrimitiveType(
                ) ==
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_URI) {
            return new org.apache.batik.css.engine.value.URIValue(
              value.
                getStringValue(
                  ),
              value.
                getStringValue(
                  ));
        }
        return value;
    }
    public AbstractValueManager() { super(
                                      ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "EFsZAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1ae+zr1l33/d3e29u7tve227rS9d3bjTbj5yRO7ES3G43j" +
       "RxI7iWMnzoOxO7/j+BnbcRyP7lEBrRiMCtox0FYhsQk2dQ8B46mhIgTbtAlp" +
       "aOIlsU0IicGYtP7BQBQYx87vfW/bVZuIlJNj+/v9nu/rfM7X5+S5b0NnwgAq" +
       "+J69MWwv2tWSaHdhV3ejja+Fux22yklBqKlNWwrDIbh3Rbn/Mxe+++JT84s7" +
       "0NkZ9FrJdb1IikzPDXkt9OxYU1nowuFd0tacMIIusgspluBVZNowa4bRZRZ6" +
       "zRHWCLrE7qsAAxVgoAKcqwA3DqkA002au3KaGYfkRuESejd0ioXO+kqmXgTd" +
       "d1yILwWSsyeGyy0AEs5l1yIwKmdOAujeA9u3Nl9l8DMF+OlfecfF3z4NXZhB" +
       "F0xXyNRRgBIRGGQG3ehojqwFYUNVNXUG3eJqmipogSnZZprrPYNuDU3DlaJV" +
       "oB04Kbu58rUgH/PQczcqmW3BSom84MA83dRsdf/qjG5LBrD1tkNbtxZS2X1g" +
       "4HkTKBbokqLts1xnma4aQfec5Diw8RIDCADr9Y4Wzb2Doa5zJXADunUbO1ty" +
       "DViIAtM1AOkZbwVGiaA7XlJo5mtfUizJ0K5E0O0n6bjtI0B1Q+6IjCWCXn+S" +
       "LJcEonTHiSgdic+3e4984F1uy93JdVY1xc70PweY7j7BxGu6Fmiuom0Zb3yY" +
       "/aB02+ee3IEgQPz6E8Rbmt//qRcefcvdz39hS/PGa9D05YWmRFeUj8o3f+XO" +
       "5kP105ka53wvNLPgH7M8T39u78nlxAcz77YDidnD3f2Hz/N/MX3vJ7Rv7UDn" +
       "29BZxbNXDsijWxTP8U1bC2jN1QIp0tQ2dIPmqs38eRu6HvRZ09W2d/u6HmpR" +
       "G7rOzm+d9fJr4CIdiMhcdD3om67u7fd9KZrn/cSHIOgi+EJvBN8Hoe3ngayJ" +
       "IBOee44GS4rkmq4Hc4GX2R/CmhvJwLdzWAZZb8GhtwpACsJeYMASyIO5tvdA" +
       "CTNaA+gEx5K90uCGDDJeUiIxu+pKLsiKYDdLOf//c7Aks/zi+tQpEJQ7T0KC" +
       "DWZTy7NVLbiiPL3CyRc+deVLOwdTZM9nEYSC8Xe34+/m4++C8Xe34+/m4+9e" +
       "a3zo1Kl82NdlemzzAETRAngAkPLGh4Sf7LzzyftPgwT019eBEGSk8EsDdvMQ" +
       "Qdo5TiogjaHnP7R+n/ie4g60cxx5M93BrfMZO5fh5QEuXjo5464l98IT3/zu" +
       "pz/4mHc4945B+R4kXM2ZTen7T3o58BRNBSB5KP7he6XPXvncY5d2oOsATgBs" +
       "jCTgSgA7d58c49jUvrwPk5ktZ4DBuhc4kp092se289E88NaHd/Lw35z3bwE+" +
       "vhPaa/aTP//Nnr7Wz9rXbdMlC9oJK3IYfqvgf+Rv//JfkNzd+4h94cgaKGjR" +
       "5SMokQm7kOPBLYc5MAw0DdD9w4e4X37m20/8RJ4AgOKBaw14KWubAB1ACIGb" +
       "f+YLy7/7+tc++tWdw6SJwDK5km1TSbZGfg98ToHv/2bfzLjsxnaG39rcg5l7" +
       "D3DGz0Z+06FuAHFsMBGzDLo0ch1PNXVTkm0ty9j/vvBg6bP/9oGL25ywwZ39" +
       "lHrLKws4vP8jOPTeL73jP+7OxZxSshXv0H+HZFsYfe2h5EYQSJtMj+R9f3XX" +
       "r35e+ggAZACCoZlqOa5BuT+gPIDF3BeFvIVPPCtnzT3h0YlwfK4dqUyuKE99" +
       "9Ts3id/5kxdybY+XNkfj3pX8y9tUy5p7EyD+DSdnfUsK54Cu8nzv7Rft518E" +
       "EmdAogLwLewHAIKSY1myR33m+r//0z+77Z1fOQ3tUNB525NUSsonHHQDyHQt" +
       "nAP0Svwff3Sbzetz+wCfQFcZv02Q2/Or00DBh14aa6isMjmcrrf/V9+WH//H" +
       "/7zKCTnKXGNBPsE/g5/78B3Nt30r5z+c7hn33cnVsAyquEPe8iecf9+5/+yf" +
       "70DXz6CLyl6JmMMsmEQzUBaF+3UjKCOPPT9e4mzX88sHcHbnSag5MuxJoDlc" +
       "DkA/o8765w8D/lByCkzEM+VdbLeYXT+aM96Xt5ey5s1br2fdHwUzNsxLTcCh" +
       "m65k53IeikDG2Mql/TkqgtITuPjSwsZyMa8HxXaeHZkxu9t6bYtVWYtstcj7" +
       "6Etmw+V9XUH0bz4Uxnqg9Hv/Pz315V984OsgRB3oTL6mgcgcGbG3yqrhn33u" +
       "mbte8/Q33p8DEEAf8adfvOPRTCrzchZnDZE15L6pd2SmCvnqzkph1M1xQlNz" +
       "a182M7nAdAC0xnulHvzYrV+3PvzNT27LuJNpeIJYe/Lpn/ve7gee3jlSPD9w" +
       "Vf16lGdbQOdK37Tn4QC67+VGyTmof/70Y3/8W489sdXq1uOlIAnedD751//z" +
       "5d0PfeOL16g1rrO9HyCw0U2/3qqE7cb+hy1NtfJ6lCSO3k8L68W0qE+bjRpB" +
       "SPTGQKvNzdhaaBurMe62imlf6VKESLXRaiy7aSVA1NlE73OL0G6K5FJifIEn" +
       "7aa3lnxKMItDodmjA1F0KsZSmleZsWn5ku+P2zNRWuoCTtsDH572y6iu97Ae" +
       "tsJmSEQyo7qkqeUZBleRmMPiyHEDv70sbzrRsK/wnGNt+nUmrqVmSe7IyyI6" +
       "j7CKUJ1znSmuI63YjGXMMIfonNzI1aE0WC9L5SnBRJ1BfQDWyFVY9oMFjtHl" +
       "rj/BacTplkNF8cVBUpsHkld3iFFJFFtVq0OZAtuUx4uWMCQcpEQL/bBItxqC" +
       "zk5RvCPShoDw8xrCdxf1qT8fuoFlIoilyxVE6LilWc9Ret1Rv9gipXRCiWZt" +
       "NnJg3WInTCqNzSGtIAY5k11rwEl4qFDjclcW7HRQG6WLQl3jFum0Q9U2IBOq" +
       "6+kMrRt1h+6FVaGrsl6qzwKWDvUOp/Hm3JyhG87xCQ68HZebxabRViWktCQJ" +
       "DF/KbuiW6W5bw1zG7+H8xPTZ8tQcWcCrk2nSnvTXDE33MYlNxkS08ZhSMfQE" +
       "MilU+5NgE05KvbQkDZJ5S1j2A2LZrjQFtzHoGu3+TLWssLDpLXmeXcxwpzVt" +
       "19PmRpRWyxFZsMbjGuLZfcWAmaqsEB23a8XtemtNKYOhHHTSJiFFxsT2LJvr" +
       "jWx15uFOoqI9a8nyaUMbNtdDY0IFhEDFrf5YbKO+5i2HlEKKOB9i3Dokwxbf" +
       "t2OK9zbN5WiprAeib5nOfJQWhVZbnxSJDj6mZ80GZaqs74yZeCH5XWuasm1y" +
       "RktNdlNSG6IQKsYorEiDstAcVQa+MMYZzjUVRJQxjMLqQgl12nyjmvDDXo+H" +
       "WTNZNjeptFbZ7jRocNUui2KRuVD7rZSv9clGiwoMaiHAXJMtFapaGZETauSk" +
       "USPt1VcD3I+bpGJOq1ilZOtiCRGZhtSTZvNlsqi1w5hivRCTkWDTMYnu2ui0" +
       "dNxOJiVMqams24KNVaG8mpYaZUEKJwPFdtteWaY2neUyWSaY062EG9teWr3B" +
       "hlNHLmIUhP6koY+QkTPDNLeYygsD5QWyxIlz16ApdIzj8tIjVlWRG5cr9Y1s" +
       "e4V2QU46TWfVMIUCJQ01PqYGqLLsUXy7tjJFhkaX85hf0WMDnkxHZFPpxPNy" +
       "r2O2ggRlypbcNXCpT9tTW9i0e3w1SAYyM+wZJMYrUmCPW/yCXDAa464Rzijx" +
       "LZltmg7BOHqdm06cos5VSabB42NeIvFGqVxMZoSQkoE3S7uytoTVBZY41hpB" +
       "mkw/Tc1qS+NbPrdpW3gNL/Ak6LIWXws6HZQekGzYqM/waoMilUa6bgwYLKYj" +
       "FFN1mF8YfnvQ6pukxTR8vETNJZdrrIsTlOeY+Uyil7rMoqVK16p5U2lA833J" +
       "n7uq7c0GBG4TlGvVFdcb81V73LcDpGNs5G53Lo0aKwbUBw10Qjt9ZTxccJtB" +
       "W8cxbVUZoP2hXRc3K59jfVTqsykG2zHRoRKFpXCL0hoK69UWCa4ZMdFtk6tJ" +
       "pTdHq7UYpfh1bday1yORLyBSRwp5PEQNz+JVst5ExWrHLYY1HZ0PV2xxXOkk" +
       "Q5OoGDMxGvBzUqrLi/YikEdGl/LXNV8gxEKVW2ILrzpNKkq5vaAR2hNHDovO" +
       "BgOS4ql+Ren5cCUVYDimqpXisqgvZKzJ1ZLKYl1ILcphB4zqsJseMvbWODJc" +
       "uRW7Dlf7S54T2qox7oj9Ka32uSkuWlRx3e7p2mpilDNAc7s+xozWc5RRhSIb" +
       "W4lWZjmjoZt0Bfa6k4qR9AU28dFJryGXR3h9tBnFXXlI6DjXKC0a1f5C8Udd" +
       "aek4YmcxpgsFVQelx4TTNWRaLG4QPOiues5Gdac0Eic9p2YQQQHBZtXIIEvM" +
       "GnaDQq1mWMsujPTpQpEllh1tNeBizK3RG3jYQRu1RnMoo/PBkCFXJFcx2pWG" +
       "PDdLMaVRsYFI6npMI5iCJRUadlG/zW/gXgcj5FjXCrRUZKVKUWdb+tSUuCHD" +
       "znC+USZYk2hiSxOp11Z1glREUlMpY4QzXlTCK9QsUFWEk6jOCjFVvoE1nLZo" +
       "0Dy2Wo89R6gznamGSmE11mHZXMelWOwQ6wbjDomOJ3k0S1hi0FZpiWusCCdV" +
       "YIXVx9MlwKCRj440Zm41lv215ya1AtZ1qISeFSLabMGDgqYvNwIZDWv2YjnD" +
       "5vSCKlYCfJJO5U19PutK6BKvxKsGUhtHxSU6xLCsMkZKbaQJOx2ig8U6MWlO" +
       "hsAoF233WoQ7cdfVvjuqB1wwY3VhFCVyneQCmBNiGC6h1d4wnmxKw5heVqcq" +
       "aoZghhREIRp0KCoaz9pR29CQoJhitYGuR5tZeTJYzAayW3amfoczaw0v9dyg" +
       "GuKUWC0oNMz27GqpsCjQqDFl1uyKYNlaGuHDoI6m/MLiqbi8ZvGprU+GiTdH" +
       "4WmR9hKJSEp1quvS1qBQLontcUHqjhCpovnl2nKKrXo1K+rovaRKgMjWOryG" +
       "jVOlETYIfO6oEwoeDGg5NVpNHkVKzXRkILQ7hquWztY3EcEVABrIvao4a/dt" +
       "KS2O4VW8ihpogWV6vFFurMqFYruPanQwtYoVnmjCq/K0oiVyQKbIqLbCpj20" +
       "VmP1USeKPXzqysVqt6vzbVS1W1acFvuB4FUseDHZDPHhIHCLDjNmqXWntmpx" +
       "QWc16rXWRnWVpKYPkDvVui3fG7WHEUpM5yV2mIr1Fdx3E9vz8DJZIPym5C7X" +
       "aioTuOhSvRSjUqEKwtPoi7bDdFPbpvqDqAhMKCXDLg3rYDXsdHV6zTRsadVZ" +
       "dMz6dGEIm05p0J15IZ+CMomp0iNrWgqRBTZyS9rUVCOOxaXWolNWek1rbCTt" +
       "ggEW3yhwWQ4m56FIDPRk2ZqIbAnx6tP2BDetjetUahM5HPRXdaXSHy9gQg2H" +
       "cwUdyzK2tBu6Kgptgkqw8oqs+uRGYYaqBd7xesXJsqxvhhG8VthChawFqphW" +
       "uwXaYAxPXTt9fu3MhbnVZkgZpilsaFdQF7YrfXFdH/oaGpQSvFhAejReicSm" +
       "VbC64hgh5t0OPAr7OiGXhHV30hLhoaG4DrIQmQXa68U0pRarVtkcNRNRc+gG" +
       "KAZq5UECV/qNCqfAycAmxNTtjNlySSksgoVdEfgJFjQZV52YllV3aos+p8TV" +
       "4rRWNotYrJFhqVERe11OFXCVxIZ6Y+HwWG9ZLHd8UZxPWCziHUnXq0u+LtqN" +
       "BoJ78brLINUuk7rNjToVaIXThJ5eA+nD6gptGPGihTFYjSwTItOkVqw+RDTN" +
       "Spcc4Q0ZOoU79QqJWX0iClFJZgkdJUdkOZ1x1RFtEQzGzFV5FjLNNHEL0rrg" +
       "BbFfRvFNaMXLhmuvV05ULqB1NY5m2swf9QivNBdTZ2A7wqw+ayr1UYEdahMR" +
       "Ho+DVZy6S1vFRJn1on44STXewppx0rVjQcMrswlYMm07dgt2vcKrrWW9QPaD" +
       "QmveNNwarFdiG2OGiLjmwwgXsdAVbb/g8aRYxVDwGqy4WGkpw3EMkN9tMKrO" +
       "+kuVYzqahnCrgKzE3Jqz15jZ9A1LalRHatsd+7Eb8UiXnii0SfaWUVnHkzFu" +
       "FpclL/IKBKIwPG+MdbellMXmNFFqXbcljOrmym6VdaNFTPCALNFDq1ZFFEqR" +
       "Udlbo2haKPgbf25PK12kMg6EIk6Uu7jDR+3FzHJWlVmsd/qjCk77izVTieep" +
       "Mo0JAa5RMNNNSCqcgTeyt2avam9/dW/Lt+QbAwenOuAlOXtAv4q3xOTaA+7s" +
       "bUick/a2r5ODndL8c2H/eGD/98hO6ZHdpFP7OxS7r7xRfnSDPHubvuulDoDy" +
       "N+mPPv70s2r/Y6Wdvc27cQTdEHn+j9larNkn9rMefuldg25+/nW4qfT5x//1" +
       "juHb5u98Fdvm95zQ86TIj3ef+yL9JuWXdqDTB1tMV53MHWe6fHxj6XygRavA" +
       "HR7bXrrrICB5UO4D34f3AvLwtbeurxnoU3mgt/l0Ym90Z5sJ+TV/JI/ECDoT" +
       "zr0guuYT3fakKJcXn5B36nhK3J6lxBpRdlXP2SX6XTJRND/zdc787qxZRtBF" +
       "JdCkSKMyqXmG7LO/+fvMqMNpELzSZsnRPdH8hnvcx/eDL7LnY+SH4+PTh9N7" +
       "nU/dffMefDnzmoJA5r1c5s9f28/Z5Xtygqey5gmAFltfbrcIc+dkDx4/9NCT" +
       "P6iH7gLfR/Y89MgPx0Nnc4Kz3xeQAL8I0cbOjhWyvyFobnQAh79wrWQ9be79" +
       "pwAIvvRygjOpAJtyQx7P1fy1lzlI+I2seSbKzvYdfxVp13L1B1+Nq5MIet21" +
       "zhGzg5Dbr/o3w/YEXvnUsxfOveHZ0d/kR2kHp+Q3sNA5fWXbR/etj/TP+oGm" +
       "m7kVN2x3sf385xMRdN8rTrhob3841//jW8ZPRtAbX4Yxgs5uO0d5PgPMvRYP" +
       "CBhoj1L+DgCIk5RAi/z3KN3vRdD5Qzow6LZzlOQPgXRAknX/yN9Pild7vrs9" +
       "gtkkp46sQHszJY/6ra8U9QOWo8d+2aqV/7Vlf4VZbf/cckX59LOd3rteQD+2" +
       "PXZUwDtImkk5x0LXb09AD1ap+15S2r6ss62HXrz5Mzc8uL+i3rxV+HDWHtHt" +
       "nmuf65GOH+UncekfvOF3H/nNZ7+Wnwb8H7v4pf9zJAAA");
}
