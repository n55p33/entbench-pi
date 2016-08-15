package org.apache.batik.css.engine.value;
public class RGBColorValue extends org.apache.batik.css.engine.value.AbstractValue {
    protected org.apache.batik.css.engine.value.Value red;
    protected org.apache.batik.css.engine.value.Value green;
    protected org.apache.batik.css.engine.value.Value blue;
    public RGBColorValue(org.apache.batik.css.engine.value.Value r, org.apache.batik.css.engine.value.Value g,
                         org.apache.batik.css.engine.value.Value b) {
        super(
          );
        red =
          r;
        green =
          g;
        blue =
          b;
    }
    public short getPrimitiveType() { return org.w3c.dom.css.CSSPrimitiveValue.
                                               CSS_RGBCOLOR; }
    public java.lang.String getCssText() { return "rgb(" + red.getCssText(
                                                                 ) +
                                           ", " +
                                           green.
                                             getCssText(
                                               ) +
                                           ", " +
                                           blue.
                                             getCssText(
                                               ) +
                                           ')'; }
    public org.apache.batik.css.engine.value.Value getRed() throws org.w3c.dom.DOMException {
        return red;
    }
    public org.apache.batik.css.engine.value.Value getGreen()
          throws org.w3c.dom.DOMException { return green;
    }
    public org.apache.batik.css.engine.value.Value getBlue()
          throws org.w3c.dom.DOMException { return blue; }
    public java.lang.String toString() { return getCssText(
                                                  ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1ZC4xUVxk+O/t+sQ9ey2t57ELLa6a0pQaXYtllgaWzj7BA" +
       "4tAy3LlzZveyd+693Htmd9iKtk0J+CKIlGJtMRoaWkKBGGs1lQaDWmqrCZTa" +
       "1qZUq4loJZaYohG1/v+59859zGPdRJzknrlzzv//53+d7/znzMlrpNTQSTNV" +
       "WJDt0qgR7FRYn6AbNN4hC4axCfqi4hPFwl+3Xe1ZESBlETJhUDC6RcGgayUq" +
       "x40ImSUpBhMUkRo9lMaRo0+nBtWHBSapSoRMloyupCZLosS61ThFgi2CHiYN" +
       "AmO6FEsx2mUJYGRWGDQJcU1Cq/3DbWFSI6raLoe8yUXe4RpByqQzl8FIfXiH" +
       "MCyEUkySQ2HJYG1pnSzWVHnXgKyyIE2z4A55ueWCDeHlWS6Yd6buxs0Dg/Xc" +
       "BRMFRVEZN8/YSA1VHqbxMKlzejtlmjR2ks+T4jCpdhEz0hq2Jw3BpCGY1LbW" +
       "oQLta6mSSnao3BxmSyrTRFSIkbleIZqgC0lLTB/XGSRUMMt2zgzWzslYa1qZ" +
       "ZeLji0OHnthW/91iUhchdZLSj+qIoASDSSLgUJqMUd1YHY/TeIQ0KBDsfqpL" +
       "giyNWpFuNKQBRWApCL/tFuxMaVTnczq+gjiCbXpKZKqeMS/BE8r6VZqQhQGw" +
       "dYpjq2nhWuwHA6skUExPCJB3FkvJkKTEGZnt58jY2Ho/EABreZKyQTUzVYki" +
       "QAdpNFNEFpSBUD+knjIApKUqJKDOyPS8QtHXmiAOCQM0ihnpo+szh4CqkjsC" +
       "WRiZ7CfjkiBK031RcsXnWs/K/Q8p65UAKQKd41SUUf9qYGr2MW2kCapTWAcm" +
       "Y82i8GFhytl9AUKAeLKP2KR58XPX71vSfO6CSTMjB01vbAcVWVQ8FptwcWbH" +
       "whXFqEaFphoSBt9jOV9lfdZIW1oDhJmSkYiDQXvw3MafffbhE/TDAKnqImWi" +
       "KqeSkEcNoprUJJnq66hCdYHReBeppEq8g493kXJ4D0sKNXt7EwmDsi5SIvOu" +
       "MpX/BhclQAS6qAreJSWh2u+awAb5e1ojhJTDQ2rgaSbmh38zEgsNqkkaEkRB" +
       "kRQ11KeraL8RAsSJgW8HQzHI+qGQoaZ0SMGQqg+EBMiDQWoNiAbSDoBOoWFB" +
       "TtHQxnXtYICqb8FfQcw17f8ySxptnThSVARhmOkHARnWz3pVjlM9Kh5KtXde" +
       "PxV9zUwwXBSWlxjBiYPmxEE+cRAmDpoTB/nEQc/EpKiIzzcJFTBDDgEbgqUP" +
       "2FuzsP/BDdv3zSuGXNNGSsDbSDrPswd1OPhgg3pUPN1YOzr3yrLzAVISJo2C" +
       "yFKCjFvKan0AwEocstZzTQx2J2eTmOPaJHB301WRxgGj8m0WlpQKdZjq2M/I" +
       "JJcEewvDxRrKv4Hk1J+cOzLyyJYv3BEgAe++gFOWAqQhex+ieQa1W/14kEtu" +
       "3d6rN04f3q06yODZaOz9MYsTbZjnzwi/e6LiojnCC9Gzu1u52ysBuZkAYQdQ" +
       "bPbP4QGeNhvE0ZYKMDih6klBxiHbx1VsUFdHnB6eqg38fRKkRTWuxCZ47rSW" +
       "Jv/G0SkatlPN1MY881nBN4l7+7Wn3/7lH+/i7rb3kzpXIdBPWZsLw1BYI0er" +
       "BidtN+mUAt17R/q+/vi1vVt5zgJFS64JW7HtAOyCEIKb91zY+c77V45dDjh5" +
       "zmATT8WgFkpnjMR+UlXASJhtgaMPrDEZEAKzpnWzAvkpJSQhJlNcWP+sm7/s" +
       "hT/vrzfzQIYeO42WjC3A6Z/WTh5+bdvfmrmYIhH3YMdnDpkJ7BMdyat1XdiF" +
       "eqQfuTTrG68IT8MWAbBsSKOUI20x90Ext7yJkdvGxhSOJUh+D294uJdz/jt4" +
       "eze6ikslfGwFNvMN97LxrkxXlRUVD1z+qHbLRy9f53Z6yzR3lnQLWpuZmNgs" +
       "SIP4qX5YWy8Yg0B397meB+rlczdBYgQkigDZRq8O4Jr25JRFXVr+6x+fn7L9" +
       "YjEJrCVVsirE1wp8eZJKWBfUGARcTmufuc9Mi5EKaOq5qSTL+KwODM3s3EHv" +
       "TGqMh2n0B1O/t/L40Ss8PzVTxgwrRrBVePCYF/sOJJx441NvHv/a4RGzXFiY" +
       "Hwd9fE3/6JVjj37w9yyXcwTMUcr4+COhk09N71j1Ied3oAi5W9PZ2xvAucN7" +
       "54nkx4F5ZT8NkPIIqRet4pqnGCzwCBSUhl1xQwHuGfcWh2Yl1JaB2pl+GHRN" +
       "6wdBZ1uFd6TG91of7k2wca/FgoQWP+4VEf5yP2e5jbeLsFlqw0ylpqsMtKRx" +
       "H9LUFhDLSLFO45n1NpFzfhqbsCnl3rzJ2OlVfjo8t1uz3J5H+U2m8tj0ZOuY" +
       "j5uR0gGAZCWXlpvHqeU0eJZa8yzNo+XWglrm42akJOaGLpeSDxRQMu1Mtjgz" +
       "Gf+UEV+B6t4gnIVLEJ1m5TtD8PPPsUcPHY33PrPMXLqN3rq8E46dz//qX68H" +
       "j/zm1RxlYCVTtaUyHaaya84ynNIDFt38eOWsvPcmHPzdD1sH2sdTt2Ff8xiV" +
       "Gf6eDUYsyo8/flVeefRP0zetGtw+jhJsts+dfpHPdZ98dd0C8WCAnyVNSMg6" +
       "g3qZ2rxAUKVTODQrmzxw0JJJgAYM7Fx42qwEaPPnqpNivtzJFBf5WAtspkaB" +
       "sRQ2cOirH6BQUEtJqJ+GeZi8hTwGuT8VM7w0AMV928V9rX2/N3NwWg4Gk27y" +
       "s6Gvbnlrx+s8WhWYHhkfuVID0shVPtabxn8CnyJ4/o0P6o0d+A1Y3mEdL+dk" +
       "zpe4/RXcx3wGhHY3vj/01NXnTQP8m5aPmO479KVPgvsPmQvKvKRoyboncPOY" +
       "FxWmOdiMonZzC83COdb+4fTul57dvTdgRSkBYAlVhM4yMSzKHLcmeZ1uarrm" +
       "i3U/OtBYvBYWahepSCnSzhTtinuTtdxIxVxRcG41nNS1dEaPM1K0yK4tOPyp" +
       "Y2F04bIGOzo03r8jk+WNODYTnnYry9vHv0DysRZYBAcKjB3E5suMVMEC6QD0" +
       "hYSy6956XpZhJRE0r5kc53zlFjiHo8dUeMKWheHxOycfawEHfMs3Zmee5YQm" +
       "LP5H7hKDcTUZXNPb3ZkWqYZAzJm/jc2TcFgC7220KhLHS9+8VV7CeqDfMrV/" +
       "/F7Kx1rAS6dyewl/focTnMHmOUYqwBPrMnWP44sTt8oXWH5GLIMi4/dFPtYC" +
       "vnhpLF+cxeb7jJSDL9rt6spxxYu3ClmwmBUse4TxuyIfawFXXCgw9nNszkNG" +
       "MNWED/x9yHHDT/4XbkgzUuu50MPzZFPWPwjmrbd46mhdxdSjm9/i9V3mZroG" +
       "tuxESpbdJx7Xe5mm04TETaoxzz8a/7rEyNwxbwZgY+PfXP+LJuObjMwowAho" +
       "Yr64ed5mZFIuHjgJQeumfBeA208JWvBvN90VwHyHDiY1X9wkvwXpQIKvH2g2" +
       "IP4XN6yroS7SoXrmAUkXecv+TPwnjxV/10mhxVPw8P+R7JogZf6TFBVPH93Q" +
       "89D1e54xb9FEWRgdRSnVUAmYF3qZQnluXmm2rLL1C29OOFM53y5QGkyFnTU0" +
       "w5XoHbD4Ncy76b4rJqM1c9P0zrGVL/9iX9klKK22kiKBkYlbsw/qaS0FJ5St" +
       "4eyKBw4V/O6rbeGTu1YtSfzlXX4VQswKaWZ++qh4+fiDbxxsOtYcINVdpBRq" +
       "L5rmNwhrdikbqTisR0itZHSmQUWQIgmyp5yagEtEwLXL/WK5szbTi3ewjMzL" +
       "LhGzb66rZHWE6u1qSuG7JBRk1U6PfWDynDVSmuZjcHpcZfRj2IymMRqQrtFw" +
       "t6bZFXTZdY3DxJ5cUL2Hc3/MX7G58R9nYCKSYx4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "lx/6+bf+5NOfK0+e/g+FZLky5igAAA==");
}
