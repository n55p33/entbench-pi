package org.apache.batik.util.io;
public class StringNormalizingReader extends org.apache.batik.util.io.NormalizingReader {
    protected java.lang.String string;
    protected int length;
    protected int next;
    protected int line = 1;
    protected int column;
    public StringNormalizingReader(java.lang.String s) { super();
                                                         string = s;
                                                         length = s.length(
                                                                      ); }
    public int read() throws java.io.IOException { int result = length ==
                                                     next
                                                     ? -1
                                                     : string.
                                                     charAt(
                                                       next++);
                                                   if (result <= 13) { switch (result) {
                                                                           case 13:
                                                                               column =
                                                                                 0;
                                                                               line++;
                                                                               int c =
                                                                                 length ==
                                                                                 next
                                                                                 ? -1
                                                                                 : string.
                                                                                 charAt(
                                                                                   next);
                                                                               if (c ==
                                                                                     10) {
                                                                                   next++;
                                                                               }
                                                                               return 10;
                                                                           case 10:
                                                                               column =
                                                                                 0;
                                                                               line++;
                                                                       }
                                                   }
                                                   return result;
    }
    public int getLine() { return line; }
    public int getColumn() { return column;
    }
    public void close() throws java.io.IOException {
        string =
          null;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "vdLmxn8ALn+YojQdAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL06e+zzVnX+Hv1elH5fW/qg9N2PR5vuc2Ln4aiw4Th24sSJ" +
       "nTjOw2z9cPyK42f8iB2zboDYQENiiLWMTaX/rGgMFYom2CYxpm7TBgi0CcQ2" +
       "mDRA06SxMST6x9i0bmPXzu/9fV8fgBbpXt/ce86555x7zrnH9/qZ70PXBT5U" +
       "8Fxro1tueElNwktLq3Ip3HhqcKnDVDjJD1SFsKQgGIG+y/L9nz7/wxc+uLhw" +
       "HDolQjdLjuOGUmi4TjBUA9daqwoDnd/vJS3VDkLoArOU1hIchYYFM0YQPsJA" +
       "rzqAGkIXmV0WYMACDFiAcxZgfB8KIL1adSKbyDAkJwxW0C9BxxjolCdn7IXQ" +
       "fYeJeJIv2TtkuFwCQOFM9n8MhMqREx+6d0/2rcxXCPxEAX78Nx+98PsnoPMi" +
       "dN5w+IwdGTARgklE6HpbteeqH+CKoioidKOjqgqv+oZkGWnOtwjdFBi6I4WR" +
       "r+4pKeuMPNXP59zX3PVyJpsfyaHr74mnGaql7P67TrMkHch6676sWwmprB8I" +
       "eM4AjPmaJKu7KCdNw1FC6J6jGHsyXuwCAIB62lbDhbs31UlHAh3QTdu1syRH" +
       "h/nQNxwdgF7nRmCWELrjmkQzXXuSbEq6ejmEbj8Kx22HANTZXBEZSgjdchQs" +
       "pwRW6Y4jq3Rgfb7ff/MH3uG0neM5z4oqWxn/ZwDS3UeQhqqm+qojq1vE6x9i" +
       "Pizd+vn3HYcgAHzLEeAtzB/+4vNvffju5764hXndVWDY+VKVw8vy0/Mbvnon" +
       "8WD9RMbGGc8NjGzxD0memz+3M/JI4gHPu3WPYjZ4aXfwueFfzt75CfV7x6Fz" +
       "NHRKdq3IBnZ0o+zanmGpfkt1VF8KVYWGzqqOQuTjNHQatBnDUbe9rKYFakhD" +
       "J62865Sb/wcq0gCJTEWnQdtwNHe37UnhIm8nHgRBp0GBrgflLmj7y58hJMML" +
       "11ZhSZYcw3Fhzncz+QNYdcI50O0CngOrN+HAjXxggrDr67AE7GCh7gzkSjDc" +
       "HVPqu76deQpoDlVJUf1LmbF5/z/TJJm0F+Jjx8BC3Hk0DFjAg9quBWAvy49H" +
       "DfL5T13+8vE9t9jRUwgVwcyXtjNfymfeLqThXrrGzNCxY/mEr8k42AKDNTOB" +
       "94O4eP2D/C903v6++08Ac/Pik0DhGSh87fBM7McLOo+KMjBa6LmPxO8a/3Lx" +
       "OHT8cJzNuAZd5zJ0LouOe1Hw4lH/uhrd8+/97g+f/fBj7r6nHQrcOwHgSszM" +
       "ge8/ql/flVUFhMR98g/dK3328ucfu3gcOgmiAoiEoQQsFwSZu4/OcciRH9kN" +
       "ipks1wGBtVzl2dBuJDsXLnw33u/JF/6GvH0j0PGrMsu+H5Q375h6/sxGb/ay" +
       "+jVbQ8kW7YgUedB9C+999Bt/9S9oru7d+Hz+wI7Hq+EjB2JCRux87v037tvA" +
       "yFdVAPcPH+F+44nvv/dtuQEAiAeuNuHFrCZALABLCNT8K19cffPb33r668f3" +
       "jSYEm2I0tww52RMy64fOvYiQYLY37PMDYooFHC6zmouCY7uKoRnS3FIzK/3v" +
       "868vffbfPnBhawcW6Nk1o4dfmsB+/2sb0Du//Oh/3J2TOSZne9q+zvbBtoHy" +
       "5n3KuO9Lm4yP5F1fu+u3viB9FIRcEOYCI1XzyHVsx3Eypm4BuUeOmW1fOy6Z" +
       "ryacDz+U15cyTeRIUD6GZtU9wUGvOOx4B5KSy/IHv/6DV49/8CfP52IczmoO" +
       "GkFP8h7Z2l1W3ZsA8rcdDQFtKVgAuPJz/Z+/YD33AqAoAooyCHAB64PYkRwy" +
       "mR3o607//Z/++a1v/+oJ6DgFnbNcSaGk3Pugs8Ds1WABglji/dxbt6senwHV" +
       "hVxU6Arht9Zye/7vDGDwwWsHHipLSvZ99/b/Yq35u//xP69QQh5yrrIXH8EX" +
       "4WeevIP42e/l+Pu+n2HfnVwZnUECt4+LfML+9+P3n/qL49BpEbog72SHY8mK" +
       "Mo8SQUYU7KaMIIM8NH44u9lu5Y/sxbY7j8adA9MejTr7uwJoZ9BZ+9yRQHND" +
       "puU7d4LNbtA5FGiOQXkDz1Huy+uLWfXGXb8+6/luCLhUlR3X/hH4HQPlf7OS" +
       "kcs6tlv1TcROvnDvXsLggS3rVJC7QYZd3Aa2rC5nVWNLtHZNa3nzYVleC8ob" +
       "d2R54zVk6V5DlqxJ5gqiAE+W6ujh4sVtjvMNG0TQ9U7+Bj9207fNJ7/7yW1u" +
       "dtTAjgCr73v813506QOPHz+QET9wRVJ6EGebFecMvjrnMnPZ+15slhyD+udn" +
       "H/vcxx9775armw7ndyR4ffnk3/7PVy595DtfukoycQLk7kdWhHmFK3IbKA/v" +
       "rMjD11gR8eWsyEkH6D9r80c4etsr5Oh1oJR2OCpdgyPpZXGUJbJX42j+Y1ht" +
       "dYej6jU4Wrwsq91m5lfjyXhJnrY2dQz49HXIpdql3BXdq896Imu+Kffc7N0T" +
       "YGiGI1m7bNy2tOSLu74+Bu+iIPBeXFq1q3k49bL5AtZ+w/7Wybjgve/9//TB" +
       "r/z6A98GltuBrltnARSY+IH9tR9lr8K/+swTd73q8e+8P89HgMrG73nhjrdm" +
       "VJMXky6r8pFwV6w7MrH4PMFnpCDs5SmEqmSS5YDcAXlGmXm426D2Y0kb3vBk" +
       "uxzQ+O6PKYnNSSwkyURlYRguD+G4ieC9Fs4RZKNgDshhX2IbRqPCpcsU10tD" +
       "XFPRMF0H41qErSOnXUQ8ARl0w81qMBuUF8yMHA+FYYNs0auQ0Trdbrfl0fZK" +
       "9HC7Ko75/nhC2Ei3ZQ1KvuDP6z20h0Yohw4rm5LGm44SzdUJbK9H2lpT4T7K" +
       "2fNVbzkQBuGEx1WxyDSHRWkywAUSlZsDlyhLCQ77RNnrUbFVaM3hYYh1OYMe" +
       "DXxmYdRdu6nPdYcRJj2aEXFBj42uQRcLyy4rzIrNdiOctxtE19ssiJVV3qgL" +
       "QmRcc1gt8YbdYAKSmw1XDaFT7Iq0GfVUWe/iFC3iZkwMOvP2jFPK4sCTFisy" +
       "EStmuYhJjWhh4ZbPzFjdDvHCTIjpDm2ajWKXH4y8EWutvJXGkEZ3wze92Ghr" +
       "a1ORZp3QnU5E0dbrc2e1RMraUpFjEosnFClYo2ZpyaaioA6S9qC6lKoRwssy" +
       "M1umVY4wu25sij2BCtz1RMcpHcVd2woZfjVY666/EYYDUV0N6mRK2aZO0baR" +
       "yEmnX6QnJCsXcTOx7C4xsWtuLIYUIhRFEbxUTA1yEzSLRYwtoRsfpwTOnXid" +
       "ljQyDAIndWHSirt4mZRb1WBkSolCLsbdNS7qdWM67JiSwsjVkddsWSRpuqNw" +
       "VIkoxZiVfKZXYsbrBud2ItWizZVXGTLYTN6skzHVYSlSIUqx0h1L9UW/UGw3" +
       "ZN0ki0iPKHTQjrDUV91xi6B8t9JbrhBuoJMxteJjgo9Eb7Ya4yN30J7Kw8mw" +
       "0RqYPT0KPLrYkDyablb1UR+rbATEckcJRS0atOoNa77bWOsDoSMkgxI+0SNf" +
       "EVsxsMxxxbeQTU2G+2u31G4aizk1gje6nAyZnifAuqdLDpnMZTnxWyyNY5UZ" +
       "MixXmSWP9dhxm6CX/lTm5YofaRE61VbenPFRQiqMLLdgcLWAXBLlyKH9pjrX" +
       "NwFCUXjCL6djk13abDp0hJGoLx3e7pPEbBFsegqDL7npolLAIk3TdBkOCG7j" +
       "hINAWnY3g1FZkBC3sxx2krXbnPRa1UGbKDYq40Vn6JnlFHEb/UrTdDuVOYoF" +
       "ot3k9dizStYkCMK67i4WvYFQEppRgSctblSreHg5iuse3yL5qNGwNDwYcGlz" +
       "rZs8jpIlfcASXcLgXX3WUjrT1Twe4DLf0RFU13GrDLeWTSGj0KKaJXOG49qi" +
       "2a7oeKqveMkPeaeqm1JXI6rtQTj028pArHMFDovMFSOlCVosIPTC7scpTZLU" +
       "fDy03LjQKcrmeupPtKaPklMXoRaIa+uleWPTKBUqehXt9Usdnk2TyXBZ1iYo" +
       "zlozfBRXqv3BetCEKSlqtRMXqVe9kt6J+wiCkXjC8uNAkfiFC4KKVMI4I5mv" +
       "Vht5Oi3VUnNYFhZjQqU7hEP3u2FQMmXcx4bDXnXg0xVC95ubZNOZORLNjMZD" +
       "qo1LEoa5QoWvmtWFM5VGdVxG4tRjyPmyrxLKAGW6y01Va7XrZilRJoVKW7OH" +
       "vmuaE1zyhnUd71Qb/nKOdoiBVK+t4lQuRM4Sc1urhr7hph7VNylDG7vKNCTt" +
       "WrroTZGh3LUwPGgjlaW4iQnMGDQbgMasbNWa+ghRpOHGiTyeiJdtuzMduHO1" +
       "vyFDbSxLUbswAVl1BWvOLaqh18ix45Zshems2XClF+fSsJDOS72KPGFIWGar" +
       "er0uRxocUaO0n3oW1QlXsdDqqXYxHhqKT5cb4xVqhcuwuKTbETrsNZdpPcHg" +
       "RlTx+3jAj6a6jRSbgw4WDyXCnsPlzbqCon5YKHi+hjk9Qh3Foj6lXWvc4usr" +
       "bsORPiEFQaAO8JYo43R1OQ7ZZBqPNqZNDEmxiDWrIjzl+6JWULp8q1Ame9zE" +
       "RCfO1CGktBCN14O4ivXhKkKN1N5IGq6QeUsaypONNpcRbKKoFMF77arXQikn" +
       "LRlrXBBxCxdNFmwkSaBNpECotiSX8JZOc7S0jSWhOD2lVar1EX8qkG7cCeZk" +
       "P6SsFdLliNbUQFjDDdo+isyUSdQsFbBEGcaU3UE6BX0ckrVIqQ1Fy2W8Vh1x" +
       "w7EQl00CrTuM5iz8CmYjM3mwsCm8NVpOy0qZqFlywx5Fq6U5TuvV1aS9tuMp" +
       "jZbRrjie0IoeBAXAbtQsImWXqHXVYlqHKaW9KVCeK3mG3xXSwkq3rMJMLRZq" +
       "5MJbRGmzspbF9TxN0urSS7kyyvVEOClWVzAyaKF+Z4PS65pcmoYFLZKScoHF" +
       "aGq5aE570XolwvVeNBzU4LpamXdactPqUqIMk2wD22hOY6TUY04PvW5bnktO" +
       "UMfH7lxrqxpfS8Zo3cdmcH3VGtCl2cIuzBPG7PSKmqvqYnPE90cTAaEriQg7" +
       "bamCss0OjUSlNjDFeF6uboqEWhBsvzKNJo2QClFCXHBScdF09KagzQyM63lz" +
       "y28hTjoueRThjJTOBLeayxXudVdcH+wbDT0ossa6PoyrkhZ6iDsqDzmlWrDZ" +
       "qQBXKxgRo1TJj2gNY5llPSz4DFVn6VZvMgmWHaIcbAzdmMpxa0TquhB0YjZI" +
       "AoyoqwixZvsCgrXX0Qrtp702US34bGOIqvW1Wi9ZeqkrzeyYrhXhUKdxXrfm" +
       "3ZW/EBys104wDK7OOEsUQTDqJoy9mKzATBV+1Q/nSaNconWZaUZrpTXqbypx" +
       "Q4mHZYNpCfW+BvvL5abJt9V2zZ6InVKNaaZYu8eNyzKiVhdFA2bDeGlU0Vq9" +
       "jNGK00xqthAKlS6sR2y3oRZ6E3gaYWVMDKdyhWcaItgXrJI/QEt0MajWywNf" +
       "gavTVaUMT6jpsCkrrSbvsd2wWeioVYblCTcxF+25aFlOl4+qo/7UTRZNUyrL" +
       "dZlz0HThVJVND1sVY26qThco2lFheG50Vvi8gA/raKHI95ZUk1a1ZoCJsugi" +
       "bZMUVXqOlIlRfVgZdnm4odCBUpFFH4x1+pWFNjI6kTWabcpJszAY9hAhDNNu" +
       "2uYCga4rYpGq0pOhKRT5hlRuj2UxpoqFsFlcTZZwEVlj4poklPFAFOaTmtjc" +
       "tEQlFBbTgT1MmUgcysLYFmtKXUpQFIHnkxEzosv1sAtbTV2eF5xg0WirtX6J" +
       "rwzn1qZKw6lib7q1CtogJtJiU/Sjrgh7nAavcGxNztAK0sL6o3k4C5ce6xVj" +
       "k6uMXJsflxI86PIpU5kUYURqCgU0kmBlbqhFrqdZpOdIKB2URrV21W6te2MN" +
       "3YAski020fqUN4dSne8u2XqCODFVNgttMx2m8x5IvWulUZUV1i3bagstri4U" +
       "a2m/h6dz1i1zbS5VmbbdkzEUc5O6mYpap7owG53+oOUKQbeSYl43HTRwDBnL" +
       "ZBqW6amUVPpMYSBGRWMelHFpRk/0xpSdtMVapcGm+DKMi3XMtntrpldTmyCf" +
       "1KbtwoCl1l5qL0hsVAmZRmPSCWw/RsqdBRKlC8MU9GkgCt2JK1bSNUwUWJNo" +
       "+cWIbRmdGmH7VFjSFr2Ac6JV5I+SUq+KtiYdZ24HPj4Nl/zYRpyECmrYRFra" +
       "Pb5Yk3gnWZTJKUu5hLQupCoBd5iu1y6IJFwgXW4lJy1cL9gTRxtwbLlVkYJm" +
       "sxaGXH3ZbWyMuMozTiExSxvK1et0lQ1KzKCU1MQqurCcyYiz5c1oki61MYqY" +
       "4pyzasamxQXLClVMTWezLs5BYBiPENhlUcqH+ww2Iu3xQvYYVtApquMX1E3E" +
       "h4lYTT1VXqG+b9RXqbPxJLuHxiFV17smZyLNuECwyFqQVKnCmJteGGzqm1Hk" +
       "9Gu1cmKNkkmpwdeKswIuMmAHSVJJ8JhB0IrZylAZkSwrpnLF4aNC36e8sZpy" +
       "a2TmaBjP1BBxXfAb5ZqcNMdlrORMaolbdlWQH1NEsQrelbg6iXkIQ9e8QXXR" +
       "7fkeTxNMj9btjVvqakOtNHfJNlFrdaVg4494BBOIid/nVkMTxdjJpuCWS77q" +
       "8rOxxa2WpW41VpMUQ8RgI3TSaT+ZNEsIXtnQSexXW1XcK4vNtbiacAE7Rrts" +
       "ItGwg3tYuYxWtbXC2ImD4WA9Zu5yoIC30bdkr6nveWWvzzfmpwJ7d7w/xnnA" +
       "zvt6Vr1+7wQl/52CjtwLHjhBOXCGDGVHZndd6+o2Py57+t2PP6WwHysd3zl7" +
       "F0LobOh6P2Opa9U6QOokoPTQtY8Ge/nN9f6Z8Bfe/a93jH528fZXcAV2zxE+" +
       "j5L8vd4zX2q9Qf7QcejE3gnxFXfqh5EeOXwufM5Xw8h3RodOh+/a0+z5TGM3" +
       "g0LtaJY6eja1v3ZXP5h603btX+Rq47ePjB25K9neshjuJZolE1n1MpXleE9m" +
       "1RMhdNJXJSU/79o3oQ+/1CHLQSbyjg8dlvlWUB7dkfnRn77MH3+RsU9k1e+E" +
       "0GldDZnd48V90Z7+SUW7HRR1RzT1py/aZ15k7A+y6lngTkA0Yv+ccl+4T/8E" +
       "wuVXptlZs7UjnPXTF+65q9tq9vejOcCfZdXnQug62XID9apngmvXUPYl/uNX" +
       "InESQrdd4w4/u5C8/Yrvhrbfusifeur8mdueEv4uv8be+x7lLAOd0SKQIR64" +
       "JjrQPuX5qmbkUp3dXhp5+eMrIXT7tb4wCKHjxvbA+Mtb4L8OoVuuCgwUkT0O" +
       "wn4thC4chQWazJ8H4f4mhM7tw4XQqW3jIMg3QugEAMma3/R2I8lD1/wu4gpt" +
       "JscObxl7y3XTSy3XgV3mgUN7Q/7p124cj7Yff12Wn32q03/H89WPbS/qZUtK" +
       "04zKGQY6vf1mYG8vuO+a1HZpnWo/+MINnz77+t1964Ytw/tWf4C3e65+K07a" +
       "XpjfY6d/dNtn3vy7T30rPzD/P9tPECKTJwAA");
}
