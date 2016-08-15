package org.apache.batik.svggen;
public class SVGClipDescriptor implements org.apache.batik.svggen.SVGDescriptor, org.apache.batik.svggen.SVGSyntax {
    private java.lang.String clipPathValue;
    private org.w3c.dom.Element clipPathDef;
    public SVGClipDescriptor(java.lang.String clipPathValue, org.w3c.dom.Element clipPathDef) {
        super(
          );
        if (clipPathValue ==
              null)
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              org.apache.batik.svggen.ErrorConstants.
                ERR_CLIP_NULL);
        this.
          clipPathValue =
          clipPathValue;
        this.
          clipPathDef =
          clipPathDef;
    }
    public java.util.Map getAttributeMap(java.util.Map attrMap) {
        if (attrMap ==
              null)
            attrMap =
              new java.util.HashMap(
                );
        attrMap.
          put(
            SVG_CLIP_PATH_ATTRIBUTE,
            clipPathValue);
        return attrMap;
    }
    public java.util.List getDefinitionSet(java.util.List defSet) {
        if (defSet ==
              null)
            defSet =
              new java.util.LinkedList(
                );
        if (clipPathDef !=
              null)
            defSet.
              add(
                clipPathDef);
        return defSet;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYa3AUxxGeO6H3W4DAPASSJSjxuDOxcUwE2CAEiJzEBWGl" +
                                                              "cjyOvb2508Le7rI7J51EnGBsl/GPEEIAk5ThT+RgCAZXKq7ESeyS44ofZSdV" +
                                                              "2CSO45hQcX7YcSibctlJhbx6ZvZ9d6KoOKraudFMT890T/fX3XPuKio1dNSC" +
                                                              "FRIioxo2Qj0KiQq6gZPdsmAYW2EsLj5aIny8873+FUFUFkN1Q4LRJwoGXi9h" +
                                                              "OWnE0FxJMYigiNjoxzhJV0R1bGB9WCCSqsTQdMnozWiyJEqkT01iSjAo6BHU" +
                                                              "KBCiS4kswb0mA4LmRuAkYXaS8Br/dFcE1YiqNuqQz3SRd7tmKGXG2csgqCGy" +
                                                              "WxgWwlkiyeGIZJCunI4Wa6o8mpZVEsI5EtotLzdVsCmyPE8FbU/Vf3r98FAD" +
                                                              "U8FUQVFUwsQztmBDlYdxMoLqndEeGWeMvehrqCSCql3EBLVHrE3DsGkYNrWk" +
                                                              "dajg9LVYyWa6VSYOsTiVaSI9EEGtXiaaoAsZk02UnRk4VBBTdrYYpJ1vS8ul" +
                                                              "zBPx2OLw0Ud3NvywBNXHUL2kDNDjiHAIApvEQKE4k8C6sSaZxMkYalTgsgew" +
                                                              "LgmyNGbedJMhpRWBZOH6LbXQwayGdbanoyu4R5BNz4pE1W3xUsygzP9KU7KQ" +
                                                              "BlmbHVm5hOvpOAhYJcHB9JQAdmcumbJHUpIEzfOvsGVs/yIQwNLyDCZDqr3V" +
                                                              "FEWAAdTETUQWlHR4AExPSQNpqQoGqBM0qyhTqmtNEPcIaRynFumji/IpoKpk" +
                                                              "iqBLCJruJ2Oc4JZm+W7JdT9X+1ce2qdsVIIoAGdOYlGm56+GRS2+RVtwCusY" +
                                                              "/IAvrFkUOS40P3swiBAQT/cRc5off/XaPUtaJl7mNLML0GxO7MYiiYvjibqL" +
                                                              "c7o7V5TQY1RoqiHRy/dIzrwsas505TRAmGabI50MWZMTW178yv6z+IMgqupF" +
                                                              "ZaIqZzNgR42imtEkGesbsIJ1geBkL6rESrKbzfeicuhHJAXz0c2plIFJL5oi" +
                                                              "s6Eylf0PKkoBC6qiKuhLSkq1+ppAhlg/pyGEyuFDa+FrR/yP/RK0PTykZnBY" +
                                                              "EAVFUtRwVFep/EYYECcBuh0KJ8Dq94QNNauDCYZVPR0WwA6GsDUxnE5jJTww" +
                                                              "uKFblrR12BB1SQNzD1Er0/7P/HNUvqkjgQCofo7f8WXwmY2qnMR6XDyaXdtz" +
                                                              "7Xz8VW5U1BFMzRDUCVuG+JYhtmWIbxnK2xIFAmynaXRrfsFwPXvA0QFpazoH" +
                                                              "dmzadbCtBCxLG5kCuqWkbZ6I0+2ggQXhcfFCU+1Y6+VlLwTRlAhqEkSSFWQa" +
                                                              "QNboaYAmcY/pvTUJiEVOSJjvCgk0lumqiJOASMVCg8mlQh3GOh0naJqLgxWw" +
                                                              "qGuGi4eLgudHEydG7h/8+m1BFPRGAbplKQAYXR6l2G1jdLvf+wvxrX/4vU8v" +
                                                              "HL9PdXDAE1asaJi3ksrQ5rcFv3ri4qL5wtPxZ+9rZ2qvBJwmAvgVQGCLfw8P" +
                                                              "zHRZkE1lqQCBU6qeEWQ6Zem4igzp6ogzwoy0kfWngVlUU7+bA99S0xHZL51t" +
                                                              "1mg7gxs1tTOfFCwkrBrQTv7u1+/fztRtRY96V9gfwKTLhViUWRPDpkbHbLfq" +
                                                              "GAPdOyei3z529eFtzGaB4tZCG7bTthuQCq4Q1PzQy3vf+uPl8UtBx84JhOxs" +
                                                              "AjKfnC0kHUdVkwgJuy1wzgOIJwMqUKtpv1cB+5RSkpCQMXWsf9Z3LHv6r4ca" +
                                                              "uB3IMGKZ0ZIbM3DGb1mL9r+6828tjE1ApBHX0ZlDxmF8qsN5ja4Lo/Qcuftf" +
                                                              "n/udl4STEBAAhA1pDDNcDTIdBJnkMyEBYytpcA3x4GpNTKUwM3K7GEqqmRBN" +
                                                              "nMD72E0vZxS3sfYOqiXGELG5Ltp0GG6P8TqlK52Ki4cvfVQ7+NFz15iI3nzM" +
                                                              "bSB9gtbFbZI2C3LAfoYf0TYKxhDQ3THRv71BnrgOHGPAUQSENjbrgKg5jzmZ" +
                                                              "1KXlv3/+heZdF0tQcD2qklUhuV5gnokqwSWwMQRgnNPuvodbxEgFNA1MVJQn" +
                                                              "fN4AvZV5he+7J6MRdkNjP5nxo5WnT11mpqlxHrPN64H44IFiltU7aHD2jc//" +
                                                              "5vS3jo/wvKCzOAT61s38x2Y5ceBPf89TOQO/AjmLb30sfO6xWd2rP2DrHRSi" +
                                                              "q9tz+TENkNxZ+7mzmU+CbWW/DKLyGGoQzSx6UJCz1LdjkDkaVmoNmbZn3psF" +
                                                              "8pSny0bZOX4EdG3rxz8nlkKfUtN+rQ/yaugVtsLXYaJBhx/yAoh1+tiShaxd" +
                                                              "RJulFsKUa7oElRb2QUz1JEwJCA3xOwppEBOaDt7JsZW2K2nTz/ndXdQoN3iF" +
                                                              "mA/fAnO/BUWEGORC0Caaf9piqwmqtk67Dqfo0F2+s355krPmnD0X23uyvzJ/" +
                                                              "yucGYbeHmDjVMUk65KRCFnXrJNQDo2DNOQovc4tl+6xSGT9w9FRy8+PLuO81" +
                                                              "eTPoHigQn/ztv14LnbjySoHkrZKo2lIZD2PZ5+1zPd7exwohx3XeqTvy7jPt" +
                                                              "6bU3k3PRsZYbZFX0/3kgxKLiAOI/yksH/jJr6+qhXTeRPs3zqdPP8kzfuVc2" +
                                                              "LBCPBFnVx306r1r0LuryenKVjqG8VbZ6/PlW27DqqR21wLfKNKxVhVOYAjZp" +
                                                              "JwbFlvqiYcBOpV03Sq9qIJswyBZhhNlSXNy+sKG5fcXHbdyIWgrQukrMQz/7" +
                                                              "aSy2sEHkxG2FGHtLyydOV4hvZ178M19wS4EFnG76E+FvDL65+zV2mRXUemwV" +
                                                              "uiwHrMyVGTbYuqmjqmiE74qpG/b7v5dQsCwTJlIGspHwVimDk2b68VmVaJPy" +
                                                              "Z+mFxxmdS/vBHnnNh3d9fxVXa2sRp3Hon/nSlYsnxy6c40BA1UvQ4mIvTfnP" +
                                                              "W7Qy6JikunEM5JMNX5h4/93BHUEzD6ujTS5noV6tk4hA2kMH9xcw2GleM+Gc" +
                                                              "1z1S//PDTSXrAXl6UUVWkfZmcW/S633lRjbhshvnQcXxRdNo/gN/Afj+TT9q" +
                                                              "LHSAG01Tt/m4MN9+XYCciM4TFFgEXcZHnyT5fIQ2Gcgd05jYj5SmvCNOWFJu" +
                                                              "FEInz+voQI/GxiXbExqsWBs1PSF68wBTbGkRgKH/G15XbILvjMnljMVllHEZ" +
                                                              "45Lso81x2y7q3Gk0r1NO+Dei/z7IlX90EuU/RptvQj0Byod8QFJYMQd5HR0/" +
                                                              "5mj/8Geh/RxBjXmvHTTjnpn3mMofAMXzp+orZpy6900WQO1HuhoAvVRWlt05" +
                                                              "oatfpukgCROvhmeIGvsZJ2hGkTwCSkveYUf/Hqc/DWrx0xNUyn7ddGcJqnLo" +
                                                              "gBXvuEmeJKgESGj3vFaghuOpcS7gyi5MNTLtT7+R9u0l7uKaIg97zLbQIRs1" +
                                                              "Ae7CqU39+67d+Tgv7kVZGBujXKoBE/g7g50DtBblZvEq29h5ve6pyg4Lwxr5" +
                                                              "gR3Hme0ytx6wTI3e+Cxf5Wu02wXwW+Mrn/vVwbLXAX23oYAAJe22/CIip2Uh" +
                                                              "VG+L5GMf5EusJO/q/O7o6iWpD99mZZqJlXOK08fFS6d3vHFk5jiU7tW9qBQy" +
                                                              "Rpxj1c26UWULFof1GKqVjJ4cHBG4SILsAdY6apwCrcSZXkx11tqj9GmIoLa8" +
                                                              "9+wCD2pQ0o5gfa2aVZImNFc7I55XdiuNymqab4Ez4koBHqDNQzkO3CXxSJ+m" +
                                                              "WUBe9QeNOemDhXGEts+zLm1+8V+cZzoT6BoAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
