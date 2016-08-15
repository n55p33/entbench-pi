package org.apache.batik.dom;
public class GenericNotation extends org.apache.batik.dom.AbstractNotation {
    protected boolean readonly;
    protected GenericNotation() { super(); }
    public GenericNotation(java.lang.String name, java.lang.String pubId,
                           java.lang.String sysId,
                           org.apache.batik.dom.AbstractDocument owner) {
        super(
          );
        ownerDocument =
          owner;
        setNodeName(
          name);
        setPublicId(
          pubId);
        setSystemId(
          sysId);
    }
    public boolean isReadonly() { return readonly; }
    public void setReadonly(boolean v) { readonly = v; }
    protected org.w3c.dom.Node newNode() { return new org.apache.batik.dom.GenericNotation(
                                             ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYC5AURxnu3Xu/HzxzcAd3HFg8shuSYKQOMcdxB4d7j+II" +
                                                              "lkfC0jvbezfc7Mww03O3d5E8iCnwRSESgkooyyJFRBJSKfFRmhRWShNMtCoJ" +
                                                              "GqMVYqlVopEylGW0RI1/d8/sPPaBWMlWbe9s999/9///X3//33PmCiozDdRG" +
                                                              "VBqh0zoxI70qHcaGSZI9CjbNbdAXlx4twX/deXlwbRiVj6L6cWwOSNgkfTJR" +
                                                              "kuYoapVVk2JVIuYgIUk2Y9ggJjEmMZU1dRTNkc3+tK7IkkwHtCRhAtuxEUNN" +
                                                              "mFJDTliU9NsKKGqNwU6ifCfR7uBwVwzVSpo+7YrP94j3eEaYZNpdy6SoMbYb" +
                                                              "T+KoRWUlGpNN2pUx0EpdU6bHFI1GSIZGditrbBdsia3JcUHH0w3vXjs03shd" +
                                                              "MAurqka5eeZWYmrKJEnGUIPb26uQtLkH3YdKYqjGI0xRZ8xZNAqLRmFRx1pX" +
                                                              "CnZfR1Qr3aNxc6ijqVyX2IYoavcr0bGB07aaYb5n0FBJbdv5ZLB2cdZaYWWO" +
                                                              "iY+sjB55dGfjMyWoYRQ1yOoI244Em6CwyCg4lKQTxDC7k0mSHEVNKgR7hBgy" +
                                                              "VuQZO9LNpjymYmpB+B23sE5LJwZf0/UVxBFsMyyJakbWvBQHlP2vLKXgMbB1" +
                                                              "rmursLCP9YOB1TJszEhhwJ09pXRCVpMULQrOyNrY+XEQgKkVaULHtexSpSqG" +
                                                              "DtQsIKJgdSw6AtBTx0C0TAMAGhS1FFTKfK1jaQKPkThDZEBuWAyBVBV3BJtC" +
                                                              "0ZygGNcEUWoJRMkTnyuD6w7eq25WwygEe04SSWH7r4FJbYFJW0mKGATOgZhY" +
                                                              "uyJ2FM999kAYIRCeExAWMt/51NU7V7Wdf1HILMgjM5TYTSQal04m6l9Z2LN8" +
                                                              "bQnbRqWumTILvs9yfsqG7ZGujA4MMzerkQ1GnMHzW3/8yQdOk7fDqLoflUua" +
                                                              "YqUBR02SltZlhRibiEoMTEmyH1URNdnDx/tRBTzHZJWI3qFUyiS0H5UqvKtc" +
                                                              "4//BRSlQwVxUDc+ymtKcZx3Tcf6c0RFCFfBFtfBtReLDfyn6RHRcS5MolrAq" +
                                                              "q1p02NCY/WYUGCcBvh2PJgD1E1FTswyAYFQzxqIYcDBO7IGklo7y/cvSoH2y" +
                                                              "Iwxg+genOsOsmjUVCoHDFwaPuwInZbOmJIkRl45YG3qvPhV/SUCJwd/2BxAU" +
                                                              "rBYRq0X4ahFYLRJYDYVCfJHZbFURUYjHBJxsoNba5SP3bNl1oKMEoKRPlYIz" +
                                                              "wyDa4UsxPe7xdzg7Lp1trptpv7T6+TAqjaFmLFELKyxjdBtjwEXShH1caxOQ" +
                                                              "fNwcsNiTA1jyMjSJJIGCCuUCW0ulNkkM1k/RbI8GJ0OxsxgtnB/y7h+dPzb1" +
                                                              "4Pb7bwmjsJ/22ZJlwFhs+jAj6ywpdwaPez69Dfsvv3v26F7NPfi+POKkv5yZ" +
                                                              "zIaOIAyC7olLKxbjc/Fn93Zyt1cBMVMMBwk4ry24ho9XuhyOZrZUgsEpzUhj" +
                                                              "hQ05Pq6m44Y25fZwfDbx59kAi3rntC2zTx7/ZaNzddbOE3hmOAtYwXPAR0f0" +
                                                              "x375sz/ext3tpIsGT54fIbTLQ1FMWTMnoyYXttsMQkDuzWPDX3rkyv4dHLMg" +
                                                              "sSTfgp2s7QFqghCCmx9+cc8bb106eTGcxXmIoird0CgcZpLMZO1kQ6iuiJ2w" +
                                                              "4DJ3S8ByCmhgwOm8SwWIyikZJxTCzta/GpauPvfng40CCgr0OEhadX0Fbv9N" +
                                                              "G9ADL+38extXE5JYlnXd5ooJ6p7lau42DDzN9pF58NXWL7+AH4MkAMRryjOE" +
                                                              "cynibkA8bmu4/bfw9vbA2B2sWWp68e8/Yp5qKC4duvhO3fZ3nrvKd+svp7zh" +
                                                              "HsB6l0AYa5ZlQP28ID9txuY4yN1+fvDuRuX8NdA4CholYFlzyABqzPjAYUuX" +
                                                              "Vfzqh8/P3fVKCQr3oWpFw8k+zM8ZqgKAE3McWDWjf+xOEdypSmgauakox/ic" +
                                                              "DubgRflD15vWKXf2zHfnfWvdqROXONB0rqI1C64apqYFvqtscK3Kf4hY+yHe" +
                                                              "rmDNzQ5gy3UrAbV5AK3VRRQG4lrKNZXy//Oh0ObGsCIqIooo1r+FN47I0rwp" +
                                                              "pjsB/AV+3ahJVhoIme+7vwiIhlizgQ99hDU9woau/zMQrKNbFwMLhHdYGvWl" +
                                                              "LX7lcZnz9Gt3/PzUF49OiaJpeeF0EZg3/59DSmLfb/+RA2ieKPIUdIH5o9Ez" +
                                                              "x1t61r/N57uMzWZ3ZnJTP2Q9d+6tp9N/C3eU/yiMKkZRo2RfMbZjxWI8OApl" +
                                                              "tencO+Aa4hv3l8iiHuzKZqSFwWzhWTaYK9ySA56ZNHuuy5ceFsG33QZiexDZ" +
                                                              "IcQfdghws2ZlLukWmk1RpUFwUlOVaX95wkqAEQvQOGzIacgck3YZfevwLulA" +
                                                              "5/DvRbRvyjNByM15IvqF7a/vfpnnpUpWrGxzLPSUIlDUeJJio9j3e/AJwfc/" +
                                                              "7Mv2yzpEOdrcY9fEi7NFsa4zjisCu4AB0b3Nb00cv/ykMCCIsYAwOXDks+9F" +
                                                              "Dh4RmUbcrJbkXG68c8TtSpjDGontrr3YKnxG3x/O7v3+E3v3i101++8JvXAN" +
                                                              "fvIX/345cuw3F/IUqxUJTVMIVrOnOZQ9uLP98RFGbfxMww8ONZf0QanTjyot" +
                                                              "Vd5jkf6kH48VppXwBMy9tbkYtc1jwaEotALi4HIsp6K7i1BRxkVrbxat/FOO" +
                                                              "ApeQIOkucMjLQK2F7oncpyf3HTmRHHp8ddimyt1QmFBNv1khk0TxqCphmnwM" +
                                                              "N8Bvxi5dvFl/+Hff6xzbcCM1Oetru07Vzf4vgnivKIze4FZe2Penlm3rx3fd" +
                                                              "QHm9KOCloMpvDJy5sGmZdDjMXwMIHst5feCf1OVHS7VBqGWofnwsycZ1lhPL" +
                                                              "tXZc1xbJzn5IZPNwoalFUuNDRcYeZs19lBH9Vpv/WE/CRe/970ci5f0z/jKF" +
                                                              "1b22TvF7Y44oNDVgrM0B3Ciu9VARbxxmzecoqjEJddzBBYlNYexHpqh0UpOT" +
                                                              "ros+/wG4iGOFVXKbbDs3XcdFeZJdoalFPPC1ImNfZ81XgWdVMjUIpzZb5LEK" +
                                                              "buo2iRdu2QHumePvSxUGlX3glQMrlOfnvMIUr92kp040VM47cdfrnKWyr8Zq" +
                                                              "gW9SlqJ4iw3Pc7lukJTM7awVpYfg8TMUzc5XoVJUAi3f8jeF5FnbE15Jisr4" +
                                                              "r1fuGThtrhzU3OLBK3IOtIMIe/y2/r8Vyo5nMiF/csiGYs71QuHJJ0t8PMzf" +
                                                              "KDucaYl3ynHp7Iktg/de/fDj4sItKXhmhmmpgZwp7v5Z3m0vqM3RVb55+bX6" +
                                                              "p6uWOhmqSWzYRfgCDwy74TjrDAAtgauo2Zm9kb5xct1zPz1Q/ipUCTtQCFM0" +
                                                              "a0dusZrRLUh4O2K5tQHkKH5H7lr+len1q1J/+TW/bKGcS0BQPi5dPHXPa4fn" +
                                                              "n4S7dE0/KoPkSzK8it44rW4l0qQxiupkszcDWwQtMlZ8hUc9wypm1yTuF9ud" +
                                                              "ddle9rqGoo7cuiv3JRdcTKeIsUGz1KRdutS4Pb5X3U7qsnQ9MMHt8dSmqmBC" +
                                                              "Fg0AaTw2oOtOWVrxaZ2fWC0f+Wp89gX+yJqf/BcI5fawbRoAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "n1//pZ999R+8/iPPfD3Pw/4f2zLfLKkkAAA=");
}
