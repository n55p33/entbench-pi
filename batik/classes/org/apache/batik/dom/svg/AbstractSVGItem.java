package org.apache.batik.dom.svg;
public abstract class AbstractSVGItem implements org.apache.batik.dom.svg.SVGItem {
    protected org.apache.batik.dom.svg.AbstractSVGList parent;
    protected java.lang.String itemStringValue;
    protected abstract java.lang.String getStringValue();
    protected AbstractSVGItem() { super(); }
    public void setParent(org.apache.batik.dom.svg.AbstractSVGList list) {
        parent =
          list;
    }
    public org.apache.batik.dom.svg.AbstractSVGList getParent() { return parent;
    }
    protected void resetAttribute() { if (parent != null) { itemStringValue =
                                                              null;
                                                            parent.itemChanged(
                                                                     ); }
    }
    public java.lang.String getValueAsString() { if (itemStringValue == null) {
                                                     itemStringValue =
                                                       getStringValue(
                                                         );
                                                 }
                                                 return itemStringValue; }
    public static final java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVZfXBUVxW/u/kO+QZCBBJCCFQ+ugtapJ0gNqQJBDchJRTH" +
                                                              "ICxv397dfeTte4/37iabIEqZ6YD+wVCkFJ02/iEMirQwHTtalU4cxtJO1Zm2" +
                                                              "+IG11NE/RCtjGcfqiFrPufftvrdvs4vMSGbezc2955x7z7m/83Fvzt8kZZZJ" +
                                                              "2qjGAmzCoFagV2NDkmnRaI8qWdZ2GAvLT5dIf919Y/AhPykfIXUJyRqQJYv2" +
                                                              "KVSNWiOkVdEsJmkytQYpjSLHkEktao5JTNG1ETJXsfqThqrIChvQoxQJdkhm" +
                                                              "iDRKjJlKJMVovy2AkdYQ7CTIdxLs9k53hUiNrBsTDnmLi7zHNYOUSWcti5GG" +
                                                              "0F5pTAqmmKIGQ4rFutImWWno6kRc1VmApllgr7rWNsGW0No8E3RcrP/g9rFE" +
                                                              "AzfBbEnTdMbVs7ZRS1fHaDRE6p3RXpUmrX3kC6QkRGa5iBnpDGUWDcKiQVg0" +
                                                              "o61DBbuvpVoq2aNzdVhGUrkh44YYWZwrxJBMKWmLGeJ7BgmVzNadM4O27Vlt" +
                                                              "hZZ5Kj61Mnji6d0NL5SQ+hFSr2jDuB0ZNsFgkREwKE1GqGl1R6M0OkIaNTjs" +
                                                              "YWoqkqpM2ifdZClxTWIpOP6MWXAwZVCTr+nYCs4RdDNTMtPNrHoxDij7r7KY" +
                                                              "KsVB12ZHV6FhH46DgtUKbMyMSYA7m6V0VNGijCzycmR17Pw0EABrRZKyhJ5d" +
                                                              "qlSTYIA0CYiokhYPDgP0tDiQlukAQJOR+QWFoq0NSR6V4jSMiPTQDYkpoKri" +
                                                              "hkAWRuZ6ybgkOKX5nlNync/NwfVH92ubNT/xwZ6jVFZx/7OAqc3DtI3GqEnB" +
                                                              "DwRjzYrQSan50hE/IUA810MsaL77+VsPr2qbflXQLJiBZmtkL5VZWD4dqXtj" +
                                                              "Yc/yh0pwG5WGbil4+Dmacy8bsme60gZEmOasRJwMZCant73y2YPn6Ht+Ut1P" +
                                                              "ymVdTSUBR42ynjQUlZqbqEZNidFoP6miWrSHz/eTCuiHFI2K0a2xmEVZPylV" +
                                                              "+VC5zv8GE8VABJqoGvqKFtMzfUNiCd5PG4SQBvjIg/AtIOKH/2ZkZzChJ2lQ" +
                                                              "kiVN0fTgkKmj/lYQIk4EbJsIRgD1o0FLT5kAwaBuxoMS4CBB7YmongxaY/Fg" +
                                                              "dwSALslseMemfkaTAQSZcW/Fp1G72eM+Hxh+odftVfCYzboapWZYPpHa2Hvr" +
                                                              "+fDrAlLoBrZdGPkorBgQKwb4igFYMQArBjwrEp+PLzQHVxanC2czCl4OYbZm" +
                                                              "+fCuLXuOdJQArIzxUjAsknbkpJseJxRk4ndYvtBUO7n4+prLflIaIk2wWkpS" +
                                                              "MXt0m3GIS/Ko7bo1EUhETj5od+UDTGSmLtMohKNCecGWUqmPURPHGZnjkpDJ" +
                                                              "VuiXwcK5Ysb9k+lT44/v+OJqP/HnpgBcsgyiF7IPYeDOBuhOr+vPJLf+8I0P" +
                                                              "Lpw8oDtBICenZFJhHifq0OGFgtc8YXlFu/Ri+NKBTm72KgjSTAKngvjX5l0j" +
                                                              "J8Z0ZeI16lIJCsd0MympOJWxcTVLmPq4M8Ix2sj7cwAWdeh0rfCttr2Q/8bZ" +
                                                              "ZgPbeQLTiDOPFjwffHLYePZXP/vjx7m5M6mj3pXzhynrcoUrFNbEA1OjA9vt" +
                                                              "JqVA986poa88dfPwTo5ZoFgy04Kd2PZAmIIjBDM/8eq+a+9eP33V7+CckSrD" +
                                                              "1Bk4NY2ms3riFKktoicsuMzZEkQ8FSQgcDof0wCiSkyRIipF3/pX/dI1L/75" +
                                                              "aIOAggojGSSturMAZ/wjG8nB13f/vY2L8cmYcR2zOWQijM92JHebpjSB+0g/" +
                                                              "/mbrV69Iz0JCgCBsKZOUx1XCzUD4ua3l+q/m7QOeuXXYLLXc+M91MVdlFJaP" +
                                                              "XX2/dsf7L9/iu80trdzHPSAZXQJh2CxLg/h53vi0WbISQPfA9ODnGtTp2yBx" +
                                                              "BCTKEG2trSaEx3QOOGzqsopf/+hy8543Soi/j1SruhTtk7ifkSoAOLUSEFnT" +
                                                              "xqceFoc7XplJMGmSp3zeABp40cxH15s0GDf25PfmfWf92anrHGiGkLGA8/sx" +
                                                              "2OcEVl6gO7597q11Pz/75MlxkeKXFw5oHr6Wf25VI4d+9488k/NQNkP54eEf" +
                                                              "CZ5/Zn7Phvc4vxNTkLsznZ+gIC47vB87l/ybv6P8x35SMUIaZLsg3iGpKfTU" +
                                                              "ESgCrUyVDEVzznxuQSeql65szFzojWeuZb3RzEmM0Edq7NfOFMCWwtduO3a7" +
                                                              "N4D5CO/0c5b7sFmZHxYKcTOo/iWIt+Iy0PI/5ueQHRRmc64HsdkiMNNVEKI9" +
                                                              "+Sotsze1rIBK24qqVIgbPFaB+kGU2vzIMro1cCfAcwuIWY8Ow0V0EFP38XYF" +
                                                              "NvcL70ADpiJwC2WkUrIt5IRl/lPvLQLdYdlxNF9mm+0Fj8AujTDstBYq6Pll" +
                                                              "5PShE1PRrWfWCJ9syi2Se+EO+Nwv/v2TwKnfvjZDhVbFdON+lY5R1bU5vM23" +
                                                              "5kSBAX7XcVzqnbrjv3+pM77xbiorHGu7Q+2Efy8CJVYUDizerVw59Kf52zck" +
                                                              "9txFkbTIY06vyG8NnH9t0zL5uJ9f7ISv510Ic5m6cj282qRwg9W25/j5kixS" +
                                                              "2hAYq+BbaSNlpdcpHLDmoxC7AWx2e0qC5iISiyRPs8gc93xQvy5OmcvJcPQz" +
                                                              "ji8l7xQPiqcsHOg2+Hgiq9EsnAvCt87WaN1d2MiH3V0e81QXEeYxgc+RMsjX" +
                                                              "OVjERoewmQRfghvjkIivRVPjkKkkoYAcs2/WwQNN744+c+M54b7ePOghpkdO" +
                                                              "fPnDwNETwpXFW8WSvOcCN494r+AbbRD2+BB+fPD9Bz/UAgfwN2S7HvvS3J69" +
                                                              "NWOBYJLFxbbFl+j7w4UDP/jmgcN+2yqwsdIxXYk6KNl/D1DCQ2wnfBvsg91Q" +
                                                              "BCXYHMjHRCHWIkd+ssjcKWyeBDjEM3DgMHLscPwe2IGn2SXw9dnK9N3BDjPk" +
                                                              "2EKsRXT9RpG5M9hMQejAh1yWfYjF0cOOMb5+D4zRhHMd8D1qa/To3YOiEGsR" +
                                                              "hS8WmXsBm29DVQKg4BG023KqElckPf//MEcaqiLPAwteC1ryHm/Fg6P8/FR9" +
                                                              "5bypx37Js3n2UbAG8nIsparuwtXVLzdMGlO4cjWijDX4r+8z0lKopmGkBFq+" +
                                                              "7ZcE9SVG5sxEDZTQuimnwXheSkbK+G833WVGqh06qNhEx03yCkgHEuxeMWao" +
                                                              "F0Wdn/a5SiLb2PyM5t7pjLIs7ns/pgH+yJ4pOlLimT0sX5jaMrj/1ifOiHcH" +
                                                              "WZUmJ1HKrBCpEE8g2cJlcUFpGVnlm5ffrrtYtTQThRvFhh28L3CBshtSnIHI" +
                                                              "mO+5kVud2Yv5tdPrX/7pkfI3IeHsJD6Jkdk7829EaSMFFePOkFMzuv5Jw58K" +
                                                              "upZ/bWLDqthf3uZ3TiKe8BYWpg/LV8/ueut4y+k2P5nVT8ogwdA0v6o9MqFt" +
                                                              "o/KYOUJqFas3DVsEKYqk9pPKlKbsS9H+aIjUIYgl9C9uF9uctdlRfLVipCM/" +
                                                              "cea/9cH9fJyaG/WUFkUxtVBkOiM5r/+2Y1SnDMPD4Ixkj3JOvu5h+ZEv1f/w" +
                                                              "WFNJHzhijjpu8RVWKpKtK93/EOADIs9jcySN5wxID4cGDCOT4ssXGgLx1wQN" +
                                                              "jjPiW2GPemqf33Bxb/MuNtf/C+CCLC3rGwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/903/PozX8svLv4XogbaV30mAAA=");
}
