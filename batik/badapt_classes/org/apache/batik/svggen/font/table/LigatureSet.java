package org.apache.batik.svggen.font.table;
public class LigatureSet {
    private int ligatureCount;
    private int[] ligatureOffsets;
    private org.apache.batik.svggen.font.table.Ligature[] ligatures;
    public LigatureSet(java.io.RandomAccessFile raf, int offset) throws java.io.IOException {
        super(
          );
        raf.
          seek(
            offset);
        ligatureCount =
          raf.
            readUnsignedShort(
              );
        ligatureOffsets =
          (new int[ligatureCount]);
        ligatures =
          (new org.apache.batik.svggen.font.table.Ligature[ligatureCount]);
        for (int i =
               0;
             i <
               ligatureCount;
             i++) {
            ligatureOffsets[i] =
              raf.
                readUnsignedShort(
                  );
        }
        for (int i =
               0;
             i <
               ligatureCount;
             i++) {
            raf.
              seek(
                offset +
                  ligatureOffsets[i]);
            ligatures[i] =
              new org.apache.batik.svggen.font.table.Ligature(
                raf);
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1Ze2wcxRkfnx3H8SN+xHkQYjtxnKA8uCMUWoFpmsTYidNz" +
                                                              "bMXBog7kMt6bu9tkb3fZnbMvoSkPCcUggWgIIa3A/zQ0aRoSikBQtdBUqAEE" +
                                                              "ReLRUopI+lKblqISVaVVaUu/b2b39nF3TqOqtbSPm/2+mfm++b7f75vxiQ/J" +
                                                              "DNsi7UznUb7HZHa0V+dD1LJZskejtr0N2hLKI5X0zzvOb7kuQqpHyewMtQcU" +
                                                              "arM+lWlJe5S0qbrNqa4wewtjSdQYspjNrHHKVUMfJXNVuz9raqqi8gEjyVBg" +
                                                              "hFpx0kw5t9SxHGf9TgectMVhJjExk9j68OfuOKlXDHOPJ77AJ97j+4KSWW8s" +
                                                              "m5Om+C46TmM5rmqxuGrz7rxFVpmGtietGTzK8jy6S7vWccHm+LVFLuh8svHj" +
                                                              "Tx7MNAkXzKG6bnBhnr2V2YY2zpJx0ui19mosa99GvkIq46TOJ8xJV9wdNAaD" +
                                                              "xmBQ11pPCmbfwPRctscQ5nC3p2pTwQlxsiTYiUktmnW6GRJzhh5quGO7UAZr" +
                                                              "FxeslVYWmfjwqtjBR3Y0PVVJGkdJo6oP43QUmASHQUbBoSw7xix7fTLJkqOk" +
                                                              "WYfFHmaWSjV1r7PSLbaa1inPwfK7bsHGnMksMabnK1hHsM3KKdywCualREA5" +
                                                              "v2akNJoGW+d5tkoL+7AdDKxVYWJWikLcOSpVu1U9yUlHWKNgY9cXQQBUZ2YZ" +
                                                              "zxiFoap0Cg2kRYaIRvV0bBhCT0+D6AwDAtDiZGHZTtHXJlV20zRLYESG5Ibk" +
                                                              "J5CaJRyBKpzMDYuJnmCVFoZWybc+H2654YHb9U16hFTAnJNM0XD+daDUHlLa" +
                                                              "ylLMYpAHUrF+ZfwQnff8ZIQQEJ4bEpYyz375wrrV7adfljKXl5AZHNvFFJ5Q" +
                                                              "jozNfmNRz4rrKnEaNaZhq7j4ActFlg05X7rzJiDMvEKP+DHqfjy99cyX7jzO" +
                                                              "PoiQ2n5SrRhaLgtx1KwYWVPVmLWR6cyinCX7ySymJ3vE934yE97jqs5k62Aq" +
                                                              "ZTPeT6o00VRtiN/gohR0gS6qhXdVTxnuu0l5RrznTULITLhIPVxtRP6JJyc0" +
                                                              "ljGyLEYVqqu6ERuyDLTfjgHijIFvM7ExiPrdMdvIWRCCMcNKxyjEQYa5H8bT" +
                                                              "aabHUgYiFB3TGOBOWiTHMAO0gVAz/x+D5NHSORMVFbAIi8IQoEH2bDK0JLMS" +
                                                              "ysHcht4LJxOvyvDClHB8xEkUxo3KcaNi3KgcN4rjRsW4Ud+4pKJCDNeK48v1" +
                                                              "htXaDXkPwFu/YvjWzTsnOysh0MyJKnA1inYGCKjHAwcX0RPKqZaGvUvOrnkx" +
                                                              "QqripIUqPEc15JP1VhqQStntJHP9GFCTxxCLfQyB1GYZCkvCNMsxhdNLjTHO" +
                                                              "LGznpNXXg8tfmKmx8uxRcv7k9OGJu0buuCpCIkFSwCFnAJ6h+hBCeQGyu8Jg" +
                                                              "UKrfxv3nPz51aJ/hwUKAZVxyLNJEGzrDARF2T0JZuZg+k3h+X5dw+yyAbU4h" +
                                                              "zQAR28NjBFCn20VwtKUGDE4ZVpZq+Mn1cS3PWMaE1yIitVm8t0JY1GEazoOr" +
                                                              "y8lL8cSv80y8z5eRjXEWskIwxOeHzcd+9vrvPyPc7ZJJo68KgEDt9gEYdtYi" +
                                                              "oKrZC9ttFsOAfv/w0EMPf7h/u4hZkFhaasAuvPcAcMESgpvvefm2d8+dPfJ2" +
                                                              "xItzDgyeG4NCKF8wEttJ7TRGwmjLvfkAAGqADxg1XTfpEJ9qSsXsw8T6R+Oy" +
                                                              "Nc/88YEmGQcatLhhtPriHXjtl20gd76646/topsKBQnY85knJlF9jtfzesui" +
                                                              "e3Ae+bvebPvaS/Qx4AfAZFvdywTMRoQPIsLyBcAWQlM1olupnjSy6xWAN7sP" +
                                                              "ADsIBphww7kxGxJXzcI6jTuUdvXQTmWya+g3kq4uK6Eg5eYei90/8s6u10QU" +
                                                              "1CA0YDvOocGX+AAhvhBskqvzKfxVwPUvvHBVsEFSQ0uPw0+LCwRlmnmY+Ypp" +
                                                              "KsqgAbF9Led2P3r+CWlAmMBDwmzy4H2fRh84KJdWVjlLiwoNv46sdKQ5eOvG" +
                                                              "2S2ZbhSh0fe7U/u+d2zffjmrliBn90JJ+sRP//la9PAvXilBEpWqU6leg7Fe" +
                                                              "QPbW4NpIg268t/H7D7ZU9gGo9JOanK7elmP9SX+PUKTZuTHfYnnVk2jwm4YL" +
                                                              "A6SzEtZANF8rpnFV0WSc0Jvjhl7/YG9eYSaGs9DbjLdlth93g8voq9ETyoNv" +
                                                              "f9Qw8tELF4QrgkW+H2YGqCnXoRlvy3Ed5od5cRO1MyB3zekttzRppz+BHkeh" +
                                                              "R5ESgxaQcz4ASo70jJk//+GL83a+UUkifaRWM2iyjwp8J7MAWJmdAV7Pm19Y" +
                                                              "J3FlogZuTfiWJwXHEOEYki9qwNzuKI0avVmTizzf+9z8p284OnVWAJwp+7hc" +
                                                              "6FdiqREgdLFV9Djl+Fuf+8nRrx6akGE2TdKE9Bb8fVAbu/tXfytyuaDQEnkU" +
                                                              "0h+NnXh0Yc/aD4S+x2Wo3ZUvLo+gHvB0rz6e/Uuks/pHETJzlDQpztZshGo5" +
                                                              "ZIhR2I7Y7n4Ntm+B78GthayjuwtcvSicyL5hwyzqz48qHsgFjzixliXtcHU4" +
                                                              "nNIRJs4KIl52CJUrxH0l3q50eWqmaamwfWchoqqbplNOGjSnBOwxcrogn+sl" +
                                                              "Q+N9AG8J2d9Q2aC8OWhEJ1yLnfEWlzFC+uYKvNHi2ZbThhx1Zyu3D3bwFKRA" +
                                                              "I4LWJGjdUnfmB/Y3fvuUjNpSJBXadx07WqO8lz0jSApHva4wv9k4nWa4HEfI" +
                                                              "Jyfb/8vtAJ4G0AkeSzMjCztPnoHaNc0z7m7jf9k9Atuy8pns8+PUN5e+fsfU" +
                                                              "0l8KmKtRbYh3IOASe1+fzkcnzn3wZkPbSVGFViGPO7QQPDQoPhMIbPXFKjTi" +
                                                              "zRCv15ekiJulgBNf46WTJIKvUQ7pqepUE711Q32nCYfgr3V446aHraECSLIQ" +
                                                              "IgLs8Q2dYRXmfmt1GapwvgIf8yXItS2AsgPCVA+y3p994Nff7UpvuJQdE7a1" +
                                                              "X2RPhL87YL1Wll/u8FReuvsPC7etzey8hM1PRygawl1+a+DEKxuXKwci4ghH" +
                                                              "YmnR0U9QqTuIoLUWAwDQgzXFUi88uActq8QCh+oKly3x9+Q03+7D2z0QKwou" +
                                                              "tIyLacTvL6ZjbBgxfczthAD+3JgPoWzmElF2iXO576VQ9sC0KFtOm5NZLsra" +
                                                              "QksLjtw63chCVHDz4bybGKsu4SDCNM3/zF8PTeOvvC8ECnMXf9UkdGLkm7uv" +
                                                              "FiKIi23lDvVE0X3k7oNTycHH17g0sQHcxg3zSo2NMy3QFSd1vmMWLNIWFB3q" +
                                                              "yoNI5eRUY838qZvekYDpHhbWQxancprmLyN879WmxVKqmES9LCpM8TjGSefF" +
                                                              "PQ8BzgsodlRqfhvqm+k0OanCh1/lJCfzy6gAwMoXv/x3OGkKy8NUxNMv9zQn" +
                                                              "tZ4cdCVf/CLPwi4GRPD1OdONuSYPqGXplq8Irm8hkOZeLPF8IbE0gJ3iBN/F" +
                                                              "uZw8w08op6Y2b7n9wmcfl0cYikb37sVe6oDV5GlKASuXlO3N7at604pPZj85" +
                                                              "a5kbZM1ywl4qXO5DoBFIFRPDa2Fof293Fbb57x654YUfT1a/CSy+nVRQILTt" +
                                                              "xUVu3sxB9G+PF+8BgVfEwUP3iq/vWbs69af3xDbCobVF5eUTyttHb33rwIIj" +
                                                              "7RFS109mQP6wvKi+b9yjb2XKuDVKGlS7Nw9ThF6APQMbzNmYCRTP9oVfHHc2" +
                                                              "FFrxAAyCvXhvXXxsCFuuCWZtgFo36dQidV5L4F8LLt3kTDOk4LX4CpQ+wTV5" +
                                                              "WRFWJuIDpukePdTdZAqE2Vge2F4Vr3h77d+HvKlP3RsAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "OqsFPWKSJY/6e9VfDtB6nW82XGKj6UFTaLU6IhWIA2LOjviRzoYY31A2szUo" +
       "caP6UPTTRB9pWL4eRfMGHuocIeBw3vS73dZE09Cln8Q0rwxQsb5uzDiDxdAN" +
       "W1/Zdi3GyJkaJyFHoGpUqDlmjOvcLNfF1K7DItwfMFm8ZlLZbOkGtXHcGbLs" +
       "8vtFPPLY5QqURbxerMmliWExKDr2GE8YsMfYeTPrwjzShNF+o0B4JvXiaJSz" +
       "orxI2M52J/X0TJOLyMD7cJPWOW9VOAObbJjraRvtCHw3JBCGjKZOe7Jlw0Dk" +
       "rZDdRWmnKRuEQPWLlpRLQyaMW/M+yJfNWkFi3AKAU0JgA8Idr7Xu0lKGrOWg" +
       "cUKazMhsNO1+IgyQddNCvckilymqjupIyFNypjeLudeYjPMmT86VeuKMV+xk" +
       "tAI1xh5gxwiksOUGa2L7baJam75PGdKKz0RX9gOHzScY2l05mcDsncG8yxL+" +
       "GFvshnNVIzke6xV66Cn2bK8Zyd6BLQSgHGHUazZNaEXe0fF07K2TWtacDi0m" +
       "xybLbDJOugXvRtuWrBCCViNYLjVbwxnXr0+V6SSeb7j9cO3be2wUOJhhTbcq" +
       "y5HYSBogOt00e5MaGW9TLEUwz+9sGhLqdlNH1mxE3pjgKQsNBbXj9YX20Gbw" +
       "eby2p80JKkYdpOVz2x3WFtuWtB3X89Ru7YEp+l6PHJFgcbFBelqj2yQlqY1m" +
       "ZT271BZ1sUbMc9gVZvyIXUTZUoibYdbrDmGOhLGeLmiDdMk1zX0tWUlhpytq" +
       "zawvEZ4kkG11ucijiJKazSAdjXbojJzXka7Dc500YUxY6uY7qbFm4r7ADO05" +
       "Okm7C4Ps4Bw/loqJsyFmC67rCRpFyQ2SDDIcz4lkbSTrdRYSJCiLVttIJ71m" +
       "R+FNRWizLRJj2ahpLfpTq8WuW4TPw+lCaK9m5IqOR30/tlROWShbfD9oCLra" +
       "IFtC0DRQVIGphLG55iwED7kfqV5m/MN391j+ZLUDcfbBBXgaLzs+8y6evLML" +
       "G1ZnWzXV7zp05SX9ha2aC68foPIFyXP3+o6iekf0xU+++ZYy/en60cluVTeC" +
       "HgUVz3fbaqLal6aKoPdceLNdvqb7wB3f0Ry+/ZC//NbNR555a/kHh33k0+8z" +
       "HmWhR7TYti9u8l9oX/cDVTMrJh49bPn71d/PRNDL337TKYIeis52Pb90oPxy" +
       "BH3wfpQR9GD5d5Hk5yPomXuQlPtMVePi+F+MoFtXxwNWqv+L4345gm6cjwNT" +
       "HRoXh/zzCHoADCmbv+LfZZvq8GIlu3bZvmeO9NS328K54BKvXNrprT6aOt2V" +
       "jQ+fTb0uf+UtevLxb3Z++vCiW7bFoihneYSFHj68cz/b2X3pnrOdznWd+tC3" +
       "nvi5R189dbInDgyfh8IF3l64+1vlgeNH1Xvg4p8984vf84/f+uNq1+z/A+eC" +
       "tWfNJgAA");
}
