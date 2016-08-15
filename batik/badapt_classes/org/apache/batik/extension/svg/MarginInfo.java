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
    public static final long jlc$SourceLastModified$jl7 = 1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVaC2wcxRmeOz/jt50nTvyMSZoQ7oASmsiUJHbs5MLZsWwn" +
                                                              "Ek6Is7c3d95kb3ezO2dfQkMBqSRtVZrSAKGFqK2CeCgQVJXSqgWlohQQtBKP" +
                                                              "QiniIVoVWhqViBYQtKX/P7t3u7d3u+lF2NLNrWfmf3z//PP//8zeyTOkwtBJ" +
                                                              "O1VYiO3XqBEaUNiIoBs03i8LhjEOfZPiHWXCB7veHV4bJJUTpGFKMIZEwaCD" +
                                                              "EpXjxgRpkxSDCYpIjWFK40gxolOD6tMCk1RlgsyXjEhKkyVRYkNqnOKE7YIe" +
                                                              "Jc0CY7oUSzMasRgw0hYFTcJck/AG93BvlNSJqrbfnr7IMb3fMYIzU7Ysg5Gm" +
                                                              "6B5hWginmSSHo5LBejM6uUhT5f1JWWUhmmGhPfJqywRboqsLTND9cOOHnx6Z" +
                                                              "auImmCsoiso4PGOUGqo8TeNR0mj3Dsg0Zewj15OyKKl1TGakJ5oVGgahYRCa" +
                                                              "RWvPAu3rqZJO9ascDstyqtREVIiRrnwmmqALKYvNCNcZOFQzCzsnBrSdObQm" +
                                                              "ygKIt10UPnrHrqYfl5HGCdIoKWOojghKMBAyAQalqRjVjQ3xOI1PkGYFFnuM" +
                                                              "6pIgSweslW4xpKQisDQsf9Ys2JnWqM5l2raCdQRselpkqp6Dl+AOZf1XkZCF" +
                                                              "JGBdYGM1EQ5iPwCskUAxPSGA31kk5XslJc5Ih5sih7HnapgApFUpyqbUnKhy" +
                                                              "RYAO0mK6iCwoyfAYuJ6ShKkVKjigzkirJ1O0tSaIe4UknUSPdM0bMYdg1hxu" +
                                                              "CCRhZL57GucEq9TqWiXH+pwZvvKW65TNSpAEQOc4FWXUvxaI2l1EozRBdQr7" +
                                                              "wCSsWxm9XVjw2OEgITB5vmuyOefRr5xdv6r99NPmnMVF5myN7aEimxRPxBqe" +
                                                              "X9K/Ym0ZqlGtqYaEi5+HnO+yEWukN6NBhFmQ44iDoezg6dHfXHPDA/S9IKmJ" +
                                                              "kEpRldMp8KNmUU1pkkz1TVShusBoPELmUCXez8cjpAqeo5JCzd6tiYRBWYSU" +
                                                              "y7yrUuX/g4kSwAJNVAPPkpJQs8+awKb4c0YjhFTBh9TB5wJi/vFvRnaGp9QU" +
                                                              "DQuioEiKGh7RVcRvhCHixMC2U+EYeP3esKGmdXDBsKonwwL4wRS1BmDTUMUA" +
                                                              "jGFjOhkeEvSkpERAixB6mTbL/DOIb+5MIACmX+Le+DLsmc2qHKf6pHg03Tdw" +
                                                              "9qHJZ02nwo1gWYaRFSAyZIoMcZGhnMgQiAzZIkkgwCXNQ9HmAsPy7IWNDpG2" +
                                                              "bsXYtVt2H+4uA8/SZsrBtkGY2p2XcfrtaJAN4ZPiqZb6A11vXPpEkJRHSYsg" +
                                                              "srQgYwLZoCchNIl7rd1bF4NcZKeETkdKwFymqyKNQ0TySg0Wl2p1murYz8g8" +
                                                              "B4dswsKtGfZOF0X1J6ePzdy4/auXBEkwPwugyAoIYEg+grE7F6N73Lu/GN/G" +
                                                              "Q+9+eOr2g6odB/LSSjYbFlAihm63L7jNMymu7BQemXzsYA83+xyI00yAfQUh" +
                                                              "sN0tIy/M9GZDNmKpBsAJVU8JMg5lbVzDpnR1xu7hTtrMn+eBW9TivpsPn5XW" +
                                                              "RuTfOLpAw3ah6dToZy4UPCV8eUy7+w+/++sXubmz2aPRkfbHKOt1RCxk1sJj" +
                                                              "U7PttuM6pTDv9WMj373tzKEd3GdhxtJiAnuw7YdIBUsIZv7a0/teffONEy8F" +
                                                              "c34eYJCy0zGofDI5kNhPanxAgrRltj4Q8WSICug1PdsU8E8pIQkxmeLG+nfj" +
                                                              "hZc+8vdbmkw/kKEn60arzs3A7r+gj9zw7K6P2jmbgIgZ17aZPc0M43Ntzht0" +
                                                              "XdiPemRufKHtzqeEuyEhQBA2pAPUjKvcBlX5ex3301g6ZsC+lFKwDNNWirps" +
                                                              "ZLd4uGfkz2b6uaAIgTlv/n3hb21/Zc9zfJGrcedjP+Kud+xriBAOD2syjf8Z" +
                                                              "/AXg81/8oNGxwwz1Lf1WvunMJRxNy4DmK3wqxHwA4YMtb+69690HTQDuhOya" +
                                                              "TA8f/cZnoVuOmitnVi1LCwoHJ41ZuZhwsFmL2nX5SeEUg++cOviL+w4eMrVq" +
                                                              "yc/BA1BiPvjyf54LHXvrmSLhH7aQKpi15+XozKZL4+7LXx0T0savN/7ySEvZ" +
                                                              "IESNCKlOK9K+NI3EnTyh7DLSMcdy2fUQ73CCw6VhJLASVgE71rgartQVlh3w" +
                                                              "q9fxvI6RMkkpUBz/Hcici7IqpqoyFZTi1FyZ1XzsktwMwmcQPjaKzYWGM5Dn" +
                                                              "O46jyp8Uj7z0fv329x8/y42ff0xwxq0hQTNXvhmbZbjyC92JdrNgTMG8y08P" +
                                                              "72yST38KHCeAowiFg7FVh0SfyYty1uyKqj/+6okFu58vI8FBUgOrHR8UeMIg" +
                                                              "cyBSU2MKaoSMtm69GahmqqFp4lBJAfiCDgwWHcXD0EBKYzxwHPjZwp9cee/x" +
                                                              "N3jE1DiLtsJssMYKlGuKZwNsl2NzUWGM9SJ1rWDQrEpy/rWJs475rHMcm2v5" +
                                                              "0Bg2u0wDbD9PW2HHTs0cWMw7a7FuyyuR+GnbztIPvPil39/7ndtnzJ3tE6dc" +
                                                              "dIs+2SrHbnr74wKf40VJkdDlop8In7yrtf+q9zi9XR0gdU+msNaECsumveyB" +
                                                              "1L+C3ZVPBknVBGkSrdPtdkFOY86dgBOdkT3ywgk4bzz/dGYeRXpz1c8Sd+x0" +
                                                              "iHXXJc6AVM7ygo9diizCdQnDp9XyoFa38/F619xSqFIoAofRJNVb3v7BiY9u" +
                                                              "PLQmiLmwYhpVB6s02fOG03iIvvnkbW21R9/6Jvf8LGtzByzn7UpsLuauUIaP" +
                                                              "ISglDH4ex8AsKYLsKikW+ijLSP2WbWPjkcFrJsfGN4yOcx+3dw/34H3n8uA9" +
                                                              "hcZZbMlbXMQ4+KBnI+dBP2TYzGCTKQLJSwQjDVlIQ5GNG6MDxTBdfx6YllgC" +
                                                              "l/hg4pHi5vPG5CWCkdospoHhjcUAHToPQG2WtDYfQFzpb583IC8RjNRlAQ1u" +
                                                              "i0aLITry/yNqyLp2hyWuowAR4Q/HigOBanyOpqsMIgeNu1DU+7CFcoKpWi45" +
                                                              "OJS/s0TlccE7LSmdHsr/0E5o3y/U0YsagoIuJadYMS1/VKKWuIpdlpwuDy3v" +
                                                              "89XSixpiWExlTE0VU/P+EtXEiNBtCer2UPOUr5pe1AwOUzRR1JYPn4cteywx" +
                                                              "PR5K/tRXSS9qsCXU91AhFFPz0RLVRObLLEHLPNR8zFdNL2pIPXvSBoNDpyhk" +
                                                              "D93uGPB4idqijOWWvOUe2v7aV1svaqi74dAzM0qToGqfTgV+xxR16fukj76Z" +
                                                              "YvUo/6skrhtGh1xH4UewvG/zugTmh7oTNx09Ht96z6VBqxhdD4ENItTFMp2m" +
                                                              "soNVNXLKqyGH+LW3XZC93nDrn37ek+wr5YYN+9rPcYeG/3dA3bPSuyx1q/LU" +
                                                              "TX9rHb9qancJl2UdLiu5Wd4/dPKZTcvEW4P8jt+sFAveDeQT9ebXhzU6ZWld" +
                                                              "yT+iLs0/oqAPrbPWdZ3bG23P8TqieJG6Dh+OY+gazvU1n9PJ69i8DF5hUGZe" +
                                                              "0hY76pZPq1Lc9upXPo8jDO9/IYdyLo5hPh20UA6WbiAvUh/87/mMncHmL1CZ" +
                                                              "JCkbVzXTPNystinemS1TYELcZOHZVLopvEh94H7sM/YJNh9AJQ2mGMXqoagx" +
                                                              "/jlbxsC0u9lCtLl0Y3iRegMOVPiMVWFDIAGAMfp4kVLMGoHAbFmjEz4RC1Kk" +
                                                              "dGt4kfogbvEZm4dNPSRvsEYUaqGitmiYLVtgnXy1Bejq0m3hReqDt8NnrAub" +
                                                              "VoimYIuIXXLZdlg8W3ZYCp8hC8xQ6XbwIvXBuspnDM+AgeWMNIEdthTUdLY5" +
                                                              "vjBb5sAqddjCNFy6ObxIfSCv9RnDbBq4nJFmyRgsUjPa9lj9udwNMlJjv2/F" +
                                                              "y9VFBT/nMH+CID50vLF64fFtr/CiLvczgToozxJpWXbefjmeKzWdJiRuxTrz" +
                                                              "LozfvAf6GWn3fw0Mx2NoUe9An0kzyEirNw1spNyzkyoCnuWmgmMt/3bOi4Il" +
                                                              "7HlwDDIfnFO2gk4wBR9HTE9axJx3cOb1YSaQX3ZnF4zMP9eCOSr1pXkVLv8h" +
                                                              "TrYaTZs/xZkUTx3fMnzd2SvuMV9MirJw4AByqY2SKvMdaa6i7fLkluVVuXnF" +
                                                              "pw0Pz7kwW/s3mwrb3r/YkeB3QsWooa+0ut7aGT25l3evnrjy8d8ernwhSAI7" +
                                                              "SEBgZO6OwovWjJaGo8SOaOGLH6j++evE3hXf23/VqsQ/XsveaAbyL7Dd8yfF" +
                                                              "l+699sVbF51oD5LaCKnAs2yG3wBv3K+MUnFanyD1kjGQARWBiyTIeW+VGtCt" +
                                                              "BfyJDreLZc76XC++1maku/CVWuGPAWpg81K9T00r/FK/Hk4fdk/2ZJN3KEhr" +
                                                              "movA7rGWElt+g7c2g6sB/jgZHdK07BvHmsUa39cDxer7Ae7DIn/Ep/j/ANv7" +
                                                              "zGykJwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "BxTJd57iQ3cou1Ik90eVhwBFWtXOXMNz");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("l94uweIIkjogSL3zBN9/h7IPFMl7gNkBBMnjY7Bjco++XXLPgy9zQI5558m9" +
       "cIeyDxXJM1HlKiA3uuU87Zjjs2+XY3Hsxx5wZN95jvU7lBUnluc+DKIOMxyc" +
       "cS53TPIH7+pGUFR54PgmbHGt77FbLtrvL4fLv/L6lfvf9/rsP5aXQY8ucF+i" +
       "K/drsW2fvB5z4vmCH6iaWRK/tL8s45dsfiiqPHXnC7pR5R6QFoDPIfs2H4kq" +
       "j9++DRDto+eTrT4GxOJ0q6hyX/n3ZD0czMRxvahyYf9wssoAYAJVikfCP+Pw" +
       "cX+/KDt3c4B2ZB8f+V4LcyKme/6mSKz8F4nDqCne/5PEDfmrr4/Yn3iz/Yv7" +
       "W66yLe12RS/305WL+wu3R5HXs7ft7bCvC8MXv3v5a5deOIwSL+8BH4v0CWxP" +
       "n32ltO/4UXkJdPfP3vdPfvgfvv4H5S2l/wcEaJT3uzIAAA==");
}
