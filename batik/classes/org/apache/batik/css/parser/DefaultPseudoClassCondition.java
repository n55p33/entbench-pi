package org.apache.batik.css.parser;
public class DefaultPseudoClassCondition extends org.apache.batik.css.parser.AbstractAttributeCondition {
    protected java.lang.String namespaceURI;
    public DefaultPseudoClassCondition(java.lang.String namespaceURI, java.lang.String value) {
        super(
          value);
        this.
          namespaceURI =
          namespaceURI;
    }
    public short getConditionType() { return SAC_PSEUDO_CLASS_CONDITION;
    }
    public java.lang.String getNamespaceURI() { return namespaceURI;
    }
    public java.lang.String getLocalName() { return null; }
    public boolean getSpecified() { return false; }
    public java.lang.String toString() { return ":" + getValue();
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL0Za2wUx3nujN9v84wBY4wh4pG7kAYiakIDxg4mZ2NhQK1J" +
                                                              "OOb25nyL93aX3Tn77NRpglJBU5USSoBWxL+ISBABVDVKqjSIKE2TKGmlJLQJ" +
                                                              "rUKqtlJpU9SgqmlV2qbfzOzt6x7UUqmlnd2b+b5vvvf3zfjMNVRqGqiFqDRE" +
                                                              "x3RihrpU2o8Nk8Q7FWya22AuKh0rwX/ZdbVvTRCVDaK6JDZ7JWySbpkocXMQ" +
                                                              "zZdVk2JVImYfIXGG0W8QkxgjmMqaOohmymZPSldkSaa9WpwwgB3YiKBGTKkh" +
                                                              "x9KU9FgEKJofAU7CnJPwev9yRwTVSJo+5oDPcYF3ulYYZMrZy6SoIbIHj+Bw" +
                                                              "mspKOCKbtCNjoOW6powNKRoNkQwN7VFWWSrYHFmVo4K28/Wf3TiUbOAqmI5V" +
                                                              "VaNcPHMrMTVlhMQjqN6Z7VJIytyLHkElEVTtAqaoPZLdNAybhmHTrLQOFHBf" +
                                                              "S9R0qlPj4tAspTJdYgxRtNBLRMcGTllk+jnPQKGCWrJzZJC21ZZWSJkj4lPL" +
                                                              "w0eO7Wr4fgmqH0T1sjrA2JGACQqbDIJCSSpGDHN9PE7ig6hRBWMPEEPGijxu" +
                                                              "WbrJlIdUTNNg/qxa2GRaJwbf09EV2BFkM9IS1QxbvAR3KOtXaULBQyDrLEdW" +
                                                              "IWE3mwcBq2RgzEhg8DsLZdqwrMYpWuDHsGVsfwAAALU8RWhSs7eapmKYQE3C" +
                                                              "RRSsDoUHwPXUIQAt1cABDYqaCxJlutaxNIyHSJR5pA+uXywBVCVXBEOhaKYf" +
                                                              "jFMCKzX7rOSyz7W+tQcfVjepQRQAnuNEUhj/1YDU4kPaShLEIBAHArFmWeQo" +
                                                              "nvXKgSBCADzTByxgXvzq9ftWtFx8U8DMzQOzJbaHSDQqnYzVvTuvc+maEsZG" +
                                                              "ha6ZMjO+R3IeZf3WSkdGhwwzy6bIFkPZxYtbf/KVR0+TT4KoqgeVSZqSToEf" +
                                                              "NUpaSpcVYtxPVGJgSuI9qJKo8U6+3oPK4Tsiq0TMbkkkTEJ70DSFT5Vp/Deo" +
                                                              "KAEkmIqq4FtWE1r2W8c0yb8zOkKoHB5UA888JP74m6I94aSWImEsYVVWtXC/" +
                                                              "oTH5zTBknBjoNhmOgdcPh00tbYALhjVjKIzBD5LEWpBMk0UmJMLwRpLAaYX2" +
                                                              "myQd17hFIariXAEh5nP6/3W3DJN9+mggAGaZ508KCsTTJk2JEyMqHUlv6Lp+" +
                                                              "Nvq2cDgWJJbWKLoHGAgJBkKcgRAwEBIMhIowgAIBvu8MxohwBTDkMKQEyMk1" +
                                                              "Swce2rz7QFsJ+KA+Og2swEDbPLWp08kb2WQflc411Y4vvLLytSCaFkFNWKJp" +
                                                              "rLBSs94YgiQmDVtxXhODquUUj1ZX8WBVz9AkEofcVaiIWFQqtBFisHmKZrgo" +
                                                              "ZEsbC+Jw4cKSl3908fjoYzu+dmcQBb31gm1ZCqmOofezLG9n83Z/nshHt37/" +
                                                              "1c/OHZ3QnIzhKUDZupmDyWRo83uGXz1RaVkrfiH6ykQ7V3slZHSKIQIhWbb4" +
                                                              "9/AkpI5scmeyVIDACc1IYYUtZXVcRZOGNurMcJdt5N8zwC2qWYQugWexFbL8" +
                                                              "zVZn6WycLVyc+ZlPCl487h3Qn/7wZ3/4Ald3ts7UuxqEAUI7XLmNEWviWazR" +
                                                              "cdttBiEA99Hx/u88dW3/Tu6zALEo34btbOyEnAYmBDV//c29lz++cvJS0PFz" +
                                                              "CsU9HYMeKWMLyeZRVREhYbclDj+QGxXIGMxr2rer4J9yQsYxhbDA+mf94pUv" +
                                                              "/Olgg/ADBWaybrTi5gSc+ds2oEff3vW3Fk4mILHa7OjMARMJf7pDeb1h4DHG" +
                                                              "R+ax9+Z/9w38NJQOSNemPE54Bg5yHQS55HOgVeOYrAyHRBlm86u5SVdxmDv5" +
                                                              "eDdTB8dEfG0NGxab7tDwRp+rw4pKhy59Wrvj0wvXuSzeFs3tCb1Y7xDOx4Yl" +
                                                              "GSA/25+6NmEzCXB3X+x7sEG5eAMoDgJFCdK0ucWARJrx+I0FXVr+y1dfm7X7" +
                                                              "3RIU7EZViobj3ZiHIKoE3ydmEnJwRv/SfcL0oxUwNHBRUY7wORNM/QvyG7Yr" +
                                                              "pVNuivGXZv9g7anJK9wHdUFjrp1z53lyLm/0nbA//f49Pz/15NFR0SosLZzr" +
                                                              "fHhz/rFFie37zd9zVM6zXJ42xoc/GD5zorlz3Scc30k3DLs9k1vKIGU7uHed" +
                                                              "Tv012Fb2ehCVD6IGyWqsd2AlzYJ4EJpJM9ttQ/PtWfc2hqIL6rDT6Tx/qnNt" +
                                                              "6090TgmFbwbNvmt9ua2OmbANnlYr7Fv9uS2A+McDHOV2Pi5jwx3ZVFKpGxoF" +
                                                              "Lkncl01qi5ClqIaxZ0JNJ9u39vCYE1mUjV9kQ0SQuzefV4ql29mw3N6U/5X5" +
                                                              "Wyt3CnPcDrHYml+o++Wd+8l9RybjW55ZKRyvydtRdsGB6flf/Oud0PFfv5Wn" +
                                                              "Yamkmn6HQkaI4tqTHX3ne1y9lx8MHL/5qO7wb3/YPrRhKp0Fm2u5Se/Afi8A" +
                                                              "IZYVjh4/K2/s+2PztnXJ3VNoEhb41Okn+VzvmbfuXyIdDvJTkHDonNOTF6nD" +
                                                              "68ZVBoHjnrrN48yLbAdoZIZdCE/IcoBQ/kKdx3fs8lcItUgpIEXWeDXZDVVm" +
                                                              "iFC7LeWdhqfVZEYeSMdMaAvlFMCMWGepu/p3Swfa+38nfPC2PAgCbuaz4W/t" +
                                                              "+GDPO9xaFcw9bB25XAPcyNXgNAjhP4e/ADz/Zg/jm02wN2SiTutg1GqfjFjy" +
                                                              "LpqFfQKEJ5o+Hj5x9XkhgD/l+oDJgSNPfB46eEQElDheL8o54bpxxBFbiMMG" +
                                                              "hXG3sNguHKP79+cmXn52Yn/QstKXKQRnUjOobcOAXZxmeJUuON34jfofHWoq" +
                                                              "6YZA7UEVaVXemyY9ca+zlpvpmMsKznnccV2LZ6ZxigLLspWRpz9cJP39F0WZ" +
                                                              "TXTqfP5B28ubsgGy2vLy1VMPkEKoRYJgX5G1x9kwAW0QBEifvyI42njkVmmj" +
                                                              "BZ51lkjrpq6NQqhFJP52kbUn2fAEFEfQRkSTsNJn+ZNLFd+8BaqYztYWwNNt" +
                                                              "ydM9dVUUQi0i7okia5NsOCZUMaATCc4HRNyhyVaks5fq+oajYHlM0xSCVX8c" +
                                                              "s5+jruA6fqvcqRmeXksRvVPXYSHUIno6W2TtPBueo6iCaq6zjaOG0/8LNWQo" +
                                                              "mlvkDoYdD+bkXAaLC0zp7GR9xezJ7R/whse+ZKyBGpZIK4q7gXV9l+kGSchc" +
                                                              "wBrRzur89RIwUuSiiB16+QcX5EWB8zJFM/LhUFQCoxvyAhRxPySUDf52w71K" +
                                                              "UZUDB5uKDzfIj4E6gLDP1/XsOXR1sTuu9VDpDegH7X9S2OrNBLxdrW3bmTez" +
                                                              "rasRXuSp5/yCP1vy0uKKPyqdm9zc9/D11c+IawxJwePjjEo1FDpxo2L3gQsL" +
                                                              "UsvSKtu09Ebd+crF2frbKBh24mOuy4k7IX515kXNvjO+2W4f9S+fXHvhpwfK" +
                                                              "3oPOYScKYIqm78w9RWX0NDTgOyO5BR16Zn750LH0e2PrViT+/Ct+TkU5p1M/" +
                                                              "fFS6dOqh9w/POdkSRNU9qBRaC5Lhx7uNY+pWIo0Yg6hWNrsywCJQkbHi6Rbq" +
                                                              "mMNjFpdcL5Y6a+1ZdglGUVtuB5R7dQhn+lFibNDSapyRgX6j2pnx/OfBCqKq" +
                                                              "tK77EJwZV5c4IhIsswZ4bTTSq+vZBrF8ic5TwGj+bMvGD/knGy7/BwhsaPP8" +
                                                              "GwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1aecwrV3Wf92V5ySPkvSQQ0pA9L7SJ6Tfe7VFoyoxnbM/i" +
       "sT1jz9hDy8usHntWz+KZMU0LqCyCilIaaCpB/qiC2qKwdEHdRJUKlUWgSlSo" +
       "m1RAVaXSUiTyR2nVtKV3xt/2vrw8CkS1NNfX955z7vnde865Z+71s9+GrgsD" +
       "qOR7drawvWhfT6P9ld3YjzJfD/cppjGSg1DXOrYchhPQdkl94FPnv/vC+80L" +
       "e9D1EnSb7LpeJEdLzw05PfTsja4x0PnjVsLWnTCCLjAreSPDcbS0YWYZRo8y" +
       "0CtOsEbQReZQBRioAAMV4EIFGD2mAkyv1N3Y6eQcshuFa+jnoTMMdL2v5upF" +
       "0P2XC/HlQHYOxIwKBEDCDflvAYAqmNMAuu8I+w7ziwB/sAQ/+WtvvvC710Dn" +
       "Jej80uVzdVSgRAQGkaCbHN1R9CBENU3XJOgWV9c1Xg+Wsr3cFnpL0K3hcuHK" +
       "URzoR5OUN8a+HhRjHs/cTWqOLYjVyAuO4BlL3dYOf11n2PICYL39GOsOYTdv" +
       "BwDPLYFigSGr+iHLtdbS1SLo3tMcRxgv0oAAsJ519Mj0joa61pVBA3Trbu1s" +
       "2V3AfBQs3QUgvc6LwSgRdOdLCs3n2pdVS17olyLojtN0o10XoLqxmIicJYJe" +
       "fZqskARW6c5Tq3Rifb7NvuF9b3H77l6hs6ardq7/DYDpnlNMnG7oge6q+o7x" +
       "pkeYD8m3f+bdexAEiF99inhH8wc/9/wbX3/Pc1/Y0bz2CjRDZaWr0SX1GeXm" +
       "r9zVeRi5JlfjBt8Ll/niX4a8MP/RQc+jqQ887/YjiXnn/mHnc9zn5m/9mP6t" +
       "PegcCV2venbsADu6RfUcf2nrQU939UCOdI2EbtRdrVP0k9BZUGeWrr5rHRpG" +
       "qEckdK1dNF3vFb/BFBlARD5FZ0F96RreYd2XI7Oopz4EQWfBA90Enrug3af4" +
       "jqAVbHqODsuq7C5dDx4FXo4/hHU3UsDcmrACrN6CQy8OgAnCXrCAZWAHpn7Q" +
       "oYZh7pmhHsC4bsixHY1CPda8YkWBV2nFBOznNuf/v46W5tgvJGfOgGW563RQ" +
       "sIE/9T1b04NL6pMxRjz/iUtf2jtykoNZi6AWUGB/p8B+ocA+UGB/p8D+VRSA" +
       "zpwpxn1VrsjOFMBCWiAkgGB508P8z1KPv/uBa4AN+sm1YBVyUvilY3bnOIiQ" +
       "RahUgSVDzz2VvE34hfIetHd58M2VB03ncvZRHjKPQuPF0053Jbnn3/XN737y" +
       "Q094x+53WTQ/iAov5sy9+oHT0xx4qq6BOHks/pH75E9f+swTF/ega0GoAOEx" +
       "koE5g8hzz+kxLvPuRw8jZY7lOgDY8AJHtvOuw/B2LjIDLzluKdb/5qJ+C5jj" +
       "V+Tm/jrwPHRg/8V33nubn5ev2tlLvminUBSR+Kd4/yN/8xf/XCum+zBonz+x" +
       "DfJ69OiJQJELO1+EhFuObWAS6Dqg+/unRr/6wW+/602FAQCKB6804MW87IAA" +
       "AZYQTPM7vrD+269/7Zmv7h0bTQR2ylixl2p6BDJvh85dBSQY7XXH+oBAYwP3" +
       "y63m4tR1PG1pLGXF1nMr/a/zD1U+/a/vu7CzAxu0HJrR67+/gOP2H8Ogt37p" +
       "zf9+TyHmjJpvdMdzdky2i563HUtGg0DOcj3St/3l3b/+efkjIA6D2Bcut3oR" +
       "zvaKOdgrkL8aJCQFZ76n7e/2tLy9XCwpXNA8UpT7+XQUnFDRV8uLe8OTrnG5" +
       "951IVy6p7//qd14pfOdPny+wXJ7vnLSEgew/ujO+vLgvBeJfczoO9OXQBHT1" +
       "59ifuWA/9wKQKAGJKoh54TAAUSm9zG4OqK87+3d/9tnbH//KNdBeFzpne7LW" +
       "lQsXhG4Etq+HJghoqf/Tb9wtfXIDKC4UUKEXgd+ZzB3Fr2uBgg+/dPTp5unK" +
       "sQPf8Z9DW3n7P/zHiyahiDtX2KVP8Uvwsx++s/PYtwr+4wCQc9+TvjhSg9Tu" +
       "mLf6Meff9h64/s/3oLMSdEE9yBsF2Y5zt5JArhQeJpMgt7ys//K8Z7fJP3oU" +
       "4O46HXxODHs69BzvEKCeU+f1c6eizc35LD8AnvsOHPG+09HmDFRU0ILl/qK8" +
       "mBc/fujcN/qBFwEtde3Av78HPmfA8z/5k4vLG3ab+K2dg0zivqNUwgfb1025" +
       "qiHYvvQpRxYesYtxeVnPC2wnuvWSNvOGvOimZ4A+11X3W/uFAPrKOl+TV38C" +
       "RKWwyKgBh7F0ZbuYmW4EfMBWLx7qKYAMGxjNxZXdupJe3f+zXsB2bz72fcYD" +
       "2ex7//H9X/7lB78ODIyCrtvkiw/s6kSAYOM8wX/nsx+8+xVPfuO9RUAFEy78" +
       "4gt3vjGXOrkaurwY5sXoENadOSy+yFcYOYwGRQzUtRzZ1f1qFCwdsFVsDrJX" +
       "+Ilbv259+Jsf32Wmp53oFLH+7iff87399z25d+J94MEXpeQneXbvBIXSrzyY" +
       "4QC6/2qjFBzdf/rkE3/yW0+8a6fVrZdntwR4efv4X/33l/ef+sYXr5A8XWt7" +
       "uzj8Qy1sdPOoXw9J9PDDlCW5mkzTmhuvWGTTrifYvJ6Ydb/XstD5UrZIPF3U" +
       "HanKmmO6Qg2HSrXhZgxSk2e1idtqsZy/sCls2pjyvIeJKVMieQzFBFyg1yue" +
       "pInqhO45NsWMqWBKryOb8qcIv1g7tlBdK8Z2uI2aaWs6BQ2uVlVKSmOz2Ri1" +
       "rbEasAK37q2X3TXOEWmNW5qBP616bdZqj1tdMZOrVTSmzXKQzGBJU4TNhOsI" +
       "uEw3KVxqUWLGK77lqbPBeCtpglWlBNKZG+Ss1yuL7bGVLlbOYC0PPdPJHGnE" +
       "25rFyzIi+kmywGrzJY31JrRlpgg9RboLgqY8A522Oi41SvQNknHJROApr9Tw" +
       "8JE679Ziez6XBoGUNXmPVMj+qoQlTujTww6tRB125Q3Fpu8lLM15rDVO2JbQ" +
       "FUU+mPe7juDV6WobFo3aZDlVhujaIRuCILPqqD8IBhPBNgfj1ZptSi2BIrMo" +
       "Y/oWYRPCJELXsjeSGI1FM8V0+pOAGQ+7fczgEa68tkereoSG/oTS5ouUi1iM" +
       "4QZqb2LbVmnljsZ0ryMG1FaiOtWKJIk8Za3q9ohJyvqwJQZ1Y+Gs++VJJVwF" +
       "aJXqoZ3xWsFJqsPzfg/vs8iIaC0XTZPDxMGIIEa95SqNRSWgbFKbTlh2Aa9T" +
       "udrjZCpRjDJCCFWsaw0Qkq+MU2WDcjV6GM3kKYONMzxgCE0kRaLmJCq2rnKL" +
       "LWEu2njISNo6CQZzX4zxftgTQiPJ7XXa5kSTD1u67Dv0fEzUOhzHh7g37Sej" +
       "2ZQco1FFRTF8vpY7KWXHkZyyZNbnKa7ho6V4liWY0BFmGDE0ZXpurLqDDr2d" +
       "tYIhn21bYikaq4aw0v0xN0bdmCWm5gquzPFp3RrJvMkQJIb20aDriPrYczcz" +
       "esFjHRTfTrAsXcw22zViRGLUTdvTNj7YjodbSpH7PD5eu/MtMNB4o5YcmQil" +
       "nik3pcFqWOJqpC4ZNZG3tJ6ZJNusqZBdaySl80gxYFrgyqXJpE5764Uu8NKa" +
       "n3iEwU59mfdVYR6lI6FHLfiYRNYU7bWnzVLNG9H1SbhclycDxbKsCUG1yjjf" +
       "nTQEH7zaeTRKWA65Xte7kUhUgqrYVsuZ0t4OLdrrY40p2m63qVGr7jRJpC7z" +
       "IukQ4VwQxGjWgb1JvwGQWi628ljTGS40dWSWy5EyRxlzJaxocovhDYYQfWxg" +
       "lacONWASzmdQeT6rOtlYq7TMLikHyxlKmA131IRrYg2nWKTkLBZoT5Ya5Tbd" +
       "CScTCjgrkQ3W/am9aTJ+id2sqyq+EClKEWnG6/fQBYVZtLrg0ITAyIFJeskC" +
       "JbFN3B6knplgE9wa0GMgwqrwiapXg21r3A2pEo2WhotqmBC4MmJEv9y2lKo4" +
       "Nmy1XqnM65sNw2QR35G7VpcVacoPGIwPkfp8sRw7uBClM3OIr+PpdFWRZm0R" +
       "E7YIahGeoQrykhS743WEdZdh36GlYOFJRKh0SlRSV2neriHltrHy5tu4pDnq" +
       "GFNqlYVTkTprZ+gZ+pbpIW67JsFuaPajWguuqPCwL9XGLrk16Skuxb6DZyLn" +
       "tWtxb7atcLJgBcay38yscUuohbbU52lyTJqiotQRGLV8shGqjp4JJI521Ao5" +
       "n08jaSaonDTssXEwUCktarDtbdKprsX5OF6IetpVmPZWkNymmKmMkKklyR51" +
       "7Hq7ZQI94FYi1eA6amu1KGxN43RNoFOyNWMclhA3S1HecqoWRdiSQBGkn8Jx" +
       "u62JNXgSN7coQ3i1uhIpw4xw0bmD4QIMq1XE3pZK6obiy6PuthNOkf58oNPi" +
       "gMl0iRM4wpwrqo2vSuNeOiN7gzSoBnpQp5BsHM5TU8HRkmMgdX+6gYf2YgGj" +
       "OCbKmRJMlo0Fr5a0sArcxKhtxFrXqjsk05dbw9UA5QaU0fJxXamYdbzf40py" +
       "ipQkGElqbZYaD3lWd0ZEo44tGll/zDca/eFC0IfzAM36HGY77Wbc4AUtdfBN" +
       "Q8e1CdbWCKNXZnuprLQiHNh6KUjqPm1mDUQMNqtyspnF/FbvhrWoo1TmrRQf" +
       "pvW53eNRuNooNVmH2HZmWG1WSlsh0Wvo6MDDF1S3o9HlWBVRjgrSElnuzoSg" +
       "lFU0w2nNWjWOnLYISVh6yqomLfsk7RG1THMIl0q4DcwbKlP20mnC9jFuOm8l" +
       "Q44dwONN1mvNA19g4+WmN5M2yKIluxSNJH1t2l0FfmXbqNkZ48BlV0Fh2Kgj" +
       "oy1cabBdrsx7IBBvA6NvbuGgC146aq2thmyFQXM7o+rV1FPhHt7YeoG9rfGq" +
       "WitbNZwJEauyocnetBX3dW2yKVeqXaWqm2B/bpK9TFyHWhW1t3OqTlA+NUCi" +
       "aAyPItFQq+aaZJoBPmlOUnjtslGzjJQnC6erJAq7cSIklqtDR0FZ154Hre4G" +
       "ifkqWhqoeH8oVEfLxipJa5LQpf1e6nUZy1XtcmW9bHTsNSmnUpliKSSuIZvO" +
       "nKg405WAWOMyP463uiHU13YVcZIa25zCjVlDzKJaxx2peNCfO3bJK5VErdS2" +
       "ES5TVmKjIdFctsm0iNPCHtY0bAMexhqwZWPTEN257FiO2+yPLZmsR+tJf1Zz" +
       "9UqG2Gl70GfgxnrYSpQaPB8FnEn75a5TBXalw6ixbKOkNBdWZh2mq3BYqo62" +
       "kTujagLrEaZSrwwttyRsN45igH2M1PANNbH6uOeyw0m36eLNtiRgXn/lBgFb" +
       "b2eMgmqeREpah4BJ1cPGsEVrac0I27ZKRtOFTxIzUcdnEi4IzrLbaTG6qJlr" +
       "Q5CIuc4PtIGMbmywPQ7Enu7HsF/jE0Mu1dquMepUR+iio8Tyti7CUamHj4ZI" +
       "KnfVBFGwamOGjtSMnS1YdGWO6gAYvoWlBbxyytWErfLLSRwtKr012HtXGeOv" +
       "u8aYJqiGV+qvGikys8wFDoMZx8HGxo4MrN7UiTFh46bOtL1GXfHTFOsqy8Gg" +
       "Z856tZBdxH161EJKqjNzG9W5C4/DiJ7RY86droaeog7RmZQ6OjWNh2ytvjI8" +
       "oy966+ZcQltTQpCFme5kc0SVS1vb3/jOIKS3rquqQpWRmlK6XDBM6Iucv0VU" +
       "alRDumVRmswma2PUwKrtWAkXvay6YbKKMBhZBO1xc2oxa/QqKWIlqFgeY8TS" +
       "2GRkvequLMFxVpjUqNgWcLl1kx2vzS41alQtZepWDZToEsaYs/hJyFJuSWKZ" +
       "LrA4TF7Pt9FcTFg2yrQBognT6XhZXrY8ayk32HDYkaZgoSYdtd7n2MzMBNkK" +
       "G8a65Mmred8elFMeZDttNWyUVkGMNo31Rl1zjj6zQm4jjGZzvj8lXa8pVifR" +
       "CIt1r7nsyOvmdiUPe2W4zbDi2HPsjYV7cw0vKdYMlZlOeeu3ehyS6luqxcGJ" +
       "Geolic6wni+RdH3dWswExC5ZPV411QQLuG0ctBGOTKYxv1xilWZprM4ahIi1" +
       "t1R3ADPmtDvueOkmQ00uHWX8FDca1aRVoafSFMcaMY1vDXJVJ5oLBh9V4Fk4" +
       "nHGVcBLHiICDYL7ot2YIXx0GIMNNtUCsKc5E3wZyyIHg6zfgrDOqbLJyTNOj" +
       "bK05yFZFYLxSUUuknKRUoo9WK8KrdHE/9apMbTEOmWm44ekoBmmropXUoFs1" +
       "AoXGzGrdGcZZ3WqRs0alYc3YDcjfqmLdQPiSMetvTD8xaJB/Dee8Ss/JtdNq" +
       "JwgnzsosPlkMs2ED4ypNyW01yky/rFdHgbCclOBOVJpY04ZfGcBGl29qw7WJ" +
       "JPBoCF5HOHaKrDFO7jQYM23F7Lzki6RXnoO8W2SDMEs61NhS+ssmp6ydAbvq" +
       "+prKNOZNuVSRtIXdmwpRjDW4ljY23ZLdXSoszst+xi1mzVXVd1N4aGCdNXgn" +
       "o1stgkokoaHWSZMMw0SqK5MJvy5tJCzotpdqY5L0ViVlsOnhsOX2shaMgVWX" +
       "R6N2D+Tk+aul/oO93d9SHFocXaz9EMcVu6778+Kho+Oh4nP96cuYk+e0x8dz" +
       "UP6mfvdL3ZcVb+nPvP3Jp7XhRyt7B8eaj0fQjZHn/6Stb3T7hKj8bviRlz6R" +
       "GBTXhcfHbZ9/+7/cOXnMfPwHuGK495Sep0X+9uDZL/Zep35gD7rm6PDtRReZ" +
       "lzM9evmR27lAj+LAnVx28Hb30cwWs3s/ePYPZnb/ysf8Vz51K6xgt/ZXOTV+" +
       "y1X6nsiLTQRdWOjR0XXQ0aXEm05Yy6UIrIfpBdGxHSXf73Tk5GhFQ3gE/NZD" +
       "4M0D4M2XH/h7rtL3S3nxjgg6D4Czp48djyG+80eFeA94HjuA+NjLD/FDV+l7" +
       "Ki9+JYJuAhAZT5Vt9sAsT+D7wI+A77a88V7wdA/wdV9+fL9xlb5n8uIjO3y8" +
       "r6vFQeaV7Pas4nm2LrvHsJ/+UZf1TvAMDmAPXn7Yv3OVvt/Li2cj6IbIO3F3" +
       "dIzt4z8ItjSCXnuVi+H8luuOF/1DZfevCvUTT5+/4TVPT/+6uBs9+ufDjQx0" +
       "gxHb9slrhxP16/1AN5YFkBt3lxB+8fXHQJGr3F7nl4dFpUDwRzuez0TQq67E" +
       "E0HXgPIk5XMgwp2mBPGs+D5J99kIOndMBwbdVU6SfA5IByR59fP+4X1e82oX" +
       "76gSRoGsRmgElkuJI/1oetMzl2+cR2t46/dbwxN77YOX7ZDFv44Od7N497+j" +
       "S+onn6bYtzzf/OjuOli15e02l3IDA53d3Uwf7Yj3v6S0Q1nX9x9+4eZP3fjQ" +
       "4e59807hY6M/odu9V757JRw/Km5Lt3/4mt9/w28+/bXiVuN/AXqeuhIOJgAA");
}
