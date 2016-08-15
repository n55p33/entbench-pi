package org.apache.batik.css.parser;
public class DefaultAttributeCondition extends org.apache.batik.css.parser.AbstractAttributeCondition {
    protected java.lang.String localName;
    protected java.lang.String namespaceURI;
    protected boolean specified;
    public DefaultAttributeCondition(java.lang.String localName, java.lang.String namespaceURI,
                                     boolean specified,
                                     java.lang.String value) { super(
                                                                 value);
                                                               this.
                                                                 localName =
                                                                 localName;
                                                               this.
                                                                 namespaceURI =
                                                                 namespaceURI;
                                                               this.
                                                                 specified =
                                                                 specified;
    }
    public short getConditionType() { return SAC_ATTRIBUTE_CONDITION;
    }
    public java.lang.String getNamespaceURI() { return namespaceURI;
    }
    public java.lang.String getLocalName() { return localName; }
    public boolean getSpecified() { return specified; }
    public java.lang.String toString() { if (value == null) { return "[" +
                                                              localName +
                                                              "]";
                                         }
                                         return "[" + localName +
                                         "=\"" +
                                         value +
                                         "\"]"; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1ZfWwUxxUfn41tjI0/+DZgwBgQH7kLaaBNTSDG2Mbk/CEM" +
                                                              "RDWBY29vzrd4b3ezO2efnZIPqghaqYhQvloF/qiISCkJadUoqZogqigfKLRV" +
                                                              "gDZNq5CqrRraFDWoalqVtul7M3u3H+c7ZKn0pJ3bm3nvzXtv3rzfm7mzN8gE" +
                                                              "yyQNVGNBNmJQK9imsV7JtGisVZUsawv0ReRjxdJfd17vvi9ASvvJ5IRkdcmS" +
                                                              "RdsVqsasfjJX0SwmaTK1uimNIUevSS1qDklM0bV+Mk2xOpOGqsgK69JjFAm2" +
                                                              "SWaY1EqMmUo0xWinLYCRuWHQJMQ1CbX4h5vDpFLWjRGHfKaLvNU1gpRJZy6L" +
                                                              "kZrwbmlICqWYoobCisWa0yZZbujqyICqsyBNs+BudZXtgk3hVTkuaHyx+tNb" +
                                                              "BxM13AVTJE3TGTfP2kwtXR2isTCpdnrbVJq0HiGPkeIwmeQiZqQpnJk0BJOG" +
                                                              "YNKMtQ4VaF9FtVSyVefmsIykUkNGhRhZ4BViSKaUtMX0cp1BQjmzbefMYO38" +
                                                              "rLXCyhwTjywPHT62s+b7xaS6n1QrWh+qI4MSDCbpB4fSZJSaVkssRmP9pFaD" +
                                                              "xe6jpiKpyqi90nWWMqBJLAXLn3ELdqYMavI5HV/BOoJtZkpmupk1L84Dyv41" +
                                                              "Ia5KA2DrdMdWYWE79oOBFQooZsYliDubpWRQ0WKMzPNzZG1sehAIgLUsSVlC" +
                                                              "z05VoknQQepEiKiSNhDqg9DTBoB0gg4BaDJSn1co+tqQ5EFpgEYwIn10vWII" +
                                                              "qCZyRyALI9P8ZFwSrFK9b5Vc63Oje82BR7WNWoAUgc4xKquo/yRgavAxbaZx" +
                                                              "alLYB4Kxcln4qDT9tf0BQoB4mo9Y0Lz85ZsPrGi48LagmT0GTU90N5VZRD4V" +
                                                              "nfzunNal9xWjGuWGbim4+B7L+S7rtUea0wZkmOlZiTgYzAxe2Pzml544Qz8O" +
                                                              "kIpOUirraioJcVQr60lDUanZQTVqSozGOslEqsVa+XgnKYP3sKJR0dsTj1uU" +
                                                              "dZISlXeV6vw3uCgOItBFFfCuaHE9825ILMHf0wYhpAweUgnPXCI+/JuRRCih" +
                                                              "J2lIkiVN0fRQr6mj/VYIMk4UfJsIRSHqB0OWnjIhBEO6ORCSIA4S1B6QLQt3" +
                                                              "JiTC0AYal1IqyyY02FMxbn4QI874P86VRrunDBcVwZLM8ScEFfbSRl2NUTMi" +
                                                              "H06tb7v5QuQdEWy4QWyPMbIKpg+K6YN8+iBMHxTTB/NOT4qK+KxTUQ0RBLCE" +
                                                              "g5AMIBtXLu3bsWnX/sZiiD5juAT8j6SNHlRqdTJGJs1H5HN1VaMLrq18PUBK" +
                                                              "wqROkllKUhFkWswBSF/yoL3DK6OAVw5szHfBBuKdqcs0BlkrH3zYUsr1IWpi" +
                                                              "PyNTXRIyoIbbN5QfUsbUn1w4PvzktsfvDpCAFylwygmQ5JC9F/N7No83+TPE" +
                                                              "WHKr913/9NzRPbqTKzzQk0HMHE60odEfF373RORl86WXIq/taeJunwi5nEmw" +
                                                              "9yBNNvjn8KSi5kxaR1vKweC4biYlFYcyPq5gCVMfdnp4wNby96kQFpNwbzbB" +
                                                              "s9LerPwbR6cb2M4QAY5x5rOCw8b9fcaJX/70j5/j7s4gTLWrNOijrNmV1VBY" +
                                                              "Hc9ftU7YbjEpBboPjvd+48iNfdt5zALFwrEmbMK2FbIZLCG4+am3H3n/w2un" +
                                                              "rgacOGcA66koVEfprJHYTyoKGAmzLXb0gayoQrbAqGnaqkF8KnFFiqoUN9a/" +
                                                              "qhetfOnPB2pEHKjQkwmjFbcX4PTPWk+eeGfn3xu4mCIZUdnxmUMmUv0UR3KL" +
                                                              "aUojqEf6yctzv/mWdAJAAxK1pYxSnntLuA9KuOUzoUjjnAjAQQHA2L/amwlw" +
                                                              "t/WlohbsWiUJizRkg9w9vbvk/U29vxcANmsMBkE37bnQ17e9t/sSD4FyzAvY" +
                                                              "jxNVuXY95A9X/NWIpfkMPkXw/AcfXBLsEGBR12oj1vwsZBlGGjRfWqDG9BoQ" +
                                                              "2lP34eAz158XBvgh3UdM9x/+2mfBA4fFuoq6Z2FO6eHmEbWPMAebZtRuQaFZ" +
                                                              "OEf7R+f2/Oi5PfuEVnVeFG+DIvX5X/z7UvD4by6OARRlUV1XqSSS2b0Y7NnU" +
                                                              "PtW7PsKoDV+tfvVgXXE7ZJVOUp7SlEdStDPmlgqlm5WKuhbMqal4h9s8XBxG" +
                                                              "ipbBOvAw4u0qrsvdWY0I14jwsU3YLLLcGda7Zq4SPSIfvPpJ1bZPzt/kdntr" +
                                                              "fHdC6ZIM4fRabBaj02f4EXCjZCWA7t4L3Q/XqBdugcR+kCgD0ls9JqBx2pN+" +
                                                              "bOoJZb/68evTd71bTALtpELVpVi7xDM5mQgplFoJAPK0se4BkUGGy6Gp4aaS" +
                                                              "HONzOnAXzxs7P7QlDcZ39OgrM36w5vTJazyVGULGbM5fjLWFB7r5SdFBjzNX" +
                                                              "Pv/z008fHRYxVWCH+Phm/rNHje797T9yXM7BcoxN4+PvD519pr517cec30Et" +
                                                              "5G5K59ZDgPwO7z1nkn8LNJa+ESBl/aRGtk9m2yQ1hVjQD6cRK3Ncg9ObZ9x7" +
                                                              "shBldHMWlef4d61rWj9eujdCCfMEvQORk3EJ58HTaKNHox8iiwh/eZizLOHt" +
                                                              "MmzuyiDSRMPUGWhJYz5QqiogFthUXZbUblvH1QKJsX0Qmx1CVnfekNzmNQHl" +
                                                              "L7HnWpLHBFEkLMEmkqtpPm5GKtGRFpSwdOvmzrGUjY9T2fnwrLCnW5FHWbWg" +
                                                              "svm4wa2WQWWAZBrDji/6NE0W0DTtzLg8OyP/lBLfecddXThbmWC+mpvvSMoB" +
                                                              "4tTewydjPc+uDNhZdD0ozHTjLpUOUdUlCq+Z5nqyQhc/hDtb7IPJh373w6aB" +
                                                              "9eOp5bGv4TbVOv6eB/t7Wf5E41flrb1/qt+yNrFrHGX5PJ+X/CK/03X2Ysdi" +
                                                              "+VCA3ziIvZ9zU+Flavbu+AqTspSpecFuYXZda3G9FsCzzl7Xdf44dCLHFxLZ" +
                                                              "gjMfawHU/EqBsaeweQzqugHKsgfBbG3/BbsMwa/7Xe8tDIIloZvMXzfgz460" +
                                                              "E/qP326TFgY57Nhi8P7RrCvqMl7ssF3RMX4v5mMt4KkjBcaOYXMQygrwYrc/" +
                                                              "bzneePpOeaMBnh7bpJ7xeyMfawGLv11g7BQ2JyCFgzfCHrxxXHHyDrhiCo4h" +
                                                              "rD5k2/PQ+F2Rj7WAuecKjH0PmzPCFX0ejHBc8d07FRX18Oy07dk5flfkYy1g" +
                                                              "7qsFxs5j8zIj5Ux3nxyzbnjlf+GGNCOz8t5vYc08M+eKXVwLyy+crC6fcXLr" +
                                                              "exzasle3lQBS8ZSquqs613upYdK4ws2rFDWeOMm8ycjsAldweKHAX7gZbwie" +
                                                              "i4xMHYuHkWJo3ZSXIF37KSEh82833c8YqXDoYFLx4ia5DNKBBF+vGJkz/upC" +
                                                              "t4ctcEw3Aflz3Zsu8pYl2ZWddruVdVUyCz0VAP/bJIPWKfHHSUQ+d3JT96M3" +
                                                              "Vz8rrohkVRodRSmT4OgpbquyiL8gr7SMrNKNS29NfnHiokxtVCsUdnbHbFcI" +
                                                              "bwGEMzCK6n33J1ZT9hrl/VNrzv9kf+llOMFsJ0USI1O25x4t0kYKSq3t4dwj" +
                                                              "NlRH/GKneem3RtauiP/l1/zwRsSRfE5++oh89fSOK4dmnmoIkEmdZAKUfTTN" +
                                                              "zzwbRrTNVB4y+0mVYrWlQUWQokiq5/w+GQNewl3J/WK7syrbixeMjDTmXl/k" +
                                                              "XsvCQXeYmuv1lMYTXRVUZ06P5/8cexNVpAzDx+D0uK542rFpTuNqQNRGwl2G" +
                                                              "kbndKWsweALoGLsewfYP/BWbj/4LKEpbIlIdAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
