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
    public static final long jlc$SourceLastModified$jl7 = 1471109864000L;
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
                                                              "we3xHGNyVomA0QDIxmOduu7cj46o0UWeGRi8ZsD2M/GKzbX/AqacvtrUHgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
