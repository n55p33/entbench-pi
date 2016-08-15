package org.apache.batik.gvt.flow;
public class BlockInfo {
    public static final int ALIGN_START = 0;
    public static final int ALIGN_MIDDLE = 1;
    public static final int ALIGN_END = 2;
    public static final int ALIGN_FULL = 3;
    protected float top;
    protected float right;
    protected float bottom;
    protected float left;
    protected float indent;
    protected int alignment;
    protected float lineHeight;
    protected java.util.List fontList;
    protected java.util.Map fontAttrs;
    protected float ascent = -1;
    protected float descent = -1;
    protected boolean flowRegionBreak;
    public BlockInfo(float top, float right, float bottom, float left, float indent,
                     int alignment,
                     float lineHeight,
                     java.util.List fontList,
                     java.util.Map fontAttrs,
                     boolean flowRegionBreak) { super();
                                                this.top = top;
                                                this.right = right;
                                                this.bottom = bottom;
                                                this.left = left;
                                                this.indent = indent;
                                                this.alignment = alignment;
                                                this.lineHeight =
                                                  lineHeight;
                                                this.fontList = fontList;
                                                this.fontAttrs = fontAttrs;
                                                this.flowRegionBreak =
                                                  flowRegionBreak;
    }
    public BlockInfo(float margin, int alignment) { super();
                                                    setMargin(margin);
                                                    this.indent =
                                                      0;
                                                    this.alignment =
                                                      alignment;
                                                    this.flowRegionBreak =
                                                      false; }
    public void setMargin(float margin) { this.top = margin;
                                          this.right = margin;
                                          this.bottom = margin;
                                          this.left = margin; }
    public void initLineInfo(java.awt.font.FontRenderContext frc) {
        float fontSize =
          12;
        java.lang.Float fsFloat =
          (java.lang.Float)
            fontAttrs.
            get(
              java.awt.font.TextAttribute.
                SIZE);
        if (fsFloat !=
              null)
            fontSize =
              fsFloat.
                floatValue(
                  );
        java.util.Iterator i =
          fontList.
          iterator(
            );
        while (i.
                 hasNext(
                   )) {
            org.apache.batik.gvt.font.GVTFont font =
              (org.apache.batik.gvt.font.GVTFont)
                i.
                next(
                  );
            org.apache.batik.gvt.font.GVTLineMetrics lm =
              font.
              getLineMetrics(
                "",
                frc);
            this.
              ascent =
              lm.
                getAscent(
                  );
            this.
              descent =
              lm.
                getDescent(
                  );
            break;
        }
        if (ascent ==
              -1) {
            ascent =
              fontSize *
                0.8F;
            descent =
              fontSize *
                0.2F;
        }
    }
    public float getTopMargin() { return top; }
    public float getRightMargin() { return right; }
    public float getBottomMargin() { return bottom; }
    public float getLeftMargin() { return left; }
    public float getIndent() { return indent; }
    public int getTextAlignment() { return alignment; }
    public float getLineHeight() { return lineHeight; }
    public java.util.List getFontList() { return fontList; }
    public java.util.Map getFontAttrs() { return fontAttrs; }
    public float getAscent() { return ascent; }
    public float getDescent() { return descent; }
    public boolean isFlowRegionBreak() { return flowRegionBreak; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVbDWwcxRWeOyeOY8e/IT8k2PlzAknIHQkJEEwBx7ET04tj" +
                                                              "7CQqTsCs9+bOi/d2N7tz9sUhNCBBQlsohfBTClHVhgZoIKjip7QFBVFaKBSJ" +
                                                              "n5Y/ASlUAgoUIgRUBdq+N7N3u7d3u/Tc2tKO1zPz5r33zZs3782sD31IJlom" +
                                                              "aaIai7AdBrUi7RrrlkyLxttUybI2QV2/fHOZ9MlF73atDpPyPlIzKFkbZMmi" +
                                                              "HQpV41YfaVQ0i0maTK0uSuNI0W1Si5rDElN0rY9MU6zOlKEqssI26HGKHbZI" +
                                                              "ZozUS4yZykCa0U57AEYaYyBJlEsSbfU2t8TIFFk3djjdZ7q6t7lasGfK4WUx" +
                                                              "Uhe7RBqWommmqNGYYrGWjEmWGrq6I6nqLEIzLHKJusqG4LzYqgII5t9X+9kX" +
                                                              "1w3WcQimSpqmM66e1UMtXR2m8RipdWrbVZqytpPLSFmMVLk6M9IcyzKNAtMo" +
                                                              "MM1q6/QC6auplk616Vwdlh2p3JBRIEbm5Q9iSKaUsofp5jLDCBXM1p0Tg7Zz" +
                                                              "c9oKLQtUvHFpdN/NF9X9oozU9pFaRetFcWQQggGTPgCUpgaoabXG4zTeR+o1" +
                                                              "mOxeaiqSqozaM91gKUlNYmmY/iwsWJk2qMl5OljBPIJuZlpmuplTL8ENyv5r" +
                                                              "YkKVkqDrdEdXoWEH1oOClQoIZiYksDubZMKQosUZmeOlyOnY/E3oAKSTUpQN" +
                                                              "6jlWEzQJKkiDMBFV0pLRXjA9LQldJ+pggCYjs3wHRawNSR6SkrQfLdLTr1s0" +
                                                              "Qa/JHAgkYWSatxsfCWZplmeWXPPzYddZ1+7U1mthEgKZ41RWUf4qIGryEPXQ" +
                                                              "BDUprANBOGVJ7CZp+iN7w4RA52mezqLPQ5ceO/fkpiNPij6zi/TZOHAJlVm/" +
                                                              "fGCg5rkT2havLkMxKgzdUnDy8zTnq6zbbmnJGOBhpudGxMZItvFIz+8u2H03" +
                                                              "fT9MKjtJuayr6RTYUb2spwxFpeY6qlFTYjTeSSZTLd7G2zvJJHiPKRoVtRsT" +
                                                              "CYuyTjJB5VXlOv8bIErAEAhRJbwrWkLPvhsSG+TvGYMQMgkeMgWe+UT88N+M" +
                                                              "bIkO6ikalWRJUzQ92m3qqL8VBY8zANgORgfA6oeilp42wQSjupmMSmAHg9Ru" +
                                                              "SA6zaELVR6JrVF0e6gT+EbQvY9xGzqBOU0dCIYD7BO9iV2GdrNfVODX75X3p" +
                                                              "Ne3H7u1/WhgSGr+NBiMLgFlEMItwZhFgFkFmkRwzEgpxHschUzGdMBlDsKzB" +
                                                              "r05Z3HvheRfvnV8GdmSMTAAkw9B1ft7+0uas/azD7pcPN1SPzntj+eNhMiFG" +
                                                              "GiSZpSUVt4tWMwmOSB6y1+qUAdh5nA1grmsDwJ3L1GUaB//jtxHYo1Tow9TE" +
                                                              "ekaOc42Q3Z5wIUb9N4ei8pMjt4xcvuXbp4RJON/nI8uJ4K6QvBs9dc4jN3vX" +
                                                              "erFxa/e8+9nhm3bpzqrP20Sye18BJeow32sFXnj65SVzpQf6H9nVzGGfDF6Z" +
                                                              "SbCKwOE1eXnkOZWWrINGXSpA4YRupiQVm7IYV7JBUx9xarh51vP348AsqnCV" +
                                                              "4cuZ9rLjv7F1uoHlDGHOaGceLfgG8I1e4/aXn33vVA53dq+odW3yvZS1uPwT" +
                                                              "DtbAPVG9Y7abTEqh3+u3dN9w44d7tnKbhR4LijFsxrIN/BJMIcB85ZPbX3nz" +
                                                              "jQMvhnN2HmKwQacHIM7J5JTEelIZoCRwW+TIA/5NBU+AVtO8WQP7VBKKNKBS" +
                                                              "XFhf1i5c/sAH19YJO1ChJmtGJ3/9AE798WvI7qcv+ryJDxOScX91MHO6Cac9" +
                                                              "1Rm51TSlHShH5vLnG3/4e+l2cP/gci1llHIvWskxqMxf67ieetMDFqxLJQXT" +
                                                              "MGxvSCu6L5b3Nnf/VWw2xxchEP2m3Rm9ZstLlzzDJ7kCVz7Wo97VrnUNHsJl" +
                                                              "YXUC/H/DTwief+GDoGOFcOwNbfbuMje3vRhGBiRfHBAP5isQ3dXw5tBt794j" +
                                                              "FPBuv57OdO++7/w7cu0+MXMiRllQECa4aUScItTBYjVKNy+IC6foeOfwrl/f" +
                                                              "uWuPkKohf8dth4Dynj9/9UzklqNPFXH8sIR0SUSaK9GYhUnj6sufHaHS2qtr" +
                                                              "f3NdQ1kHeI1OUpHWlO1p2hl3jwlBlpUecE2XE/3wCrdyODWMhJbALGDFGZ6C" +
                                                              "C3WajQP+anG9n8NImaIVCI5/tovRQIfGIhbWI43w2Kpf3nZi3fTm1Z/Mtyez" +
                                                              "SF9XEHbtr3/V13dinSw6F7N1T/B158EK+bXU77itozyn55xDDZpjAzx32c7h" +
                                                              "LmGf2/7H8ADIIBsA44A4dpOSonHMRlBQO/wY1/HRUmfk7fYO0D8fUls/OuNn" +
                                                              "3xDYzfNZbU7/h88/+tzto4cPCXPF5c/IUr/8qTBpwx1wYcAu7kzqp+vOPPLe" +
                                                              "21suzM5RDRbdwsBmMlLjDnSE3/1WcYPjtbH8Ga6H56g9w0ez7v987v57BEEv" +
                                                              "Ftty7Koddhsk3u+iAG4BC2PSgK6rVNKKU3NNV/G2U3I9CO8hUEhisdByxyn5" +
                                                              "ILpS1n75uhc/rt7y8aPH+GTl57zubRk0Eo6tHotF3Fy8ceR6yRqEfiuPdG2r" +
                                                              "U498ASP2wYgyGKO10YQINpO3idu9J0569bHHp1/8XBkJd5BKcGbxDonHQ2Qy" +
                                                              "BCLUGoTgN2Occ66YiJEKKOq4qqRA+YIK3AvnFN9l21MG4/vi6C9n3H/Wwf1v" +
                                                              "8IDA4EM0FgY7XbYhdBUPdrA8EYulhSGEH6lnBsMi6M65z3V86JGAed6BhQiN" +
                                                              "eVpkCQCGxogVVmw3RMNsXlmHCUmeT+BHR04QevcLp//p4A9uGhGOIWAb9tDN" +
                                                              "/OdGdeCKt/5RYHM85i6yM3vo+6KHbpvVdvb7nN4JfpG6OVOYREEC4dCuuDv1" +
                                                              "aXh++RNhMqmP1Mn2Uc0WSU1jSNlHKhUre34TI9V57flHDSKvbskF9yd4QwMX" +
                                                              "W2/Y7d5vJ7C8vdWJtGfivCyDZ4FtQQu8xsfTObGkUKRIp8ZokpoNb/34wOeX" +
                                                              "7zkjjKHexGEUHVCpc/p1pfFE6KpDNzZW7Tv6XW752aGvFLbMyyVYLOOmUIav" +
                                                              "EYiULX64hHGHokmqJ2KeESAsI1Wtsc51Xf29m1p7NnELd9YOt9+rvs5+v10I" +
                                                              "TbPNrbkINPiyJ+s3rw/SC4vvYXFNEYX8WDAyRSi0oXPt2lh7MY1uGINGC212" +
                                                              "CwM04l7iR2PWyI8FI5OFRu1da4upc9sY1Flk81oUoA4X+cCY1fFjwUilUKdj" +
                                                              "cyxWTJ87/nt9eEQwC56TbGYnFehD+Ms9xdWAJHOyYeoMPAaNe3SoDhgWomSm" +
                                                              "G7lNwSX8vSUKfwI8i20ui32Ef9DZyO4rlNGPGpyBqSQHWTEpHypRykZ4lth8" +
                                                              "lvhI+UiglH7U4LsGdMb0VDExHy1RzNnwLLUZLfUR87eBYvpRMzJBpYmiWD4x" +
                                                              "BiyX2WyW+Qj5dKCQftSAJaStEBkUE/OZEsWcC0/UZhT1EfP5QDH9qGHNSaqS" +
                                                              "1FK2pN71/0KJks6DZ7nNa7mPpK8ESupHDa4KD8HXU7919GqJos6BZ4XNbIWP" +
                                                              "qEcDRfWjZqQiAQFXNqHa6BH0L2OY/VNtVqf6CPpOoKB+1DD7KCjeRnKirR5J" +
                                                              "3x2DpCttXit9JP17oKR+1LCcJEv2WU4fjcFIV9mMVvmI+WmgmH7UkJjGqa+c" +
                                                              "n5UoJ+7Wp9ucTveR88tAOf2oIXHFi48emoSUYo1JJX4HIXnk/SpA3kyxhI7/" +
                                                              "lBPPfZOLrytzIpgfN/pdCfJDvwNX7Nsf33jH8uzZxblgr7DVL1PpMFVdQ9Xk" +
                                                              "n4NBEraBX4I6Gc3rNde//XBzck0pNzBY1/Q1dyz49xxIHJb453VeUX5/xd9m" +
                                                              "bTp78OISLlPmeFDyDnnXhkNPrVskXx/mN74i1Sq4Kc4naslPsCpNytKmln+E" +
                                                              "uSA/xz8Rns32vG72WqNjOX45vh+pJ3t3neOcgaOGpvqn96FpWNSAVViUbZDM" +
                                                              "pCJQ9JwVTRjWlXjOqkO1/48zAKwPVeYDhN51m63lttIB8iMtDhD/eyazz26k" +
                                                              "ERZBTx7pgKKHQuBh2h83cJwWBGCI4oSaIFNTNIXxm2dxnRya4UA2Zxwgm4pt" +
                                                              "uAcbtt65/Pq/h8yPNEDdFQFtK7FYBlAkKdukG8KiuCU6UETGC4p5XAXxs710" +
                                                              "KPxIA9Q9J6CtFYszGakBKHow4ioKRst4gYH7hmlrZJYOhh9pgMKxgLYuLNbB" +
                                                              "nglgrOEJUlE01o8XGnPhsWyVrNLR8CMN0PiCgDYMEkObGKkGNGKQhxXFYvN4" +
                                                              "YYE5etpWKF06Fn6kAfomAtq4rhJsQIBFp5PuOTgMjBcOeHY4YiszUjoOfqQB" +
                                                              "uloBbWksNEbq0HPCrtOal1M6cOjjuURGbZ1GS4fDjzRA5d0BbVdgsdNeIvlJ" +
                                                              "q4PFpeOFRRM8O22FdpaOhR9pgL7XBLR9H4u9jFQBFh3urNhB4urxDC8utdW5" +
                                                              "tHQk/EgDtL01oO02LG4U4UVHXtrtQHHTePrNXbY+u0qHwo80QN2DAW13YfET" +
                                                              "4TdbnXzZweGn44UDnvhdZitzWek4+JEG6Hp/QNuDWBxmpBJwWEuLAXHfeAGB" +
                                                              "dzW7bW12lw6EH2mAso8FtD2OxW8YqVesjiIHEw4ej/xfbnDB8nLffOIN+MyC" +
                                                              "D8jFR8/yvftrK2bs3/wSPzjIfZg8JUYqEmlVdV9Rut7LDZMmFA7iFHFhyb/+" +
                                                              "CT3NyPG+H6FCnoq/+FT9QfR/lpHjivVnpAxKd8/nYOv19mRkIv/t7vcimJrT" +
                                                              "Dw/V+Iu7y0swOnTB15fFXT9kma6LUXGnmxEJ6Gw30PzMaNrXzY/r9GdB3qkJ" +
                                                              "/9Q/e8KR7rY/lDm8/7yuncdOu0N8DCmr0ugojlIVI5PEd5l80LKCj27co2XH" +
                                                              "Kl+/+Iua+yYvzJ4n1QuBHWOf7VgkJlIhA21jludLQas598HgKwfOevSPe8uf" +
                                                              "D5PQVoJx4NSthbffGSNtksatscKPzbZIJv+EsWXxrTvOPjnx0WvZa+ZQ/lcF" +
                                                              "3v798osHL3zh+pkHmsKkqpNMxIuGDL+WX7tD66HysNlHqhWrPQMiwiiKpOZ9" +
                                                              "yVaDZizhPwFwXGw4q3O1+CktI/MLP+Mr/AC5EiyWmmv0tBbHYapjpMqpETPj" +
                                                              "OWhKG4aHwKmxpxJLfrm6OoOzAfbYH9tgGNmvHMtvN/gybs+tbu+HcaH3+Su+" +
                                                              "ffAfAv4QTwY0AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV7e9DraHmfz9n72WXP7nJbFtgLe5aw63BkWbJlsZAiWVfL" +
       "luSLbMshWWRdLNm6WRdfBJsA0wYaJpSmSwrTQOkMlDazQNqGadOUznbShGSS" +
       "ZoYOvbeBoZ1JUspM+COkU9qmr2R/l/Od7/v2nN1Tz+i1/F5/v+d93ud5X/nR" +
       "i98v3RFHpXIYuNuZGyRXzU1yde7Wribb0Iyvtto1WYti02i6WhwPQN5z+tt+" +
       "9fIPf/RJ+4GLpTsnpddqvh8kWuIEftwz48BdmUa7dPkol3ZNL05KD7Tn2kqD" +
       "0sRxobYTJ8+2S/cea5qUrrQPIEAAAgQgQAUEiDiqBRq9xvRTr5m30PwkXpZ+" +
       "pnShXboz1HN4SemJazsJtUjz9t3IBQPQw9357yEgVTTeRKXHD7nvOF9H+FNl" +
       "6IW/+dMP/MPbSpcnpcuO38/h6ABEAgaZlO7zTG9qRjFhGKYxKT3om6bRNyNH" +
       "c52swD0pPRQ7M19L0sg8FFKemYZmVIx5JLn79JxblOpJEB3SsxzTNQ5+3WG5" +
       "2gxwfcMR1x1DJs8HBC85AFhkabp50OT2heMbSemxky0OOV4RQAXQ9C7PTOzg" +
       "cKjbfQ1klB7azZ2r+TOon0SOPwNV7whSMEpSeuTMTnNZh5q+0Gbmc0np4ZP1" +
       "5F0RqHVPIYi8SVJ6/clqRU9glh45MUvH5uf74rs/8QGf8y8WmA1Td3P8d4NG" +
       "j55o1DMtMzJ93dw1vO+Z9i9pb/j6xy6WSqDy609U3tX5xx/8wXt//NGXfmdX" +
       "582n1JGmc1NPntO/ML3/m29pPo3flsO4OwxiJ5/8a5gX6i/vS57dhGDlveGw" +
       "x7zw6kHhS73fVj/0K+b3LpYu8aU79cBNPaBHD+qBFzquGbGmb0ZaYhp86R7T" +
       "N5pFOV+6C9y3Hd/c5UqWFZsJX7rdLbLuDIrfQEQW6CIX0V3g3vGt4OA+1BK7" +
       "uN+EpVLpLnCV7gPX20q7T/GdlIaQHXgmpOma7/gBJEdBzj+GTD+ZAtna0BRo" +
       "/QKKgzQCKggF0QzSgB7Y5r5gtkogyw3WEOkG+oIH41/N9Sv8/9bzJuf0wPrC" +
       "BSDut5xc7C5YJ1zgGmb0nP5CStI/+Mpzv3fxUPn30khKT4LBru4Gu1oMdhUM" +
       "djUf7OrhYKULF4oxXpcPuptOMBkLsKyBwbvv6f5Ptd7/sbfdBvQoXN8OJHkR" +
       "VIXOtrvNI0PAF+ZOB9pYeunT6w8Pf7ZysXTxWgOaAwVZl/Lmcm72Ds3blZML" +
       "57R+L3/0j3/41V96PjhaQtdY5P3Kvr5lvjLfdlKkUaCbBrB1R90/87j2tee+" +
       "/vyVi6XbwXIHJi7RgEoC6/HoyTGuWaHPHli7nMsdgLAVRJ7m5kUHJupSYkfB" +
       "+iinmOv7i/sHgYzvzVX2deB6116Hi++89LVhnr5upxv5pJ1gUVjT9/TDz/77" +
       "P/gTpBD3geG9fMyV9c3k2WOLPe/scrGsHzzSgUFkmqDef/m0/Dc+9f2P/mSh" +
       "AKDGk6cNeCVPm2CRgykEYv4rv7P8D9/+wy986+Kh0lxIgLdLp66jbw5J5vml" +
       "S+eQBKO9/QgPMBYuWFa51lxRfC8wHMvRpq6Za+n/vvwU/LX/8YkHdnrggpwD" +
       "Nfrxl+/gKP9NZOlDv/fTf/5o0c0FPXdWRzI7qrazgK896pmIIm2b49h8+F+/" +
       "9TPf0D4LbCmwX7GTmYVJulTI4BJo9PQ5G5bI8cBsrPZGHnr+oW8vfvmPv7wz" +
       "4Cc9wonK5sde+Pm/uPqJFy4ec5tPXue5jrfZuc5CjV6zm5G/AJ8L4Pq/+ZXP" +
       "RJ6xM50PNff2+/FDAx6GG0DnifNgFUMwf/TV53/j7z3/0R2Nh671GjTYFH35" +
       "3/6f37/66e/87inGC2huoBUziZxICsSVPEF3+lRPSreB/cOu8Diua8Xc09aF" +
       "A35O//Xud7752eyrL+6GnWrAw5TKZ+3lrt9O5gbkqXOM4JGX/zP2XS/9yX8d" +
       "/lQugBzevYf6//pcuG8C17v3+v/uk4u8qPr6pHT/ccu8022yKHvPYWdX8rY/" +
       "diOdveaos45WlDGnifOuaRC4puYXoKEi95kivZp3XCj0jlA7Tx6Lj1vsa+Vx" +
       "bCf8nP7Jb/3pa4Z/+s9/UMj92q30cQMFkO2U8/48eTzXtTeedE+cFtugHvqS" +
       "+L4H3Jd+BHqcgB514GJjKQKOcXONOdvXvuOu//gvfvMN7//mbaWLTOkS0C+D" +
       "0QrPULoHmGQztoFP3YR/6b07Ia7vBskDBdXSdeSLjEeut9nifgbE0212nj6R" +
       "J09dbwnPanpC/Bd3jvhwPbyr6Fo9Z5J+Mk8GRVEnT5QdevmGiO7qPlz8eu35" +
       "RozJt/xHDvTh/yW50498939eN9uF3z/Frp1oP4Fe/OVHmj/xvaL9kQPOWz+6" +
       "uX5XBI5HR22rv+L92cW33flbF0t3TUoP6Puz11Bz09ytTcB5Iz44kIHz2TXl" +
       "154ddhvlZw83GG85aViPDXvS9R8ZNHCf187vL53w9g/nUn4nuJ7cT/+TJzWn" +
       "2J/tlDmHdJUHR6WZGT303c9/4c8//NHGxdzd3LHKoQOpPHBUT0zzI97Pvfip" +
       "t977wnc+Xrjjg653G48nivRKnvxYMb+35bfvAN46Lk6LuRF2fM0tEKNJ6V6i" +
       "zbPic/0B0RsUmnek04VeWS+nV++/nvWVPesrp7DOb2Yg+0J+szwPcp4UByjv" +
       "AOt9O6wdnqLa9Glgo1cA9qk92KfOAVsszO3Ngb1nB5YWqdOQZq8A6dv3SN9+" +
       "DtICzYdvDumlHVJGabdPg/qRG4d6f577CLjesYf6juugloqbv3o6QrCpvCeM" +
       "ggSsTtM4gHdbEoSHhvEYrp+/SVxvAdfTe1xPn4Hrr5+BK7/9hQNAd0TOzE5O" +
       "g/SLNwnpreB6Zg/pmTMgffpGIN05DZIk8E7D9JmbxPRmcJX3mMpnYPrbN4Lp" +
       "dte0TpXS51+BlN65R/TOMxD93RuSEti+mv6pmL50k5geBxe0xwSdgenLN4Lp" +
       "Hs11Zr63h3Vy7X3lJmE9AS54Dws+A9av3QisS/mjGs48S9G/dpO4HgNXdY+r" +
       "egau37gRXHdbYMuQb5lP7JaLUR46b5Q8JQ+TY1z+2SuYemQ/CnIGl395Q1Of" +
       "cyGSJIpPI/PgecPkKXOYHCPzW6+ADLofBT2DzL+6obWlxfoZa+sPXoES1/aY" +
       "amdg+taNYLrLMM8E9W9uElTudLE9KOwMUP/pRkBdzp/V9cwZ2DSTkakt8mzu" +
       "BLj//LLgis6A4wfeqHoVu1oc9b57c27/jXNXv3LwHGBoRjFAdGXuYkV7cKw8" +
       "tuvcPWw/ARK9YZBgq3v/UWftwJ89+/H/9snf/2tPfhvsc1sH+9y8tg2kNfzL" +
       "P3rkvfmP790cn0dyPv3ikWxbi5NO8TjINA4pnTgO3+4Gr4JS8roGh8Y8cfBp" +
       "D6fUaK1veiNT2pqS2jAhftBYVGU3IxY+z3UXLZpekxuMHlTQZI41u8tB3Izx" +
       "8lRyIKMqYkmGx4otNkmy68aBbZGDpssN7dkk4IW5E2JdhhwymkD2W35NhYi+" +
       "qxCzQOFnPYU0lmURE5EUM5AUGujVRJDgTM5qEYJkkxjBGtWYQmC+5QaepvGa" +
       "gxEGGSkO1osid7Ftb5JE2U75andYhSxOmuAdl8EQLaFCeSu7fCYwi+mk4zlc" +
       "NxyisGppw27FqXjaQKik/VTkKyO479QiinbFSqTiHaWeSa5AL+OYr9Y5VuCm" +
       "E34SZEof3U62i6ZWUWoYQauauiVbLh33p5ZSTRoDnmEWiDGfGxNsWU8wV4tZ" +
       "S0BHykaxTaxHLkeB53lLkVXViB3NaW/ERss6X/eXbZrP2pzQSuMli7YzdTnj" +
       "+VqCj8v4YgyvkZHedbx+uPQ69boJK51k3Kt6jZ4TGqNoOpwst0kot/uM1xm2" +
       "F/UOzuvbTBAJoD6dDrysQ91mXUtDd1GH68O14drVEGmRPZ6eerUu7vQFTYkD" +
       "K6zN21STHHfgsDKYYZNMxwOh3U2UFceEhgiJDD7GAyADPGS0npkw+qjbnc3Y" +
       "gTxrKuFMC7TpmEWzgdkrB7AnbUzNWfaXQaZ1cHgmKK6oep4KOet41FpUlx23" +
       "JrlzUuZb6cQNPYBu0G7Q4nZVi9SFMFwsqcigjXEwojk4kJpuN+AnjrqIqRTM" +
       "o9ANYmXimZK7lXwVopGAEPoDJeyK9bk7orNuS1g4VIdkhpWw3RvPCbzddY1W" +
       "OZzNmuo8RtZcT1uL/V69v4i6VttoDyI4rnQ1qMURs4U66mvJJraao0noeuZo" +
       "LMuZahgTuIwpsJfY9EyYoHBvpFjokmejLS2PuySlhBEhkhI7bGHNSVh2RGyN" +
       "9oha1TOzZVvu1nRTgqxF6IiyM69nDjSYSBzRcoceZLHNWS1aDKq2tmovOhth" +
       "lhmKT20b2cBf1rPp1PNbrETaYWqwm86ET1YMn5UbaZWrINYA7wjzpJVq26je" +
       "G6jKtBqH6w0Tmmp96TIDdT4w+/3JoG1gbDVbtVqcIwu9YJj04kFTTbeDeYus" +
       "DceutGpMeToiaMLutabraLRoyys77rPlwYpVO93ObGF2ZiOzrAwaDbHcmfIL" +
       "qe4sNHfUaylZF696yHLZbgxJtZER4kzqzSyiHpiOG6LVdbc/T0Ov0/cIbob3" +
       "0j5RzzS6PezVW9GQqZj12aBMT7srFd+w2ZKUlIrR5FUKIyXcGVZZIxKtoUSN" +
       "sdoYCUUT4bAUhkb2rM9GZZF0Ou0Z49IdPllPbGbGLBhv0Vtn9CzccLFuKxlr" +
       "dEiXioWMjCq1CcKtbLNnrfxhgzW8fmdAEIs1TsJWgpUrqRZDWkZhoS6LcF/O" +
       "/GReNkW74zAs6/QnYV8ZJmgy6qw9qU/Wt3B5qRCGXfMJeBZ5MbVuIW2YVTQS" +
       "gubJhlMDeBCs8QFtLjRJR6tdZFJb88oUF1HTaYSdeYJu9FU6noZoryWJkM83" +
       "0hYq1LsrMsYNHZ2LyGpsRsxGg8xGGfdtD5mG2TKSq5X+1oQbZMsM1kg1Zsb+" +
       "vF7rD7Owa9U53B9mLGtRTH3SnzaFtUTD5thfSJPRKOJFdtwPCVTtpaHTHXoY" +
       "rw6xFqls8I0W2TV4JSNog4iXfnOI6ukEj9rzFcbAacC5FMtJGguckjVjGzxs" +
       "opA29hFkNSRqCDDdgTFCtqtJH07l9YBKpoQ8ZHEV06YDemkj5RQxRHyNogaW" +
       "+MLU7qFtZ87EGwAIIlsdXicbtYk8HSN+Nu92VrYvVjlPWHc1neM7WKvWAjJ0" +
       "gflt9taj8oAnoJpIKmVimEiNUVfGhqQgiMCpjBnbgp2aDsUEB+NqS4KbdstL" +
       "2BYC4QSN4Y3RiseW+qocbVvURurrYxzucFK9qek43PNq8KDvcn2bq63aPotA" +
       "qFl2q7oMzXQHdl2OX43ixWbZ2Vh1zDHNpEMxy0271R0POuxm1W+m9XZtioi+" +
       "BQ1H6+pmo9u0DFZFz8MncdJ2s4xqYYvmMMNGAY4NI18RubjlqmOlCXEQNVg7" +
       "plVmqYCVGF1ai1NrmnbmJrLq2Szp9CyOJOSaE3cRY7yuJWSC4eickcl0VcMk" +
       "QyqXMWiN6Wml3Bl3nJ7rdummhmpKX+eTAanOh4K4LfPNuhWYkrWOXMhKR6m8" +
       "EICLbhiJjVJbf45DuJIt3KUoM2OuEfO9Sl/pawLOqrYCFCxOLU7j+tVlElmI" +
       "aHThBWfysKSE3MiV4LBqu8h87ZJuqJg6XR3TELJuRsZWokYduzUl2izFsJN6" +
       "s4mMtHlXLms+i/sNkfc0ftjka1ASrHpd3mJ5ezriUWRdFUIL8ScOMHAePIE6" +
       "ydbM+sAB0dw0iRBoCCOG4/fXdQYT4QFEwrUGLZSnYwXDnCTItn6ttqGoSTgn" +
       "sg1S1TG77bFWFcK4BkHxPBkTKEqgRij1A5/r9FyyK0FrFYa4nuJZC8xSpQrV" +
       "sBQ3hqRU9JENpWaWOJkqGGQ3GlA5yZIA1eXmWGaAtvFKBDWWAxKYXXit6kSK" +
       "LbJlWF5Jstw2q3CcZp1aj+pNjXVMeh23Paf8Po1A8EhX5Xky5RqsVudq9Rm+" +
       "rpgZtsIbGJhUkqZXTJJsMSEwDDteIGnZIViUbFbl/kyoR0NREBREFIcQW1UQ" +
       "Hm9KDVuhbSc2yO0G0OfbYR/2sVpq61CUYNuGJnNlduDWsCyd9hYVOqgnXJAw" +
       "CLNt6Gavvu0tactJZYOtRgqKN4i+XF2rsy0LtmEVtcuLoYQ4Roq3KrU6PuW4" +
       "EIYaY3LRMmqkoLPTDQUE2a12t2SzrbDBYCZWJV2v11WnRQuCtESXyx5RVnkB" +
       "IVY+I+JuFe6wKLRy6k3cRzhotLbgVYOnCJTuVJiZio2nqm2QimxERINWU9fu" +
       "szRXd30y7jj1Tr2WIcNGvcUSplEn7a4jmsNw0ew22U0wGw69NdLriPHY9bim" +
       "4pmDMsn1KmjXXOntEIJClMBT1mYlfkRM8YQSIclgDbMpJFCtp3KdRs2pbzvI" +
       "KijXwbYvXA2N1RTzRbRlhWxdGkpqj6abqNFMU2oFa2O7XO4BH7H0ZLjjVxW9" +
       "Muor8LwvupxgK5GJoAMeH9Ywy+WovrCaxgsG3xpod90Zj6qQihm1FdgwNFbG" +
       "qJWwlrNqbqkJyiTdbtoAW5CBNGUXitDjw8YkWISBOIUQdC2ZYyxbzOcCZ25Y" +
       "WuGGzVCHQji0GLouhJSYTUbYYFUfj7BaVWNXTHva2W6HaluSPIXXVrTqKO1x" +
       "HbU5lgsW3rJVFUy6T8Q8PEpivQaPrSruwSEm+nTbwFUpwcvRKq6VV3CFH0xl" +
       "MZoueLCL2bbKMRKtoX4TXa3UMSPS6rgxoohtr+9UgrGcVF0b66hwygK/06zC" +
       "1ea6U0FdzOlV5dGWbzB8TWJ6KWxoaBrqeKzCjLtowIESEOi4rDdV2GLma8Vx" +
       "FcGY69vNaNBqYJCf4CbdXTdr9cGUVX3GtKlyJ8Y3xohocdJWNYOOTGhgm9AP" +
       "KHsG9tt9j8Vccd0fN1Z9RbDWfMOpVlIHqdIWTk22Ehq5Iiuz4ZZc9rvcaECH" +
       "3DbsbRcT1E3shruy+bLizFwOU9B2DDYT08qQojfcFu5lor9ut5VJ21J6Dcwk" +
       "1VXY62QtMlQ9Z0ShG9LZjquj7ajcndcModm1kj7R0voJTS4UGpImdDzSmxVI" +
       "mdgDmLbkWpfi8CXLiX1t2YcZoRqKGAxVhNYirlMToIEa5smh0KD7achRGipQ" +
       "DQ4YPBzG2WUriOvkBB2LU34kL2md6lmj+WTZdYguMxaXnFYnuUq7KqnQUEyG" +
       "S6velEMpEMgyTFGY0JybPV9wol6thWyqVNhMkrGT4C0ZxgKhV4bbTb1Fr6oj" +
       "BbXmOsMPcXDOWHl8eeTNPCCXRWvOLrWy7teUoFXGRiGe6oOV2Ws0EkKyqgE/" +
       "5hgHbZhe0FfApqjVGqMcD/YkENiLIIvtxuYxyCVl2ZpI7WibZHw4s0QoNJpW" +
       "i1qtxTEmxhaCzLlGmk02U3cWYdSwDcthhxkaXXy88FGRpCONHKN8ndWRSDRM" +
       "CBqTmb6ohGJGArvehY1thuKbDc+1pmgNGZrKuAZtDNybDkKsIfH9tit7JkNt" +
       "Kd8f2wtRjobxYryBPBFDHbi/RAUd9bXYleNmKG4TwXP9Mg02stAma/T8GKmu" +
       "WKw6WopzaYzWVnY5bCEJ4puSPtMkNlwtfbzOhCOxTwyHjjKdUJ2w2erirfVw" +
       "0JuP3PFcWi4kGELB3llYy0NTpWyxBnt1xE0Snmw4nYSyKcjcallWrS/o3oQc" +
       "bLBwJghcNyXtqt1A9NZ6RLJNHg36Gs+IA5Efb7yqsfF7Ww1ViOpks555aJik" +
       "hD5NknoNkpfAl21lkaYMpsskAsaopEssBCNdsA3BSZtKXaEHbBMNa2NivIkx" +
       "uCLIG57AAex6M2HUOGO1BSlwwRp1gJbECTpTOcz23GjSUiXbxsNZR9jM2mra" +
       "FqekPwPzJtEtxaUrcNAYs75sx6PtMBLbvUazI1Zkpzmj1A69ABZPWLAiK3Tt" +
       "zZhRVyKqqnTNTMKRwFTqjF9fEFbgEckSjexW3OVJJqzJqTSYdeakLpmciqpO" +
       "nCnzQLKWXTJ1A3I6WsQiPV1WOLkZJZLmwp26Ls3nqdJjpxOY7aMWNc/AWc2o" +
       "kNOhMYsN0eRXbmuJyuAcBWxUr9OQqlXGCDXJ7gFebWxMtns4h6b4nOmSjI2k" +
       "kWiTaBptqGYjTYxRLeG6C4ieUUkb0JUq1TaLKqgy5MZJlHQ5bmDKkQh8XDmt" +
       "LLl10Kh0xSpFjGBEtegBOjCm/jibrE3W");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("R1GF8le2MXGSbGQu0HKLZutcCHXFlBqRGy8kwcTTaZsYc5ZJsKSRjbDpCK66" +
       "6zrNVT0iDhpMQlWlzaihLodmPHd4jl6j5hzaWFOfIht+27IkHpzotk2qMWd6" +
       "DWi7spJIqE5jBFqDQ9CctyazRktRl7TnDo0hOMAlWJuadDyGwByGY+ztFCo3" +
       "B4i4ldkyV2eafrCEyswA71o9yA25ubMa+iGxEYwG5KvSCsa93oJfQQm20h2v" +
       "FQ2oNTQs8ym2rcRryR+AzZzFjAf4wtPqbQVoirehW3V2jVTkrKOJ0ThToQhn" +
       "DRJZLloQ3gWnI6GHRSrkUl4DwraprxtSWhEbVNOLKuksmLv8kK/JtFFzG5U2" +
       "sHZVTA+qY05wyxAYVytv1VXWQn0YLCZuJFnYcLZoubxNVOG5mxrtrhbX8AY3" +
       "E9aWZK76stlILaomd4dBa4OK/cSeWhbbF5NFrAH/KcjZdMK3VmVg3sebaAD2" +
       "gXN/UxmtJlp50oVcnUFW4CwSxFwbyYClWHBeLCyWodjZ8ClLtcujMZZQ9Tq3" +
       "jcEeYmmPIrnbcdaOI4TSBN8ONWriZLa8ZtZjdo0uEQkuNxcJD3XacrkTQUSz" +
       "RjvbkeetKgk55VQtnIedZUgP5Lk0sgUW1bi14G3CTattRV5dCqSMsKYqhycz" +
       "VvRWXCdZidBsO43LyTQtc7rGIeV+WrYswiJWaHewVisEQbwnf4T4w5t7tPlg" +
       "8aj2MEh67mJ5wR/dxNPLXdGJKJXic2fpRGDtsQfbRc2HD6JjotJbz4p9LiLD" +
       "vvCRFz5nSF+EDwKjsKR0TxKE73TNleke6+p+0NMzZ0ecdIrQ76Owj2985L8/" +
       "MvgJ+/03EWr62AmcJ7v8+50Xf5d9u/6LF0u3HQaBXBeUfm2jZ68N/bgUmUka" +
       "+YNrAkDeeijZInQoD95S9pJVTvsH54Fz/i94x27ui7KjCKALRxWQvMKF+05U" +
       "OBYidCGPtLpwF5iEGBy5tWjm+Kc+B18FjnGoRBfuvpk4ojzjwu3Xss7/q3rf" +
       "nvX7binrgz8mHiv+S9DWydX8D7SrDEh6pm+Y0f5NiIL8m88RzGN58oakdJ/j" +
       "O0kRpr6LPb9wtJguvPFVyOG1eWb+l2e4l0N4a+RwnMPT55SV8+QK4Dczk0EQ" +
       "7ua+0Jkjfk+9Wn5PFJR2n+Wt51c7pyy3fhcqSel+wK+X/0V9KkP41TLMrWG0" +
       "ZxjdeobEOWXNPHl3UroMGJJFaMepFN/zaik+Dq54TzG+9RQ755RJecIlpdcA" +
       "im3TOn0O+VdLMA/6SfcE01tP8JwIzQt5hOaFATC/gCB/FHhyRO6mQjZPI5dH" +
       "Fa735Na3npx5Tln+z+mF9yelB3ITA2wucU0UyxFH7VZoaLbnmN16jstzygo4" +
       "7l5Drw2HOSLovVqCj4LrA3uCH7j1BJ8/p+xn82STlO4FBJnT42oKl3755SDu" +
       "4mqOhLK9Fc7zg/sRP3jrhfLxc8p+IU9+buc8mTMCdAqp3P9yGHcBOkdS+eit" +
       "MGbP70d8/tZL5TPnlP2tPHlhZ8yIo6CaI3KferXk8ii/n9mT+5lbT+6L55R9" +
       "KU8+n5QuAXKUeRq7v/Nq2eWh0B/as/vQrWf3D84p+0d58iI4RDoxc0ro0RHJ" +
       "L9/UKwRAFw5fOMzfnnr4ureXd2/c6l/53OW73/g55d8V79wdvhV7T7t0t5W6" +
       "7vFw+mP3d4aRaTkF73t2wfVhQeafJqU3nfkGJDjM5F+F/H99V//rSel1p9VP" +
       "SreB9HjNl4AzO1kzKd1RfB+v95tAT47q5YFvxc3xKr8NegdV8ttvhIXkrg2n" +
       "2r1/sNkdaB4+pjW7c/xDLzcPx07kT15zji7eMz8486by/s2or36uJX7gB/Uv" +
       "7l4e1F0ty/Je7m6X7tq9x1h0mp+bnzizt4O+7uSe/tH9v3rPUwdn/Pt3gI80" +
       "+Bi2x05/U4/2wqR4ty77J2/8tXd/6XN/WLzF8P8Ah7QdrgBAAAA=");
}
