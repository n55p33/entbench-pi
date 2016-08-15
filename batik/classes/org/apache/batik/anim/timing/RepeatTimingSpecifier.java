package org.apache.batik.anim.timing;
public class RepeatTimingSpecifier extends org.apache.batik.anim.timing.EventbaseTimingSpecifier {
    protected int repeatIteration;
    protected boolean repeatIterationSpecified;
    public RepeatTimingSpecifier(org.apache.batik.anim.timing.TimedElement owner,
                                 boolean isBegin,
                                 float offset,
                                 java.lang.String syncbaseID) { super(
                                                                  owner,
                                                                  isBegin,
                                                                  offset,
                                                                  syncbaseID,
                                                                  owner.
                                                                    getRoot(
                                                                      ).
                                                                    getRepeatEventName(
                                                                      ));
    }
    public RepeatTimingSpecifier(org.apache.batik.anim.timing.TimedElement owner,
                                 boolean isBegin,
                                 float offset,
                                 java.lang.String syncbaseID,
                                 int repeatIteration) {
        super(
          owner,
          isBegin,
          offset,
          syncbaseID,
          owner.
            getRoot(
              ).
            getRepeatEventName(
              ));
        this.
          repeatIteration =
          repeatIteration;
        this.
          repeatIterationSpecified =
          true;
    }
    public java.lang.String toString() { return (eventbaseID ==
                                                   null
                                                   ? ""
                                                   : eventbaseID +
                                                 ".") +
                                         "repeat" +
                                         (repeatIterationSpecified
                                            ? "(" +
                                          repeatIteration +
                                          ")"
                                            : "") +
                                         (offset !=
                                            0
                                            ? super.
                                            toString(
                                              )
                                            : "");
    }
    public void handleEvent(org.w3c.dom.events.Event e) {
        org.w3c.dom.smil.TimeEvent evt =
          (org.w3c.dom.smil.TimeEvent)
            e;
        if (!repeatIterationSpecified ||
              evt.
              getDetail(
                ) ==
              repeatIteration) {
            super.
              handleEvent(
                e);
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1YDYwVVxW++/aHZX/YH/62CyywLLT8vVdoQevSH3a7C4tv" +
       "l5UFEpfCct+8u7sD82aGmft2H1RqS2JAjYhIKRogMYFQCS1ErdpYGkyjbdNq" +
       "pEVrNaVGTUQrscRYjaj1nHtn3vy8H4JpfMncmXfnnHvPueec75wz566Tctsi" +
       "LUznUb7bZHa0S+f91LJZslOjtr0R5oaUp0rpX7dd67svQioGyaRRavcq1Gbd" +
       "KtOS9iCZpeo2p7rC7D7GksjRbzGbWWOUq4Y+SKaqdk/K1FRF5b1GkiHBZmrF" +
       "SQPl3FITac56nAU4mRUHSWJCktjq8Ov2OKlRDHO3R97kI+/0vUHKlLeXzUl9" +
       "fAcdo7E0V7VYXLV5e8Yii01D2z2iGTzKMjy6Q1vhHMG6+IqcI2i9UPfBzUOj" +
       "9eIIJlNdN7hQz97AbEMbY8k4qfNmuzSWsneRx0hpnFT7iDlpi7ubxmDTGGzq" +
       "autRgfS1TE+nOg2hDndXqjAVFIiTucFFTGrRlLNMv5AZVqjkju6CGbSdk9VW" +
       "apmj4pOLY0ee2lb/rVJSN0jqVH0AxVFACA6bDMKBslSCWfbqZJIlB0mDDsYe" +
       "YJZKNXWPY+lGWx3RKU+D+d1jwcm0ySyxp3dWYEfQzUor3LCy6g0Lh3L+lQ9r" +
       "dAR0nebpKjXsxnlQsEoFwaxhCn7nsJTtVPUkJ7PDHFkd2z4JBMA6IcX4qJHd" +
       "qkynMEEapYtoVB+JDYDr6SNAWm6AA1qcNBdcFM/apMpOOsKG0CNDdP3yFVBN" +
       "FAeBLJxMDZOJlcBKzSEr+exzvW/VwUf1tXqElIDMSaZoKH81MLWEmDawYWYx" +
       "iAPJWLMofpROu3ggQggQTw0RS5rvfebGQ0taLr0iaWbkoVmf2MEUPqScSky6" +
       "PLNz4X2lKEaladgqGj+guYiyfudNe8YEhJmWXRFfRt2Xlzb8+NOPn2XvRUhV" +
       "D6lQDC2dAj9qUIyUqWrMWsN0ZlHOkj1kItOTneJ9D5kAz3FVZ3J2/fCwzXgP" +
       "KdPEVIUh/sMRDcMSeERV8Kzqw4b7bFI+Kp4zJiFkAlykBq4WIn/izgmLjRop" +
       "FqMK1VXdiPVbBupvxwBxEnC2o7EEeP3OmG2kLXDBmGGNxCj4wShzXgAbBKWa" +
       "Aj+KbWAmo3yj+DNgMkUFV7ei6G7m/2ujDGo8ebykBIwxMwwFGkTRWkNLMmtI" +
       "OZLu6Lrx7NBr0s0wNJyz4mQ57B2Ve0fF3lHcOyr3jubdm5SUiC2noAzS9mC5" +
       "nYABAMI1Cwe2rtt+oLUUnM4cL4NjjwBpayAZdXpA4aL7kHK+sXbP3KvLXoqQ" +
       "sjhppApPUw1zy2prBFBL2ekEdk0C0pSXLeb4sgWmOctQWBLAqlDWcFapNMaY" +
       "hfOcTPGt4OYyjNpY4UySV35y6dj4E5s/e3eERIIJArcsB2xD9n6E9Sx8t4WB" +
       "Id+6dfuvfXD+6F7Dg4hAxnETZQ4n6tAadorw8Qwpi+bQ54Yu7m0Txz4RIJxT" +
       "CDlAx5bwHgEEanfRHHWpBIWHDStFNXzlnnEVH7WMcW9GeGuDeJ4CblGNITkH" +
       "rqVOjIo7vp1m4jhdejf6WUgLkS3uHzBP/PKnf7xHHLebWOp8FcEA4+0+MMPF" +
       "GgVsNXhuu9FiDOjeOdb/1Sev798ifBYo5uXbsA3HTgAxMCEc8+de2fX2u1dP" +
       "XYlk/byEQzZPJ6AoymSVxHlSVURJ2G2BJw+AoQY4gV7TtkkH/4R4owmNYWD9" +
       "q27+suf+fLBe+oEGM64bLbn1At78HR3k8de2/b1FLFOiYDL2zswjkwg/2Vt5" +
       "tWXR3ShH5ok3Zn3tZXoCcgXgs63uYQJyy8QZlAnNmzhZWBRWAFBYEgsqCL0g" +
       "OmAEDqQTNkQykHJ1zMl3y/u3Kwfa+n8vc9kdeRgk3dSnY1/a/NaO14VbVCJW" +
       "4DwKVetDAsAUn0/WS3N9CL8SuP6DF5oJJ2TeaOx0ktecbPYyzQxIvrBIuRlU" +
       "ILa38d2dx689IxUIZ/cQMTtw5AsfRg8ekbaWJdC8nCrEzyPLIKkODu0o3dxi" +
       "uwiO7j+c3/uDp/ful1I1BhN6F9Srz/zi369Hj/3m1TyZY0LCMDRGJcDdiwEg" +
       "wwAjNmgfqdTDn6974VBjaTcgTQ+pTOvqrjTrSfpXhSrOTid8BvPKKzHhVw+N" +
       "w0nJIrQDznzc0Rpv9/ueV3NEB4PysJj4d03G9dd64elYJ0ZlnSj2WiFe351l" +
       "JYKViHefwmG+7UfxoA/4qv8h5dCV92s3v//iDXGOwfbBD1q91JRGbMBhARpx" +
       "ejjLrqX2KNDde6nvkXrt0k1YcRBWVKCOsNdbkO4zAYhzqMsn/OqHL03bfrmU" +
       "RLpJFZxHspuKbEEmAkwzexQqhYz54EMSpcYrYagXqpIc5XMmEClm58egrpTJ" +
       "BWrs+f7076w6c/KqgEtTLDErNxWsdFByZf5UgOOdOCzOBdhCrCELlguZy/Hv" +
       "Shw+gUMPDn23cqNSVS/gREI8WsRXRGn6iHi1AYetctFN/+N548QWx+9nZGus" +
       "mYEaS3TyXpo/++bHfn7mK0fHZaAXga0QX9M/12uJfb/9R47fiqomD5KF+Adj" +
       "5443dz7wnuD3ygvkbsvkVq1Qonm8y8+m/hZprfhRhEwYJPWK0zlvploak/Yg" +
       "dIu2205Ddx14H+z8ZJvTni2fZoah1LdtuLDxo1MZDyCRV8tMQru0wjXP8cJ5" +
       "YQcuIeJBOtCdYlyEw1K3dJhoWgYHKVkyVD3UFlkWwMMSFXoPx6zklDkJL1qE" +
       "t6Vv5W16UJEYXHc5O95VQJG9XjCO58pbiBs6ypC8blORzAajT/DHigieyYcG" +
       "4ldBQn1fGA1muIFlkVmFWnORHU/tO3Iyuf70sogTxh1gJm6YSzU2xrRQ9M0K" +
       "RF+v+BjhufI7kw7/7vm2kY7baW5wruUW7Qv+nw1xtKhwQIdFeXnfn5o3PjC6" +
       "/Tb6lNmhUwov+c3ec6+uWaAcjogvLzLGcr7YBJnag5FVZTGetvRgpp+XtWsj" +
       "2qsZrg7Hrh23nyAKsRaB7SNF3h3F4cucVHJDFgxeDhG+e+ijgHgx/8VgnmyD" +
       "q9fRpff2j6EQa0hVt5bD/1AeNWE5P36PEk0aqSh4P2TCaBfexI7fKHJOp3E4" +
       "zkn1KNWTGhNM+bJr2ZihJr3jO/GRZEhOpub9goEVS1POt1P5vU959mRd5fST" +
       "m94SsZr9JlcDUTec1jR/OvA9V5gWG1aFxjUyOZjidgGyTbFWCHpG+SB0OC+Z" +
       "vg1y52WCY8Kbn/a7ULuGaaHkFXc/3fOcVHl0sK188JO8ADUOkODjRdO1/Iqi" +
       "jZwwp+iyggecKQkibdauU29lVx84zwuAmvgi7gJQWn4TH1LOn1zX9+iNlafl" +
       "ZwBFo3v24CrV0ErILxJZEJtbcDV3rYq1C29OujBxvgv3DVJgL6Zm+Px6C0SH" +
       "iX7UHOqR7bZsq/z2qVUv/uRAxRtQ/GwhJZSTyVtyq5KMmYbssSWe2zIB4Ivm" +
       "vX3h13c/sGT4L78WxTORLdbMwvRDypUzW9883HQKmvzqHlIOmYxlRLn08G59" +
       "A1PGrEFSq9pdGRARVlGpFujHJqHLU4Q0cS7OcdZmZ/EjEietue1o7qc3aDTG" +
       "mdVhpHWR36Gjq/ZmAp/q3TyQNs0Qgzfja9m7JXigNcBph+K9pul262S/KcJ/" +
       "Tf5aHcefiUccLv8XIpL9Sy0bAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
