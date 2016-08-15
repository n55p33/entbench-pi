package org.apache.batik.extension.svg;
public class MarginInfo {
    public static final int JUSTIFY_START = 0;
    public static final int JUSTIFY_MIDDLE = 1;
    public static final int JUSTIFY_END = 2;
    public static final int JUSTIFY_FULL = 3;
    protected float top;
    protected float right;
    protected float bottom;
    protected float left;
    protected float indent;
    protected int justification;
    protected boolean flowRegionBreak;
    public MarginInfo(float top, float right, float bottom, float left, float indent,
                      int justification,
                      boolean flowRegionBreak) { super();
                                                 this.top = top;
                                                 this.right = right;
                                                 this.bottom = bottom;
                                                 this.left = left;
                                                 this.indent = indent;
                                                 this.justification =
                                                   justification;
                                                 this.flowRegionBreak =
                                                   flowRegionBreak;
    }
    public MarginInfo(float margin, int justification) { super();
                                                         setMargin(
                                                           margin);
                                                         this.indent =
                                                           0;
                                                         this.justification =
                                                           justification;
                                                         this.flowRegionBreak =
                                                           false;
    }
    public void setMargin(float margin) { this.top = margin;
                                          this.right = margin;
                                          this.bottom = margin;
                                          this.left = margin; }
    public float getTopMargin() { return top; }
    public float getRightMargin() { return right; }
    public float getBottomMargin() { return bottom; }
    public float getLeftMargin() { return left; }
    public float getIndent() { return indent; }
    public int getJustification() { return justification; }
    public boolean isFlowRegionBreak() { return flowRegionBreak; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVaC4wbxRke+97vR55ccs8cSROCDZTQREdJcpe7xMF3Od1d" +
                                                              "InEJuazXY98m693N7vjOCQ0FpJK0VWlKA4QWorYK4qFAUFVKqxaUilJA0Eo8" +
                                                              "CqWIh2hVaGlUIlpA0Jb+/+zau157N3VETvJ4b2b+x/fPP///z6xPnCYVhk46" +
                                                              "qMJCbJ9GjdCgwkYF3aDxAVkwjAnomxLvKBM+2PnuyJogqZwkjdOCMSwKBh2S" +
                                                              "qBw3Jkm7pBhMUERqjFAaR4pRnRpUnxGYpCqTZJ5kRFKaLIkSG1bjFCdsE/Qo" +
                                                              "aREY06VYmtGIxYCR9ihoEuaahNe7h/uipF5UtX329IWO6QOOEZyZsmUZjDRH" +
                                                              "dwszQjjNJDkclQzWl9HJRZoq70vKKgvRDAvtlldZJtgcXVVggp6Hmz789PB0" +
                                                              "MzfBHEFRVMbhGWPUUOUZGo+SJrt3UKYpYy+5npRFSZ1jMiO90azQMAgNg9As" +
                                                              "WnsWaN9AlXRqQOVwWJZTpSaiQox05zPRBF1IWWxGuc7AoZpZ2DkxoO3KoTVR" +
                                                              "FkC87aLwkTt2Nv+4jDRNkiZJGUd1RFCCgZBJMChNxahurI/HaXyStCiw2ONU" +
                                                              "lwRZ2m+tdKshJRWBpWH5s2bBzrRGdS7TthWsI2DT0yJT9Ry8BHco67+KhCwk" +
                                                              "Aet8G6uJcAj7AWCtBIrpCQH8ziIp3yMpcUY63RQ5jL1XwwQgrUpRNq3mRJUr" +
                                                              "AnSQVtNFZEFJhsfB9ZQkTK1QwQF1Rto8maKtNUHcIyTpFHqka96oOQSzargh" +
                                                              "kISRee5pnBOsUptrlRzrc3rkyluuUzYpQRIAneNUlFH/OiDqcBGN0QTVKewD" +
                                                              "k7B+RfR2Yf5jh4KEwOR5rsnmnEe/cmbdyo5TT5tzFhWZsyW2m4psSjwea3x+" +
                                                              "8cDyNWWoRrWmGhIufh5yvstGrZG+jAYRZn6OIw6GsoOnxn5zzQ0P0PeCpDZC" +
                                                              "KkVVTqfAj1pENaVJMtU3UoXqAqPxCKmhSnyAj0dIFTxHJYWavVsSCYOyCCmX" +
                                                              "eVelyv8HEyWABZqoFp4lJaFmnzWBTfPnjEYIqYIPqYfPBcT849+M7AhPqyka" +
                                                              "FkRBkRQ1PKqriN8IQ8SJgW2nwzHw+j1hQ03r4IJhVU+GBfCDaWoNwKahigEY" +
                                                              "w8ZMMjws6ElJiYAWIfQy7TzzzyC+ObOBAJh+sXvjy7BnNqlynOpT4pF0/+CZ" +
                                                              "h6aeNZ0KN4JlGUaWg8iQKTLERYZyIkMgMmSLJIEAlzQXRZsLDMuzBzY6RNr6" +
                                                              "5ePXbt51qKcMPEubLQfbBmFqT17GGbCjQTaET4knWxv2d79x6RNBUh4lrYLI" +
                                                              "0oKMCWS9noTQJO6xdm99DHKRnRK6HCkBc5muijQOEckrNVhcqtUZqmM/I3Md" +
                                                              "HLIJC7dm2DtdFNWfnDo6e+O2r14SJMH8LIAiKyCAIfkoxu5cjO517/5ifJsO" +
                                                              "vvvhydsPqHYcyEsr2WxYQIkYety+4DbPlLiiS3hk6rEDvdzsNRCnmQD7CkJg" +
                                                              "h1tGXpjpy4ZsxFINgBOqnhJkHMrauJZN6+qs3cOdtIU/zwW3qMN9Nw8+K6yN" +
                                                              "yL9xdL6G7QLTqdHPXCh4SvjyuHb3H3731y9yc2ezR5Mj7Y9T1ueIWMislcem" +
                                                              "FtttJ3RKYd7rR0e/e9vpg9u5z8KMJcUE9mI7AJEKlhDM/LWn97765hvHXwrm" +
                                                              "/DzAIGWnY1D5ZHIgsZ/U+oAEaUttfSDiyRAV0Gt6tyrgn1JCEmIyxY3176YL" +
                                                              "L33k77c0m34gQ0/WjVaenYHdf0E/ueHZnR91cDYBETOubTN7mhnG59ic1+u6" +
                                                              "sA/1yNz4QvudTwl3Q0KAIGxI+6kZV7kNqvL3Ou6n8XTMgH0ppWAZZqwUddno" +
                                                              "LvFQ7+ifzfRzQRECc968+8Lf2vbK7uf4Ilfjzsd+xN3g2NcQIRwe1mwa/zP4" +
                                                              "C8Dnv/hBo2OHGepbB6x805VLOJqWAc2X+1SI+QDCB1rf3HPXuw+aANwJ2TWZ" +
                                                              "Hjryjc9CtxwxV86sWpYUFA5OGrNyMeFgswa16/aTwimG3jl54Bf3HThoatWa" +
                                                              "n4MHocR88OX/PBc6+tYzRcI/bCFVMGvPy9GZTZfG3Ze/OiakDV9v+uXh1rIh" +
                                                              "iBoRUp1WpL1pGok7eULZZaRjjuWy6yHe4QSHS8NIYAWsAnasdjVcqSssO+BX" +
                                                              "n+N5LSNlklKgOP47mDkbZVVMVWUqKMWpuTKr+NgluRmEzyB8bAybCw1nIM93" +
                                                              "HEeVPyUefun9hm3vP36GGz//mOCMW8OCZq58CzZLceUXuBPtJsGYhnmXnxrZ" +
                                                              "0Syf+hQ4TgJHEQoHY4sOiT6TF+Ws2RVVf/zVE/N3PV9GgkOkFlY7PiTwhEFq" +
                                                              "IFJTYxpqhIy2dp0ZqGaroWnmUEkB+IIODBadxcPQYEpjPHDs/9mCn1x577E3" +
                                                              "eMTUOIv2wmyw2gqUq4tnA2yXYXNRYYz1InWtYNCsSnL+tZGzjvmscxyba/nQ" +
                                                              "ODY7TQNsO0dbYccOzRxYxDvrsG7LK5H4advO0g+8+KXf3/ud22fNne0Tp1x0" +
                                                              "Cz/ZIsduevvjAp/jRUmR0OWinwyfuKtt4Kr3OL1dHSB1b6aw1oQKy6a97IHU" +
                                                              "v4I9lU8GSdUkaRat0+02QU5jzp2EE52RPfLCCThvPP90Zh5F+nLVz2J37HSI" +
                                                              "ddclzoBUzvKCj12KLMR1CcOnzfKgNrfz8XrX3FKoUigCh9Ek1Vvf/sHxj248" +
                                                              "uDqIubBiBlUHqzTb80bSeIi++cRt7XVH3vom9/wsa3MHLOPtCmwu5q5Qho8h" +
                                                              "KCUMfh7HwCwpguwqKRb4KMtIw+at4xORoWumxifWj01wH7d3D/fgvWfz4N2F" +
                                                              "xllkyVtUxDj4oGcj5wE/ZNjMYpMpAslLBCONWUjDkQ0booPFMF1/DpgWWwIX" +
                                                              "+2DikeLmc8bkJYKRuiymwZENxQAdPAdA7Za0dh9AXOlvnzMgLxGM1GcBDW2N" +
                                                              "RoshOvz/I2rMunanJa6zABHhD0eLA4FqvEbTVQaRg8ZdKBp82EI5wVQtlxwc" +
                                                              "yt9ZovK44F2WlC4P5X9oJ7TvF+roRQ1BQZeS06yYlj8qUUtcxW5LTreHlvf5" +
                                                              "aulFDTEspjKmpoqpeX+JamJE6LEE9XioedJXTS9qBocpmihqy4fPwZa9lphe" +
                                                              "DyV/6qukFzXYEup7qBCKqfloiWoi86WWoKUeaj7mq6YXNaSe3WmDwaFTFLKH" +
                                                              "bncMeLxEbVHGMkveMg9tf+2rrRc11N1w6Jkdo0lQtV+nAr9jirr0fdJH30yx" +
                                                              "epT/VRLXDaNDrqPwI1jet3tdAvND3fGbjhyLb7nn0qBVjK6DwAYR6mKZzlDZ" +
                                                              "waoaOeXVkMP82tsuyF5vvPVPP+9N9pdyw4Z9HWe5Q8P/O6HuWeFdlrpVeeqm" +
                                                              "v7VNXDW9q4TLsk6Xldws7x8+8czGpeKtQX7Hb1aKBe8G8on68uvDWp2ytK7k" +
                                                              "H1GX5B9R0IfWWuu61u2Ntud4HVG8SF2HD8cxdDXn+prP6eR1bF4GrzAoMy9p" +
                                                              "ix11y2dUKW579SufxxGG97+QQzkHxzCfDlkoh0o3kBepD/73fMZOY/MXqEyS" +
                                                              "lE2ommkeblbbFO+cL1NgQtxo4dlYuim8SH3gfuwz9gk2H0AlDaYYw+qhqDH+" +
                                                              "eb6MgWl3k4VoU+nG8CL1Bhyo8BmrwoZAAgBj9PMipZg1AoHzZY0u+EQsSJHS" +
                                                              "reFF6oO41WdsLjYNkLzBGlGohYraovF82QLr5KstQFeXbgsvUh+8nT5j3di0" +
                                                              "QTQFW0Tsksu2w6LzZYcl8Bm2wAyXbgcvUh+sK33G8AwYWMZIM9hhc0FNZ5vj" +
                                                              "C+fLHFiljliYRko3hxepD+Q1PmOYTQOXM9IiGUNFakbbHqs+l7tBRmrt9614" +
                                                              "ubqw4Occ5k8QxIeONVUvOLb1FV7U5X4mUA/lWSIty87bL8dzpabThMStWG/e" +
                                                              "hfGb98AAIx3+r4HheAwt6h3oN2mGGGnzpoGNlHt2UkXAs9xUcKzl3855UbCE" +
                                                              "PQ+OQeaDc8oW0Amm4OOo6UkLmfMOzrw+zATyy+7sgpF5Z1swR6W+JK/C5T/E" +
                                                              "yVajafOnOFPiyWObR647c8U95otJURb270cudVFSZb4jzVW03Z7csrwqNy3/" +
                                                              "tPHhmguztX+LqbDt/YscCX4HVIwa+kqb662d0Zt7effq8Ssf/+2hyheCJLCd" +
                                                              "BARG5mwvvGjNaGk4SmyPFr74geqfv07sW/69fVetTPzjteyNZiD/Ats9f0p8" +
                                                              "6d5rX7x14fGOIKmLkAo8y2b4DfCGfcoYFWf0SdIgGYMZUBG4SIKc91apEd1a" +
                                                              "wJ/ocLtY5mzI9eJrbUZ6Cl+pFf4YoBY2L9X71bTCL/Ub4PRh92RPNnmHgrSm" +
                                                              "uQjsHmspseU3eGsyuBrgj1PRYU3LvnGs+UTj+3qwWH0/yH1Y5I/4FP8ft6i/" +
                                                              "zqQnAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "eLsUnwFf+oAi/c5TfPgudVeL5HJUeRhQ");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("ZDT9TBmee+DtEiyOIIcHBIfvPMH336XuA0XyHuB2AEH6+BjsmNxjb5fc8+A7" +
       "OiA3eufJffAudR8ukmeiyjVAbnDbedoxx2ffLsfi2I894Mi+8xxrd6krTizP" +
       "fQREHWZInHEud0zyB+/pRlBUefD4Jmxxre/x2y7a7y+HK7/8+tXL73td+E/l" +
       "ZdCjC9wPMJXLemzbJ6/HnMhf9ANNN0viD+wvy/glmx+KKk/d/YJuVLkA0gLw" +
       "OXTf56NR5fqd+wDVPsqf7PVxoBane0WV+8u/J9vhYCWO20WVi/vMySYEwASa" +
       "FFnSP+PwcX+/KD13a4B25B8f/V6CORHTPX9LJFb+i8Rh1BTv/0niZeWrrw/Y" +
       "n3iz/Qv7W66KLed5McplpnJpf+H2KPJ69o6jHY51kXrhu1e+9sAHD6PEK3vA" +
       "xyp9AtvTZ18p7Tt+VF4Czf/5+/7pD/+j13+/vKX0/wDenhR6uzIAAA==");
}
