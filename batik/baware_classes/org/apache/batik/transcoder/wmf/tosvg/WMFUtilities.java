package org.apache.batik.transcoder.wmf.tosvg;
public class WMFUtilities {
    public static java.lang.String decodeString(org.apache.batik.transcoder.wmf.tosvg.WMFFont wmfFont,
                                                byte[] bstr) { try {
                                                                   switch (wmfFont.
                                                                             charset) {
                                                                       case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                              META_CHARSET_ANSI:
                                                                           return new java.lang.String(
                                                                             bstr,
                                                                             org.apache.batik.transcoder.wmf.WMFConstants.
                                                                               CHARSET_ANSI);
                                                                       case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                              META_CHARSET_DEFAULT:
                                                                           return new java.lang.String(
                                                                             bstr,
                                                                             org.apache.batik.transcoder.wmf.WMFConstants.
                                                                               CHARSET_DEFAULT);
                                                                       case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                              META_CHARSET_SHIFTJIS:
                                                                           return new java.lang.String(
                                                                             bstr,
                                                                             org.apache.batik.transcoder.wmf.WMFConstants.
                                                                               CHARSET_SHIFTJIS);
                                                                       case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                              META_CHARSET_HANGUL:
                                                                           return new java.lang.String(
                                                                             bstr,
                                                                             org.apache.batik.transcoder.wmf.WMFConstants.
                                                                               CHARSET_HANGUL);
                                                                       case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                              META_CHARSET_JOHAB:
                                                                           return new java.lang.String(
                                                                             bstr,
                                                                             org.apache.batik.transcoder.wmf.WMFConstants.
                                                                               CHARSET_JOHAB);
                                                                       case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                              META_CHARSET_GB2312:
                                                                           return new java.lang.String(
                                                                             bstr,
                                                                             org.apache.batik.transcoder.wmf.WMFConstants.
                                                                               CHARSET_GB2312);
                                                                       case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                              META_CHARSET_CHINESEBIG5:
                                                                           return new java.lang.String(
                                                                             bstr,
                                                                             org.apache.batik.transcoder.wmf.WMFConstants.
                                                                               CHARSET_CHINESEBIG5);
                                                                       case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                              META_CHARSET_GREEK:
                                                                           return new java.lang.String(
                                                                             bstr,
                                                                             org.apache.batik.transcoder.wmf.WMFConstants.
                                                                               CHARSET_GREEK);
                                                                       case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                              META_CHARSET_TURKISH:
                                                                           return new java.lang.String(
                                                                             bstr,
                                                                             org.apache.batik.transcoder.wmf.WMFConstants.
                                                                               CHARSET_TURKISH);
                                                                       case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                              META_CHARSET_VIETNAMESE:
                                                                           return new java.lang.String(
                                                                             bstr,
                                                                             org.apache.batik.transcoder.wmf.WMFConstants.
                                                                               CHARSET_VIETNAMESE);
                                                                       case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                              META_CHARSET_HEBREW:
                                                                           return new java.lang.String(
                                                                             bstr,
                                                                             org.apache.batik.transcoder.wmf.WMFConstants.
                                                                               CHARSET_HEBREW);
                                                                       case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                              META_CHARSET_ARABIC:
                                                                           return new java.lang.String(
                                                                             bstr,
                                                                             org.apache.batik.transcoder.wmf.WMFConstants.
                                                                               CHARSET_ARABIC);
                                                                       case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                              META_CHARSET_RUSSIAN:
                                                                           return new java.lang.String(
                                                                             bstr,
                                                                             org.apache.batik.transcoder.wmf.WMFConstants.
                                                                               CHARSET_CYRILLIC);
                                                                       case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                              META_CHARSET_THAI:
                                                                           return new java.lang.String(
                                                                             bstr,
                                                                             org.apache.batik.transcoder.wmf.WMFConstants.
                                                                               CHARSET_THAI);
                                                                       case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                              META_CHARSET_EASTEUROPE:
                                                                           return new java.lang.String(
                                                                             bstr,
                                                                             org.apache.batik.transcoder.wmf.WMFConstants.
                                                                               CHARSET_EASTEUROPE);
                                                                       case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                              META_CHARSET_OEM:
                                                                           return new java.lang.String(
                                                                             bstr,
                                                                             org.apache.batik.transcoder.wmf.WMFConstants.
                                                                               CHARSET_OEM);
                                                                       default:
                                                                   }
                                                               }
                                                               catch (java.io.UnsupportedEncodingException e) {
                                                                   
                                                               }
                                                               return new java.lang.String(
                                                                 bstr);
    }
    public static int getHorizontalAlignment(int align) {
        int v =
          align;
        v =
          v %
            org.apache.batik.transcoder.wmf.WMFConstants.
              TA_BASELINE;
        v =
          v %
            org.apache.batik.transcoder.wmf.WMFConstants.
              TA_BOTTOM;
        if (v >=
              6)
            return org.apache.batik.transcoder.wmf.WMFConstants.
                     TA_CENTER;
        else
            if (v >=
                  2)
                return org.apache.batik.transcoder.wmf.WMFConstants.
                         TA_RIGHT;
            else
                return org.apache.batik.transcoder.wmf.WMFConstants.
                         TA_LEFT;
    }
    public static int getVerticalAlignment(int align) {
        int v =
          align;
        if (v /
              org.apache.batik.transcoder.wmf.WMFConstants.
                TA_BASELINE !=
              0)
            return org.apache.batik.transcoder.wmf.WMFConstants.
                     TA_BASELINE;
        v =
          v %
            org.apache.batik.transcoder.wmf.WMFConstants.
              TA_BASELINE;
        if (v /
              org.apache.batik.transcoder.wmf.WMFConstants.
                TA_BOTTOM !=
              0)
            return org.apache.batik.transcoder.wmf.WMFConstants.
                     TA_BOTTOM;
        else
            return org.apache.batik.transcoder.wmf.WMFConstants.
                     TA_TOP;
    }
    public WMFUtilities() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "cf6KzYn/ACLzRUsYHQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16e+z82FWff9/d/e2Dzf5+u0k2Ycm+sr8l3Uz4esaep5bS" +
       "2DOesWfs8Yw99swYysb2+Dl+v8Zjug2kj0SAQgQbmvLYqlKAlm4S1IKoCqm2" +
       "ghYQCAmE+pJKaFWplBAp+YOHCJRee77v32OJ0jKS73h8zzn3nHPP/dwz9/iN" +
       "L0EPxBFUC3xnbzh+cqzlybHttI6TfaDFx2O6NZOjWNv0HTmOF+DZK+p7f+bG" +
       "H3/1E+bNI+i6BL1d9jw/kRPL92JOi30n0zY0dOP8KeFobpxAN2lbzmQ4TSwH" +
       "pq04eZmGvuECawLdok9VgIEKMFABrlSAsXMqwPQ2zUvdfskhe0kcQn8XukZD" +
       "1wO1VC+Bnr8sJJAj2T0RM6ssABIeKn+LwKiKOY+g585sP9h8m8GfrMGv/aPv" +
       "vPkv74NuSNANy+NLdVSgRAIGkaBHXc1VtCjGNhttI0GPe5q24bXIkh2rqPSW" +
       "oCdiy/DkJI20MyeVD9NAi6oxzz33qFraFqVq4kdn5umW5mxOfz2gO7IBbH3y" +
       "3NaDhcPyOTDwEQsoFumyqp2y3L+1vE0CPXuV48zGWxNAAFgfdLXE9M+Gut+T" +
       "wQPoicPcObJnwHwSWZ4BSB/wUzBKAj11V6GlrwNZ3cqG9koCvfsq3ezQBage" +
       "rhxRsiTQO6+SVZLALD11ZZYuzM+Xpt/68e/ySO+o0nmjqU6p/0OA6ZkrTJym" +
       "a5HmqdqB8dH30z8sP/n5jx1BECB+5xXiA83P/52vfPADz7z5qweab7oDDavY" +
       "mpq8on5aeey33tN/qXdfqcZDgR9b5eRfsrwK/9lJz8t5AFbek2cSy87j0843" +
       "uf+w/u6f1r54BD1CQddV30ldEEePq74bWI4WjTRPi+RE21DQw5q36Vf9FPQg" +
       "uKctTzs8ZXU91hIKut+pHl33q9/ARToQUbroQXBvebp/eh/IiVnd5wEEQQ+C" +
       "C3oUXM9Ch0/1nUAabPquBsuq7FmeD88iv7Q/hjUvUYBvTVgBUb+FYz+NQAjC" +
       "fmTAMogDUzvpSCLZi1V/o0XwztXhxI8zA14yQwHYD2wHXi3DLfjrGigvLb65" +
       "u3YNTMZ7rkKBA1YR6TtAxCvqaylOfOWzr/z60dnSOPFVAiFg7OPD2MfV2Mfn" +
       "Yx+DsY+rsY8vjg1du1YN+Y5Sh8Pcg5nbAgwA6PjoS/zfHn/oY++9DwRdsLsf" +
       "uL0khe8O0v1z1KAqbFRB6EJvfmr3PeKH60fQ0WW0LfUGjx4p2WclRp5h4a2r" +
       "q+xOcm989Pf/+HM//Kp/vt4uwfcJDNzOWS7j9171cOSr2gYA47n49z8n/9wr" +
       "n3/11hF0P8AGgIeJDOIXQM0zV8e4tJxfPoXG0pYHgMG6H7myU3ad4tkjiRn5" +
       "u/Mn1dQ/Vt0/Dnz8FHTSXAr4svftQdm+4xAq5aRdsaKC3r/JBz/+n3/zf6OV" +
       "u09R+saFfY/XkpcvIEMp7EaFAY+fx8Ai0jRA998+NfuhT37po99eBQCgeOFO" +
       "A94q2z5ABDCFwM3/4FfD//KF3/307xydB00CtsZUcSw1Pxj5l+BzDVz/p7xK" +
       "48oHh1X9RP8EWp47w5agHPmbz3UDKOOABVhG0C3Bc/2NpVuy4mhlxP75jRcb" +
       "P/eHH795iAkHPDkNqQ+8tYDz59+IQ9/969/5J89UYq6p5S537r9zsgN0vv1c" +
       "MhZF8r7UI/+e3376H/+K/OMAhAHwxVahVVgGVf6AqgmsV76oVS18pQ8pm2fj" +
       "iwvh8lq7kI28on7id778NvHL//YrlbaX05mL887IwcuHUCub53Ig/l1XVz0p" +
       "xyaga745/Y6bzptfBRIlIFEFuBazEUCR/FKUnFA/8OB//Xe/9OSHfus+6GgI" +
       "PeL48mYoVwsOehhEuhabALny4G998BDNu4dAc7MyFbrN+EOAvLv6dR9Q8KW7" +
       "Y82wzEbOl+u7/4x1lI/8jz+9zQkVytxhE77CL8Fv/NhT/W/7YsV/vtxL7mfy" +
       "2yEZZG7nvMhPu3909N7r//4IelCCbqonaaEoO2m5iCSQCsWnuSJIHS/1X05r" +
       "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" +
       "T+a7ni37zaHmdeJ53udiWGW7tu333GyzaMA7pFhFhb0XwxjpEO5u2RoVW193" +
       "bb3urexMjtm5mWU6Xdf3bFtHyIKhioDt+Xsa5S2iHsu5OrPzIb0QpiajuURe" +
       "CzlFDdOOSWjk1kQHizU3Hra4ZkTjRX0m11djqxm0F4OmP++3OgkWzILIRtAM" +
       "R6VM0LHANrBNvlTnSr3eNLEYs5oZqo/5EO1PdpuujszINbxIkJY9V9buYCUL" +
       "SsEWS4GuDbxarb4Fm3JcbyIztBfwU8PQRjwtjkSkN92yJOG1iDCiClXtIuoc" +
       "Zmi72aJcZpwLpi/xIP2Zi+sOA2Zq3JngapMEjvEDOK7pNU1gRt1xslv4w6xl" +
       "G7kM1zYbmG4bHZZar7oij+nbQtbrvQ68X2bqKkQ1Qgk7bmG6872FTsQNLAza" +
       "UY1k92ZtyG+EtSxOVK1NTuNAwVNPYJoJWEGcNOTX0wwlaxk17+SZ7jLxwlhP" +
       "gpZjIMtOozFzClYTpWhIzn3OrpGLwBv2OZEUpSY65/Y4JjfEaewRPZbVR9Qq" +
       "ZxmHIQFqaUTedXG93w8FcT5tG41B0LDXrVghtiLToDJHmZhGPMD17owvtq1m" +
       "PG4qhNRkJ8JkmGeTBYmMljliROvJ3loJkwHZU5uiQ3pK3ZXaE4adL2VXXgoo" +
       "0sUZXYn17ZqCV4YszCM9ZMW4jizkQp/tKG2H8CaTsDJME+1hg5mEtVWxNF02" +
       "atLeZK8Hq0xLZCxIppwWUukCIAY7a0xN0TRTtDFeF50WR4+yeU2hu8PxRFhJ" +
       "bDzlJRTryEjcmKpCQVKtWr5YBTO9m23bbWJca66pWVtzV/PUBii391aOhSKF" +
       "yYxqplpH10O2v1tIiz4S9VMVacCd+k7M1xaKxpwpa645F1dNlpZFD/zliobt" +
       "nbZ3nTrf2tKJHK31CS153LQPp9qmGS3WsSvKrU0m4PgW7fbyrT1j98EC44rm" +
       "tKGbtSbd5GXbWtQZZodZiVMzAi5uxnN1YehjEm7Kqw41B7xYm2gmsKatNdwo" +
       "4hkzTLvaRO+OJnx/opvtvL/vMxadSwQ7HDfItJsoi3STF3W22AfLotaqaykS" +
       "W1RW9Ky9T0qTnqRvauGg13QiSlguJESe8zkqjFh6P1nB7NJuekm+z/aeEKFB" +
       "hKpEYxZldL4SkhbY/3G8SPur2qiO11rjDtvpblSP1npqtyZNN46gmURi9uf2" +
       "eBvzyHCyCCIp7WPpXpSXRIJb6XrF0vUos83eXo62XgM2TTTnhZlPtLqasIbT" +
       "VNNHiLmKO7uQS60hhwmCVmSk3FSGkc6PxbHc3NXDmYQNt3OCDrC9vl7Js+lu" +
       "yaTriWLqpIehrVW0y6QJD7y1jrPRMmmsd4GcCdJogeDKZCCE6LSjz+AJO0yT" +
       "qcvK2HyC5g02Gu1oqc7Fc7tD+vHIc+kkCxeBr47UwrIoOFH19qRYezDYngtO" +
       "iNfkHMPKv8ff8bWdUDxeHcacVc9sp1N2jL6Gf+aHrufL5sWzA+jqc/0eB9AX" +
       "Dumg8rTh6bsVxaqThk9/5LXXN+xPNI5ODjeXCfRw4gff4miZ5lw573v/3U9V" +
       "mKomeH7o9isf+YOnFt9mfuhrKCs8e0XPqyL/OfPGr42+Wf3BI+i+syO426qV" +
       "l5levnzw9kikJWnkLS4dvz195tlvLD32Irjed+LZ9935aP+OUXB0HgWHALhy" +
       "gHx0oDo9ifuWv3IxaOh7CfD9i3f3fXWufTigev0nX/jND7/+wn+vjoYfsmJR" +
       "jrDIuENl9ALPl9/4whd/+21Pf7YqpdyvyPHBOVdLyrdXjC8VgiujHz3z5XtK" +
       "1z0HQdd+8eDKw3cCqV9nuU6JrI2hwTjQklcjK0gszyC8zIp8zwUyTquCfx3D" +
       "HFYnd2ERiwnw3z7Rzib92klZ7uyELc+vQVUsffitougMRq47mmck5p0Guw9M" +
       "SXm7C/K7xdnbz89f+47vaWUl5bTvUFW0/OOzFxFAZ35H5e2D8tVgZfPCPcoj" +
       "H79H3yfK5vsT6AG1VOag+z3Ifyg/fEf3oPlk2bgJ9ChABLB6zs+1R+cg673V" +
       "8edFoQeDzyL5yfLhB8C1PEGF5f9DVDjxcfnz71UE/+Qelv7TsvmRBHrS0BLS" +
       "j6yiLIM4mGMZVVBWQs5t/tGv1+b3g0s5sVn5/2nzv7iHzZ8pm58EsQpsFrUo" +
       "sdS7W/xTX4vFOYiYi6X2slb47tte8jm8mKJ+9vUbD73rdeE/HSDy9OWRh2no" +
       "IT11nIulnQv314NI063KiocPhZ6g+vrZBHrxr4T+YJlU35Xu/+rA/PNgz3sL" +
       "ZoALoL3I9G8S6JvuwZSA3fjsx0W+zyfQzat8QKnq+yLdm0DCOR2ArMPNRZJf" +
       "AloBkvL2l4M7lKMOtbX82uXk5Wxqn3irqb2Q77xwaaesXu86zSjSwwter6if" +
       "e308/a6vtH/iUIZXHbkoSikPgU3t8EbAWVby/F2lncq6Tr701cd+5uEXTzOo" +
       "xw4Kn6+QC7o9e+c6N+EGSVWZLv71u372W3/q9d+tqmP/F3lqL7t3JwAA");
}
