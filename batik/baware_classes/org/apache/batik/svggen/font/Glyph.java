package org.apache.batik.svggen.font;
public class Glyph {
    protected short leftSideBearing;
    protected int advanceWidth;
    private org.apache.batik.svggen.font.Point[] points;
    public Glyph(org.apache.batik.svggen.font.table.GlyphDescription gd, short lsb,
                 int advance) { super();
                                leftSideBearing = lsb;
                                advanceWidth = advance;
                                describe(gd); }
    public int getAdvanceWidth() { return advanceWidth; }
    public short getLeftSideBearing() { return leftSideBearing; }
    public org.apache.batik.svggen.font.Point getPoint(int i) { return points[i];
    }
    public int getPointCount() { return points.length; }
    public void reset() {  }
    public void scale(int factor) { for (int i = 0; i < points.
                                                          length;
                                         i++) { points[i].
                                                  x = (points[i].
                                                         x <<
                                                         10) *
                                                        factor >>
                                                        26;
                                                points[i].
                                                  y = (points[i].
                                                         y <<
                                                         10) *
                                                        factor >>
                                                        26;
                                    }
                                    leftSideBearing = (short)
                                                        (leftSideBearing *
                                                           factor >>
                                                           6);
                                    advanceWidth = advanceWidth *
                                                     factor >>
                                                     6; }
    private void describe(org.apache.batik.svggen.font.table.GlyphDescription gd) {
        int endPtIndex =
          0;
        points =
          (new org.apache.batik.svggen.font.Point[gd.
                                                    getPointCount(
                                                      ) +
                                                    2]);
        for (int i =
               0;
             i <
               gd.
               getPointCount(
                 );
             i++) {
            boolean endPt =
              gd.
              getEndPtOfContours(
                endPtIndex) ==
              i;
            if (endPt) {
                endPtIndex++;
            }
            points[i] =
              new org.apache.batik.svggen.font.Point(
                gd.
                  getXCoordinate(
                    i),
                gd.
                  getYCoordinate(
                    i),
                (gd.
                   getFlags(
                     i) &
                   org.apache.batik.svggen.font.table.GlyfDescript.
                     onCurve) !=
                  0,
                endPt);
        }
        points[gd.
                 getPointCount(
                   )] =
          new org.apache.batik.svggen.font.Point(
            0,
            0,
            true,
            true);
        points[gd.
                 getPointCount(
                   ) +
                 1] =
          new org.apache.batik.svggen.font.Point(
            advanceWidth,
            0,
            true,
            true);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "ueeueNTgZ3lt2RYhwqPWWnz78n8Bb8yKGEEiAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV6e8zryHUf7717n97de3cde53Nvvc6zVrxlShKooTdpCYp" +
       "ihJFSZT4kMQmXlN8ieL7/XC3cdyH3QZ1jXadOkCyfzlNGmzsoE3QoEWaDdrm" +
       "ARtBYgRNWjS2EwRNWteA3aJJW7d1Sep733u/zXYdARwNZ87MnN+Zc84czszr" +
       "XwMuBz5Qcx0z00wnvKOk4Z2d2b4TZq4S3CGpNi36gSJjphgEbFH2svTcz938" +
       "029+cnvrInBFAN4p2rYTiqHu2MFCCRwzVmQKuHlcipuKFYTALWonxmI9CnWz" +
       "TulB+CIFvONE0xC4TR2yUC9YqBcs1CsW6sgxVdHoIcWOLKxsIdph4AF/DbhA" +
       "AVdcqWQvBJ493Ykr+qJ10A1dISh6uFa+8wWoqnHqA88cYd9jvgvwp2r1V//h" +
       "B2/9k0vATQG4qdtMyY5UMBEWgwjAg5ZibRQ/QGRZkQXgEVtRZEbxddHU84pv" +
       "AXg00DVbDCNfORJSWRi5il+NeSy5B6USmx9JoeMfwVN1xZQP3y6rpqgVWN99" +
       "jHWPcFCWFwBv6AVjvipKymGTBwzdlkPg6bMtjjDeHhcERdOrlhJunaOhHrDF" +
       "ogB4dD93pmhrdSb0dVsrSC87UTFKCDx+305LWbuiZIia8nIIvOcsHb2vKqiu" +
       "V4Iom4TAu86SVT0Vs/T4mVk6MT9fm770iQ/bQ/tixbOsSGbJ/7Wi0VNnGi0U" +
       "VfEVW1L2DR98H/Wj4rt/6eMXAaAgftcZ4j3NP/ur3/jA9z71xq/vab7rHjSz" +
       "zU6Rwpelz2we/u0nsBd6l0o2rrlOoJeTfwp5pf70Qc2LqVtY3ruPeiwr7xxW" +
       "vrH41fVHfkb56kXgxgi4IjlmZBV69IjkWK5uKj6h2Iovhoo8Aq4rtoxV9SPg" +
       "apGndFvZl85UNVDCEfCAWRVdcar3QkRq0UUpoqtFXrdV5zDviuG2yqcuAABX" +
       "iwd4sHieBPa/6j8EuPrWsZS6KIm2bjt12ndK/EFdscNNIdttfVNovVEPnMgv" +
       "VLDu+FpdLPRgqxxWxJqm2HW1kE2dMDN3e6dUL/cvquO0RHQruXChEPYTZ03d" +
       "LKxk6Jiy4r8svRqh+Dc++/LnLx6p/oEsQuC5Yqw7+7HuVGPd2Y91pxzrTjUW" +
       "cOFCNcR3lGPu57KYCaOw6cLbPfgC84Pkhz7+3KVCidzkgUKMJWn9/k4XO/YC" +
       "o8rXSYUqAm98Ovlh/ocaF4GLp71nyWdRdKNsTpc+78i33T5rNffq9+bH/uRP" +
       "P/ejrzjH9nPKHR+Y9d0tS7N87qxEfUdS5MLRHXf/vmfEX3j5l165fRF4oLD1" +
       "wr+FYqGPhet46uwYp8zzxUNXV2K5XABWHd8SzbLq0D/dCLe+kxyXVFP9cJV/" +
       "pJDxO0p9vVU8zx8ocPVf1r7TLdPv2KtGOWlnUFSu9PsY9yd+7zf/E1SJ+9Dr" +
       "3jyxjjFK+OIJSy87u1nZ9CPHOsD6ilLQ/f6n6X/wqa997K9UClBQPH+vAW+X" +
       "KVZYeDGFhZj/5q97/+7LX/rM71w8VpqwWOqijalL6RHIshy4cQ7IYrTvPuan" +
       "8BRmYVSl1tzmbMuRdVUXN6ZSaun/vvle8Bf+yydu7fXALEoO1eh737yD4/Lv" +
       "RIGPfP6Df/ZU1c0FqVypjmV2TLZ3f+887hnxfTEr+Uh/+ItP/tiviT9RONLC" +
       "eQV6rlT+6FIlg0sV8neFAHSuTYYlT3vL7CuB5OtuxbIPvHBOpOPrVjGT8cHq" +
       "UH/l0S8bP/4nP7v3/GeXkjPEysdf/TvfuvOJVy+eWG+fv2vJO9lmv+ZWKvjQ" +
       "fja/VfwuFM//LZ9yFsuCvc99FDtw/M8ceX7XTQs4z57HVjXE4I8/98q/+OlX" +
       "PraH8ejp5QYvoqmf/bf/5wt3Pv2V37iH37scbB1/H2Y1y6Sz17tuCFwqgoyK" +
       "93pV8r4qvVMyW80SUNV9oEyeDk66odNCPxHbvSx98ne+/hD/9X/5jYqP08Hh" +
       "SaubiO5eag+XyTOlEB4763OHYrAt6FpvTH/glvnGN4sehaJHqVg1gplfOPv0" +
       "lI0eUF+++u9/5V+9+0O/fQm4OABumI4oD8TK3QHXCz+jFKIw5dT9yx/Ym1ly" +
       "7cC5AClwF/i9mN5TvV05X+kGZWx37Czf879m5uajf/g/7hJC5ePvoYdn2gv1" +
       "13/8cez7v1q1P3a2Zeun0rsXwCIOPm7b/Bnrv1987sq/uQhcFYBb0kGQzYtm" +
       "VLowoQgsg8PIuwjET9WfDhL3EdGLR4vJE2cN4cSwZ938sQIW+ZK6zN8449kf" +
       "LqV8u3iePnB6T5/17BeAKjOtmjxbpbfL5C8dOtLrru+EBZeKXPXdKZTMVNSQ" +
       "0WUFVcQyyC2L2/sVokyRMpntZ7Z/Xy0Yneax5OuZAx6fuQ+P/H14LLOLQ+Ye" +
       "FOW4FNdSl/cx2ktnOFv++TkrYzrgu4rn2QPOnr0PZz94X+lddX09LrzQIXtX" +
       "XKdwCEGh6u+9v6pXDn7vLl/7R8//5g+99vwfVJZ5TQ8KhUB87R5h/ok2X3/9" +
       "y1/94kNPfraKIx7YiMFeNc5+H939+XPqq6bi+MHTsnjkPFkcrjfnx4B0hf/Q" +
       "D1w4iPEquZeJeijS3b1FerHMfk/hcFXdFs0jqZqKrZ2YbsVNj4a4uG93yN1+" +
       "HS2tr/gycmylXP4O6/Yhqe7cOfoqLSrTu5j1gffdf+4mlQiPfcWvffQ/P85+" +
       "//ZDbyEWffrM1J7t8h9PXv8N4rulv38RuHTkOe76ZD3d6MXT/uKGrxTf2DZ7" +
       "yms8uZd/Jb+98MvkvZWIz1m7PnxO3StlkhazJZWi3s/MOeQfSYEzxvrBNzXW" +
       "/Wp7oTC1y8078J1G+f7X7607lw5050pQ7UuUb9ahBj22M6Xbh7EDr/hBMUW3" +
       "dyZ8qBq3jtVm/2V/htHOn5vRQn0ePu6McmztxR/5o09+4e89/+XCxkngclwu" +
       "E4UWnBhxGpX7Jn/r9U89+Y5Xv/IjVZhb6CH/N775eBU4/N3z4JbJx05BfbyE" +
       "ylTfhpQYhJMqMlXkI7RnApgHiqn7/0cb3mKHrWCEHP4oThCXiQSqdlhzMro2" +
       "2ZL4LhoOeWcYGBHSGIyHo1xIWzbD+gQ52s4nrQCexvDatIVsnW9qICj2NZ0X" +
       "GX5OYgSO+YmdCJjTQOYoP+QQz3SQZDtOeX485iRXtIy+GI49kxSYmg3FuZJI" +
       "UR65rrRhYrRZ70GQWuvA0HBZm6l45lHkrMG1oEFztEB9WRN3DGc2OpS7MpeZ" +
       "j4XbjaHXvAbVaUKcuvGTFuM5w0ydLzLZ0Zh0E3IdXQw1gbQ6pMBOSUO0msZ0" +
       "1FgzwlQE0Yy1xqSvNZnlOubtPr9cDDYCyoITvImNBUwe6ZPl2vMW2a7OrtFF" +
       "6DAJbklSSqpDPo9YFyGWrGStaKw9jFElT1xMCJs9ChdFvBeZE8ZS1i1HZDNt" +
       "2el2Nm007fOZQvACNBBJeBB6gb9ZLAO2kwRcQDDbdlCrKXnTWIqRtrUYN7Im" +
       "elMOXVeMduGgoe2YdtAMOcvnmwYajhZrilNaiNDhkpbVFbaNfBt0jJ0/14bQ" +
       "jmcpYRWClNbOxwNuM9lReEaM6jg3yVwxnZKB2UY1D8xJUR61Zg098RlMt6gF" +
       "lec2rdeiTttXPQabIk2GNLjNfCgY6xGFks5M40h3yslT0eZgtoehbkPqr5He" +
       "giMHK0Hkow7Ij4np2jYTOpstbSQTQIyFa7aHRckocI22pZjWfJNM5GwHxx1v" +
       "MtaafZ+aysv1EldZjUbCtZuQumBI/XhDsmOO46kJPEr0ATEPVNpHEMyZ8vZ4" +
       "EbMY7y5FFJ0Z/EYfjS27350PEnrZWM/HYUPCMdZYmaYujqM+ZyjmeuPiQ9dA" +
       "sJZraqhHmBLu7JBsnOyI8Zrg29oyaFNDOk3DFbQSe6HRoQxtl9hjMdPjfIWA" +
       "JIwQRp7zGJvsjLmOQBQeR2aTq0f6YoQl1ARLEMrqLmtKFOdSz6JpTNi1ySXS" +
       "dDcCa80hEgVpdgXC8ybEp+iGXIg1fakFG4iR2vRSJpWO1NrgxMAaZDt9HaQC" +
       "TW3atSkHDcW17XhMZIMsFbk+pW1rYDb0l9xg4fkeJ04ZnmjUQYMIV0y8ynp2" +
       "j0WUBrXwyJ1sTsy1SS9ZxuVpXom7KoguUEPX9MjXVjKeRfE0YogMj2vSdG5o" +
       "U3o8R+3dWq/HWjwC1cGiPg92XJS5mCUOjZo4C9w4ZYa6i2NQqVEKDTrQlMxJ" +
       "f6ut+sqwlVKtZL4FB4FIbDvGMm+hUcuKeWw5MbZR27QxG1OEhZPamoEEroL3" +
       "c2/sZoy88UQ3EucxVl8FtQ03b0xirC9jICyDiaQxTSyweo6fxktS99NdNFCm" +
       "sMHp+CbH2V7KNFE8miSuRThTfz5d9cOaBcKmySB4au9MESXQAaQzWacHBwPI" +
       "iZdzlWJASVF1GVx38WzJF/buZUxie4Lm827cx0crg1MjberNNXizW6ht3K5Z" +
       "tDixl4KrD1vmJMCmLi+q60ycTeojFukOyFzdjtfZKk8Ss8aow76Tq/FsRXQ7" +
       "I6Oj1VsRwfEp5uJsc7ymHHaXRyhKNZZQR1jTdG511LYaDW1TRW2cWaW4lfmI" +
       "0UEWaG+ek1kqkLuk0YvEiPWghrgl5layIDBxKinQZLLiNp7cGWUZOKIQQoYm" +
       "jO5EM9aL1tnMoiN4Js16QUvp5gkDed21Bia96dbO7ZreifL+IrcxokfQSThK" +
       "RLpOzmki3vRqHa67koYcrIsUadTw4XgWN1FMMsDA73Oj2A9NRTQRSmomCgPB" +
       "UN4Co6bkdgf6qM0Q0EZvIiGKcclIjOGllMeKSiuy1ukNVmzPNkgwHzPbrKtx" +
       "W0mAue1cI6M2FHY1GmXXXEsbwKwicETdM40BZpncLl3Xm20xisbprtn2B3ZH" +
       "S5x8t4gUxXYQWAXXdKRYg04dXuSBiQuFavtBW5qgRCrAOse3I2s6GnTbRK/m" +
       "KlAkdHh4pAr9mFpytsAMG4gXFR1GNT4lKE2bjpK0jQdDA7N80rXIxLTBFAnq" +
       "+hxrm4lgLgOrj03YiLWFukRGdbdYWLUgXAjkAsGhcTJs+XKkLGlY76WouBt4" +
       "rX4xNzWdxBaoTE9hgUJyCFXTQYs2aNrSEhtFBGezWrFGRGG2TU5oClF4eTRS" +
       "jNWI6vg9GVooebvLIdo8nwbomnJtCFJq+rTZZMGtPOhL8kJdDgYNiZvhI2lI" +
       "eYuoy28jCJvEu64CqasdCm3kkb/1eqLqTXmMpGPdz8HaZLjaxbXFqO10HbHB" +
       "gQvH7IzQDj7vWWrHZ6Z4FFEblq21481S72fkjO7YU1HyZsMZSCtNE5OXG5Pb" +
       "tvNoybF2HRlvO8KWpEYTf43kK5g3U7dH0bOaT4jmPMRGVleugQrXTki+C/tJ" +
       "4cERdiu2w2RJuO05vFFzEmZUTq/VN0t2x4cz2l6Ova6r1qBgByIbEh8KXqIM" +
       "gnA6k9a4K5OgsUOG6jZYQ6vpOB7S2mysNdDF1qOQprXAqKAOt1xjuuJXudXu" +
       "1iZQvMlSzmgaqscPwHGvYXSnAuri5MRd4uG03YIoaittxU2+7Adzg215ONX2" +
       "kYDCEnmCCkbOrfspDqs5azf45ZAM69tAJpoZlMC0gZotLxgoiOq6Ht33Idjs" +
       "cVMIRrurzXabeQjZkuo1kOGgUI3r7Mhd5fAg1m1klaC16RB27ZVSM8hdVLPm" +
       "EhvlqLziQHQcUTt72IVr9MYzapG84HbTkWUt4XUv0D3WnFAOPXf57YxIZNle" +
       "1mUIIkZd34ON2XqFIrWO0As1JBYV2/CtWWZGuduckVGGCx1C3m3XhNTs4F1U" +
       "IR0oI3fdYi5mHSMiLMJjac3w1v2l2Eq3WN6KOSff4CjZSFvemo8GDbDLYgt4" +
       "SCItd74iNJ+YRr15hEVZlslgyi3cfjjfIlIjWHXNYGq5+GC86xBi3CGMhUjP" +
       "h0202Rv27ME2oCbbmpKqQlPvBknUmQWgFUy41OoLKD1XVo0RJ6aEPEpbdT+S" +
       "5+7GwHgQbxOxt8t7oap26V1rW8RYzhCFfRJNYD6zeuauPpF2ZCjDpAKSXLpc" +
       "E7JbW9Jha+lndaez2rh5UEObtLJZjlGpRTeLMEGt5ehsZRvQYhZPqXUvHccC" +
       "Y+QdWdukqyzhoDRu+dqsxeKN1orsQZjrJ7Guu2ZXCxOtgRNyjEWNcDMbefGE" +
       "0w2CW7I81e5Ne1valb2kS8HgbJpq0QxvjWNEgg1muzVwA/RijwhWncw02I3g" +
       "6WlSLK0bbE01qSVJNGsJlaHjLjOVrB4N1WOYzL2h0tkwdm0g1ZpGZ0Kn9RG/" +
       "BZcry8YoKoNnrXoOx1nDHYRcUwcHmtAljV2GptGMpurNzdCMzUGX0FW0cAy2" +
       "saj5TbTX6BjwWPJUizKR9lZdtnrTdCwnSeFYLDjAQHuz607kFhZkhOm3FvNd" +
       "C5I4YYgp0XSXk5ApUagylogFZXe3nQW2JZA6uGSTQXNMJmQr0wisIWIhNORW" +
       "fiOg4bAFWXK7ASWODdILBLPGnYDPzDXIgsbY38KwtGwSW6wbQYk8NQMZ4foG" +
       "EzrzEYk1wPVsyrHytkEvdxGaDGsstpbcJdqbUV59CLNtWUiiIF/LTWS6Q/Ru" +
       "r/BRDMR0PdN30tTTJwy97SQ9TZrsOARDp9uRqWvT1YjtdrnEaWPtFh+ac9/1" +
       "OnPJ01CHbdpeu8fWeWvEO/Cu25/vQhHhpx1zMlJ7yW7RgJHU36FNB6WxMAx4" +
       "ebZa0iaHT7iu5Y+aUdCKJ4uRU+j2ate0AwlNaxEnNJBlPWo7/TxzN86AZ8EG" +
       "1wZRtA0loaCktWGYIWFrKEG85/f8Rc6aG8Y3ezVlvAG1VJZ3WE/K5U2Tm+eQ" +
       "7LGO4LhZvWUjGJW5BrNKiu86lE9x2Z6jRLc/glEDZkxGaBO4mLUCrDZcmq3F" +
       "ACI8uyU5xSom0c4qMaLNauNZGhXD7XoPHQy37BSubxLfQqMGIw+7gjlRLT3z" +
       "VptZe8DH+oCSawLLIyS/JT3Fgyx42QXbodVndtIAFxdEz2/hNQN1fTNAEBJy" +
       "uvVsSBhLr89N2LHdRzwOiqgB1quPmOFkPtRYMwY7LcHYeKu+ppF8pzvqT9be" +
       "HJmrJOjOEKLWZKBtyoIIHY1jE3EJy+Y6I8gae0lb5aVmHd8FvIS3u2TaYXaN" +
       "TgRBu563jiMcVN1A90NoZHIdD/dxX+1sGbcj8abX9yBP5psqu+q1mubYXhHB" +
       "ok/FCh3Wdzte6UOp75D0BOt106VQIzo1qdn32nCnCDI8voNQEO7ouD/vLFth" +
       "zNIk0Y/8kb+29U5j48xobaAM1VUvW0c0q+YmrLbsxXzRl2pYN0b7XSsa+jYI" +
       "wr2sD/MDBmrUPAcdm8qqw0vdYmVy7fG6ttZEngmmK1PDxS2yqi3hrJ3N6kFa" +
       "rK+t1bLdnG55u4sjk3asanrBds4LTW8HznI0JzdEUERsYBznu+LbYNxdZAuT" +
       "QCaE3GWZlsqMek5/hQxbEkMkeb8IrSJlymoCZIbNxXqbePRyaedw1+6im242" +
       "JnBcRxDk+8rthR97a9sej1Q7PEcXOXYmXFb87bews5Ge2BU72hetfleAM4f/" +
       "J/ZFT5xwAOUZzJP3u59RHUJ95qOvvibPfhK8eLAl1guB66Hjvt9UYsU80dXV" +
       "Kh8dsXGz7P6p4nnhgI0Xzm7PHgO99w7696RvttP3+jl1ny2TnwqBm5oSImd3" +
       "4I/F+9NvtnF0st8zECtpl4e27z+A+P5vP8RfPKfun5fJPw2BRwuI1D1OQI5R" +
       "/vzbRfmdxQMeoAS/PSgvHBO8VBH863Og/mqZ/HIIXCugVhv25bt2DPCNtwGw" +
       "0tQniqd9ALD97Z/G3zqn7otl8vkQeOgQG+ZEe4An9PQLbwNgdZviseJ56QDg" +
       "S99+gP/hnLovlcnvhsBlXwmUe55JPxA7unwM9vfeLtjyKAg9AIv+BanrV89B" +
       "/LUy+Y/lKbwk7i9sfeUY3R+/DXTVoVdZTx+go98qOvHN0DUqgj87B93/LJP/" +
       "WhijXN3P2JwF+N/eCsDyMKa67FHeKXnPXRc695cQpc++dvPaY69xv7s/QTy8" +
       "KHidAq6pkWmePHg+kb/i+oqqVyxf3x9Du+XfBSAEnjjvSLDQx/KvYvVb+yaX" +
       "QuCx+zQpj2+qzEn6KyFw6yx9AbT6P0l3PQRuHNMVXe0zJ0keDIFLBUmZfci9" +
       "x+nP/sg+vXB6WT+ajEffbDJORALPnzpFrO7gHp74RftbuC9Ln3uNnH74G52f" +
       "3N+tkkwxz8terlHA1f01r6NTw2fv29th");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("X1eGL3zz4Z+7/t7D2OLhPcPHKnyCt6fvfZEJt9ywunqU/+JjP//ST732peow" +
       "6v8BVHn8ERwtAAA=");
}
