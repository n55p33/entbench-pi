package org.apache.batik.css.engine;
public class SystemColorSupport implements org.apache.batik.util.CSSConstants {
    public static org.apache.batik.css.engine.value.Value getSystemColor(java.lang.String ident) {
        ident =
          ident.
            toLowerCase(
              );
        java.awt.SystemColor sc =
          (java.awt.SystemColor)
            factories.
            get(
              ident);
        return new org.apache.batik.css.engine.value.RGBColorValue(
          new org.apache.batik.css.engine.value.FloatValue(
            org.w3c.dom.css.CSSPrimitiveValue.
              CSS_NUMBER,
            sc.
              getRed(
                )),
          new org.apache.batik.css.engine.value.FloatValue(
            org.w3c.dom.css.CSSPrimitiveValue.
              CSS_NUMBER,
            sc.
              getGreen(
                )),
          new org.apache.batik.css.engine.value.FloatValue(
            org.w3c.dom.css.CSSPrimitiveValue.
              CSS_NUMBER,
            sc.
              getBlue(
                )));
    }
    protected static final java.util.Map factories = new java.util.HashMap(
      );
    static { factories.put(CSS_ACTIVEBORDER_VALUE, java.awt.SystemColor.
                                                     windowBorder);
             factories.put(CSS_ACTIVECAPTION_VALUE, java.awt.SystemColor.
                                                      activeCaption);
             factories.put(CSS_APPWORKSPACE_VALUE, java.awt.SystemColor.
                                                     desktop);
             factories.put(CSS_BACKGROUND_VALUE, java.awt.SystemColor.
                                                   desktop);
             factories.put(CSS_BUTTONFACE_VALUE, java.awt.SystemColor.
                                                   control);
             factories.put(CSS_BUTTONHIGHLIGHT_VALUE, java.awt.SystemColor.
                                                        controlLtHighlight);
             factories.put(CSS_BUTTONSHADOW_VALUE, java.awt.SystemColor.
                                                     controlDkShadow);
             factories.put(CSS_BUTTONTEXT_VALUE, java.awt.SystemColor.
                                                   controlText);
             factories.put(CSS_CAPTIONTEXT_VALUE, java.awt.SystemColor.
                                                    activeCaptionText);
             factories.put(CSS_GRAYTEXT_VALUE, java.awt.SystemColor.
                                                 textInactiveText);
             factories.put(CSS_HIGHLIGHT_VALUE, java.awt.SystemColor.
                                                  textHighlight);
             factories.put(CSS_HIGHLIGHTTEXT_VALUE, java.awt.SystemColor.
                                                      textHighlightText);
             factories.put(CSS_INACTIVEBORDER_VALUE, java.awt.SystemColor.
                                                       windowBorder);
             factories.put(CSS_INACTIVECAPTION_VALUE, java.awt.SystemColor.
                                                        inactiveCaption);
             factories.put(CSS_INACTIVECAPTIONTEXT_VALUE, java.awt.SystemColor.
                                                            inactiveCaptionText);
             factories.put(CSS_INFOBACKGROUND_VALUE, java.awt.SystemColor.
                                                       info);
             factories.put(CSS_INFOTEXT_VALUE, java.awt.SystemColor.
                                                 infoText);
             factories.put(CSS_MENU_VALUE, java.awt.SystemColor.menu);
             factories.put(CSS_MENUTEXT_VALUE, java.awt.SystemColor.
                                                 menuText);
             factories.put(CSS_SCROLLBAR_VALUE, java.awt.SystemColor.
                                                  scrollbar);
             factories.put(CSS_THREEDDARKSHADOW_VALUE, java.awt.SystemColor.
                                                         controlDkShadow);
             factories.put(CSS_THREEDFACE_VALUE, java.awt.SystemColor.
                                                   control);
             factories.put(CSS_THREEDHIGHLIGHT_VALUE, java.awt.SystemColor.
                                                        controlHighlight);
             factories.put(CSS_THREEDLIGHTSHADOW_VALUE, java.awt.SystemColor.
                                                          controlLtHighlight);
             factories.put(CSS_THREEDSHADOW_VALUE, java.awt.SystemColor.
                                                     controlShadow);
             factories.put(CSS_WINDOW_VALUE, java.awt.SystemColor.
                                               window);
             factories.put(CSS_WINDOWFRAME_VALUE, java.awt.SystemColor.
                                                    windowBorder);
             factories.put(CSS_WINDOWTEXT_VALUE, java.awt.SystemColor.
                                                   windowText); }
    protected SystemColorSupport() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1YfWwUxxWfO+PzB/4GjGOwMY4B8ZG70IYSakJjHAOmZ3Ax" +
                                                              "sdTj45jbm/Mt3ttddmfts9OkCVIUqraUUiCkKvxFSkpJiKpGbdomchU1H0pa" +
                                                              "iYQ2TaNQ1PSPpClKUJS0Kv16M7N7+3Fn06hqT7q5udk3b+a9+b3fe7Pnr6Jy" +
                                                              "00DtRKVROqETM9qn0kFsmCTdq2DT3AljSenhMvzh3ne2rQujSALVZbE5IGGT" +
                                                              "bJKJkjYTqE1WTYpViZjbCEmzGYMGMYkxhqmsqQk0Tzb7c7oiSzId0NKECQxj" +
                                                              "I44aMaWGnLIo6bcVUNQWh53E+E5iPcHH3XFUI2n6hCve4hHv9Txhkjl3LZOi" +
                                                              "hvh+PIZjFpWVWFw2aXfeQCt1TZkYUTQaJXka3a+ssV2wNb6myAWdT9Z/fP1I" +
                                                              "toG7YA5WVY1y88wdxNSUMZKOo3p3tE8hOfMAug+VxdFsjzBFXXFn0RgsGoNF" +
                                                              "HWtdKdh9LVGtXK/GzaGOpogusQ1RtNivRMcGztlqBvmeQUMltW3nk8HajoK1" +
                                                              "wsoiE4+vjB17eG/DD8pQfQLVy+oQ244Em6CwSAIcSnIpYpg96TRJJ1CjCoc9" +
                                                              "RAwZK/KkfdJNpjyiYmrB8TtuYYOWTgy+pusrOEewzbAkqhkF8zIcUPa/8oyC" +
                                                              "R8DWZtdWYeEmNg4GVsuwMSODAXf2lFmjspqmaFFwRsHGrs+DAEytyBGa1QpL" +
                                                              "zVIxDKAmAREFqyOxIYCeOgKi5RoA0KCodVqlzNc6lkbxCEkyRAbkBsUjkKri" +
                                                              "jmBTKJoXFOOa4JRaA6fkOZ+r29YfvkfdooZRCPacJpLC9j8bJrUHJu0gGWIQ" +
                                                              "iAMxsWZF/ARufuZQGCEQnhcQFjI/+tK1O1e1T70oZBaUkNme2k8kmpTOpOou" +
                                                              "Luxdvq6MbaNS10yZHb7Pch5lg/aT7rwODNNc0MgeRp2HUzue/+L958h7YVTd" +
                                                              "jyKSplg5wFGjpOV0WSHGZqISA1OS7kdVRE338uf9qAL6cVklYnR7JmMS2o9m" +
                                                              "KXwoovH/4KIMqGAuqoa+rGY0p69jmuX9vI4QqoAvWgvfpUh8+C9FOJbVciSG" +
                                                              "JazKqhYbNDRmvxkDxkmBb7OxFKB+NGZqlgEQjGnGSAwDDrLEfiCZTHYE9hQb" +
                                                              "mjApgXBWNGPI0nXNALYBqOn/j0XyzNI546EQHMLCIAUoED1bNCVNjKR0zNrY" +
                                                              "d+2J5MsCXiwkbB9RFIV1o2LdKF83CutGxbrR4nVRKMSXm8vWF+cNpzUKcQ/E" +
                                                              "W7N8aM/WfYc6ywBo+vgscDUT7fQloF6XHBxGT0oXmmonF19e/VwYzYqjJixR" +
                                                              "Cyssn/QYI8BU0qgdzDUpSE1uhujwZAiW2gxNImkgqOkyha2lUhsjBhunaK5H" +
                                                              "g5O/WKTGps8eJfePpk6OPzD85VvDKOxPCmzJcuAzNn2QUXmBsruCZFBKb/1D" +
                                                              "73x84cS9mksLvizjJMeimcyGziAggu5JSis68FPJZ+7t4m6vAtqmGE4dDrk9" +
                                                              "uIaPdbodBme2VILBGc3IYYU9cnxcTbOGNu6OcKQ28v5cgEUdC8MO+I7Zccl/" +
                                                              "2dNmnbXzBbIZzgJW8Axxx5B+6re/evfT3N1OMqn3VAFDhHZ7CIwpa+JU1ejC" +
                                                              "dqdBCMi9dXLwW8evPrSLYxYkbi61YBdre4G44AjBzQ++eOCN318+cyns4pyi" +
                                                              "Kt3QKAQ4SecLdrJHqHYGO2HBpe6WINAU0MCA03W3ChCVMzJOKYTF1t/rl6x+" +
                                                              "6s+HGwQUFBhxkLTqxgrc8Zs2ovtf3vuXdq4mJLEc7LrNFRPEPsfV3GMYeILt" +
                                                              "I//Aq22PvIBPQYoAWjblScKZFnE3IH5ua7j9t/L2tsCztaxZYnrx7w8xT62U" +
                                                              "lI5c+qB2+INnr/Hd+ost73EPYL1bIIw1S/Ogfn6Qn7ZgMwtyt01t292gTF0H" +
                                                              "jQnQKAHzmtsNIMm8Dxy2dHnF737+XPO+i2UovAlVKxpOb8I8zlAVAJyYWeDX" +
                                                              "vP65O8XhjldC08BNRUXGFw0wBy8qfXR9OZ1yZ0/+eP4P1589fZkDTRc6FhSI" +
                                                              "daGPWHnJ7sb2udfW/vrsN0+Mi6S/fHpCC8xr+dt2JXXwD38tcjmnshIFSWB+" +
                                                              "Inb+O629G97j811OYbO78sVpCnjZnfupc7mPwp2RX4RRRQI1SHaJPIwVi0Vq" +
                                                              "AspC06mboYz2PfeXeKKe6S5w5sIgn3mWDbKZmx6hz6RZvzZAYAvYEa6ziwun" +
                                                              "yPARWAjxTj+fsoy3K1hzCz++MtaNUhQxeSFOYQuyipUAc7TOsAAQToZjUQYE" +
                                                              "G6jNxQJLZENWyqQ78DgvMZPS7mUNzV3rPuwUYGgvIeupRQ//9CeJxLIGSQh3" +
                                                              "llLsr0EfO1spvZl7/o9iwk0lJgi5eY/Fvj78+v5XOG1Xsly+03GvJ1NDzvfk" +
                                                              "jAZ/zmiE7xXbI1dELbf7vyyzYBpcsOQc3AliO+UcSbMLHrPBLuP+p/o5VfnC" +
                                                              "2D20748qPe/f/t07hFsXTxPBrvzTX7hy8dTkhfMiQzD3UrRyuitp8T2Y1QxL" +
                                                              "Zqh7XIB8tPmzU+++PbwnbHN6HWuGBXZbKKp1SQ0olA3uLZBfqEBec/0wEZrv" +
                                                              "+kr9z440lW2CgqQfVVqqfMAi/Wl/TFaYVsqDG/fm5capDZp/wScE33+yLwML" +
                                                              "GxCgaeq1byEdhWsI8Ct7DhXuCuiK+oO1t7Nmq7CuuxTV50uHOJQEEd1KKbLk" +
                                                              "RjX/RIL3EW894GV425+dRRW6SBhDQ4WXCAxGbdPdLvnN+MzBY6fT2x9dLcDU" +
                                                              "5L+x9alW7vHf/OOV6MkrL5W4IlRRTb9FIWNECSSgNh9yB/jF22Xzt+qOvv10" +
                                                              "18jGT1LUs7H2G5Tt7P8iMGLF9GANbuWFg39q3bkhu+8T1OeLAu4MqvzewPmX" +
                                                              "Ni+Vjob5WwaRZoreTvgndfuBXG0QahmqH7o3F7DS4uBjpY2VlaVr5JLgC7Pu" +
                                                              "ftYMBHJK4wwaA3VbyI/DBh7XLL9GxSsUvoH7Zij2DrImT1HdCKGeq6SjcNlM" +
                                                              "V88xltWjPLe7YTgxQxj+BxUXG+jRYUNNxRdbVo61FL1GE69+pCdO11fOP333" +
                                                              "6xzKhdczNQDKjKUo3oLB04/oBsnI3BE1onwQtPI1ihbMYDnQhujw/X9VzPkG" +
                                                              "3FVLzaGoDFqv5FE4qKAklBf81yt3nKJqVw4WFR2vyEnQDiKs+4heAgWiysqH" +
                                                              "PKxge50f1rwbHVZhivfWxWKZv/R04s4atPPbhdNbt91z7TOPilufpODJSaZl" +
                                                              "NqQEcQEtxO7iabU5uiJbll+ve7JqiZPCGsWG3Yha4IFxDwSBzvDRGrgPmV2F" +
                                                              "a9EbZ9Y/+8tDkVeBPnehEKZozq7iejSvW0Cau+LFqQ94jl/Uupd/e2LDqsz7" +
                                                              "b/KKv7jOD8onpUtn97x2tOUMXOhm96NyYHqS54XyXRPqDiKNGQlUK5t9edgi" +
                                                              "aJGx4surdQzKmMUy94vtztrCKHtnAAmo6L1niTctcDsaJ8ZGzVLTdmae7Y74" +
                                                              "3sY69AdxF5jgjngqQMwaKS/ydlkyPqDrTh6vmKPzmE4FKYsP8tnneZc1j/8b" +
                                                              "DfOcYhAZAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "eUX29iIAAA==");
}
