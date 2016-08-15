package org.apache.batik.css.engine.value.svg;
public class OpacityManager extends org.apache.batik.css.engine.value.AbstractValueManager {
    protected boolean inherited;
    protected java.lang.String property;
    public OpacityManager(java.lang.String prop, boolean inherit) { super(
                                                                      );
                                                                    property =
                                                                      prop;
                                                                    inherited =
                                                                      inherit;
    }
    public boolean isInheritedProperty() { return inherited; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return true; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_NUMBER_OR_INHERIT; }
    public java.lang.String getPropertyName() { return property; }
    public org.apache.batik.css.engine.value.Value getDefaultValue() { return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                                                                                NUMBER_1;
    }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        switch (lu.
                  getLexicalUnitType(
                    )) {
            case org.w3c.css.sac.LexicalUnit.
                   SAC_INHERIT:
                return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                         INHERIT_VALUE;
            case org.w3c.css.sac.LexicalUnit.
                   SAC_INTEGER:
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_NUMBER,
                  lu.
                    getIntegerValue(
                      ));
            case org.w3c.css.sac.LexicalUnit.
                   SAC_REAL:
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_NUMBER,
                  lu.
                    getFloatValue(
                      ));
        }
        throw createInvalidLexicalUnitDOMException(
                lu.
                  getLexicalUnitType(
                    ));
    }
    public org.apache.batik.css.engine.value.Value createFloatValue(short type,
                                                                    float floatValue)
          throws org.w3c.dom.DOMException {
        if (type ==
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_NUMBER) {
            return new org.apache.batik.css.engine.value.FloatValue(
              type,
              floatValue);
        }
        throw createInvalidFloatTypeDOMException(
                type);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL0Za2wcxXl8fsZvO0/ycF5OoiRwlwBJCyYUx7ETJ+eH4hAJ" +
       "B3Dm9ubOm+ztLrtz9jkhFBCI0KoI0hDSCtIfDQqNgNCqiFYtKC0tDwGVeLRA" +
       "Kx5qkUpLUYmqAmpa6PfN7N4+zneWpaYn7dzezPd9872/+eYe/ZhU2hZpYzqP" +
       "8gmT2dFunQ9Sy2bJLo3a9i6YG1EeKKf/uPHD/isipGqYNI5Su0+hNutRmZa0" +
       "h8kiVbc51RVm9zOWRIxBi9nMGqNcNfRhMlu1ezOmpioq7zOSDAF2UytOWijn" +
       "lprIctbrEOBkURw4iQlOYp3h5Y44qVcMc8IDn+cD7/KtIGTG28vmpDm+j47R" +
       "WJarWiyu2rwjZ5G1pqFNpDWDR1mOR/dpGxwVbI9vKFDBsieaPj1/72izUMFM" +
       "qusGF+LZO5ltaGMsGSdN3my3xjL2TeQWUh4ndT5gTtrj7qYx2DQGm7rSelDA" +
       "fQPTs5kuQ4jDXUpVpoIMcbI0SMSkFs04ZAYFz0ChhjuyC2SQdkleWillgYj3" +
       "r40dfeDG5h+Vk6Zh0qTqQ8iOAkxw2GQYFMoyCWbZnckkSw6TFh2MPcQslWrq" +
       "AcfSrbaa1inPgvldteBk1mSW2NPTFdgRZLOyCjesvHgp4VDOr8qURtMg6xxP" +
       "VilhD86DgLUqMGalKPidg1KxX9WTnCwOY+RlbN8BAIBanWF81MhvVaFTmCCt" +
       "0kU0qqdjQ+B6ehpAKw1wQIuT+UWJoq5NquynaTaCHhmCG5RLADVDKAJROJkd" +
       "BhOUwErzQ1by2efj/qvuOahv0yOkDHhOMkVD/usAqS2EtJOlmMUgDiRi/Zr4" +
       "MTrn6cMRQgB4dghYwjx187lrLm47+4KEWTAJzEBiH1P4iHIy0fjqwq7VV5Qj" +
       "GzWmYato/IDkIsoGnZWOnAkZZk6eIi5G3cWzO5+77tbT7KMIqe0lVYqhZTPg" +
       "Ry2KkTFVjVlbmc4sylmyl8xgerJLrPeSaniPqzqTswOplM14L6nQxFSVIX6D" +
       "ilJAAlVUC++qnjLcd5PyUfGeMwkh1fCQenhWEvkR35ykY6NGhsWoQnVVN2KD" +
       "loHy2zHIOAnQ7WgsAV6/P2YbWQtcMGZY6RgFPxhlzoJiI2waeIqNUS3LYvZY" +
       "OjYAECqf6KM6+IQVRYcz/39b5VDqmeNlZWCQheF0oEEkbTO0JLNGlKPZzd3n" +
       "Hh95SboahoejL04uh92jcveo2D0Ku0fl7lGxexR2jwZ3J2VlYtNZyIX0ALDf" +
       "fsgEkIrrVw/dsH3v4WXl4HrmeAUoH0GXBUpSl5cu3Bw/opxpbTiw9N31z0ZI" +
       "RZy0UoVnqYYVptNKQ+5S9jvhXZ+AYuXVjCW+moHFzjIUloSUVax2OFRqjDFm" +
       "4Twns3wU3IqGsRsrXk8m5Z+cPT5+2+6vr4uQSLBM4JaVkOEQfRCTez6Jt4fT" +
       "w2R0m+768NMzxw4ZXqII1B23XBZgogzLwm4RVs+IsmYJfXLk6UPtQu0zIJFz" +
       "CraHHNkW3iOQhzrcnI6y1IDAKcPKUA2XXB3X8lHLGPdmhL+2iPdZ4BZ1GJgX" +
       "wbPBiVTxjatzTBznSv9GPwtJIWrGpiHzobd+85fLhLrd8tLkOxcMMd7hS2lI" +
       "rFUkrxbPbXdZjAHcO8cHv33/x3ftET4LEMsn27Adxy5IZWBCUPOdL9z09nvv" +
       "nnwj4vk5h5qeTcDRKJcXEudJbQkhYbeVHj+QEjXIFeg17dfq4J9qSqUJjWFg" +
       "/btpxfon/3ZPs/QDDWZcN7p4agLe/EWbya0v3fhZmyBTpmBJ9nTmgck8P9Oj" +
       "3GlZdAL5yN322qLvPE8fgooBWdpWDzCReCNCBxEh+Tw4oQlMrL5RWX2DSQAD" +
       "bSibsCFg1QzYZ8wpbpcO7lUOtw9+IAvXRZMgSLjZj8S+tfvNfS8L69dgSsB5" +
       "3LvBF/CQOnyu1yyt8iV8yuD5Ah+0Bk7IItHa5VSqJflSZZo54Hx1ibNlUIDY" +
       "odb39j/44WNSgHApDwGzw0e/8WX0nqPSpPK8s7zgyOHHkWceKQ4OHcjd0lK7" +
       "CIyeP5859LNHDt0luWoNVu9uOJw+9rv/vBw9/v6Lk5SI6oRhaIzKPHY5+nk+" +
       "q88K2kcKteXupp/f21reAwmll9RkdfWmLOtN+qnCkc3OJnwG885SYsIvHhqH" +
       "k7I1YAcxvUGwsS7PDBHMELG2HYcVtj+vBs3lO5WPKPe+8UnD7k+eOSdEDh7r" +
       "/Wmkj5pS3y04rER9zw3XvW3UHgW4y8/2X9+snT0PFIeBogLV3R6woATnAknH" +
       "ga6s/v0vnp2z99VyEukhtZpBkz1U5G8yAxIns0eheufMr10j88Z4DQzNQlRS" +
       "IHzBBMbu4smzQnfG5CKOD/xk7o+vOnXiXZHATEljgRPEcKAIFGzRHHo14/Tr" +
       "X/ntqfuOjUt3KhEcIbx5/xrQErf/8fMClYsSOUm8hPCHY48+OL/r6o8Evler" +
       "ELs9V3gIgnrv4V56OvPPyLKqX0dI9TBpVpxmbDcecaACDEMDYrsdGjRsgfVg" +
       "MyFPzh35WrwwHLC+bcNV0h8DFTzg715hbEQTLoFnrVMz1oYLYxkRL9cLlFVi" +
       "XIPDJW4dmmFaBgcuWTJUihpKkAU0VR+FHhDQcOJKWX9x3IHDDZJWf1GX3B0U" +
       "oQ2edc5e64qIII8Gq3AYKeS0GDaHsm4Zog/F3xtDjKZKMJrzNlyb31B8qkio" +
       "afBXaS84CGaARcX6OpFtT95+9ERy4OH1EScvbQbNcsO8RGNjTPORqkFKgTjr" +
       "E52s57TvNB7500/b05uncybGubYpTr34ezFEzJrioRtm5fnb/zp/19Wje6dx" +
       "vF0c0lKY5A/6Hn1x60rlSES07TKaCtr9IFJHMIZqLcazlh6sHMvzdp3p2nKT" +
       "Y9dNYTf0PCfkEvmDWzHUEnXo5hJrt+AwzslM1e51g23Q58tXem6cmyreSpcA" +
       "nNhlink7qJFV8GxxxNoyfY0UQy0h9d0l1r6Jwx3Qh6l2p65mKMfzahGV3Hmh" +
       "VLICnh2OXDumr5JiqCXEPlZi7TgO90HZUfF+ThzliijkyAVQSBOuYfLe6Ui1" +
       "c/oKKYZaQujvl1h7GIcTcDBLM+5qIt9YfhWHDindJt97JyflqnPf6ju34s+t" +
       "OU+F37sAKmzFtaXwXOfo4brpq7AYagk1PVli7SkcngiqsN/JpBs9bfzwAmij" +
       "BdeWwLPXEWnv9LVRDLWExL8ssfYrHJ6W2tjCUjSryaOe276umvpezIMXinvm" +
       "QiluITxpR/r09BVXDDWknFD7vgDlH79MEWLbVInGWU5VqHatrnIXZkUpHXUN" +
       "DXWLN8Hiq6Hd3BbSoTTP3S1pZKJbBvq6cwoz8XAhkN/E4WVO6hSLQUsu9I5T" +
       "z3nKf+VCKR9j+KCjwYPTV34x1BLKL5HNKqEntErls1K4Kegwi+AKQT6Y3ET4" +
       "8y0B8AkO73HonYQZepDeZLZ4/39hixwnjcFLZ2xp5xX86SX/qFEeP9FUM/fE" +
       "tW+Kc3L+z5R6OPGmsprmb7p871WmxVKqkK1etmCm+Pp8CtfOX4tDfYFRiPCZ" +
       "RD3PydIpUcEYY/nc4SB+4YRcEUROquSLD6cM+rxZk+EAWzD6ISvAamFI4EJ8" +
       "++GqOan14GBT+eIHqQXqAIKvdaYbvxunVldnwuYWNDDCYxyT5sqCfVXehWZP" +
       "5UK+Vmx5oIURf5667UZW/n06opw5sb3/4LmND8u7YkWjBw4glbo4qZbX1vmW" +
       "ZWlRai6tqm2rzzc+MWOF29y1SIa9XLDAV2Z2QQSZ6LnzQxepdnv+PvXtk1c9" +
       "88rhqtcipGwPKaPQGuwpvG3ImVnoFffECy/coL0TN7wdq787cfXFqb//Qdzn" +
       "EHlBt7A4/IjyxqkbXj8y72RbhNT1kkroW1lOXINsmdB3MmXMGiYNqt2dAxaB" +
       "ikq1wG1eIwYZxYtdoRdHnQ35WfyngZNlhZeZhf/P1GrGOLM2G1ldXDs0QHvp" +
       "zbita6Dry5pmCMGbcUyJY49MgWgN8NqReJ9pune9FetNkWm2Tp4R0b3bxCu+" +
       "Lf4v8SijzlghAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "dZn8J1//Y1//A8//YXmC+m/YmCmOBiwAAA==");
}
