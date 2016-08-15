package org.apache.batik.css.engine.value.css2;
public class FontSizeAdjustManager extends org.apache.batik.css.engine.value.AbstractValueManager {
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_FONT_SIZE_ADJUST_VALUE; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_FONT_SIZE_ADJUST_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.ValueConstants.
                 NONE_VALUE;
    }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        switch (lu.
                  getLexicalUnitType(
                    )) {
            case org.w3c.css.sac.LexicalUnit.
                   SAC_INHERIT:
                return org.apache.batik.css.engine.value.ValueConstants.
                         INHERIT_VALUE;
            case org.w3c.css.sac.LexicalUnit.
                   SAC_INTEGER:
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_NUMBER,
                  lu.
                    getIntegerValue(
                      ));
            case org.w3c.css.sac.LexicalUnit.
                   SAC_REAL:
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_NUMBER,
                  lu.
                    getFloatValue(
                      ));
            case org.w3c.css.sac.LexicalUnit.
                   SAC_IDENT:
                if (lu.
                      getStringValue(
                        ).
                      equalsIgnoreCase(
                        org.apache.batik.util.CSSConstants.
                          CSS_NONE_VALUE)) {
                    return org.apache.batik.css.engine.value.ValueConstants.
                             NONE_VALUE;
                }
                throw createInvalidIdentifierDOMException(
                        lu.
                          getStringValue(
                            ));
        }
        throw createInvalidLexicalUnitDOMException(
                lu.
                  getLexicalUnitType(
                    ));
    }
    public org.apache.batik.css.engine.value.Value createStringValue(short type,
                                                                     java.lang.String value,
                                                                     org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        if (type !=
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_IDENT) {
            throw createInvalidStringTypeDOMException(
                    type);
        }
        if (value.
              equalsIgnoreCase(
                org.apache.batik.util.CSSConstants.
                  CSS_NONE_VALUE)) {
            return org.apache.batik.css.engine.value.ValueConstants.
                     NONE_VALUE;
        }
        throw createInvalidIdentifierDOMException(
                value);
    }
    public org.apache.batik.css.engine.value.Value createFloatValue(short type,
                                                                    float floatValue)
          throws org.w3c.dom.DOMException {
        if (type ==
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_NUMBER) {
            return new org.apache.batik.css.engine.value.FloatValue(
              type,
              floatValue);
        }
        throw createInvalidFloatTypeDOMException(
                type);
    }
    public FontSizeAdjustManager() { super(
                                       );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "weZ7nExXLAanSoE7dp33wH9yqsBfCo/tIGhPHvx8rAE4ioQiRRNluBI4all5" +
       "chy238Tmgnh9KTfg+PNHguAX2FzipFaCKtNALmh/MlXQYsrc7+Czf/LQ5mPN" +
       "Hdf482cT4puAw20efIVGb0+E6jvYvA4JVqLajvJygfqb/wWoaU7qc95T4qF6" +
       "7rj/T+Sdv3L2RHXZnBPbXhUnycy9fCWcDBIpTfPtaP2721LTYglVmFgpLyJM" +
       "8fUeJyv+sxtVTorxS9jyZ8n8F06WTMgMXhnOJFqH8W9OfsrDyEmpfPHz/AM2" +
       "nbl4YN8ArZ/yGrgvSAlaiG8/3YecVHh0MKl88ZGEQiAdSPA1bLrJ7taJAWuG" +
       "s5sFh3wROo5T0zJbZl18iFiqnyiWfPcay7IOc+KfOPe0k5L/xfUr505s6rr3" +
       "6q2PyVtIRaNjYyhlOpxx5F2nEIrH+iV5pbmySjeuvDbjfPly9/CVdQvq101E" +
       "NCwlcWM4L3AtZzdmbudeO7n+wk8Plr4Cx8btJARrduZ23/9g8k+fprSZssjC" +
       "7bHxZ7leaon7wqaVXxu9Y3XivdfFnRKRZ78F+en7lcundvz8yNyTDWEyvYOU" +
       "wLmSpftIhWpvGNW3MGXY6iNVqt2WBhVBikq1rIPiDFxmFDOswMWBsyrTi9fT" +
       "nCwdf/wdf6lfoRkjzGoxUnocxcBRc7rXIz0TuBlJmWaAwetxXIktk7kQvQFR" +
       "2x/rNE33brf4NlOknETe0hOqF6/4NvvftQ5MEqUfAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16e6wj13nf7F1p9bCsXUl+qIotS/LKjsz4DjlDckisk3rI" +
       "meEMOSSHHHJITtPI835w3g/ODBO1loPWboM6RiunDpronzpoajixUSRtgMKB" +
       "2iKNjQRtU7iPFKgdtAXqNnVjF0ga1G3SM8N79z60u6ohofdiDmfO+b5zvt93" +
       "vvOd7zy++G3o/jiCaoHvFIbjJ8danhzbTus4KQItPh6yLU6KYk3tO1IcL0De" +
       "i8pzX77+R9/7jHnjCLomQk9InucnUmL5XjzXYt/ZaSoLXT/LJR3NjRPoBmtL" +
       "OwlOE8uBWStObrHQ286xJtBN9lQEGIgAAxHgSgQYP6MCTG/XvNTtlxySl8Qh" +
       "9BegKyx0LVBK8RLo2YuVBFIkuSfVcBUCUMOD5bcAQFXMeQQ9cxv7AfPrAH+2" +
       "Br/yN3/sxt+7Cl0XoeuWx5fiKECIBDQiQo+4mitrUYyrqqaK0GOepqm8FlmS" +
       "Y+0ruUXo8dgyPClJI+22ksrMNNCiqs0zzT2ilNiiVEn86DY83dIc9fTrft2R" +
       "DID1XWdYDwipMh8AfNgCgkW6pGinLPdtLU9NoPdd5riN8eYIEADWB1wtMf3b" +
       "Td3nSSADevzQd47kGTCfRJZnANL7/RS0kkBP3bXSUteBpGwlQ3sxgZ68TMcd" +
       "igDVQ5UiSpYEeudlsqom0EtPXeqlc/3z7clHPv3jHu0dVTKrmuKU8j8ImJ6+" +
       "xDTXdC3SPEU7MD7yIfZnpHd95VNHEASI33mJ+EDzD37iux/9oadf++qB5gfu" +
       "QDOVbU1JXlQ+Lz/6O+/pv9C9WorxYODHVtn5F5BX5s+dlNzKAzDy3nW7xrLw" +
       "+LTwtfk/3Xz8C9rvH0EPM9A1xXdSF9jRY4rvBpajRQPN0yIp0VQGekjz1H5V" +
       "zkAPgHfW8rRD7lTXYy1hoPucKuuaX30DFemgilJFD4B3y9P90/dASszqPQ8g" +
       "CHoAPNAj4PlB6PBX/SaQD5u+q8GSInmW58Nc5Jf4Y1jzEhno1oRlYPVbOPbT" +
       "CJgg7EcGLAE7MLWTAiUuaQ0gE7yTnFQrMxCYAqrirb2Gq3YaJ2PJA7YRHZeG" +
       "F/z/bzIvtXAju3IFdNB7LrsHB4ws2ndULXpReSXtkd/95Rd/6+j2cDnRXwJ9" +
       "BEhxfJDiuJLiGDR6fJDiuJKizECO7ygFdOVK1fg7SmkOlgH6dQs8BPCdj7zA" +
       "//nhxz713FVgkkF2H+iUkhS+uwvvn/kUpvKcCjBs6LXPZS8Lf7F+BB1d9MUl" +
       "ApD1cMnOlR70tqe8eXkM3qne65/81h996Wde8s9G4wXnfuIkXs9ZDvLnLus6" +
       "8hVNBW7zrPoPPSP96otfeenmEXQf8BzAWyYSUChwRE9fbuPCYL916jhLLPcD" +
       "wLofuZJTFp16u4cTM/Kzs5zKCB6t3h8DOv4odJJcGA5l6RNBmb7jYDRlp11C" +
       "UTnmH+aDn/+3/+y/oJW6T3349XOzIq8lt875jbKy65WHeOzMBhaRpgG6f/85" +
       "7m989tuf/HOVAQCK99+pwZtl2gf+AnQhUPNf+mr4u9/8xue/fnRmNAmYOFPZ" +
       "sZT8APJPwd8V8PxJ+ZTgyozDmH+8f+J4nrnteYKy5Q+cyQZ8kAMGZWlBN5ee" +
       "66uWbkmyo5UW+7+vP9/41f/26RsHm3BAzqlJ/dAbV3CW/2d60Md/68f+59NV" +
       "NVeUcg48098Z2cGxPnFWMx5FUlHKkb/8L9/7s78p/Txw0cAtxmDUVZ4OqvQB" +
       "VR1Yr3RRq1L4UhlSJu+Lzw+Ei2PtXKzyovKZr3/n7cJ3fv27lbQXg53z/T6W" +
       "glsHUyuTZ3JQ/bsvj3paik1A13xt8qM3nNe+B2oUQY0K8HXxNAKOKL9gJSfU" +
       "9z/w7/7RP3nXx37nKnREQQ87vqRSUjXgoIeApWuxCXxYHvzZjx6sOXsQJDcq" +
       "qNDrwB8M5Mnq6yoQ8IW7+xqqjFXOhuuT/2vqyJ/4D3/8OiVUXuYOU/QlfhH+" +
       "4s891f+R36/4z4Z7yf10/nrnDOK6M17kC+4fHj137TeOoAdE6IZyEjQKpesF" +
       "g0gEgVJ8GkmCwPJC+cWg5zDD37rtzt5z2dWca/ayozmbFMB7SV2+P3zW4S/k" +
       "V8BAvB85xo7r5fdHK8Znq/RmmXzwoPXy9QfBiI2r4BNw6JYnOVU9LyTAYhzl" +
       "5ukYFUAwClR803awqpp3gvC7so4SzPEhgjv4qjJFD1JU7+27WsOtU1lB7z96" +
       "Vhnrg2Dwp/7TZ377p9//TdBFQ+j+amYDPXOuxUlaxsd/+Yuffe/bXvm9n6oc" +
       "EPA+wsef/4Mq2hjdC3GZEGVCnkJ9qoTKVzM9K4EJs/ITmlqhvadlcpHlAte6" +
       "Own+4Jce/+b25771S4fA7rIZXiLWPvXKX/3T40+/cnQunH7/6yLa8zyHkLoS" +
       "+u0nGo6gZ+/VSsVB/ecvvfQPf/GlTx6kevxicEiCtc8v/ev/89vHn/u9r90h" +
       "4rjP8d9ExyaPfoduxgx++sc2RGKVLfN8pU3hrjHId7DB0NkGbo5Hs0VKbkf8" +
       "PBQDeTCm69gkHy+spC/aORoU3ZjVMGyMiWJb2zICw8rzFTkiHUaQjJBckhEe" +
       "mqHriAE5cLdDex6EIV+XxMidI6FTH3bqvrBe8NF8iLZ24k5tyGgLjcK0NZxi" +
       "CtrptuUuhqGtCBHTBbfbmqzMGI1xKydrks1g9VDey24kspN2uFR3Wt9Du4U1" +
       "obqjDhahC5UG6zJ9tRiQ7BKjVuFeDYRAkVOOpeYNtzFRN2vwj9LbNitt9lJu" +
       "Fo5AYAXXCBNkPiEEYbl2PXKlMnUyTQYj1/GoXThjwj2xVfBhltg+6Syl3jAh" +
       "jCaaLy1nE1g2vXMUGnUjOZsF225LmVhKI1YbdZcUF+vJyhqra3excll0gEtI" +
       "ahniDmd4mGPktL7qNYeTWNgNZjJR17kl3ciaXGNmMKIzVCeYke27WF8mx7K4" +
       "IzehLraRPb9KOI2v1c25Te5Rcs3xA3rs2cpouxTtZaJKNp4ikTtsjcA00Ken" +
       "rdHIXgoCYy2GqtNfDKJ50J+6q5oxJuOwucESo+fGa7FdCILf3HckUva3io4I" +
       "3t7jhzy61EJBrtMNgcL7s/aiiw8MlvBwlo1btKvnnDOKDGyCuSOBX8wbe45q" +
       "eGFz3G7xTrbLYlYNxbHob1uctMdtpC87wqi5Wa3HfNPCFa8tDIlZu8/K065b" +
       "CFQk2lxubvzN0BL8YR8ltnG+Tpacgg19q0fnsTxYZGQvJlvs2G5txdEmbFhO" +
       "fUv4ImNGQq897pJ01GaG/dWg18cpS993jICKSCTERgMi6nXs8ZZYsxsND50M" +
       "N/hCaeD60OwvsnpU4A66r2myGsEShXU3jbbLzPHW3lxMJnN4auON3tBCYpzf" +
       "D0YZUQhWa7TbZJ6O1rMFbs6oTGeGm/oCxdJ2gESDolljEc9ttQmRY/vySM71" +
       "6WKbNWtLKuKTHVtnGsV2TwgJ3VqJEiuocmITvLNQjCzej3llQViEgymdlOPQ" +
       "XTfpxkoWaoYRbEIzEJnZHFuNtou5YAsOOhYbosNOmr3CAXNnLti0NpN0XFui" +
       "S1fbKx5pyzYtzTdkA3HMnTEh+wLeI4dLXKuFnk0oaosrGH2gTYytWa/hpqOX" +
       "irK42lQmLbwp8nPJ6SeCgG5MZJXJklxXzGaW4cmWm+Mbu80JtMxT25nh0MTA" +
       "z3mLGZstI/MnCTM1tth8I4XOAEQttrwhBAINB4N0itUxcTfkQrKXrHo4x8Fc" +
       "l3OXm6Xot8lZ2jd6Cl33x/QIcU1fWcmNUV1dsKvGeg9LMEOOOaeZEnShR7NN" +
       "yjT6jJUwNh70BsF8OfeNeSNi9m6DGQ1mLp2tJGts43DR7u0ZMpjaI2cBPFpa" +
       "b6fsjJkljDKaSR4z9fiIYgXgVeYTWEdHNT0MY2m1o71FjFA83Z80hCkZhC7t" +
       "SPJmwEhKoLVyZ73f4nOliIabpJvMeNYfLH0Wbwcs1Z0oEr8cKNw481pTcbfd" +
       "psPltIHO6noLHYaLWksb5Fu9BntyViwUWm5lfYdluLEJ+syFl3kB8l1byIsw" +
       "6yo1jVAyOB6zTWrb4KcocIX2vJeuevHY7pM1OHb9XJdYuL1GJvhOLHiur8yM" +
       "HMfcjNkHA8FrRcqaqSEOQ/f6ymS0NBB6zWRRbdhzbNroMm4riiV3zWwyk6J6" +
       "M4dxuO7QpnV4zWNIZwWQCYEaopRmmruxu86F3gaszNeJ0CLlaLnBMR+1PQHu" +
       "ShRKINm6OTOWBTqcIIyZjJDZroM3jRqz9oBvRxpB7LFNrUtOxVnujIm4l4z6" +
       "jcTVZ7xOEpne9Kdib59se2EQqSprNLeZNqFplxJb6bZHNvgeuaEZVFZxk5hI" +
       "NI9vULO2c7yuPpK9nb3w51EgG402OjBFTibxCK61KY+F+/sdjFoEafb4uOi1" +
       "anTgjDv7cbdQkNV8qc5teFET8k2tZmZdwlgS22g2mYKfNc9mzHjUSzIjls1F" +
       "ksbERlbBAg+u516EjHUi9fR0nbXKBWlSgxVK8F0MbXR2aXfbCiZjP9xSSL+Y" +
       "Nr2FOFn26GEj2dixRyyicZ+XQludabhLR6wnq8v2RN3h8qIbD+r9cO5p2JhK" +
       "F1OVWvpTVXHrYADssWmusrk2V4g0qOOZJLdVKxOpwqLnLlGnpYWY6juKC8cC" +
       "M1hsUNxo5oREZbTmUnN5V0OGy3rKESwCLzx9vYbDfBhbLFkPNlhLb+LRPIrn" +
       "bjLLZZ1CFnsfd7hwSWXjcCWJA6qmbxqbbRfp+AN7WBvJNJYMMRsL450ykmVc" +
       "0HfFGkb9XEn3Cb/fjoD60D2xlAaIJMmdVuERo2jp8SNWrK0jtb1RNB7lEEOR" +
       "h854q/RrpuGNcK6l9UgpLgK4brT9TreD6y0X6W4Qez3k2K5vANsWab1t5/u2" +
       "1BSKYJAhE3gkEN103dpPGtMZTVlSYzDYb9XFbKG1I1Jy3FV/0xfbE0PojPIc" +
       "d3sThV0zeb+w+mKKEKOUsTZ+P8JX/GxV68VK1+ggzlSMh61lXutvM2/LF+ai" +
       "uevPd2sK52Bt23Mzv+P6PLmrZXGD0hCswU5VewMvYtFMdGcz7NW7kmYTsFRL" +
       "dwnVlPHCHuLjBYv5BmkXjhRLcn/UpKjNakqLbjvnVAHWV17Y1TVhH5LdvdNr" +
       "2mImTXTYMov2yFSYHeMng70iKQuOaXYJXENW1DCgFJaHFQTTl20dpWcGltJq" +
       "NnZRfEzMB91Nrs8Cr4uEeUyNVukAay1hhSPU5TqJOaPNU85IgDV3RSqdadb3" +
       "EGnbo9t7ra1s2XldjaKhpZiU1Aq1vY0MijlW28FFUYxoHnHbU3hM7KKoKXje" +
       "fNpuFzO1yyWbviEjaDa0fXO87PLYSlYXwnA6F3eTWpBjvSa3TefLmcwoniXT" +
       "USgPZ60RYCPEbr7cpHlNXqpGLVyba2bFoETRs5dZj5lsmo1swlmrybLQlkQR" +
       "zzdZzYqp3MTIlp9m+DzYouTSilteqjQ2NT1Fs50wmVrOwsNiF/V3lJdF+pjY" +
       "Zj2TXjYTg9cIQ6Pt2CFcptbAyT3db+ZdvJXYyLyHzKQmn9PjVjgnMTbK2lZs" +
       "RUxWM+dtBfcFMC1lOZcgE7dbm82LWJVwZrnvKfJ0401GTMT3hitz1MQazZqn" +
       "zFMPs7RsxK2NHqqFIb7KCA7dYA213tFSuojxNdGfATuW4G4noeGtuF1tZGHs" +
       "kO4kECRamjiow8ZoMTOtRnfH162FZjadaQ9Ri367bkntTnM1aY3mhBhjSJcZ" +
       "jVGKG4mWnmki5pH5msUlj/dJTA1QNKO7RRj39L4PJ8zA5Ohd3olwsmn5M2s+" +
       "nzhpj2lKjtNSzAJBOwvX8MzuaKEbNW5CGym+Rqi9FVBSf5RMcNY14bGznm3i" +
       "SMFq/b0Os7OWCwhVvdlBlEUzSPEMqWs6Iwzkeo1s27vNDm8OhZCV7N2wMPRQ" +
       "hrOVLy2xUOm2Fs2QamNR6Yl5dYeyyJxei16Pk9fm0iuUoqv3VwrRY4KFziUS" +
       "h4DJhF1sDEdwKSNgi+G4oy+1YbGrxXkiLPwo57t2IXa8DlVvrxZjY7w2vemQ" +
       "CunOqjvV44goSDfQOXoP42PEk53mZtLBIxEuBpGx43FHsgYdGN1oikCb9fHI" +
       "6XTEATmzcJXn8IbMRkMskYY4GFJxK6ZMNJtP/daivh/KotPoWJQVeoW10jlF" +
       "KjBmqtRG+pTT6tsWC+f6MmrVW3E7itB2iHCFkDBzaWJvCtOZBnneohCPZCK6" +
       "ZgmtQHYL3tbSHSHbOucUXbgvqLNd2Kg3yEk/c5TVuMmieCLuVVdOVW2KebVs" +
       "2+GcqNnPO3IyxOeRmooICtZ5nW1NDyJejGO7j8l0LmKOJvkeloWSsM7T7gZd" +
       "WztVp7z5aC5iHaqmeZijpJ6623eKSbEgVmSx20yXGevygZ4w5irYDSYrdDxY" +
       "b9rWRADrqFXPFHrWNgRBGGcRVO5SxDTOxiBUKaKF1dUXXj9TdRg8bUf351t7" +
       "D4LGpecrudKbK1i0Zvb1Rdpzhu5KwjMtydfMNtli29luRs2RHI4mJIrKkd6c" +
       "ONOtRy60ujkFVgM3J7udnsxaYzJc6mCF+8Pl0vdHv7/dh8eqjZbb52a2g5UF" +
       "g+9j1X0oerZMnr+9uVz9XbvH5vK5DTio3El4792Ow6pdhM9/4pVX1ekvNI5O" +
       "Ni5XCfRQ4gcfdrSd5pyr6iFQ04fuvmMyrk4DzzbUfvMT//WpxY+YH/s+jgze" +
       "d0nOy1X+3fEXvzb4gPLXj6Crt7fXXndOeZHp1sVNtYdBSJVG3uLC1tp7b2v2" +
       "iVJjHwDPh080++E7b9vf0QquVFZw6Pt77AtH9yirdrrdBHrCihnP1CIr0VQu" +
       "8quT34phfs5ghAR6QPZ9MOK8M2Py3mgL53yTVYZ9Ef0HwdM8Qd9869G/fI+y" +
       "nyyTn0igd1gx7lmulJQb+qfwy7LdGc6X3izO58Fz6wTnrbce51+7R9lPl8mn" +
       "Euhxq7wGUG3p3QXlX3kTKK+XmU+Dp3eCsvfWo/zZe5T9rTJ5JYGuG1pyCu/2" +
       "edklO75qndzPqFB/9k2gfrzMfBY8zAlq5q1H/Yv3KPtCmfzti6gnJ/5ncAbx" +
       "828CYjUFPAMe7gQi99ZD/JV7lP39MvnSASKh6VLqHI5BTo8PPvjGZ9ln9JU2" +
       "vvxmtfEe8KxOtLF6a7RxVBEcnYL6gRJUhioVllhSjlkttxTJWXpWckrz/L2A" +
       "93merN6q1v7xpdaunJzMn9T05Glrqu8eE9MxmStaUE6eFfNXy+QrCfQ2JdKk" +
       "RKuUWWb92plGf/3NavQ58MQnGo3fGo1ePTkRvMP4vz82/aia/Krg6Dcq/q/f" +
       "WUfl59cqgt8tk38OwqyDHg5nVXfSxr94s9ooHcrLJ9p4+S21r/LzX91RJbrj" +
       "S0nF+h/fSBHfKpNvJNCNgyKokvNOevjm96OHPIHeecfrJuV5+ZOvuwZ3uLql" +
       "/PKr1x9896vLf1PduLh9veohFnpQTx3n/PHmufdrQaTpVgXlocNhZ1D9/EEC" +
       "feD/7WJMAt1X/lQg/vuB+X8k0LNvyJycnEGeZ/zDk9F+F8YEunZ4Oc/zxyBq" +
       "uRMPmNpAep7ye6CbLlMCKarf83R/kkAPn9GBRg8v50jKo+CrgKR8PQpOXUf7" +
       "jRWGy3ESScrBRE46NT/4nifPD4LKZh5/I5s5t854/4XVQXWh8jSSTw9XKl9U" +
       "vvTqcPLj323/wuFqi+JI+31Zy4Ms9MDhlk1VabkaePautZ3WdY1+4XuPfvmh" +
       "509XLo8eBD4bkOdke9+d746ABXtS3fbY/9q7f+Ujf+fVb1Qnzv8XX0Ud+ukq" +
       "AAA=");
}
